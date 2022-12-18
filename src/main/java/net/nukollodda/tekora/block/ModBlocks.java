package net.nukollodda.tekora.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.item.ModCreativeModTab;
import net.nukollodda.tekora.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tekora.MODID);

    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBlock("antimony_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> ARSENIC_BLOCK = registerBlock("arsenic_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> BARIUM_BLOCK = registerBlock("barium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> BERYLLIUM_BLOCK = registerBlock("beryllium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> CADMIUM_BLOCK = registerBlock("cadmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> CALCIUM_BLOCK = registerBlock("calcium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> CERIUM_BLOCK = registerBlock("cerium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> CHROMIUM_BLOCK = registerBlock("chromium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> DYSPROSIUM_BLOCK = registerBlock("dysprosium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> ERBIUM_BLOCK = registerBlock("erbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> EUROPIUM_BLOCK = registerBlock("europium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> GADOLINIUM_BLOCK = registerBlock("gadolinium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> GALLIUM_BLOCK = registerBlock("gallium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> GERMANIUM_BLOCK = registerBlock("germanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> HAFNIUM_BLOCK = registerBlock("hafnium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> HOLMIUM_BLOCK = registerBlock("holmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> INDIUM_BLOCK = registerBlock("indium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> LANTHANUM_BLOCK = registerBlock("lanthanum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> LUTETIUM_BLOCK = registerBlock("lutetium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("manganese_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> NEODYMIUM_BLOCK = registerBlock("neodymium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> NIOBIUM_BLOCK = registerBlock("niobium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> PALLADIUM_BLOCK = registerBlock("palladium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> PRASEODYMIUM_BLOCK = registerBlock("praseodymium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> RHENIUM_BLOCK = registerBlock("rhenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> RHODIUM_BLOCK = registerBlock("rhodium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> RUTHENIUM_BLOCK = registerBlock("ruthenium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> SAMARIUM_BLOCK = registerBlock("samarium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> SCANDIUM_BLOCK = registerBlock("scandium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> STRONTIUM_BLOCK = registerBlock("strontium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> TANTALUM_BLOCK = registerBlock("tantalum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> TELLURIUM_BLOCK = registerBlock("tellurium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> TERBIUM_BLOCK = registerBlock("terbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> THALLIUM_BLOCK = registerBlock("thallium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> THORIUM_BLOCK = registerBlock("thorium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> THULIUM_BLOCK = registerBlock("thulium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> VANADIUM_BLOCK = registerBlock("vanadium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> YTTERBIUM_BLOCK = registerBlock("ytterbium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> YTTRIUM_BLOCK = registerBlock("yttrium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, false);

    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = registerBlock("zirconium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TEKORA_BLOCKS, true);

    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).destroyTime(20).requiresCorrectToolForDrops(),
                    UniformInt.of(1,5)), ModCreativeModTab.TEKORA_BLOCKS, false);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, boolean fireResist) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, fireResist);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, boolean fireResist) {
        if (fireResist == true) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).fireResistant()));
        } else {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
