package net.osdilites.tekora.recipes;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.StacksResourceHandler;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.resource.DataComponentHolderResource;
import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.fluids.ChemicalLiquidBlock;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.ChemDataIngredient;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.ingredient.MaterialIngredient;
import net.osdilites.tekora.recipes.ingredient.SoluteIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.injection.Desc;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

public final class ReactionRecipe implements TekoraGeneralRecipe<ReactionRecipeInput> {
    private final List<Chemical> reactants;
    private final List<Chemical> products;
    private final Catalyst catalyst;
    private final FluidIngredient solvent;
    private final double deltaEnthalpy;
    private final double deltaEntropy;
    private final double freqFactor;
    private final double activationEnergy;

    // stores a list of reaction coefficients so that recipe JSON data can easily get accessed.
    // do NOT modify values in this list;
    private final Map<SoluteKey, Integer> reactCoeffs;
    private final Map<SoluteKey, Integer> prodCoeffs;
    private final Map<SoluteKey, Integer> reactOrders;
    private final Map<SoluteKey, Integer> prodOrders;

    // NOTE: DO NOT STORE RECIPE EVALUATION DATA IN THIS CLASS.
    //       THIS CLASS EXCLUSIVELY STORES JSON DATA.
    public ReactionRecipe(List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, FluidIngredient solvent, double deltaEnthalpy, double deltaEntropy, double freqFactor, double activationEnergy) {
        this.reactants = reactants;
        this.products = products;
        this.catalyst = catalyst;
        this.solvent = solvent;
        this.deltaEnthalpy = deltaEnthalpy;
        this.deltaEntropy = deltaEntropy;
        this.freqFactor = freqFactor;
        this.activationEnergy = activationEnergy;

        this.reactCoeffs = new HashMap<>();
        this.reactOrders = new HashMap<>();
        this.prodOrders = new HashMap<>();

        for (Chemical chemical : reactants) {
            if (chemical.chemical().isSolute()) {
                SoluteKey key = chemical.chemical().asSoluteIngredient().value();
                this.reactCoeffs.put(key, chemical.coefficient());
                this.reactOrders.put(key, chemical.order());
            }
        }

        this.prodCoeffs = new HashMap<>();
        for (Chemical chemical : products) {
            if (chemical.chemical().isSolute()) {
                SoluteKey key = chemical.chemical().asSoluteIngredient().value();
                this.prodCoeffs.put(key, chemical.coefficient());
                this.prodOrders.put(key, chemical.order());
            }
        }
    }

    public static final MapCodec<ReactionRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Chemical.CODEC.listOf().fieldOf("reactants").forGetter(r -> r.reactants),
            Chemical.CODEC.listOf().fieldOf("products").forGetter(r -> r.products),
            Catalyst.CODEC.fieldOf("catalyst").forGetter(r -> r.catalyst),
            FluidIngredient.CODEC.fieldOf("solvent").forGetter(r -> r.solvent),
            Codec.DOUBLE.fieldOf("d_enthalpy").forGetter(r -> r.deltaEnthalpy), // J/mol
            Codec.DOUBLE.fieldOf("d_entropy").forGetter(r -> r.deltaEntropy), // J/mol K
            Codec.DOUBLE.fieldOf("freq_factor").forGetter(r -> r.freqFactor),
            Codec.DOUBLE.fieldOf("activation_energy").forGetter(r -> r.activationEnergy) // J
    ).apply(inst, ReactionRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ReactionRecipe> STREAM_CODEC = StreamCodec.composite(
            Chemical.STREAM_CODEC.apply(ByteBufCodecs.list()), r -> r.reactants,
            Chemical.STREAM_CODEC.apply(ByteBufCodecs.list()), r -> r.products,
            Catalyst.STREAM_CODEC, r -> r.catalyst,
            FluidIngredient.STREAM_CODEC, r -> r.solvent,
            ByteBufCodecs.DOUBLE, r -> r.deltaEnthalpy,
            ByteBufCodecs.DOUBLE, r -> r.deltaEntropy,
            ByteBufCodecs.DOUBLE, r -> r.freqFactor,
            ByteBufCodecs.DOUBLE, r -> r.activationEnergy,
            ReactionRecipe::new
    );

    @Override
    public boolean matches(@NonNull ReactionRecipeInput input, Level level) {
        if (!level.isClientSide()) {
            boolean hasAllOutput = true;
            boolean hasAllInput = true;
            double q = 1;

            Set<ChemicalIngredient> ingredients = input.inputs().keySet();

            // Two sets A and B are equal if:
            // 1. They are the same length
            // 2. A is a subset of B, and vice versa
            // Note that ingredients can contain both reactants and products,
            // and input doesn't necessarily need to be equal to union of reactants and products.
            
            // answers: is reactants a subset of ingredients?
            for (Chemical chemical : reactants) {
                double c = chemical.coefficient();
                ChemicalIngredient recipeIng = chemical.chemical();
                if (ingredients.contains(recipeIng)) {
                    q *= Math.pow(input.inputs().get(recipeIng), c);
                } else {
                    // System.out.printf("%s not found\n", recipeIng);
                    hasAllInput = false;
                    q = 0;
                    break;
                };
            }

            // similar deal for products
            for (Chemical chemical : products) {
                double c = chemical.coefficient();
                ChemicalIngredient ing = chemical.chemical();

                if (ingredients.contains(ing)) {
                    q /= Math.pow(input.inputs().get(ing), c);
                } else {
                    hasAllOutput = false;
                    if (q == 0) return false;
                    else {
                        q = Double.POSITIVE_INFINITY;
                    }
                    break;
                };
            }

            return hasAllOutput || hasAllInput;
        }
        return false;
    }

    @Override
    public ItemStack assemble(ReactionRecipeInput reactionRecipeInput) {
        return null; // DO NOT USE
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Reaction";
    }

    @Override
    public RecipeSerializer<? extends Recipe<ReactionRecipeInput>> getSerializer() {
        return TekoraRecipes.REACTION_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ReactionRecipeInput>> getType() {
        return TekoraRecipes.REACTION_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    // METHODS FOR BLOCK ENTITIES
    // algorithm used to implement the natural log of the reaction quotient, used to compare against the equilibrium constant
    public double getLnQ(HashMap<SoluteKey, Double> ingredients, double tankVol) {
        double q = 1.0;

        for (var entry : ingredients.entrySet()) {
            SoluteKey key = entry.getKey();
            double concentration = entry.getValue() / tankVol;

            int reactCoeff = this.reactCoeffs.getOrDefault(key, 0);
            int prodCoeff = this.prodCoeffs.getOrDefault(key, 0);

            if (reactCoeff != 0 && prodCoeff != 0) {
                continue;
            }
            if (reactCoeff != 0) {
                q /= Math.pow(concentration, reactCoeff);
            } else if (prodCoeff != 0) {
                q *= Math.pow(concentration, prodCoeff);
            }
        }
        return Math.log(q);
    }

    public double getLnK(double temperature) {
        return (deltaEnthalpy - temperature * deltaEntropy) / (temperature * UtilFunctions.IDEAL_GAS_CONST);
    }

    // function returns Ae^(-E/RT) * delta_t or in other words, the rate constant multiplied by the time period
    public float getRateTicks(HashMap<SoluteKey, Double> ingredients, double temperature, float torque) {
        // todo, involving the torque parameter, the hgiher the torque, the higher the returned rate value.
        float rateTicks = 1;
        boolean noReactants = false;
        for (var entry : ingredients.entrySet()) {
            if (reactOrders.containsKey(entry.getKey())) {
                if (entry.getValue() == 0) {
                    noReactants = true;
                    break;
                }
                rateTicks = rateTicks * (float)Math.pow(entry.getValue(), reactOrders.get(entry.getKey()));
            }
        }
        if (noReactants) {
            rateTicks = 1;
            for (var entry : ingredients.entrySet()) {
                if (prodOrders.containsKey(entry.getKey())) {
                    if (entry.getValue() == 0) {
                        return 0;
                    }
                    rateTicks = rateTicks * (float)Math.pow(entry.getValue(), reactOrders.get(entry.getKey()));
                }
            }
        }

        return rateTicks * (float)freqFactor * (float)Math.exp(-activationEnergy / (temperature * UtilFunctions.IDEAL_GAS_CONST)) / 20;
    }

    
    // -------

    // the output from comparing lnQ with lnK.
    public static class ReactionDirection {
        public static final int REVERSE = 1, EQUAL = 0, FORWARD = -1;
    }

    // if for any reason the reaction should not continue, there is stalled.
    public enum CrafterStatus {
        IDLE, 
        ACTIVE,
        STALLED,
    }

    // what is an overflow resolution strategy?

    // assume that there will only be two distinct inventories to deal with,
    // so the enum should be enough to determine where to look/insert into
    public enum ResourceHandlerType { ITEM, FLUID }
    public record SlotReference(ResourceHandlerType type, int slotIndex, double storedAmount) { }

    public static class IngredientValue {
        public float progress = 0.f;

        // info from the Chemical object

        public final ChemicalIngredient ingredient;
        private final int stoichCoefficient;
        public final int rateExponent;
        public double concentration;

        // aggregations
        
        /// from all matching slots
        public double total;
        /// slots that match this resource.
        public ArrayList<SlotReference> references;

        // TODO wtf is the item slots functions and fields

        public IngredientValue(
            ChemicalIngredient chemIng, 
            int coeff, int rateOrder, 
            double total, double concentration, 
            ArrayList<SlotReference> slotReferences
        ) {
            this.stoichCoefficient = coeff;
            this.ingredient = chemIng;
            this.rateExponent = rateOrder;
            this.concentration = concentration;
            this.total = total;
            this.references = slotReferences;
        }

        public boolean isSolute() {
            return ingredient.isSolute();
        }

        public boolean isMaterial() {
            return ingredient.isMaterial();
        }
        
        public float coefficient() {
            return stoichCoefficient;
        }

        public boolean affectsQ() {
            return ingredient.affectsQ();
        }

        // TODO
    }

    public static class ReactionState {
        // TODO okay, let's not worry about raw arrays and cache locality for now
        // TODO worry about getting the new system that takes into account other requirements,
        // TODO and can create a new abstraction for storing chemical ingredients later. 
        public HashMap<ChemicalIngredient, IngredientValue> entries;
        /// which side of equation this is for
        public boolean isReactants;
        /// whether recipe ingredients on this side are present
        public boolean hasAll = false;

        public double solventVolume = 0.0;

        public ReactionState(boolean isReactants) {
            this.entries = new HashMap<>();
            this.isReactants = isReactants;
        }

        public void put(ChemicalIngredient chemIng, IngredientValue ingVal) {
            entries.put(chemIng, ingVal);
        }

        public void put(Chemical chem) {
            IngredientValue entry = new IngredientValue(
                chem.chemical(), chem.coefficient(), chem.order(), 
                0, 0, new ArrayList<>()
            );
            entries.put(chem.chemical(), entry);
        }

        public @Nullable IngredientValue get(ChemicalIngredient key) {
            return entries.get(key);
        }

        public float getCoefficient(ChemicalIngredient key) {
            IngredientValue value = this.get(key);
            return value == null ? 0.f : value.coefficient();
        }

        // TODO?
    }


    // ------

    // okay fine, I will setup more external structures for 
    // the block to use

    public class ReactionTracker {
        // keep going, don't clear, yea?
        int activeRecipeId;

        HashMap<Integer, ChemicalIngredient> itemSlotLookup;
        HashMap<Integer, ChemicalIngredient> fluidSlotLookup;
        HashMap<ChemicalIngredient, Float> ingredientProgress;

        CrafterStatus status;
        // mark when external change
        boolean isDirty;

        // TODO handling pipes? or extraction mid processing?
    }

    // kinda mimick neoforge's transaction model for inserting and extracting items
    public class InventorySnapshot {
        HashMap<Integer, ChemicalIngredient> itemSlots;
        HashMap<Integer, ChemicalIngredient> fluidSlots;
        HashMap<ChemicalIngredient, Float> ingredientProgress;
        // TODO
        // solventSlots?
        // emptyItemSlots????
        // emptyFluidSlots?????
    }

    // -----

    public void fillWithReactants(ReactionState state, ReactionTracker tracker, ItemStacksResourceHandler inventory, FluidStacksResourceHandler tank) {
        fillReactionState(reactants, state, tracker, inventory, tank);
    }

    public void fillWithProducts(ReactionState state, ReactionTracker tracker, ItemStacksResourceHandler inventory, FluidStacksResourceHandler tank) {
        fillReactionState(products, state, tracker, inventory, tank);
    }

    // TODO
    // okay. todo. i will not think for data loading.
    // i will blindly write down the entire pseudo code implementation,
    // so that I can go back and refactor later.
    // i need to get *some* progress done.
    // TODO 

    private <R extends StacksResourceHandler<S, T>, S, T extends DataComponentHolderResource<W>, W>
    void fillReactionState(
        List<Chemical> recipeChemicals, 
        ReactionState state, 
        ReactionTracker tracker,
        ItemStacksResourceHandler inventory, 
        FluidStacksResourceHandler tank // really..? all for solvent and concentration?
    ) {
        // TODO check invariants, like chemical length (or note them)?

        recipeChemicals.forEach(chem -> state.put(chem));

        state.solventVolume = getSolventVolume(tank, tracker);

        for (int slot = 0; slot < inventory.size(); ++slot) {
            ItemResource itemResource = inventory.getResource(slot);
            if (itemResource.isEmpty()) continue;

            for (IngredientValue value : state.entries.values()) {
                boolean validMaterial = value.ingredient.isMaterial() 
                    && value.ingredient.test(itemResource.toStack());
                if (validMaterial) {
                    // TODO... add slot contribution
                    continue;
                }
                
                // time to make important assumption:
                // a material ingredient cannot hold solutes

                boolean validSolutes = itemResource.has(TekoraComponents.SOLUTES_LIST);
                if (!validSolutes) continue;
                
                Solutes soluteMap = itemResource.get(TekoraComponents.SOLUTES_LIST);
                for (var solute : soluteMap.dataMap().entrySet()) {
                    // TODO omg how do I get the state of solute LOL
                    // we'll assume a state only to get this working for now
                    ChemicalIngredient chemIng = ChemicalIngredient.of(solute.getKey(), SoluteIngredient.SOLID);
                    
                    // ofc, assuming chemIngredients can be safely used for hashing
                    if (state.entries.containsKey(chemIng)) {
                        // TODO ??? what is addSlotContribution?
                        // oh it has to do with slotReferences in an ingredient.
                    }
                }
            }
        }

        for (int slot = 0; slot < tank.size(); ++slot) {
            FluidResource fluidResource = tank.getResource(slot);
            
            // similar logic, except assume different states
            for (IngredientValue value : state.entries.values()) {
                // note, please don't try to extract logic onto generic funtcion,
                // there is no time
                boolean validMaterial = value.ingredient.isMaterial() 
                    && value.ingredient.test(fluidResource.toStack(1));
                if (validMaterial) {
                    // TODO... add slot contribution
                    continue;
                }

                boolean validSolutes = fluidResource.has(TekoraComponents.SOLUTES_LIST);
                if (!validSolutes) continue;
                
                Solutes soluteMap = fluidResource.get(TekoraComponents.SOLUTES_LIST);
                for (var solute : soluteMap.dataMap().entrySet()) {
                    // ...
                    ChemicalIngredient chemIng = ChemicalIngredient.of(solute.getKey(), SoluteIngredient.SOLVATED);
                    
                    // ...
                    if (state.entries.containsKey(chemIng)) {
                        // TODO ??? what is addSlotContribution?
                        // oh it has to do with slotReferences in an ingredient.
                    }
                }
            }
        }

        state.hasAll = true;
        for (IngredientValue value : state.entries.values()) {
            if (value.total <= 0.0) state.hasAll = false;
            value.concentration = getConcentration(value, state.solventVolume);
        }

        // TODO, multiple solvents?
    }

    private static double getSolventVolume(FluidStacksResourceHandler tank, ReactionTracker tracker) {
        // TODO
        return 0.0;
    }

    private static double getConcentration(IngredientValue ingredientDat, double solventVolume) {
        // TODO
        return 0.0;
    }

    // -----

    /*
    lnQ, lnK, and getRateTicks need to be revisited.
     */

    // ----

    // ----


    // restricting where to output slots for a resourecHandler
    public record OutputBound(int minIndex, int maxIndex) {
        // TODO
    }

    // they called this type of pattern a context!
    public static class ReactionContext {
        public ReactionState reactantState;
        public ReactionState productState;
        
        // and if there were more even more handlers to consider?
        public ItemStacksResourceHandler inventory;
        public FluidStacksResourceHandler tank;
        public @Nullable OutputBound itemBounds;
        public @Nullable OutputBound fluidBounds;
    }

    public void modifyCrafterInventory(ReactionContext dat, double rate, int action) {
        if (action != ReactionDirection.FORWARD && action != ReactionDirection.REVERSE) {
            return;
        }
        
        /*
        // Because the state should persist between ticks, capture a snapshot to simulate first
        snapshot = captureSnapshot(handlers)


        */
        // TODO

    }
}
