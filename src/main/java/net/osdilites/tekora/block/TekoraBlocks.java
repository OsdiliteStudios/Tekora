package net.osdilites.tekora.block;

import net.minecraft.world.level.block.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

public class TekoraBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Tekora.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}