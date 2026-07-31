package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.Nullable;

public class PressingRecipeBuilder extends AbstractDepotRecipeBuilder {
    @Override
    public RecipeBuilder group(@Nullable String s) {
        return null;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return null;
    }
}
