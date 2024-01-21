package net.nukollodda.tekora.item;

import net.nukollodda.tekora.fluid.TekoraFluids;
import net.nukollodda.tekora.item.armors.TekoraArmor;
import net.nukollodda.tekora.item.containers.Canister;
import net.nukollodda.tekora.item.containers.TekoraBucketItem;
import net.nukollodda.tekora.item.isotopic.Lithium;
import net.nukollodda.tekora.item.isotopic.radioactive.*;
import net.nukollodda.tekora.item.mixtures.Residue;
import net.nukollodda.tekora.item.tools.HammerItem;
import net.nukollodda.tekora.item.tools.SmithingTemplates;
import net.nukollodda.tekora.item.tools.thorium.*;
import net.nukollodda.tekora.item.typical.*;
import net.minecraft.world.item.*;
import net.nukollodda.tekora.Tekora;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.item.armors.HeatResArmor;
import net.nukollodda.tekora.tiers.TekoraArmors;
import net.nukollodda.tekora.tiers.TekoraTiers;

public class TekoraItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tekora.MODID);

    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine", TekoraItem::new);
    public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", TekoraItem::new);
    public static final RegistryObject<Item> CHROMITE = ITEMS.register("chromite", TekoraItem::new);
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", TekoraItem::new);
    public static final RegistryObject<Item> COLTAN = ITEMS.register("coltan", TekoraItem::new);
    public static final RegistryObject<Item> DOLOMITE = ITEMS.register("dolomite", TekoraItem::new);
    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite", TekoraItem::new);
    public static final RegistryObject<Item> HALITE = ITEMS.register("halite", TekoraItem::new);
    public static final RegistryObject<Item> MONAZITE = ITEMS.register("monazite", TekoraItem::new);
    public static final RegistryObject<Item> PYROLUSITE = ITEMS.register("pyrolusite", TekoraItem::new);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", TekoraItem::new);
    public static final RegistryObject<Item> RUTILE = ITEMS.register("rutile", TekoraItem::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", TekoraItem::new);
    public static final RegistryObject<Item> URANINITE = ITEMS.register("uraninite", TekoraItem::new);
    public static final RegistryObject<Item> WOLFRAMITE = ITEMS.register("wolframite", TekoraItem::new);
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", TekoraItem::new);

    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", TekoraItem::new);
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", TekoraItem::new);
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", TekoraItem::new);
    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum", TekoraItem::new);
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", TekoraItem::new);
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", TekoraItem::new);

    public static final RegistryObject<Item> COLTAN_PIECE = ITEMS.register("coltan_piece", TekoraItem::new);
    public static final RegistryObject<Item> MONAZITE_SHARD = ITEMS.register("monazite_shard", TekoraItem::new);
    public static final RegistryObject<Item> PYROLUSITE_PIECE = ITEMS.register("pyrolusite_piece", TekoraItem::new);
    public static final RegistryObject<Item> RUTILE_SHARD = ITEMS.register("rutile_shard", TekoraItem::new);
    public static final RegistryObject<Item> WOLFRAMITE_PIECE = ITEMS.register("wolframite_piece", TekoraItem::new);

    public static final RegistryObject<Item> PULVERIZED_ANCIENT_DEBRIS = ITEMS.register("pulverized_ancient_debris", () -> new TekoraItem(true));
    public static final RegistryObject<Item> PULVERIZED_AQUAMARINE_ORE = ITEMS.register("pulverized_aquamarine_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_BAUXITE_ORE = ITEMS.register("pulverized_bauxite_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_CINNABAR_ORE = ITEMS.register("pulverized_cinnabar_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_COAL_ORE = ITEMS.register("pulverized_coal_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_DIAMOND_ORE = ITEMS.register("pulverized_diamond_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_EMERALD_ORE = ITEMS.register("pulverized_emerald_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_HALITE_ORE = ITEMS.register("pulverized_halite_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_LAPIS_ORE = ITEMS.register("pulverized_lapis_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_QUARTZ_ORE = ITEMS.register("pulverized_quartz_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_REDSTONE_ORE = ITEMS.register("pulverized_redstone_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_RUBY_ORE = ITEMS.register("pulverized_ruby_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_SAPPHIRE_ORE = ITEMS.register("pulverized_sapphire_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_URANINITE_ORE = ITEMS.register("pulverized_uraninite_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_WOLFRAMITE_ORE = ITEMS.register("pulverized_wolframite_ore", TekoraItem::new);
    public static final RegistryObject<Item> PULVERIZED_ZIRCON_ORE = ITEMS.register("pulverized_zircon_ore", TekoraItem::new);

    public static final RegistryObject<Item> GRAPHITE_BAR = ITEMS.register("graphite_bar", TekoraItem::new);
    public static final RegistryObject<Item> IODINE_BAR = ITEMS.register("iodine_bar", TekoraItem::new);
    public static final RegistryObject<Item> COPPER_STEEL = ITEMS.register("copper_steel", TekoraItem::new);
    
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", TekoraItem::new);
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", TekoraItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", TekoraItem::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", TekoraItem::new);
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", Lithium::new);
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", TekoraItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", TekoraItem::new);
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", Thorium::new);
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TekoraItem::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", Uranium::new);
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", TekoraItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", HeatResistantItem::new);
    
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", TekoraItem::new);
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_INGOT = ITEMS.register("chromoly_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> FERROBORON_INGOT = ITEMS.register("ferroboron_ingot", TekoraItem::new);
    public static final RegistryObject<Item> GALVANIZED_STEEL_INGOT = ITEMS.register("galvanized_steel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_INGOT = ITEMS.register("hsla_steel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> INCONEL_INGOT = ITEMS.register("inconel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot", TekoraItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_INGOT = ITEMS.register("magnetic_neodymium_ingot", TekoraItem::new);
    public static final RegistryObject<Item> MU_METAL_INGOT = ITEMS.register("mu_metal_ingot", TekoraItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_INGOT = ITEMS.register("reactor_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_INGOT = ITEMS.register("stainless_steel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", TekoraItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = ITEMS.register("tungsten_carbide_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_INGOT = ITEMS.register("tungsten_steel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_INGOT = ITEMS.register("vanasteel_ingot", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register("zircaloy_ingot", HeatResistantItem::new);
    
    public static final RegistryObject<Item> ANTIMONY_PIECE = ITEMS.register("antimony_piece", TekoraItem::new);
    public static final RegistryObject<Item> ARSENIC_PIECE = ITEMS.register("arsenic_piece", TekoraItem::new);
    public static final RegistryObject<Item> BORON_PIECE = ITEMS.register("boron_piece", HeatResistantItem::new);
    public static final RegistryObject<Item> GERMANIUM_PIECE = ITEMS.register("germanium_piece", TekoraItem::new);
    public static final RegistryObject<Item> SILICON_PIECE = ITEMS.register("silicon_piece", TekoraItem::new);
    public static final RegistryObject<Item> TELLURIUM_PIECE = ITEMS.register("tellurium_piece", TekoraItem::new);
    public static final RegistryObject<Item> MAGNESIUM_DIBORIDE = ITEMS.register("magnesium_diboride", TekoraItem::new);
    public static final RegistryObject<Item> NIOBIUM_TIN = ITEMS.register("niobium_tin", HeatResistantItem::new);
    public static final RegistryObject<Item> SILICON_CARBIDE = ITEMS.register("silicon_carbide", HeatResistantItem::new);

    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", TekoraItem::new);
    public static final RegistryObject<Item> BARIUM_NUGGET = ITEMS.register("barium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget", TekoraItem::new);
    public static final RegistryObject<Item> CADMIUM_NUGGET = ITEMS.register("cadmium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> CALCIUM_NUGGET = ITEMS.register("calcium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> CERIUM_NUGGET = ITEMS.register("cerium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> CESIUM_NUGGET = ITEMS.register("cesium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> CHROMIUM_NUGGET = ITEMS.register("chromium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget", TekoraItem::new);
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", TekoraItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_NUGGET = ITEMS.register("dysprosium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> ERBIUM_NUGGET = ITEMS.register("erbium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> EUROPIUM_NUGGET = ITEMS.register("europium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> GADOLINIUM_NUGGET = ITEMS.register("gadolinium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> HAFNIUM_NUGGET = ITEMS.register("hafnium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_NUGGET = ITEMS.register("holmium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> INDIUM_NUGGET = ITEMS.register("indium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> LANTHANUM_NUGGET = ITEMS.register("lanthanum_nugget", TekoraItem::new);
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", TekoraItem::new);
    public static final RegistryObject<Item> LITHIUM_NUGGET = ITEMS.register("lithium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> LUTETIUM_NUGGET = ITEMS.register("lutetium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> MANGANESE_NUGGET = ITEMS.register("manganese_nugget", TekoraItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_NUGGET = ITEMS.register("molybdenum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_NUGGET = ITEMS.register("neodymium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", TekoraItem::new);
    public static final RegistryObject<Item> NIOBIUM_NUGGET = ITEMS.register("niobium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_NUGGET = ITEMS.register("potassium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_NUGGET = ITEMS.register("praseodymium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> RHENIUM_NUGGET = ITEMS.register("rhenium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_NUGGET = ITEMS.register("rhodium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_NUGGET = ITEMS.register("rubidium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> RUTHENIUM_NUGGET = ITEMS.register("ruthenium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_NUGGET = ITEMS.register("samarium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> SCANDIUM_NUGGET = ITEMS.register("scandium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", TekoraItem::new);
    public static final RegistryObject<Item> SODIUM_NUGGET = ITEMS.register("sodium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> STRONTIUM_NUGGET = ITEMS.register("strontium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> TANTALUM_NUGGET = ITEMS.register("tantalum_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_NUGGET = ITEMS.register("terbium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> THALLIUM_NUGGET = ITEMS.register("thallium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> THORIUM_NUGGET = ITEMS.register("thorium_nugget", Thorium.Nugget::new);
    public static final RegistryObject<Item> THULIUM_NUGGET = ITEMS.register("thulium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", TekoraItem::new);
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", Uranium.Nugget::new);
    public static final RegistryObject<Item> VANADIUM_NUGGET = ITEMS.register("vanadium_nugget", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_NUGGET = ITEMS.register("ytterbium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> YTTRIUM_NUGGET = ITEMS.register("yttrium_nugget", TekoraItem::new);
    public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", TekoraItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_NUGGET = ITEMS.register("zirconium_nugget", HeatResistantItem::new);

    public static final RegistryObject<Item> PHOSPHORUS_DUST = ITEMS.register("phosphorus_dust", TekoraItem::new);
    public static final RegistryObject<Item> SELENIUM_DUST = ITEMS.register("selenium_dust", TekoraItem::new);
    public static final RegistryObject<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", TekoraItem::new);
    public static final RegistryObject<Item> GRAPHITE_DUST = ITEMS.register("graphite_dust", TekoraItem::new);
    public static final RegistryObject<Item> IODINE_DUST = ITEMS.register("iodine_dust", TekoraItem::new);

    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", TekoraItem::new);
    public static final RegistryObject<Item> BARIUM_DUST = ITEMS.register("barium_dust", TekoraItem::new);
    public static final RegistryObject<Item> BERYLLIUM_DUST = ITEMS.register("beryllium_dust", TekoraItem::new);
    public static final RegistryObject<Item> BISMUTH_DUST = ITEMS.register("bismuth_dust", TekoraItem::new);
    public static final RegistryObject<Item> CADMIUM_DUST = ITEMS.register("cadmium_dust", TekoraItem::new);
    public static final RegistryObject<Item> CALCIUM_DUST = ITEMS.register("calcium_dust", TekoraItem::new);
    public static final RegistryObject<Item> CERIUM_DUST = ITEMS.register("cerium_dust", TekoraItem::new);
    public static final RegistryObject<Item> CESIUM_DUST = ITEMS.register("cesium_dust", TekoraItem::new);
    public static final RegistryObject<Item> CHROMIUM_DUST = ITEMS.register("chromium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_DUST = ITEMS.register("cobalt_dust", TekoraItem::new);
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", TekoraItem::new);
    public static final RegistryObject<Item> DYSPROSIUM_DUST = ITEMS.register("dysprosium_dust", TekoraItem::new);
    public static final RegistryObject<Item> ERBIUM_DUST = ITEMS.register("erbium_dust", TekoraItem::new);
    public static final RegistryObject<Item> EUROPIUM_DUST = ITEMS.register("europium_dust", TekoraItem::new);
    public static final RegistryObject<Item> GADOLINIUM_DUST = ITEMS.register("gadolinium_dust", TekoraItem::new);
    public static final RegistryObject<Item> GALLIUM_DUST = ITEMS.register("gallium_dust", TekoraItem::new);
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", TekoraItem::new);
    public static final RegistryObject<Item> HAFNIUM_DUST = ITEMS.register("hafnium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> HOLMIUM_DUST = ITEMS.register("holmium_dust", TekoraItem::new);
    public static final RegistryObject<Item> INDIUM_DUST = ITEMS.register("indium_dust", TekoraItem::new);
    public static final RegistryObject<Item> IRIDIUM_DUST = ITEMS.register("iridium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", TekoraItem::new);
    public static final RegistryObject<Item> LANTHANUM_DUST = ITEMS.register("lanthanum_dust", TekoraItem::new);
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", TekoraItem::new);
    public static final RegistryObject<Item> LITHIUM_DUST = ITEMS.register("lithium_dust", TekoraItem::new);
    public static final RegistryObject<Item> LUTETIUM_DUST = ITEMS.register("lutetium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> MAGNESIUM_DUST = ITEMS.register("magnesium_dust", TekoraItem::new);
    public static final RegistryObject<Item> MANGANESE_DUST = ITEMS.register("manganese_dust", TekoraItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_DUST = ITEMS.register("molybdenum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> NEODYMIUM_DUST = ITEMS.register("neodymium_dust", TekoraItem::new);
    public static final RegistryObject<Item> NICKEL_DUST = ITEMS.register("nickel_dust", TekoraItem::new);
    public static final RegistryObject<Item> NIOBIUM_DUST = ITEMS.register("niobium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_DUST = ITEMS.register("osmium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_DUST = ITEMS.register("palladium_dust", TekoraItem::new);
    public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> POTASSIUM_DUST = ITEMS.register("potassium_dust", TekoraItem::new);
    public static final RegistryObject<Item> PRASEODYMIUM_DUST = ITEMS.register("praseodymium_dust", TekoraItem::new);
    public static final RegistryObject<Item> RHENIUM_DUST = ITEMS.register("rhenium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_DUST = ITEMS.register("rhodium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> RUBIDIUM_DUST = ITEMS.register("rubidium_dust", TekoraItem::new);
    public static final RegistryObject<Item> RUTHENIUM_DUST = ITEMS.register("ruthenium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> SAMARIUM_DUST = ITEMS.register("samarium_dust", TekoraItem::new);
    public static final RegistryObject<Item> SCANDIUM_DUST = ITEMS.register("scandium_dust", TekoraItem::new);
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", TekoraItem::new);
    public static final RegistryObject<Item> SODIUM_DUST = ITEMS.register("sodium_dust", TekoraItem::new);
    public static final RegistryObject<Item> STRONTIUM_DUST = ITEMS.register("strontium_dust", TekoraItem::new);
    public static final RegistryObject<Item> TANTALUM_DUST = ITEMS.register("tantalum_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TERBIUM_DUST = ITEMS.register("terbium_dust", TekoraItem::new);
    public static final RegistryObject<Item> THALLIUM_DUST = ITEMS.register("thallium_dust", TekoraItem::new);
    public static final RegistryObject<Item> THORIUM_DUST = ITEMS.register("thorium_dust", Thorium::new);
    public static final RegistryObject<Item> THULIUM_DUST = ITEMS.register("thulium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", TekoraItem::new);
    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> URANIUM_DUST = ITEMS.register("uranium_dust", Uranium::new);
    public static final RegistryObject<Item> VANADIUM_DUST = ITEMS.register("vanadium_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_DUST = ITEMS.register("ytterbium_dust", TekoraItem::new);
    public static final RegistryObject<Item> YTTRIUM_DUST = ITEMS.register("yttrium_dust", TekoraItem::new);
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust", TekoraItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_DUST = ITEMS.register("zirconium_dust", HeatResistantItem::new);

    public static final RegistryObject<Item> ARSENIC_DUST = ITEMS.register("arsenic_dust", TekoraItem::new);
    public static final RegistryObject<Item> ANTIMONY_DUST = ITEMS.register("antimony_dust", TekoraItem::new);
    public static final RegistryObject<Item> BORON_DUST = ITEMS.register("boron_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> GERMANIUM_DUST = ITEMS.register("germanium_dust", TekoraItem::new);
    public static final RegistryObject<Item> SILICON_DUST = ITEMS.register("silicon_dust", TekoraItem::new);
    public static final RegistryObject<Item> TELLURIUM_DUST = ITEMS.register("tellurium_dust", TekoraItem::new);

    public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust", TekoraItem::new);
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust", TekoraItem::new);
    public static final RegistryObject<Item> CARBON_STEEL_DUST = ITEMS.register("carbon_steel_dust", TekoraItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_DUST = ITEMS.register("chromoly_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> COPPER_STEEL_DUST = ITEMS.register("copper_steel_dust", TekoraItem::new);
    public static final RegistryObject<Item> FERROBORON_DUST = ITEMS.register("ferroboron_dust", TekoraItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_DUST = ITEMS.register("hsla_steel_dust", TekoraItem::new);
    public static final RegistryObject<Item> INCONEL_DUST = ITEMS.register("inconel_dust", TekoraItem::new);
    public static final RegistryObject<Item> INVAR_DUST = ITEMS.register("invar_dust", TekoraItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_DUST = ITEMS.register("magnetic_neodymium_dust", TekoraItem::new);
    public static final RegistryObject<Item> MU_METAL_DUST = ITEMS.register("mu_metal_dust", TekoraItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_DUST = ITEMS.register("reactor_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_DUST = ITEMS.register("stainless_steel_dust", TekoraItem::new);
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", TekoraItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_DUST = ITEMS.register("tungsten_carbide_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_DUST = ITEMS.register("tungsten_steel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_DUST = ITEMS.register("vanasteel_dust", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCALOY_DUST = ITEMS.register("zircaloy_dust", HeatResistantItem::new);


    public static final RegistryObject<Item> ALUMINA = ITEMS.register("alumina",
            () -> new CompoundItem("aluminum", "oxide", true));
    public static final RegistryObject<Item> AHCP = ITEMS.register("ahcp", TekoraItem::new); // ammonium hexachloroplatinate
    public static final RegistryObject<Item> APT = ITEMS.register("apt", TekoraItem::new); // ammonium paratungstate
    public static final RegistryObject<Item> BAKING_SODA = ITEMS.register("baking_soda", TekoraItem::new);
    public static final RegistryObject<Item> BN_DUST = ITEMS.register("bn_dust",
            () -> new CompoundItem("boron", "nitride"));
    public static final RegistryObject<Item> BORAX = ITEMS.register("borax", TekoraItem::new);
    public static final RegistryObject<Item> BORIC_ACID = ITEMS.register("boric_acid", TekoraItem::new);
    public static final RegistryObject<Item> PHOSPHORIC_ACID = ITEMS.register("phosphoric_acid", TekoraItem::new);
    public static final RegistryObject<Item> POTASSIUM_IODIDE = ITEMS.register("potassium_iodide",
            () -> new CompoundItem("potassium", "iodide"));
    public static final RegistryObject<Item> POTASSIUM_PM = ITEMS.register("potassium_pm", TekoraItem::new);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new CompoundItem("sodium", "chloride"));
    public static final RegistryObject<Item> SILICA = ITEMS.register("silica",
            () -> new CompoundItem("silicon", "oxide", true));
    public static final RegistryObject<Item> SODIUM_HYDRIDE = ITEMS.register("sodium_hydride", TekoraItem::new);
    public static final RegistryObject<Item> TITANIUM_DIOXIDE = ITEMS.register("titanium_dioxide",
            () -> new CompoundItem("titanium", "oxide", true));
    public static final RegistryObject<Item> TUNGSTEN_OXIDE = ITEMS.register("tungsten_oxide",
            () -> new CompoundItem("tungsten", "oxide", true));
    public static final RegistryObject<Item> GENERIC_DUST = ITEMS.register("dust", DustItem::new);

    public static final RegistryObject<Residue> RESIDUE = ITEMS.register("residue", Residue::new);

    public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", TekoraItem::new);
    public static final RegistryObject<Item> BISMUTH_PLATE = ITEMS.register("bismuth_plate", TekoraItem::new);
    public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", TekoraItem::new);
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", TekoraItem::new);
    public static final RegistryObject<Item> CADMIUM_PLATE = ITEMS.register("cadmium_plate", TekoraItem::new);
    public static final RegistryObject<Item> CHROMIUM_PLATE = ITEMS.register("chromium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> CHROMOLY_STEEL_PLATE = ITEMS.register("chromoly_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> COBALT_PLATE = ITEMS.register("cobalt_plate", TekoraItem::new);
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", TekoraItem::new);
    public static final RegistryObject<Item> COPPER_STEEL_PLATE = ITEMS.register("copper_steel_plate", TekoraItem::new);
    public static final RegistryObject<Item> FERROBORON_PLATE = ITEMS.register("ferroboron_plate", TekoraItem::new);
    public static final RegistryObject<Item> GALVANIZED_STEEL_PLATE = ITEMS.register("galvanized_steel_plate", TekoraItem::new);
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate", TekoraItem::new);
    public static final RegistryObject<Item> HSLA_STEEL_PLATE = ITEMS.register("hsla_steel_plate", TekoraItem::new);
    public static final RegistryObject<Item> INCONEL_PLATE = ITEMS.register("inconel_plate", TekoraItem::new);
    public static final RegistryObject<Item> INDIUM_PLATE = ITEMS.register("indium_plate", TekoraItem::new);
    public static final RegistryObject<Item> INVAR_PLATE = ITEMS.register("invar_plate", TekoraItem::new);
    public static final RegistryObject<Item> IRIDIUM_PLATE = ITEMS.register("iridium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", TekoraItem::new);
    public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", TekoraItem::new);
    public static final RegistryObject<Item> MAGNESIUM_PLATE = ITEMS.register("magnesium_plate", TekoraItem::new);
    public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_PLATE = ITEMS.register("magnetic_neodymium_plate", TekoraItem::new);
    public static final RegistryObject<Item> MANGANESE_PLATE = ITEMS.register("manganese_plate", TekoraItem::new);
    public static final RegistryObject<Item> MOLYBDENUM_PLATE = ITEMS.register("molybdenum_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> MU_METAL_PLATE = ITEMS.register("mu_metal_plate", TekoraItem::new);
    public static final RegistryObject<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", TekoraItem::new);
    public static final RegistryObject<Item> NIOBIUM_PLATE = ITEMS.register("niobium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> OSMIUM_PLATE = ITEMS.register("osmium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> PALLADIUM_PLATE = ITEMS.register("palladium_plate", TekoraItem::new);
    public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> REACTOR_STEEL_PLATE = ITEMS.register("reactor_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> RHODIUM_PLATE = ITEMS.register("rhodium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> SCANDIUM_PLATE = ITEMS.register("scandium_plate", TekoraItem::new);
    public static final RegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate", TekoraItem::new);
    public static final RegistryObject<Item> STAINLESS_STEEL_PLATE = ITEMS.register("stainless_steel_plate", TekoraItem::new);
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", TekoraItem::new);
    public static final RegistryObject<Item> THORIUM_PLATE = ITEMS.register("thorium_plate", Thorium::new);
    public static final RegistryObject<Item> THULIUM_PLATE = ITEMS.register("thulium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", TekoraItem::new);
    public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PLATE = ITEMS.register("tungsten_carbide_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_PLATE = ITEMS.register("tungsten_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> TUNGSTEN_STEEL_PLATE = ITEMS.register("tungsten_steel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> VANASTEEL_PLATE = ITEMS.register("vanasteel_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> YTTERBIUM_PLATE = ITEMS.register("ytterbium_plate", TekoraItem::new);
    public static final RegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", TekoraItem::new);
    public static final RegistryObject<Item> ZIRCALOY_PLATE = ITEMS.register("zircaloy_plate", HeatResistantItem::new);
    public static final RegistryObject<Item> ZIRCONIUM_PLATE = ITEMS.register("zirconium_plate", HeatResistantItem::new);


    public static final RegistryObject<Item> TITANIUM_TEMPLATE = ITEMS.register("titanium_upgrade_smithing_template",
            () -> SmithingTemplates.createTekoraUpgradeTemplate(SmithingTemplates.APPLIES_TO_STEEL,
                    SmithingTemplates.APPLIES_TO_ALL_STEEL,"titanium"));

    public static final RegistryObject<Item> THORIUM_TEMPLATE = ITEMS.register("thorium_upgrade_smithing_template",
            () -> SmithingTemplates.createTekoraUpgradeTemplate(SmithingTemplates.APPLIES_TO_STEEL,
                    SmithingTemplates.APPLIES_TO_TOOLS_STEEL,"thorium"));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_TEMPLATE = ITEMS.register("tungsten_steel_upgrade_smithing_template",
            () -> SmithingTemplates.createTekoraUpgradeTemplate(SmithingTemplates.APPLIES_TO_IRON,
                    SmithingTemplates.APPLIES_TO_ALL_IRON,"tungsten_steel"));

    public static final RegistryObject<Item> VANASTEEL_TEMPLATE = ITEMS.register("vanasteel_upgrade_smithing_template",
            () -> SmithingTemplates.createTekoraUpgradeTemplate(SmithingTemplates.APPLIES_TO_IRON,
                    SmithingTemplates.APPLIES_TO_ALL_IRON,"vanasteel"));


    public static final RegistryObject<Item> BORON_HELMET = ITEMS.register("boron_helmet", () -> new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> BORON_CHESTPLATE = ITEMS.register("boron_chestplate", () -> new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> BORON_LEGGINGS = ITEMS.register("boron_leggings", () -> new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> BORON_BOOTS = ITEMS.register("boron_boots", () -> new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () -> new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () -> new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () -> new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () -> new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_HELMET = ITEMS.register("tungsten_steel_helmet", () -> new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_CHESTPLATE = ITEMS.register("tungsten_steel_chestplate", () -> new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_LEGGINGS = ITEMS.register("tungsten_steel_leggings", () -> new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> TUNGSTEN_STEEL_BOOTS = ITEMS.register("tungsten_steel_boots", () -> new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.BOOTS));
    public static final RegistryObject<Item> VANASTEEL_HELMET = ITEMS.register("vanasteel_helmet", () -> new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> VANASTEEL_CHESTPLATE = ITEMS.register("vanasteel_chestplate", () -> new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> VANASTEEL_LEGGINGS = ITEMS.register("vanasteel_leggings", () -> new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> VANASTEEL_BOOTS = ITEMS.register("vanasteel_boots", () -> new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.BOOTS));


    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
            new HammerItem(Tiers.DIAMOND, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () ->
            new HammerItem(Tiers.GOLD, new Item.Properties()));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
            new HammerItem(Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () ->
            new HammerItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    
    
    public static final RegistryObject<Item> BORON_AXE = ITEMS.register("boron_axe", () ->
            new AxeItem(TekoraTiers.BORON,5.0f, 3.0f, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_HOE = ITEMS.register("boron_hoe", () ->
            new HoeItem(TekoraTiers.BORON,-6,0, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_PICKAXE = ITEMS.register("boron_pickaxe", () ->
            new PickaxeItem(TekoraTiers.BORON,1, -2.8f, new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_SHOVEL = ITEMS.register("boron_shovel", () ->
            new ShovelItem(TekoraTiers.BORON, 1.5f, -3.0f,new Item.Properties().fireResistant()));
    
    public static final RegistryObject<Item> BORON_SWORD = ITEMS.register("boron_sword", () ->
            new SwordItem(TekoraTiers.BORON, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BORON_HAMMER = ITEMS.register("boron_hammer", () ->
            new HammerItem(TekoraTiers.BORON, new Item.Properties().fireResistant()));
    

    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () ->
            new AxeItem(TekoraTiers.BRONZE, 6.0f, 3.1f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () ->
            new HoeItem(TekoraTiers.BRONZE,-2,0,  new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () ->
            new PickaxeItem(TekoraTiers.BRONZE,1,-2.8f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () ->
            new ShovelItem(TekoraTiers.BRONZE,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () ->
            new SwordItem(TekoraTiers.BRONZE, 3, -2.4f,new Item.Properties()));
    
    public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () ->
            new HammerItem(TekoraTiers.BRONZE, new Item.Properties()));


    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () ->
            new AxeItem(TekoraTiers.PLATINUM, 6.0f, 3.2f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () ->
            new HoeItem(TekoraTiers.PLATINUM, -3,0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () ->
            new PickaxeItem(TekoraTiers.PLATINUM,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () ->
            new ShovelItem(TekoraTiers.PLATINUM, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () ->
            new SwordItem(TekoraTiers.PLATINUM, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM_HAMMER = ITEMS.register("platinum_hammer", () ->
            new HammerItem(TekoraTiers.PLATINUM, new Item.Properties().fireResistant()));


    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () ->
            new AxeItem(TekoraTiers.SILVER,5.6f, 3.2f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () ->
            new HoeItem(TekoraTiers.SILVER, 0,0, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () ->
            new PickaxeItem(TekoraTiers.SILVER,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () ->
            new ShovelItem(TekoraTiers.SILVER, 1.5f, -3.0f,new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () ->
            new SwordItem(TekoraTiers.SILVER, 3, -2.4f,new Item.Properties()));
    
    public static final RegistryObject<Item> SILVER_HAMMER = ITEMS.register("silver_hammer", () ->
            new HammerItem(TekoraTiers.SILVER, new Item.Properties()));


    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () ->
            new AxeItem(TekoraTiers.STEEL, 6.0f, 3.1f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () ->
            new HoeItem(TekoraTiers.STEEL, -2, 0, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () ->
            new PickaxeItem(TekoraTiers.STEEL,1, -2.8f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () ->
            new ShovelItem(TekoraTiers.STEEL, 1.5f, -3.0f,new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () ->
            new SwordItem(TekoraTiers.STEEL, 3, -2.4f,new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer", () ->
            new HammerItem(TekoraTiers.STEEL, new Item.Properties()));

    public static final RegistryObject<Item> THORIUM_AXE = ITEMS.register("thorium_axe", ThoriumAxe::new);
    public static final RegistryObject<Item> THORIUM_HOE = ITEMS.register("thorium_hoe", ThoriumHoe::new);
    public static final RegistryObject<Item> THORIUM_PICKAXE = ITEMS.register("thorium_pickaxe", ThoriumPickaxe::new);
    public static final RegistryObject<Item> THORIUM_SHOVEL = ITEMS.register("thorium_shovel", ThoriumShovel::new);
    public static final RegistryObject<Item> THORIUM_SWORD = ITEMS.register("thorium_sword", ThoriumSword::new);
    public static final RegistryObject<Item> THORIUM_HAMMER = ITEMS.register("thorium_hammer", ThoriumHammer::new);

    
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () ->
            new AxeItem(TekoraTiers.TITANIUM, 5.0f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () ->
            new HoeItem(TekoraTiers.TITANIUM, -5, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () ->
            new PickaxeItem(TekoraTiers.TITANIUM,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () ->
            new ShovelItem(TekoraTiers.TITANIUM, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () ->
            new SwordItem(TekoraTiers.TITANIUM, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer", () ->
            new HammerItem(TekoraTiers.TITANIUM, new Item.Properties().fireResistant()));

    
    public static final RegistryObject<Item> TUNGSTEN_STEEL_AXE = ITEMS.register("tungsten_steel_axe", () ->
            new AxeItem(TekoraTiers.TUNGSTEN_STEEL, 5.5f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_HOE = ITEMS.register("tungsten_steel_hoe", () ->
            new HoeItem(TekoraTiers.TUNGSTEN_STEEL, -4, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_PICKAXE = ITEMS.register("tungsten_steel_pickaxe", () ->
            new PickaxeItem(TekoraTiers.TUNGSTEN_STEEL,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_SHOVEL = ITEMS.register("tungsten_steel_shovel", () ->
            new ShovelItem(TekoraTiers.TUNGSTEN_STEEL, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_SWORD = ITEMS.register("tungsten_steel_sword", () ->
            new SwordItem(TekoraTiers.TUNGSTEN_STEEL, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TUNGSTEN_STEEL_HAMMER = ITEMS.register("tungsten_steel_hammer", () ->
            new HammerItem(TekoraTiers.TUNGSTEN_STEEL, new Item.Properties().fireResistant()));
    

    public static final RegistryObject<Item> VANASTEEL_AXE = ITEMS.register("vanasteel_axe", () ->
            new AxeItem(TekoraTiers.VANASTEEL, 5.0f, 3.0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_HOE = ITEMS.register("vanasteel_hoe", () ->
            new HoeItem(TekoraTiers.VANASTEEL, -6, 0, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_PICKAXE = ITEMS.register("vanasteel_pickaxe", () ->
            new PickaxeItem(TekoraTiers.VANASTEEL,1, -2.8f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_SHOVEL = ITEMS.register("vanasteel_shovel", () ->
            new ShovelItem(TekoraTiers.VANASTEEL, 1.5f, -3.0f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_SWORD = ITEMS.register("vanasteel_sword", () ->
            new SwordItem(TekoraTiers.VANASTEEL, 3, -2.4f,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VANASTEEL_HAMMER = ITEMS.register("vanasteel_hammer", () ->
            new HammerItem(TekoraTiers.VANASTEEL, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TURBINE_STATOR = ITEMS.register("turbine_stator", TekoraItem::new);
    public static final RegistryObject<Item> TURBINE_GENERATOR = ITEMS.register("turbine_generator", TekoraItem::new);
    public static final RegistryObject<Item> TURBINE_ROTOR = ITEMS.register("turbine_rotor", TekoraItem::new);

    public static final RegistryObject<Item> CARBON_STEEL_ROD = ITEMS.register("carbon_steel_rod", TekoraItem::new);
    public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", TekoraItem::new);

    public static final RegistryObject<Item> COIL = ITEMS.register("coil", TekoraItem::new);

    public static final RegistryObject<Item> STAINLESS_STEEL_TURBINE = ITEMS.register("stainless_steel_turbine", TekoraItem::new); // used for steam turbines aswell
    // other types of turbines are
    // glass composite turbine - wind generators
    // titanium - gas turbines

    public static final RegistryObject<Item> AMMONIUM_HYDROXIDE_BUCKET = ITEMS.register("ammonium_hydroxide_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_AMMONIUM_HYDROXIDE));
    public static final RegistryObject<Item> GALLIUM_BUCKET = ITEMS.register("gallium_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_GALLIUM_FLUID));
    public static final RegistryObject<Item> MERCURY_BUCKET = ITEMS.register("mercury_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_MERCURY_FLUID));
    public static final RegistryObject<Item> BROMINE_BUCKET = ITEMS.register("bromine_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_BROMINE_FLUID));
    public static final RegistryObject<Item> HYDROFLUORIC_ACID_BUCKET = ITEMS.register("hydrofluoric_acid_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_HYDROFLUORIC_ACID));
    public static final RegistryObject<Item> NITRIC_ACID_BUCKET = ITEMS.register("nitric_acid_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_NITRIC_ACID));
    public static final RegistryObject<Item> SULFURIC_ACID_BUCKET = ITEMS.register("sulfuric_acid_bucket",
            () -> new TekoraBucketItem(TekoraFluids.SOURCE_SULFURIC_ACID));

    public static final RegistryObject<Item> TIN_CANISTER = ITEMS.register("tin_canister", () -> new Canister(500, 4));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}