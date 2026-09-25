package net.osdilites.tekora.recipes;

import net.minecraft.world.item.crafting.*;

public interface TekoraGeneralRecipe<T extends RecipeInput> extends Recipe<T> {
    @Override
    default RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    default PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }
}
