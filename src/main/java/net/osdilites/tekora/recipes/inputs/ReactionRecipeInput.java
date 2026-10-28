package net.osdilites.tekora.recipes.inputs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.fluid.ChemicalFluidType;
import net.osdilites.tekora.item.typical.CompoundItem;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;

import java.util.HashMap;
import java.util.Map;

// tekora assumes any placement in the catalyst means it is a heterogeneous catalyst,
// homogenous catalysts in Tekora will simply be placed in both reactants and products.
public record ReactionRecipeInput(Map<ChemicalIngredient, Double> inputs, double availableEnergy) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return 0;
    }

    public double getFrac() {
        return 0;
    }

    // method created so that kiln furnaces and future Tekora BlockEntities could use reaction recipes
    /**
     * Method that reads ingredients into hashmaps to be properly processed by the recipe input.
     * @param inventory - Entity inventory being passed to read data from
     * @param tank - Entity tank being passed to read data from
     * @param ingredients - Input that has values read into them
     * @param liquidSolutes - Input that has volumes read into them
     * @return The total volume of the tank
     * */
    public static float fromReadingHandlersGetVolume(HashMap<ChemicalIngredient, Double> ingredients, HashMap<SoluteKey, Double> liquidSolutes, ItemStacksResourceHandler inventory, FluidStacksResourceHandler tank) {
        HashMap<SoluteKey, Double> solidSolutes = new HashMap<>();
        HashMap<Item, Double> items = new HashMap<>();

        for (int i = 0; i < inventory.size(); i++) {
            ItemResource resource = inventory.getResource(i);
            if (resource.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
                Solutes val = resource.getComponents().get(TekoraComponents.SOLUTES_LIST);
                if (val != null) {
                    Map<SoluteKey, Double> map = val.dataMap();
                    for (SoluteKey key : map.keySet()) {
                        double moles = map.get(key);
                        solidSolutes.put(key, solidSolutes.getOrDefault(key, 0d) + moles);
                    }
                }
            } else {
                ItemStack stack = resource.toStack();
                Item item = stack.getItem();
                if (item instanceof CompoundItem compound) {
                    double count = stack.count() * compound.getMoles();
                    items.put(item, items.getOrDefault(item, 0.0) + count);
                }
            }
        }

        HashMap<Fluid, Double> fluids = new HashMap<>();
        // note, if we support gases, they would be added in the liquidSolutes array
        int volume = 0;
        for (int i = 0; i < tank.size(); i++) {
            FluidResource fluidResource = tank.getResource(i);
            Fluid fluid = fluidResource.getFluid();
            if (fluid.getFluidType() instanceof ChemicalFluidType fluidType) {
                double amt = tank.getAmountAsInt(i) * fluidType.getMolarVolume();
                fluids.put(fluid, fluids.getOrDefault(fluid, 0.0) + amt);
            }
            volume += tank.getAmountAsInt(i);
            if (fluidResource.getComponents().has(TekoraComponents.SOLUTES_LIST)) {
                Solutes val = fluidResource.getComponents().get(TekoraComponents.SOLUTES_LIST);
                if (val != null) {
                    Map<SoluteKey, Double> map = val.dataMap();
                    for (SoluteKey key : map.keySet()) {
                        double moles = map.get(key);
                        liquidSolutes.put(key, liquidSolutes.getOrDefault(key, 0d) + moles);
                    }
                }
            }
        }

        // note, the reason we are starting with 4 hashmaps before merging into one is because
        // using equals() on any ingredient classes might be unsafe.
        for (var pair : items.entrySet()) {
            ingredients.put(ChemicalIngredient.of(new ItemStack(pair.getKey())), pair.getValue());
        }
        for (var pair : fluids.entrySet()) {
            ingredients.put(ChemicalIngredient.of(pair.getKey()), pair.getValue());
        }
        for (var pair : solidSolutes.entrySet()) {
            ingredients.put(ChemicalIngredient.solidSolute(pair.getKey()), pair.getValue());
        }
        for (var pair : liquidSolutes.entrySet()) {
            ingredients.put(ChemicalIngredient.liquidSolute(pair.getKey()), pair.getValue());
        }
        return volume;
    }
}