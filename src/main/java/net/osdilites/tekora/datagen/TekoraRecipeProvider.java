package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
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
    private static int reactionId = 1;
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

        shapeless(RecipeCategory.MISC, TekoraItems.CINNABAR_SHARD.get(), 4)
                .requires(Items.CINNABAR)
                .unlockedBy("has_cinnabar", has(Items.CINNABAR))
                .save(output);

        shaped(RecipeCategory.MISC, Items.CINNABAR)
                .pattern("CC")
                .pattern("CC")
                .define('C', TekoraItems.CINNABAR_SHARD.get())
                .unlockedBy("has_cinnabar", has(Items.CINNABAR))
                .save(output);

        shaped(RecipeCategory.MISC, TekoraBlocks.FIRE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', TekoraItems.FIRE_BRICK.get())
                .unlockedBy("has_fire_brick", has(TekoraItems.FIRE_BRICK.get()))
                .save(output);

        shapeless(RecipeCategory.MISC, TekoraItems.FIRE_CLAY_BALL.get(), 2)
                .requires(Items.CLAY_BALL)
                .requires(TekoraItems.BAUXITE.get())
                .unlockedBy("has_bauxite", has(TekoraItems.BAUXITE.get()))
                .save(output);

        smeltingResultFromBase(TekoraItems.FIRE_BRICK.get(), TekoraItems.FIRE_CLAY_BALL.get());

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.MAGNESIUM), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.CARBONATE), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.of(TekoraItems.MAGNESIUM_CARBONATE.get()), 1, 1)),
                new Catalyst(ChemicalIngredient.liquidSolute(SoluteKey.SULFATE), 10000),
                FluidIngredient.of(Fluids.WATER),
                30540, 260.7, 2.51E8, 75540).save(output);

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.of(TekoraItems.SODIUM_CHLORIDE.get()), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.SODIUM), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.CHLORIDE), 1, 1)),
                Catalyst.NULL_CATALYST,
                FluidIngredient.of(Fluids.WATER),
                3880, 43.0, 1E9, 15000).save(output);

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.AMMONIUM), 3, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.PHOSPHATE), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.of(TekoraItems.AMMONIUM_PHOSPHATE.get()), 1, 1)),
                Catalyst.NULL_CATALYST,
                FluidIngredient.of(Fluids.WATER),
                5400, 2.0, 1E9, 12000).save(output);

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.SODIUM), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.HYDROXIDE), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.of(TekoraItems.SODIUM_HYDROXIDE.get()), 1, 1)),
                Catalyst.NULL_CATALYST,
                FluidIngredient.of(Fluids.WATER),
                44500, 23.0, 1E9, 12000).save(output);

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.BISULFATE), 1, 1),
                        new Chemical(ChemicalIngredient.of(Fluids.WATER), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.HYDROXIDE), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.SULFURIC_ACID), 1, 1)),
                Catalyst.NULL_CATALYST,
                FluidIngredient.of(Fluids.WATER),
                55840, 80.7, 1E10, 5000).save(output);

        ReactionRecipeBuilder.createReactionRecipe(getReactionId(),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.SULFATE), 1, 1),
                        new Chemical(ChemicalIngredient.of(Fluids.WATER), 1, 1)),
                List.of(new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.HYDROXIDE), 1, 1),
                        new Chemical(ChemicalIngredient.liquidSolute(SoluteKey.BISULFATE), 1, 1)),
                Catalyst.NULL_CATALYST,
                FluidIngredient.of(Fluids.WATER),
                30730, 128, 1E9, 8000).save(output);

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

    public static int getReactionId() {
        return reactionId++;
    }
}
