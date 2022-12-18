package net.nukollodda.tekora.item;

import net.minecraft.world.item.CreativeModeTab;
import net.nukollodda.tekora.Tekora;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tekora.MODID);

    public static final RegistryObject<Item> APATITE = ITEMS.register("apatite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> BASTNAESITE = ITEMS.register("bastnaesite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> CASSITERITE = ITEMS.register("cassiterite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> CHROMITE = ITEMS.register("chromite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> COLTAN = ITEMS.register("coltan",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> DOLOMITE = ITEMS.register("dolomite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> GALENA = ITEMS.register("galena",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> MAGNETITE = ITEMS.register("magnetite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> MONAZITE = ITEMS.register("monazite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> ORPIMENT = ITEMS.register("orpiment",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> PENTLANDITE = ITEMS.register("pentlandite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> PYROLUSITE = ITEMS.register("pyrolusite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> RUTILE = ITEMS.register("rutile",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> SCHEELITE = ITEMS.register("scheelite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> SPERRYLITE = ITEMS.register("sperrylite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> SPHALERITE = ITEMS.register("sphalerite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> STIBNITE = ITEMS.register("stibnite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> THORITE = ITEMS.register("thorite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> URANINITE = ITEMS.register("uraninite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> WOLFRAMITE = ITEMS.register("wolframite",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS)));




    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> ANTIMONY_PIECE = ITEMS.register("antimony_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ARSENIC_PIECE = ITEMS.register("arsenic_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BORON_PIECE = ITEMS.register("boron_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> GERMANIUM_PIECE = ITEMS.register("germanium_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SILICON_PIECE = ITEMS.register("silicon_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> TELLURIUM_PIECE = ITEMS.register("tellurium_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BARIUM_NUGGET = ITEMS.register("barium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CADMIUM_NUGGET = ITEMS.register("cadmium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CALCIUM_NUGGET = ITEMS.register("calcium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CERIUM_NUGGET = ITEMS.register("cerium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CESIUM_NUGGET = ITEMS.register("cesium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> CHROMIUM_NUGGET = ITEMS.register("chromium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> DYSPROSIUM_NUGGET = ITEMS.register("dysprosium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ERBIUM_NUGGET = ITEMS.register("erbium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> EUROPIUM_NUGGET = ITEMS.register("europium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> GADOLINIUM_NUGGET = ITEMS.register("gadolinium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> HAFNIUM_NUGGET = ITEMS.register("hafnium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> HOLMIUM_NUGGET = ITEMS.register("holmium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> INDIUM_NUGGET = ITEMS.register("indium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> LANTHANUM_NUGGET = ITEMS.register("lanthanum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LITHIUM_NUGGET = ITEMS.register("lithium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> LUTETIUM_NUGGET = ITEMS.register("lutetium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> MANGANESE_NUGGET = ITEMS.register("manganese_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> MOLYBDENUM_NUGGET = ITEMS.register("molybdenum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> NEODYMIUM_NUGGET = ITEMS.register("neodymium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> NIOBIUM_NUGGET = ITEMS.register("niobium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> POTASSIUM_NUGGET = ITEMS.register("potassium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> PRASEODYMIUM_NUGGET = ITEMS.register("praseodymium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> RHENIUM_NUGGET = ITEMS.register("rhenium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> RHODIUM_NUGGET = ITEMS.register("rhodium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> RUBIDIUM_NUGGET = ITEMS.register("rubidium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> RUTHENIUM_NUGGET = ITEMS.register("ruthenium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> SAMARIUM_NUGGET = ITEMS.register("samarium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SCANDIUM_NUGGET = ITEMS.register("scandium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> SODIUM_NUGGET = ITEMS.register("sodium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> STRONTIUM_NUGGET = ITEMS.register("strontium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> TANTALUM_NUGGET = ITEMS.register("tantalum_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TERBIUM_NUGGET = ITEMS.register("terbium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> THALLIUM_NUGGET = ITEMS.register("thallium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> THORIUM_NUGGET = ITEMS.register("thorium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> THULIUM_NUGGET = ITEMS.register("thulium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> VANADIUM_NUGGET = ITEMS.register("vanadium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static final RegistryObject<Item> YTTERBIUM_NUGGET = ITEMS.register("ytterbium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> YTTRIUM_NUGGET = ITEMS.register("yttrium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS)));

    public static final RegistryObject<Item> ZIRCONIUM_NUGGET = ITEMS.register("zirconium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
