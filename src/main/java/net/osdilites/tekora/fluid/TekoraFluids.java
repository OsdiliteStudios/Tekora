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
import net.osdilites.tekora.fluid.fluids.ChemicalFluid;
import net.osdilites.tekora.fluid.types.TekoraFluidTypes;

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

    public static final BaseFlowingFluid.Properties ACETONE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.ACETONE_TYPE, ACETONE_SOURCE, ACETONE_FLOWING)
            .block(TekoraBlocks.ACETONE);

    public static final BaseFlowingFluid.Properties SULFUR_DIOXIDE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.SULFUR_DIOXIDE_TYPE, SULFUR_DIOXIDE_SOURCE, SULFUR_DIOXIDE_FLOWING)
            .block(TekoraBlocks.SULFUR_DIOXIDE);

    public static final BaseFlowingFluid.Properties SULFUR_TRIOXIDE_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.SULFUR_TRIOXIDE_TYPE, SULFUR_TRIOXIDE_SOURCE, SULFUR_TRIOXIDE_FLOWING)
            .block(TekoraBlocks.SULFUR_TRIOXIDE);

    public static final BaseFlowingFluid.Properties SULFURIC_ACID_PROPERTIES = new BaseFlowingFluid.Properties(
            TekoraFluidTypes.SULFURIC_ACID_TYPE, SULFURIC_ACID_SOURCE, SULFURIC_ACID_FLOWING)
            .block(TekoraBlocks.SULFURIC_ACID);

    public static ResourceKey<Fluid> getRK(FlowingFluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
