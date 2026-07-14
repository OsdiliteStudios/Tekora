package net.osdilites.tekora.recipes.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public record KilningRecipeInput(List<ItemStack> inputs, List<FluidStack> fluidInputs, ItemStack output, int time) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return i < size() ? inputs.get(i) : ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return inputs.size();
    }
}
