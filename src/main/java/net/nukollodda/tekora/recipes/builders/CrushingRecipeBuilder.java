package net.nukollodda.tekora.recipes.builders;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.nukollodda.tekora.recipes.types.CrushingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CrushingRecipeBuilder  implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private String group;
    private final RecipeSerializer<CrushingRecipe> serializer;
    private CrushingRecipeBuilder(RecipeCategory pCategory, Item pResult, Ingredient pIngredient, float pXp, int pTime,
                                  RecipeSerializer<CrushingRecipe> pSerializer) {
        this.category = pCategory;
        this.result = pResult;
        this.ingredient = pIngredient;
        this.experience = pXp;
        this.cookingTime = pTime;
        this.serializer = pSerializer;
    }



    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        return null;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return null;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {

    }
}
