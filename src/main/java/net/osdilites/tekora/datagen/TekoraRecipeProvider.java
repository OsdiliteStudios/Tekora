package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.datagen.recipetypes.PrintingRecipeBuilder;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.item.TekoraItems;

import java.util.Optional;
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

        buildBannerPrintingRecipes();

        PrintingRecipeBuilder.printingBuilder(RecipeCategory.MISC, Ingredient.of(Items.NAME_TAG), Items.NAME_TAG, 4.0, 0.2)
            .unlockedBy("has_name_tag", has(Items.NAME_TAG))
            .save(output, "tekora:printing/name_tag");

        PrintingRecipeBuilder.printingBuilder(RecipeCategory.MISC, Ingredient.of(Items.BOOK), Items.WRITTEN_BOOK, 4.0, 0.2)
            .unlockedBy("has_book", has(Items.BOOK))
            .save(output, "tekora:printing/print_book");

        PrintingRecipeBuilder.printingBuilder(RecipeCategory.MISC, Ingredient.of(Items.WRITABLE_BOOK), Items.WRITTEN_BOOK, 4.0, 0.2)
            .unlockedBy("has_writable_book", has(Items.WRITABLE_BOOK))
            .save(output, "tekora:printing/copy_book");

        //PressingRecipeBuilder.pressingBuilder(RecipeCategory.TOOLS, Ingredient.of(TekoraItems.STEEL_INGOT.get()), TekoraItems.STEEL_PLATE.get(), 1, 1)
        //        .save(output, "tekora:pressing/steel_plate"); // todo, change the cuttorque and ratedvelocity values in the future
    }

    /// Does not throw on failed lookups because some silly banner recipes should not stop runData
    private void buildBannerPrintingRecipes() {
        var itemRegistry = registries.lookup(Registries.ITEM);
        if (itemRegistry.isEmpty()) {
            // ...
            return;
        }
        Optional<Named<Item>> bannerTagSet = itemRegistry.get().get(ItemTags.BANNERS);
        if (bannerTagSet.isPresent()) {
            // iteration is a hack, won't work for modded banners
            for (Item clr : Items.BANNER.asList()) {
                Identifier id = BuiltInRegistries.ITEM.getKey(clr);
                String name = id.getPath();
                PrintingRecipeBuilder.printingBuilder(RecipeCategory.DECORATIONS, Ingredient.of(bannerTagSet.get()), clr, 4.0, 0.2)
                    .unlockedBy("has_banners", has(ItemTags.BANNERS))
                    .save(output, "tekora:printing/"+name);
            }
        }

        // this is so disappointingly jank
        BuiltInRegistries.ITEM.entrySet().stream()
            // bad way to filter for banner pattern items. ideally would iterate by specific tag,
            // but components and holderSets for given tag are not initialized during datagen
            .filter(entry -> entry.getKey().identifier().getPath().endsWith("_banner_pattern"))
            .forEach(entry -> {
                Identifier id = entry.getKey().identifier();
                String name = id.getPath();
                Item pattern = entry.getValue();
                PrintingRecipeBuilder.printingBuilder(RecipeCategory.MISC, Ingredient.of(Items.PAPER), pattern, 4.0, 0.2)
                    .unlockedBy("has_printer", has(TekoraItems.INK_PRESS_SHAFT.get()))
                    .save(output, "tekora:printing/copy_"+name);
            });
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
