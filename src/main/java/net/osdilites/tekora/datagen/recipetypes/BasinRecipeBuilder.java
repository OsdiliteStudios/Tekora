package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.BasinRecipe;
import net.osdilites.tekora.recipes.TekoraMechanicalRecipe;

import java.util.List;

public class BasinRecipeBuilder extends AbstractTekoraRecipeBuilder {
    private final RecipeCategory category;
    private final List<FluidIngredient> fluids;
    private final List<Ingredient> items;
    private final FluidStackTemplate fluidOutput;
    private final ItemStackTemplate itemOutput;
    private final String machineType;
    private final double cutTorque;
    private final double ratedVelocity;

    protected BasinRecipeBuilder(RecipeCategory category, List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, String machineType, double cutTorque, double ratedVelocity) {
        this.category = category;
        this.fluids = fluids;
        this.items = items;
        this.fluidOutput = fluidOutput;
        this.itemOutput = itemOutput;
        this.machineType = machineType;
        this.cutTorque = cutTorque;
        this.ratedVelocity = ratedVelocity;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(itemOutput); // todo, modify the name in case of conflicts
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        BasinRecipe recipe = new BasinRecipe(fluids, items, fluidOutput, itemOutput, machineType, cutTorque, ratedVelocity);
        recipeOutput.accept(resourceKey, recipe, null);
    }

    public static BasinRecipeBuilder createMacerationRecipe(RecipeCategory category, List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, double cutTorque, double ratedVelocity) {
        return new BasinRecipeBuilder(category, fluids, items, fluidOutput, itemOutput, TekoraMechanicalRecipe.CRUSHER, cutTorque, ratedVelocity);
    }

    public static BasinRecipeBuilder createMixerRecipe(RecipeCategory category, List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, double cutTorque, double ratedVelocity) {
        return new BasinRecipeBuilder(category, fluids, items, fluidOutput, itemOutput, TekoraMechanicalRecipe.MIXER, cutTorque, ratedVelocity);
    }

    public static BasinRecipeBuilder createCompactingRecipe(RecipeCategory category, List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, double cutTorque, double ratedVelocity) {
        return new BasinRecipeBuilder(category, fluids, items, fluidOutput, itemOutput, TekoraMechanicalRecipe.PRINTER, cutTorque, ratedVelocity);
    }
}
