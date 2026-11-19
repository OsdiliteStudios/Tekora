package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.ingredient.MaterialIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.NonNull;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                SoluteKey key = chemical.chemical().asSolute();
                this.reactCoeffs.put(key, chemical.coefficient());
                this.reactOrders.put(key, chemical.order());
            }
        }

        this.prodCoeffs = new HashMap<>();
        for (Chemical chemical : products) {
            if (chemical.chemical().isSolute()) {
                SoluteKey key = chemical.chemical().asSolute();
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

    private static boolean hasSolutes(ItemResource resource) {
        return resource.getComponents().has(TekoraComponents.SOLUTES_LIST);
    } 

    private static boolean hasSolutes(FluidResource resource) {
        return resource.getComponents().has(TekoraComponents.SOLUTES_LIST);
    }

    /**
     * wshen the recipe prcoes the whole thing, it passes throguh an inpoiut, both the item stack and fluid handlers
     * look at existing data, recipe, populated handlers, and compa
     * ******by default, if only reactants and no products, then create the product item first ********
     * the list has to be complete. if neither are co 
     * @param chemicals
     * @param items
     * @param inventory
     * @param fluids
     * @param tank
     */
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

    public void fillWithReactants(Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        fillBasedOnData(reactants, items, inventory, fluids, tank);
    }
    public void fillWithProducts(Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        fillBasedOnData(products, items, inventory, fluids, tank);
    }

    // special values to indicate properties about coefficients in Map<Integer, float[]>
    
    /// used to indicate a solute is present for a map
    private static float SOLUTE_NOT_PRESENT = -1.0f;

    /// a index belongs to a material
    private static boolean isMaterialIndex(Integer index) { return index < -1; }

    // the material index as its actual index in map of chemicals
    private static float asEquationIndex(Integer index) { return Math.abs(index + 1); }
    

    private static float[] getRecipeCoefficients(Map<Chemical, Chemical> chemicalSet, Map<SoluteKey, Double> inputResourceMap) {
        float[] list = new float[inputResourceMap.size()];
        // default initialize to not present 
        for (int i = 0; i < list.length; ++i) {
            list[i] = SOLUTE_NOT_PRESENT;
        }

        // iterating through a set could be in any order, so instead set
        // the coefficients that really matter
        // ...actually nah, don't continue with this.

        // TODO: change the data structure of Map<Integer, number> parameters used in helper functions
        // to something else entirely

        // would be like:
        // key: Resource
        // value: {
        //  type: Either<MaterialIngredient, SoluteKey> or smth else?
        //  moles: float
        // }

        // TODO: think about the pieces of the actual requirements you've been given,
        // and channel your inner systems engineer to design a better flow
        // free free to change ANY of the types not already needed for JSON representation
        
        return list;
    }

    
    
    /**
     * 
     * @param chemicals Reactants or products of a chemical reaction
     * @param itemIngredients
     * @param inventory
     */
    private static void getIngredientCoefficients(List<Chemical> chemicals, Map<Integer, float[]> itemIngredients, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluidIngredients, FluidStacksResourceHandler tank) {
        // data structure for easier lookups and simplicity.
        // if optimizing, make sure to cache this value somewhere
        // perhaps a dedicated cache object (new class) for these checks? 
        // or maybe just change the data structure from list to set
        Map<Chemical, Chemical> chemicalSet = 
            chemicals.stream()
                .map(chem -> chem)
                .collect(Collectors.toMap(k -> k, v -> v));   
        
        // test inventory on chemicals
        for (int index = 0; index < inventory.size(); ++index) {
            ItemResource resource = inventory.getResource(index);
            
            if (hasSolutes(resource)) {
                Solutes resourceSolutes = resource.getComponents().get(TekoraComponents.SOLUTES_LIST);

                if (resourceSolutes == null) continue;

                Map<SoluteKey, Double> resSolutesMap = resourceSolutes.dataMap();
                float[] list = getRecipeCoefficients(chemicalSet, resSolutesMap);
                itemIngredients.put(index, list);
            }
        }



        // then, test fluids for chemicals
    }

    private boolean allPresent(List<Chemical> chemList, ItemStacksResourceHandler inventory, int action) {
        Map<ChemicalIngredient, Boolean> recipeIng = 
            chemList.stream()
                .map(chem -> chem.chemical())
                .collect(Collectors.toMap(k -> k, v -> false));       

        if (action != 1 && action != -1) {
            return false;
        }
        
        for (int i = 0; i < inventory.size(); ++i) {
            ItemResource slotResource = inventory.getResource(i);
            // ingredients can't be air.
            if (slotResource.isEmpty()) continue;
            ChemicalIngredient key = ChemicalIngredient.of(slotResource.getItem());
            boolean inRecipe = recipeIng.containsKey(key);
            // cover the case of extra ingredients not in the recipe
            if (!inRecipe) continue;
            recipeIng.put(key, inRecipe);
        }

        return !recipeIng.values().contains(false);
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

    /** @deprecated Temporary method. modifyCrafterInventory should be used instead.*/
    public List<Chemical> getProducts() {
        return products;
    }

    
    public static class ReactionDirection {
        public static final int REVERSE = 1, EQUAL = 0, FORWARD = -1;
    } 

    /**
     * Modifies the given inventory based on the given recipe parameters 
     * @param itemChemicals A map of slot index (int) and *recipe* coefficients (float[]) for each slot, for either reactants or products.
     * @param inventory The item inventory to modify
     * @param rate The rate at which the reaction occurs.
     * @param action int determining whether to produce reactants (1) or products (-1). The direction of the reaction.
     */
    public void modifyCrafterInventory(@NonNull Map<Integer, float[]> itemChemicals, ItemStacksResourceHandler inventory, double rate, int action) {
        boolean allProducts = false; // can we can turn into reactants?
        boolean allReactants = false; // we can turn into products?
        
        if (action == ReactionDirection.REVERSE) {
            // check if all products are available
            allProducts = allPresent(products, inventory, action);
        } else if (action == ReactionDirection.FORWARD) {
            // check if all reactants are available
            allReactants = allPresent(reactants, inventory, action);
        } else {
            // at equilibrium, don't modify anything.
            return;
        }

        if (!allProducts && !allReactants) {
            // cannot produce a reaction, so don't modify anything.
            return;
        }

        if (!allProducts) {
            // create missing product items, and modify the appropriate solutes
            // then return.
        } else if (!allReactants) {
            // create missing reactant items, and modify the appro... yea.
            // then return
        }

        // all reactants and products are present at this point,
        // so modify the moles of the given chemicals

        // modify the solutes of each of the inventory items 
        // for (Integer ind : itemChemicals.keySet()) {
        //     // positive indices indicates solutes for a chemical item, reversed for fluids?
        //     boolean hasSolutes = ind > 0;
        //     // negative keys (ind) should be converted to unsigned
        //     float[] vals = itemChemicals.get(hasSolutes ? ind : -ind - 1);

        //     if (vals == null) continue;

        //     ItemResource resource = inventory.getResource(ind);
        //     if (hasSolutes && resource.has(TekoraComponents.SOLUTES_LIST)) {
        //         int mapInd = 0;
        //         // -----todo, work products/reactants that are not in the list but in the recipe within the recipe.
        //         Map<SoluteKey, Double> data = resource.get(TekoraComponents.SOLUTES_LIST).dataMap();
        //         for (var entry : data.entrySet()) {
        //             float coeff = vals[mapInd++];
                    
        //             // do not want to modify solutes not involved in reaction 
        //             if (!soluteExistsInRecipe(entry.getKey(), action)) continue;

        //             if (coeff > 0) {
        //                 double newVal = coeff * rate;
        //                 double original = entry.getValue();
        //                 // modify solutes of the side given by itemChemicals.
        //                 // TODO this needs to be changed. how to determine if itemChemicals
        //                 // is products or reactants? how to make that distinction *clear*?

        //                 // forward should decrease reactants, but increase products, which is not what this seems like.
        //                 // easy solution would just be to add another parameter to this method which indicates
        //                 // the "side" that this method is modifying 
        //                 entry.setValue(action == ReactionDirection.FORWARD ? original-newVal : original+newVal);
        //             }
        //         }
        //     }

        //     // should I just refactor the hell out of this
        //     // TODO: ~~fiddle with this last, focus on making items from solutes in BasinEntity~~
        //     // TODO: need these methods anyway, so get explanations/requirements for actual reactions,
        //     // and rewrite such that these methods are much clearer (and all original todo items 
        //     // are made possible to attempt without guessing what it actually means)

        //     float amt = (float)rate * vals[0];
        //     if (action == -1) amt = -amt;
        //     vals[1] += amt;
        //     if (vals[1] >= 1.0f) {
        //         inventory.set(ind, resource, inventory.getAmountAsInt(ind) + 1);
        //     } else if (vals[1] <= -1.0f) {
        //         inventory.set(ind, resource, inventory.getAmountAsInt(ind) - 1);
        //     }
        //     vals[1] %= 1.0f;
        // }
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