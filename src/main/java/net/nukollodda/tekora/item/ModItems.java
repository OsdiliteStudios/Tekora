package net.nukollodda.tekora.item;

import net.nukollodda.tekora.item.armors.TekoraArmor;
import net.nukollodda.tekora.item.isotopic.Lithium;
import net.nukollodda.tekora.item.isotopic.radioactive.*;
import net.nukollodda.tekora.item.tools.HammerItem;
import net.nukollodda.tekora.item.tools.thorium.*;
import net.nukollodda.tekora.item.typical.*;
import net.minecraft.world.item.*;
import net.nukollodda.tekora.Tekora;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.item.armors.HeatResArmor;
import net.nukollodda.tekora.tiers.ModArmors;
import net.nukollodda.tekora.tiers.ModTiers;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tekora.MODID);

    public static final RegistryObject<Item> APATITE = ITEMS.register("apatite", TypicalItem::new);
    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine", TypicalItem::new);
    public static final RegistryObject<Item> BASTNAESITE = ITEMS.register("bastnaesite", TypicalItem::new);
    public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", TypicalItem::new);
    public static final RegistryObject<Item> CASSITERITE = ITEMS.register("cassiterite", TypicalItem::new);
    public static final RegistryObject<Item> CHROMITE = ITEMS.register("chromite", TypicalItem::new);
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", TypicalItem::new);
    public static final RegistryObject<Item> COLTAN = ITEMS.register("coltan", TypicalItem::new);
    public static final RegistryObject<Item> DOLOMITE = ITEMS.register("dolomite", TypicalItem::new);
    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite", TypicalItem::new);
    public static final RegistryObject<Item> GALENA = ITEMS.register("galena", TypicalItem::new);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", TypicalItem::new);
    public static final RegistryObject<Item> MAGNETITE = ITEMS.register("magnetite", TypicalItem::new);
    public static final RegistryObject<Item> MONAZITE = ITEMS.register("monazite", TypicalItem::new);
    public static final RegistryObject<Item> ORPIMENT = ITEMS.register("orpiment", TypicalItem::new);
    public static final RegistryObject<Item> PENTLANDITE = ITEMS.register("pentlandite", TypicalItem::new);
    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite", TypicalItem::new);
    public static final RegistryObject<Item> PYROLUSITE = ITEMS.register("pyrolusite", TypicalItem::new);
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", TypicalItem::new);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", TypicalItem::new);
    public static final RegistryObject<Item> RUTILE = ITEMS.register("rutile", TypicalItem::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", TypicalItem::new);
    public static final RegistryObject<Item> SCHEELITE = ITEMS.register("scheelite", TypicalItem::new);
    public static final RegistryObject<Item> SPERRYLITE = ITEMS.register("sperrylite", TypicalItem::new);
    public static final RegistryObject<Item> SPHALERITE = ITEMS.register("sphalerite", TypicalItem::new);
    public static final RegistryObject<Item> STIBNITE = ITEMS.register("stibnite", TypicalItem::new);
    public static final RegistryObject<Item> THORITE = ITEMS.register("thorite", TypicalItem::new);
    public static final RegistryObject<Item> URANINITE = ITEMS.register("uraninite", TypicalItem::new);
    public static final RegistryObject<Item> WOLFRAMITE = ITEMS.register("wolframite", TypicalItem::new);
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", TypicalItem::new);

    public static final RegistryObject<Item> BASTNAESITE_SHARD = ITEMS.register("bastnaesite_shard", TypicalItem::new);
    public static final RegistryObject<Item> COLTAN_PIECE = ITEMS.register("coltan_piece", TypicalItem::new);
    public static final RegistryObject<Item> MAGNETITE_SHARD = ITEMS.register("magnetite_shard", TypicalItem::new);
    public static final RegistryObject<Item> MONAZITE_SHARD = ITEMS.register("monazite_shard", TypicalItem::new);
    public static final RegistryObject<Item> ORPIMENT_SHARD = ITEMS.register("orpiment_shard", TypicalItem::new);
    public static final RegistryObject<Item> PYRITE_PIECE = ITEMS.register("pyrite_piece", TypicalItem::new);
    public static final RegistryObject<Item> PYROLUSITE_PIECE = ITEMS.register("pyrolusite_piece", TypicalItem::new);
    public static final RegistryObject<Item> RUTILE_SHARD = ITEMS.register("rutile_shard", TypicalItem::new);
    public static final RegistryObject<Item> SCHEELITE_SHARD = ITEMS.register("scheelite_shard", TypicalItem::new);
    public static final RegistryObject<Item> SPERRYLITE_SHARD = ITEMS.register("sperrylite_shard", TypicalItem::new);
    public static final RegistryObject<Item> SPHALERITE_PIECE = ITEMS.register("sphalerite_piece", TypicalItem::new);
    public static final RegistryObject<Item> STIBNITE_SHARD = ITEMS.register("stibnite_shard", TypicalItem::new);
    public static final RegistryObject<Item> THORITE_PIECE = ITEMS.register("thorite_piece", TypicalItem::new);
    public static final RegistryObject<Item> WOLFRAMITE_PIECE = ITEMS.register("wolframite_piece", TypicalItem::new);


    public static final RegistryObject<Item> GRAPHITE_BAR = ITEMS.register("graphite_bar", TypicalItem::new);
    public static final RegistryObject<Item> IODINE_BAR = ITEMS.register("iodine_bar", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_STEEL = ITEMS.register("copper_steel", TypicalItem::new);
    
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", TypicalItem::new);
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", TypicalItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", TypicalItem::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", TypicalItem::new);
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", Lithium::new);
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", TypicalItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", Thorium::new);
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TypicalItem::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", Uranium::new);
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", TypicalItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", HeatResistantItem::new);
    
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", TypicalItem::new);
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_INGOT = ITEMS.register("chromoly_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> FERROBORON_INGOT = ITEMS.register("ferroboron_ingot", TypicalItem::new);
    public static final RegistryObject<Item> GALVANIZED_STEEL_INGOT = ITEMS.register("galvanized_steel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_INGOT = ITEMS.register("hsla_steel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> INCONEL_INGOT = ITEMS.register("inconel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot", TypicalItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_INGOT = ITEMS.register("magnetic_neodymium_ingot", TypicalItem::new);
    public static final RegistryObject<Item> MU_METAL_INGOT = ITEMS.register("mu_metal_ingot", TypicalItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_INGOT = ITEMS.register("reactor_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_INGOT = ITEMS.register("stainless_steel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", TypicalItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = ITEMS.register("tungsten_carbide_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_INGOT = ITEMS.register("tungsten_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_INGOT = ITEMS.register("vanasteel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register("zircaloy_ingot", HeatResistantItem::new);
    
    public static final RegistryObject<Item> ANTIMONY_PIECE = ITEMS.register("antimony_piece", TypicalItem::new);
    public static final RegistryObject<Item> ARSENIC_PIECE = ITEMS.register("arsenic_piece", TypicalItem::new);
    public static final RegistryObject<Item> BORON_PIECE = ITEMS.register("boron_piece", HeatResistantItem::new);
    public static final RegistryObject<Item> GERMANIUM_PIECE = ITEMS.register("germanium_piece", TypicalItem::new);
    public static final RegistryObject<Item> SILICON_PIECE = ITEMS.register("silicon_piece", TypicalItem::new);
    public static final RegistryObject<Item> TELLURIUM_PIECE = ITEMS.register("tellurium_piece", TypicalItem::new);
    public static final RegistryObject<Item> MAGNESIUM_DIBORIDE = ITEMS.register("magnesium_diboride", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_TIN = ITEMS.register("niobium_tin", HeatResistantItem::new);
    public static final RegistryObject<Item> SILICON_CARBIDE = ITEMS.register("silicon_carbide", HeatResistantItem::new);

    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", TypicalItem::new);
    public static final RegistryObject<Item> BARIUM_NUGGET = ITEMS.register("barium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_NUGGET = ITEMS.register("cadmium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_NUGGET = ITEMS.register("calcium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> CERIUM_NUGGET = ITEMS.register("cerium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> CESIUM_NUGGET = ITEMS.register("cesium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> CHROMIUM_NUGGET = ITEMS.register("chromium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", TypicalItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_NUGGET = ITEMS.register("dysprosium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> ERBIUM_NUGGET = ITEMS.register("erbium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> EUROPIUM_NUGGET = ITEMS.register("europium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> GADOLINIUM_NUGGET = ITEMS.register("gadolinium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> HAFNIUM_NUGGET = ITEMS.register("hafnium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_NUGGET = ITEMS.register("holmium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> INDIUM_NUGGET = ITEMS.register("indium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> LANTHANUM_NUGGET = ITEMS.register("lanthanum_nugget", TypicalItem::new);
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", TypicalItem::new);
    public static final RegistryObject<Item> LITHIUM_NUGGET = ITEMS.register("lithium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> LUTETIUM_NUGGET = ITEMS.register("lutetium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_NUGGET = ITEMS.register("manganese_nugget", TypicalItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_NUGGET = ITEMS.register("molybdenum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_NUGGET = ITEMS.register("neodymium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_NUGGET = ITEMS.register("niobium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_NUGGET = ITEMS.register("potassium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_NUGGET = ITEMS.register("praseodymium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> RHENIUM_NUGGET = ITEMS.register("rhenium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_NUGGET = ITEMS.register("rhodium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_NUGGET = ITEMS.register("rubidium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> RUTHENIUM_NUGGET = ITEMS.register("ruthenium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_NUGGET = ITEMS.register("samarium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> SCANDIUM_NUGGET = ITEMS.register("scandium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_NUGGET = ITEMS.register("sodium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> STRONTIUM_NUGGET = ITEMS.register("strontium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> TANTALUM_NUGGET = ITEMS.register("tantalum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_NUGGET = ITEMS.register("terbium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> THALLIUM_NUGGET = ITEMS.register("thallium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> THORIUM_NUGGET = ITEMS.register("thorium_nugget", Thorium.Nugget::new);
    public static final RegistryObject<Item> THULIUM_NUGGET = ITEMS.register("thulium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", TypicalItem::new);
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", Uranium.Nugget::new);
    public static final RegistryObject<Item> VANADIUM_NUGGET = ITEMS.register("vanadium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_NUGGET = ITEMS.register("ytterbium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> YTTRIUM_NUGGET = ITEMS.register("yttrium_nugget", TypicalItem::new);
    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", TypicalItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_NUGGET = ITEMS.register("zirconium_nugget", HeatResistantItem::new);

    public static final RegistryObject<Item> PHOSPHORUS_DUST = ITEMS.register("phosphorus_dust", TypicalItem::new);
    public static final RegistryObject<Item> SELENIUM_DUST = ITEMS.register("selenium_dust", TypicalItem::new);
    public static final RegistryObject<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", TypicalItem::new);
    public static final RegistryObject<Item> GRAPHITE_DUST = ITEMS.register("graphite_dust", TypicalItem::new);
    public static final RegistryObject<Item> IODINE_DUST = ITEMS.register("iodine_dust", TypicalItem::new);

    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", TypicalItem::new);
    public static final RegistryObject<Item> BARIUM_DUST = ITEMS.register("barium_dust", TypicalItem::new);
    public static final RegistryObject<Item> BERYLLIUM_DUST = ITEMS.register("beryllium_dust", TypicalItem::new);
    public static final RegistryObject<Item> BISMUTH_DUST = ITEMS.register("bismuth_dust", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_DUST = ITEMS.register("cadmium_dust", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_DUST = ITEMS.register("calcium_dust", TypicalItem::new);
    public static final RegistryObject<Item> CERIUM_DUST = ITEMS.register("cerium_dust", TypicalItem::new);
    public static final RegistryObject<Item> CESIUM_DUST = ITEMS.register("cesium_dust", TypicalItem::new);
    public static final RegistryObject<Item> CHROMIUM_DUST = ITEMS.register("chromium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_DUST = ITEMS.register("cobalt_dust", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", TypicalItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_DUST = ITEMS.register("dysprosium_dust", TypicalItem::new);
    public static final RegistryObject<Item> ERBIUM_DUST = ITEMS.register("erbium_dust", TypicalItem::new);
    public static final RegistryObject<Item> EUROPIUM_DUST = ITEMS.register("europium_dust", TypicalItem::new);
    public static final RegistryObject<Item> GADOLINIUM_DUST = ITEMS.register("gadolinium_dust", TypicalItem::new);
    public static final RegistryObject<Item> GALLIUM_DUST = ITEMS.register("gallium_dust", TypicalItem::new);
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", TypicalItem::new);
    public static final RegistryObject<Item> HAFNIUM_DUST = ITEMS.register("hafnium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_DUST = ITEMS.register("holmium_dust", TypicalItem::new);
    public static final RegistryObject<Item> INDIUM_DUST = ITEMS.register("indium_dust", TypicalItem::new);
    public static final RegistryObject<Item> IRIDIUM_DUST = ITEMS.register("iridium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", TypicalItem::new);
    public static final RegistryObject<Item> LANTHANUM_DUST = ITEMS.register("lanthanum_dust", TypicalItem::new);
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", TypicalItem::new);
    public static final RegistryObject<Item> LITHIUM_DUST = ITEMS.register("lithium_dust", TypicalItem::new);
    public static final RegistryObject<Item> LUTETIUM_DUST = ITEMS.register("lutetium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_DUST = ITEMS.register("magnesium_dust", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_DUST = ITEMS.register("manganese_dust", TypicalItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_DUST = ITEMS.register("molybdenum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_DUST = ITEMS.register("neodymium_dust", TypicalItem::new);
    public static final RegistryObject<Item> NICKEL_DUST = ITEMS.register("nickel_dust", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_DUST = ITEMS.register("niobium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_DUST = ITEMS.register("osmium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_DUST = ITEMS.register("palladium_dust", TypicalItem::new);
    public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_DUST = ITEMS.register("potassium_dust", TypicalItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_DUST = ITEMS.register("praseodymium_dust", TypicalItem::new);
    public static final RegistryObject<Item> RHENIUM_DUST = ITEMS.register("rhenium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_DUST = ITEMS.register("rhodium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_DUST = ITEMS.register("rubidium_dust", TypicalItem::new);
    public static final RegistryObject<Item> RUTHENIUM_DUST = ITEMS.register("ruthenium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_DUST = ITEMS.register("samarium_dust", TypicalItem::new);
    public static final RegistryObject<Item> SCANDIUM_DUST = ITEMS.register("scandium_dust", TypicalItem::new);
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_DUST = ITEMS.register("sodium_dust", TypicalItem::new);
    public static final RegistryObject<Item> STRONTIUM_DUST = ITEMS.register("strontium_dust", TypicalItem::new);
    public static final RegistryObject<Item> TANTALUM_DUST = ITEMS.register("tantalum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_DUST = ITEMS.register("terbium_dust", TypicalItem::new);
    public static final RegistryObject<Item> THALLIUM_DUST = ITEMS.register("thallium_dust", TypicalItem::new);
    public static final RegistryObject<Item> THORIUM_DUST = ITEMS.register("thorium_dust", Thorium::new);
    public static final RegistryObject<Item> THULIUM_DUST = ITEMS.register("thulium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", TypicalItem::new);
    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_DUST = ITEMS.register("uranium_dust", Uranium::new);
    public static final RegistryObject<Item> VANADIUM_DUST = ITEMS.register("vanadium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_DUST = ITEMS.register("ytterbium_dust", TypicalItem::new);
    public static final RegistryObject<Item> YTTRIUM_DUST = ITEMS.register("yttrium_dust", TypicalItem::new);
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust", TypicalItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_DUST = ITEMS.register("zirconium_dust", HeatResistantItem::new);

    public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust", TypicalItem::new);
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust", TypicalItem::new);
    public static final RegistryObject<Item> CARBON_STEEL_DUST = ITEMS.register("carbon_steel_dust", TypicalItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_DUST = ITEMS.register("chromoly_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> COPPER_STEEL_DUST = ITEMS.register("copper_steel_dust", TypicalItem::new);
    public static final RegistryObject<Item> FERROBORON_DUST = ITEMS.register("ferroboron_dust", TypicalItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_DUST = ITEMS.register("hsla_steel_dust", TypicalItem::new);
    public static final RegistryObject<Item> INCONEL_DUST = ITEMS.register("inconel_dust", TypicalItem::new);
    public static final RegistryObject<Item> INVAR_DUST = ITEMS.register("invar_dust", TypicalItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_DUST = ITEMS.register("magnetic_neodymium_dust", TypicalItem::new);
    public static final RegistryObject<Item> MU_METAL_DUST = ITEMS.register("mu_metal_dust", TypicalItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_DUST = ITEMS.register("reactor_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_DUST = ITEMS.register("stainless_steel_dust", TypicalItem::new);
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", TypicalItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_DUST = ITEMS.register("tungsten_carbide_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_DUST = ITEMS.register("tungsten_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_DUST = ITEMS.register("vanasteel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCALOY_DUST = ITEMS.register("zircaloy_dust", HeatResistantItem::new);
    
    public static final RegistryObject<Item> ALUMINA = ITEMS.register("alumina", HeatResistantItem::new);
    public static final RegistryObject<Item> ALUMINUM_FLUORIDE = ITEMS.register("aluminum_fluoride", TypicalItem::new);
    public static final RegistryObject<Item> AMMONIUM_CHLORIDE = ITEMS.register("ammonium_chloride", TypicalItem::new);
    public static final RegistryObject<Item> AHCP = ITEMS.register("ahcp", TypicalItem::new);
    public static final RegistryObject<Item> APT = ITEMS.register("apt", TypicalItem::new);
    public static final RegistryObject<Item> ARSENIC_TRISULFIDE = ITEMS.register("arsenic_trisulfide", TypicalItem::new);
    public static final RegistryObject<Item> BAKING_SODA = ITEMS.register("baking_soda", TypicalItem::new);
    public static final RegistryObject<Item> BARIUM_OXIDE = ITEMS.register("barium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> BARIUM_SULFATE = ITEMS.register("barium_sulfate", HeatResistantItem::new);
    public static final RegistryObject<Item> BERYLLIUM_CHLORIDE = ITEMS.register("beryllium_chloride", TypicalItem::new);
    public static final RegistryObject<Item> BERYLLIUM_FLUORIDE = ITEMS.register("beryllium_fluoride", TypicalItem::new);
    public static final RegistryObject<Item> BERYLLIUM_SULFATE = ITEMS.register("beryllium_sulfate", TypicalItem::new);
    public static final RegistryObject<Item> BISMUTH_SULFIDE = ITEMS.register("bismuth_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> BN_DUST = ITEMS.register("bn_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> BORAX = ITEMS.register("borax", TypicalItem::new);
    public static final RegistryObject<Item> BORIC_ACID = ITEMS.register("boric_acid", TypicalItem::new);
    public static final RegistryObject<Item> BORON_TRIOXIDE = ITEMS.register("boron_trioxide", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_OXIDE = ITEMS.register("cadmium_oxide", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_SULFIDE = ITEMS.register("cadmium_sulfide", HeatResistantItem::new);
    public static final RegistryObject<Item> CALCIUM_CARBONATE = ITEMS.register("calcium_carbonate", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_CHLORIDE = ITEMS.register("calcium_chloride", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_FLUORIDE = ITEMS.register("calcium_fluoride", HeatResistantItem::new);
    public static final RegistryObject<Item> CALCIUM_OXIDE = ITEMS.register("calcium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> CALCIUM_PHOSPHATE = ITEMS.register("calcium_phosphate", TypicalItem::new);
    public static final RegistryObject<Item> CALCIUM_SULFATE = ITEMS.register("calcium_sulfate", HeatResistantItem::new);
    public static final RegistryObject<Item> CERIUM_DIOXIDE = ITEMS.register("cerium_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> CHROMIUM_OXIDE = ITEMS.register("chromium_oxide", TypicalItem::new);
    public static final RegistryObject<Item> COBALT_OXIDE = ITEMS.register("cobalt_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> COPPER_NITRATE = ITEMS.register("copper_nitrate", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_SULFIDE = ITEMS.register("copper_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_OXIDE = ITEMS.register("dysprosium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> ERBIUM_OXIDE = ITEMS.register("erbium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> EUROPIUM_OXIDE = ITEMS.register("europium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> FERRIC_SULFIDE = ITEMS.register("ferric_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> FERRIC_OXIDE = ITEMS.register("ferric_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> FERROUS_SULFIDE = ITEMS.register("ferrous_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> GADOLINIUM_OXIDE = ITEMS.register("gadolinium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> GERMANIUM_SULFIDE = ITEMS.register("germanium_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> HOLMIUM_OXIDE = ITEMS.register("holmium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> IRON_OXIDE_MIXED = ITEMS.register("iron_oxide_mixed", HeatResistantItem::new);
    public static final RegistryObject<Item> LANTHANUM_OXIDE = ITEMS.register("lanthanum_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> LEAD_OXIDE = ITEMS.register("lead_oxide", TypicalItem::new);
    public static final RegistryObject<Item> LEAD_SULFIDE = ITEMS.register("lead_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> LITHIUM_FLUORIDE = ITEMS.register("lithium_fluoride", TypicalItem::new);
    public static final RegistryObject<Item> LUTETIUM_OXIDE = ITEMS.register("lutetium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_CARBONATE = ITEMS.register("magnesium_carbonate", TypicalItem::new);
    public static final RegistryObject<Item> MAGNESIUM_CHLORIDE = ITEMS.register("magnesium_chloride", TypicalItem::new);
    public static final RegistryObject<Item> MAGNESIUM_FLUORIDE = ITEMS.register("magnesium_fluoride", TypicalItem::new);
    public static final RegistryObject<Item> MAGNESIUM_OXIDE = ITEMS.register("magnesium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_SULFATE = ITEMS.register("magnesium_sulfate", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_DIOXIDE = ITEMS.register("manganese_dioxide", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_OXIDE = ITEMS.register("manganese_oxide", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_SULFIDE = ITEMS.register("manganese_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_DISULFIDE = ITEMS.register("molybdenum_disulfide", HeatResistantItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_OXIDE = ITEMS.register("molybdenum_oxide", TypicalItem::new);
    public static final RegistryObject<Item> NEODYMIUM_OXIDE = ITEMS.register("neodymium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> NICKEL_CARBONATE = ITEMS.register("nickel_carbonate", TypicalItem::new);
    public static final RegistryObject<Item> NICKEL_IODIDE = ITEMS.register("nickel_iodide", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_PENTAFLUORIDE = ITEMS.register("niobium_pentafluoride", TypicalItem::new);
    public static final RegistryObject<Item> PHOSPHORIC_ACID = ITEMS.register("phosphoric_acid", TypicalItem::new);
    public static final RegistryObject<Item> PHOSPHORUS_PENTOXIDE = ITEMS.register("phosphorus_pentoxide", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_CHLORIDE = ITEMS.register("potassium_chloride", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_HYDROXIDE = ITEMS.register("potassium_hydroxide", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_IODIDE = ITEMS.register("potassium_iodide", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_OXIDE = ITEMS.register("potassium_oxide", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_PM = ITEMS.register("potassium_pm", TypicalItem::new);
    public static final RegistryObject<Item> POTASSIUM_SULFATE = ITEMS.register("potassium_sulfate", TypicalItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_OXIDE = ITEMS.register("praseodymium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_HYDROXIDE = ITEMS.register("praseodymium_hydroxide", TypicalItem::new);
    public static final RegistryObject<Item> PROTACTINIUM_DIOXIDE = ITEMS.register("protactinium_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> RHENIUM_DISULFIDE = ITEMS.register("rhenium_disulfide", TypicalItem::new);
    public static final RegistryObject<Item> RHENIUM_HEPTOXIDE = ITEMS.register("rhenium_heptoxide", TypicalItem::new);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", TypicalItem::new);
    public static final RegistryObject<Item> SAMARIUM_OXIDE = ITEMS.register("samarium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> SCANDIUM_OXIDE = ITEMS.register("scandium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> SELENIUM_DIOXIDE = ITEMS.register("selenium_dioxide", TypicalItem::new);
    public static final RegistryObject<Item> SILICA = ITEMS.register("silica", HeatResistantItem::new);
    public static final RegistryObject<Item> SILVER_NITRATE = ITEMS.register("silver_nitrate", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_CARBONATE = ITEMS.register("sodium_carbonate", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_CYANIDE = ITEMS.register("sodium_cyanide", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_FLUORIDE = ITEMS.register("sodium_fluoride", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_HYDRIDE = ITEMS.register("sodium_hydride", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_HYDROXIDE = ITEMS.register("sodium_hydroxide", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_OXIDE = ITEMS.register("sodium_oxide", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_SULFATE = ITEMS.register("sodium_sulfate", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_SULFIDE = ITEMS.register("sodium_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_SULFITE = ITEMS.register("sodium_sulfite", TypicalItem::new);
    public static final RegistryObject<Item> SODIUM_THIOSULFATE = ITEMS.register("sodium_thiosulfate", TypicalItem::new);
    public static final RegistryObject<Item> STRONTIUM_OXIDE = ITEMS.register("strontium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> STRONTIUM_SULFATE = ITEMS.register("strontium_sulfate", HeatResistantItem::new);
    public static final RegistryObject<Item> TANTALUM_PENTAFLUORIDE = ITEMS.register("tantalum_pentafluoride", TypicalItem::new);
    public static final RegistryObject<Item> TERBIUM_OXIDE = ITEMS.register("terbium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_DIOXIDE = ITEMS.register("tin_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> TITANIUM_DIOXIDE = ITEMS.register("titanium_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> THALLIUM_SULFIDE = ITEMS.register("thallium_sulfide", TypicalItem::new);
    public static final RegistryObject<Item> THORIUM_DIOXIDE = ITEMS.register("thorium_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> THORIUM_TETRAFLUORIDE = ITEMS.register("thorium_tetrafluoride", TypicalItem::new);
    public static final RegistryObject<Item> THULIUM_OXIDE = ITEMS.register("thulium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_OXIDE = ITEMS.register("tungsten_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_DIOXIDE = ITEMS.register("uranium_dioxide", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_TETRAFLUORIDE = ITEMS.register("uranium_tetrafluoride", TypicalItem::new);
    public static final RegistryObject<Item> URANIUM_HEXAFLUORIDE = ITEMS.register("uranium_hexafluoride", TypicalItem::new);
    public static final RegistryObject<Item> VANADIUM_PENTOXIDE = ITEMS.register("vanadium_pentoxide", TypicalItem::new);
    public static final RegistryObject<Item> YTTERBIUM_OXIDE = ITEMS.register("ytterbium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTRIUM_OXIDE = ITEMS.register("yttrium_oxide", HeatResistantItem::new);
    public static final RegistryObject<Item> ZINC_NITRATE = ITEMS.register("zinc_nitrate", TypicalItem::new);
    public static final RegistryObject<Item> ZINC_SULFIDE = ITEMS.register("zinc_sulfide", TypicalItem::new);

    public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", TypicalItem::new);
    public static final RegistryObject<Item> BISMUTH_PLATE = ITEMS.register("bismuth_plate", TypicalItem::new);
    public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", TypicalItem::new);
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", TypicalItem::new);
    public static final RegistryObject<Item> CADMIUM_PLATE = ITEMS.register("cadmium_plate", TypicalItem::new);
    public static final RegistryObject<Item> CHROMIUM_PLATE = ITEMS.register("chromium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_PLATE = ITEMS.register("chromoly_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_PLATE = ITEMS.register("cobalt_plate", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", TypicalItem::new);
    public static final RegistryObject<Item> COPPER_STEEL_PLATE = ITEMS.register("copper_steel_plate", TypicalItem::new);
    public static final RegistryObject<Item> FERROBORON_PLATE = ITEMS.register("ferroboron_plate", TypicalItem::new);
    public static final RegistryObject<Item> GALVANZIED_STEEL_PLATE = ITEMS.register("galvanized_steel_plate", TypicalItem::new);
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate", TypicalItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_PLATE = ITEMS.register("hsla_steel_plate", TypicalItem::new);
    public static final RegistryObject<Item> INCONEL_PLATE = ITEMS.register("inconel_plate", TypicalItem::new);
    public static final RegistryObject<Item> INDIUM_PLATE = ITEMS.register("indium_plate", TypicalItem::new);
    public static final RegistryObject<Item> INVAR_PLATE = ITEMS.register("invar_plate", TypicalItem::new);
    public static final RegistryObject<Item> IRIDIUM_PLATE = ITEMS.register("iridium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", TypicalItem::new);
    public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", TypicalItem::new);
    public static final RegistryObject<Item> MAGNESIUM_PLATE = ITEMS.register("magnesium_plate", TypicalItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_PLATE = ITEMS.register("magnetic_neodymium_plate", TypicalItem::new);
    public static final RegistryObject<Item> MANGANESE_PLATE = ITEMS.register("manganese_plate", TypicalItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_PLATE = ITEMS.register("molybdenum_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> MU_METAL_PLATE = ITEMS.register("mu_metal_plate", TypicalItem::new);
    public static final RegistryObject<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", TypicalItem::new);
    public static final RegistryObject<Item> NIOBIUM_PLATE = ITEMS.register("niobium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_PLATE = ITEMS.register("osmium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_PLATE = ITEMS.register("palladium_plate", TypicalItem::new);
    public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_PLATE = ITEMS.register("reactor_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_PLATE = ITEMS.register("rhodium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> SCANDIUM_PLATE = ITEMS.register("scandium_plate", TypicalItem::new);
    public static final RegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate", TypicalItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_PLATE = ITEMS.register("stainless_steel_plate", TypicalItem::new);
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", TypicalItem::new);
    public static final RegistryObject<Item> THORIUM_PLATE = ITEMS.register("thorium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> THULIUM_PLATE = ITEMS.register("thulium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", TypicalItem::new);
    public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PLATE = ITEMS.register("tungsten_carbide_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_PLATE = ITEMS.register("tungsten_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_PLATE = ITEMS.register("tungsten_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_PLATE = ITEMS.register("vanasteel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_PLATE = ITEMS.register("ytterbium_plate", TypicalItem::new);
    public static final RegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", TypicalItem::new);
    public static final RegistryObject<Item> ZIRCALOY_PLATE = ITEMS.register("zircaloy_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_PLATE = ITEMS.register("zirconium_plate", HeatResistantItem::new);


    public static final RegistryObject<Item> BORON_HELMET = ITEMS.register("boron_helmet", () -> new HeatResArmor(ModArmors.BORON, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> BORON_CHESTPLATE = ITEMS.register("boron_chestplate", () -> new HeatResArmor(ModArmors.BORON, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> BORON_LEGGINGS = ITEMS.register("boron_leggings", () -> new HeatResArmor(ModArmors.BORON, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> BORON_BOOTS = ITEMS.register("boron_boots", () -> new HeatResArmor(ModArmors.BORON, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new TekoraArmor(ModArmors.BRONZE, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new TekoraArmor(ModArmors.BRONZE, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new TekoraArmor(ModArmors.BRONZE, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new TekoraArmor(ModArmors.BRONZE, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () -> new HeatResArmor(ModArmors.PLATINUM, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () -> new HeatResArmor(ModArmors.PLATINUM, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () -> new HeatResArmor(ModArmors.PLATINUM, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () -> new HeatResArmor(ModArmors.PLATINUM, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new TekoraArmor(ModArmors.SILVER, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new TekoraArmor(ModArmors.SILVER, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new TekoraArmor(ModArmors.SILVER, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new TekoraArmor(ModArmors.SILVER, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new TekoraArmor(ModArmors.STEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new TekoraArmor(ModArmors.STEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new TekoraArmor(ModArmors.STEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new TekoraArmor(ModArmors.STEEL, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new HeatResArmor(ModArmors.TITANIUM, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new HeatResArmor(ModArmors.TITANIUM, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new HeatResArmor(ModArmors.TITANIUM, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new HeatResArmor(ModArmors.TITANIUM, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_HELMET = ITEMS.register("tungsten_steel_helmet", () -> new HeatResArmor(ModArmors.TUNGSTEN_STEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_CHESTPLATE = ITEMS.register("tungsten_steel_chestplate", () -> new HeatResArmor(ModArmors.TUNGSTEN_STEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_LEGGINGS = ITEMS.register("tungsten_steel_leggings", () -> new HeatResArmor(ModArmors.TUNGSTEN_STEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_BOOTS = ITEMS.register("tungsten_steel_boots", () -> new HeatResArmor(ModArmors.TUNGSTEN_STEEL, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> VANASTEEL_HELMET = ITEMS.register("vanasteel_helmet", () -> new HeatResArmor(ModArmors.VANASTEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> VANASTEEL_CHESTPLATE = ITEMS.register("vanasteel_chestplate", () -> new HeatResArmor(ModArmors.VANASTEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> VANASTEEL_LEGGINGS = ITEMS.register("vanasteel_leggings", () -> new HeatResArmor(ModArmors.VANASTEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> VANASTEEL_BOOTS = ITEMS.register("vanasteel_boots", () -> new HeatResArmor(ModArmors.VANASTEEL, ArmorItem.Type.BOOTS));


    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
            new HammerItem(Tiers.DIAMOND, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () ->
            new HammerItem(Tiers.GOLD, new Item.Properties()));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
            new HammerItem(Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () ->
            new HammerItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    
    
    public static final RegistryObject<Item> BORON_AXE = ITEMS.register("boron_axe", () ->
            new AxeItem(ModTiers.BORON,5.0f, 3.0f, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_HOE = ITEMS.register("boron_hoe", () ->
            new HoeItem(ModTiers.BORON,-6,0, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_PICKAXE = ITEMS.register("boron_pickaxe", () ->
            new PickaxeItem(ModTiers.BORON,1, -2.8f, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_SHOVEL = ITEMS.register("boron_shovel", () ->
            new ShovelItem(ModTiers.BORON, 1.5f, -3.0f,new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_SWORD = ITEMS.register("boron_sword", () ->
            new SwordItem(ModTiers.BORON, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BORON_HAMMER = ITEMS.register("boron_hammer", () ->
            new HammerItem(ModTiers.BORON, new Item.Properties().fireResistant()));
    

    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () ->
            new AxeItem(ModTiers.BRONZE, 6.0f, 3.1f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () ->
            new HoeItem(ModTiers.BRONZE,-2,0,  new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () ->
            new PickaxeItem(ModTiers.BRONZE,1,-2.8f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () ->
            new ShovelItem(ModTiers.BRONZE,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () ->
            new SwordItem(ModTiers.BRONZE, 3, -2.4f,new Item.Properties()));
    
    public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () ->
            new HammerItem(ModTiers.BRONZE, new Item.Properties()));


    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () ->
            new AxeItem(ModTiers.PLATINUM, 6.0f, 3.2f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () ->
            new HoeItem(ModTiers.PLATINUM, -3,0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () ->
            new PickaxeItem(ModTiers.PLATINUM,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () ->
            new ShovelItem(ModTiers.PLATINUM, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () ->
            new SwordItem(ModTiers.PLATINUM, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_HAMMER = ITEMS.register("platinum_hammer", () ->
            new HammerItem(ModTiers.PLATINUM, new Item.Properties().fireResistant()));


    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () ->
            new AxeItem(ModTiers.SILVER,5.6f, 3.2f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () ->
            new HoeItem(ModTiers.SILVER, 0,0, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () ->
            new PickaxeItem(ModTiers.SILVER,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () ->
            new ShovelItem(ModTiers.SILVER, 1.5f, -3.0f,new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () ->
            new SwordItem(ModTiers.SILVER, 3, -2.4f,new Item.Properties()));
    
    public static final RegistryObject<Item> SILVER_HAMMER = ITEMS.register("silver_hammer", () ->
            new HammerItem(ModTiers.SILVER, new Item.Properties()));


    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () ->
            new AxeItem(ModTiers.STEEL, 6.0f, 3.1f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () ->
            new HoeItem(ModTiers.STEEL, -2, 0, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () ->
            new PickaxeItem(ModTiers.STEEL,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () ->
            new ShovelItem(ModTiers.STEEL, 1.5f, -3.0f,new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () ->
            new SwordItem(ModTiers.STEEL, 3, -2.4f,new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer", () ->
            new HammerItem(ModTiers.STEEL, new Item.Properties()));

    public static final RegistryObject<Item> THORIUM_AXE = ITEMS.register("thorium_axe", ThoriumAxe::new);
    public static final RegistryObject<Item> THORIUM_HOE = ITEMS.register("thorium_hoe", ThoriumHoe::new);
    public static final RegistryObject<Item> THORIUM_PICKAXE = ITEMS.register("thorium_pickaxe", ThoriumPickaxe::new);
    public static final RegistryObject<Item> THORIUM_SHOVEL = ITEMS.register("thorium_shovel", ThoriumShovel::new);
    public static final RegistryObject<Item> THORIUM_SWORD = ITEMS.register("thorium_sword", ThoriumSword::new);
    public static final RegistryObject<Item> THORIUM_HAMMER = ITEMS.register("thorium_hammer", ThoriumHammer::new);

    
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () ->
            new AxeItem(ModTiers.TITANIUM, 5.0f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () ->
            new HoeItem(ModTiers.TITANIUM, -5, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () ->
            new PickaxeItem(ModTiers.TITANIUM,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () ->
            new ShovelItem(ModTiers.TITANIUM, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () ->
            new SwordItem(ModTiers.TITANIUM, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer", () ->
            new HammerItem(ModTiers.TITANIUM, new Item.Properties().fireResistant()));

    
    public static final RegistryObject<Item> TUNGSTEN_STEEL_AXE = ITEMS.register("tungsten_steel_axe", () ->
            new AxeItem(ModTiers.TUNGSTEN_STEEL, 5.5f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_HOE = ITEMS.register("tungsten_steel_hoe", () ->
            new HoeItem(ModTiers.TUNGSTEN_STEEL, -4, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_PICKAXE = ITEMS.register("tungsten_steel_pickaxe", () ->
            new PickaxeItem(ModTiers.TUNGSTEN_STEEL,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_SHOVEL = ITEMS.register("tungsten_steel_shovel", () ->
            new ShovelItem(ModTiers.TUNGSTEN_STEEL, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_SWORD = ITEMS.register("tungsten_steel_sword", () ->
            new SwordItem(ModTiers.TUNGSTEN_STEEL, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_HAMMER = ITEMS.register("tungsten_steel_hammer", () ->
            new HammerItem(ModTiers.TUNGSTEN_STEEL, new Item.Properties().fireResistant()));
    

    public static final RegistryObject<Item> VANASTEEL_AXE = ITEMS.register("vanasteel_axe", () ->
            new AxeItem(ModTiers.VANASTEEL, 5.0f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_HOE = ITEMS.register("vanasteel_hoe", () ->
            new HoeItem(ModTiers.VANASTEEL, -6, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_PICKAXE = ITEMS.register("vanasteel_pickaxe", () ->
            new PickaxeItem(ModTiers.VANASTEEL,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_SHOVEL = ITEMS.register("vanasteel_shovel", () ->
            new ShovelItem(ModTiers.VANASTEEL, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_SWORD = ITEMS.register("vanasteel_sword", () ->
            new SwordItem(ModTiers.VANASTEEL, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_HAMMER = ITEMS.register("vanasteel_hammer", () ->
            new HammerItem(ModTiers.VANASTEEL, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}