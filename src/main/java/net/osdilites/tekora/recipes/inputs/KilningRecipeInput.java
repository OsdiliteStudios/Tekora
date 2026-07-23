package net.osdilites.tekora.recipes.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public record KilningRecipeInput(List<ItemStack> inputs, List<FluidStack> fluidInputs) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return inputs.size();
    }
}
