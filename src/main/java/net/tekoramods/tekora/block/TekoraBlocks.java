package net.tekoramods.tekora.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.basic.TekoraBaseBlock;
import net.tekoramods.tekora.block.basic.TekoraExperienceBlock;
import net.tekoramods.tekora.block.basic.TekoraMeltableBlock;
import net.tekoramods.tekora.block.entity.blocks.connecters.EnergyCable;
import net.tekoramods.tekora.block.entity.blocks.connecters.EnergyCableFacade;
import net.tekoramods.tekora.block.entity.blocks.enstorage.InfiniteBattery;
import net.tekoramods.tekora.block.entity.blocks.generators.HydroelectricGeneratorBlock;
import net.tekoramods.tekora.block.entity.blocks.machines.*;
import net.tekoramods.tekora.fluid.TekoraFluids;
import net.tekoramods.tekora.block.fluids.TekoraGasBlock;
import net.tekoramods.tekora.block.fluids.TekoraLiquidBlock;
import net.tekoramods.tekora.block.fluids.TekoraLiquidMixtureBlock;
import net.tekoramods.tekora.fluid.data.TekoraFluidPresets;
import net.tekoramods.tekora.item.TekoraItems;
import net.tekoramods.tekora.item.typical.RawItem;

import java.util.function.Supplier;

public class TekoraBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tekora.MODID);

    public static final RegistryObject<Block> BORAX_BLOCK = registerBlock("borax_block",
            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new TekoraExperienceBlock(2f,2f, Blocks.CLAY, SoundType.SAND));
    public static final RegistryObject<Block> EVAPORITE = registerBlock("evaporite",
            () -> new TekoraExperienceBlock(4f,3f, Blocks.STONE));
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new TekoraExperienceBlock(4f,3f, Blocks.STONE));


    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new TekoraBaseBlock(3f));
    public static final RegistryObject<Block> ANTIMONY_BLOCK = registerBlock("antimony_block", () -> new TekoraBaseBlock(4f));
    public static final RegistryObject<Block> ARSENIC_BLOCK = registerBlock("arsenic_block", () -> new TekoraBaseBlock(4f));
    public static final RegistryObject<Block> BARIUM_BLOCK = registerBlock("barium_block", () -> new TekoraBaseBlock(2f));
    public static final RegistryObject<Block> BERYLLIUM_BLOCK = registerBlock("beryllium_block", () -> new TekoraBaseBlock(6f));
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block", () -> new TekoraBaseBlock(3f));
    public static final RegistryObject<Block> BORON_BLOCK = registerBlock("boron_block", () -> new TekoraBaseBlock(6f), true);
    public static final RegistryObject<Block> CADMIUM_BLOCK = registerBlock("cadmium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CALCIUM_BLOCK = registerBlock("calcium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CERIUM_BLOCK = registerBlock("cerium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CHROMIUM_BLOCK = registerBlock("chromium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> DYSPROSIUM_BLOCK = registerBlock("dysprosium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> ERBIUM_BLOCK = registerBlock("erbium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> EUROPIUM_BLOCK = registerBlock("europium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> GADOLINIUM_BLOCK = registerBlock("gadolinium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> GALLIUM_BLOCK = registerBlock("gallium_block",
            () -> new TekoraMeltableBlock(1f, TekoraFluidPresets.GALLIUM));
    public static final RegistryObject<Block> GERMANIUM_BLOCK = registerBlock("germanium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> HAFNIUM_BLOCK = registerBlock("hafnium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> HOLMIUM_BLOCK = registerBlock("holmium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> INDIUM_BLOCK = registerBlock("indium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> LANTHANUM_BLOCK = registerBlock("lanthanum_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> LUTETIUM_BLOCK = registerBlock("lutetium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MANGANESE_BLOCK = registerBlock("manganese_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = registerBlock("neodymium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> NICKEL_BLOCK = registerBlock("nickel_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> NIOBIUM_BLOCK = registerBlock("niobium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> PALLADIUM_BLOCK = registerBlock("palladium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> PRASEODYMIUM_BLOCK = registerBlock("praseodymium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RHENIUM_BLOCK = registerBlock("rhenium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> RHODIUM_BLOCK = registerBlock("rhodium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> RUTHENIUM_BLOCK = registerBlock("ruthenium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> SAMARIUM_BLOCK = registerBlock("samarium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> SCANDIUM_BLOCK = registerBlock("scandium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> STRONTIUM_BLOCK = registerBlock("strontium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> TANTALUM_BLOCK = registerBlock("tantalum_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> TELLURIUM_BLOCK = registerBlock("tellurium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> TERBIUM_BLOCK = registerBlock("terbium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> THALLIUM_BLOCK = registerBlock("thallium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> THORIUM_BLOCK = registerBlock("thorium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> THULIUM_BLOCK = registerBlock("thulium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> VANADIUM_BLOCK = registerBlock("vanadium_block", TekoraBaseBlock::new, true);
    public static final RegistryObject<Block> YTTERBIUM_BLOCK = registerBlock("ytterbium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> YTTRIUM_BLOCK = registerBlock("yttrium_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = registerBlock("zirconium_block", TekoraBaseBlock::new, true);

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_NICKEL_BLOCK = registerBlock("raw_nickel_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBlock("raw_zinc_block", TekoraBaseBlock::new);

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> BAUXITE_BLOCK = registerBlock("bauxite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CHROMITE_BLOCK = registerBlock("chromite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> CINNABAR_BLOCK = registerBlock("cinnabar_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> COLTAN_BLOCK = registerBlock("coltan_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> DOLOMITE_BLOCK = registerBlock("dolomite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> FLUORITE_BLOCK = registerBlock("fluorite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> HALITE_BLOCK = registerBlock("halite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> MONAZITE_BLOCK = registerBlock("monazite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> RUTILE_BLOCK = registerBlock("rutile_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> URANINITE_BLOCK = registerBlock("uraninite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> WOLFRAMITE_BLOCK = registerBlock("wolframite_block", TekoraBaseBlock::new);
    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block", TekoraBaseBlock::new);

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
    public static final RegistryObject<Block> URANINITE_ORE = registerBlock("uraninite_ore",
            () -> new TekoraExperienceBlock(5.5f,3f, 1, 3));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new TekoraExperienceBlock(4f,3f, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new TekoraExperienceBlock(6.5f,3f, SoundType.DEEPSLATE, 1, 2));
    public static final RegistryObject<Block> DEEPSLATE_URANINITE_ORE = registerBlock("deepslate_uraninite_ore",
            () -> new TekoraExperienceBlock(7f,3.5f, SoundType.DEEPSLATE, 1, 3));
    public static final RegistryObject<Block> WOLFRAMITE_ORE = registerBlock("wolframite_ore",
            () -> new TekoraExperienceBlock(6.75f,3.5f));
    public static final RegistryObject<Block> DEEPSLATE_WOLFRAMITE_ORE = registerBlock("deepslate_wolframite_ore",
            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore",
            () -> new TekoraExperienceBlock(6.75f,3.5f));
    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new TekoraExperienceBlock(6.75f,3.5f));
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new TekoraExperienceBlock(8.25f,4.5f, SoundType.DEEPSLATE));

    public static final RegistryObject<Block> ALUMINUM_CABLE = registerBlock("aluminum_cable", () ->
            new EnergyCable(3f, RawItem.ALUMINUM, 512));
    public static final RegistryObject<Block> ALUMINUM_CABLE_FACADE = BLOCKS.register("aluminum_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.ALUMINUM, 512));
    public static final RegistryObject<Block> COPPER_CABLE = registerBlock("copper_cable", () ->
            new EnergyCable(3f, RawItem.COPPER, 256));
    public static final RegistryObject<Block> COPPER_CABLE_FACADE = BLOCKS.register("copper_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.COPPER, 256));
    public static final RegistryObject<Block> CUPRONICKEL_CABLE = registerBlock("cupronickel_cable", () ->
            new EnergyCable(3f, RawItem.CUPRONICKEL, 1024));
    public static final RegistryObject<Block> CUPRONICKEL_CABLE_FACADE = BLOCKS.register("cupronickel_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.CUPRONICKEL, 1024));
    public static final RegistryObject<Block> ELECTRUM_CABLE = registerBlock("electrum_cable", () ->
            new EnergyCable(3f, RawItem.ELECTRUM, 1024));
    public static final RegistryObject<Block> ELECTRUM_CABLE_FACADE = BLOCKS.register("electrum_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.ELECTRUM, 1024));
    public static final RegistryObject<Block> GOLD_CABLE = registerBlock("gold_cable", () ->
            new EnergyCable(3f, RawItem.GOLD, 512));
    public static final RegistryObject<Block> GOLD_CABLE_FACADE = BLOCKS.register("gold_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.GOLD, 512));
    public static final RegistryObject<Block> SILVER_CABLE = registerBlock("silver_cable", () ->
            new EnergyCable(3f, RawItem.SILVER, 512));
    public static final RegistryObject<Block> SILVER_CABLE_FACADE = BLOCKS.register("silver_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.SILVER, 512));
    public static final RegistryObject<Block> TIN_CABLE = registerBlock("tin_cable", () ->
            new EnergyCable(3f, RawItem.TIN, 256));
    public static final RegistryObject<Block> TIN_CABLE_FACADE = BLOCKS.register("tin_cable_facade", () ->
            new EnergyCableFacade(3f, RawItem.TIN, 256));

    public static final RegistryObject<Block> ALLOY_FURNACE = registerBlock("alloy_furnace", AlloyFurnace::new);
    public static final RegistryObject<Block> INFUSION_FURNACE = registerBlock("infusion_furnace", InfusionFurnace::new);
    public static final RegistryObject<Block> COMPRESSOR = registerBlock("compressor", Compressor::new);

    public static final RegistryObject<Block> CUTTER = registerBlock("cutter", Cutter::new);
    public static final RegistryObject<Block> ELECTRIC_FURNACE = registerBlock("electric_blast_furnace", ElectricFurnace::new);
    public static final RegistryObject<Block> EXTRUDER = registerBlock("extruder", Extruder::new);
    public static final RegistryObject<Block> PULVERIZER = registerBlock("pulverizer", Pulverizer::new);
    public static final RegistryObject<Block> CENTRIFUGE = registerBlock("centrifuge", Centrifuge::new);

    public static final RegistryObject<Block> INFINITE_BATTERY = registerBlock("infinite_battery", InfiniteBattery::new);

    public static final RegistryObject<Block> HYDROELECTRIC_GENERATOR = registerBlock("hydroelectric_generator",
            HydroelectricGeneratorBlock::new);

    // tekora fluids
    public static final RegistryObject<LiquidBlock> GALLIUM_FLUID_BLOCK = BLOCKS.register("gallium_fluid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_GALLIUM_FLUID,
                    "tekora:gallium_block"));
    public static final RegistryObject<LiquidBlock> MERCURY_FLUID_BLOCK = BLOCKS.register("mercury_fluid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_MERCURY_FLUID));
    public static final RegistryObject<LiquidBlock> LIQUID_AMMONIA_BLOCK = BLOCKS.register("ammonia_fluid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_AMMONIA_FLUID));
    public static final RegistryObject<LiquidBlock> PRUSSIC_ACID_BLOCK = BLOCKS.register("prussic_acid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_PRUSSIC_ACID));
    public static final RegistryObject<LiquidBlock> HYDROFLUORIC_ACID_BLOCK = BLOCKS.register("hydrofluoric_acid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_HYDROFLUORIC_ACID));
    public static final RegistryObject<LiquidBlock> HYDROCHLORIC_ACID_BLOCK = BLOCKS.register("hydrochloric_acid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_HYDROCHLORIC_ACID));
    public static final RegistryObject<LiquidBlock> NITRIC_ACID_BLOCK = BLOCKS.register("nitric_acid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_NITRIC_ACID));
    public static final RegistryObject<LiquidBlock> SULFURIC_ACID_BLOCK = BLOCKS.register("sulfuric_acid",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_SULFURIC_ACID));
    public static final RegistryObject<LiquidBlock> AMMONIUM_HYDROXIDE_BLOCK = BLOCKS.register("ammonium_hydroxide",
            () -> new TekoraLiquidMixtureBlock(TekoraFluids.SOURCE_AMMONIUM_HYDROXIDE, "water", false));

    // tekora gases
    public static final RegistryObject<LiquidBlock> HYDROGEN_GAS_BLOCK = BLOCKS.register("hydrogen_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_HYDROGEN_GAS));
    public static final RegistryObject<LiquidBlock> DEUTERIUM_GAS_BLOCK = BLOCKS.register("deuterium_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_DEUTERIUM_GAS));
    public static final RegistryObject<LiquidBlock> TRITIUM_GAS_BLOCK = BLOCKS.register("tritium_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_TRITIUM_GAS));
    public static final RegistryObject<LiquidBlock> HELIUM_GAS_BLOCK = BLOCKS.register("helium_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_HELIUM_GAS));
    public static final RegistryObject<LiquidBlock> NITROGEN_GAS_BLOCK = BLOCKS.register("nitrogen_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_NITROGEN_GAS));
    public static final RegistryObject<LiquidBlock> OXYGEN_GAS_BLOCK = BLOCKS.register("oxygen_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_OXYGEN_GAS));
    public static final RegistryObject<LiquidBlock> FLUORINE_GAS_BLOCK = BLOCKS.register("fluorine_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_FLUORINE_GAS));
    public static final RegistryObject<LiquidBlock> NEON_GAS_BLOCK = BLOCKS.register("neon_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_NEON_GAS));
    public static final RegistryObject<LiquidBlock> CHLORINE_GAS_BLOCK = BLOCKS.register("chlorine_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_CHLORINE_GAS));
    public static final RegistryObject<LiquidBlock> ARGON_GAS_BLOCK = BLOCKS.register("argon_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_ARGON_GAS));
    public static final RegistryObject<LiquidBlock> KRYPTON_GAS_BLOCK = BLOCKS.register("krypton_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_KRYPTON_GAS));
    public static final RegistryObject<LiquidBlock> XENON_GAS_BLOCK = BLOCKS.register("xenon_gas",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_XENON_GAS));
    public static final RegistryObject<LiquidBlock> STEAM_BLOCK = BLOCKS.register("steam",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_STEAM));
    public static final RegistryObject<LiquidBlock> AMMONIA_BLOCK = BLOCKS.register("ammonia",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_AMMONIA));
    public static final RegistryObject<LiquidBlock> HYDROGEN_CYANIDE_BLOCK = BLOCKS.register("hydrogen_cyanide",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_HYDROGEN_CYANIDE));
    public static final RegistryObject<LiquidBlock> HYDROGEN_FLUORIDE_BLOCK = BLOCKS.register("hydrogen_fluoride",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_HYDROGEN_FLUORIDE));
    public static final RegistryObject<LiquidBlock> HYDROGEN_CHLORIDE_BLOCK = BLOCKS.register("hydrogen_chloride",
            () -> new TekoraGasBlock(TekoraFluids.SOURCE_HYDROGEN_CHLORIDE));

    public static final RegistryObject<LiquidBlock> BROMINE_BLOCK = BLOCKS.register("bromine",
            () -> new TekoraLiquidBlock(TekoraFluids.SOURCE_BROMINE_FLUID));

    private static RegistryObject<EnergyCable> registerCable(String name, int strength, int color, int transfer) {
        RegistryObject<EnergyCable> cable = BLOCKS.register(name, () -> new EnergyCable(strength, color, transfer));
        RegistryObject<EnergyCableFacade> facade = BLOCKS.register(name + "_facade", () -> new EnergyCableFacade(strength, color, transfer));

        registerBlockItem(name, cable, false);
        return cable;
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
        TekoraItems.ITEMS.register(name, () -> new BlockItem(block.get(), fireResist ? new Item.Properties().fireResistant() : new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}