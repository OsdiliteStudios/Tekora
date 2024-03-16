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

public class PulverizingRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final float resultChance;
    private final ItemStack residue;
    private final float residueChance;
    private final Ingredient ingredient;
    private final int time;
    private final int ingCount;

    private PulverizingRecipeBuilder(ItemStack pResult, float pResultChance, ItemStack pResidue, float pResidueChance,
                                     Ingredient pIngredient, int pIngCount, int pTime) {
        this.result = pResult;
        this.resultChance = pResultChance;
        this.residue = pResidue;
        this.residueChance = pResidueChance;
        this.ingredient = pIngredient;
        this.ingCount = pIngCount;
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
        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.resultChance, this.residue, this.residueChance,
                this.ingredient, this.ingCount, this.time));
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, Ingredient pIng) {
        return create(pResult, 0, null, 0, pIng, 1, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, Ingredient pIng, int pIngCount) {
        return create(pResult, 0, null, 0, pIng, pIngCount, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, Ingredient pIng, int pIngCount, int pTime) {
        return create(pResult, 0, null, 0, pIng, pIngCount, pTime);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, Ingredient pIng) {
        return create(pResult, pResultChance, null, 0, pIng, 1, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, Ingredient pIng, int pIngCount) {
        return create(pResult, pResultChance, null, 0, pIng, pIngCount, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, Ingredient pIng, int pIngCount,
                                                   int pTime) {
        return create(pResult, pResultChance, null, 0, pIng, pIngCount, pTime);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, ItemStack pResidue, float pResidueChance,
                                                  Ingredient pIng) {
        return create(pResult, pResultChance, pResidue, pResidueChance, pIng, 1, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, ItemStack pResidue, float pResidueChance,
                                                   Ingredient pIng, int pIngCount) {
        return create(pResult, pResultChance, pResidue, pResidueChance, pIng, pIngCount, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, ItemStack pResidue, float pResidueChance,
                                                  Ingredient pIng) {
        return create(pResult, 0, pResidue, pResidueChance, pIng, 1, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, ItemStack pResidue, float pResidueChance,
                                                   Ingredient pIng, int pIngCount) {
        return create(pResult, 0, pResidue, pResidueChance, pIng, pIngCount, 200);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, ItemStack pResidue, float pResidueChance,
                                                   Ingredient pIng, int pIngCount, int pTime) {
        return create(pResult, 0, pResidue, pResidueChance, pIng, pIngCount, pTime);
    }

    public static PulverizingRecipeBuilder create(ItemStack pResult, float pResultChance, ItemStack pResidue, float pResidueChance,
                                                  Ingredient pIng, int pIngCount, int pTime) {
        return new PulverizingRecipeBuilder(pResult, pResultChance, pResidue, pResidueChance, pIng, pIngCount, pTime);
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final ItemStack result;
        private final float resultChance;
        private final ItemStack residue;
        private final float residueChance;
        private final Ingredient ingredient;
        private final int time;
        private final int ingCount;

        public Result(ResourceLocation pId, ItemStack pResult, float pResultChance, ItemStack pResidue, float pResidueChance,
                      Ingredient pIngredient, int pIngCount, int pTime) {
            this.id = pId;
            this.result = pResult;
            this.resultChance = pResultChance;
            this.residue = pResidue;
            this.residueChance = pResidueChance;
            this.ingredient = pIngredient;
            this.ingCount = pIngCount;
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
            result.addProperty("chance", this.resultChance);

            pJson.add("output", result);

            if (this.residue != null && !this.residue.equals(ItemStack.EMPTY)) {
                JsonObject residue = new JsonObject();
                residue.addProperty("item", BuiltInRegistries.ITEM.getKey(this.residue.getItem()).toString());
                int count = this.residue.getCount();
                if (count > 1)
                    residue.addProperty("count", count - 1);
                residue.addProperty("chance", this.residueChance);
                pJson.add("residue", residue);
            }
            pJson.addProperty("time", this.time);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return TekoraRecipes.PULVERIZATION_SERIALIZER.get();
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
