package net.osdilites.tekora.block;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.thermal.KilnFurnace;
import net.osdilites.tekora.block.entities.transporter.rotational.Cogwheel;
import net.osdilites.tekora.block.entities.transporter.rotational.HandCrank;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;
import net.osdilites.tekora.block.entities.transporter.rotational.Waterwheel;

public class TekoraBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Tekora.MODID);

    public static final DeferredHolder<Block, Cogwheel> WOODEN_COGWHEEL =
            BLOCKS.register("wooden_cogwheel", id -> new Cogwheel(id.getNamespace(), 1));
    public static final DeferredHolder<Block, Shaft> SHAFT =
            BLOCKS.register("shaft", id -> new Shaft(id.getNamespace()));
    public static final DeferredHolder<Block, HandCrank> WOODEN_HAND_CRANK =
            BLOCKS.register("wooden_hand_crank", id -> new HandCrank(id.getNamespace(), 1));
    public static final DeferredHolder<Block, KilnFurnace> KILN_FURNACE =
            BLOCKS.register("kiln_furnace", () -> new KilnFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}