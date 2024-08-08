package net.tekoramods.tekora.recipes.builders;

import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tekoramods.tekora.recipes.types.CompressionRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class InfusionRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final Ingredient catalyst;
    private final int time;
    private final RecipeSerializer<CompressionRecipe> serializer;
    private InfusionRecipeBuilder(Item pResult, Ingredient pIngredient, Ingredient pCatalyst, int pTime,
                                  RecipeSerializer<CompressionRecipe> pSerializer) {
        this.result = pResult;
        this.ingredient = pIngredient;
        this.catalyst = pCatalyst;
        this.time = pTime;
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
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {

    }

    public class Result implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject pJson) {

        }

        @Override
        public ResourceLocation getId() {
            return null;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return null;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
