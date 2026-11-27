package net.osdilites.tekora.recipes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.jspecify.annotations.NonNull;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.transfer.StacksResourceHandler;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.resource.DataComponentHolderResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.ingredient.MaterialIngredient;
import net.osdilites.tekora.recipes.ingredient.SoluteIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;

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

    // TODO lnQ, lnK, and getRateTicks need to be revisited.

    /* Pipeline
     * recipeInputs + states -> fillStates* -> lnQ vs lnK -> modifyInventories (transaction)
     * 
     * *fillStates be called once when there is an active reaction recipe
     * **lnQ, lnK, and rateTicks still need to be rewritten. hardcode values for now
     *
     * if there were more handlers to consider, like an entity with multiple
     * output fluidTanks and/or output inventories,
     * then code would need to be rewritten in essentially every method
     *
     * more description here
     * this code is very very brittle and incomprehensible, but it "kind of" works with simple recipes
     * simulateReactionStep's logic per type of ingredient and handler could be 
     * put into private generic helpers if there was more time, and 
     * redundant checks and logic could be cut down once the important invariants are
     * identified and documented
     *
     * behaviors I wish are true:
     *
     * reactionState should be renamed. 
     * it should hold values that are constant for a running
     * reaction, and only change/cleared if recipe changes
     * 
     * reactionTracker is the one that needs to be updated per state.
     * it should be the one to track totals of an ingredient across slots, and 
     * be cleared completely on recipe change.
     */

    // ---

    // the output from comparing lnQ with lnK.
    public static class ReactionDirection {
        public static final int REVERSE = 1, EQUAL = 0, FORWARD = -1;
    }

    // if for any reason the reaction should not continue, there is stalled.
    public enum ReactionStatus {
        IDLE, 
        ACTIVE,
        STALLED, // unused, maybe use this later
    }

    // what is an overflow resolution strategy?

    // assume that there will only be two distinct inventories to deal with,
    // so the enum should be enough to determine where to look/insert into

    public static class IngredientValue {
        // info from the Chemical object

        public final ChemicalIngredient ingredient;
        private final int stoichCoefficient;
        public final int rateExponent;

        // aggregations

        public double concentration;
        public double total;

        public IngredientValue(
            ChemicalIngredient chemIng, 
            int coeff, int rateOrder, 
            double total, double concentration
        ) {
            this.stoichCoefficient = coeff;
            this.ingredient = chemIng;
            this.rateExponent = rateOrder;
            this.concentration = concentration;
            this.total = total;
        }

        // convenience functions

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
    }

    // initialize only once for each side of the chemical reaction.
    public static class ReactionState {
        // okay, let's not worry about raw arrays and cache locality for now
        // worry about getting the new system that takes into account other requirements,
        // and can create a new abstraction for storing chemical ingredients later. 

        private HashMap<ChemicalIngredient, IngredientValue> entries;
        /// which side of equation this is for
        public final boolean isReactants;
        /// whether recipe ingredients on this side are present
        public boolean hasAll = false;

        public ReactionState(boolean isReactants) {
            this.entries = new HashMap<>();
            this.isReactants = isReactants;
        }

        public void put(ChemicalIngredient chemIng, IngredientValue ingVal) {
            entries.put(chemIng, ingVal);
        }

        public void put(Chemical chem) {
            IngredientValue entry = new IngredientValue(
                chem.chemical(), chem.coefficient(), chem.order(), 0, 0);
            entries.put(chem.chemical(), entry);
        }

        public @Nullable IngredientValue get(ChemicalIngredient key) {
            return entries.get(key);
        }

        // clearing entries should only be the 
        // case when the entity's recipes change 
        public void clear() {
            hasAll = false;
            entries.clear();
        }
    }

    // ------

    /// structure supporting (hopefully) fast lookups and stores status of entity after each craft 
    // instantiate this only once for the lifetime of the block entity supporting reaction recipes
    public static class ReactionTracker {
        // keep going, don't clear, yea?
        int activeRecipeHash;

        // slots associated with chemical ingredient
        // a distinct ingredient can be present in multiple slots
        Map<ChemicalIngredient, Set<Integer>> itemSlotLookup;
        Map<ChemicalIngredient, Set<Integer>> fluidSlotLookup;
        Map<ChemicalIngredient, Double> ingredientProgress;

        public ReactionStatus status;
        // mark when external change
        public boolean isDirty;

        public double solventVolume = 0.0;

        public ReactionTracker() {
            this.itemSlotLookup = new HashMap<>();
            this.fluidSlotLookup = new HashMap<>();
            this.ingredientProgress = new HashMap<>();
            this.status = ReactionStatus.IDLE;
            this.isDirty = false;
        }

        public void clear() {
            this.activeRecipeHash = 0;
            this.solventVolume = 0.0;
            this.itemSlotLookup.clear();
            this.fluidSlotLookup.clear();
            // preserve ingredientProgress, since
            // an ingredient can be shared between recipes
        }

        public void printIngProg() {
            StringBuilder builder = new StringBuilder();
            final String format = "%s : %s\n";
            for (var e : this.ingredientProgress.entrySet()) {
                builder.append(String.format(format, e.getKey(), e.getValue()));
            }
            System.out.println(builder.toString());
        }

        public void putSlotSet(ChemicalIngredient chemIng, boolean isItem) {
            // if (isItem) {
                itemSlotLookup.putIfAbsent(chemIng, new HashSet<>());
            // } else {
                fluidSlotLookup.putIfAbsent(chemIng, new HashSet<>());
            // }
            ingredientProgress.putIfAbsent(chemIng, 0.0);
        }

        private @Nullable Set<Integer> getItemSlots(ChemicalIngredient chemIng) {
            return itemSlotLookup.get(chemIng);
        }

        private @Nullable Set<Integer> getFluidSlots(ChemicalIngredient chemIng) {
            return fluidSlotLookup.get(chemIng);
        }

        public @Nullable Set<Integer> getSlotSet(ChemicalIngredient chemIng, boolean isItem) {
            return isItem ? getItemSlots(chemIng) : getFluidSlots(chemIng);
        }

        public boolean putChemIngInSlot(int slot, boolean isItem, ChemicalIngredient chemIng) {
            var set = getSlotSet(chemIng, isItem);
            if (set != null) {
                set.add(slot);
                return true;
            }
            return false;
        }

        public Integer getFirst(ChemicalIngredient chemIng, boolean isItem) {
            var set = getSlotSet(chemIng, isItem);
            if (set != null && !set.isEmpty()) {
                for (Integer val : set) return val;
            }
            return -1; // stinky
        }

        // TODO: tracker update function for whenever inventory changes
        // it should be updated on a per tick basis,
        // item and fluid slot lookups...

        // TODO handling pipes? or extraction mid processing?
    }

    /// Used to restrict which indices to check and output to 
    /// for entities that share output and input in the same handler.
    // TODO use this
    public record OutputBound(int minIndex, int maxIndex) { 
        /// Bounds are inclusive.
        public OutputBound(int minIndex, int maxIndex) {
            if (minIndex > maxIndex) 
                throw new IllegalArgumentException("min > max");

            this.minIndex = minIndex < 0 ? 0 : minIndex;
            this.maxIndex = maxIndex;
        }
        public boolean inBounds(int index) {
            return (minIndex <= index) && (index <= maxIndex);
        }
    }

    // they called this type of pattern a context!
    // TODO: some more functions could replace parameters with this
    public static class ReactionContext {
        public ReactionState reactantState;
        public ReactionState productState;
        public ReactionTracker tracker;
        
        public ItemStacksResourceHandler inventory;
        public FluidStacksResourceHandler tank;

        // TODO these have to be used by simulateReactionStep()!
        public @Nullable OutputBound itemBounds;
        public @Nullable OutputBound fluidBounds;
    }

    // -----

    public void fillWithReactants(ReactionState state, ReactionTracker tracker, double solventVolume, ItemStacksResourceHandler inventory, FluidStacksResourceHandler tank) {
        fillReactionState(reactants, solventVolume, inventory, tank, state, tracker);
    }

    public void fillWithProducts(ReactionState state, ReactionTracker tracker, double solventVolume, ItemStacksResourceHandler inventory, FluidStacksResourceHandler tank) {
        fillReactionState(products, solventVolume, inventory, tank, state, tracker);
    }

    // only call the fill methods when the recipe changes 
    private <R extends StacksResourceHandler<S, T>, S, T extends DataComponentHolderResource<W>, W>
    void fillReactionState(
        @NonNull List<Chemical> recipeChemicals, 
        double solventVolume, // volume of the fluid in tank
        @NonNull ItemStacksResourceHandler inventory, 
        @NonNull FluidStacksResourceHandler tank,
        ReactionState state,
        ReactionTracker tracker
    ) {
        if (recipeChemicals.isEmpty()) {
            throw new IllegalArgumentException("recipeChemicals shouldn't be empty");
        }
        
        // clear the state object since it will be reused across recipe changes
        state.clear();

        // default initialize state's entries; totals for each are computed on a pass thru handlers
        recipeChemicals.forEach(chem -> {
            state.put(chem);
            tracker.putSlotSet(chem.chemical(), true);
        });

        System.err.println(tracker.itemSlotLookup);
        System.err.println(tracker.fluidSlotLookup);

        for (int slot = 0; slot < inventory.size(); ++slot) {
            ItemResource itemResource = inventory.getResource(slot);
            if (itemResource.isEmpty()) continue;
            ItemStack itemStack = itemResource.toStack();
            
            boolean validMaterial = false;
            for (IngredientValue value : state.entries.values()) {
                validMaterial = value.ingredient.isMaterial() 
                    && value.ingredient.test(itemStack);
                if (!validMaterial) { continue; }
                value.total += inventory.getAmountAsInt(slot);
                boolean success = tracker.putChemIngInSlot(slot, true, value.ingredient);
                if (!success) throw new IllegalStateException("failed. one by one");
            }
            if (validMaterial) continue;

            // NOTE, assume a material ingredient cannot hold solutes, unless that should change

            boolean validSolutes = itemResource.has(TekoraComponents.SOLUTES_LIST);
            if (!validSolutes) continue;

            Solutes soluteMap = itemResource.get(TekoraComponents.SOLUTES_LIST);
            for (var solute : soluteMap.dataMap().entrySet()) {
                // we'll assume solutes are solid inside items only to get this working for now
                // (there's also the case of solutes being in bucket/bottle items...)
                ChemicalIngredient chemIng = ChemicalIngredient.of(solute.getKey(), SoluteIngredient.SOLID);
                IngredientValue value = state.entries.get(chemIng);
                if (value == null) continue;
                value.total += solute.getValue();
                tracker.putSlotSet(value.ingredient, true);
                boolean success = tracker.putChemIngInSlot(slot, true, value.ingredient);
                if (!success) throw new IllegalStateException("failed. one by 2");
            }
        }

        for (int slot = 0; slot < tank.size(); ++slot) {
            FluidResource fluidResource = tank.getResource(slot);
            int amount = tank.getAmountAsInt(slot);
            FluidStack fluidStack = fluidResource.toStack(amount);
            boolean validMaterial = false;
            // similar logic, except assume different states for inserted ingredients
            for (IngredientValue value : state.entries.values()) {
                // note, please don't try to extract logic onto generic funtcion, not worth time
                validMaterial = value.ingredient.isMaterial() 
                    && value.ingredient.test(fluidStack);
                if (!validMaterial) { continue; }
                value.total += amount;
                tracker.putSlotSet(value.ingredient, false);
                boolean success = tracker.putChemIngInSlot(slot, false, value.ingredient);
                if (!success) throw new IllegalStateException("failed. one by 3");
            }
            if (validMaterial) continue;

            boolean validSolutes = fluidResource.has(TekoraComponents.SOLUTES_LIST);
            if (!validSolutes) continue;
            
            Solutes soluteMap = fluidResource.get(TekoraComponents.SOLUTES_LIST);
            for (var solute : soluteMap.dataMap().entrySet()) {
                // TODO, if other states get annexed, determine what it is based off the fluid resource properties
                // TODO, must solvated ingredients force solventVolume to be above 0?
                // a new private method can be created to determine state based off resource properties
                ChemicalIngredient chemIng = ChemicalIngredient.of(solute.getKey(), SoluteIngredient.SOLVATED);
                IngredientValue value = state.entries.get(chemIng);
                if (value == null) continue;
                value.total += solute.getValue();
                tracker.putSlotSet(value.ingredient, false);
                boolean success = tracker.putChemIngInSlot(slot, false, value.ingredient);
                if (!success) throw new IllegalStateException("failed. one by 4");
            }
        }

        // are all ingredients for this side present? check to ensure
        state.hasAll = true;
        for (IngredientValue value : state.entries.values()) {
            System.out.printf("%s = %s", value.ingredient.toString(), value.total);
            if (value.total <= 0.0) {
                state.hasAll = false;
                break;
            }
        }

        // TODO, dealing with multiple solvents?
    }

    private static double getConcentration(IngredientValue ingredientDat, double solventVolume) {
        if (ingredientDat.total <= 0.0) return 0.0;
        else if (ingredientDat.isMaterial()) return 1.0;
        
        if (!ingredientDat.isSolute()) return 0.0;
        String state = ingredientDat.ingredient.asSoluteIngredient().state();
        switch (state) {
            // what is chemistry thermodynamic
            case SoluteIngredient.SOLID:
            case SoluteIngredient.LIQUID:
                return 1.0;
            case SoluteIngredient.SOLVATED:
                return solventVolume > 0.0 ? ingredientDat.total / solventVolume : 0.0;
            // TODO, concentration based on other states
            default:
                return 0.0;
        }
    }

    // solventVolume needs to be fetched from ReactionRecipeInput helper
    // should be called per active tick
    public void updateConcentrations(double solventVolume, ReactionContext dat) {
        double clampedVolume = Math.max(0.0, solventVolume);
        dat.tracker.solventVolume = clampedVolume;
        for (IngredientValue value : dat.reactantState.entries.values()) {
            value.concentration = getConcentration(value, clampedVolume);
        }
        for (IngredientValue value : dat.productState.entries.values()) {
            value.concentration = getConcentration(value, clampedVolume);
        }
    }

    // -----

    // 
    private static ItemResource withNewSolutes(ItemResource original, SoluteKey key, double delta) {
        Map<SoluteKey, Double> updatedMap;
        if (original.has(TekoraComponents.SOLUTES_LIST)) {
            Solutes solutes = original.get(TekoraComponents.SOLUTES_LIST);
            updatedMap = new HashMap<>(solutes.dataMap());
        } else {
            updatedMap = new HashMap<>();
        }
        double next = updatedMap.getOrDefault(key, 0.0) + delta;
        if (next <= 0) {
            // TODO have to return the amount still due (not needed for bare minimum)
            updatedMap.remove(key);
        } else {
            updatedMap.put(key, next);
        }

        Solutes nextSolutes = new Solutes(Map.copyOf(updatedMap));
        return original.with(TekoraComponents.SOLUTES_LIST.get(), nextSolutes);
    }

    private static FluidResource withNewSolutes(FluidResource original, SoluteKey key, double delta) {
        Map<SoluteKey, Double> updatedMap;
        if (original.has(TekoraComponents.SOLUTES_LIST)) {
            Solutes solutes = original.get(TekoraComponents.SOLUTES_LIST);
            updatedMap = new HashMap<>(solutes.dataMap());
        } else {
            updatedMap = new HashMap<>();
        }
        double next = updatedMap.getOrDefault(key, 0.0) + delta;
        if (next <= 0) {
            // TODO have to return the amount still due (not needed for bare minimum)
            updatedMap.remove(key);
        } else {
            updatedMap.put(key, next);
        }

        Solutes nextSolutes = new Solutes(Map.copyOf(updatedMap));
        return original.with(TekoraComponents.SOLUTES_LIST.get(), nextSolutes);
    }

    private static Optional<ItemResource> findItemResource(MaterialIngredient materialIng) {
        if (!materialIng.isItem()) return Optional.empty();
        Ingredient ingredient = materialIng.asItem();
        return Optional.of(ItemResource.of(ingredient.getValues().get(0)));
    }

    private static Optional<FluidResource> findFluidResource(MaterialIngredient materialIng) {
        if (!materialIng.isFluid()) return Optional.empty();
        FluidIngredient ingredient = materialIng.asFluid();
        return Optional.of(FluidResource.of(ingredient.fluids().get(0)));
    }
    

    // what a monster
    private static boolean simulateReactionStep(
        ReactionContext dat, 
        int direction, 
        double rateTicks, 
        Map<ChemicalIngredient, Double> reactionProg,
        Transaction transaction
    ) {        
        ReactionState reactantState = dat.reactantState;
        ReactionState productState = dat.productState;

        ReactionState inputState;
        ReactionState outputState;
        switch (direction) {
            case ReactionDirection.FORWARD:
                inputState = reactantState;
                outputState = productState;
                break;
            case ReactionDirection.REVERSE:
                inputState = productState;
                outputState = reactantState;
                break;
            case ReactionDirection.EQUAL:
            default:
                dat.tracker.status = ReactionStatus.IDLE;
                System.out.println("directionless");
                return false;
        }

        if (!inputState.hasAll) {
            System.out.println("not all present for input side");
            dat.tracker.status = ReactionStatus.IDLE;
            return false;
        }
        
        final double tickProgress = rateTicks;

        final int firstItemOutputSlot = dat.itemBounds == null ? 0 : dat.itemBounds.minIndex();

        try (Transaction simTransaction = Transaction.open(transaction)) {
            // code from old version still useful?

            System.err.println("attempting transaction");

            // try extraction
            boolean isExtractedAll = true;

            for (var entry : inputState.entries.entrySet()) {
                ChemicalIngredient chemIng = entry.getKey();
                IngredientValue value = entry.getValue();
                double amtConsumed = value.coefficient() * tickProgress;

                // the lookup sets intended for extracting from the next
                // slot if the current slot has insufficient amounts,
                // but for now they are unused
                Set<Integer> itemSlots = dat.tracker.getItemSlots(chemIng);
                Set<Integer> fluidSlots = dat.tracker.getFluidSlots(chemIng);
                // misnomers
                boolean presentInInventory = itemSlots != null && !itemSlots.isEmpty();
                boolean presentInTank = fluidSlots != null && !fluidSlots.isEmpty();

                System.out.printf("inv | tank : %s | %s\n", presentInInventory, presentInTank);

                if (presentInInventory) {
                    int slot = dat.tracker.getFirst(chemIng, true);
                    if (slot < 0) {
                        System.err.println("really? can't find?");
                        throw new IllegalStateException("really? can't find?");
                    }
                    ItemResource resource = dat.inventory.getResource(slot);
                    int count = dat.inventory.getAmountAsInt(slot);

                    if (count == 0) {
                        // there's nothing to "extract"
                        // TODO later, case with materialIngredients and progress
                        isExtractedAll = false;
                        System.err.println("what do i extract? no count");
                        break;
                    }

                    if (chemIng.isSolute()) {
                        var solIng = chemIng.asSoluteIngredient();

                        // if the resource doesn't contain solutes, error
                        if (resource.has(TekoraComponents.SOLUTES_LIST)) {
                            System.out.println("no solutes?");
                            System.out.println(resource);
                            continue;
                        }

                        ItemResource newResource = withNewSolutes(resource, solIng.value(), -amtConsumed);

                        // replacement
                        int extracted = dat.inventory.extract(slot, resource, count, simTransaction);
                        int inserted = dat.inventory.insert(slot, newResource, count, simTransaction);
                        if (extracted != inserted) {
                            System.err.println("cannot replace solute item");
                            isExtractedAll = false;
                            break;
                        }
                        dat.tracker.isDirty = true;

                    } else if (chemIng.isMaterial()) {
                        // ...
                        MaterialIngredient matIng = chemIng.asMaterial();
                        assert matIng.isItem();

                        // the "fractional" amount of the material
                        double currProg = reactionProg.getOrDefault(chemIng, 0.0);
                        double nextProg = currProg - amtConsumed;

                        if (nextProg > currProg) throw new IllegalStateException("n > c");

                        if (nextProg > 0) {
                            reactionProg.put(chemIng, nextProg);
                            continue;
                        }

                        // round to the "most negative" integer
                        int amt = Math.abs((int)Math.floor(nextProg));
                        int extracted = dat.inventory.extract(slot, resource, amt, simTransaction);
                        if (extracted < amt) {
                            System.err.println("cannot replace extract, mat item");
                            isExtractedAll = false;
                            break;
                        }

                        // next prog is not positive.
                        double newProg = nextProg - Math.floor(nextProg);
                        reactionProg.put(chemIng, newProg);
                    }
                } else if (presentInTank) {
                    // oh my god,
                    int slot = dat.tracker.getFirst(chemIng, false);
                    if (slot < 0) {
                        System.err.println("really? can't find?");
                    }
                    FluidResource resource = dat.tank.getResource(slot);
                    // TODO, a bug where stale entry in tracker's slots
                    // points to an empty resource, causing crash
                    // fix this by making sure tracker is updated on recipe
                    // change (when the mixer gets replaced, for example)
                    if (resource.isEmpty()) {
                        System.err.println("fluid resource is empty despite present entry in tracker");
                        isExtractedAll = false;
                        break;
                    }

                    int count = dat.tank.getAmountAsInt(slot);

                    if (chemIng.isSolute()) {
                        var solIng = chemIng.asSoluteIngredient();
                        FluidResource newResource = withNewSolutes(resource, solIng.value(), -amtConsumed);

                        // replacement
                        int extracted = dat.tank.extract(slot, resource, count, simTransaction);
                        int inserted = dat.tank.insert(slot, newResource, count, simTransaction);
                        if (extracted != inserted) {
                            System.err.println("cannot replace extract");
                            isExtractedAll = false;
                            break;
                        }

                    } else if (chemIng.isMaterial()) {
                        // ...
                        MaterialIngredient matIng = chemIng.asMaterial();
                        assert matIng.isFluid();

                        // the "fractional" amount of the material
                        double currProg = reactionProg.getOrDefault(chemIng, 0.0);
                        double nextProg = currProg - amtConsumed;

                        if (nextProg > currProg) throw new IllegalStateException("n > c");

                        if (nextProg > 0) {
                            reactionProg.put(chemIng, nextProg);
                            continue;
                        }

                        // round to the "most negative" integer
                        int amt = Math.abs((int)Math.floor(nextProg));
                        int extracted = dat.tank.extract(slot, resource, amt, simTransaction);
                        if (extracted < amt) {
                            System.err.println("extract < amt");
                            isExtractedAll = false;
                            break;
                        }
                        double newProg = nextProg - Math.floor(nextProg);
                        reactionProg.put(chemIng, newProg);
                    }
                } else {
                    // no slot to extract from, meaning it's not there
                    // this violate an invariant
                    System.err.print("item/fluid lookups are stupid");
                    isExtractedAll = false;
                    break;
                }
            }

            if (!isExtractedAll) { 
                dat.tracker.status = ReactionStatus.IDLE;
                System.err.println("cannot extract all");
                simTransaction.close();
                return false; 
            }

            // find valid solvent slot
            // for now, let it just be the first slot with a fluidresource
            int solventSlot = -1;
            FluidResource solventResource = FluidResource.EMPTY;
            int solventCount = 0;
            for (int slot = 0; slot < dat.tank.size(); ++slot) {
                FluidResource resource = dat.tank.getResource(slot);
                if (!resource.isEmpty()) {
                    solventResource = resource;
                    solventSlot = slot;
                    solventCount = dat.tank.getAmountAsInt(slot);
                    break;
                }
            }

            for (var entry : outputState.entries.entrySet()) {
                ChemicalIngredient chemIng = entry.getKey();
                IngredientValue value = entry.getValue();
                double amtProduced = value.coefficient() * tickProgress;

                // Set<Integer> itemSlots = tracker.getItemSlots(chemIng);
                // Set<Integer> fluidSlots = tracker.getFluidSlots(chemIng);

                // solvated solutes virtually never deal with overflow.

                if (chemIng.isSolute()) {
                    var soluteIng = chemIng.asSoluteIngredient();

                    switch (soluteIng.state()) {
                        case SoluteIngredient.SOLVATED:
                            if (solventSlot < 0) {
                                System.err.println("can't find solvent slot");
                                continue;
                            }
                            
                            FluidResource newResource = withNewSolutes(solventResource, soluteIng.value(), amtProduced);
                            // replacement
                            int extracted = dat.tank.extract(solventSlot, solventResource, solventCount, simTransaction);
                            int inserted = dat.tank.insert(solventSlot, newResource, solventCount, simTransaction);
                            solventResource = newResource; // update the reference for next
                            if (extracted != inserted) {
                                continue;
                            }
                            break;
                        // solutes inside a solid are a thing. called alloys. ????
                        case SoluteIngredient.SOLID:
                            // Note ignore for now
                            // probably involves replacing items with datacomponent
                            break;
                        default:
                            // TODO cases for other states?
                            break;
                    }

                } else if (chemIng.isMaterial()) {
                    // ...
                    MaterialIngredient matIng = chemIng.asMaterial();

                    // the "fractional" amount of the material
                    double currProg = reactionProg.getOrDefault(chemIng, 0.0);
                    double nextProg = currProg + amtProduced;
                    assert nextProg >= currProg;

                    if (nextProg < 1.0) { 
                        reactionProg.put(chemIng, nextProg);
                        continue; 
                    }

                    int inserted = 0;
                    int amt = (int)Math.floor(nextProg);

                    if (matIng.isFluid()) {
                        FluidResource resource = findFluidResource(matIng).orElse(null);
                        if (resource == null) {
                            System.err.println("can't find output resource from material");
                            continue;
                        };
                        inserted = dat.tank.insert(resource, amt, simTransaction);
                    } else  {
                        ItemResource resource = findItemResource(matIng).orElse(null);
                        if (resource == null) {
                            System.err.println("can't find output resource from material");
                            continue;
                        };
                        
                        // overflow attempt (doesn't really work atm)
                        int amtRemaining = amt;
                        final int lastItemOutputSlot = dat.itemBounds == null ? firstItemOutputSlot : dat.itemBounds.maxIndex(); 
                        for (int slot = firstItemOutputSlot; slot <= lastItemOutputSlot; ++slot) {
                            inserted = dat.inventory.insert(firstItemOutputSlot, resource, amtRemaining, simTransaction);
                            amtRemaining -= inserted;
                            if (amtRemaining <= 0) {
                                break;
                                // otherwise, attempt an insert in the next slot
                            }
                        }
                    }
                    
                    if (inserted < amt) {
                        // TODO, overflow, but maybe later
                        // right now, just void it 
                    }

                    double newProg = nextProg - Math.floor(nextProg);
                    reactionProg.put(chemIng, newProg);
                }
            }
            simTransaction.commit();
        }

        dat.tracker.status = ReactionStatus.ACTIVE;
        return true;
    }

    public void modifyCrafterInventory(ReactionContext dat, int direction, double rateTicks) {
        try (Transaction transaction = Transaction.openRoot()) {
            // LOL

            System.out.println("before");
            dat.tracker.printIngProg();
            if (!dat.tank.getResource(0).isEmpty() && dat.tank.getResource(0).has(TekoraComponents.SOLUTES_LIST)) {
                System.out.println(dat.tank.getResource(0).get(TekoraComponents.SOLUTES_LIST).dataMap());
            }

            var progSnapshot = dat.tracker.ingredientProgress.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            boolean success = simulateReactionStep(dat, direction, rateTicks, progSnapshot, transaction);

            if (success) {
                transaction.commit();
                dat.tracker.ingredientProgress = progSnapshot;
            } else {
                System.out.println("failed to commit");
                System.out.println("after");
                dat.tracker.printIngProg();
                if (!dat.tank.getResource(0).isEmpty() && dat.tank.getResource(0).has(TekoraComponents.SOLUTES_LIST)) {
                    System.out.println(dat.tank.getResource(0).get(TekoraComponents.SOLUTES_LIST).dataMap());
                }
                System.out.println("\n\n");
                // throw new IllegalStateException("oops");
                transaction.close();
                return;
            }
        }

        System.out.println("after");
        dat.tracker.printIngProg();
        if (!dat.tank.getResource(0).isEmpty() && dat.tank.getResource(0).has(TekoraComponents.SOLUTES_LIST)) {
            System.out.println(dat.tank.getResource(0).get(TekoraComponents.SOLUTES_LIST).dataMap());
        }
        System.out.println("\n\n");
    }
}
