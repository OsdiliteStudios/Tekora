package net.osdilites.tekora.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.recipes.inputs.KilningRecipeInput;

public record KilningRecipe() implements Recipe<KilningRecipeInput> {
    @Override
    public boolean matches(KilningRecipeInput kilningRecipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(KilningRecipeInput kilningRecipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Kilning";
    }

    @Override
    public RecipeSerializer<? extends Recipe<KilningRecipeInput>> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<? extends Recipe<KilningRecipeInput>> getType() {
        return null;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }
}
