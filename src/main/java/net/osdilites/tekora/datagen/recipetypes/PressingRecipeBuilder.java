package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.osdilites.tekora.recipes.PressingRecipe;

public class PressingRecipeBuilder extends AbstractDepotRecipeBuilder {
    public PressingRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStackTemplate result, double cutTorque, double ratedVelocity) {
        super(category, ingredient, result, cutTorque, ratedVelocity);
    }

    public static PressingRecipeBuilder pressingBuilder(RecipeCategory category, Ingredient ingredient, ItemLike result, int count, double cutTorque, double ratedVelocity) {
        return new PressingRecipeBuilder(category, ingredient, new ItemStackTemplate(result.asItem(), count), cutTorque, ratedVelocity);
    }

    public static PressingRecipeBuilder pressingBuilder(RecipeCategory category, Ingredient ingredient, ItemLike result, double cutTorque, double ratedVelocity) {
        return new PressingRecipeBuilder(category, ingredient, new ItemStackTemplate(result.asItem()), cutTorque, ratedVelocity);
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> id) {
        PressingRecipe recipe = new PressingRecipe(this.ingredient, this.result, this.cutTorque, this.ratedVelocity);
        output.accept(id, recipe, this.advancementBuilder.build(output, id, this.category));
    }
}
