package net.osdilites.tekora.datagen;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.fluid.TekoraFluids;

public class TekoraFluidTagProvider extends FluidTagsProvider {
    public TekoraFluidTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Tekora.MODID);
    }

    @Override 
    protected void addTags(HolderLookup.Provider provider) {
        /* TODO: Create custom fluid physics
         * Currently, all fluids have water's physics
         * (ie buoyancy, drowning mechanics, and turning lava into obsidian/cobblestone)
         * For custom swimming speeds, fog colors, or damage effects without triggering water interactions,
         * remove them from FluidTags.WATER
         * */

        var waterTag = tag(FluidTags.WATER);

        TekoraFluids.FLUIDS.getEntries().forEach(holder ->
                waterTag.add(holder.getKey())
        );
    }
}
