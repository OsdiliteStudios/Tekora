package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public abstract class DepotRecipeBuilder extends AbstractTekoraRecipeBuilder {
    protected final RecipeCategory category;
    protected final Ingredient ingredient;
    protected final ItemStackTemplate result;
    protected final double cutTorque;
    protected final double ratedVelocity;

    protected DepotRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        this.category = category;
        this.ingredient = ingredient;
        this.result = result;
        this.cutTorque = cutTorque;
        this.ratedVelocity = ratedVelocity;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(result);
    }
}
