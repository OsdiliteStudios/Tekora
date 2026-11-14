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
import net.osdilites.tekora.block.basic.TekoraExperienceBlock;
import net.osdilites.tekora.block.entities.Basin;
import net.osdilites.tekora.block.entities.Depot;
import net.osdilites.tekora.block.entities.mechanical.*;
import net.osdilites.tekora.block.entities.thermal.KilnFurnace;
import net.osdilites.tekora.block.entities.transporter.rotational.*;
import net.osdilites.tekora.block.fluids.ChemicalLiquidBlock;
import net.osdilites.tekora.fluid.TekoraFluids;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.block.basic.TekoraBaseBlock;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Tekora.MODID);

    // shaft connectables
    public static final DeferredHolder<Block, Shaft> STEEL_SHAFT =
            createBlock("steel_shaft", () -> new Shaft("steel_shaft", ShaftEntity.STEEL_I));
    public static final DeferredHolder<Block, HandCrank> HAND_CRANK =
            createBlock("hand_crank", () -> new HandCrank("hand_crank", 1));
    public static final DeferredHolder<Block, HandCrank> SUPER_CRANK = 
            createBlock("super_crank", () -> new HandCrank("super_crank", 4, HandCrankEntity.SUPER_FORCE_COEFF));

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
    public static final DeferredHolder<Block, ChemicalLiquidBlock> ACETIC_ACID =
            createBlock("acetic_acid", () -> new ChemicalLiquidBlock(TekoraFluids.ACETIC_ACID.getSource(), "acetic_acid"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> ACETONE =
            createBlock("acetone", () -> new ChemicalLiquidBlock(TekoraFluids.ACETONE.getSource(), "acetone"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> AMMONIA =
            createBlock("ammonia", () -> new ChemicalLiquidBlock(TekoraFluids.AMMONIA.getSource(), "ammonia"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> BENZENE =
            createBlock("benzene", () -> new ChemicalLiquidBlock(TekoraFluids.BENZENE.getSource(), "benzene"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> BROMINE =
            createBlock("bromine", () -> new ChemicalLiquidBlock(TekoraFluids.BROMINE.getSource(), "bromine"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> ETHANOL =
            createBlock("ethanol", () -> new ChemicalLiquidBlock(TekoraFluids.ETHANOL.getSource(), "ethanol"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> FORMIC_ACID =
            createBlock("formic_acid", () -> new ChemicalLiquidBlock(TekoraFluids.FORMIC_ACID.getSource(), "formic_acid"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> HYDRAZINE =
            createBlock("hydrazine", () -> new ChemicalLiquidBlock(TekoraFluids.HYDRAZINE.getSource(), "hydrazine"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> HYDROGEN_FLUORIDE =
            createBlock("hydrogen_fluoride", () -> new ChemicalLiquidBlock(TekoraFluids.HYDROGEN_FLUORIDE.getSource(), "hydrogen_fluoride"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> HYDROGEN_PEROXIDE =
            createBlock("hydrogen_peroxide", () -> new ChemicalLiquidBlock(TekoraFluids.HYDROGEN_PEROXIDE.getSource(), "hydrogen_peroxide"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> METHANOL =
            createBlock("methanol", () -> new ChemicalLiquidBlock(TekoraFluids.METHANOL.getSource(), "methanol"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFURIC_ACID =
            createBlock("sulfuric_acid", () -> new ChemicalLiquidBlock(TekoraFluids.SULFURIC_ACID.getSource(), "sulfuric_acid"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFUR_DIOXIDE =
            createBlock("sulfur_dioxide", () -> new ChemicalLiquidBlock(TekoraFluids.SULFUR_DIOXIDE.getSource(), "sulfur_dioxide"));
    public static final DeferredHolder<Block, ChemicalLiquidBlock> SULFUR_TRIOXIDE =
            createBlock("sulfur_trioxide", () -> new ChemicalLiquidBlock(TekoraFluids.SULFUR_TRIOXIDE.getSource(), "sulfur_trioxide"));

    // public static final DeferredBlock<Block> STEEL_BLOCK = BLOCKS.register(
    //     "steel_block", 
    //     registryName -> new Block(BlockBehaviour.Properties.of()
    //     .setId(ResourceKey.create(Registries.BLOCK, registryName))
    //     .destroyTime(4.f)
    //     .explosionResistance(10.f)
    //     .sound(SoundType.IRON)
    // ));

    public static final DeferredHolder<Block, Block> BAUXITE_ORE = createBlock("bauxite_ore",
            () -> new TekoraExperienceBlock("bauxite_ore", 2.0f, 1.0f));

    public static final DeferredHolder<Block, Block> STEEL_BLOCK = createBlock(
        "steel_block", 
        () -> new TekoraBaseBlock("steel_block")
    );
        
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