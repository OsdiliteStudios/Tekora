package net.osdilites.tekora.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

public class TekoraFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Tekora.MODID);

    // todo, add fluids to Tekroa

    public static ResourceKey<Fluid> getRK(FlowingFluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
