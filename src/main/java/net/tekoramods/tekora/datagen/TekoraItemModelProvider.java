package net.tekoramods.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.item.TekoraItems;

public class TekoraItemModelProvider extends ItemModelProvider {
    public TekoraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TekoraItems.RAW_LEAD);
        simpleItem(TekoraItems.RAW_NICKEL);
        simpleItem(TekoraItems.RAW_SILVER);
        simpleItem(TekoraItems.RAW_PLATINUM);
        simpleItem(TekoraItems.RAW_TIN);
        simpleItem(TekoraItems.RAW_ZINC);

        simpleItem(TekoraItems.AQUAMARINE);
        simpleItem(TekoraItems.BAUXITE);
        simpleItem(TekoraItems.CHROMITE);
        simpleItem(TekoraItems.CINNABAR);
        simpleItem(TekoraItems.HALITE);
        simpleItem(TekoraItems.RUBY);
        simpleItem(TekoraItems.SAPPHIRE);
        simpleItem(TekoraItems.URANINITE);
        simpleItem(TekoraItems.ZIRCON);

        simpleItem(TekoraItems.MONAZITE_SHARD);
        simpleItem(TekoraItems.RUTILE_SHARD);

        simpleItem(TekoraItems.COLTAN_PIECE);
        simpleItem(TekoraItems.PYROLUSITE_PIECE);
        simpleItem(TekoraItems.WOLFRAMITE_PIECE);

        simpleItem(TekoraItems.COLTAN);
        simpleItem(TekoraItems.MONAZITE);
        simpleItem(TekoraItems.PYROLUSITE);
        simpleItem(TekoraItems.WOLFRAMITE);
        simpleItem(TekoraItems.RUTILE);

        simpleItem(TekoraItems.PULVERIZED_ANCIENT_DEBRIS);
        simpleItem(TekoraItems.PULVERIZED_AQUAMARINE_ORE);
        simpleItem(TekoraItems.PULVERIZED_BAUXITE_ORE);
        simpleItem(TekoraItems.PULVERIZED_CINNABAR_ORE);
        simpleItem(TekoraItems.PULVERIZED_COAL_ORE);
        simpleItem(TekoraItems.PULVERIZED_DIAMOND_ORE);
        simpleItem(TekoraItems.PULVERIZED_EMERALD_ORE);
        simpleItem(TekoraItems.PULVERIZED_HALITE_ORE);
        simpleItem(TekoraItems.PULVERIZED_LAPIS_ORE);
        simpleItem(TekoraItems.PULVERIZED_QUARTZ_ORE);
        simpleItem(TekoraItems.PULVERIZED_REDSTONE_ORE);
        simpleItem(TekoraItems.PULVERIZED_RUBY_ORE);
        simpleItem(TekoraItems.PULVERIZED_SAPPHIRE_ORE);
        simpleItem(TekoraItems.PULVERIZED_URANINITE_ORE);
        simpleItem(TekoraItems.PULVERIZED_WOLFRAMITE_ORE);
        simpleItem(TekoraItems.PULVERIZED_ZIRCON_ORE);

        simpleItem(TekoraItems.DOLOMITE);
        simpleItem(TekoraItems.FLUORITE);

        plainIngotItem(TekoraItems.ALUMINUM_INGOT);
        plainIngotItem(TekoraItems.BARIUM_INGOT);
        plainIngotItem(TekoraItems.BERYLLIUM_INGOT);
        simpleItem(TekoraItems.BISMUTH_INGOT);
        plainIngotItem(TekoraItems.CADMIUM_INGOT);
        plainIngotItem(TekoraItems.CALCIUM_INGOT);
        roughIngotItem(TekoraItems.CERIUM_INGOT);
        plainIngotItem(TekoraItems.CESIUM_INGOT);
        plainIngotItem(TekoraItems.CHROMIUM_INGOT);
        shinyIngotItem(TekoraItems.COBALT_INGOT);
        roughIngotItem(TekoraItems.DYSPROSIUM_INGOT);
        roughIngotItem(TekoraItems.ERBIUM_INGOT);
        roughIngotItem(TekoraItems.EUROPIUM_INGOT);
        roughIngotItem(TekoraItems.GADOLINIUM_INGOT);
        plainIngotItem(TekoraItems.GALLIUM_INGOT);
        plainIngotItem(TekoraItems.HAFNIUM_INGOT);
        roughIngotItem(TekoraItems.HOLMIUM_INGOT);
        plainIngotItem(TekoraItems.INDIUM_INGOT);
        shinyIngotItem(TekoraItems.IRIDIUM_INGOT);
        roughIngotItem(TekoraItems.LANTHANUM_INGOT);
        plainIngotItem(TekoraItems.LEAD_INGOT);
        plainIngotItem(TekoraItems.LITHIUM_INGOT);
        roughIngotItem(TekoraItems.LUTETIUM_INGOT);
        plainIngotItem(TekoraItems.MAGNESIUM_INGOT);
        plainIngotItem(TekoraItems.MANGANESE_INGOT);
        plainIngotItem(TekoraItems.MOLYBDENUM_INGOT);
        roughIngotItem(TekoraItems.NEODYMIUM_INGOT);
        shinyIngotItem(TekoraItems.NICKEL_INGOT);
        plainIngotItem(TekoraItems.NIOBIUM_INGOT);
        shinyIngotItem(TekoraItems.OSMIUM_INGOT);
        shinyIngotItem(TekoraItems.PALLADIUM_INGOT);
        shinyIngotItem(TekoraItems.PLATINUM_INGOT);
        roughIngotItem(TekoraItems.PRASEODYMIUM_INGOT);
        plainIngotItem(TekoraItems.POTASSIUM_INGOT);
        plainIngotItem(TekoraItems.RHENIUM_INGOT);
        shinyIngotItem(TekoraItems.RHODIUM_INGOT);
        plainIngotItem(TekoraItems.RUBIDIUM_INGOT);
        shinyIngotItem(TekoraItems.RUTHENIUM_INGOT);
        roughIngotItem(TekoraItems.SAMARIUM_INGOT);
        plainIngotItem(TekoraItems.SCANDIUM_INGOT);
        shinyIngotItem(TekoraItems.SILVER_INGOT);
        plainIngotItem(TekoraItems.SODIUM_INGOT);
        plainIngotItem(TekoraItems.STRONTIUM_INGOT);
        plainIngotItem(TekoraItems.TANTALUM_INGOT);
        roughIngotItem(TekoraItems.TERBIUM_INGOT);
        plainIngotItem(TekoraItems.THALLIUM_INGOT);
        roughIngotItem(TekoraItems.THORIUM_INGOT);
        roughIngotItem(TekoraItems.THULIUM_INGOT);
        plainIngotItem(TekoraItems.TIN_INGOT);
        plainIngotItem(TekoraItems.TITANIUM_INGOT);
        plainIngotItem(TekoraItems.TUNGSTEN_INGOT);
        roughIngotItem(TekoraItems.URANIUM_INGOT);
        plainIngotItem(TekoraItems.VANADIUM_INGOT);
        roughIngotItem(TekoraItems.YTTERBIUM_INGOT);
        plainIngotItem(TekoraItems.YTTRIUM_INGOT);
        plainIngotItem(TekoraItems.ZINC_INGOT);
        plainIngotItem(TekoraItems.ZIRCONIUM_INGOT);

        shinyIngotItem(TekoraItems.BRASS_INGOT);
        shinyIngotItem(TekoraItems.BRONZE_INGOT);
        refinedIngotItem(TekoraItems.CARBON_STEEL_INGOT);
        refinedIngotItem(TekoraItems.CHROMOLY_STEEL_INGOT);
        shinyIngotItem(TekoraItems.CUPRONICKEL_INGOT);
        shinyIngotItem(TekoraItems.ELECTRUM_INGOT);
        plainIngotItem(TekoraItems.FERROBORON_INGOT);
        plainIngotItem(TekoraItems.GALVANIZED_STEEL_INGOT);
        refinedIngotItem(TekoraItems.HSLA_STEEL_INGOT);
        shinyIngotItem(TekoraItems.INCONEL_INGOT);
        shinyIngotItem(TekoraItems.INVAR_INGOT);
        plainIngotItem(TekoraItems.MAGNETIC_NEODYMIUM_INGOT);
        shinyIngotItem(TekoraItems.MU_METAL_INGOT);
        plainIngotItem(TekoraItems.REACTOR_STEEL_INGOT);
        refinedIngotItem(TekoraItems.STAINLESS_STEEL_INGOT);
        plainIngotItem(TekoraItems.STEEL_INGOT);
        plainIngotItem(TekoraItems.TUNGSTEN_CARBIDE_INGOT);
        refinedIngotItem(TekoraItems.TUNGSTEN_STEEL_INGOT);
        plainIngotItem(TekoraItems.VANASTEEL_INGOT);
        plainIngotItem(TekoraItems.ZIRCALOY_INGOT);

        simpleItem(TekoraItems.COPPER_STEEL);

        simpleItem(TekoraItems.GRAPHITE_BAR);
        simpleItem(TekoraItems.IODINE_BAR);

        pieceItem(TekoraItems.ANTIMONY_PIECE);
        pieceItem(TekoraItems.ARSENIC_PIECE);
        pieceItem(TekoraItems.BORON_PIECE);
        pieceItem(TekoraItems.GERMANIUM_PIECE);
        pieceItem(TekoraItems.SILICON_PIECE);
        pieceItem(TekoraItems.TELLURIUM_PIECE);

        pieceItem(TekoraItems.MAGNESIUM_DIBORIDE);
        pieceItem(TekoraItems.NIOBIUM_TIN);
        pieceItem(TekoraItems.SILICON_CARBIDE);

        lumpyNuggetItem(TekoraItems.ALUMINUM_NUGGET);
        sNuggetItem(TekoraItems.BARIUM_NUGGET);
        rockyNuggetItem(TekoraItems.BERYLLIUM_NUGGET);
        simpleItem(TekoraItems.BISMUTH_NUGGET);
        lumpyNuggetItem(TekoraItems.CADMIUM_NUGGET);
        sNuggetItem(TekoraItems.CALCIUM_NUGGET);
        rockyNuggetItem(TekoraItems.CERIUM_NUGGET);
        sNuggetItem(TekoraItems.CESIUM_NUGGET);
        rightNuggetItem(TekoraItems.CHROMIUM_NUGGET);
        crystalNuggetItem(TekoraItems.COBALT_NUGGET);
        simpleItem(TekoraItems.COPPER_NUGGET);
        rockyNuggetItem(TekoraItems.DYSPROSIUM_NUGGET);
        rockyNuggetItem(TekoraItems.ERBIUM_NUGGET);
        rockyNuggetItem(TekoraItems.EUROPIUM_NUGGET);
        rockyNuggetItem(TekoraItems.GADOLINIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.GALLIUM_NUGGET);
        rightNuggetItem(TekoraItems.HAFNIUM_NUGGET);
        rockyNuggetItem(TekoraItems.HOLMIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.INDIUM_NUGGET);
        crystalNuggetItem(TekoraItems.IRIDIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.LANTHANUM_NUGGET);
        lumpyNuggetItem(TekoraItems.LEAD_NUGGET);
        sNuggetItem(TekoraItems.LITHIUM_NUGGET);
        rockyNuggetItem(TekoraItems.LUTETIUM_NUGGET);
        sNuggetItem(TekoraItems.MAGNESIUM_NUGGET);
        rightNuggetItem(TekoraItems.MANGANESE_NUGGET);
        leftNuggetItem(TekoraItems.MOLYBDENUM_NUGGET);
        rockyNuggetItem(TekoraItems.NEODYMIUM_NUGGET);
        crystalNuggetItem(TekoraItems.NICKEL_NUGGET);
        leftNuggetItem(TekoraItems.NIOBIUM_NUGGET);
        crystalNuggetItem(TekoraItems.OSMIUM_NUGGET);
        rightNuggetItem(TekoraItems.PALLADIUM_NUGGET);
        rockyNuggetItem(TekoraItems.PLATINUM_NUGGET);
        sNuggetItem(TekoraItems.PRASEODYMIUM_NUGGET);
        rockyNuggetItem(TekoraItems.POTASSIUM_NUGGET);
        nuggetItem(TekoraItems.RHENIUM_NUGGET);
        rightNuggetItem(TekoraItems.RHODIUM_NUGGET);
        sNuggetItem(TekoraItems.RUBIDIUM_NUGGET);
        rightNuggetItem(TekoraItems.RUTHENIUM_NUGGET);
        rockyNuggetItem(TekoraItems.SAMARIUM_NUGGET);
        rockyNuggetItem(TekoraItems.SCANDIUM_NUGGET);
        rightNuggetItem(TekoraItems.SILVER_NUGGET);
        sNuggetItem(TekoraItems.SODIUM_NUGGET);
        sNuggetItem(TekoraItems.STRONTIUM_NUGGET);
        rightNuggetItem(TekoraItems.TANTALUM_NUGGET);
        rockyNuggetItem(TekoraItems.TERBIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.THALLIUM_NUGGET);
        rockyNuggetItem(TekoraItems.THORIUM_NUGGET);
        rockyNuggetItem(TekoraItems.THULIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.TIN_NUGGET);
        leftNuggetItem(TekoraItems.TITANIUM_NUGGET);
        leftNuggetItem(TekoraItems.TUNGSTEN_NUGGET);
        rockyNuggetItem(TekoraItems.URANIUM_NUGGET);
        nuggetItem(TekoraItems.VANADIUM_NUGGET);
        rockyNuggetItem(TekoraItems.YTTERBIUM_NUGGET);
        rockyNuggetItem(TekoraItems.YTTRIUM_NUGGET);
        lumpyNuggetItem(TekoraItems.ZINC_NUGGET);
        leftNuggetItem(TekoraItems.ZIRCONIUM_NUGGET);

        crystalNuggetItem(TekoraItems.BRASS_NUGGET);
        crystalNuggetItem(TekoraItems.BRONZE_NUGGET);
        nuggetItem(TekoraItems.CARBON_STEEL_NUGGET);
        nuggetItem(TekoraItems.CHROMOLY_STEEL_NUGGET);
        crystalNuggetItem(TekoraItems.CUPRONICKEL_NUGGET);
        crystalNuggetItem(TekoraItems.ELECTRUM_NUGGET);
        leftNuggetItem(TekoraItems.FERROBORON_NUGGET);
        nuggetItem(TekoraItems.HSLA_STEEL_NUGGET);
        crystalNuggetItem(TekoraItems.INCONEL_NUGGET);
        crystalNuggetItem(TekoraItems.INVAR_NUGGET);
        leftNuggetItem(TekoraItems.MAGNETIC_NEODYMIUM_NUGGET);
        crystalNuggetItem(TekoraItems.MU_METAL_NUGGET);
        leftNuggetItem(TekoraItems.REACTOR_STEEL_NUGGET);
        nuggetItem(TekoraItems.STAINLESS_STEEL_NUGGET);
        leftNuggetItem(TekoraItems.STEEL_NUGGET);
        leftNuggetItem(TekoraItems.TUNGSTEN_CARBIDE_NUGGET);
        nuggetItem(TekoraItems.TUNGSTEN_STEEL_NUGGET);
        leftNuggetItem(TekoraItems.VANASTEEL_NUGGET);
        leftNuggetItem(TekoraItems.ZIRCALOY_NUGGET);

        simpleItem(TekoraItems.PHOSPHORUS_DUST);
        simpleItem(TekoraItems.SULFUR_DUST);
        simpleItem(TekoraItems.SELENIUM_DUST);

        simpleItem(TekoraItems.GRAPHITE_DUST);
        simpleItem(TekoraItems.IODINE_DUST);

        simpleItem(TekoraItems.COPPER_DUST);
        simpleItem(TekoraItems.GOLD_DUST);
        simpleItem(TekoraItems.IRON_DUST);

        dustItem(TekoraItems.ALUMINUM_DUST);
        dustItem(TekoraItems.BARIUM_DUST);
        dustItem(TekoraItems.BERYLLIUM_DUST);
        dustItem(TekoraItems.BISMUTH_DUST);
        dustItem(TekoraItems.CADMIUM_DUST);
        dustItem(TekoraItems.CALCIUM_DUST);
        dustItem(TekoraItems.CERIUM_DUST);
        dustItem(TekoraItems.CESIUM_DUST);
        dustItem(TekoraItems.CHROMIUM_DUST);
        dustItem(TekoraItems.COBALT_DUST);
        dustItem(TekoraItems.DYSPROSIUM_DUST);
        dustItem(TekoraItems.ERBIUM_DUST);
        dustItem(TekoraItems.EUROPIUM_DUST);
        dustItem(TekoraItems.GADOLINIUM_DUST);
        dustItem(TekoraItems.GALLIUM_DUST);
        dustItem(TekoraItems.HAFNIUM_DUST);
        dustItem(TekoraItems.HOLMIUM_DUST);
        dustItem(TekoraItems.INDIUM_DUST);
        dustItem(TekoraItems.IRIDIUM_DUST);
        dustItem(TekoraItems.LANTHANUM_DUST);
        dustItem(TekoraItems.LEAD_DUST);
        dustItem(TekoraItems.LITHIUM_DUST);
        dustItem(TekoraItems.LUTETIUM_DUST);
        dustItem(TekoraItems.MAGNESIUM_DUST);
        dustItem(TekoraItems.MANGANESE_DUST);
        dustItem(TekoraItems.MOLYBDENUM_DUST);
        dustItem(TekoraItems.NEODYMIUM_DUST);
        dustItem(TekoraItems.NICKEL_DUST);
        dustItem(TekoraItems.NIOBIUM_DUST);
        dustItem(TekoraItems.OSMIUM_DUST);
        dustItem(TekoraItems.PALLADIUM_DUST);
        dustItem(TekoraItems.PLATINUM_DUST);
        dustItem(TekoraItems.PRASEODYMIUM_DUST);
        dustItem(TekoraItems.POTASSIUM_DUST);
        dustItem(TekoraItems.RHENIUM_DUST);
        dustItem(TekoraItems.RHODIUM_DUST);
        dustItem(TekoraItems.RUBIDIUM_DUST);
        dustItem(TekoraItems.RUTHENIUM_DUST);
        dustItem(TekoraItems.SAMARIUM_DUST);
        dustItem(TekoraItems.SCANDIUM_DUST);
        dustItem(TekoraItems.SILVER_DUST);
        dustItem(TekoraItems.SODIUM_DUST);
        dustItem(TekoraItems.STRONTIUM_DUST);
        dustItem(TekoraItems.TANTALUM_DUST);
        dustItem(TekoraItems.TERBIUM_DUST);
        dustItem(TekoraItems.THALLIUM_DUST);
        dustItem(TekoraItems.THORIUM_DUST);
        dustItem(TekoraItems.THULIUM_DUST);
        dustItem(TekoraItems.TIN_DUST);
        dustItem(TekoraItems.TITANIUM_DUST);
        dustItem(TekoraItems.TUNGSTEN_DUST);
        dustItem(TekoraItems.URANIUM_DUST);
        dustItem(TekoraItems.VANADIUM_DUST);
        dustItem(TekoraItems.YTTERBIUM_DUST);
        dustItem(TekoraItems.YTTRIUM_DUST);
        dustItem(TekoraItems.ZINC_DUST);
        dustItem(TekoraItems.ZIRCONIUM_DUST);

        simpleItem(TekoraItems.COPPER_STEEL_DUST);

        dustItem(TekoraItems.ARSENIC_DUST);
        dustItem(TekoraItems.ANTIMONY_DUST);
        dustItem(TekoraItems.BORON_DUST);
        dustItem(TekoraItems.GERMANIUM_DUST);
        dustItem(TekoraItems.SILICON_DUST);
        dustItem(TekoraItems.TELLURIUM_DUST);

        dustItem(TekoraItems.BRASS_DUST);
        dustItem(TekoraItems.BRONZE_DUST);
        dustItem(TekoraItems.CARBON_STEEL_DUST);
        dustItem(TekoraItems.CHROMOLY_STEEL_DUST);
        dustItem(TekoraItems.CUPRONICKEL_DUST);
        dustItem(TekoraItems.ELECTRUM_DUST);
        dustItem(TekoraItems.FERROBORON_DUST);
        dustItem(TekoraItems.HSLA_STEEL_DUST);
        dustItem(TekoraItems.INCONEL_DUST);
        dustItem(TekoraItems.INVAR_DUST);
        dustItem(TekoraItems.MAGNETIC_NEODYMIUM_DUST);
        dustItem(TekoraItems.MU_METAL_DUST);
        dustItem(TekoraItems.REACTOR_STEEL_DUST);
        dustItem(TekoraItems.STAINLESS_STEEL_DUST);
        dustItem(TekoraItems.STEEL_DUST);
        dustItem(TekoraItems.TUNGSTEN_CARBIDE_DUST);
        dustItem(TekoraItems.TUNGSTEN_STEEL_DUST);
        dustItem(TekoraItems.VANASTEEL_DUST);
        dustItem(TekoraItems.ZIRCALOY_DUST);

        simpleItem(TekoraItems.COPPER_TINY_DUST);
        simpleItem(TekoraItems.GOLD_TINY_DUST);
        simpleItem(TekoraItems.IRON_TINY_DUST);

        tinyDustItem(TekoraItems.ALUMINUM_TINY_DUST);
        tinyDustItem(TekoraItems.BARIUM_TINY_DUST);
        tinyDustItem(TekoraItems.BERYLLIUM_TINY_DUST);
        tinyDustItem(TekoraItems.CADMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.CALCIUM_TINY_DUST);
        tinyDustItem(TekoraItems.CERIUM_TINY_DUST);
        tinyDustItem(TekoraItems.CESIUM_TINY_DUST);
        tinyDustItem(TekoraItems.CHROMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.COBALT_TINY_DUST);
        tinyDustItem(TekoraItems.DYSPROSIUM_TINY_DUST);
        tinyDustItem(TekoraItems.ERBIUM_TINY_DUST);
        tinyDustItem(TekoraItems.EUROPIUM_TINY_DUST);
        tinyDustItem(TekoraItems.GADOLINIUM_TINY_DUST);
        tinyDustItem(TekoraItems.GALLIUM_TINY_DUST);
        tinyDustItem(TekoraItems.HAFNIUM_TINY_DUST);
        tinyDustItem(TekoraItems.HOLMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.INDIUM_TINY_DUST);
        tinyDustItem(TekoraItems.IRIDIUM_TINY_DUST);
        tinyDustItem(TekoraItems.LANTHANUM_TINY_DUST);
        tinyDustItem(TekoraItems.LEAD_TINY_DUST);
        tinyDustItem(TekoraItems.LITHIUM_TINY_DUST);
        tinyDustItem(TekoraItems.LUTETIUM_TINY_DUST);
        tinyDustItem(TekoraItems.MAGNESIUM_TINY_DUST);
        tinyDustItem(TekoraItems.MANGANESE_TINY_DUST);
        tinyDustItem(TekoraItems.MOLYBDENUM_TINY_DUST);
        tinyDustItem(TekoraItems.NEODYMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.NICKEL_TINY_DUST);
        tinyDustItem(TekoraItems.NIOBIUM_TINY_DUST);
        tinyDustItem(TekoraItems.OSMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.PALLADIUM_TINY_DUST);
        tinyDustItem(TekoraItems.PLATINUM_TINY_DUST);
        tinyDustItem(TekoraItems.PRASEODYMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.POTASSIUM_TINY_DUST);
        tinyDustItem(TekoraItems.RHENIUM_TINY_DUST);
        tinyDustItem(TekoraItems.RHODIUM_TINY_DUST);
        tinyDustItem(TekoraItems.RUBIDIUM_TINY_DUST);
        tinyDustItem(TekoraItems.RUTHENIUM_TINY_DUST);
        tinyDustItem(TekoraItems.SAMARIUM_TINY_DUST);
        tinyDustItem(TekoraItems.SCANDIUM_TINY_DUST);
        tinyDustItem(TekoraItems.SILVER_TINY_DUST);
        tinyDustItem(TekoraItems.SODIUM_TINY_DUST);
        tinyDustItem(TekoraItems.STRONTIUM_TINY_DUST);
        tinyDustItem(TekoraItems.TANTALUM_TINY_DUST);
        tinyDustItem(TekoraItems.TERBIUM_TINY_DUST);
        tinyDustItem(TekoraItems.THALLIUM_TINY_DUST);
        tinyDustItem(TekoraItems.THORIUM_TINY_DUST);
        tinyDustItem(TekoraItems.THULIUM_TINY_DUST);
        tinyDustItem(TekoraItems.TIN_TINY_DUST);
        tinyDustItem(TekoraItems.TITANIUM_TINY_DUST);
        tinyDustItem(TekoraItems.TUNGSTEN_TINY_DUST);
        tinyDustItem(TekoraItems.URANIUM_TINY_DUST);
        tinyDustItem(TekoraItems.VANADIUM_TINY_DUST);
        tinyDustItem(TekoraItems.YTTERBIUM_TINY_DUST);
        tinyDustItem(TekoraItems.YTTRIUM_TINY_DUST);
        tinyDustItem(TekoraItems.ZINC_TINY_DUST);
        tinyDustItem(TekoraItems.ZIRCONIUM_TINY_DUST);

        tinyDustItem(TekoraItems.ARSENIC_TINY_DUST);
        tinyDustItem(TekoraItems.ANTIMONY_TINY_DUST);
        tinyDustItem(TekoraItems.BORON_TINY_DUST);
        tinyDustItem(TekoraItems.GERMANIUM_TINY_DUST);
        tinyDustItem(TekoraItems.SILICON_TINY_DUST);
        tinyDustItem(TekoraItems.TELLURIUM_TINY_DUST);

        tinyDustItem(TekoraItems.BRASS_TINY_DUST);
        tinyDustItem(TekoraItems.BRONZE_TINY_DUST);
        tinyDustItem(TekoraItems.CARBON_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.CHROMOLY_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.CUPRONICKEL_TINY_DUST);
        tinyDustItem(TekoraItems.ELECTRUM_TINY_DUST);
        tinyDustItem(TekoraItems.FERROBORON_TINY_DUST);
        tinyDustItem(TekoraItems.HSLA_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.INCONEL_TINY_DUST);
        tinyDustItem(TekoraItems.INVAR_TINY_DUST);
        tinyDustItem(TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST);
        tinyDustItem(TekoraItems.MU_METAL_TINY_DUST);
        tinyDustItem(TekoraItems.REACTOR_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.STAINLESS_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST);
        tinyDustItem(TekoraItems.TUNGSTEN_STEEL_TINY_DUST);
        tinyDustItem(TekoraItems.VANASTEEL_TINY_DUST);
        tinyDustItem(TekoraItems.ZIRCALOY_TINY_DUST);

        simpleItem(TekoraItems.ALUMINA);
        simpleItem(TekoraItems.AHCP);
        simpleItem(TekoraItems.APT);
        simpleItem(TekoraItems.BAKING_SODA);
        simpleItem(TekoraItems.BN_DUST);
        simpleItem(TekoraItems.BORAX);
        simpleItem(TekoraItems.POTASSIUM_PM);
        simpleItem(TekoraItems.SALT);
        simpleItem(TekoraItems.SILICA);

        simpleItem(TekoraItems.POTASSIUM_IODIDE);

        simpleItem(TekoraItems.BORIC_ACID);
        simpleItem(TekoraItems.PHOSPHORIC_ACID);
        simpleItem(TekoraItems.SODIUM_HYDRIDE);

        simpleItem(TekoraItems.GENERIC_DUST);

        simpleItem(TekoraItems.COPPER_PLATE);
        simpleItem(TekoraItems.GOLD_PLATE);
        simpleItem(TekoraItems.IRON_PLATE);

        plateItem(TekoraItems.ALUMINUM_PLATE);
        plateItem(TekoraItems.BISMUTH_PLATE);
        plateItem(TekoraItems.CADMIUM_PLATE);
        plateItem(TekoraItems.CHROMIUM_PLATE);
        plateItem(TekoraItems.COBALT_PLATE);
        plateItem(TekoraItems.INDIUM_PLATE);
        plateItem(TekoraItems.IRIDIUM_PLATE);
        plateItem(TekoraItems.LEAD_PLATE);
        plateItem(TekoraItems.MAGNESIUM_PLATE);
        plateItem(TekoraItems.MANGANESE_PLATE);
        plateItem(TekoraItems.MOLYBDENUM_PLATE);
        plateItem(TekoraItems.NICKEL_PLATE);
        plateItem(TekoraItems.NIOBIUM_PLATE);
        plateItem(TekoraItems.OSMIUM_PLATE);
        plateItem(TekoraItems.PALLADIUM_PLATE);
        plateItem(TekoraItems.PLATINUM_PLATE);
        plateItem(TekoraItems.RHODIUM_PLATE);
        plateItem(TekoraItems.SCANDIUM_PLATE);
        plateItem(TekoraItems.SILVER_PLATE);
        plateItem(TekoraItems.THORIUM_PLATE);
        plateItem(TekoraItems.THULIUM_PLATE);
        plateItem(TekoraItems.TIN_PLATE);
        plateItem(TekoraItems.TITANIUM_PLATE);
        plateItem(TekoraItems.TUNGSTEN_PLATE);
        plateItem(TekoraItems.YTTERBIUM_PLATE);
        plateItem(TekoraItems.ZINC_PLATE);
        plateItem(TekoraItems.ZIRCONIUM_PLATE);

        simpleItem(TekoraItems.COPPER_STEEL_PLATE);

        plateItem(TekoraItems.BRASS_PLATE);
        plateItem(TekoraItems.BRONZE_PLATE);
        plateItem(TekoraItems.CHROMOLY_STEEL_PLATE);
        plateItem(TekoraItems.CUPRONICKEL_PLATE);
        plateItem(TekoraItems.ELECTRUM_PLATE);
        plateItem(TekoraItems.FERROBORON_PLATE);
        plateItem(TekoraItems.GALVANIZED_STEEL_PLATE);
        plateItem(TekoraItems.HSLA_STEEL_PLATE);
        plateItem(TekoraItems.INCONEL_PLATE);
        plateItem(TekoraItems.INVAR_PLATE);
        plateItem(TekoraItems.MAGNETIC_NEODYMIUM_PLATE);
        plateItem(TekoraItems.MU_METAL_PLATE);
        plateItem(TekoraItems.REACTOR_STEEL_PLATE);
        plateItem(TekoraItems.STAINLESS_STEEL_PLATE);
        plateItem(TekoraItems.STEEL_PLATE);
        plateItem(TekoraItems.TUNGSTEN_CARBIDE_PLATE);
        plateItem(TekoraItems.TUNGSTEN_STEEL_PLATE);
        plateItem(TekoraItems.VANASTEEL_PLATE);
        plateItem(TekoraItems.ZIRCALOY_PLATE);

        swordItem(TekoraItems.BORON_SWORD);
        swordItem(TekoraItems.BRONZE_SWORD);
        swordItem(TekoraItems.PLATINUM_SWORD);
        swordItem(TekoraItems.SILVER_SWORD);
        swordItem(TekoraItems.STEEL_SWORD);
        swordItem(TekoraItems.THORIUM_SWORD);
        swordItem(TekoraItems.TITANIUM_SWORD);
        swordItem(TekoraItems.TUNGSTEN_STEEL_SWORD);
        swordItem(TekoraItems.VANASTEEL_SWORD);

        axeItem(TekoraItems.BORON_AXE);
        axeItem(TekoraItems.BRONZE_AXE);
        axeItem(TekoraItems.PLATINUM_AXE);
        axeItem(TekoraItems.SILVER_AXE);
        axeItem(TekoraItems.STEEL_AXE);
        axeItem(TekoraItems.THORIUM_AXE);
        axeItem(TekoraItems.TITANIUM_AXE);
        axeItem(TekoraItems.TUNGSTEN_STEEL_AXE);
        axeItem(TekoraItems.VANASTEEL_AXE);

        simpleItem(TekoraItems.DIAMOND_HAMMER);
        simpleItem(TekoraItems.GOLDEN_HAMMER);
        simpleItem(TekoraItems.IRON_HAMMER);
        simpleItem(TekoraItems.NETHERITE_HAMMER);

        hammerItem(TekoraItems.BORON_HAMMER);
        hammerItem(TekoraItems.BRONZE_HAMMER);
        hammerItem(TekoraItems.PLATINUM_HAMMER);
        hammerItem(TekoraItems.SILVER_HAMMER);
        hammerItem(TekoraItems.STEEL_HAMMER);
        hammerItem(TekoraItems.THORIUM_HAMMER);
        hammerItem(TekoraItems.TITANIUM_HAMMER);
        hammerItem(TekoraItems.TUNGSTEN_STEEL_HAMMER);
        hammerItem(TekoraItems.VANASTEEL_HAMMER);

        helmetItem(TekoraItems.BORON_HELMET);
        chestplateItem(TekoraItems.BORON_CHESTPLATE);
        leggingsItem(TekoraItems.BORON_LEGGINGS);
        bootsItem(TekoraItems.BORON_BOOTS);
        helmetItem(TekoraItems.BRONZE_HELMET);
        chestplateItem(TekoraItems.BRONZE_CHESTPLATE);
        leggingsItem(TekoraItems.BRONZE_LEGGINGS);
        bootsItem(TekoraItems.BRONZE_BOOTS);
        helmetItem(TekoraItems.PLATINUM_HELMET);
        chestplateItem(TekoraItems.PLATINUM_CHESTPLATE);
        leggingsItem(TekoraItems.PLATINUM_LEGGINGS);
        bootsItem(TekoraItems.PLATINUM_BOOTS);
        helmetItem(TekoraItems.SILVER_HELMET);
        chestplateItem(TekoraItems.SILVER_CHESTPLATE);
        leggingsItem(TekoraItems.SILVER_LEGGINGS);
        bootsItem(TekoraItems.SILVER_BOOTS);
        helmetItem(TekoraItems.STEEL_HELMET);
        chestplateItem(TekoraItems.STEEL_CHESTPLATE);
        leggingsItem(TekoraItems.STEEL_LEGGINGS);
        bootsItem(TekoraItems.STEEL_BOOTS);
        heavyHelmetItem(TekoraItems.TITANIUM_HELMET);
        heavyChestplateItem(TekoraItems.TITANIUM_CHESTPLATE);
        heavyLeggingsItem(TekoraItems.TITANIUM_LEGGINGS);
        heavyBootsItem(TekoraItems.TITANIUM_BOOTS);
        heavyHelmetItem(TekoraItems.TUNGSTEN_STEEL_HELMET);
        heavyChestplateItem(TekoraItems.TUNGSTEN_STEEL_CHESTPLATE);
        heavyLeggingsItem(TekoraItems.TUNGSTEN_STEEL_LEGGINGS);
        heavyBootsItem(TekoraItems.TUNGSTEN_STEEL_BOOTS);
        helmetItem(TekoraItems.VANASTEEL_HELMET);
        chestplateItem(TekoraItems.VANASTEEL_CHESTPLATE);
        leggingsItem(TekoraItems.VANASTEEL_LEGGINGS);
        bootsItem(TekoraItems.VANASTEEL_BOOTS);

        simpleItem(TekoraItems.BASIC_WRENCH);
        simpleItem(TekoraItems.ADVANCED_WRENCH);

        shovelItem(TekoraItems.BORON_SHOVEL);
        pickaxeItem(TekoraItems.BORON_PICKAXE);
        axeItem(TekoraItems.BORON_AXE);
        hoeItem(TekoraItems.BORON_HOE);
        shovelItem(TekoraItems.BRONZE_SHOVEL);
        pickaxeItem(TekoraItems.BRONZE_PICKAXE);
        axeItem(TekoraItems.BRONZE_AXE);
        hoeItem(TekoraItems.BRONZE_HOE);
        shovelItem(TekoraItems.PLATINUM_SHOVEL);
        pickaxeItem(TekoraItems.PLATINUM_PICKAXE);
        axeItem(TekoraItems.PLATINUM_AXE);
        hoeItem(TekoraItems.PLATINUM_HOE);
        shovelItem(TekoraItems.SILVER_SHOVEL);
        pickaxeItem(TekoraItems.SILVER_PICKAXE);
        axeItem(TekoraItems.SILVER_AXE);
        hoeItem(TekoraItems.SILVER_HOE);
        shovelItem(TekoraItems.STEEL_SHOVEL);
        pickaxeItem(TekoraItems.STEEL_PICKAXE);
        axeItem(TekoraItems.STEEL_AXE);
        hoeItem(TekoraItems.STEEL_HOE);
        shovelItem(TekoraItems.THORIUM_SHOVEL);
        pickaxeItem(TekoraItems.THORIUM_PICKAXE);
        axeItem(TekoraItems.THORIUM_AXE);
        hoeItem(TekoraItems.THORIUM_HOE);
        shovelItem(TekoraItems.TITANIUM_SHOVEL);
        pickaxeItem(TekoraItems.TITANIUM_PICKAXE);
        axeItem(TekoraItems.TITANIUM_AXE);
        hoeItem(TekoraItems.TITANIUM_HOE);
        shovelItem(TekoraItems.TUNGSTEN_STEEL_SHOVEL);
        pickaxeItem(TekoraItems.TUNGSTEN_STEEL_PICKAXE);
        axeItem(TekoraItems.TUNGSTEN_STEEL_AXE);
        hoeItem(TekoraItems.TUNGSTEN_STEEL_HOE);
        shovelItem(TekoraItems.VANASTEEL_SHOVEL);
        pickaxeItem(TekoraItems.VANASTEEL_PICKAXE);
        axeItem(TekoraItems.VANASTEEL_AXE);
        hoeItem(TekoraItems.VANASTEEL_HOE);

        rodItem(TekoraItems.STEEL_ROD);
        rodItem(TekoraItems.CARBON_STEEL_ROD);

        simpleItem(TekoraItems.STAINLESS_STEEL_TURBINE);
        simpleItem(TekoraItems.TURBINE_GENERATOR);
        simpleItem(TekoraItems.TURBINE_STATOR);
        simpleItem(TekoraItems.TURBINE_ROTOR);
        simpleItem(TekoraItems.COIL);

        simpleItem(TekoraItems.TITANIUM_TEMPLATE);
        simpleItem(TekoraItems.THORIUM_TEMPLATE);
        simpleItem(TekoraItems.TUNGSTEN_STEEL_TEMPLATE);
        simpleItem(TekoraItems.VANASTEEL_TEMPLATE);

        wireItem(TekoraItems.ALUMINUM_WIRE);
        simpleItem(TekoraItems.COPPER_WIRE);
        wireItem(TekoraItems.CUPRONICKEL_WIRE);
        wireItem(TekoraItems.ELECTRUM_WIRE);
        simpleItem(TekoraItems.GOLD_WIRE);
        wireItem(TekoraItems.SILVER_WIRE);
        wireItem(TekoraItems.TIN_WIRE);

        bucketItem(TekoraItems.AMMONIUM_HYDROXIDE_BUCKET);
        bucketItem(TekoraItems.BROMINE_BUCKET);
        bucketItem(TekoraItems.HYDROFLUORIC_ACID_BUCKET);
        bucketItem(TekoraItems.NITRIC_ACID_BUCKET);
        bucketItem(TekoraItems.SULFURIC_ACID_BUCKET);
        bucketItem(TekoraItems.GALLIUM_BUCKET);
        bucketItem(TekoraItems.MERCURY_BUCKET);

        canisterItem(TekoraItems.TIN_CANISTER);

        cableItem(TekoraBlocks.ALUMINUM_CABLE);
        blockItem(TekoraBlocks.COPPER_CABLE);
        cableItem(TekoraBlocks.CUPRONICKEL_CABLE);
        cableItem(TekoraBlocks.ELECTRUM_CABLE);
        blockItem(TekoraBlocks.GOLD_CABLE);
        cableItem(TekoraBlocks.SILVER_CABLE);
        cableItem(TekoraBlocks.TIN_CABLE);

        blockAsItem(TekoraBlocks.RUBBER_SAPLING);
    }

    private ItemModelBuilder blockItem(RegistryObject<? extends Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID, "item/" + block.getId().getPath()));
    }

    private ItemModelBuilder itemParentBlock(RegistryObject<? extends Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(Tekora.MODID, "block/" + block.getId().getPath()));
    }

    private ItemModelBuilder cableItem(RegistryObject<? extends Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID, "item/items/cable"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder blockAsItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder plainIngotItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/plain_ingot"));
    }

    private ItemModelBuilder refinedIngotItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/refined_ingot"));
    }

    private ItemModelBuilder roughIngotItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/rough_ingot"));
    }

    private ItemModelBuilder shinyIngotItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/shiny_ingot"));
    }

    private ItemModelBuilder pieceItem(RegistryObject<? extends Item> item) {

        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/piece"));
    }

    private ItemModelBuilder dustItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/dust"));
    }

    private ItemModelBuilder tinyDustItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/tiny_dust"));
    }

    private ItemModelBuilder lumpyNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/lumpy_nugget"));
    }

    private ItemModelBuilder sNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/s_nugget"));
    }

    private ItemModelBuilder crystalNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/crystal_nugget"));
    }

    private ItemModelBuilder rockyNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/rocky_nugget"));
    }

    private ItemModelBuilder rightNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/items/right_nugget"));
    }

    private ItemModelBuilder leftNuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/left_nugget"));
    }

    private ItemModelBuilder nuggetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/nugget"));
    }

    private ItemModelBuilder plateItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/plate"));
    }

    private ItemModelBuilder gearItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/gear"));
    }

    private ItemModelBuilder wireItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/wire"));
    }

    private ItemModelBuilder rodItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/items/rod"));
    }

    private ItemModelBuilder swordItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/swordstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/sword"));
    }

    private ItemModelBuilder pickaxeItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/digstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/pickaxe"));
    }


    private ItemModelBuilder axeItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/attackstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/axe"));
    }

    private ItemModelBuilder shovelItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/digstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/shovel"));
    }

    private ItemModelBuilder hoeItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/attackstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/hoe"));
    }

    private ItemModelBuilder hammerItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(Tekora.MODID,"item/tools/hammerstick"))
                .texture("layer1", new ResourceLocation(Tekora.MODID,"item/tools/hammer"));
    }

    private ItemModelBuilder bootsItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/boots"));
    }

    private ItemModelBuilder leggingsItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/leggings"));
    }

    private ItemModelBuilder chestplateItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/chestplate"));
    }

    private ItemModelBuilder helmetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/helmet"));
    }

    private ItemModelBuilder heavyBootsItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/heavy_boots"));
    }

    private ItemModelBuilder heavyLeggingsItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/heavy_leggings"));
    }

    private ItemModelBuilder heavyChestplateItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/heavy_chestplate"));
    }

    private ItemModelBuilder heavyHelmetItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/armors/heavy_helmet"));
    }

    private ItemModelBuilder bucketItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation("tekora:item/bucket_liquid"))
                .texture("layer1", new ResourceLocation("tekora:item/bucket"));
    }

    private ItemModelBuilder canisterItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation("tekora:item/canister_interior"))
                .texture("layer1", new ResourceLocation("tekora:item/" + item.getId().getPath() + "_exterior"));
    }

    private ItemModelBuilder itemSpecifiedTexture(RegistryObject<Item> item, String texture) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tekora.MODID,"item/" + texture));
    }
}
