package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.datagen.recipetypes.ReactionRecipeBuilder;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;

import java.util.List;
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
        // todo, make it so that the Wrench can be used as an upgrader machineType item.
        shaped(RecipeCategory.TOOLS, TekoraItems.WRENCH.get())
                .pattern("P P")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', TekoraItems.STEEL_PLATE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_steel_plate", has(TekoraItems.STEEL_PLATE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, TekoraBlocks.DEPOT.get())
                .pattern("ICI")
                .pattern("ICI")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('C', Blocks.COBBLESTONE.asItem())
                .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
                .save(output);

        shaped(RecipeCategory.MISC, TekoraBlocks.BASIN.get())
                .pattern("C C")
                .pattern("ICI")
                .define('I', TekoraTags.Items.PLATES_STEEL)
                .define('C', Blocks.COBBLESTONE.asItem())
                .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
                .save(output);

        shaped(RecipeCategory.TOOLS, TekoraBlocks.STEEL_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', TekoraItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(TekoraItems.STEEL_INGOT.get()))
                .save(output);

        int reactionId = 1;
        ReactionRecipeBuilder.createReactionRecipe(reactionId++,
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.MAGNESIUM), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.CARBONATE), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.of(TekoraItems.MAGNESIUM_CARBONATE.get()), 1, 1)),
                new Catalyst(ChemicalIngredient.liquidSolute(SoluteKey.SULFATE), 10000),
                FluidIngredient.of(Fluids.WATER),
                30540, 260.7, 2.51E8, 75540).save(output);

        //PressingRecipeBuilder.pressingBuilder(RecipeCategory.TOOLS, Ingredient.of(TekoraItems.STEEL_INGOT.get()), TekoraItems.STEEL_PLATE.get(), 1, 1)
        //        .save(output, "tekora:pressing/steel_plate"); // todo, change the cuttorque and ratedvelocity values in the future
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
