package net.osdilites.tekora.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.basic.TekoraBaseBlock;
import net.osdilites.tekora.block.basic.TekoraExperienceBlock;
import net.osdilites.tekora.block.entities.attachment.ItemInputBlock;
import net.osdilites.tekora.block.entities.attachment.ItemOutputBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.Cogwheel;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;
import net.osdilites.tekora.block.entities.transporter.rotational.Waterwheel;
import net.osdilites.tekora.block.entities.thermal.KilnFurnace;
import net.osdilites.tekora.item.TekoraItems;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tekora.MODID);

//    public static final RegistryObject<Block> BORAX_BLOCK = registerBaseBlock("borax_block",
//            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
//    public static final RegistryObject<Block> SALT_BLOCK = registerBaseBlock("salt_block",
//            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
    public static final RegistryObject<Block> EVAPORITE = registerBaseBlock("evaporite");
    public static final RegistryObject<Block> LIMESTONE = registerBaseBlock("limestone");


    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBaseBlock("aluminum_block");
    //public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBaseBlock("antimony_block");
    //public static final RegistryObject<Block> ARSENIC_BLOCK = registerBaseBlock("arsenic_block");
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBaseBlock("bismuth_block");
    //public static final RegistryObject<Block> BORON_BLOCK = registerBaseBlock("boron_block", true);
    public static final RegistryObject<Block> COBALT_BLOCK = registerBaseBlock("cobalt_block");
    public static final RegistryObject<Block> LEAD_BLOCK = registerBaseBlock("lead_block");
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBaseBlock("magnesium_block");
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBaseBlock("manganese_block");
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBaseBlock("molybdenum_block", true);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBaseBlock("nickel_block");
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBaseBlock("platinum_block", true);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBaseBlock("silver_block");
    //public static final RegistryObject<Block> SILICON_BLOCK = registerBaseBlock("silicon_block");
    public static final RegistryObject<Block> TIN_BLOCK = registerBaseBlock("tin_block");
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBaseBlock("tungsten_block", true);
    public static final RegistryObject<Block> ZINC_BLOCK = registerBaseBlock("zinc_block");

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBaseBlock("raw_lead_block");
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = registerBaseBlock("raw_nickel_block");
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBaseBlock("raw_platinum_block");
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBaseBlock("raw_silver_block");
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBaseBlock("raw_tin_block");
    public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBaseBlock("raw_zinc_block");

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBaseBlock("aquamarine_block");
    public static final RegistryObject<Block> BAUXITE_BLOCK = registerBaseBlock("bauxite_block");
    //public static final RegistryObject<Block> CHROMITE_BLOCK = registerBaseBlock("chromite_block");
    public static final RegistryObject<Block> CINNABAR_BLOCK = registerBaseBlock("cinnabar_block");
    //public static final RegistryObject<Block> COLTAN_BLOCK = registerBaseBlock("coltan_block");
    public static final RegistryObject<Block> DOLOMITE_BLOCK = registerBaseBlock("dolomite_block");
    public static final RegistryObject<Block> FLUORITE_BLOCK = registerBaseBlock("fluorite_block");
    public static final RegistryObject<Block> HALITE_BLOCK = registerBaseBlock("halite_block");
    //public static final RegistryObject<Block> MONAZITE_BLOCK = registerBaseBlock("monazite_block");
    public static final RegistryObject<Block> RUBY_BLOCK = registerBaseBlock("ruby_block");
    //public static final RegistryObject<Block> RUTILE_BLOCK = registerBaseBlock("rutile_block");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBaseBlock("sapphire_block");
    //public static final RegistryObject<Block> URANINITE_BLOCK = registerBaseBlock("uraninite_block");
    public static final RegistryObject<Block> WOLFRAMITE_BLOCK = registerBaseBlock("wolframite_block");
    //public static final RegistryObject<Block> ZIRCON_BLOCK = registerBaseBlock("zircon_block");

    public static final RegistryObject<Block> FIREBRICKS = registerBaseBlock("firebricks", 6f, Blocks.BRICKS, SoundType.STONE);
    public static final RegistryObject<Block> CASTING_BRICKS = registerBaseBlock("casting_bricks", 6f, Blocks.BRICKS, SoundType.STONE);

    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new TekoraExperienceBlock("aquamarine_ore", 7f, 4.5f,1, 4));
    public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new TekoraExperienceBlock("deepslate_aquamarine_ore", 8.5f, 4.5f, SoundType.DEEPSLATE, 1, 4));
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new TekoraExperienceBlock("bauxite_ore", 2.25f, 1.3f, 1, 3));
    public static final RegistryObject<Block> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore",
            () -> new TekoraExperienceBlock("deepslate_bauxite_ore", 3.75f, 1.7f, SoundType.DEEPSLATE, 1, 3));
    public static final RegistryObject<Block> CINNABAR_ORE = registerBlock("cinnabar_ore",
            () -> new TekoraExperienceBlock("cinnabar_ore", 1.25f, 1.0f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_CINNABAR_ORE = registerBlock("deepslate_cinnabar_ore",
            () -> new TekoraExperienceBlock("deepslate_cinnabar_ore", 2.25f, 1.2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> HALITE_ORE = registerBlock("halite_ore",
            () -> new TekoraExperienceBlock("halite_ore", 2.68f, 1.5f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_HALITE_ORE = registerBlock("deepslate_halite_ore",
            () -> new TekoraExperienceBlock("deepslate_halite_ore", 4.18f, 2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new TekoraExperienceBlock("lead_ore", 2.68f, 1.5f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new TekoraExperienceBlock("deepslate_lead_ore", 4.18f, 2f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> NICKEL_ORE = registerBlock("nickel_ore",
            () -> new TekoraExperienceBlock("nickel_ore", 4.8f, 2.5f));
    public static final RegistryObject<Block> DEEPSLATE_NICKEL_ORE = registerBlock("deepslate_nickel_ore",
            () -> new TekoraExperienceBlock("deepslate_nickel_ore", 6.3f, 3.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new TekoraExperienceBlock("ruby_ore", 9f, 4.5f, 1, 4));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new TekoraExperienceBlock("deepslate_ruby_ore", 15f, 5.6f, SoundType.DEEPSLATE, 1, 4));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new TekoraExperienceBlock("sapphire_ore", 9f, 4.5f, 1, 4));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new TekoraExperienceBlock("deepslate_sapphire_ore", 15f, 5.6f, SoundType.DEEPSLATE, 1, 4));
//    public static final RegistryObject<Block> URANINITE_ORE = registerBlock("uraninite_ore",
//            () -> new TekoraExperienceBlock("uraninite_ore", 5.5f, 3f, 1, 3));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new TekoraExperienceBlock("tin_ore", 4f, 3f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new TekoraExperienceBlock("deepslate_tin_ore",6.5f, 3f, SoundType.DEEPSLATE, 1, 2));
//    public static final RegistryObject<Block> DEEPSLATE_URANINITE_ORE = registerBlock("deepslate_uraninite_ore",
//            () -> new TekoraExperienceBlock("deepslate_uraninite_ore", 7f, 3.5f, SoundType.DEEPSLATE, 1, 3));
    public static final RegistryObject<Block> WOLFRAMITE_ORE = registerBlock("wolframite_ore",
            () -> new TekoraExperienceBlock("wolframite_ore", 6.75f, 3.5f));
    public static final RegistryObject<Block> DEEPSLATE_WOLFRAMITE_ORE = registerBlock("deepslate_wolframite_ore",
            () -> new TekoraExperienceBlock("deepslate_wolframite_ore", 8.25f, 4.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore",
            () -> new TekoraExperienceBlock("zinc_ore", 6.75f, 3.5f));
    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            () -> new TekoraExperienceBlock("deepslate_zinc_ore", 8.25f,4.5f, SoundType.DEEPSLATE));
//    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
//            () -> new TekoraExperienceBlock(6.75f,3.5f));
//    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
//            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));

    public static final RegistryObject<Block> WOODEN_COGWHEEL = registerBlock("wooden_cogwheel", Cogwheel.Wood::new);
    public static final RegistryObject<Block> SHAFT = registerBlock("shaft", Shaft.Steel::new);
    public static final RegistryObject<Block> WOODEN_WATERWHEEL = registerBlock("wooden_waterwheel", Waterwheel.Wood::new);

    public static final RegistryObject<Block> KILN_FURNACE = registerBlock("kiln_furnace",
            () -> new KilnFurnace(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "kiln_furnace")))));
    public static final RegistryObject<Block> ITEM_INPUT_BLOCK = registerBlock("item_input_block",
            () -> new ItemInputBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HOPPER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "item_input_block")))));
    public static final RegistryObject<Block> ITEM_OUTPUT_BLOCK = registerBlock("item_output_block",
            () -> new ItemOutputBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HOPPER).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "item_output_block")))));
    // tekora fluids
//    public static final RegistryObject<LiquidBlock> MERCURY_FLUID_BLOCK = BLOCKS.register("mercury_fluid",
//            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_MERCURY_FLUID));

    private static RegistryObject<Block> registerBaseBlock(String name) {
        return registerBlock(name, () -> new TekoraBaseBlock(name));
    }

    private static RegistryObject<Block> registerBaseBlock(String name, boolean fireres) {
        return registerBlock(name, () -> new TekoraBaseBlock(name), fireres);
    }

    private static RegistryObject<Block> registerBaseBlock(String name, float strength) {
        return registerBlock(name, () -> new TekoraBaseBlock(name, strength));
    }

    private static RegistryObject<Block> registerBaseBlock(String name, float strength, Block material, SoundType sound) {
        return registerBlock(name, () -> new TekoraBaseBlock(name, strength, material, sound));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, false);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean fireResist) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, fireResist);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, boolean fireResist) {
        Item.Properties properties = fireResist ? new Item.Properties().fireResistant() : new Item.Properties();
        TekoraItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}