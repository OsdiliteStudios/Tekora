package net.osdilites.tekora.recipes.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record DeployingRecipeInput(ItemStack input, ItemStack deployed, int exp) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return i == 1 ? deployed : input;
    }

    @Override
    public int size() {
        return 2;
    }
}
