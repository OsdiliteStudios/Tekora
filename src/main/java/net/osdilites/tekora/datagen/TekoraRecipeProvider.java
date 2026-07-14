package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.osdilites.tekora.item.TekoraItems;

import java.util.concurrent.CompletableFuture;

public class TekoraRecipeProvider extends RecipeProvider {
    public TekoraRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new TekoraRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Tekora Recipes";
        }
    }
    @Override
    protected void buildRecipes() {
        // todo, make it so that the Wrench can be used as an upgrader type item.
        shaped(RecipeCategory.TOOLS, TekoraItems.WRENCH.get())
                .pattern("P P")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', TekoraItems.STEEL_PLATE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_steel_plate", has(TekoraItems.STEEL_PLATE.get()));
    }

    private void buildGearRecipe(Item gear, Item gearPart) {
        shaped(RecipeCategory.TOOLS, gear)
                .pattern(" P ")
                .pattern("P P")
                .pattern(" P ")
                .define('P', gearPart)
                .unlockedBy("has_" + gearPart.getDescriptionId(), has(gearPart));
    }
}
