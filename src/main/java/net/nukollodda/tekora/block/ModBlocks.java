package net.nukollodda.tekora.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.basic.TekoraBlocks;
import net.nukollodda.tekora.block.basic.TekoraDropExperienceBlock;
import net.nukollodda.tekora.block.entity.AlloyFurnace;
import net.nukollodda.tekora.block.entity.Crusher;
import net.nukollodda.tekora.block.entity.InfusionFurnace;
import net.nukollodda.tekora.fluid.ModFluids;
import net.nukollodda.tekora.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tekora.MODID);

    public static final RegistryObject<Block> BORAX_BLOCK = registerBlock("borax_block",
            () -> new TekoraDropExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND, 1));
    public static final RegistryObject<Block> EPSOMITE_BLOCK = registerBlock("epsomite_block",
            () -> new TekoraDropExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND, 1));
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new TekoraDropExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND, 1));
    public static final RegistryObject<Block> EVAPORITE = registerBlock("evaporite",
            () -> new TekoraDropExperienceBlock(4f,3f, Blocks.STONE, 1));
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new TekoraDropExperienceBlock(4f,3f, Blocks.STONE, 1));


    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new TekoraBlocks(3f));
    public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBlock("antimony_block", () -> new TekoraBlocks(4f));
    public static final RegistryObject<Block> ARSENIC_BLOCK = registerBlock("arsenic_block", () -> new TekoraBlocks(4f));
    public static final RegistryObject<Block> BARIUM_BLOCK = registerBlock("barium_block", () -> new TekoraBlocks(2f));
    public static final RegistryObject<Block> BERYLLIUM_BLOCK = registerBlock("beryllium_block", () -> new TekoraBlocks(6f));
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block", () -> new TekoraBlocks(3f));
    public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block", () -> new TekoraBlocks(6f), true);
    public static final RegistryObject<Block> CADMIUM_BLOCK = registerBlock("cadmium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> CALCIUM_BLOCK = registerBlock("calcium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> CERIUM_BLOCK = registerBlock("cerium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> CHROMIUM_BLOCK = registerBlock("chromium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block", TekoraBlocks::new);
    public static final RegistryObject<Block> DYSPROSIUM_BLOCK = registerBlock("dysprosium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> ERBIUM_BLOCK = registerBlock("erbium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> EUROPIUM_BLOCK = registerBlock("europium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> GADOLINIUM_BLOCK = registerBlock("gadolinium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> GALLIUM_BLOCK = registerBlock("gallium_block", () -> new TekoraBlocks(1f));
    public static final RegistryObject<Block> GERMANIUM_BLOCK = registerBlock("germanium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> HAFNIUM_BLOCK = registerBlock("hafnium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> HOLMIUM_BLOCK = registerBlock("holmium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> INDIUM_BLOCK = registerBlock("indium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> LANTHANUM_BLOCK = registerBlock("lanthanum_block", TekoraBlocks::new);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", TekoraBlocks::new);
    public static final RegistryObject<Block> LUTETIUM_BLOCK = registerBlock("lutetium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("manganese_block", TekoraBlocks::new);
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = registerBlock("neodymium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block", TekoraBlocks::new);
    public static final RegistryObject<Block> NIOBIUM_BLOCK = registerBlock("niobium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> PALLADIUM_BLOCK = registerBlock("palladium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> PRASEODYMIUM_BLOCK = registerBlock("praseodymium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> RHENIUM_BLOCK = registerBlock("rhenium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> RHODIUM_BLOCK = registerBlock("rhodium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> RUTHENIUM_BLOCK = registerBlock("ruthenium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> SAMARIUM_BLOCK = registerBlock("samarium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> SCANDIUM_BLOCK = registerBlock("scandium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", TekoraBlocks::new);
    public static final RegistryObject<Block> STRONTIUM_BLOCK = registerBlock("strontium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block", TekoraBlocks::new);
    public static final RegistryObject<Block> TANTALUM_BLOCK = registerBlock("tantalum_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> TELLURIUM_BLOCK = registerBlock("tellurium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> TERBIUM_BLOCK = registerBlock("terbium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> THALLIUM_BLOCK = registerBlock("thallium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> THORIUM_BLOCK = registerBlock("thorium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> THULIUM_BLOCK = registerBlock("thulium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", TekoraBlocks::new);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> VANADIUM_BLOCK = registerBlock("vanadium_block", TekoraBlocks::new, true);
    public static final RegistryObject<Block> YTTERBIUM_BLOCK = registerBlock("ytterbium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> YTTRIUM_BLOCK = registerBlock("yttrium_block", TekoraBlocks::new);
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", TekoraBlocks::new);
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = registerBlock("zirconium_block", TekoraBlocks::new, true);


    public static final RegistryObject<Block> APATITE_ORE = registerBlock("apatite_ore",
            () -> new TekoraDropExperienceBlock(5f,3f, UniformInt.of(2, 6), 2));
    public static final RegistryObject<Block> CALCITE_APATITE_ORE = registerBlock("calcite_apatite_ore",
            () -> new TekoraDropExperienceBlock(5f,3f, SoundType.CALCITE, UniformInt.of(2, 6), 2));
    public static final RegistryObject<Block> DEEPSLATE_APATITE_ORE = registerBlock("deepslate_apatite_ore",
            () -> new TekoraDropExperienceBlock(6.5f,3.5f, SoundType.DEEPSLATE, UniformInt.of(2, 6), 2));
    public static final RegistryObject<Block> GRANITE_APATITE_ORE = registerBlock("granite_apatite_ore",
            () -> new TekoraDropExperienceBlock(5f,3f, UniformInt.of(2, 6), 2));
    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new TekoraDropExperienceBlock(7f,4.5f, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new TekoraDropExperienceBlock(8.5f,4.5f, SoundType.DEEPSLATE, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new TekoraDropExperienceBlock(2.25f,1.3f, UniformInt.of(1, 3), 1));
    public static final RegistryObject<Block> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore",
            () -> new TekoraDropExperienceBlock(3.75f,1.7f, SoundType.DEEPSLATE, UniformInt.of(1, 3), 1));
    public static final RegistryObject<Block> SAND_BAUXITE_ORE = registerBlock("sand_bauxite_ore",
            () -> new TekoraDropExperienceBlock(1f,1.2f, Blocks.SAND, SoundType.SAND,
                    UniformInt.of(1, 3), 1));
    public static final RegistryObject<Block> CASSITERITE_ORE = registerBlock("cassiterite_ore",
            () -> new TekoraDropExperienceBlock(4f,3f, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> DEEPSLATE_CASSITERITE_ORE = registerBlock("deepslate_cassiterite_ore",
            () -> new TekoraDropExperienceBlock(6.5f,3f, SoundType.DEEPSLATE, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> CHROMITE_ORE = registerBlock("chromite_ore",
            () -> new TekoraDropExperienceBlock(5.5f,3f, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> BASALT_CHROMITE_ORE = registerBlock("basalt_chromite_ore",
            () -> new TekoraDropExperienceBlock(5.5f,3f, SoundType.BASALT, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> DEEPSLATE_CHROMITE_ORE = registerBlock("deepslate_chromite_ore",
            () -> new TekoraDropExperienceBlock(7f,3.5f, SoundType.DEEPSLATE, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> NETHER_BASALT_CHROMITE_ORE = registerBlock("nether_basalt_chromite_ore",
            () -> new TekoraDropExperienceBlock(5.5f,3f, SoundType.BASALT, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> TUFF_CHROMITE_ORE = registerBlock("tuff_chromite_ore",
            () -> new TekoraDropExperienceBlock(5.5f,3f, SoundType.TUFF, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> CINNABAR_ORE = registerBlock("cinnabar_ore",
            () -> new TekoraDropExperienceBlock(1.25f,1.0f, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> DEEPSLATE_CINNABAR_ORE = registerBlock("deepslate_cinnabar_ore",
            () -> new TekoraDropExperienceBlock(2.25f,1.2f, SoundType.DEEPSLATE, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> GALENA_ORE = registerBlock("galena_ore",
            () -> new TekoraDropExperienceBlock(2.68f,1.5f, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> BASALT_GALENA_ORE = registerBlock("basalt_galena_ore",
            () -> new TekoraDropExperienceBlock(2.68f,1.5f, SoundType.BASALT, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> CALCITE_GALENA_ORE = registerBlock("calcite_galena_ore",
            () -> new TekoraDropExperienceBlock(2.68f,1.5f, SoundType.CALCITE, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> DEEPSLATE_GALENA_ORE = registerBlock("deepslate_galena_ore",
            () -> new TekoraDropExperienceBlock(4.18f,2f, SoundType.DEEPSLATE, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> TUFF_GALENA_ORE = registerBlock("tuff_galena_ore",
            () -> new TekoraDropExperienceBlock(2.68f,1.5f, SoundType.TUFF, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> GARNET_ORE = registerBlock("garnet_ore",
            () -> new TekoraDropExperienceBlock(7f,4f, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> DEEPSLATE_GARNET_ORE = registerBlock("deepslate_garnet_ore",
            () -> new TekoraDropExperienceBlock(8.5f,4.5f, SoundType.DEEPSLATE, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> GRAPHITE_ORE = registerBlock("graphite_ore",
            () -> new TekoraDropExperienceBlock(5f,1.3f, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> DEEPSLATE_GRAPHITE_ORE = registerBlock("deepslate_graphite_ore",
            () -> new TekoraDropExperienceBlock(1.5f,1.7f, SoundType.DEEPSLATE, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> TUFF_GRAPHITE_ORE = registerBlock("tuff_graphite_ore",
            () -> new TekoraDropExperienceBlock(5f,1.3f, SoundType.TUFF, UniformInt.of(1, 2), 1));
    public static final RegistryObject<Block> PENTLANDITE_ORE = registerBlock("pentlandite_ore",
            () -> new TekoraDropExperienceBlock(4.8f,2.5f, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> BASALT_PENTLANDITE_ORE = registerBlock("basalt_pentlandite_ore",
            () -> new TekoraDropExperienceBlock(4.8f,2.5f, SoundType.BASALT, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> DEEPSLATE_PENTLANDITE_ORE = registerBlock("deepslate_pentlandite_ore",
            () -> new TekoraDropExperienceBlock(6.3f,3.5f, SoundType.DEEPSLATE, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> GRANITE_PENTLANDITE_ORE = registerBlock("granite_pentlandite_ore",
            () -> new TekoraDropExperienceBlock(4.8f,2.5f, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> TUFF_PENTLANDITE_ORE = registerBlock("tuff_pentlandite_ore",
            () -> new TekoraDropExperienceBlock(4.8f,2.5f, SoundType.TUFF, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new TekoraDropExperienceBlock(9f,4.5f, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new TekoraDropExperienceBlock(15f,5.6f, SoundType.DEEPSLATE, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new TekoraDropExperienceBlock(9f,4.5f, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new TekoraDropExperienceBlock(15f,5.6f, SoundType.DEEPSLATE, UniformInt.of(1, 4), 2));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new TekoraDropExperienceBlock(2f,1.4f, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new TekoraDropExperienceBlock(3.5f,1.5f, SoundType.DEEPSLATE, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> URANINITE_ORE = registerBlock("uraninite_ore",
            () -> new TekoraDropExperienceBlock(5.5f,3f, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> DEEPSLATE_URANINITE_ORE = registerBlock("deepslate_uraninite_ore",
            () -> new TekoraDropExperienceBlock(7f,3.5f, SoundType.DEEPSLATE, UniformInt.of(1, 3), 2));
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new TekoraDropExperienceBlock(6.75f,3.5f, 2));
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new TekoraDropExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE, 2));
    public static final RegistryObject<Block> GRANITE_ZIRCON_ORE = registerBlock("granite_zircon_ore",
            () -> new TekoraDropExperienceBlock(6.75f,4.5f, 2));
    public static final RegistryObject<Block> SANSTONE_ZIRCON_ORE = registerBlock("sandstone_zircon_ore",
            () -> new TekoraDropExperienceBlock(4f,2.5f, 2));


    public static final RegistryObject<Block> ALLOY_FURNACE = registerBlock("alloy_furnace", AlloyFurnace::new);
    public static final RegistryObject<Block> INFUSION_FURNACE = registerBlock("infusion_furnace", InfusionFurnace::new);
    public static final RegistryObject<Block> CRUSHER = registerBlock("crusher", Crusher::new);

    public static final RegistryObject<LiquidBlock> CHLORINE_BLOCK = BLOCKS.register("chlorine_block",
            () -> new LiquidBlock(ModFluids.SOURCE_CHLORINE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, false);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean fireResist) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, fireResist);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, boolean fireResist) {
        return fireResist ? ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant())) :
                ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}