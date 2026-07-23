package net.osdilites.tekora.recipes;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;

public interface TekoraMechanicalRecipe<T extends RecipeInput> extends Recipe<T> {
    double cutTorque();
    double ratedVelocity();
}
