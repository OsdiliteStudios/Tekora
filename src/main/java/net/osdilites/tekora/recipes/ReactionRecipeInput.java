package net.osdilites.tekora.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public record ReactionRecipeInput(List<Chemical> reactants, List<Chemical> products, ItemStack catalyst) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
