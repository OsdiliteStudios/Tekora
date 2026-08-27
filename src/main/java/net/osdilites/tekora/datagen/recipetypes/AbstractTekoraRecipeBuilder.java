package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;

public abstract class AbstractTekoraRecipeBuilder implements RecipeBuilder {
    protected final RecipeUnlockAdvancementBuilder advancementBuilder = new RecipeUnlockAdvancementBuilder();

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        advancementBuilder.unlockedBy(s, criterion);
        return this;
    }
}
