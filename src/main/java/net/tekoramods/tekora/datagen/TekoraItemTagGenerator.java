package net.tekoramods.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.datagen.tags.TekoraTags;
import net.tekoramods.tekora.item.TekoraItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TekoraItemTagGenerator extends ItemTagsProvider {
    public TekoraItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                                  CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TekoraTags.Items.ALUMINUM_INGOT).add(TekoraItems.ALUMINUM_INGOT.get());
        tag(TekoraTags.Items.BISMUTH_INGOT).add(TekoraItems.BISMUTH_INGOT.get());
        tag(TekoraTags.Items.COBALT_INGOT).add(TekoraItems.COBALT_INGOT.get());
        tag(TekoraTags.Items.LEAD_INGOT).add(TekoraItems.LEAD_INGOT.get());
        tag(TekoraTags.Items.MAGNESIUM_INGOT).add(TekoraItems.MAGNESIUM_INGOT.get());
        tag(TekoraTags.Items.MANGANESE_INGOT).add(TekoraItems.MANGANESE_INGOT.get());
        tag(TekoraTags.Items.MOLYBDENUM_INGOT).add(TekoraItems.MOLYBDENUM_INGOT.get());
        tag(TekoraTags.Items.NICKEL_INGOT).add(TekoraItems.NICKEL_INGOT.get());
        tag(TekoraTags.Items.PLATINUM_INGOT).add(TekoraItems.PLATINUM_INGOT.get());
        tag(TekoraTags.Items.POTASSIUM_INGOT).add(TekoraItems.POTASSIUM_INGOT.get());
        tag(TekoraTags.Items.SILVER_INGOT).add(TekoraItems.SILVER_INGOT.get());
        tag(TekoraTags.Items.SODIUM_INGOT).add(TekoraItems.SODIUM_INGOT.get());
        tag(TekoraTags.Items.TIN_INGOT).add(TekoraItems.TIN_INGOT.get());
        tag(TekoraTags.Items.TUNGSTEN_INGOT).add(TekoraItems.TUNGSTEN_INGOT.get());
        tag(TekoraTags.Items.ZINC_INGOT).add(TekoraItems.ZINC_INGOT.get());

        tag(TekoraTags.Items.BRASS_INGOT).add(TekoraItems.BRASS_INGOT.get());
        tag(TekoraTags.Items.BRONZE_INGOT).add(TekoraItems.BRONZE_INGOT.get());
        tag(TekoraTags.Items.CONSTANTAN_INGOT).add(TekoraItems.CONSTANTAN_INGOT.get());
        tag(TekoraTags.Items.ELECTRUM_INGOT).add(TekoraItems.ELECTRUM_INGOT.get());
        tag(TekoraTags.Items.INVAR_INGOT).add(TekoraItems.INVAR_INGOT.get());
        tag(TekoraTags.Items.STEEL_INGOT).add(TekoraItems.STEEL_INGOT.get());
        tag(TekoraTags.Items.PEWTER_INGOT).add(TekoraItems.PEWTER_INGOT.get());
        tag(TekoraTags.Items.TUNGSTEN_STEEL_INGOT).add(TekoraItems.TUNGSTEN_STEEL_INGOT.get());

        tag(TekoraTags.Items.RAW_LEAD).add(TekoraItems.RAW_LEAD.get());
        tag(TekoraTags.Items.RAW_NICKEL).add(TekoraItems.RAW_NICKEL.get());
        tag(TekoraTags.Items.RAW_PLATINUM).add(TekoraItems.RAW_PLATINUM.get());
        tag(TekoraTags.Items.RAW_SILVER).add(TekoraItems.RAW_SILVER.get());
        tag(TekoraTags.Items.RAW_TIN).add(TekoraItems.RAW_TIN.get());
        tag(TekoraTags.Items.RAW_ZINC).add(TekoraItems.RAW_ZINC.get());

        /* --------------------------------blocks----------------------------------------- */
        tag(TekoraTags.Items.ALUMINUM_BLOCK).add(TekoraBlocks.ALUMINUM_BLOCK.get().asItem());
        tag(TekoraTags.Items.BISMUTH_BLOCK).add(TekoraBlocks.BISMUTH_BLOCK.get().asItem());
        tag(TekoraTags.Items.COBALT_BLOCK).add(TekoraBlocks.COBALT_BLOCK.get().asItem());
        tag(TekoraTags.Items.LEAD_BLOCK).add(TekoraBlocks.LEAD_BLOCK.get().asItem());
        tag(TekoraTags.Items.MAGNESIUM_BLOCK).add(TekoraBlocks.MAGNESIUM_BLOCK.get().asItem());
        tag(TekoraTags.Items.MANGANESE_BLOCK).add(TekoraBlocks.MANGANESE_BLOCK.get().asItem());
        tag(TekoraTags.Items.MOLYBDENUM_BLOCK).add(TekoraBlocks.MOLYBDENUM_BLOCK.get().asItem());
        tag(TekoraTags.Items.NICKEL_BLOCK).add(TekoraBlocks.NICKEL_BLOCK.get().asItem());
        tag(TekoraTags.Items.PLATINUM_BLOCK).add(TekoraBlocks.PLATINUM_BLOCK.get().asItem());
        tag(TekoraTags.Items.SILVER_BLOCK).add(TekoraBlocks.SILVER_BLOCK.get().asItem());
        tag(TekoraTags.Items.TIN_BLOCK).add(TekoraBlocks.TIN_BLOCK.get().asItem());
        tag(TekoraTags.Items.TUNGSTEN_BLOCK).add(TekoraBlocks.TUNGSTEN_BLOCK.get().asItem());
        tag(TekoraTags.Items.ZINC_BLOCK).add(TekoraBlocks.ZINC_BLOCK.get().asItem());

        tag(TekoraTags.Items.RAW_LEAD_BLOCK).add(TekoraBlocks.RAW_LEAD_BLOCK.get().asItem());
        tag(TekoraTags.Items.RAW_NICKEL_BLOCK).add(TekoraBlocks.RAW_NICKEL_BLOCK.get().asItem());
        tag(TekoraTags.Items.RAW_PLATINUM_BLOCK).add(TekoraBlocks.RAW_PLATINUM_BLOCK.get().asItem());
        tag(TekoraTags.Items.RAW_SILVER_BLOCK).add(TekoraBlocks.RAW_SILVER_BLOCK.get().asItem());
        tag(TekoraTags.Items.RAW_TIN_BLOCK).add(TekoraBlocks.RAW_TIN_BLOCK.get().asItem());
        tag(TekoraTags.Items.RAW_ZINC_BLOCK).add(TekoraBlocks.RAW_ZINC_BLOCK.get().asItem());

        tag(TekoraTags.Items.AQUAMARINE_BLOCK).add(TekoraBlocks.AQUAMARINE_BLOCK.get().asItem());
        tag(TekoraTags.Items.BAUXITE_BLOCK).add(TekoraBlocks.BAUXITE_BLOCK.get().asItem());
        tag(TekoraTags.Items.CINNABAR_BLOCK).add(TekoraBlocks.CINNABAR_BLOCK.get().asItem());
        tag(TekoraTags.Items.DOLOMITE_BLOCK).add(TekoraBlocks.DOLOMITE_BLOCK.get().asItem());
        tag(TekoraTags.Items.FLUORITE_BLOCK).add(TekoraBlocks.FLUORITE_BLOCK.get().asItem());
        tag(TekoraTags.Items.HALITE_BLOCK).add(TekoraBlocks.HALITE_BLOCK.get().asItem());
        tag(TekoraTags.Items.RUBY_BLOCK).add(TekoraBlocks.RUBY_BLOCK.get().asItem());
        tag(TekoraTags.Items.SAPPHIRE_BLOCK).add(TekoraBlocks.SAPPHIRE_BLOCK.get().asItem());
        tag(TekoraTags.Items.WOLFRAMITE_BLOCK).add(TekoraBlocks.WOLFRAMITE_BLOCK.get().asItem());

        tag(TekoraTags.Items.AQUAMARINE_ORE).add(TekoraBlocks.AQUAMARINE_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get().asItem());
        tag(TekoraTags.Items.BAUXITE_ORE).add(TekoraBlocks.BAUXITE_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get().asItem());
        tag(TekoraTags.Items.CINNABAR_ORE).add(TekoraBlocks.CINNABAR_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get().asItem());
        tag(TekoraTags.Items.HALITE_ORE).add(TekoraBlocks.HALITE_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_HALITE_ORE.get().asItem());
        tag(TekoraTags.Items.RUBY_ORE).add(TekoraBlocks.RUBY_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_RUBY_ORE.get().asItem());
        tag(TekoraTags.Items.SAPPHIRE_ORE).add(TekoraBlocks.SAPPHIRE_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get().asItem());
        tag(TekoraTags.Items.WOLFRAMITE_ORE).add(TekoraBlocks.WOLFRAMITE_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get().asItem());

        tag(TekoraTags.Items.LEAD_ORE).add(TekoraBlocks.LEAD_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_LEAD_ORE.get().asItem());
        tag(TekoraTags.Items.NICKEL_ORE).add(TekoraBlocks.NICKEL_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_NICKEL_ORE.get().asItem());
        tag(TekoraTags.Items.TIN_ORE).add(TekoraBlocks.TIN_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_TIN_ORE.get().asItem());
        tag(TekoraTags.Items.ZINC_ORE).add(TekoraBlocks.ZINC_ORE.get().asItem(), TekoraBlocks.DEEPSLATE_ZINC_ORE.get().asItem());
    }
}
