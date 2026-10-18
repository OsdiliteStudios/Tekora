package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.item.typical.CompoundItem;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.NonNull;

import java.util.*;

public final class ReactionRecipe implements TekoraGeneralRecipe<ReactionRecipeInput> {
    private final List<Chemical> reactants;
    private final List<Chemical> products;
    private final Catalyst catalyst;
    private final FluidIngredient solvent;
    private final double deltaEnthalpy;
    private final double deltaEntropy;
    private final double freqFactor;
    private final double activationEnergy;

    private final Map<SoluteKey, Integer> reactCoeffs;
    private final Map<SoluteKey, Integer> prodCoeffs;
    private final Map<SoluteKey, Integer> reactOrders;

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

        double equ = 1;
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

    // JSON structure
    // reactants (list)
    //  - name (string)
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // products (list)
    //  - name
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // freq_factor (float)
    // activation_energy (float)

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
            double reqEnergy = activationEnergy;
            boolean hasAllOutput = true;
            boolean hasAllInput = true;
            double q = 1;

            Set<ChemicalIngredient> ingredients = input.inputs().keySet();
            for (Chemical chemical : reactants) {
                double c = chemical.coefficient();
                for (ChemicalIngredient ing : ingredients) {
                    if (ing.equals(chemical.chemical())) {
                        q *= Math.pow(input.inputs().get(ing), c);
                    } else {
                        hasAllInput = false;
                        q = 0;
                        break;
                    }
                }
            }
            for (Chemical chemical : products) {
                double c = chemical.coefficient();
                for (ChemicalIngredient ing : ingredients) {
                    if (ing.equals(chemical.chemical())) {
                        q /= Math.pow(input.inputs().get(ing), c);
                    } else {
                        hasAllOutput = false;
                        if (q == 0) return false;
                        else {
                            q = Double.POSITIVE_INFINITY;
                        }
                        break;
                    }
                }
            }


            if (hasAllOutput && !hasAllInput) {
                reqEnergy += deltaEnthalpy;
                return reqEnergy <= input.availableEnergy();
            }
        }
        return false;
    }

    @Override
    public ItemStack assemble(ReactionRecipeInput reactionRecipeInput) {
        return null;
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
    public float getRateTicks(HashMap<SoluteKey, Double> ingredients, double temperature) {
        float rateTicks = (float)freqFactor * (float)Math.exp(-activationEnergy / (temperature * UtilFunctions.IDEAL_GAS_CONST)) / 20;
        for (var entry : ingredients.entrySet()) {
            if (reactOrders.containsKey(entry.getKey())) {
                rateTicks = rateTicks * (float)Math.pow(entry.getValue(), reactOrders.get(entry.getKey()));
            }
        }
        return rateTicks;
    }

    private static void fillBasedOnData(List<Chemical> chemicals, Map<Integer, float[]> items, ItemStacksResourceHandler inventory, Map<Integer, float[]> fluids, FluidStacksResourceHandler tank) {
        for (Chemical chemical : chemicals) {
            for (int i = 0; i < inventory.size(); i++) {
                ItemResource resource = inventory.getResource(i);
                if (resource.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
                    Solutes val = resource.getComponents().get(TekoraComponents.SOLUTES_LIST);
                    if (val != null) {
                        Map<SoluteKey, Double> map = val.dataMap();
                        float[] list = new float[map.size()];
                        int ind = 0;
                        for (SoluteKey key : map.keySet()) {
                            list[ind++] = chemical.chemical().test(key) ? chemical.coefficient() : -1.0f;
                        }
                        items.put(i, list);
                    }
                } else if (chemical.chemical().test(resource.toStack())) {
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

    public static void modifyCrafterInventory(@NonNull Map<Integer, float[]> itemReactants, ItemStacksResourceHandler inventory, double rate, int action) {
        for (Integer ind : itemReactants.keySet()) {
            boolean hasSolutes = ind < 0;
            float[] vals = itemReactants.get(hasSolutes ? -ind - 1 : ind);
            ItemResource resource = inventory.getResource(ind);
            if (hasSolutes && resource.has(TekoraComponents.SOLUTES_LIST)) {
                int mapInd = 0;
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

    public static void modifyCrafterTank(@NonNull Map<Integer, float[]> fluidReactants, FluidStacksResourceHandler tank, double rate, int action) {
        for (Integer ind : fluidReactants.keySet()) {
            boolean hasSolutes = ind < 0;
            float[] vals = fluidReactants.get(hasSolutes ? -ind - 1 : ind);
            FluidResource resource = tank.getResource(ind);
            if (hasSolutes && resource.has(TekoraComponents.SOLUTES_LIST)) {
                int mapInd = 0;
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