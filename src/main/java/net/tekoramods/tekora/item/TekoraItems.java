package net.tekoramods.tekora.item;

import net.tekoramods.tekora.fluid.TekoraFluids;
import net.tekoramods.tekora.item.armors.TekoraArmor;
import net.tekoramods.tekora.item.containers.Canister;
import net.tekoramods.tekora.item.containers.TekoraBucketItem;
import net.tekoramods.tekora.item.isotopic.Lithium;
import net.leng.tekora.item.isotopic.radioactive.*;
import net.tekoramods.tekora.item.mixtures.Residue;
import net.leng.tekora.item.tools.*;
import net.leng.tekora.item.tools.thorium.*;
import net.leng.tekora.item.typical.*;
import net.minecraft.world.item.*;
import net.tekoramods.tekora.Tekora;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.item.armors.HeatResArmor;
import net.tekoramods.tekora.item.tools.*;
import net.tekoramods.tekora.item.tools.thorium.*;
import net.tekoramods.tekora.tiers.TekoraArmors;
import net.tekoramods.tekora.tiers.TekoraTiers;
import net.tekoramods.tekora.item.isotopic.radioactive.Thorium;
import net.tekoramods.tekora.item.isotopic.radioactive.Uranium;
import net.tekoramods.tekora.item.typical.*;

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

  public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new RawItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new RawItem(RawItem.BARIUM));
  public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new RawItem(RawItem.BERYLLIUM));
  public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", TekoraItem::new);
  public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new RawItem(RawItem.CADMIUM));
  public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new RawItem(RawItem.CALCIUM));
  public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new RawItem(RawItem.CERIUM));
  public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", () -> new RawItem(RawItem.CESIUM));
  public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", () -> new RawItem(true, RawItem.CHROMIUM));
  public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new RawItem(RawItem.COBALT));
  public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new RawItem(RawItem.DYSPROSIUM));
  public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new RawItem(RawItem.ERBIUM));
  public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new RawItem(RawItem.EUROPIUM));
  public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new RawItem(RawItem.GADOLINIUM));
  public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new RawItem(RawItem.GALLIUM));
  public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new RawItem(true, RawItem.HAFNIUM));
  public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new RawItem(RawItem.HOLMIUM));
  public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new RawItem(RawItem.INDIUM));
  public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new RawItem(true, RawItem.IRIDIUM));
  public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new RawItem(RawItem.LANTHANUM));
  public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new RawItem(RawItem.LEAD));
  public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", Lithium::new);
  public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new RawItem(true, RawItem.LUTETIUM));
  public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new RawItem(RawItem.MAGNESIUM));
  public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new RawItem(RawItem.MANGANESE));
  public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new RawItem(true, RawItem.MOLYBDENUM));
  public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new RawItem(RawItem.NEODYMIUM));
  public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new RawItem(RawItem.NICKEL));
  public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new RawItem(true, RawItem.NIOBIUM));
  public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new RawItem(true, RawItem.OSMIUM));
  public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new RawItem(RawItem.PALLADIUM));
  public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new RawItem(true, RawItem.PLATINUM));
  public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new RawItem(RawItem.POTASSIUM));
  public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", () -> new RawItem(RawItem.PRASEODYMIUM));
  public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new RawItem(true, RawItem.RHENIUM));
  public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new RawItem(true, RawItem.RHODIUM));
  public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new RawItem(RawItem.RUBIDIUM));
  public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new RawItem(true, RawItem.RUTHENIUM));
  public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new RawItem(RawItem.SAMARIUM));
  public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new RawItem(RawItem.SCANDIUM));
  public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new RawItem(RawItem.SILVER));
  public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new RawItem(RawItem.SODIUM));
  public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new RawItem(RawItem.STRONTIUM));
  public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new RawItem(true, RawItem.TANTALUM));
  public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new RawItem(RawItem.TERBIUM));
  public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new RawItem(RawItem.THALLIUM));
  public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", Thorium::new);
  public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new RawItem(true, RawItem.THULIUM));
  public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new RawItem(RawItem.TIN));
  public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new RawItem(true, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new RawItem(true, RawItem.TUNGSTEN));
  public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", Uranium::new);
  public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new RawItem(true, RawItem.VANADIUM));
  public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new RawItem(RawItem.YTTERBIUM));
  public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new RawItem(RawItem.YTTRIUM));
  public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new RawItem(RawItem.ZINC));
  public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new RawItem(true, RawItem.ZIRCONIUM));

  public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new RawItem(RawItem.BRASS));
  public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new RawItem(RawItem.BRONZE));
  public static final RegistryObject<Item> CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot", () -> new RawItem(RawItem.CARBON_STEEL));
  public static final RegistryObject<Item> CHROMOLY_STEEL_INGOT = ITEMS.register("chromoly_steel_ingot", () -> new RawItem(true, RawItem.CHROMOLY_STEEL));
  public static final RegistryObject<Item> CUPRONICKEL_INGOT = ITEMS.register("cupronickel_ingot", () -> new RawItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", () -> new RawItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> FERROBORON_INGOT = ITEMS.register("ferroboron_ingot", () -> new RawItem(RawItem.FERROBORON));
  public static final RegistryObject<Item> GALVANIZED_STEEL_INGOT = ITEMS.register("galvanized_steel_ingot", () -> new RawItem(RawItem.GALVANIZED_STEEL));
  public static final RegistryObject<Item> HSLA_STEEL_INGOT = ITEMS.register("hsla_steel_ingot", () -> new RawItem(RawItem.HSLA_STEEL));
  public static final RegistryObject<Item> INCONEL_INGOT = ITEMS.register("inconel_ingot", () -> new RawItem(RawItem.INCONEL));
  public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot", () -> new RawItem(RawItem.INVAR));
  public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_INGOT = ITEMS.register("magnetic_neodymium_ingot", () -> new RawItem(RawItem.MAGNETIC_NEODYMIUM));
  public static final RegistryObject<Item> MU_METAL_INGOT = ITEMS.register("mu_metal_ingot", () -> new RawItem(RawItem.MU_METAL));
  public static final RegistryObject<Item> REACTOR_STEEL_INGOT = ITEMS.register("reactor_steel_ingot", () -> new RawItem(true, RawItem.REACTOR_STEEL));
  public static final RegistryObject<Item> STAINLESS_STEEL_INGOT = ITEMS.register("stainless_steel_ingot", () -> new RawItem(RawItem.STAINLESS_STEEL));
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new RawItem(RawItem.STEEL));
  public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = ITEMS.register("tungsten_carbide_ingot", () -> new RawItem(true, RawItem.TUNGSTEN_CARBIDE));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_INGOT = ITEMS.register("tungsten_steel_ingot", () -> new RawItem(true, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_INGOT = ITEMS.register("vanasteel_ingot", () -> new RawItem(true, RawItem.VANASTEEL));
  public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register("zircaloy_ingot", () -> new RawItem(true, RawItem.ZIRCALOY));

  public static final RegistryObject<Item> ANTIMONY_PIECE = ITEMS.register("antimony_piece", () -> new RawItem(RawItem.ANTIMONY));
  public static final RegistryObject<Item> ARSENIC_PIECE = ITEMS.register("arsenic_piece", () -> new RawItem(RawItem.ARSENIC));
  public static final RegistryObject<Item> BORON_PIECE = ITEMS.register("boron_piece", () -> new RawItem(true, RawItem.BORON));
  public static final RegistryObject<Item> GERMANIUM_PIECE = ITEMS.register("germanium_piece", () -> new RawItem(RawItem.GERMANIUM));
  public static final RegistryObject<Item> SILICON_PIECE = ITEMS.register("silicon_piece", () -> new RawItem(RawItem.SILICON));
  public static final RegistryObject<Item> TELLURIUM_PIECE = ITEMS.register("tellurium_piece", () -> new RawItem(RawItem.TELLURIUM));
  public static final RegistryObject<Item> MAGNESIUM_DIBORIDE = ITEMS.register("magnesium_diboride", () -> new RawItem(RawItem.MAGNESIUM_DIBORIDE));
  public static final RegistryObject<Item> NIOBIUM_TIN = ITEMS.register("niobium_tin", () -> new RawItem(true, RawItem.NIOBIUM_TIN));
  public static final RegistryObject<Item> SILICON_CARBIDE = ITEMS.register("silicon_carbide", () -> new RawItem(true, RawItem.SILICON_CARBIDE));

  public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", () -> new RawItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> BARIUM_NUGGET = ITEMS.register("barium_nugget", () -> new RawItem(RawItem.BARIUM));
  public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget", () -> new RawItem(RawItem.BERYLLIUM));
  public static final RegistryObject<Item> BISMUTH_NUGGET = ITEMS.register("bismuth_nugget", TekoraItem::new);
  public static final RegistryObject<Item> CADMIUM_NUGGET = ITEMS.register("cadmium_nugget", () -> new RawItem(RawItem.CADMIUM));
  public static final RegistryObject<Item> CALCIUM_NUGGET = ITEMS.register("calcium_nugget", () -> new RawItem(RawItem.CALCIUM));
  public static final RegistryObject<Item> CERIUM_NUGGET = ITEMS.register("cerium_nugget", () -> new RawItem(RawItem.CERIUM));
  public static final RegistryObject<Item> CESIUM_NUGGET = ITEMS.register("cesium_nugget", () -> new RawItem(RawItem.CESIUM));
  public static final RegistryObject<Item> CHROMIUM_NUGGET = ITEMS.register("chromium_nugget", () -> new RawItem(true, RawItem.CHROMIUM));
  public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget", () -> new RawItem(RawItem.COBALT));
  public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", TekoraItem::new);
  public static final RegistryObject<Item> DYSPROSIUM_NUGGET = ITEMS.register("dysprosium_nugget", () -> new RawItem(RawItem.DYSPROSIUM));
  public static final RegistryObject<Item> ERBIUM_NUGGET = ITEMS.register("erbium_nugget", () -> new RawItem(RawItem.ERBIUM));
  public static final RegistryObject<Item> EUROPIUM_NUGGET = ITEMS.register("europium_nugget", () -> new RawItem(RawItem.EUROPIUM));
  public static final RegistryObject<Item> GADOLINIUM_NUGGET = ITEMS.register("gadolinium_nugget", () -> new RawItem(RawItem.GADOLINIUM));
  public static final RegistryObject<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget", () -> new RawItem(RawItem.GALLIUM));
  public static final RegistryObject<Item> HAFNIUM_NUGGET = ITEMS.register("hafnium_nugget", () -> new RawItem(true, RawItem.HAFNIUM));
  public static final RegistryObject<Item> HOLMIUM_NUGGET = ITEMS.register("holmium_nugget", () -> new RawItem(RawItem.HOLMIUM));
  public static final RegistryObject<Item> INDIUM_NUGGET = ITEMS.register("indium_nugget", () -> new RawItem(RawItem.INDIUM));
  public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", () -> new RawItem(true, RawItem.IRIDIUM));
  public static final RegistryObject<Item> LANTHANUM_NUGGET = ITEMS.register("lanthanum_nugget", () -> new RawItem(RawItem.LANTHANUM));
  public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new RawItem(RawItem.LEAD));
  public static final RegistryObject<Item> LITHIUM_NUGGET = ITEMS.register("lithium_nugget", () -> new RawItem(RawItem.LITHIUM));
  public static final RegistryObject<Item> LUTETIUM_NUGGET = ITEMS.register("lutetium_nugget", () -> new RawItem(true, RawItem.LUTETIUM));
  public static final RegistryObject<Item> MAGNESIUM_NUGGET = ITEMS.register("magnesium_nugget", () -> new RawItem(RawItem.MAGNESIUM));
  public static final RegistryObject<Item> MANGANESE_NUGGET = ITEMS.register("manganese_nugget", () -> new RawItem(RawItem.MANGANESE));
  public static final RegistryObject<Item> MOLYBDENUM_NUGGET = ITEMS.register("molybdenum_nugget", () -> new RawItem(true, RawItem.MOLYBDENUM));
  public static final RegistryObject<Item> NEODYMIUM_NUGGET = ITEMS.register("neodymium_nugget", () -> new RawItem(RawItem.NEODYMIUM));
  public static final RegistryObject<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", () -> new RawItem(RawItem.NICKEL));
  public static final RegistryObject<Item> NIOBIUM_NUGGET = ITEMS.register("niobium_nugget", () -> new RawItem(true, RawItem.NIOBIUM));
  public static final RegistryObject<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget", () -> new RawItem(true, RawItem.OSMIUM));
  public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget", () -> new RawItem(RawItem.PALLADIUM));
  public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", () -> new RawItem(true, RawItem.PLATINUM));
  public static final RegistryObject<Item> POTASSIUM_NUGGET = ITEMS.register("potassium_nugget", () -> new RawItem(RawItem.POTASSIUM));
  public static final RegistryObject<Item> PRASEODYMIUM_NUGGET = ITEMS.register("praseodymium_nugget", () -> new RawItem(RawItem.PRASEODYMIUM));
  public static final RegistryObject<Item> RHENIUM_NUGGET = ITEMS.register("rhenium_nugget", () -> new RawItem(true, RawItem.RHENIUM));
  public static final RegistryObject<Item> RHODIUM_NUGGET = ITEMS.register("rhodium_nugget", () -> new RawItem(true, RawItem.RHODIUM));
  public static final RegistryObject<Item> RUBIDIUM_NUGGET = ITEMS.register("rubidium_nugget", () -> new RawItem(RawItem.RUBIDIUM));
  public static final RegistryObject<Item> RUTHENIUM_NUGGET = ITEMS.register("ruthenium_nugget", () -> new RawItem(true, RawItem.RUTHENIUM));
  public static final RegistryObject<Item> SAMARIUM_NUGGET = ITEMS.register("samarium_nugget", () -> new RawItem(RawItem.SAMARIUM));
  public static final RegistryObject<Item> SCANDIUM_NUGGET = ITEMS.register("scandium_nugget", () -> new RawItem(RawItem.SCANDIUM));
  public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new RawItem(RawItem.SILVER));
  public static final RegistryObject<Item> SODIUM_NUGGET = ITEMS.register("sodium_nugget", () -> new RawItem(RawItem.SODIUM));
  public static final RegistryObject<Item> STRONTIUM_NUGGET = ITEMS.register("strontium_nugget", () -> new RawItem(RawItem.STRONTIUM));
  public static final RegistryObject<Item> TANTALUM_NUGGET = ITEMS.register("tantalum_nugget", () -> new RawItem(true, RawItem.TANTALUM));
  public static final RegistryObject<Item> TERBIUM_NUGGET = ITEMS.register("terbium_nugget", () -> new RawItem(RawItem.TERBIUM));
  public static final RegistryObject<Item> THALLIUM_NUGGET = ITEMS.register("thallium_nugget", () -> new RawItem(RawItem.THALLIUM));
  public static final RegistryObject<Item> THORIUM_NUGGET = ITEMS.register("thorium_nugget", Thorium.Nugget::new);
  public static final RegistryObject<Item> THULIUM_NUGGET = ITEMS.register("thulium_nugget", () -> new RawItem(true, RawItem.THULIUM));
  public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () -> new RawItem(RawItem.TIN));
  public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new RawItem(true, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () -> new RawItem(true, RawItem.TUNGSTEN));
  public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", Uranium.Nugget::new);
  public static final RegistryObject<Item> VANADIUM_NUGGET = ITEMS.register("vanadium_nugget", () -> new RawItem(true, RawItem.VANADIUM));
  public static final RegistryObject<Item> YTTERBIUM_NUGGET = ITEMS.register("ytterbium_nugget", () -> new RawItem(RawItem.YTTERBIUM));
  public static final RegistryObject<Item> YTTRIUM_NUGGET = ITEMS.register("yttrium_nugget", () -> new RawItem(RawItem.YTTRIUM));
  public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", () -> new RawItem(RawItem.ZINC));
  public static final RegistryObject<Item> ZIRCONIUM_NUGGET = ITEMS.register("zirconium_nugget", () -> new RawItem(true, RawItem.ZIRCONIUM));

  public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", () -> new RawItem(RawItem.BRASS));
  public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", () -> new RawItem(RawItem.BRONZE));
  public static final RegistryObject<Item> CARBON_STEEL_NUGGET = ITEMS.register("carbon_steel_nugget", () -> new RawItem(RawItem.CARBON_STEEL));
  public static final RegistryObject<Item> CHROMOLY_STEEL_NUGGET = ITEMS.register("chromoly_steel_nugget", () -> new RawItem(true, RawItem.CHROMOLY_STEEL));
  public static final RegistryObject<Item> CUPRONICKEL_NUGGET = ITEMS.register("cupronickel_nugget", () -> new RawItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget", () -> new RawItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> FERROBORON_NUGGET = ITEMS.register("ferroboron_nugget", () -> new RawItem(RawItem.FERROBORON));
  public static final RegistryObject<Item> HSLA_STEEL_NUGGET = ITEMS.register("hsla_steel_nugget", () -> new RawItem(RawItem.HSLA_STEEL));
  public static final RegistryObject<Item> INCONEL_NUGGET = ITEMS.register("inconel_nugget", () -> new RawItem(RawItem.INCONEL));
  public static final RegistryObject<Item> INVAR_NUGGET = ITEMS.register("invar_nugget", () -> new RawItem(RawItem.INVAR));
  public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_NUGGET = ITEMS.register("magnetic_neodymium_nugget", () -> new RawItem(RawItem.MAGNETIC_NEODYMIUM));
  public static final RegistryObject<Item> MU_METAL_NUGGET = ITEMS.register("mu_metal_nugget", () -> new RawItem(RawItem.MU_METAL));
  public static final RegistryObject<Item> REACTOR_STEEL_NUGGET = ITEMS.register("reactor_steel_nugget", () -> new RawItem(true, RawItem.REACTOR_STEEL));
  public static final RegistryObject<Item> STAINLESS_STEEL_NUGGET = ITEMS.register("stainless_steel_nugget", () -> new RawItem(RawItem.STAINLESS_STEEL));
  public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new RawItem(RawItem.STEEL));
  public static final RegistryObject<Item> TUNGSTEN_CARBIDE_NUGGET = ITEMS.register("tungsten_carbide_nugget", () -> new RawItem(true, RawItem.TUNGSTEN_CARBIDE));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_NUGGET = ITEMS.register("tungsten_steel_nugget", () -> new RawItem(true, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_NUGGET = ITEMS.register("vanasteel_nugget", () -> new RawItem(true, RawItem.VANASTEEL));
  public static final RegistryObject<Item> ZIRCALOY_NUGGET = ITEMS.register("zircaloy_nugget", () -> new RawItem(true, RawItem.ZIRCALOY));

  public static final RegistryObject<Item> PHOSPHORUS_DUST = ITEMS.register("phosphorus_dust", TekoraItem::new);
  public static final RegistryObject<Item> SELENIUM_DUST = ITEMS.register("selenium_dust", TekoraItem::new);
  public static final RegistryObject<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", TekoraItem::new);
  public static final RegistryObject<Item> GRAPHITE_DUST = ITEMS.register("graphite_dust", TekoraItem::new);
  public static final RegistryObject<Item> IODINE_DUST = ITEMS.register("iodine_dust", TekoraItem::new);

  public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new RawItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> BARIUM_DUST = ITEMS.register("barium_dust", () -> new RawItem(RawItem.BARIUM));
  public static final RegistryObject<Item> BERYLLIUM_DUST = ITEMS.register("beryllium_dust", () -> new RawItem(RawItem.BERYLLIUM));
  public static final RegistryObject<Item> BISMUTH_DUST = ITEMS.register("bismuth_dust", TekoraItem::new);
  public static final RegistryObject<Item> CADMIUM_DUST = ITEMS.register("cadmium_dust", () -> new RawItem(RawItem.CADMIUM));
  public static final RegistryObject<Item> CALCIUM_DUST = ITEMS.register("calcium_dust", () -> new RawItem(RawItem.CALCIUM));
  public static final RegistryObject<Item> CERIUM_DUST = ITEMS.register("cerium_dust", () -> new RawItem(RawItem.CERIUM));
  public static final RegistryObject<Item> CESIUM_DUST = ITEMS.register("cesium_dust", () -> new RawItem(RawItem.CESIUM));
  public static final RegistryObject<Item> CHROMIUM_DUST = ITEMS.register("chromium_dust", () -> new RawItem(true, RawItem.CHROMIUM));
  public static final RegistryObject<Item> COBALT_DUST = ITEMS.register("cobalt_dust", () -> new RawItem(RawItem.COBALT));
  public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", TekoraItem::new);
  public static final RegistryObject<Item> DYSPROSIUM_DUST = ITEMS.register("dysprosium_dust", () -> new RawItem(RawItem.DYSPROSIUM));
  public static final RegistryObject<Item> ERBIUM_DUST = ITEMS.register("erbium_dust", () -> new RawItem(RawItem.ERBIUM));
  public static final RegistryObject<Item> EUROPIUM_DUST = ITEMS.register("europium_dust", () -> new RawItem(RawItem.EUROPIUM));
  public static final RegistryObject<Item> GADOLINIUM_DUST = ITEMS.register("gadolinium_dust", () -> new RawItem(RawItem.GADOLINIUM));
  public static final RegistryObject<Item> GALLIUM_DUST = ITEMS.register("gallium_dust", () -> new RawItem(RawItem.GALLIUM));
  public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", TekoraItem::new);
  public static final RegistryObject<Item> HAFNIUM_DUST = ITEMS.register("hafnium_dust", () -> new RawItem(true, RawItem.HAFNIUM));
  public static final RegistryObject<Item> HOLMIUM_DUST = ITEMS.register("holmium_dust", () -> new RawItem(RawItem.HOLMIUM));
  public static final RegistryObject<Item> INDIUM_DUST = ITEMS.register("indium_dust", () -> new RawItem(RawItem.INDIUM));
  public static final RegistryObject<Item> IRIDIUM_DUST = ITEMS.register("iridium_dust", () -> new RawItem(true, RawItem.IRIDIUM));
  public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", TekoraItem::new);
  public static final RegistryObject<Item> LANTHANUM_DUST = ITEMS.register("lanthanum_dust", () -> new RawItem(RawItem.LANTHANUM));
  public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", () -> new RawItem(RawItem.LEAD));
  public static final RegistryObject<Item> LITHIUM_DUST = ITEMS.register("lithium_dust", () -> new RawItem(RawItem.LITHIUM));
  public static final RegistryObject<Item> LUTETIUM_DUST = ITEMS.register("lutetium_dust", () -> new RawItem(true, RawItem.LUTETIUM));
  public static final RegistryObject<Item> MAGNESIUM_DUST = ITEMS.register("magnesium_dust", () -> new RawItem(RawItem.MAGNESIUM));
  public static final RegistryObject<Item> MANGANESE_DUST = ITEMS.register("manganese_dust", () -> new RawItem(RawItem.MANGANESE));
  public static final RegistryObject<Item> MOLYBDENUM_DUST = ITEMS.register("molybdenum_dust", () -> new RawItem(true, RawItem.MOLYBDENUM));
  public static final RegistryObject<Item> NEODYMIUM_DUST = ITEMS.register("neodymium_dust", () -> new RawItem(RawItem.NEODYMIUM));
  public static final RegistryObject<Item> NICKEL_DUST = ITEMS.register("nickel_dust", () -> new RawItem(RawItem.NICKEL));
  public static final RegistryObject<Item> NIOBIUM_DUST = ITEMS.register("niobium_dust", () -> new RawItem(true, RawItem.NIOBIUM));
  public static final RegistryObject<Item> OSMIUM_DUST = ITEMS.register("osmium_dust", () -> new RawItem(true, RawItem.OSMIUM));
  public static final RegistryObject<Item> PALLADIUM_DUST = ITEMS.register("palladium_dust", () -> new RawItem(RawItem.PALLADIUM));
  public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", () -> new RawItem(true, RawItem.PLATINUM));
  public static final RegistryObject<Item> POTASSIUM_DUST = ITEMS.register("potassium_dust", () -> new RawItem(RawItem.POTASSIUM));
  public static final RegistryObject<Item> PRASEODYMIUM_DUST = ITEMS.register("praseodymium_dust", () -> new RawItem(RawItem.PRASEODYMIUM));
  public static final RegistryObject<Item> RHENIUM_DUST = ITEMS.register("rhenium_dust", () -> new RawItem(true, RawItem.RHENIUM));
  public static final RegistryObject<Item> RHODIUM_DUST = ITEMS.register("rhodium_dust", () -> new RawItem(true, RawItem.RHODIUM));
  public static final RegistryObject<Item> RUBIDIUM_DUST = ITEMS.register("rubidium_dust", () -> new RawItem(RawItem.RUBIDIUM));
  public static final RegistryObject<Item> RUTHENIUM_DUST = ITEMS.register("ruthenium_dust", () -> new RawItem(true, RawItem.RUTHENIUM));
  public static final RegistryObject<Item> SAMARIUM_DUST = ITEMS.register("samarium_dust", () -> new RawItem(RawItem.SAMARIUM));
  public static final RegistryObject<Item> SCANDIUM_DUST = ITEMS.register("scandium_dust", () -> new RawItem(RawItem.SCANDIUM));
  public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new RawItem(RawItem.SILVER));
  public static final RegistryObject<Item> SODIUM_DUST = ITEMS.register("sodium_dust", () -> new RawItem(RawItem.SODIUM));
  public static final RegistryObject<Item> STRONTIUM_DUST = ITEMS.register("strontium_dust", () -> new RawItem(RawItem.STRONTIUM));
  public static final RegistryObject<Item> TANTALUM_DUST = ITEMS.register("tantalum_dust", () -> new RawItem(true, RawItem.TANTALUM));
  public static final RegistryObject<Item> TERBIUM_DUST = ITEMS.register("terbium_dust", () -> new RawItem(RawItem.TERBIUM));
  public static final RegistryObject<Item> THALLIUM_DUST = ITEMS.register("thallium_dust", () -> new RawItem(RawItem.THALLIUM));
  public static final RegistryObject<Item> THORIUM_DUST = ITEMS.register("thorium_dust", Thorium::new);
  public static final RegistryObject<Item> THULIUM_DUST = ITEMS.register("thulium_dust", () -> new RawItem(true, RawItem.THULIUM));
  public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", () -> new RawItem(RawItem.TIN));
  public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", () -> new RawItem(true, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", () -> new RawItem(true, RawItem.TUNGSTEN));
  public static final RegistryObject<Item> URANIUM_DUST = ITEMS.register("uranium_dust", Uranium::new);
  public static final RegistryObject<Item> VANADIUM_DUST = ITEMS.register("vanadium_dust", () -> new RawItem(true, RawItem.VANADIUM));
  public static final RegistryObject<Item> YTTERBIUM_DUST = ITEMS.register("ytterbium_dust", () -> new RawItem(RawItem.YTTERBIUM));
  public static final RegistryObject<Item> YTTRIUM_DUST = ITEMS.register("yttrium_dust", () -> new RawItem(RawItem.YTTRIUM));
  public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust", () -> new RawItem(RawItem.ZINC));
  public static final RegistryObject<Item> ZIRCONIUM_DUST = ITEMS.register("zirconium_dust", () -> new RawItem(true, RawItem.ZIRCONIUM));

  public static final RegistryObject<Item> ARSENIC_DUST = ITEMS.register("arsenic_dust", () -> new RawItem(RawItem.ARSENIC));
  public static final RegistryObject<Item> ANTIMONY_DUST = ITEMS.register("antimony_dust", () -> new RawItem(RawItem.ANTIMONY));
  public static final RegistryObject<Item> BORON_DUST = ITEMS.register("boron_dust", () -> new RawItem(true, RawItem.BORON));
  public static final RegistryObject<Item> GERMANIUM_DUST = ITEMS.register("germanium_dust", () -> new RawItem(RawItem.GERMANIUM));
  public static final RegistryObject<Item> SILICON_DUST = ITEMS.register("silicon_dust", () -> new RawItem(RawItem.SILICON));
  public static final RegistryObject<Item> TELLURIUM_DUST = ITEMS.register("tellurium_dust", () -> new RawItem(RawItem.TELLURIUM));

  public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust", () -> new RawItem(RawItem.BRASS));
  public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust", () -> new RawItem(RawItem.BRONZE));
  public static final RegistryObject<Item> CARBON_STEEL_DUST = ITEMS.register("carbon_steel_dust", () -> new RawItem(RawItem.CARBON_STEEL));
  public static final RegistryObject<Item> CHROMOLY_STEEL_DUST = ITEMS.register("chromoly_steel_dust", () -> new RawItem(true, RawItem.CHROMOLY_STEEL));
  public static final RegistryObject<Item> COPPER_STEEL_DUST = ITEMS.register("copper_steel_dust", TekoraItem::new);
  public static final RegistryObject<Item> CUPRONICKEL_DUST = ITEMS.register("cupronickel_dust", () -> new RawItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_DUST = ITEMS.register("electrum_dust", () -> new RawItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> FERROBORON_DUST = ITEMS.register("ferroboron_dust", () -> new RawItem(RawItem.FERROBORON));
  public static final RegistryObject<Item> HSLA_STEEL_DUST = ITEMS.register("hsla_steel_dust", () -> new RawItem(RawItem.HSLA_STEEL));
  public static final RegistryObject<Item> INCONEL_DUST = ITEMS.register("inconel_dust", () -> new RawItem(RawItem.INCONEL));
  public static final RegistryObject<Item> INVAR_DUST = ITEMS.register("invar_dust", () -> new RawItem(RawItem.INVAR));
  public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_DUST = ITEMS.register("magnetic_neodymium_dust", () -> new RawItem(RawItem.MAGNETIC_NEODYMIUM));
  public static final RegistryObject<Item> MU_METAL_DUST = ITEMS.register("mu_metal_dust", () -> new RawItem(RawItem.MU_METAL));
  public static final RegistryObject<Item> REACTOR_STEEL_DUST = ITEMS.register("reactor_steel_dust", () -> new RawItem(true, RawItem.REACTOR_STEEL));
  public static final RegistryObject<Item> STAINLESS_STEEL_DUST = ITEMS.register("stainless_steel_dust", () -> new RawItem(RawItem.STAINLESS_STEEL));
  public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new RawItem(RawItem.STEEL));
  public static final RegistryObject<Item> TUNGSTEN_CARBIDE_DUST = ITEMS.register("tungsten_carbide_dust", () -> new RawItem(true, RawItem.TUNGSTEN_CARBIDE));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_DUST = ITEMS.register("tungsten_steel_dust", () -> new RawItem(true, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_DUST = ITEMS.register("vanasteel_dust", () -> new RawItem(true, RawItem.VANASTEEL));
  public static final RegistryObject<Item> ZIRCALOY_DUST = ITEMS.register("zircaloy_dust", () -> new RawItem(true, RawItem.ZIRCALOY));


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

  public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", () -> new RawItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> BISMUTH_PLATE = ITEMS.register("bismuth_plate", TekoraItem::new);
  public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate", () -> new RawItem(RawItem.BRASS));
  public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", () -> new RawItem(RawItem.BRONZE));
  public static final RegistryObject<Item> CADMIUM_PLATE = ITEMS.register("cadmium_plate", () -> new RawItem(RawItem.CADMIUM));
  public static final RegistryObject<Item> CHROMIUM_PLATE = ITEMS.register("chromium_plate", () -> new RawItem(true, RawItem.CHROMIUM));
  public static final RegistryObject<Item> CHROMOLY_STEEL_PLATE = ITEMS.register("chromoly_steel_plate", () -> new RawItem(true, RawItem.CHROMOLY_STEEL));
  public static final RegistryObject<Item> COBALT_PLATE = ITEMS.register("cobalt_plate", () -> new RawItem(RawItem.COBALT));
  public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", TekoraItem::new);
  public static final RegistryObject<Item> COPPER_STEEL_PLATE = ITEMS.register("copper_steel_plate", TekoraItem::new);
  public static final RegistryObject<Item> CUPRONICKEL_PLATE = ITEMS.register("cupronickel_plate", () -> new RawItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_PLATE = ITEMS.register("electrum_plate", () -> new RawItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> FERROBORON_PLATE = ITEMS.register("ferroboron_plate", () -> new RawItem(RawItem.FERROBORON));
  public static final RegistryObject<Item> GALVANIZED_STEEL_PLATE = ITEMS.register("galvanized_steel_plate", () -> new RawItem(RawItem.GALVANIZED_STEEL));
  public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate", TekoraItem::new);
  public static final RegistryObject<Item> HSLA_STEEL_PLATE = ITEMS.register("hsla_steel_plate", () -> new RawItem(RawItem.HSLA_STEEL));
  public static final RegistryObject<Item> INCONEL_PLATE = ITEMS.register("inconel_plate", () -> new RawItem(RawItem.INCONEL));
  public static final RegistryObject<Item> INDIUM_PLATE = ITEMS.register("indium_plate", () -> new RawItem(RawItem.INDIUM));
  public static final RegistryObject<Item> INVAR_PLATE = ITEMS.register("invar_plate", () -> new RawItem(RawItem.INVAR));
  public static final RegistryObject<Item> IRIDIUM_PLATE = ITEMS.register("iridium_plate", () -> new RawItem(true, RawItem.IRIDIUM));
  public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", TekoraItem::new);
  public static final RegistryObject<Item> LEAD_PLATE = ITEMS.register("lead_plate", () -> new RawItem(RawItem.LEAD));
  public static final RegistryObject<Item> MAGNESIUM_PLATE = ITEMS.register("magnesium_plate", () -> new RawItem(RawItem.MAGNESIUM));
  public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_PLATE = ITEMS.register("magnetic_neodymium_plate", () -> new RawItem(RawItem.MAGNETIC_NEODYMIUM));
  public static final RegistryObject<Item> MANGANESE_PLATE = ITEMS.register("manganese_plate", () -> new RawItem(RawItem.MANGANESE));
  public static final RegistryObject<Item> MOLYBDENUM_PLATE = ITEMS.register("molybdenum_plate", () -> new RawItem(true, RawItem.MOLYBDENUM));
  public static final RegistryObject<Item> MU_METAL_PLATE = ITEMS.register("mu_metal_plate", () -> new RawItem(RawItem.MU_METAL));
  public static final RegistryObject<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", () -> new RawItem(RawItem.NICKEL));
  public static final RegistryObject<Item> NIOBIUM_PLATE = ITEMS.register("niobium_plate", () -> new RawItem(true, RawItem.NIOBIUM));
  public static final RegistryObject<Item> OSMIUM_PLATE = ITEMS.register("osmium_plate", () -> new RawItem(true, RawItem.OSMIUM));
  public static final RegistryObject<Item> PALLADIUM_PLATE = ITEMS.register("palladium_plate", () -> new RawItem(RawItem.PALLADIUM));
  public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", () -> new RawItem(true, RawItem.PLATINUM));
  public static final RegistryObject<Item> REACTOR_STEEL_PLATE = ITEMS.register("reactor_steel_plate", () -> new RawItem(true, RawItem.REACTOR_STEEL));
  public static final RegistryObject<Item> RHODIUM_PLATE = ITEMS.register("rhodium_plate", () -> new RawItem(true, RawItem.RHODIUM));
  public static final RegistryObject<Item> SCANDIUM_PLATE = ITEMS.register("scandium_plate", () -> new RawItem(RawItem.SCANDIUM));
  public static final RegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate", () -> new RawItem(RawItem.SILVER));
  public static final RegistryObject<Item> STAINLESS_STEEL_PLATE = ITEMS.register("stainless_steel_plate", () -> new RawItem(RawItem.STAINLESS_STEEL));
  public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new RawItem(RawItem.STEEL));
  public static final RegistryObject<Item> THORIUM_PLATE = ITEMS.register("thorium_plate", Thorium::new);
  public static final RegistryObject<Item> THULIUM_PLATE = ITEMS.register("thulium_plate", () -> new RawItem(true, RawItem.THULIUM));
  public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", () -> new RawItem(RawItem.TIN));
  public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate", () -> new RawItem(true, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_CARBIDE_PLATE = ITEMS.register("tungsten_carbide_plate", () -> new RawItem(true, RawItem.TUNGSTEN_CARBIDE));
  public static final RegistryObject<Item> TUNGSTEN_PLATE = ITEMS.register("tungsten_plate", () -> new RawItem(true, RawItem.TUNGSTEN));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_PLATE = ITEMS.register("tungsten_steel_plate", () -> new RawItem(true, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_PLATE = ITEMS.register("vanasteel_plate", () -> new RawItem(true, RawItem.VANASTEEL));
  public static final RegistryObject<Item> YTTERBIUM_PLATE = ITEMS.register("ytterbium_plate", () -> new RawItem(RawItem.YTTERBIUM));
  public static final RegistryObject<Item> ZINC_PLATE = ITEMS.register("zinc_plate", () -> new RawItem(RawItem.ZINC));
  public static final RegistryObject<Item> ZIRCALOY_PLATE = ITEMS.register("zircaloy_plate", () -> new RawItem(true, RawItem.ZIRCALOY));
  public static final RegistryObject<Item> ZIRCONIUM_PLATE = ITEMS.register("zirconium_plate", () -> new RawItem(true, RawItem.ZIRCONIUM));

  public static final RegistryObject<Item> ALUMINUM_WIRE = ITEMS.register("aluminum_wire", () -> new WireItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire", () -> new WireItem(RawItem.COPPER));
  public static final RegistryObject<Item> CUPRONICKEL_WIRE = ITEMS.register("cupronickel_wire", () -> new WireItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_WIRE = ITEMS.register("electrum_wire", () -> new WireItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> GOLD_WIRE = ITEMS.register("gold_wire", () -> new WireItem(RawItem.GOLD));
  public static final RegistryObject<Item> SILVER_WIRE = ITEMS.register("silver_wire", () -> new WireItem(RawItem.SILVER));
  public static final RegistryObject<Item> TIN_WIRE = ITEMS.register("tin_wire", () -> new WireItem(RawItem.TIN));
  //public static final RegistryObject<Item> NIOBIUM_TIN_WIRE = ITEMS.register("niobium_tin_wire", TekoraItem::new);


  public static final RegistryObject<Item> ALUMINUM_TINY_DUST = ITEMS.register("aluminum_tiny_dust", () -> new RawItem(RawItem.ALUMINUM));
  public static final RegistryObject<Item> BARIUM_TINY_DUST = ITEMS.register("barium_tiny_dust", () -> new RawItem(RawItem.BARIUM));
  public static final RegistryObject<Item> BERYLLIUM_TINY_DUST = ITEMS.register("beryllium_tiny_dust", () -> new RawItem(RawItem.BERYLLIUM));
  public static final RegistryObject<Item> BISMUTH_TINY_DUST = ITEMS.register("bismuth_tiny_dust", TekoraItem::new);
  public static final RegistryObject<Item> CADMIUM_TINY_DUST = ITEMS.register("cadmium_tiny_dust", () -> new RawItem(RawItem.CADMIUM));
  public static final RegistryObject<Item> CALCIUM_TINY_DUST = ITEMS.register("calcium_tiny_dust", () -> new RawItem(RawItem.CALCIUM));
  public static final RegistryObject<Item> CERIUM_TINY_DUST = ITEMS.register("cerium_tiny_dust", () -> new RawItem(RawItem.CERIUM));
  public static final RegistryObject<Item> CESIUM_TINY_DUST = ITEMS.register("cesium_tiny_dust", () -> new RawItem(RawItem.CESIUM));
  public static final RegistryObject<Item> CHROMIUM_TINY_DUST = ITEMS.register("chromium_tiny_dust", () -> new RawItem(true, RawItem.CHROMIUM));
  public static final RegistryObject<Item> COBALT_TINY_DUST = ITEMS.register("cobalt_tiny_dust", () -> new RawItem(RawItem.COBALT));
  public static final RegistryObject<Item> COPPER_TINY_DUST = ITEMS.register("copper_tiny_dust", TekoraItem::new);
  public static final RegistryObject<Item> DYSPROSIUM_TINY_DUST = ITEMS.register("dysprosium_tiny_dust", () -> new RawItem(RawItem.DYSPROSIUM));
  public static final RegistryObject<Item> ERBIUM_TINY_DUST = ITEMS.register("erbium_tiny_dust", () -> new RawItem(RawItem.ERBIUM));
  public static final RegistryObject<Item> EUROPIUM_TINY_DUST = ITEMS.register("europium_tiny_dust", () -> new RawItem(RawItem.EUROPIUM));
  public static final RegistryObject<Item> GADOLINIUM_TINY_DUST = ITEMS.register("gadolinium_tiny_dust", () -> new RawItem(RawItem.GADOLINIUM));
  public static final RegistryObject<Item> GALLIUM_TINY_DUST = ITEMS.register("gallium_tiny_dust", () -> new RawItem(RawItem.GALLIUM));
  public static final RegistryObject<Item> GOLD_TINY_DUST = ITEMS.register("gold_tiny_dust", TekoraItem::new);
  public static final RegistryObject<Item> HAFNIUM_TINY_DUST = ITEMS.register("hafnium_tiny_dust", () -> new RawItem(true, RawItem.HAFNIUM));
  public static final RegistryObject<Item> HOLMIUM_TINY_DUST = ITEMS.register("holmium_tiny_dust", () -> new RawItem(RawItem.HOLMIUM));
  public static final RegistryObject<Item> INDIUM_TINY_DUST = ITEMS.register("indium_tiny_dust", () -> new RawItem(RawItem.INDIUM));
  public static final RegistryObject<Item> IRIDIUM_TINY_DUST = ITEMS.register("iridium_tiny_dust", () -> new RawItem(true, RawItem.IRIDIUM));
  public static final RegistryObject<Item> IRON_TINY_DUST = ITEMS.register("iron_tiny_dust", TekoraItem::new);
  public static final RegistryObject<Item> LANTHANUM_TINY_DUST = ITEMS.register("lanthanum_tiny_dust", () -> new RawItem(RawItem.LANTHANUM));
  public static final RegistryObject<Item> LEAD_TINY_DUST = ITEMS.register("lead_tiny_dust", () -> new RawItem(RawItem.LEAD));
  public static final RegistryObject<Item> LITHIUM_TINY_DUST = ITEMS.register("lithium_tiny_dust", () -> new RawItem(RawItem.LITHIUM));
  public static final RegistryObject<Item> LUTETIUM_TINY_DUST = ITEMS.register("lutetium_tiny_dust", () -> new RawItem(true, RawItem.LUTETIUM));
  public static final RegistryObject<Item> MAGNESIUM_TINY_DUST = ITEMS.register("magnesium_tiny_dust", () -> new RawItem(RawItem.MAGNESIUM));
  public static final RegistryObject<Item> MANGANESE_TINY_DUST = ITEMS.register("manganese_tiny_dust", () -> new RawItem(RawItem.MANGANESE));
  public static final RegistryObject<Item> MOLYBDENUM_TINY_DUST = ITEMS.register("molybdenum_tiny_dust", () -> new RawItem(true, RawItem.MOLYBDENUM));
  public static final RegistryObject<Item> NEODYMIUM_TINY_DUST = ITEMS.register("neodymium_tiny_dust", () -> new RawItem(RawItem.NEODYMIUM));
  public static final RegistryObject<Item> NICKEL_TINY_DUST = ITEMS.register("nickel_tiny_dust", () -> new RawItem(RawItem.NICKEL));
  public static final RegistryObject<Item> NIOBIUM_TINY_DUST = ITEMS.register("niobium_tiny_dust", () -> new RawItem(true, RawItem.NIOBIUM));
  public static final RegistryObject<Item> OSMIUM_TINY_DUST = ITEMS.register("osmium_tiny_dust", () -> new RawItem(true, RawItem.OSMIUM));
  public static final RegistryObject<Item> PALLADIUM_TINY_DUST = ITEMS.register("palladium_tiny_dust", () -> new RawItem(RawItem.PALLADIUM));
  public static final RegistryObject<Item> PLATINUM_TINY_DUST = ITEMS.register("platinum_tiny_dust", () -> new RawItem(true, RawItem.PLATINUM));
  public static final RegistryObject<Item> POTASSIUM_TINY_DUST = ITEMS.register("potassium_tiny_dust", () -> new RawItem(RawItem.POTASSIUM));
  public static final RegistryObject<Item> PRASEODYMIUM_TINY_DUST = ITEMS.register("praseodymium_tiny_dust", () -> new RawItem(RawItem.PRASEODYMIUM));
  public static final RegistryObject<Item> RHENIUM_TINY_DUST = ITEMS.register("rhenium_tiny_dust", () -> new RawItem(true, RawItem.RHENIUM));
  public static final RegistryObject<Item> RHODIUM_TINY_DUST = ITEMS.register("rhodium_tiny_dust", () -> new RawItem(true, RawItem.RHODIUM));
  public static final RegistryObject<Item> RUBIDIUM_TINY_DUST = ITEMS.register("rubidium_tiny_dust", () -> new RawItem(RawItem.RUBIDIUM));
  public static final RegistryObject<Item> RUTHENIUM_TINY_DUST = ITEMS.register("ruthenium_tiny_dust", () -> new RawItem(true, RawItem.RUTHENIUM));
  public static final RegistryObject<Item> SAMARIUM_TINY_DUST = ITEMS.register("samarium_tiny_dust", () -> new RawItem(RawItem.SAMARIUM));
  public static final RegistryObject<Item> SCANDIUM_TINY_DUST = ITEMS.register("scandium_tiny_dust", () -> new RawItem(RawItem.SCANDIUM));
  public static final RegistryObject<Item> SILVER_TINY_DUST = ITEMS.register("silver_tiny_dust", () -> new RawItem(RawItem.SILVER));
  public static final RegistryObject<Item> SODIUM_TINY_DUST = ITEMS.register("sodium_tiny_dust", () -> new RawItem(RawItem.SODIUM));
  public static final RegistryObject<Item> STRONTIUM_TINY_DUST = ITEMS.register("strontium_tiny_dust", () -> new RawItem(RawItem.STRONTIUM));
  public static final RegistryObject<Item> TANTALUM_TINY_DUST = ITEMS.register("tantalum_tiny_dust", () -> new RawItem(true, RawItem.TANTALUM));
  public static final RegistryObject<Item> TERBIUM_TINY_DUST = ITEMS.register("terbium_tiny_dust", () -> new RawItem(RawItem.TERBIUM));
  public static final RegistryObject<Item> THALLIUM_TINY_DUST = ITEMS.register("thallium_tiny_dust", () -> new RawItem(RawItem.THALLIUM));
  public static final RegistryObject<Item> THORIUM_TINY_DUST = ITEMS.register("thorium_tiny_dust", Thorium::new);
  public static final RegistryObject<Item> THULIUM_TINY_DUST = ITEMS.register("thulium_tiny_dust", () -> new RawItem(true, RawItem.THULIUM));
  public static final RegistryObject<Item> TIN_TINY_DUST = ITEMS.register("tin_tiny_dust", () -> new RawItem(RawItem.TIN));
  public static final RegistryObject<Item> TITANIUM_TINY_DUST = ITEMS.register("titanium_tiny_dust", () -> new RawItem(true, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_TINY_DUST = ITEMS.register("tungsten_tiny_dust", () -> new RawItem(true, RawItem.TUNGSTEN));
  public static final RegistryObject<Item> URANIUM_TINY_DUST = ITEMS.register("uranium_tiny_dust", Uranium::new);
  public static final RegistryObject<Item> VANADIUM_TINY_DUST = ITEMS.register("vanadium_tiny_dust", () -> new RawItem(true, RawItem.VANADIUM));
  public static final RegistryObject<Item> YTTERBIUM_TINY_DUST = ITEMS.register("ytterbium_tiny_dust", () -> new RawItem(RawItem.YTTERBIUM));
  public static final RegistryObject<Item> YTTRIUM_TINY_DUST = ITEMS.register("yttrium_tiny_dust", () -> new RawItem(RawItem.YTTRIUM));
  public static final RegistryObject<Item> ZINC_TINY_DUST = ITEMS.register("zinc_tiny_dust", () -> new RawItem(RawItem.ZINC));
  public static final RegistryObject<Item> ZIRCONIUM_TINY_DUST = ITEMS.register("zirconium_tiny_dust", () -> new RawItem(true, RawItem.ZIRCONIUM));

  public static final RegistryObject<Item> ARSENIC_TINY_DUST = ITEMS.register("arsenic_tiny_dust", () -> new RawItem(RawItem.ARSENIC));
  public static final RegistryObject<Item> ANTIMONY_TINY_DUST = ITEMS.register("antimony_tiny_dust", () -> new RawItem(RawItem.ANTIMONY));
  public static final RegistryObject<Item> BORON_TINY_DUST = ITEMS.register("boron_tiny_dust", () -> new RawItem(true, RawItem.BORON));
  public static final RegistryObject<Item> GERMANIUM_TINY_DUST = ITEMS.register("germanium_tiny_dust", () -> new RawItem(RawItem.GERMANIUM));
  public static final RegistryObject<Item> SILICON_TINY_DUST = ITEMS.register("silicon_tiny_dust", () -> new RawItem(RawItem.SILICON));
  public static final RegistryObject<Item> TELLURIUM_TINY_DUST = ITEMS.register("tellurium_tiny_dust", () -> new RawItem(RawItem.TELLURIUM));

  public static final RegistryObject<Item> BRASS_TINY_DUST = ITEMS.register("brass_tiny_dust", () -> new RawItem(RawItem.BRASS));
  public static final RegistryObject<Item> BRONZE_TINY_DUST = ITEMS.register("bronze_tiny_dust", () -> new RawItem(RawItem.BRONZE));
  public static final RegistryObject<Item> CARBON_STEEL_TINY_DUST = ITEMS.register("carbon_steel_tiny_dust", () -> new RawItem(RawItem.CARBON_STEEL));
  public static final RegistryObject<Item> CHROMOLY_STEEL_TINY_DUST = ITEMS.register("chromoly_steel_tiny_dust", () -> new RawItem(true, RawItem.CHROMOLY_STEEL));
  public static final RegistryObject<Item> CUPRONICKEL_TINY_DUST = ITEMS.register("cupronickel_tiny_dust", () -> new RawItem(RawItem.CUPRONICKEL));
  public static final RegistryObject<Item> ELECTRUM_TINY_DUST = ITEMS.register("electrum_tiny_dust", () -> new RawItem(RawItem.ELECTRUM));
  public static final RegistryObject<Item> FERROBORON_TINY_DUST = ITEMS.register("ferroboron_tiny_dust", () -> new RawItem(RawItem.FERROBORON));
  public static final RegistryObject<Item> HSLA_STEEL_TINY_DUST = ITEMS.register("hsla_steel_tiny_dust", () -> new RawItem(RawItem.HSLA_STEEL));
  public static final RegistryObject<Item> INCONEL_TINY_DUST = ITEMS.register("inconel_tiny_dust", () -> new RawItem(RawItem.INCONEL));
  public static final RegistryObject<Item> INVAR_TINY_DUST = ITEMS.register("invar_tiny_dust", () -> new RawItem(RawItem.INVAR));
  public static final RegistryObject<Item> MAGNETIC_NEODYMIUM_TINY_DUST = ITEMS.register("magnetic_neodymium_tiny_dust", () -> new RawItem(RawItem.MAGNETIC_NEODYMIUM));
  public static final RegistryObject<Item> MU_METAL_TINY_DUST = ITEMS.register("mu_metal_tiny_dust", () -> new RawItem(RawItem.MU_METAL));
  public static final RegistryObject<Item> REACTOR_STEEL_TINY_DUST = ITEMS.register("reactor_steel_tiny_dust", () -> new RawItem(true, RawItem.REACTOR_STEEL));
  public static final RegistryObject<Item> STAINLESS_STEEL_TINY_DUST = ITEMS.register("stainless_steel_tiny_dust", () -> new RawItem(RawItem.STAINLESS_STEEL));
  public static final RegistryObject<Item> STEEL_TINY_DUST = ITEMS.register("steel_tiny_dust", () -> new RawItem(RawItem.STEEL));
  public static final RegistryObject<Item> TUNGSTEN_CARBIDE_TINY_DUST = ITEMS.register("tungsten_carbide_tiny_dust", () -> new RawItem(true, RawItem.TUNGSTEN_CARBIDE));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_TINY_DUST = ITEMS.register("tungsten_steel_tiny_dust", () -> new RawItem(true, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_TINY_DUST = ITEMS.register("vanasteel_tiny_dust", () -> new RawItem(true, RawItem.VANASTEEL));
  public static final RegistryObject<Item> ZIRCALOY_TINY_DUST = ITEMS.register("zircaloy_tiny_dust", () -> new RawItem(true, RawItem.ZIRCALOY));

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


  public static final RegistryObject<Item> BORON_HELMET = ITEMS.register("boron_helmet", () ->
      new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.HELMET, RawItem.BORON));
  public static final RegistryObject<Item> BORON_CHESTPLATE = ITEMS.register("boron_chestplate", () ->
      new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.CHESTPLATE, RawItem.BORON));
  public static final RegistryObject<Item> BORON_LEGGINGS = ITEMS.register("boron_leggings", () ->
      new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.LEGGINGS, RawItem.BORON));
  public static final RegistryObject<Item> BORON_BOOTS = ITEMS.register("boron_boots", () ->
      new HeatResArmor(TekoraArmors.BORON, ArmorItem.Type.BOOTS, RawItem.BORON));
  public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet", () ->
      new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.HELMET, RawItem.BRONZE));
  public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () ->
      new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.CHESTPLATE, RawItem.BRONZE));
  public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () ->
      new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.LEGGINGS, RawItem.BRONZE));
  public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots", () ->
      new TekoraArmor(TekoraArmors.BRONZE, ArmorItem.Type.BOOTS, RawItem.BRONZE));
  public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet", () ->
      new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.HELMET, RawItem.PLATINUM));
  public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate", () ->
      new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.CHESTPLATE, RawItem.PLATINUM));
  public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings", () ->
      new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.LEGGINGS, RawItem.PLATINUM));
  public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots", () ->
      new HeatResArmor(TekoraArmors.PLATINUM, ArmorItem.Type.BOOTS, RawItem.PLATINUM));
  public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () ->
      new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.HELMET, RawItem.SILVER));
  public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () ->
      new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.CHESTPLATE, RawItem.SILVER));
  public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () ->
      new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.LEGGINGS, RawItem.SILVER));
  public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () ->
      new TekoraArmor(TekoraArmors.SILVER, ArmorItem.Type.BOOTS, RawItem.SILVER));
  public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () ->
      new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.HELMET, RawItem.STEEL));
  public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () ->
      new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.CHESTPLATE, RawItem.STEEL));
  public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () ->
      new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.LEGGINGS, RawItem.STEEL));
  public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () ->
      new TekoraArmor(TekoraArmors.STEEL, ArmorItem.Type.BOOTS, RawItem.STEEL));
  public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () ->
      new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.HELMET, RawItem.TITANIUM));
  public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () ->
      new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.CHESTPLATE, RawItem.TITANIUM));
  public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () ->
      new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.LEGGINGS, RawItem.TITANIUM));
  public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () ->
      new HeatResArmor(TekoraArmors.TITANIUM, ArmorItem.Type.BOOTS, RawItem.TITANIUM));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_HELMET = ITEMS.register("tungsten_steel_helmet", () ->
      new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.HELMET, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_CHESTPLATE = ITEMS.register("tungsten_steel_chestplate", () ->
      new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.CHESTPLATE, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_LEGGINGS = ITEMS.register("tungsten_steel_leggings", () ->
      new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.LEGGINGS, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> TUNGSTEN_STEEL_BOOTS = ITEMS.register("tungsten_steel_boots", () ->
      new HeatResArmor(TekoraArmors.TUNGSTEN_STEEL, ArmorItem.Type.BOOTS, RawItem.TUNGSTEN_STEEL));
  public static final RegistryObject<Item> VANASTEEL_HELMET = ITEMS.register("vanasteel_helmet", () ->
      new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.HELMET, RawItem.VANASTEEL));
  public static final RegistryObject<Item> VANASTEEL_CHESTPLATE = ITEMS.register("vanasteel_chestplate", () ->
      new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.CHESTPLATE, RawItem.VANASTEEL));
  public static final RegistryObject<Item> VANASTEEL_LEGGINGS = ITEMS.register("vanasteel_leggings", () ->
      new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.LEGGINGS, RawItem.VANASTEEL));
  public static final RegistryObject<Item> VANASTEEL_BOOTS = ITEMS.register("vanasteel_boots", () ->
      new HeatResArmor(TekoraArmors.VANASTEEL, ArmorItem.Type.BOOTS, RawItem.VANASTEEL));


  public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
      new HammerItem(Tiers.DIAMOND, RawItem.DIAMOND));

  public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () ->
      new HammerItem(Tiers.GOLD, RawItem.GOLD));

  public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
      new HammerItem(Tiers.IRON, RawItem.IRON));

  public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () ->
      new HammerItem(Tiers.NETHERITE, true, RawItem.NETHERITE));
  
  
  public static final RegistryObject<Item> BORON_AXE = ITEMS.register("boron_axe", () ->
      new TekoraAxeItem(TekoraTiers.BORON,5.0f, 3.0f, true, RawItem.BORON));
  
  public static final RegistryObject<Item> BORON_HOE = ITEMS.register("boron_hoe", () ->
      new TekoraHoeItem(TekoraTiers.BORON,-6,0, true, RawItem.BORON));
  
  public static final RegistryObject<Item> BORON_PICKAXE = ITEMS.register("boron_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.BORON,1, -2.8f, true, RawItem.BORON));
  
  public static final RegistryObject<Item> BORON_SHOVEL = ITEMS.register("boron_shovel", () ->
      new TekoraShovelItem(TekoraTiers.BORON, 1.5f, -3.0f, true, RawItem.BORON));
  
  public static final RegistryObject<Item> BORON_SWORD = ITEMS.register("boron_sword", () ->
      new TekoraSwordItem(TekoraTiers.BORON, 3, -2.4f, true, RawItem.BORON));

  public static final RegistryObject<Item> BORON_HAMMER = ITEMS.register("boron_hammer", () ->
      new HammerItem(TekoraTiers.BORON, true, RawItem.BORON));
  

  public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () ->
      new TekoraAxeItem(TekoraTiers.BRONZE, 6.0f, 3.1f, RawItem.BRONZE));

  public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe", () ->
      new TekoraHoeItem(TekoraTiers.BRONZE,-2,0, RawItem.BRONZE));

  public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.BRONZE,1,-2.8f, RawItem.BRONZE));

  public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () ->
      new TekoraShovelItem(TekoraTiers.BRONZE,1, -2.8f, RawItem.BRONZE));

  public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () ->
      new TekoraSwordItem(TekoraTiers.BRONZE, 3, -2.4f, RawItem.BRONZE));
  
  public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () ->
      new HammerItem(TekoraTiers.BRONZE, RawItem.BRONZE));


  public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () ->
      new TekoraAxeItem(TekoraTiers.PLATINUM, 6.0f, 3.2f, true, RawItem.PLATINUM));

  public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () ->
      new TekoraHoeItem(TekoraTiers.PLATINUM, -3,0, true, RawItem.PLATINUM));

  public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.PLATINUM,1, -2.8f, true, RawItem.PLATINUM));

  public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () ->
      new TekoraShovelItem(TekoraTiers.PLATINUM, 1.5f, -3.0f, true, RawItem.PLATINUM));

  public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () ->
      new TekoraSwordItem(TekoraTiers.PLATINUM, 3, -2.4f, true, RawItem.PLATINUM));

  public static final RegistryObject<Item> PLATINUM_HAMMER = ITEMS.register("platinum_hammer", () ->
      new HammerItem(TekoraTiers.PLATINUM, true, RawItem.PLATINUM));


  public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () ->
      new TekoraAxeItem(TekoraTiers.SILVER,5.6f, 3.2f, RawItem.SILVER));

  public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () ->
      new TekoraHoeItem(TekoraTiers.SILVER, 0,0, RawItem.SILVER));

  public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.SILVER,1, -2.8f, RawItem.SILVER));

  public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () ->
      new TekoraShovelItem(TekoraTiers.SILVER, 1.5f, -3.0f, RawItem.SILVER));

  public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () ->
      new TekoraSwordItem(TekoraTiers.SILVER, 3, -2.4f, RawItem.SILVER));
  
  public static final RegistryObject<Item> SILVER_HAMMER = ITEMS.register("silver_hammer", () ->
      new HammerItem(TekoraTiers.SILVER, RawItem.SILVER));


  public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () ->
      new TekoraAxeItem(TekoraTiers.STEEL, 6.0f, 3.1f, RawItem.STEEL));

  public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () ->
      new TekoraHoeItem(TekoraTiers.STEEL, -2, 0, RawItem.STEEL));

  public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.STEEL,1, -2.8f, RawItem.STEEL));

  public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () ->
      new TekoraShovelItem(TekoraTiers.STEEL, 1.5f, -3.0f, RawItem.STEEL));

  public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () ->
      new TekoraSwordItem(TekoraTiers.STEEL, 3, -2.4f, RawItem.STEEL));

  public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer", () ->
      new HammerItem(TekoraTiers.STEEL, RawItem.STEEL));

  public static final RegistryObject<Item> THORIUM_AXE = ITEMS.register("thorium_axe", ThoriumAxe::new);
  public static final RegistryObject<Item> THORIUM_HOE = ITEMS.register("thorium_hoe", ThoriumHoe::new);
  public static final RegistryObject<Item> THORIUM_PICKAXE = ITEMS.register("thorium_pickaxe", ThoriumPickaxe::new);
  public static final RegistryObject<Item> THORIUM_SHOVEL = ITEMS.register("thorium_shovel", ThoriumShovel::new);
  public static final RegistryObject<Item> THORIUM_SWORD = ITEMS.register("thorium_sword", ThoriumSword::new);
  public static final RegistryObject<Item> THORIUM_HAMMER = ITEMS.register("thorium_hammer", ThoriumHammer::new);

  
  public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () ->
      new TekoraAxeItem(TekoraTiers.TITANIUM, 5.0f, 3.0f, true, RawItem.TITANIUM));

  public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () ->
      new TekoraAxeItem(TekoraTiers.TITANIUM, -5, 0, true, RawItem.TITANIUM));

  public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.TITANIUM,1, -2.8f, true, RawItem.TITANIUM));

  public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () ->
      new TekoraShovelItem(TekoraTiers.TITANIUM, 1.5f, -3.0f, true, RawItem.TITANIUM));

  public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () ->
      new TekoraSwordItem(TekoraTiers.TITANIUM, 3, -2.4f, true, RawItem.TITANIUM));

  public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer", () ->
      new HammerItem(TekoraTiers.TITANIUM, true, RawItem.TITANIUM));

  
  public static final RegistryObject<Item> TUNGSTEN_STEEL_AXE = ITEMS.register("tungsten_steel_axe", () ->
      new TekoraAxeItem(TekoraTiers.TUNGSTEN_STEEL, 5.5f, 3.0f, true, RawItem.TUNGSTEN));

  public static final RegistryObject<Item> TUNGSTEN_STEEL_HOE = ITEMS.register("tungsten_steel_hoe", () ->
      new TekoraAxeItem(TekoraTiers.TUNGSTEN_STEEL, -4, 0, true, RawItem.TUNGSTEN));

  public static final RegistryObject<Item> TUNGSTEN_STEEL_PICKAXE = ITEMS.register("tungsten_steel_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.TUNGSTEN_STEEL,1, -2.8f, true, RawItem.TUNGSTEN));

  public static final RegistryObject<Item> TUNGSTEN_STEEL_SHOVEL = ITEMS.register("tungsten_steel_shovel", () ->
      new TekoraShovelItem(TekoraTiers.TUNGSTEN_STEEL, 1.5f, -3.0f, true, RawItem.TUNGSTEN));

  public static final RegistryObject<Item> TUNGSTEN_STEEL_SWORD = ITEMS.register("tungsten_steel_sword", () ->
      new TekoraSwordItem(TekoraTiers.TUNGSTEN_STEEL, 3, -2.4f, true, RawItem.TUNGSTEN));

  public static final RegistryObject<Item> TUNGSTEN_STEEL_HAMMER = ITEMS.register("tungsten_steel_hammer", () ->
      new HammerItem(TekoraTiers.TUNGSTEN_STEEL, true, RawItem.TUNGSTEN));
  

  public static final RegistryObject<Item> VANASTEEL_AXE = ITEMS.register("vanasteel_axe", () ->
      new TekoraAxeItem(TekoraTiers.VANASTEEL, 5.0f, 3.0f, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> VANASTEEL_HOE = ITEMS.register("vanasteel_hoe", () ->
      new TekoraAxeItem(TekoraTiers.VANASTEEL, -6, 0, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> VANASTEEL_PICKAXE = ITEMS.register("vanasteel_pickaxe", () ->
      new TekoraPickaxeItem(TekoraTiers.VANASTEEL,1, -2.8f, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> VANASTEEL_SHOVEL = ITEMS.register("vanasteel_shovel", () ->
      new TekoraShovelItem(TekoraTiers.VANASTEEL, 1.5f, -3.0f, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> VANASTEEL_SWORD = ITEMS.register("vanasteel_sword", () ->
      new TekoraSwordItem(TekoraTiers.VANASTEEL, 3, -2.4f, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> VANASTEEL_HAMMER = ITEMS.register("vanasteel_hammer", () ->
      new HammerItem(TekoraTiers.VANASTEEL, true, RawItem.VANASTEEL));

  public static final RegistryObject<Item> BASIC_WRENCH = ITEMS.register("basic_wrench", () -> new WrenchItem(false));

  public static final RegistryObject<Item> ADVANCED_WRENCH = ITEMS.register("advanced_wrench", () -> new WrenchItem(true));

  public static final RegistryObject<Item> TURBINE_STATOR = ITEMS.register("turbine_stator", TekoraItem::new);
  public static final RegistryObject<Item> TURBINE_GENERATOR = ITEMS.register("turbine_generator", TekoraItem::new);
  public static final RegistryObject<Item> TURBINE_ROTOR = ITEMS.register("turbine_rotor", TekoraItem::new);

  public static final RegistryObject<Item> CARBON_STEEL_ROD = ITEMS.register("carbon_steel_rod", () -> new RawItem(RawItem.CARBON_STEEL));
  public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new RawItem(RawItem.STEEL));

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