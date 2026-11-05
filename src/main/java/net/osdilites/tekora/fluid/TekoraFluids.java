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

    public static final DeferredHolder<Fluid, FlowingFluid> ACETONE_SOURCE = FLUIDS.register("acetone", () -> new ChemicalFluid.Source(TekoraFluids.ACETONE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ACETONE_FLOWING = FLUIDS.register("acetone_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ACETONE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_DIOXIDE_SOURCE = FLUIDS.register("sulfur_dioxide", () -> new ChemicalFluid.Source(TekoraFluids.SULFUR_DIOXIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_DIOXIDE_FLOWING = FLUIDS.register("sulfur_dioxide_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFUR_DIOXIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_TRIOXIDE_SOURCE = FLUIDS.register("sulfur_trioxide", () -> new ChemicalFluid.Source(TekoraFluids.SULFUR_TRIOXIDE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFUR_TRIOXIDE_FLOWING = FLUIDS.register("sulfur_trioxide_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFUR_TRIOXIDE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> SULFURIC_ACID_SOURCE = FLUIDS.register("sulfuric_acid", () -> new ChemicalFluid.Source(TekoraFluids.SULFURIC_ACID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SULFURIC_ACID_FLOWING = FLUIDS.register("sulfuric_acid_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.SULFURIC_ACID_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> AMMONIA_SOURCE = FLUIDS.register("ammonia", () -> new ChemicalFluid.Source(TekoraFluids.AMMONIA_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> AMMONIA_FLOWING = FLUIDS.register("ammonia_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.AMMONIA_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> ETHANOL_SOURCE = FLUIDS.register("ethanol", () -> new ChemicalFluid.Source(TekoraFluids.ETHANOL_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ETHANOL_FLOWING = FLUIDS.register("ethanol_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ETHANOL_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> ACETIC_ACID_SOURCE = FLUIDS.register("acetic_acid", () -> new ChemicalFluid.Source(TekoraFluids.ACETIC_ACID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> ACETIC_ACID_FLOWING = FLUIDS.register("acetic_acid_flowing", () -> new ChemicalFluid.Flowing(TekoraFluids.ACETIC_ACID_PROPERTIES));

    public static final BaseFlowingFluid.Properties ACETONE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.ACETONE_TYPE, ACETONE_SOURCE, ACETONE_FLOWING)
            .block(TekoraBlocks.ACETONE);

    public static final BaseFlowingFluid.Properties SULFUR_DIOXIDE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.SULFUR_DIOXIDE_TYPE, SULFUR_DIOXIDE_SOURCE, SULFUR_DIOXIDE_FLOWING)
            .block(TekoraBlocks.SULFUR_DIOXIDE);

    public static final BaseFlowingFluid.Properties SULFUR_TRIOXIDE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.SULFUR_TRIOXIDE_TYPE, SULFUR_TRIOXIDE_SOURCE, SULFUR_TRIOXIDE_FLOWING)
            .block(TekoraBlocks.SULFUR_TRIOXIDE);

    public static final BaseFlowingFluid.Properties SULFURIC_ACID_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.SULFURIC_ACID_TYPE, SULFURIC_ACID_SOURCE, SULFURIC_ACID_FLOWING, TekoraFluidTypes.SULFURIC_ACID_DATA)
            .block(TekoraBlocks.SULFURIC_ACID);

    public static final BaseFlowingFluid.Properties AMMONIA_PROPERTIES = ChemicalFluid.FluidProperties(
            TekoraFluidTypes.AMMONIA_TYPE, AMMONIA_SOURCE, AMMONIA_FLOWING, TekoraFluidTypes.AMMONIA_FLUID_DATA)
            .block(TekoraBlocks.AMMONIA);

    public static final BaseFlowingFluid.Properties ETHANOL_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.ETHANOL_TYPE, ETHANOL_SOURCE, ETHANOL_FLOWING)
            .block(TekoraBlocks.ETHANOL);

    public static final BaseFlowingFluid.Properties ACETIC_ACID_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.ACETIC_ACID_TYPE, ACETIC_ACID_SOURCE, ACETIC_ACID_FLOWING)
            .block(TekoraBlocks.ACETIC_ACID);

    public static ResourceKey<Fluid> getRK(FlowingFluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
