package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;

public abstract class AbstractTekoraRecipeBuilder implements RecipeBuilder {
    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        return null;
    }
}
