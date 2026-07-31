package net.osdilites.tekora.recipes;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public interface TekoraDepotRecipe extends TekoraMechanicalRecipe<DepotRecipeInput> {
    @Override
    default boolean matches(DepotRecipeInput recipeInput, Level level) {
        return input().test(recipeInput.getItem(0));
    }

    @Override
    default boolean showNotification() {
        return false;
    }

    Ingredient input();
}
