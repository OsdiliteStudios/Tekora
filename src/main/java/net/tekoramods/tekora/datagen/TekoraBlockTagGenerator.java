package net.tekoramods.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.datagen.tags.TekoraTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TekoraBlockTagGenerator extends BlockTagsProvider {
    public TekoraBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TekoraTags.Blocks.ALUMINUM_BLOCK).add(TekoraBlocks.ALUMINUM_BLOCK.get());
        tag(TekoraTags.Blocks.BISMUTH_BLOCK).add(TekoraBlocks.BISMUTH_BLOCK.get());
        tag(TekoraTags.Blocks.COBALT_BLOCK).add(TekoraBlocks.COBALT_BLOCK.get());
        tag(TekoraTags.Blocks.LEAD_BLOCK).add(TekoraBlocks.LEAD_BLOCK.get());
        tag(TekoraTags.Blocks.MAGNESIUM_BLOCK).add(TekoraBlocks.MAGNESIUM_BLOCK.get());
        tag(TekoraTags.Blocks.MANGANESE_BLOCK).add(TekoraBlocks.MANGANESE_BLOCK.get());
        tag(TekoraTags.Blocks.MOLYBDENUM_BLOCK).add(TekoraBlocks.MOLYBDENUM_BLOCK.get());
        tag(TekoraTags.Blocks.NICKEL_BLOCK).add(TekoraBlocks.NICKEL_BLOCK.get());
        tag(TekoraTags.Blocks.PLATINUM_BLOCK).add(TekoraBlocks.PLATINUM_BLOCK.get());
        tag(TekoraTags.Blocks.SILVER_BLOCK).add(TekoraBlocks.SILVER_BLOCK.get());
        tag(TekoraTags.Blocks.TIN_BLOCK).add(TekoraBlocks.TIN_BLOCK.get());
        tag(TekoraTags.Blocks.TUNGSTEN_BLOCK).add(TekoraBlocks.TUNGSTEN_BLOCK.get());
        tag(TekoraTags.Blocks.ZINC_BLOCK).add(TekoraBlocks.ZINC_BLOCK.get());

        tag(TekoraTags.Blocks.RAW_LEAD_BLOCK).add(TekoraBlocks.RAW_LEAD_BLOCK.get());
        tag(TekoraTags.Blocks.RAW_NICKEL_BLOCK).add(TekoraBlocks.RAW_NICKEL_BLOCK.get());
        tag(TekoraTags.Blocks.RAW_PLATINUM_BLOCK).add(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
        tag(TekoraTags.Blocks.RAW_SILVER_BLOCK).add(TekoraBlocks.RAW_SILVER_BLOCK.get());
        tag(TekoraTags.Blocks.RAW_TIN_BLOCK).add(TekoraBlocks.RAW_TIN_BLOCK.get());
        tag(TekoraTags.Blocks.RAW_ZINC_BLOCK).add(TekoraBlocks.RAW_ZINC_BLOCK.get());

        tag(TekoraTags.Blocks.AQUAMARINE_BLOCK).add(TekoraBlocks.AQUAMARINE_BLOCK.get());
        tag(TekoraTags.Blocks.BAUXITE_BLOCK).add(TekoraBlocks.BAUXITE_BLOCK.get());
        tag(TekoraTags.Blocks.CINNABAR_BLOCK).add(TekoraBlocks.CINNABAR_BLOCK.get());
        tag(TekoraTags.Blocks.DOLOMITE_BLOCK).add(TekoraBlocks.DOLOMITE_BLOCK.get());
        tag(TekoraTags.Blocks.FLUORITE_BLOCK).add(TekoraBlocks.FLUORITE_BLOCK.get());
        tag(TekoraTags.Blocks.HALITE_BLOCK).add(TekoraBlocks.HALITE_BLOCK.get());
        tag(TekoraTags.Blocks.RUBY_BLOCK).add(TekoraBlocks.RUBY_BLOCK.get());
        tag(TekoraTags.Blocks.SAPPHIRE_BLOCK).add(TekoraBlocks.SAPPHIRE_BLOCK.get());
        tag(TekoraTags.Blocks.WOLFRAMITE_BLOCK).add(TekoraBlocks.WOLFRAMITE_BLOCK.get());

        tag(TekoraTags.Blocks.AQUAMARINE_ORE).add(TekoraBlocks.AQUAMARINE_ORE.get(), TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
        tag(TekoraTags.Blocks.BAUXITE_ORE).add(TekoraBlocks.BAUXITE_ORE.get(), TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get());
        tag(TekoraTags.Blocks.CINNABAR_ORE).add(TekoraBlocks.CINNABAR_ORE.get(), TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get());
        tag(TekoraTags.Blocks.HALITE_ORE).add(TekoraBlocks.HALITE_ORE.get(), TekoraBlocks.DEEPSLATE_HALITE_ORE.get());
        tag(TekoraTags.Blocks.RUBY_ORE).add(TekoraBlocks.RUBY_ORE.get(), TekoraBlocks.DEEPSLATE_RUBY_ORE.get());
        tag(TekoraTags.Blocks.SAPPHIRE_ORE).add(TekoraBlocks.SAPPHIRE_ORE.get(), TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(TekoraTags.Blocks.WOLFRAMITE_ORE).add(TekoraBlocks.WOLFRAMITE_ORE.get(), TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());

        tag(TekoraTags.Blocks.LEAD_ORE).add(TekoraBlocks.LEAD_ORE.get(), TekoraBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(TekoraTags.Blocks.NICKEL_ORE).add(TekoraBlocks.NICKEL_ORE.get(), TekoraBlocks.DEEPSLATE_NICKEL_ORE.get());
        tag(TekoraTags.Blocks.TIN_ORE).add(TekoraBlocks.TIN_ORE.get(), TekoraBlocks.DEEPSLATE_TIN_ORE.get());
        tag(TekoraTags.Blocks.ZINC_ORE).add(TekoraBlocks.ZINC_ORE.get(), TekoraBlocks.DEEPSLATE_ZINC_ORE.get());
    }
}
