package net.nukollodda.tekora.recipes.builders;

import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.nukollodda.tekora.recipes.TekoraRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CompressionRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final Ingredient ingredient;
    private final int time;
    private final int ingCnt;
    private CompressionRecipeBuilder(ItemStack pResult, Ingredient pIngredient, int pIngCount, int pTime) {
        this.result = pResult;
        this.ingredient = pIngredient;
        this.ingCnt = pIngCount;
        this.time = pTime;
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
        return result.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.ingredient, this.ingCnt, this.result, this.time));
    }

    public static CompressionRecipeBuilder timed(ItemStack pResult, Ingredient pIng, int pTime) {
        return new CompressionRecipeBuilder(pResult, pIng, 1, pTime);
    }

    public static CompressionRecipeBuilder timed(ItemStack pResult, Ingredient pIng, int pIngCount, int pTime) {
        return new CompressionRecipeBuilder(pResult, pIng, pIngCount, pTime);
    }

    public static CompressionRecipeBuilder basic(ItemStack pResult, Ingredient pIng) {
        return new CompressionRecipeBuilder(pResult, pIng, 1, 200);
    }

    public static CompressionRecipeBuilder basic(ItemStack pResult, Ingredient pIng, int pIngCount) {
        return new CompressionRecipeBuilder(pResult, pIng, pIngCount, 200);
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient ingredient;
        private final ItemStack result;
        private final int ingCount;
        private final int time;

        public Result(ResourceLocation pId, Ingredient pIngredient, int pIngCount, ItemStack pResult, int pTime) {
            this.id = pId;
            this.ingredient = pIngredient;
            this.ingCount = pIngCount;
            this.result = pResult;
            this.time = pTime;
        }
        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonObject ing = this.ingredient.toJson().getAsJsonObject();
            ing.addProperty("count", this.ingCount);

            pJson.add("ingredient", ing);

            JsonObject result = new JsonObject();
            result.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result.getItem()).toString());
            result.addProperty("count", this.result.getCount());

            pJson.add("output", result);
            pJson.addProperty("time", this.time);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return TekoraRecipes.COMPRESSION_SERIALIZER.get();
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
