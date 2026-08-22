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
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TekoraBlocks.STEEL_SHAFT.get(),
                TekoraBlocks.MECH_TOP.get(),
                TekoraBlocks.CUTTER.get(),
                TekoraBlocks.CRUSHER.get(),
                TekoraBlocks.MIXER.get(),
                TekoraBlocks.PRESS.get(),
                TekoraBlocks.PRINTER.get(),
                TekoraBlocks.KILN_FURNACE.get(),
                TekoraBlocks.BASIN.get(),
                TekoraBlocks.DEPOT.get(),
                TekoraBlocks.HAND_CRANK.get()
        );

        tag(BlockTags.MINEABLE_WITH_AXE).add(TekoraBlocks.HAND_CRANK.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(
                TekoraBlocks.STEEL_SHAFT.get(),
                TekoraBlocks.MECH_TOP.get(),
                TekoraBlocks.CUTTER.get(),
                TekoraBlocks.CRUSHER.get(),
                TekoraBlocks.MIXER.get(),
                TekoraBlocks.PRESS.get(),
                TekoraBlocks.PRINTER.get(),
                TekoraBlocks.KILN_FURNACE.get(),
                TekoraBlocks.BASIN.get(),
                TekoraBlocks.DEPOT.get(),
                TekoraBlocks.HAND_CRANK.get()
        );
    }
}
