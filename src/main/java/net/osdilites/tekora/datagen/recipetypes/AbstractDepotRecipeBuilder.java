package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;

public abstract class AbstractDepotRecipeBuilder extends AbstractTekoraRecipeBuilder {
    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
    }
}
