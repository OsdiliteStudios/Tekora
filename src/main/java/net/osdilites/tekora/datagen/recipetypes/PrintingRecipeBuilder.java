package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.osdilites.tekora.recipes.PrintingRecipe;

public class PrintingRecipeBuilder extends DepotRecipeBuilder {
    protected final int experience;

    protected PrintingRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        super(category, ingredient, result, cutTorque, ratedVelocity);
        this.experience = 0; // TODO, maybe have experience for printing in the future
    }

    public static PrintingRecipeBuilder printingBuilder(RecipeCategory category, Ingredient ingredient, Item result, double cutTorque, double ratedVelocity) {
        return new PrintingRecipeBuilder(category, ingredient, new ItemStackTemplate(result), cutTorque, ratedVelocity);
    }

    @Override 
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> id) {
        PrintingRecipe recipe = new PrintingRecipe(ingredient, result, experience, cutTorque, ratedVelocity);
        output.accept(id, recipe, this.advancementBuilder.build(output, id, this.category));
    }

    public void save(RecipeOutput output) {
        save(output, defaultId());
    }
}
