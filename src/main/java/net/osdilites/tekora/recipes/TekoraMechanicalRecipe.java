package net.osdilites.tekora.recipes;

import net.minecraft.world.item.crafting.*;

public interface TekoraMechanicalRecipe<T extends RecipeInput> extends Recipe<T> {
    String PRESS = "press";
    String MIXER = "mixer";
    String CUTTER = "cutter";
    String CRUSHER = "crusher";
    String SPLITTER = "splitter"; // magnetic separation

    double cutTorque();
    double ratedVelocity();

    @Override
    default RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    default PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }
}
