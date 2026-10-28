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
        tag(FluidTags.WATER)
            .add(TekoraFluids.getRK(TekoraFluids.AMMONIA_SOURCE.get()))
            .add(TekoraFluids.getRK(TekoraFluids.AMMONIA_FLOWING.get()))
            .add(TekoraFluids.getRK(TekoraFluids.SULFURIC_ACID_SOURCE.get()))
            .add(TekoraFluids.getRK(TekoraFluids.SULFURIC_ACID_FLOWING.get()));
    }
}
