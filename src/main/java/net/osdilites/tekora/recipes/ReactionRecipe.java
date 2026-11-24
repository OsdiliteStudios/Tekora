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

    /**
     * Old.
     * @param chemicals
     * @param items
     * @param inventory
     * @param fluids
     * @param tank
     */
    @Deprecated 
    private static void fillBasedOnData(List<Chemical> chemicals, Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        for (Chemical chemical : chemicals) {
            for (int i = 0; i < inventory.size(); i++) {
                ItemResource resource = inventory.getResource(i);
                if (resource.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
                    Solutes resourceSolutes = resource.getComponents().get(TekoraComponents.SOLUTES_LIST);
                    if (resourceSolutes != null) {
                        Map<SoluteKey, Double> map = resourceSolutes.dataMap();
                        // what's the point of a list if there's some other way to encode
                        // the chemical's coefficient and position?
                        float[] list = new float[map.size()];
                        int ind = 0;
                        for (SoluteKey key : map.keySet()) {
                            // -1, skip solute since it's nmot part of th reaction
                            // float since the item is mutable
                            list[ind++] = chemical.chemical().test(key) ? chemical.coefficient() : -1.0f;
                        }
                        items.put(i, list);
                    }
                } else if (chemical.chemical().test(resource.toStack())) {
                    // if the chemical is a valid material, encode its key as negative to indicate such 
                    items.put(-i-1, new float[]{chemical.coefficient(), 0f});
                    break;
                }
            }
            for (int i = 0; i < tank.size(); i++) {
                FluidResource resource = tank.getResource(i);
                if (resource.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
                    Solutes val = resource.getComponents().get(TekoraComponents.SOLUTES_LIST);
                    if (val != null) {
                        Map<SoluteKey, Double> map = val.dataMap();
                        float[] list = new float[map.size()];
                        int ind = 0;
                        for (SoluteKey key : map.keySet()) {
                            list[ind++] = chemical.chemical().test(key) ? chemical.coefficient() : -1.0f;
                        }
                        items.put(-i-1, list);
                    }
                } else if (chemical.chemical().test(resource.toStack(1))) {
                    fluids.put(i, new float[]{chemical.coefficient(), 0f});
                    break;
                }
            }
        }
    }

    @Deprecated 
    public void fillWithReactants(Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        fillBasedOnData(reactants, items, inventory, fluids, tank);
    }

    @Deprecated 
    public void fillWithProducts(Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        fillBasedOnData(products, items, inventory, fluids, tank);
    }

    /*
    // inventory indices should be distinct.
    public record CoefficientsKey(
        boolean isSolute,   /// resource is either Material or has Solute ingredients
        int inventoryIndex  /// Inventory index that this coefficient is for 
    ) { 
        public String toString() {
            return String.format("{ %d: %s }", inventoryIndex, isSolute);
        }
    }

    // a more optimized, memory-efficient abstraction for accessing data... 
    // ...is always welcome, but for now this approach is readable enough
    // TODO: edge cases or requirements not considered?
    // - same chemical on both sides? this is homogenous catalyst, so can make a explicit check for it
    public static class CoefficientsMap {
        /// pair of ingredient key and concentration value.
        /// materials would only have one entry
        public Map<Either<MaterialIngredient, SoluteKey>, Float> coefficients;
        
        // the portion of the material ingredient that is completed
        float progress;

        public CoefficientsMap() {
            this.coefficients = new HashMap<>();
            this.progress = 0.f;
        }

        public void put(SoluteKey key, float coeff) {
            coefficients.put(Either.<MaterialIngredient, SoluteKey>right(key), coeff);
        }

        /// Returns 0 if entry is not found.
        @NotNull public float get(SoluteKey key) {
            Float value = coefficients.get(Either.<MaterialIngredient, SoluteKey>right(key));
            return value == null ? 0.f : value;
        }

        public void put(MaterialIngredient key, float coeff) {
            coefficients.put(Either.<MaterialIngredient, SoluteKey>left(key), coeff);
        }

        /// Returns 0 if entry is not found.
        @NotNull public float get(MaterialIngredient key) {
            Float value = coefficients.get(Either.<MaterialIngredient, SoluteKey>left(key));
            return value == null ? 0.f : value;
        }

        public boolean isEmpty() {
            return this.coefficients.isEmpty();
        }
    }
    */

    
    /*
     * type-alias, but not really
     * @param inventoryIndex Inventory index that this coefficient is associated with
     */
    // public record CoefficientKey(int inventoryIndex) { }

    public class IngredientValue {
        private final Float coefficient;

        // how close the material ingredient is to being crafted.
        public float progress = 0.f;

        // ingredientKey data for checking using resource -> chemIng.of() -> .asMaterial
        public ChemicalIngredient ingredient;

        IngredientValue(Float coeff, ChemicalIngredient chemIng) {
            this.coefficient = coeff;
            this.ingredient = chemIng;
        }

        IngredientValue(Float coeff, SoluteIngredient chem) {
            this.coefficient = coeff;
            this.ingredient = ChemicalIngredient.of(chem);
        }

        public boolean isSolute() {
            return ingredient.isSolute();
        }

        public boolean isMaterial() {
            return ingredient.isMaterial();
        }

        public Float coefficient() {
            return coefficient;
        }
    }

    /// Wrapper for "map" of ingredients with associated coefficients.
    public class CoefficientMap {
        /// pair of ingredient key and concentration value.
        /// materials would only have one entry
        public Map<Integer, IngredientValue> coefficients;

        public CoefficientMap() {
            this.coefficients = new HashMap<>();
        }

        // boilerplate

        public void put(int index, ChemicalIngredient mat, float coeff) {
            coefficients.put(index, new IngredientValue(coeff, mat));
        }

        public void put(int index, SoluteIngredient chem, float coeff) {
            coefficients.put(index, new IngredientValue(coeff, chem));
        }

        /// May return null.
        public IngredientValue get(int index) {
            return coefficients.get(index);
        }

        /// Returns 0 if entry is not found.
        public float getCoefficient(int index) {
            var value = coefficients.get(index);
            if (value == null) return 0.f;
            return value.coefficient;
        }

        public boolean isEmpty() {
            return this.coefficients.isEmpty();
        }
    }
    

    private static <T extends DataComponentHolderResource<W>, W> boolean hasSolutes(T resource) {
        return resource.getComponents().has(TekoraComponents.SOLUTES_LIST);
    }
    
    // TODO:
    // since there is a new type of ingredient chemDataIngredient, 
    // all the stuff added in that type of ingredient might make it
    // easier to compare with a group of solutes in a very similar 
    // way to material ingredients. thus, should get to 
    // rewriting parts of literally every method I've touched that 
    // involves solutes. damn...  

    // i wouldn't have to iterate through each coefficient anymore
    // 

    private static <T extends DataComponentHolderResource<W>, W>
        ChemicalIngredient IngredientFromResource(T resource) {
        W value = resource.value();
        ChemicalIngredient inputIngredient;

        if (value instanceof ItemLike item) {
            inputIngredient = ChemicalIngredient.of(item);
        } else if (value instanceof Fluid fluid) {
            inputIngredient = ChemicalIngredient.of(fluid);
        } else {
            System.err.println("what is value?");
            return null;
        }

        return inputIngredient;
    }

    /**
     * Populates the given maps with coefficient information for current inventory items.
     *
     * @param <R> The type of resource handler used, either ItemStack or FluidStack 
     * @param <S> The type of stack used to store the contents of this handler.
     * @param <T> The type of resource this handler manages. Must be able to hold data components.
     * @param <W> ItemLike or Fluid
     * @param chemicals Reactants or products of this reaction recipe to read from.
     * @param itemIngredients Map of ingredient coefficients to *write* to for items, based on matches with recipe
     * @param inventory inventory to read from for ingredient coefficients
     * @param fluidIngredients Map of ingredient coefficients to write to for fluids, based on matches with recipe
     * @param tank inventory to read from for ingredient coefficients
     */
    private static <R extends StacksResourceHandler<S, T>, S, T extends DataComponentHolderResource<W>, W> 
        void getIngredientCoefficients(List<Chemical> chemicals, CoefficientMap resourceIngredients, R resourceHandler) 
    {
        // - getCoefficients could be made much simpler and not rely on inventory data
        // because recipeData is constant, and wont have to explicitly only include
        // data for those present in inventory????

        // map for easier lookups and less nested loops.
        // if optimizing, make sure to cache these maps somewhere
        // perhaps a dedicated cache object (new class) for these checks? 
        // or maybe just change the data structure from list to set
        Map<ChemicalIngredient, Chemical> chemicalIngMap =
            chemicals.stream().collect(Collectors.toMap(k -> k.chemical(), v -> v));
        // test inventory on chemicals
        for (int index = 0; index < resourceHandler.size(); ++index) {
            T resource = resourceHandler.getResource(index);
            
            // note that a resource can have multiple solutes, each of which can be an ingredient
            if (hasSolutes(resource)) {
                Map<SoluteKey, Double> resourceSolutesMap = resource.getComponents().get(TekoraComponents.SOLUTES_LIST).dataMap();
                
                // map any input solutes matching an entry in the recipe to the return map
                // all ingredients means that input solutes are a super set of recipe solutes
                for (var inventorySoluteKey : resourceSolutesMap.keySet()) {
                    // have to assume ingredients in solutes list have the solvated state
                    ChemicalIngredient inventorySoluteIng = ChemicalIngredient.of(inventorySoluteKey, SoluteIngredient.SOLVATED);
                    if (!chemicalIngMap.containsKey(inventorySoluteIng)) continue;
                    
                    ChemicalIngredient inputIngredient = chemicalIngMap.get(inventorySoluteIng).chemical();
                    float recipeCoefficent = chemicalIngMap.get(inventorySoluteIng).coefficient();
                    // copy relevant recipe data for ingredients that are part of the recipe;
                    // modify the actual concentrations in the resource's map later
                    resourceIngredients.put(index, inputIngredient, recipeCoefficent);
                }
            } else {
                ChemicalIngredient inputIngredient = IngredientFromResource(resource);
                if (!chemicalIngMap.containsKey(inputIngredient)) continue;
                float coefficient = chemicalIngMap.get(inputIngredient).coefficient();
                resourceIngredients.put(index, inputIngredient, coefficient);
            }
        }
    }

    public void fillWithReactants(CoefficientMap items, ItemStacksResourceHandler inventory, CoefficientMap fluids, FluidStacksResourceHandler tank) {
        getIngredientCoefficients(reactants, items, inventory);
        getIngredientCoefficients(reactants, fluids, tank);
    }
    public void fillWithProducts(CoefficientMap items, ItemStacksResourceHandler inventory, CoefficientMap fluids, FluidStacksResourceHandler tank) {
        getIngredientCoefficients(products, items, inventory);
        getIngredientCoefficients(products, fluids, tank);
    }
    // ----

    public static class ReactionDirection {
        public static final int REVERSE = 1, EQUAL = 0, FORWARD = -1;
    } 

    // TODO documentation during bug testing
    private <R extends StacksResourceHandler<S, T>, S, T extends DataComponentHolderResource<W>, W> 
        Set<ChemicalIngredient> getMissing(List<Chemical> recipeChemList, R inventory, int action) 
    {
        if (action != ReactionDirection.FORWARD && action != ReactionDirection.REVERSE) {
            return recipeChemList.stream()
                .map(chem -> chem.chemical())
                .collect(Collectors.toSet());
        }

        Map<ChemicalIngredient, Boolean> recipeIngPresent = recipeChemList.stream()
            .map(chem -> chem.chemical())
            .collect(Collectors.toMap(k -> k, v -> false));  

        // Map<SoluteIngredient, Boolean> recipeSolutes = recipeIngStream
        //     .filter(chemIng -> chemIng.isSolute()) 
        //     .collect(Collectors.toMap(k -> k.asSoluteIngredient(), v -> false));
        
        // Map<MaterialIngredient, Boolean> recipeMaterials = recipeIngStream
        //     .filter(chemIng -> chemIng.isMaterial()) 
        //     .collect(Collectors.toMap(k -> k.asMaterial(), v -> false));
        
        // extra ingredients not in the recipeChemList are ignored
        for (int i = 0; i < inventory.size(); ++i) {
            T slotResource = inventory.getResource(i);
            // ingredients can't be air.
            if (slotResource.isEmpty()) continue;

            if (hasSolutes(slotResource)) {
                Map<SoluteKey, Double> solutes = slotResource.get(TekoraComponents.SOLUTES_LIST).dataMap();

                for (SoluteKey invSoluteKey : solutes.keySet()) {
                    // NOTE, another of the same assumption 
                    ChemicalIngredient key = ChemicalIngredient.of(invSoluteKey, SoluteIngredient.SOLVATED);
                    boolean inRecipe = recipeIngPresent.containsKey(key);
                    if (inRecipe) recipeIngPresent.replace(key, true);
                }

            } else {
                // implementation of .of(item) -> material 
                ChemicalIngredient key = IngredientFromResource(slotResource);
                boolean inRecipe = recipeIngPresent.containsKey(key);
                if (inRecipe) recipeIngPresent.replace(key, true);
            }
        }
        // // if any recipeIng is missing -> false
        // boolean allSolutes = !recipeSolutes.values().contains(false);
        // boolean allMaterials = !recipeMaterials.values().contains(false);
        // boolean allIngredientsPresent = allSolutes && allMaterials;

        // if (!allIngredientsPresent && missingIngredients != null) {
        //     Set<MaterialIngredient> missingMaterials = recipeMaterials.entrySet()
        //         .stream()
        //         .filter(e -> e.getValue() != false)
        //         .map(e -> e.getKey())
        //         .collect(Collectors.toSet());
            
        //     Set<SoluteIngredient> missingChemData = recipeSolutes.entrySet()
        //         .stream()
        //         .filter(e -> e.getValue() != false)
        //         .map(e -> e.getKey())
        //         .collect(Collectors.toSet());
            
        //     for (MaterialIngredient mat : missingMaterials) {
        //         missingIngredients.add(Either.left(mat));
        //     }

        //     for (SoluteIngredient chemDat : missingChemData) {
        //         missingIngredients.add(Either.right(chemDat));
        //     }
        // }

        // I LOVE FUNCTIONAL PROGRAMMING!
        Set<ChemicalIngredient> missingIngredients = recipeIngPresent.entrySet()
            .stream()
            .filter(entry -> !entry.getValue())
            .map(missing -> missing.getKey())
            .collect(Collectors.toSet());

        return missingIngredients;
    }

    /// Used to restrict which indices to check for entities that share
    /// output and input in the same handler.
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

    /// Add to itemChemicals, read from everything else
    private <R extends StacksResourceHandler<S, T>, S, T extends DataComponentHolderResource<W>, W> 
        void addMissingEntries(@NonNull CoefficientMap itemChemicals, List<Chemical> recipeList, R inventory, Set<ChemicalIngredient> missing, OutputBound bound) 
    {
        for (Chemical chemical : recipeList) {
            ChemicalIngredient reactantIng = chemical.chemical();
            if (!missing.contains(reactantIng)) continue;

            // find a free spot for the new output
            for (int slot = bound.minIndex; slot < bound.maxIndex; ++slot) {
                if (!inventory.getResource(slot).isEmpty()) continue;
                if (itemChemicals.get(slot) != null) {
                    System.err.printf("%s is empty resource but has data associated with it?\n", slot);
                    throw new IllegalStateException("is empty resource but has data associated with it?\n");
                }
                itemChemicals.put(slot, reactantIng, chemical.coefficient());
                break;
            }
        }
    }
    

    private boolean soluteExistsInRecipe(SoluteKey key, int action) {
        if (action == 1) {
            return prodCoeffs.keySet().contains(key);
        } else if (action == -1) {
            return reactCoeffs.keySet().contains(key);
        } else {
            return false;
        }
    }

    public void modifyCrafterInventory(
        @NonNull CoefficientMap itemChemicals, 
        ItemStacksResourceHandler inventory, 
        double rate, 
        int action,
        boolean isReactants,
        @Nullable OutputBound invBound) 
    {
        boolean allProducts = false; // can we can turn into reactants?
        boolean allReactants = false; // we can turn into products?

        invBound = invBound == null 
            ? new OutputBound(0, inventory.size()) 
            : invBound;

        if (invBound.maxIndex() > inventory.size()) {
            invBound = new OutputBound(invBound.minIndex(), inventory.size());
        }

        Set<ChemicalIngredient> missing;
        
        if (action == ReactionDirection.REVERSE) {
            // check if all products are available
            missing = getMissing(products, inventory, action);
            allProducts = missing.isEmpty();
        } else if (action == ReactionDirection.FORWARD) {
            // check if all reactants are available
            missing = getMissing(reactants, inventory, action);
            allReactants = missing.isEmpty();
        } else {
            // at equilibrium, don't modify anything.
            return;
        }

        if (!allProducts && !allReactants) {
            // cannot produce a reaction because missing ingredients
            // on either side, so don't modify anything.
            return;
        }

        // by default, if only inputs present and missing outputs, then create the output entries first
        if (allReactants && action == ReactionDirection.FORWARD) {
            addMissingEntries(itemChemicals, products, inventory, missing, invBound);
        } else if (allProducts && action == ReactionDirection.REVERSE) {
            addMissingEntries(itemChemicals, reactants, inventory, missing, invBound);
        }

        // TODO, should add entry to data component for resource creation

        // these cases shouldn't happen, should be covered by an above check
        if ( (!allProducts && action == ReactionDirection.REVERSE) 
            || (!allReactants && action == ReactionDirection.FORWARD) ) {
            System.err.println("input vs direction logic error");
            throw new IllegalStateException("input vs direction logic error");
        }

        // all reactants and products are present at this point,
        // so modify the amou of the given chemicals in the inventory
        for (Integer inventoryIndex : itemChemicals.coefficients.keySet()) {
            ItemResource inputResource = inventory.getResource(inventoryIndex);
            IngredientValue inputIngredientInfo = itemChemicals.get(inventoryIndex);

            if (inputIngredientInfo == null) {
                System.err.printf("info for %s shouldn't be empty.\n", inventoryIndex);
                throw new IllegalStateException("info for slot shouldn't be empty");
            }

            if (inputIngredientInfo.isSolute() && hasSolutes(inputResource)) {
                // current concentrations of solutes to modify.
                Map<SoluteKey, Double> solutesAmts = inputResource.get(TekoraComponents.SOLUTES_LIST).dataMap();

                // assume that the guard conditions for this modifyInv method work,
                // so recipe solutes is a subset of solutes in inventory (which has extras)
                for (var soluteEntry : solutesAmts.entrySet()) {
                    if (!soluteExistsInRecipe(soluteEntry.getKey(), action)) 
                        continue;
                    float soluteCoeff = itemChemicals.get(inventoryIndex).coefficient;
                    /*
                    // explanation, for some reason
                    if (modifyingReactantsSide) {
                        if (action == ReactionDirection.FORWARD) signum = -1.f;
                        if (action == ReactionDirection.REVERSE) signum = 1.f;
                    } else if (modifyingProductsSide) {
                        if (action == ReactionDirection.FORWARD) signum = 1.f;
                        if (action == ReactionDirection.REVERSE) signum = -1.f;
                    }
                     */
                    // assumes FORWARD = -1, REVERSE = 1, 
                    float signum = isReactants 
                        ? action    // consume reactants
                        : -action;  // consume products
                    double change = signum * soluteCoeff * rate;
                    double original = soluteEntry.getValue();
                    soluteEntry.setValue(original+change);
                }
            } else if (!inputIngredientInfo.isMaterial()) {
                ChemicalIngredient inputIngredient = ChemicalIngredient.of(inputResource.getItem());
                if (!inputIngredient.isMaterial()) {
                    // error here means serious flaw with assumptions
                    System.err.printf("couldn't treat %s as material\n", inputIngredient);
                    throw new IllegalStateException("couldn't treat this as material");
                }

                float materialCoeff = inputIngredientInfo.coefficient;
                // add or subtract from progress based on direction and side of chemical reaction to modify
                float signum = isReactants ? -action : action;
                float change = signum * (float)rate * materialCoeff;
                inputIngredientInfo.progress += change;

                // truncate fractional part: change = 0 if no item made yet 
                int itemsCountChange = (int)inputIngredientInfo.progress;
                if (Math.abs(inputIngredientInfo.progress) >= 1.f) {
                    int newAmount = inventory.getAmountAsInt(inventoryIndex) + itemsCountChange;
                    inventory.set(inventoryIndex, inputResource, newAmount );
                }

                inputIngredientInfo.progress %= 1.0f;
            }
        }

    }

    // ----


    /**
     * Modifies the given inventory based on the given recipe parameters 
     * @param itemReactants A map of slot index (int) and *recipe* coefficients (float[]) for each slot, for either reactants or products.
     * @param inventory The item inventory to modify
     * @param rate The rate at which the reaction occurs.
     * @param action int determining whether to produce reactants (1) or products (-1). The direction of the reaction.
     */
    @Deprecated 
    public void modifyCrafterInventory(@NonNull Map<Integer, float[]> itemReactants, ItemStacksResourceHandler inventory, double rate, int action) {
        if (action == 1) {
            // checks if all the products are available
        } else if (action == -1) {
            // checks if all the reactants are available
        }

        for (Integer ind : itemReactants.keySet()) {
            boolean hasSolutes = ind < 0;
            float[] vals = itemReactants.get(hasSolutes ? -ind - 1 : ind);
            ItemResource resource = inventory.getResource(ind);
            if (hasSolutes && resource.has(TekoraComponents.SOLUTES_LIST)) {
                int mapInd = 0;
                // todo, work products/reactants that are not in the list but in the recipe within the recipe.
                Map<SoluteKey, Double> data = resource.get(TekoraComponents.SOLUTES_LIST).dataMap();
                for (var entry : data.entrySet()) {
                    float coeff = vals[mapInd++];
                    if (coeff > 0) {
                        double newVal = coeff * rate;
                        double org = entry.getValue();
                        entry.setValue(action == -1 ? org-newVal : org+newVal);
                    }
                }
            }

            float amt = (float)rate * vals[0];
            if (action == -1) amt = -amt;
            vals[1] += amt;
            if (vals[1] >= 1.0f) {
                inventory.set(ind, resource, inventory.getAmountAsInt(ind) + 1);
            } else if (vals[1] <= -1.0f) {
                inventory.set(ind, resource, inventory.getAmountAsInt(ind) - 1);
            }
            vals[1] %= 1.0f;
        }
    }

    public void modifyCrafterTank(@NonNull Map<Integer, float[]> fluidReactants, FluidStacksResourceHandler tank, double rate, int action) {
        for (Integer ind : fluidReactants.keySet()) {
            boolean hasSolutes = ind < 0;
            float[] vals = fluidReactants.get(hasSolutes ? -ind - 1 : ind);
            FluidResource resource = tank.getResource(ind);
            if (hasSolutes && resource.has(TekoraComponents.SOLUTES_LIST)) {
                int mapInd = 0;
                // todo, work products/reactants that are not in the list but in the recipe within the recipe.
                Map<SoluteKey, Double> data = resource.get(TekoraComponents.SOLUTES_LIST).dataMap();
                for (var entry : data.entrySet()) {
                    float coeff = vals[mapInd++];
                    if (coeff > 0) {
                        double newVal = coeff * rate;
                        double org = entry.getValue();
                        entry.setValue(action == -1 ? org-newVal : org+newVal);
                    }
                }
            }

            float amt = (float)rate * vals[0];
            if (action == -1) amt = -amt;
            vals[1] += amt;
            if (vals[1] >= 1.0f) {
                tank.set(ind, resource, tank.getAmountAsInt(ind) + 1);
            } else if (vals[1] <= -1.0f) {
                tank.set(ind, resource, tank.getAmountAsInt(ind) - 1);
            }
            vals[1] %= 1.0f;
        }
    }
}