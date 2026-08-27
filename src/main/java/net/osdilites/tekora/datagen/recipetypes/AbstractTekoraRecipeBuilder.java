package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import org.jspecify.annotations.Nullable;

public abstract class AbstractTekoraRecipeBuilder implements RecipeBuilder {
    protected final RecipeUnlockAdvancementBuilder advancementBuilder = new RecipeUnlockAdvancementBuilder();
    protected @Nullable String group;

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        advancementBuilder.unlockedBy(s, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        this.group = s;
        return this;
    }
}
