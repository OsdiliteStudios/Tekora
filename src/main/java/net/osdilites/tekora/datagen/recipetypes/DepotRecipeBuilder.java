package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.osdilites.tekora.recipes.DepotRecipe;
import net.osdilites.tekora.recipes.TekoraMechanicalRecipe;

public class DepotRecipeBuilder extends AbstractTekoraRecipeBuilder {
    private final RecipeCategory category;
    private final Ingredient ingredient;
    private final ItemStackTemplate result;
    private final String machineType;
    private final double cutTorque;
    private final double ratedVelocity;

    protected DepotRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, String machineType, double cutTorque, double ratedVelocity) {
        this.category = category;
        this.ingredient = ingredient;
        this.result = result;
        this.machineType = machineType;
        this.cutTorque = cutTorque;
        this.ratedVelocity = ratedVelocity;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(result);
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        DepotRecipe recipe = new DepotRecipe(ingredient, result, machineType, cutTorque, ratedVelocity);
        recipeOutput.accept(resourceKey, recipe, null);
    }

    public static DepotRecipeBuilder createCrusherRecipe(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        return new DepotRecipeBuilder(category,ingredient, result, TekoraMechanicalRecipe.CRUSHER, cutTorque, ratedVelocity);
    }

    public static DepotRecipeBuilder createPressRecipe(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        return new DepotRecipeBuilder(category,ingredient, result, TekoraMechanicalRecipe.PRESS, cutTorque, ratedVelocity);
    }

    public static DepotRecipeBuilder createCuttingRecipe(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        return new DepotRecipeBuilder(category,ingredient, result, TekoraMechanicalRecipe.CUTTER, cutTorque, ratedVelocity);
    }
}
