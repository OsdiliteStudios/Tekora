package net.osdilites.tekora.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
import net.osdilites.tekora.item.TekoraItems;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Tekora.MODID);

    public static final DeferredHolder<Block, Cogwheel> WOODEN_COGWHEEL =
            createBlock("wooden_cogwheel", () -> new Cogwheel("wooden_cogwheel", 1));
    public static final DeferredHolder<Block, Shaft> SHAFT =
            createBlock("shaft", () -> new Shaft("shaft"));
    public static final DeferredHolder<Block, HandCrank> WOODEN_HAND_CRANK =
            createBlock("wooden_hand_crank", () -> new HandCrank("wooden_hand_crank", 1));
    public static final DeferredHolder<Block, KilnFurnace> KILN_FURNACE =
            createBlock("kiln_furnace", () -> new KilnFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)));


    private static <T extends Block> DeferredHolder<Block, T> createBlock(String name, Supplier<T> block) {
        DeferredHolder<Block, T> ret = BLOCKS.register(name, block);
        TekoraItems.ITEMS.registerItem(name, p -> new BlockItem(ret.get(), p.useBlockDescriptionPrefix()));
        return ret;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}