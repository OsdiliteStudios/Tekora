package net.osdilites.tekora.recipes.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;

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
}