package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;

import java.util.concurrent.CompletableFuture;

public class TekoraBlockTagProvider extends BlockTagsProvider {
    public TekoraBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Tekora.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TekoraBlocks.getKey(TekoraBlocks.STEEL_SHAFT.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.MECH_TOP.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.CUTTER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.CRUSHER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.MIXER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.PRESS.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.PRINTER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.KILN_FURNACE.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.BASIN.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.DEPOT.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.HAND_CRANK.get()));

        tag(BlockTags.MINEABLE_WITH_AXE).add(TekoraBlocks.getKey(TekoraBlocks.HAND_CRANK.get()));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(TekoraBlocks.getKey(TekoraBlocks.STEEL_SHAFT.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.MECH_TOP.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.CUTTER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.CRUSHER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.MIXER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.PRESS.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.PRINTER.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.KILN_FURNACE.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.BASIN.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.DEPOT.get()))
                .add(TekoraBlocks.getKey(TekoraBlocks.HAND_CRANK.get()));
    }
}
