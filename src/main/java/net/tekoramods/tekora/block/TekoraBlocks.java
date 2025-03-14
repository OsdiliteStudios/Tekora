package net.tekoramods.tekora.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.basic.TekoraBaseBlock;
import net.tekoramods.tekora.block.basic.TekoraExperienceBlock;
import net.tekoramods.tekora.block.entities.transporter.rotational.Cogwheel;
import net.tekoramods.tekora.block.entities.transporter.rotational.Shaft;
import net.tekoramods.tekora.block.entities.transporter.rotational.Waterwheel;
import net.tekoramods.tekora.block.entities.thermal.KilnFurnace;
import net.tekoramods.tekora.item.TekoraItems;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tekora.MODID);

//    public static final RegistryObject<Block> BORAX_BLOCK = registerBlock("borax_block",
//            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
//    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
//            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
    public static final RegistryObject<Block> EVAPORITE = registerBlock("evaporite",
            () -> new TekoraExperienceBlock(4f,3f, Blocks.STONE));
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new TekoraExperienceBlock(4f,3f, Blocks.STONE));


    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new TekoraBaseBlock(3f));
    //public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBlock("antimony_block", () -> new TekoraBaseBlock(4f));
    //public static final RegistryObject<Block> ARSENIC_BLOCK = registerBlock("arsenic_block", () -> new TekoraBaseBlock(4f));
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block", () -> new TekoraBaseBlock(3f));
    //public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block", () -> new TekoraBaseBlock(6f), true);
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("manganese_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", TekoraBaseBlock::new);

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = registerBlock("raw_nickel_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBlock("raw_zinc_block", TekoraBaseBlock::new);

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> BAUXITE_BLOCK = registerBlock("bauxite_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> CHROMITE_BLOCK = registerBlock("chromite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CINNABAR_BLOCK = registerBlock("cinnabar_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> COLTAN_BLOCK = registerBlock("coltan_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> DOLOMITE_BLOCK = registerBlock("dolomite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> FLUORITE_BLOCK = registerBlock("fluorite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> HALITE_BLOCK = registerBlock("halite_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> MONAZITE_BLOCK = registerBlock("monazite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> RUTILE_BLOCK = registerBlock("rutile_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> URANINITE_BLOCK = registerBlock("uraninite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> WOLFRAMITE_BLOCK = registerBlock("wolframite_block", TekoraBaseBlock::new);
    //public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block", TekoraBaseBlock::new);

    public static final RegistryObject<Block> FIREBRICKS = registerBlock("firebricks", () -> new TekoraBaseBlock(6f, Blocks.BRICKS, SoundType.STONE));
    public static final RegistryObject<Block> CASTING_BRICKS = registerBlock("casting_bricks", () -> new TekoraBaseBlock(6f, Blocks.BRICKS, SoundType.STONE));

    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new TekoraExperienceBlock(7f,4.5f,1, 4));
    public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new TekoraExperienceBlock(8.5f,4.5f, SoundType.DEEPSLATE, 1, 4));
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new TekoraExperienceBlock(2.25f,1.3f, 1, 3));
    public static final RegistryObject<Block> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore",
            () -> new TekoraExperienceBlock(3.75f,1.7f, SoundType.DEEPSLATE, 1, 3));
    public static final RegistryObject<Block> CINNABAR_ORE = registerBlock("cinnabar_ore",
            () -> new TekoraExperienceBlock(1.25f,1.0f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_CINNABAR_ORE = registerBlock("deepslate_cinnabar_ore",
            () -> new TekoraExperienceBlock(2.25f,1.2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> HALITE_ORE = registerBlock("halite_ore",
            () -> new TekoraExperienceBlock(2.68f,1.5f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_HALITE_ORE = registerBlock("deepslate_halite_ore",
            () -> new TekoraExperienceBlock(4.18f,2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new TekoraExperienceBlock(2.68f,1.5f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new TekoraExperienceBlock(4.18f,2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> NICKEL_ORE = registerBlock("nickel_ore",
            () -> new TekoraExperienceBlock(4.8f,2.5f));
    public static final RegistryObject<Block> DEEPSLATE_NICKEL_ORE = registerBlock("deepslate_nickel_ore",
            () -> new TekoraExperienceBlock(6.3f,3.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new TekoraExperienceBlock(9f,4.5f, 1, 4));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new TekoraExperienceBlock(15f,5.6f, SoundType.DEEPSLATE, 1, 4));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new TekoraExperienceBlock(9f,4.5f, 1, 4));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new TekoraExperienceBlock(15f,5.6f, SoundType.DEEPSLATE, 1, 4));
//    public static final RegistryObject<Block> URANINITE_ORE = registerBlock("uraninite_ore",
//            () -> new TekoraExperienceBlock(5.5f,3f, 1, 3));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new TekoraExperienceBlock(4f,3f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new TekoraExperienceBlock(6.5f,3f, SoundType.DEEPSLATE, 1, 2));
//    public static final RegistryObject<Block> DEEPSLATE_URANINITE_ORE = registerBlock("deepslate_uraninite_ore",
//            () -> new TekoraExperienceBlock(7f,3.5f, SoundType.DEEPSLATE, 1, 3));
    public static final RegistryObject<Block> WOLFRAMITE_ORE = registerBlock("wolframite_ore",
            () -> new TekoraExperienceBlock(6.75f,3.5f));
    public static final RegistryObject<Block> DEEPSLATE_WOLFRAMITE_ORE = registerBlock("deepslate_wolframite_ore",
            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore",
            () -> new TekoraExperienceBlock(6.75f,3.5f));
    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));
//    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
//            () -> new TekoraExperienceBlock(6.75f,3.5f));
//    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
//            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));

    public static final RegistryObject<Block> WOODEN_COGWHEEL = registerBlock("wooden_cogwheel", Cogwheel.Wood::new);
    public static final RegistryObject<Block> SHAFT = registerBlock("shaft", Shaft.Steel::new);
    public static final RegistryObject<Block> WOODEN_WATERWHEEL = registerBlock("wooden_waterwheel", Waterwheel.Wood::new);
    public static final RegistryObject<Block> KILN_FURNACE = registerBlock("kiln_furnace", () -> new KilnFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)));
    // tekora fluids
//    public static final RegistryObject<LiquidBlock> MERCURY_FLUID_BLOCK = BLOCKS.register("mercury_fluid",
//            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_MERCURY_FLUID));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, false);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean fireResist) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, fireResist);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, boolean fireResist) {
        TekoraItems.ITEMS.register(name, () -> new BlockItem(block.get(), fireResist ? new Item.Properties().fireResistant() : new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}