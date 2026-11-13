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
                // FIXME: find simpler implementation
                /* TODO: Create custom fluid physics
                * Currently, all fluids have water's physics
                * (ie bouyancy, drowning mechanics, and turning lava into obsidian/cobblestone)
                * For custom swimming speeds, fog colors, or damage effects without triggering water interactions,
                * remove them from FluidTags.WATER
                * */
                .add(TekoraFluids.getRK(TekoraFluids.ACETIC_ACID_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.ACETIC_ACID_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.ACETONE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.ACETONE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.AMMONIA_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.AMMONIA_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.BENZENE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.BENZENE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.BROMINE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.BROMINE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.ETHANOL_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.ETHANOL_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.FORMIC_ACID_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.FORMIC_ACID_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDRAZINE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDRAZINE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDROGEN_FLUORIDE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDROGEN_FLUORIDE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDROGEN_PEROXIDE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.HYDROGEN_PEROXIDE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.METHANOL_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.METHANOL_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFUR_DIOXIDE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFUR_DIOXIDE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFUR_TRIOXIDE_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFUR_TRIOXIDE_FLOWING.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFURIC_ACID_SOURCE.get()))
                .add(TekoraFluids.getRK(TekoraFluids.SULFURIC_ACID_FLOWING.get()));

    }
}
