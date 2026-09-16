package net.osdilites.tekora.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.Basin;
import net.osdilites.tekora.block.entities.Depot;
import net.osdilites.tekora.block.entities.mechanical.*;
import net.osdilites.tekora.block.entities.thermal.KilnFurnace;
import net.osdilites.tekora.block.entities.transporter.rotational.*;
import net.osdilites.tekora.block.fluids.ChemicalLiquidBlock;
import net.osdilites.tekora.fluid.TekoraFluids;
import net.osdilites.tekora.item.TekoraItems;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Tekora.MODID);

    // shaft connectables
    public static final DeferredHolder<Block, Shaft> STEEL_SHAFT =
            createBlock("steel_shaft", () -> new Shaft("steel_shaft", ShaftEntity.STEEL_I));
    public static final DeferredHolder<Block, HandCrank> HAND_CRANK =
            createBlock("hand_crank", () -> new HandCrank("hand_crank", 1));

    // mech attachments
    public static final DeferredHolder<Block, ApplyerMechanical> APPLYER =
            BLOCKS.register("assembler", ApplyerMechanical::new);
    public static final DeferredHolder<Block, MixerMechanical> MIXER =
            BLOCKS.register("mixer", MixerMechanical::new);
    public static final DeferredHolder<Block, CrusherMechanical> CRUSHER =
            BLOCKS.register("crusher", CrusherMechanical::new);
    public static final DeferredHolder<Block, PrinterMechanical> PRINTER =
            BLOCKS.register("printer", PrinterMechanical::new);
    public static final DeferredHolder<Block, PressMechanical> PRESS =
            BLOCKS.register("press", PressMechanical::new);
    public static final DeferredHolder<Block, CutterMechanical> CUTTER =
            BLOCKS.register("cutter", CutterMechanical::new);
    public static final DeferredHolder<Block, TopMechanical> MECH_TOP =
            createBlock("mechanical_top", TopMechanical::new);

    // machine holders
    public static final DeferredHolder<Block, Basin> BASIN =
            createBlock("basin", Basin::new);
    public static final DeferredHolder<Block, Depot> DEPOT =
            createBlock("depot", Depot::new);

    // megablock components
    public static final DeferredHolder<Block, KilnFurnace> KILN_FURNACE =
            createBlock("kiln_furnace", () -> new KilnFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)));

    // fluids
    public static final DeferredHolder<Block, ChemicalLiquidBlock> ACETONE =
            createBlock("acetone", () -> new ChemicalLiquidBlock(TekoraFluids.ACETONE_SOURCE.get(), "acetone"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFUR_DIOXIDE =
            createBlock("sulfur_dioxide", () -> new ChemicalLiquidBlock(TekoraFluids.SULFUR_DIOXIDE_SOURCE.get(), "sulfur_dioxide"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFUR_TRIOXIDE =
            createBlock("sulfur_trioxide", () -> new ChemicalLiquidBlock(TekoraFluids.SULFUR_TRIOXIDE_SOURCE.get(), "sulfur_trioxide"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFURIC_ACID =
            createBlock("sulfuric_acid", () -> new ChemicalLiquidBlock(TekoraFluids.SULFURIC_ACID_SOURCE.get(), "sulfuric_acid"));

    private static <T extends Block> DeferredHolder<Block, T> createBlock(String name, Supplier<T> block) {
        DeferredHolder<Block, T> ret = BLOCKS.register(name, block);
        TekoraItems.ITEMS.registerSimpleBlockItem(ret, Item.Properties::useBlockDescriptionPrefix);
        return ret;
    }

    public static ResourceKey<Block> getKey(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElse(null);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}