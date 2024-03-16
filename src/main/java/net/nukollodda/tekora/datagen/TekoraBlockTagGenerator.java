package net.nukollodda.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TekoraBlockTagGenerator extends BlockTagsProvider {
    public TekoraBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(TekoraTags.Blocks.ALUMINUM_BLOCK).add(TekoraBlocks.ALUMINUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.ANTIMONY_BLOCK).add(TekoraBlocks.ANTIMONY_BLOCK.get());
        this.tag(TekoraTags.Blocks.ARSENIC_BLOCK).add(TekoraBlocks.ARSENIC_BLOCK.get());
        this.tag(TekoraTags.Blocks.BARIUM_BLOCK).add(TekoraBlocks.BARIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.BERYLLIUM_BLOCK).add(TekoraBlocks.BERYLLIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.BISMUTH_BLOCK).add(TekoraBlocks.BISMUTH_BLOCK.get());
        this.tag(TekoraTags.Blocks.BORON_BLOCK).add(TekoraBlocks.BORON_BLOCK.get());
        this.tag(TekoraTags.Blocks.CADMIUM_BLOCK).add(TekoraBlocks.CADMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.CALCIUM_BLOCK).add(TekoraBlocks.CALCIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.CERIUM_BLOCK).add(TekoraBlocks.CERIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.CHROMIUM_BLOCK).add(TekoraBlocks.CHROMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.COBALT_BLOCK).add(TekoraBlocks.COBALT_BLOCK.get());
        this.tag(TekoraTags.Blocks.DYSPROSIUM_BLOCK).add(TekoraBlocks.DYSPROSIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.ERBIUM_BLOCK).add(TekoraBlocks.ERBIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.EUROPIUM_BLOCK).add(TekoraBlocks.EUROPIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.GADOLINIUM_BLOCK).add(TekoraBlocks.GADOLINIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.GALLIUM_BLOCK).add(TekoraBlocks.GALLIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.GERMANIUM_BLOCK).add(TekoraBlocks.GERMANIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.HAFNIUM_BLOCK).add(TekoraBlocks.HAFNIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.HOLMIUM_BLOCK).add(TekoraBlocks.HOLMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.INDIUM_BLOCK).add(TekoraBlocks.INDIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.IRIDIUM_BLOCK).add(TekoraBlocks.IRIDIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.LANTHANUM_BLOCK).add(TekoraBlocks.LANTHANUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.LEAD_BLOCK).add(TekoraBlocks.LEAD_BLOCK.get());
        this.tag(TekoraTags.Blocks.LUTETIUM_BLOCK).add(TekoraBlocks.LUTETIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.MAGNESIUM_BLOCK).add(TekoraBlocks.MAGNESIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.MANGANESE_BLOCK).add(TekoraBlocks.MANGANESE_BLOCK.get());
        this.tag(TekoraTags.Blocks.MOLYBDENUM_BLOCK).add(TekoraBlocks.MOLYBDENUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.NEODYMIUM_BLOCK).add(TekoraBlocks.NEODYMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.NICKEL_BLOCK).add(TekoraBlocks.NICKEL_BLOCK.get());
        this.tag(TekoraTags.Blocks.NIOBIUM_BLOCK).add(TekoraBlocks.NIOBIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.OSMIUM_BLOCK).add(TekoraBlocks.OSMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.PALLADIUM_BLOCK).add(TekoraBlocks.PALLADIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.PLATINUM_BLOCK).add(TekoraBlocks.PLATINUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.PRASEODYMIUM_BLOCK).add(TekoraBlocks.PRASEODYMIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.RHENIUM_BLOCK).add(TekoraBlocks.RHENIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.RHODIUM_BLOCK).add(TekoraBlocks.RHODIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.RUTHENIUM_BLOCK).add(TekoraBlocks.RUTHENIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.SCANDIUM_BLOCK).add(TekoraBlocks.SCANDIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.SAMARIUM_BLOCK).add(TekoraBlocks.SAMARIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.STRONTIUM_BLOCK).add(TekoraBlocks.STRONTIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.SILICON_BLOCK).add(TekoraBlocks.SILICON_BLOCK.get());
        this.tag(TekoraTags.Blocks.SILVER_BLOCK).add(TekoraBlocks.SILVER_BLOCK.get());
        this.tag(TekoraTags.Blocks.TANTALUM_BLOCK).add(TekoraBlocks.TANTALUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.TELLURIUM_BLOCK).add(TekoraBlocks.TELLURIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.TERBIUM_BLOCK).add(TekoraBlocks.TERBIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.THALLIUM_BLOCK).add(TekoraBlocks.THALLIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.THORIUM_BLOCK).add(TekoraBlocks.THORIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.THULIUM_BLOCK).add(TekoraBlocks.THULIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.TIN_BLOCK).add(TekoraBlocks.TIN_BLOCK.get());
        this.tag(TekoraTags.Blocks.TITANIUM_BLOCK).add(TekoraBlocks.TITANIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.TUNGSTEN_BLOCK).add(TekoraBlocks.TUNGSTEN_BLOCK.get());
        this.tag(TekoraTags.Blocks.URANIUM_BLOCK).add(TekoraBlocks.URANIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.VANADIUM_BLOCK).add(TekoraBlocks.VANADIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.YTTERBIUM_BLOCK).add(TekoraBlocks.YTTERBIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.YTTRIUM_BLOCK).add(TekoraBlocks.YTTRIUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.ZINC_BLOCK).add(TekoraBlocks.ZINC_BLOCK.get());
        this.tag(TekoraTags.Blocks.ZIRCONIUM_BLOCK).add(TekoraBlocks.ZIRCONIUM_BLOCK.get());

        this.tag(TekoraTags.Blocks.AQUAMARINE_BLOCK).add(TekoraBlocks.AQUAMARINE_BLOCK.get());
        this.tag(TekoraTags.Blocks.BAUXITE_BLOCK).add(TekoraBlocks.BAUXITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.CHROMITE_BLOCK).add(TekoraBlocks.CHROMITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.CINNABAR_BLOCK).add(TekoraBlocks.CINNABAR_BLOCK.get());
        this.tag(TekoraTags.Blocks.COLTAN_BLOCK).add(TekoraBlocks.COLTAN_BLOCK.get());
        this.tag(TekoraTags.Blocks.DOLOMITE_BLOCK).add(TekoraBlocks.DOLOMITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.FLUORITE_BLOCK).add(TekoraBlocks.FLUORITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.HALITE_BLOCK).add(TekoraBlocks.HALITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.MONAZITE_BLOCK).add(TekoraBlocks.MONAZITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.RUBY_BLOCK).add(TekoraBlocks.RUBY_BLOCK.get());
        this.tag(TekoraTags.Blocks.RUTILE_BLOCK).add(TekoraBlocks.RUTILE_BLOCK.get());
        this.tag(TekoraTags.Blocks.SAPPHIRE_BLOCK).add(TekoraBlocks.SAPPHIRE_BLOCK.get());
        this.tag(TekoraTags.Blocks.URANINITE_BLOCK).add(TekoraBlocks.URANINITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.WOLFRAMITE_BLOCK).add(TekoraBlocks.WOLFRAMITE_BLOCK.get());
        this.tag(TekoraTags.Blocks.ZIRCON_BLOCK).add(TekoraBlocks.ZIRCON_BLOCK.get());

        this.tag(TekoraTags.Blocks.AQUAMARINE_ORE).add(
                TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),
                TekoraBlocks.AQUAMARINE_ORE.get());

        this.tag(TekoraTags.Blocks.BAUXITE_ORE).add(
                TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(),
                TekoraBlocks.BAUXITE_ORE.get());

        this.tag(TekoraTags.Blocks.TIN_ORE).add(
                TekoraBlocks.DEEPSLATE_TIN_ORE.get(),
                TekoraBlocks.TIN_ORE.get());

        this.tag(TekoraTags.Blocks.CINNABAR_ORE).add(
                TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(),
                TekoraBlocks.CINNABAR_ORE.get());

        this.tag(TekoraTags.Blocks.HALITE_ORE).add(
                TekoraBlocks.DEEPSLATE_HALITE_ORE.get(),
                TekoraBlocks.HALITE_ORE.get());

        this.tag(TekoraTags.Blocks.LEAD_ORE).add(
                TekoraBlocks.DEEPSLATE_LEAD_ORE.get(),
                TekoraBlocks.LEAD_ORE.get());

        this.tag(TekoraTags.Blocks.NICKEL_ORE).add(
                TekoraBlocks.DEEPSLATE_NICKEL_ORE.get(),
                TekoraBlocks.NICKEL_ORE.get());

        this.tag(TekoraTags.Blocks.RUBY_ORE).add(
                TekoraBlocks.DEEPSLATE_RUBY_ORE.get(),
                TekoraBlocks.RUBY_ORE.get());

        this.tag(TekoraTags.Blocks.SAPPHIRE_ORE).add(
                TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                TekoraBlocks.SAPPHIRE_ORE.get());

        this.tag(TekoraTags.Blocks.URANINITE_ORE).add(
                TekoraBlocks.DEEPSLATE_URANINITE_ORE.get(),
                TekoraBlocks.URANINITE_ORE.get());

        this.tag(TekoraTags.Blocks.WOLFRAMITE_ORE).add(
                TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(),
                TekoraBlocks.WOLFRAMITE_ORE.get());

        this.tag(TekoraTags.Blocks.ZINC_ORE).add(
                TekoraBlocks.DEEPSLATE_ZINC_ORE.get(),
                TekoraBlocks.ZINC_ORE.get());

        this.tag(TekoraTags.Blocks.ZIRCON_ORE).add(
                TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get(),
                TekoraBlocks.ZIRCON_ORE.get());

        this.tag(TekoraTags.Blocks.RAW_LEAD_BLOCK).add(TekoraBlocks.RAW_LEAD_BLOCK.get());
        this.tag(TekoraTags.Blocks.RAW_NICKEL_BLOCK).add(TekoraBlocks.RAW_NICKEL_BLOCK.get());
        this.tag(TekoraTags.Blocks.RAW_PLATINUM_BLOCK).add(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
        this.tag(TekoraTags.Blocks.RAW_SILVER_BLOCK).add(TekoraBlocks.RAW_SILVER_BLOCK.get());
        this.tag(TekoraTags.Blocks.RAW_TIN_BLOCK).add(TekoraBlocks.RAW_TIN_BLOCK.get());
        this.tag(TekoraTags.Blocks.RAW_ZINC_BLOCK).add(TekoraBlocks.RAW_ZINC_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                TekoraBlocks.COMPRESSOR.get(),
                TekoraBlocks.CUTTER.get(),
                TekoraBlocks.ELECTRIC_FURNACE.get(),
                TekoraBlocks.EXTRUDER.get(),
                TekoraBlocks.PULVERIZER.get(),
                TekoraBlocks.ALUMINUM_BLOCK.get(),
                TekoraBlocks.ANTIMONY_BLOCK.get(),
                TekoraBlocks.ARSENIC_BLOCK.get(),
                TekoraBlocks.BARIUM_BLOCK.get(),
                TekoraBlocks.BERYLLIUM_BLOCK.get(),
                TekoraBlocks.BISMUTH_BLOCK.get(),
                TekoraBlocks.BORON_BLOCK.get(),
                TekoraBlocks.CADMIUM_BLOCK.get(),
                TekoraBlocks.CALCIUM_BLOCK.get(),
                TekoraBlocks.CERIUM_BLOCK.get(),
                TekoraBlocks.CHROMIUM_BLOCK.get(),
                TekoraBlocks.COBALT_BLOCK.get(),
                TekoraBlocks.DYSPROSIUM_BLOCK.get(),
                TekoraBlocks.ERBIUM_BLOCK.get(),
                TekoraBlocks.EUROPIUM_BLOCK.get(),
                TekoraBlocks.GADOLINIUM_BLOCK.get(),
                TekoraBlocks.GALLIUM_BLOCK.get(),
                TekoraBlocks.GERMANIUM_BLOCK.get(),
                TekoraBlocks.HAFNIUM_BLOCK.get(),
                TekoraBlocks.HOLMIUM_BLOCK.get(),
                TekoraBlocks.INDIUM_BLOCK.get(),
                TekoraBlocks.IRIDIUM_BLOCK.get(),
                TekoraBlocks.LANTHANUM_BLOCK.get(),
                TekoraBlocks.LEAD_BLOCK.get(),
                TekoraBlocks.LUTETIUM_BLOCK.get(),
                TekoraBlocks.MAGNESIUM_BLOCK.get(),
                TekoraBlocks.MANGANESE_BLOCK.get(),
                TekoraBlocks.MOLYBDENUM_BLOCK.get(),
                TekoraBlocks.NEODYMIUM_BLOCK.get(),
                TekoraBlocks.NICKEL_BLOCK.get(),
                TekoraBlocks.NIOBIUM_BLOCK.get(),
                TekoraBlocks.OSMIUM_BLOCK.get(),
                TekoraBlocks.PALLADIUM_BLOCK.get(),
                TekoraBlocks.PLATINUM_BLOCK.get(),
                TekoraBlocks.PRASEODYMIUM_BLOCK.get(),
                TekoraBlocks.RHENIUM_BLOCK.get(),
                TekoraBlocks.RHODIUM_BLOCK.get(),
                TekoraBlocks.RUTHENIUM_BLOCK.get(),
                TekoraBlocks.SAMARIUM_BLOCK.get(),
                TekoraBlocks.SCANDIUM_BLOCK.get(),
                TekoraBlocks.STRONTIUM_BLOCK.get(),
                TekoraBlocks.SILICON_BLOCK.get(),
                TekoraBlocks.SILVER_BLOCK.get(),
                TekoraBlocks.TANTALUM_BLOCK.get(),
                TekoraBlocks.TELLURIUM_BLOCK.get(),
                TekoraBlocks.TERBIUM_BLOCK.get(),
                TekoraBlocks.THALLIUM_BLOCK.get(),
                TekoraBlocks.THORIUM_BLOCK.get(),
                TekoraBlocks.THULIUM_BLOCK.get(),
                TekoraBlocks.TIN_BLOCK.get(),
                TekoraBlocks.TITANIUM_BLOCK.get(),
                TekoraBlocks.TUNGSTEN_BLOCK.get(),
                TekoraBlocks.URANIUM_BLOCK.get(),
                TekoraBlocks.VANADIUM_BLOCK.get(),
                TekoraBlocks.YTTERBIUM_BLOCK.get(),
                TekoraBlocks.YTTRIUM_BLOCK.get(),
                TekoraBlocks.ZINC_BLOCK.get(),
                TekoraBlocks.ZIRCONIUM_BLOCK.get(),
                TekoraBlocks.RAW_PLATINUM_BLOCK.get(),
                TekoraBlocks.RAW_SILVER_BLOCK.get(),
                TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),
                TekoraBlocks.AQUAMARINE_ORE.get(),
                TekoraBlocks.DEEPSLATE_RUBY_ORE.get(),
                TekoraBlocks.RUBY_ORE.get(),
                TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                TekoraBlocks.SAPPHIRE_ORE.get(),
                TekoraBlocks.DEEPSLATE_URANINITE_ORE.get(),
                TekoraBlocks.URANINITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(),
                TekoraBlocks.WOLFRAMITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get(),
                TekoraBlocks.ZIRCON_ORE.get(),
                TekoraBlocks.AQUAMARINE_BLOCK.get(),
                TekoraBlocks.CHROMITE_BLOCK.get(),
                TekoraBlocks.COLTAN_BLOCK.get(),
                TekoraBlocks.MONAZITE_BLOCK.get(),
                TekoraBlocks.RUBY_BLOCK.get(),
                TekoraBlocks.RUTILE_BLOCK.get(),
                TekoraBlocks.SAPPHIRE_BLOCK.get(),
                TekoraBlocks.URANINITE_BLOCK.get(),
                TekoraBlocks.WOLFRAMITE_BLOCK.get(),
                TekoraBlocks.ZIRCON_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                TekoraBlocks.INFUSION_FURNACE.get(),
                TekoraBlocks.ALLOY_FURNACE.get(),
                TekoraBlocks.EVAPORITE.get(),
                TekoraBlocks.LIMESTONE.get(),
                TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(),
                TekoraBlocks.BAUXITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(),
                TekoraBlocks.CINNABAR_ORE.get(),
                TekoraBlocks.DEEPSLATE_HALITE_ORE.get(),
                TekoraBlocks.HALITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_NICKEL_ORE.get(),
                TekoraBlocks.NICKEL_ORE.get(),
                TekoraBlocks.DEEPSLATE_LEAD_ORE.get(),
                TekoraBlocks.LEAD_ORE.get(),
                TekoraBlocks.DEEPSLATE_TIN_ORE.get(),
                TekoraBlocks.TIN_ORE.get(),
                TekoraBlocks.DEEPSLATE_ZINC_ORE.get(),
                TekoraBlocks.ZINC_ORE.get(),
                TekoraBlocks.RAW_LEAD_BLOCK.get(),
                TekoraBlocks.RAW_NICKEL_BLOCK.get(),
                TekoraBlocks.RAW_TIN_BLOCK.get(),
                TekoraBlocks.RAW_ZINC_BLOCK.get(),
                TekoraBlocks.BAUXITE_BLOCK.get(),
                TekoraBlocks.CINNABAR_BLOCK.get(),
                TekoraBlocks.DOLOMITE_BLOCK.get(),
                TekoraBlocks.FLUORITE_BLOCK.get(),
                TekoraBlocks.HALITE_BLOCK.get());


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TekoraBlocks.COMPRESSOR.get(),
                TekoraBlocks.CUTTER.get(),
                TekoraBlocks.ELECTRIC_FURNACE.get(),
                TekoraBlocks.EXTRUDER.get(),
                TekoraBlocks.INFUSION_FURNACE.get(),
                TekoraBlocks.ALLOY_FURNACE.get(),
                TekoraBlocks.PULVERIZER.get(),
                TekoraBlocks.EVAPORITE.get(),
                TekoraBlocks.LIMESTONE.get(),
                TekoraBlocks.ALUMINUM_BLOCK.get(),
                TekoraBlocks.ANTIMONY_BLOCK.get(),
                TekoraBlocks.ARSENIC_BLOCK.get(),
                TekoraBlocks.BARIUM_BLOCK.get(),
                TekoraBlocks.BERYLLIUM_BLOCK.get(),
                TekoraBlocks.BISMUTH_BLOCK.get(),
                TekoraBlocks.BORON_BLOCK.get(),
                TekoraBlocks.CADMIUM_BLOCK.get(),
                TekoraBlocks.CALCIUM_BLOCK.get(),
                TekoraBlocks.CERIUM_BLOCK.get(),
                TekoraBlocks.CHROMIUM_BLOCK.get(),
                TekoraBlocks.COBALT_BLOCK.get(),
                TekoraBlocks.DYSPROSIUM_BLOCK.get(),
                TekoraBlocks.ERBIUM_BLOCK.get(),
                TekoraBlocks.EUROPIUM_BLOCK.get(),
                TekoraBlocks.GADOLINIUM_BLOCK.get(),
                TekoraBlocks.GALLIUM_BLOCK.get(),
                TekoraBlocks.GERMANIUM_BLOCK.get(),
                TekoraBlocks.HAFNIUM_BLOCK.get(),
                TekoraBlocks.HOLMIUM_BLOCK.get(),
                TekoraBlocks.INDIUM_BLOCK.get(),
                TekoraBlocks.IRIDIUM_BLOCK.get(),
                TekoraBlocks.LANTHANUM_BLOCK.get(),
                TekoraBlocks.LEAD_BLOCK.get(),
                TekoraBlocks.LUTETIUM_BLOCK.get(),
                TekoraBlocks.MAGNESIUM_BLOCK.get(),
                TekoraBlocks.MANGANESE_BLOCK.get(),
                TekoraBlocks.MOLYBDENUM_BLOCK.get(),
                TekoraBlocks.NEODYMIUM_BLOCK.get(),
                TekoraBlocks.NICKEL_BLOCK.get(),
                TekoraBlocks.NIOBIUM_BLOCK.get(),
                TekoraBlocks.OSMIUM_BLOCK.get(),
                TekoraBlocks.PALLADIUM_BLOCK.get(),
                TekoraBlocks.PLATINUM_BLOCK.get(),
                TekoraBlocks.PRASEODYMIUM_BLOCK.get(),
                TekoraBlocks.RHENIUM_BLOCK.get(),
                TekoraBlocks.RHODIUM_BLOCK.get(),
                TekoraBlocks.RUTHENIUM_BLOCK.get(),
                TekoraBlocks.SAMARIUM_BLOCK.get(),
                TekoraBlocks.SCANDIUM_BLOCK.get(),
                TekoraBlocks.STRONTIUM_BLOCK.get(),
                TekoraBlocks.SILICON_BLOCK.get(),
                TekoraBlocks.SILVER_BLOCK.get(),
                TekoraBlocks.TANTALUM_BLOCK.get(),
                TekoraBlocks.TELLURIUM_BLOCK.get(),
                TekoraBlocks.TERBIUM_BLOCK.get(),
                TekoraBlocks.THALLIUM_BLOCK.get(),
                TekoraBlocks.THORIUM_BLOCK.get(),
                TekoraBlocks.THULIUM_BLOCK.get(),
                TekoraBlocks.TIN_BLOCK.get(),
                TekoraBlocks.TITANIUM_BLOCK.get(),
                TekoraBlocks.TUNGSTEN_BLOCK.get(),
                TekoraBlocks.URANIUM_BLOCK.get(),
                TekoraBlocks.VANADIUM_BLOCK.get(),
                TekoraBlocks.YTTERBIUM_BLOCK.get(),
                TekoraBlocks.YTTRIUM_BLOCK.get(),
                TekoraBlocks.ZINC_BLOCK.get(),
                TekoraBlocks.ZIRCONIUM_BLOCK.get(),
                TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),
                TekoraBlocks.AQUAMARINE_ORE.get(),
                TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(),
                TekoraBlocks.BAUXITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_TIN_ORE.get(),
                TekoraBlocks.TIN_ORE.get(),
                TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(),
                TekoraBlocks.CINNABAR_ORE.get(),
                TekoraBlocks.DEEPSLATE_HALITE_ORE.get(),
                TekoraBlocks.HALITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_LEAD_ORE.get(),
                TekoraBlocks.LEAD_ORE.get(),
                TekoraBlocks.DEEPSLATE_NICKEL_ORE.get(),
                TekoraBlocks.NICKEL_ORE.get(),
                TekoraBlocks.DEEPSLATE_RUBY_ORE.get(),
                TekoraBlocks.RUBY_ORE.get(),
                TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                TekoraBlocks.SAPPHIRE_ORE.get(),
                TekoraBlocks.DEEPSLATE_URANINITE_ORE.get(),
                TekoraBlocks.URANINITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(),
                TekoraBlocks.WOLFRAMITE_ORE.get(),
                TekoraBlocks.DEEPSLATE_ZINC_ORE.get(),
                TekoraBlocks.ZINC_ORE.get(),
                TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get(),
                TekoraBlocks.RAW_LEAD_BLOCK.get(),
                TekoraBlocks.RAW_NICKEL_BLOCK.get(),
                TekoraBlocks.RAW_PLATINUM_BLOCK.get(),
                TekoraBlocks.RAW_SILVER_BLOCK.get(),
                TekoraBlocks.RAW_TIN_BLOCK.get(),
                TekoraBlocks.RAW_ZINC_BLOCK.get(),
                TekoraBlocks.ZIRCON_ORE.get(),
                TekoraBlocks.AQUAMARINE_BLOCK.get(),
                TekoraBlocks.BAUXITE_BLOCK.get(),
                TekoraBlocks.CHROMITE_BLOCK.get(),
                TekoraBlocks.CINNABAR_BLOCK.get(),
                TekoraBlocks.COLTAN_BLOCK.get(),
                TekoraBlocks.DOLOMITE_BLOCK.get(),
                TekoraBlocks.FLUORITE_BLOCK.get(),
                TekoraBlocks.HALITE_BLOCK.get(),
                TekoraBlocks.MONAZITE_BLOCK.get(),
                TekoraBlocks.RUBY_BLOCK.get(),
                TekoraBlocks.RUTILE_BLOCK.get(),
                TekoraBlocks.SAPPHIRE_BLOCK.get(),
                TekoraBlocks.URANINITE_BLOCK.get(),
                TekoraBlocks.WOLFRAMITE_BLOCK.get(),
                TekoraBlocks.ZIRCON_BLOCK.get());

        this.tag(TekoraTags.Blocks.MINEABLE_WITH_DRILL).addTags(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL);
    }
}
