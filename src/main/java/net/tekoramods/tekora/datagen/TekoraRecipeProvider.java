package net.tekoramods.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.datagen.tags.TekoraTags;
import net.tekoramods.tekora.item.TekoraItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TekoraRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public TekoraRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pWriter) {
        nineBlockStorageRecipes(pWriter, TekoraItems.ALUMINUM_INGOT.get(), TekoraTags.Items.ALUMINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BISMUTH_INGOT.get(), TekoraTags.Items.BISMUTH_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.COBALT_INGOT.get(), TekoraTags.Items.COBALT_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.LEAD_INGOT.get(), TekoraTags.Items.LEAD_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNESIUM_INGOT.get(), TekoraTags.Items.MAGNESIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MANGANESE_INGOT.get(), TekoraTags.Items.MANGANESE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MOLYBDENUM_INGOT.get(), TekoraTags.Items.MOLYBDENUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.NICKEL_INGOT.get(), TekoraTags.Items.NICKEL_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.PLATINUM_INGOT.get(), TekoraTags.Items.PLATINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILVER_INGOT.get(), TekoraTags.Items.SILVER_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TIN_INGOT.get(), TekoraTags.Items.TIN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_INGOT.get(), TekoraTags.Items.TUNGSTEN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZINC_INGOT.get(), TekoraTags.Items.ZINC_BLOCK);

        nineBlockStorageRecipes(pWriter, TekoraItems.AQUAMARINE.get(), TekoraTags.Items.AQUAMARINE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BAUXITE.get(), TekoraTags.Items.BAUXITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CINNABAR.get(), TekoraTags.Items.CINNABAR_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.DOLOMITE.get(), TekoraTags.Items.DOLOMITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.FLUORITE.get(), TekoraTags.Items.FLUORITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.HALITE.get(), TekoraTags.Items.HALITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUBY.get(), TekoraTags.Items.RUBY_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SAPPHIRE.get(), TekoraTags.Items.SAPPHIRE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.WOLFRAMITE.get(), TekoraTags.Items.WOLFRAMITE_BLOCK);

        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_LEAD.get(), TekoraTags.Items.RAW_LEAD_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_NICKEL.get(), TekoraTags.Items.RAW_NICKEL_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_SILVER.get(), TekoraTags.Items.RAW_SILVER_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_PLATINUM.get(), TekoraTags.Items.RAW_PLATINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_TIN.get(), TekoraTags.Items.RAW_TIN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_ZINC.get(), TekoraTags.Items.RAW_ZINC_BLOCK);


        storageBlockRecipe(pWriter, TekoraBlocks.ALUMINUM_BLOCK.get(), TekoraTags.Items.ALUMINUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.BISMUTH_BLOCK.get(), TekoraTags.Items.BISMUTH_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.COBALT_BLOCK.get(), TekoraTags.Items.COBALT_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.LEAD_BLOCK.get(), TekoraTags.Items.LEAD_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MAGNESIUM_BLOCK.get(), TekoraTags.Items.MAGNESIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MANGANESE_BLOCK.get(), TekoraTags.Items.MANGANESE_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MOLYBDENUM_BLOCK.get(), TekoraTags.Items.MOLYBDENUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.NICKEL_BLOCK.get(), TekoraTags.Items.NICKEL_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.PLATINUM_BLOCK.get(), TekoraTags.Items.PLATINUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.SILVER_BLOCK.get(), TekoraTags.Items.SILVER_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TIN_BLOCK.get(), TekoraTags.Items.TIN_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TUNGSTEN_BLOCK.get(), TekoraTags.Items.TUNGSTEN_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.ZINC_BLOCK.get(), TekoraTags.Items.ZINC_INGOT);

        storageBlockRecipe(pWriter, TekoraBlocks.AQUAMARINE_BLOCK.get(), TekoraTags.Items.AQUAMARINE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.BAUXITE_BLOCK.get(), TekoraTags.Items.BAUXITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.CINNABAR_BLOCK.get(), TekoraTags.Items.CINNABAR_GEM);
//        storageBlockRecipe(pWriter, TekoraBlocks.DOLOMITE_BLOCK.get(), TekoraTags.Items.DOLOMITE_GEM);
//        storageBlockRecipe(pWriter, TekoraBlocks.FLUORITE_BLOCK.get(), TekoraTags.Items.FLUORITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.HALITE_BLOCK.get(), TekoraTags.Items.HALITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.RUBY_BLOCK.get(), TekoraTags.Items.RUBY_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.SAPPHIRE_BLOCK.get(), TekoraTags.Items.SAPPHIRE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.WOLFRAMITE_BLOCK.get(), TekoraTags.Items.WOLFRAMITE_GEM);

        storageBlockRecipe(pWriter, TekoraBlocks.RAW_LEAD_BLOCK.get(), TekoraTags.Items.RAW_LEAD);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_NICKEL_BLOCK.get(), TekoraTags.Items.RAW_NICKEL);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_SILVER_BLOCK.get(), TekoraTags.Items.RAW_SILVER);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_PLATINUM_BLOCK.get(), TekoraTags.Items.RAW_PLATINUM);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_TIN_BLOCK.get(), TekoraTags.Items.RAW_TIN);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_ZINC_BLOCK.get(), TekoraTags.Items.RAW_ZINC);

        oreBlasting(pWriter, TekoraTags.Items.RAW_LEAD, TekoraItems.LEAD_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_NICKEL, TekoraItems.NICKEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_PLATINUM, TekoraItems.PLATINUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_SILVER, TekoraItems.SILVER_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_TIN, TekoraItems.TIN_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_ZINC, TekoraItems.ZINC_INGOT.get());


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TekoraItems.INFUSED_CLAY.get(), 4)
                .requires(Items.CLAY_BALL, 2).requires(TekoraItems.BAUXITE.get(), 2).group("infused_clay")
                .unlockedBy(getHasName(Items.CLAY), has(Items.CLAY))
                .save(pWriter, Tekora.MODID + ":infused_clay_recipe_1");


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TekoraBlocks.FIREBRICKS.get(), 1)
                .requires(TekoraItems.FIRE_BRICK.get(), 4).group("firebricks")
                .unlockedBy(getHasName(TekoraItems.FIRE_BRICK.get()), has(TekoraItems.FIRE_BRICK.get()))
                .save(pWriter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TekoraItems.INFUSED_CLAY.get()), RecipeCategory.MISC,
                        TekoraItems.FIRE_BRICK.get(), 1, 200)
                .group("fire_brick").unlockedBy(getHasName(TekoraItems.INFUSED_CLAY.get()), has(TekoraItems.INFUSED_CLAY.get()))
                .save(pWriter,
                        Tekora.MODID + ":fire_brick_from_smelting_infused_clay");

        cogwheelRecipe(pWriter, TekoraBlocks.SHAFT.get(), TekoraTags.Items.PLANKS, TekoraTags.Items.SLABS_WOODEN, TekoraBlocks.WOODEN_COGWHEEL.get());
        shaftRecipe(pWriter, TekoraTags.Items.STEEL_INGOT, TekoraBlocks.SHAFT.get());
    }
    
    protected static void cogwheelRecipe(RecipeOutput pWriter, ItemLike pShaft, TagKey<Item> pMaterial, TagKey<Item> pHalfMaterial, ItemLike pResult) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
                .pattern("010")
                .pattern("121")
                .pattern("010")
                .define('0', pHalfMaterial)
                .define('1', pMaterial)
                .define('2', pShaft)
                .unlockedBy(getHasName(pShaft), has(pShaft))
                .save(pWriter, Tekora.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void shaftRecipe(RecipeOutput pWriter, TagKey<Item> pMaterial, ItemLike pResult) {
        ItemLike item = Ingredient.of(pMaterial).getItems()[0].getItem();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 5)
                .pattern("0")
                .pattern("0")
                .pattern("0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(item), has(item))
                .save(pWriter, Tekora.MODID + ":" + getItemName(pResult) + "_from_crafting");
    }

    protected static void oreBlasting(RecipeOutput pWriter, ItemLike pIngredients, ItemLike pResult) {
        oreBlasting(pWriter, List.of(pIngredients), pResult, getItemName(pResult.asItem()));
    }

    protected static void oreBlasting(RecipeOutput pWriter,
                                     List<ItemLike> pIngredients, ItemLike pResult, String pGroup) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 100)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pWriter,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting_" + getItemName(itemlike));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 200)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pWriter,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting_" + getItemName(itemlike));
        }
    }

    protected static void oreBlasting(RecipeOutput pWriter,
                                     TagKey<Item> pIngredients, ItemLike pResult) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 100)
             .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
             .save(pWriter,
                     Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting" +
                             pIngredients.location().getPath().replace('/', '_'));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 200)
                .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
                .save(pWriter,
                        Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting" +
                                pIngredients.location().getPath().replace('/', '_'));
    }
    protected static void nineBlockStorageRecipes(RecipeOutput pWriter,
                                                  ItemLike pResult, TagKey<Item> pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected static void nineBlockStorageRecipes(RecipeOutput pWriter, ItemLike pResult, ItemLike pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected static void nineBlockStorageRecipes(RecipeOutput pWriter, ItemLike pResult, Ingredient pInput,
                                                  ItemLike pUnlocker, @Nullable String pGroup) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, 9)
                .requires(pInput).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter);
    }

    protected static void storageBlockRecipe(RecipeOutput pWriter, ItemLike pResult, TagKey<Item> pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected static void storageBlockRecipe(RecipeOutput pWriter, ItemLike pResult, ItemLike pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected static void storageBlockRecipe(RecipeOutput pWriter,
                                             ItemLike pResult, Ingredient pInput, ItemLike pUnlocker, @Nullable String pGroup) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput, 9).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, getItemName(pResult) + "_from_components");
    }

//    protected static void compressionRecipe(RecipeOutput pWriter, ItemLike pInput, ItemLike pResult) {
//        compressionRecipe(pWriter, Ingredient.of(pInput), pResult);
//    }
//
//    protected static void compressionRecipe(RecipeOutput pWriter, TagKey<Item> pInput, ItemLike pResult) {
//        compressionRecipe(pWriter, Ingredient.of(pInput), pResult);
//    }

//    protected static void compressionRecipe(RecipeOutput pWriter, Ingredient pInput, ItemLike pResult) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
//                .requires(pInput).requires(TekoraTags.Items.HAMMER).group(pResult.asItem().toString())
//                .unlockedBy(getHasName(TekoraItems.IRON_HAMMER.get()), has(TekoraItems.IRON_HAMMER.get()))
//                .save(pWriter, getItemName(pResult) + "_from_hammer");
//    }

    protected static void upgradeSmithingRecipe(RecipeOutput pWriter, ItemLike[] pBase, Ingredient pMaterial, ItemLike pUpgrader,
                                                     ItemLike[] pResults) {
        for (int i = 0; i < pBase.length; i++) {
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(pUpgrader), Ingredient.of(pBase[i]),
                            pMaterial, RecipeCategory.MISC, pResults[i].asItem())
                    .unlocks(getHasName(pBase[i]), has(pBase[i]))
                    .save(pWriter, ResourceLocation.fromNamespaceAndPath(Tekora.MODID,
                            getItemName(pResults[i]) + "_from_" + getItemName(pBase[i]) + "_smithing"));
        }
    }

    protected static void armorRecipe(RecipeOutput pWriter, Ingredient pMaterial, ItemLike[] pArmorItems) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[0])
                .pattern("000")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[0]), has(pArmorItems[0]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[0] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[1])
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[1]), has(pArmorItems[1]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[1] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[2])
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[2]), has(pArmorItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[2] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[3])
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[3]), has(pArmorItems[3]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[3] + "_from_crafting");
    }

    protected static void toolRecipe(RecipeOutput pWriter, Ingredient pMaterial, ItemLike[] pToolItems) {
        toolRecipe(pWriter, pMaterial, Ingredient.of(Items.STICK), pToolItems);
    }

    protected static void toolRecipe(RecipeOutput pWriter, Ingredient pMaterial, Ingredient pStick, ItemLike[] pToolItems) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[0])
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[0]), has(pToolItems[0]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[0] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[1])
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[1]), has(pToolItems[1]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[1] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[2] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("10")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[2] + "_from_crafting_inverted");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[3])
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[3]), has(pToolItems[3]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[3] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[4] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern("1 ")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[4] + "_from_crafting_inverted");

        createHammerRecipe(pWriter, pMaterial, pStick, pToolItems[5]);
    }

    protected static void createHammerRecipe(RecipeOutput pWriter, Ingredient pMaterial, ItemLike pHammer) {
        createHammerRecipe(pWriter, pMaterial, Ingredient.of(Items.STICK), pHammer);
    }

    protected static void createHammerRecipe(RecipeOutput pWriter, Ingredient pMaterial, Ingredient pStick, ItemLike pHammer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pHammer)
                .pattern("000")
                .pattern("000")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pHammer), has(pHammer))
                .save(pWriter, Tekora.MODID + ":" + pHammer + "_from_crafting");
    }
}
