package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.item.TekoraItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TekoraRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public TekoraRecipeProvider(HolderLookup.Provider pRegistries, RecipeOutput pOutput) {
        super(pRegistries, pOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
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
        nineBlockStorageRecipes(TekoraItems.ALUMINUM_INGOT.get(), TekoraTags.Items.ALUMINUM_BLOCK);
        nineBlockStorageRecipes(TekoraItems.BISMUTH_INGOT.get(), TekoraTags.Items.BISMUTH_BLOCK);
        nineBlockStorageRecipes(TekoraItems.COBALT_INGOT.get(), TekoraTags.Items.COBALT_BLOCK);
        nineBlockStorageRecipes(TekoraItems.LEAD_INGOT.get(), TekoraTags.Items.LEAD_BLOCK);
        nineBlockStorageRecipes(TekoraItems.MAGNESIUM_INGOT.get(), TekoraTags.Items.MAGNESIUM_BLOCK);
        nineBlockStorageRecipes(TekoraItems.MANGANESE_INGOT.get(), TekoraTags.Items.MANGANESE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.MOLYBDENUM_INGOT.get(), TekoraTags.Items.MOLYBDENUM_BLOCK);
        nineBlockStorageRecipes(TekoraItems.NICKEL_INGOT.get(), TekoraTags.Items.NICKEL_BLOCK);
        nineBlockStorageRecipes(TekoraItems.PLATINUM_INGOT.get(), TekoraTags.Items.PLATINUM_BLOCK);
        nineBlockStorageRecipes(TekoraItems.SILVER_INGOT.get(), TekoraTags.Items.SILVER_BLOCK);
        nineBlockStorageRecipes(TekoraItems.TIN_INGOT.get(), TekoraTags.Items.TIN_BLOCK);
        nineBlockStorageRecipes(TekoraItems.TUNGSTEN_INGOT.get(), TekoraTags.Items.TUNGSTEN_BLOCK);
        nineBlockStorageRecipes(TekoraItems.ZINC_INGOT.get(), TekoraTags.Items.ZINC_BLOCK);

        nineBlockStorageRecipes(TekoraItems.AQUAMARINE.get(), TekoraTags.Items.AQUAMARINE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.BAUXITE.get(), TekoraTags.Items.BAUXITE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.CINNABAR.get(), TekoraTags.Items.CINNABAR_BLOCK);
        nineBlockStorageRecipes(TekoraItems.DOLOMITE.get(), TekoraTags.Items.DOLOMITE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.FLUORITE.get(), TekoraTags.Items.FLUORITE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.HALITE.get(), TekoraTags.Items.HALITE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RUBY.get(), TekoraTags.Items.RUBY_BLOCK);
        nineBlockStorageRecipes(TekoraItems.SAPPHIRE.get(), TekoraTags.Items.SAPPHIRE_BLOCK);
        nineBlockStorageRecipes(TekoraItems.WOLFRAMITE.get(), TekoraTags.Items.WOLFRAMITE_BLOCK);

        nineBlockStorageRecipes(TekoraItems.RAW_LEAD.get(), TekoraTags.Items.RAW_LEAD_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RAW_NICKEL.get(), TekoraTags.Items.RAW_NICKEL_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RAW_SILVER.get(), TekoraTags.Items.RAW_SILVER_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RAW_PLATINUM.get(), TekoraTags.Items.RAW_PLATINUM_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RAW_TIN.get(), TekoraTags.Items.RAW_TIN_BLOCK);
        nineBlockStorageRecipes(TekoraItems.RAW_ZINC.get(), TekoraTags.Items.RAW_ZINC_BLOCK);


        storageBlockRecipe(TekoraBlocks.ALUMINUM_BLOCK.get(), TekoraTags.Items.ALUMINUM_INGOT);
        storageBlockRecipe(TekoraBlocks.BISMUTH_BLOCK.get(), TekoraTags.Items.BISMUTH_INGOT);
        storageBlockRecipe(TekoraBlocks.COBALT_BLOCK.get(), TekoraTags.Items.COBALT_INGOT);
        storageBlockRecipe(TekoraBlocks.LEAD_BLOCK.get(), TekoraTags.Items.LEAD_INGOT);
        storageBlockRecipe(TekoraBlocks.MAGNESIUM_BLOCK.get(), TekoraTags.Items.MAGNESIUM_INGOT);
        storageBlockRecipe(TekoraBlocks.MANGANESE_BLOCK.get(), TekoraTags.Items.MANGANESE_INGOT);
        storageBlockRecipe(TekoraBlocks.MOLYBDENUM_BLOCK.get(), TekoraTags.Items.MOLYBDENUM_INGOT);
        storageBlockRecipe(TekoraBlocks.NICKEL_BLOCK.get(), TekoraTags.Items.NICKEL_INGOT);
        storageBlockRecipe(TekoraBlocks.PLATINUM_BLOCK.get(), TekoraTags.Items.PLATINUM_INGOT);
        storageBlockRecipe(TekoraBlocks.SILVER_BLOCK.get(), TekoraTags.Items.SILVER_INGOT);
        storageBlockRecipe(TekoraBlocks.TIN_BLOCK.get(), TekoraTags.Items.TIN_INGOT);
        storageBlockRecipe(TekoraBlocks.TUNGSTEN_BLOCK.get(), TekoraTags.Items.TUNGSTEN_INGOT);
        storageBlockRecipe(TekoraBlocks.ZINC_BLOCK.get(), TekoraTags.Items.ZINC_INGOT);

        storageBlockRecipe(TekoraBlocks.AQUAMARINE_BLOCK.get(), TekoraTags.Items.AQUAMARINE_GEM);
        storageBlockRecipe(TekoraBlocks.BAUXITE_BLOCK.get(), TekoraTags.Items.BAUXITE_GEM);
        storageBlockRecipe(TekoraBlocks.CINNABAR_BLOCK.get(), TekoraTags.Items.CINNABAR_GEM);
//        storageBlockRecipe(TekoraBlocks.DOLOMITE_BLOCK.get(), TekoraTags.Items.DOLOMITE_GEM);
//        storageBlockRecipe(TekoraBlocks.FLUORITE_BLOCK.get(), TekoraTags.Items.FLUORITE_GEM);
        storageBlockRecipe(TekoraBlocks.HALITE_BLOCK.get(), TekoraTags.Items.HALITE_GEM);
        storageBlockRecipe(TekoraBlocks.RUBY_BLOCK.get(), TekoraTags.Items.RUBY_GEM);
        storageBlockRecipe(TekoraBlocks.SAPPHIRE_BLOCK.get(), TekoraTags.Items.SAPPHIRE_GEM);
        storageBlockRecipe(TekoraBlocks.WOLFRAMITE_BLOCK.get(), TekoraTags.Items.WOLFRAMITE_GEM);

        storageBlockRecipe(TekoraBlocks.RAW_LEAD_BLOCK.get(), TekoraTags.Items.RAW_LEAD);
        storageBlockRecipe(TekoraBlocks.RAW_NICKEL_BLOCK.get(), TekoraTags.Items.RAW_NICKEL);
        storageBlockRecipe(TekoraBlocks.RAW_SILVER_BLOCK.get(), TekoraTags.Items.RAW_SILVER);
        storageBlockRecipe(TekoraBlocks.RAW_PLATINUM_BLOCK.get(), TekoraTags.Items.RAW_PLATINUM);
        storageBlockRecipe(TekoraBlocks.RAW_TIN_BLOCK.get(), TekoraTags.Items.RAW_TIN);
        storageBlockRecipe(TekoraBlocks.RAW_ZINC_BLOCK.get(), TekoraTags.Items.RAW_ZINC);

        oreBlasting(TekoraTags.Items.RAW_LEAD, TekoraItems.LEAD_INGOT.get());
        oreBlasting(TekoraTags.Items.RAW_NICKEL, TekoraItems.NICKEL_INGOT.get());
        oreBlasting(TekoraTags.Items.RAW_PLATINUM, TekoraItems.PLATINUM_INGOT.get());
        oreBlasting(TekoraTags.Items.RAW_SILVER, TekoraItems.SILVER_INGOT.get());
        oreBlasting(TekoraTags.Items.RAW_TIN, TekoraItems.TIN_INGOT.get());
        oreBlasting(TekoraTags.Items.RAW_ZINC, TekoraItems.ZINC_INGOT.get());


        shapeless(RecipeCategory.MISC, TekoraItems.INFUSED_CLAY.get(), 4)
                .requires(Items.CLAY_BALL, 2).requires(TekoraItems.BAUXITE.get(), 2).group("infused_clay")
                .unlockedBy(getHasName(Items.CLAY), has(Items.CLAY))
                .save(output,Tekora.MODID + ":infused_clay_recipe_1");


        shapeless(RecipeCategory.MISC, TekoraBlocks.FIREBRICKS.get(), 1)
                .requires(TekoraItems.FIRE_BRICK.get(), 4).group("firebricks")
                .unlockedBy(getHasName(TekoraItems.FIRE_BRICK.get()), has(TekoraItems.FIRE_BRICK.get()))
                .save(output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TekoraItems.INFUSED_CLAY.get()), RecipeCategory.MISC,
                        TekoraItems.FIRE_BRICK.get(), 1, 200)
                .group("fire_brick").unlockedBy(getHasName(TekoraItems.INFUSED_CLAY.get()), has(TekoraItems.INFUSED_CLAY.get()))
                .save(output,
                        Tekora.MODID + ":fire_brick_from_smelting_infused_clay");

        cogwheelRecipe(TekoraBlocks.SHAFT.get(), TekoraTags.Items.PLANKS, TekoraTags.Items.SLABS_WOODEN, TekoraBlocks.WOODEN_COGWHEEL.get());
        shaftRecipe(TekoraTags.Items.STEEL_INGOT, TekoraBlocks.SHAFT.get());
    }
    
    protected void cogwheelRecipe(ItemLike pShaft, TagKey<Item> pMaterial, TagKey<Item> pHalfMaterial, ItemLike pResult) {
        shaped(RecipeCategory.MISC, pResult)
                .pattern("010")
                .pattern("121")
                .pattern("010")
                .define('0', pHalfMaterial)
                .define('1', pMaterial)
                .define('2', pShaft)
                .unlockedBy(getHasName(pShaft), has(pShaft))
                .save(output);
    }

    protected void shaftRecipe(TagKey<Item> pMaterial, ItemLike pResult) {
//        ItemLike item = Ingredient.of(pMaterial).getItems()[0].getItem();
//        shaped(RecipeCategory.MISC, pResult, 5)
//                .pattern("0")
//                .pattern("0")
//                .pattern("0")
//                .define('0', pMaterial)
//                .unlockedBy(getHasName(item), has(item))
//                .save(output);
    }

    protected void oreBlasting(ItemLike pIngredients, ItemLike pResult) {
        oreBlasting(List.of(pIngredients), pResult, getItemName(pResult.asItem()));
    }

    protected void oreBlasting(List<ItemLike> pIngredients, ItemLike pResult, String pGroup) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 100)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting_" + getItemName(itemlike));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 200)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting_" + getItemName(itemlike));
        }
    }

    protected void oreBlasting(TagKey<Item> pIngredients, ItemLike pResult) {
        String loc = pIngredients.location().getPath().replace('/', '_');
//        oreBlasting(pIngredients, RecipeCategory.MISC, pResult, 1, 100)
//             .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
//             .save(output,
//                     Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting" + loc);
//
//        oreSmelting(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 200)
//                .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
//                .save(output,
//                        Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting" + loc);
    }
    protected void nineBlockStorageRecipes(ItemLike pResult, TagKey<Item> pInput) {
        //nineBlockStorageRecipes(pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected void nineBlockStorageRecipes(ItemLike pResult, ItemLike pInput) {
        nineBlockStorageRecipes(pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected void nineBlockStorageRecipes(ItemLike pResult, Ingredient pInput,
                                                  ItemLike pUnlocker, @Nullable String pGroup) {
        shapeless(RecipeCategory.MISC, pResult, 9)
                .requires(pInput).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(output);
    }

    protected void storageBlockRecipe(ItemLike pResult, TagKey<Item> pInput) {
        //storageBlockRecipe(pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected void storageBlockRecipe(ItemLike pResult, ItemLike pInput) {
        storageBlockRecipe(pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected void storageBlockRecipe(ItemLike pResult, Ingredient pInput, ItemLike pUnlocker, @Nullable String pGroup) {
        shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput, 9).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(output);
    }

//    protected void compressionRecipe(ItemLike pInput, ItemLike pResult) {
//        compressionRecipe(Ingredient.of(pInput), pResult);
//    }
//
//    protected void compressionRecipe(TagKey<Item> pInput, ItemLike pResult) {
//        compressionRecipe(Ingredient.of(pInput), pResult);
//    }

//    protected void compressionRecipe(Ingredient pInput, ItemLike pResult) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
//                .requires(pInput).requires(TekoraTags.Items.HAMMER).group(pResult.asItem().toString())
//                .unlockedBy(getHasName(TekoraItems.IRON_HAMMER.get()), has(TekoraItems.IRON_HAMMER.get()))
//                .save(getItemName(pResult) + "_from_hammer");
//    }

    protected void upgradeSmithingRecipe(Item pUpgrader) {
        trimSmithing(pUpgrader, ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "osdilites")));
    }

    protected void armorRecipe(Ingredient pMaterial, ItemLike[] pArmorItems) {
        shaped(RecipeCategory.MISC, pArmorItems[0])
                .pattern("000")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[0]), has(pArmorItems[0]))
                .save(output);

        shaped(RecipeCategory.MISC, pArmorItems[1])
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[1]), has(pArmorItems[1]))
                .save(output);

        shaped(RecipeCategory.MISC, pArmorItems[2])
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[2]), has(pArmorItems[2]))
                .save(output);

        shaped(RecipeCategory.MISC, pArmorItems[3])
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[3]), has(pArmorItems[3]))
                .save(output);
    }

    protected void toolRecipe(Ingredient pMaterial, ItemLike[] pToolItems) {
        toolRecipe(pMaterial, Ingredient.of(Items.STICK), pToolItems);
    }

    protected void toolRecipe(Ingredient pMaterial, Ingredient pStick, ItemLike[] pToolItems) {
        shaped(RecipeCategory.MISC, pToolItems[0])
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[0]), has(pToolItems[0]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[1])
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[1]), has(pToolItems[1]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("10")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[3])
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[3]), has(pToolItems[3]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(output);

        shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern("1 ")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(output);

        createHammerRecipe(pMaterial, pStick, pToolItems[5]);
    }

    protected void createHammerRecipe(Ingredient pMaterial, ItemLike pHammer) {
        createHammerRecipe(pMaterial, Ingredient.of(Items.STICK), pHammer);
    }

    protected void createHammerRecipe(Ingredient pMaterial, Ingredient pStick, ItemLike pHammer) {
        shaped(RecipeCategory.MISC, pHammer)
                .pattern("000")
                .pattern("000")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pHammer), has(pHammer))
                .save(output);
    }
}
