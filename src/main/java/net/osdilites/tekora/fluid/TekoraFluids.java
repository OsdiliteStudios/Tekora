package net.osdilites.tekora.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;

public class TekoraFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Tekora.MODID);

    public static final DeferredHolder<Fluid, FlowingFluid> ACETIC_ACID_SOURCE = FLUIDS.register("acetic_acid", () -> new ChemicalFluid.Source(TekoraFluids.ACETIC_ACID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ACETIC_ACID_FLOWING = FLUIDS.register("acetic_acid_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ACETIC_ACID_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> ACETONE_SOURCE = FLUIDS.register("acetone", () -> new ChemicalFluid.Source(TekoraFluids.ACETONE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ACETONE_FLOWING = FLUIDS.register("acetone_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ACETONE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> AMMONIA_SOURCE = FLUIDS.register("ammonia", () -> new ChemicalFluid.Source(TekoraFluids.AMMONIA_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> AMMONIA_FLOWING = FLUIDS.register("ammonia_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.AMMONIA_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> BENZENE_SOURCE = FLUIDS.register("benzene", () -> new ChemicalFluid.Source(TekoraFluids.BENZENE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> BENZENE_FLOWING = FLUIDS.register("benzene_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.BENZENE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> BROMINE_SOURCE = FLUIDS.register("bromine", () -> new ChemicalFluid.Source(TekoraFluids.BROMINE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> BROMINE_FLOWING = FLUIDS.register("bromine_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.BROMINE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> ETHANOL_SOURCE =  FLUIDS.register("ethanol", () -> new ChemicalFluid.Source(TekoraFluids.ETHANOL_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ETHANOL_FLOWING =  FLUIDS.register("ethanol_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ETHANOL_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> FORMIC_ACID_SOURCE = FLUIDS.register("formic_acid", () -> new ChemicalFluid.Source(TekoraFluids.FORMIC_ACID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FORMIC_ACID_FLOWING = FLUIDS.register("formic_acid_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.FORMIC_ACID_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> HYDRAZINE_SOURCE = FLUIDS.register("hydrazine", () -> new ChemicalFluid.Source(TekoraFluids.HYDRAZINE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> HYDRAZINE_FLOWING = FLUIDS.register("hydrazine_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.HYDRAZINE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> HYDROGEN_FLUORIDE_SOURCE = FLUIDS.register("hydrogen_fluoride", () -> new ChemicalFluid.Source(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> HYDROGEN_FLUORIDE_FLOWING = FLUIDS.register("hydrogen_fluoride_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> HYDROGEN_PEROXIDE_SOURCE = FLUIDS.register("hydrogen_peroxide", () -> new ChemicalFluid.Source(TekoraFluids.HYDROGEN_PEROXIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> HYDROGEN_PEROXIDE_FLOWING = FLUIDS.register("hydrogen_peroxide_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.HYDROGEN_PEROXIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> METHANOL_SOURCE = FLUIDS.register("methanol", () -> new ChemicalFluid.Source(TekoraFluids.METHANOL_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> METHANOL_FLOWING = FLUIDS.register("methanol_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.METHANOL_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_DIOXIDE_SOURCE = FLUIDS.register("sulfur_dioxide", () -> new ChemicalFluid.Source(TekoraFluids.SULFUR_DIOXIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_DIOXIDE_FLOWING = FLUIDS.register("sulfur_dioxide_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFUR_DIOXIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_TRIOXIDE_SOURCE = FLUIDS.register("sulfur_trioxide", () -> new ChemicalFluid.Source(TekoraFluids.SULFUR_TRIOXIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_TRIOXIDE_FLOWING = FLUIDS.register("sulfur_trioxide_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFUR_TRIOXIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFURIC_ACID_SOURCE = FLUIDS.register("sulfuric_acid", () -> new ChemicalFluid.Source(TekoraFluids.SULFURIC_ACID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFURIC_ACID_FLOWING = FLUIDS.register("sulfuric_acid_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFURIC_ACID_PROPERTIES));

    public static final BaseFlowingFluid.Properties ACETIC_ACID_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.ACETIC_ACID_TYPE, ACETIC_ACID_SOURCE, ACETIC_ACID_FLOWING, TekoraFluidTypes.ACETIC_ACID_DATA)
            .block(TekoraBlocks.ACETIC_ACID);

    public static final BaseFlowingFluid.Properties ACETONE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.ACETONE_TYPE, ACETONE_SOURCE, ACETONE_FLOWING, TekoraFluidTypes.ACETONE_DATA)
            .block(TekoraBlocks.ACETONE);

    public static final BaseFlowingFluid.Properties AMMONIA_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.AMMONIA_TYPE, AMMONIA_SOURCE, AMMONIA_FLOWING, TekoraFluidTypes.AMMONIA_DATA)
            .block(TekoraBlocks.AMMONIA);

    public static final BaseFlowingFluid.Properties BENZENE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.BENZENE_TYPE, BENZENE_SOURCE, BENZENE_FLOWING, TekoraFluidTypes.BENZENE_DATA)
            .block(TekoraBlocks.BENZENE);

    public static final BaseFlowingFluid.Properties BROMINE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.BROMINE_TYPE, BROMINE_SOURCE, BROMINE_FLOWING, TekoraFluidTypes.BROMINE_DATA)
            .block(TekoraBlocks.BROMINE);

    public static final BaseFlowingFluid.Properties ETHANOL_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.ETHANOL_TYPE, ETHANOL_SOURCE, ETHANOL_FLOWING, TekoraFluidTypes.ETHANOL_DATA)
            .block(TekoraBlocks.ETHANOL);

    public static final BaseFlowingFluid.Properties FORMIC_ACID_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.FORMIC_ACID_TYPE, FORMIC_ACID_SOURCE, FORMIC_ACID_FLOWING, TekoraFluidTypes.FORMIC_ACID_DATA)
            .block(TekoraBlocks.FORMIC_ACID);

    public static final BaseFlowingFluid.Properties HYDRAZINE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.HYDRAZINE_TYPE, HYDRAZINE_SOURCE, HYDRAZINE_FLOWING, TekoraFluidTypes.HYDRAZINE_DATA)
            .block(TekoraBlocks.HYDRAZINE);

    public static final BaseFlowingFluid.Properties HYDROGEN_FLUORIDE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.HYDROGEN_FLUORIDE_TYPE, HYDROGEN_FLUORIDE_SOURCE, HYDROGEN_FLUORIDE_FLOWING, TekoraFluidTypes.HYDROGEN_FLUORIDE_DATA)
            .block(TekoraBlocks.HYDROGEN_FLUORIDE);

    public static final BaseFlowingFluid.Properties HYDROGEN_PEROXIDE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.HYDROGEN_PEROXIDE_TYPE, HYDROGEN_PEROXIDE_SOURCE, HYDROGEN_PEROXIDE_FLOWING, TekoraFluidTypes.HYDROGEN_PEROXIDE_DATA)
            .block(TekoraBlocks.HYDROGEN_PEROXIDE);

    public static final BaseFlowingFluid.Properties METHANOL_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.METHANOL_TYPE, METHANOL_SOURCE, METHANOL_FLOWING, TekoraFluidTypes.METHANOL_DATA)
            .block(TekoraBlocks.METHANOL);

    public static final BaseFlowingFluid.Properties SULFUR_DIOXIDE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.SULFUR_DIOXIDE_TYPE, SULFUR_DIOXIDE_SOURCE, SULFUR_DIOXIDE_FLOWING, TekoraFluidTypes.SULFUR_DIOXIDE_DATA)
            .block(TekoraBlocks.SULFUR_DIOXIDE);

    public static final BaseFlowingFluid.Properties SULFUR_TRIOXIDE_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.SULFUR_TRIOXIDE_TYPE, SULFUR_TRIOXIDE_SOURCE, SULFUR_TRIOXIDE_FLOWING, TekoraFluidTypes.SULFUR_TRIOXIDE_DATA)
            .block(TekoraBlocks.SULFUR_TRIOXIDE);

    public static final BaseFlowingFluid.Properties SULFURIC_ACID_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.SULFURIC_ACID_TYPE, SULFURIC_ACID_SOURCE, SULFURIC_ACID_FLOWING, TekoraFluidTypes.SULFURIC_ACID_DATA)
            .block(TekoraBlocks.SULFURIC_ACID);

    public static ResourceKey<Fluid> getRK(FlowingFluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
