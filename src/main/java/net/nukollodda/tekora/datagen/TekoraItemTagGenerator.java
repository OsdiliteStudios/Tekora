package net.nukollodda.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import net.nukollodda.tekora.item.TekoraItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TekoraItemTagGenerator extends ItemTagsProvider {
    public TekoraItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                                  CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(TekoraTags.Items.ALUMINUM_INGOT).add(TekoraItems.ALUMINUM_INGOT.get());
        this.tag(TekoraTags.Items.BARIUM_INGOT).add(TekoraItems.BARIUM_INGOT.get());
        this.tag(TekoraTags.Items.BERYLLIUM_INGOT).add(TekoraItems.BERYLLIUM_INGOT.get());
        this.tag(TekoraTags.Items.BISMUTH_INGOT).add(TekoraItems.BISMUTH_INGOT.get());
        this.tag(TekoraTags.Items.CADMIUM_INGOT).add(TekoraItems.CADMIUM_INGOT.get());
        this.tag(TekoraTags.Items.CALCIUM_INGOT).add(TekoraItems.CALCIUM_INGOT.get());
        this.tag(TekoraTags.Items.CERIUM_INGOT).add(TekoraItems.CERIUM_INGOT.get());
        this.tag(TekoraTags.Items.CHROMIUM_INGOT).add(TekoraItems.CHROMIUM_INGOT.get());
        this.tag(TekoraTags.Items.CESIUM_INGOT).add(TekoraItems.CESIUM_INGOT.get());
        this.tag(TekoraTags.Items.COBALT_INGOT).add(TekoraItems.COBALT_INGOT.get());
        this.tag(TekoraTags.Items.DYSPROSIUM_INGOT).add(TekoraItems.DYSPROSIUM_INGOT.get());
        this.tag(TekoraTags.Items.ERBIUM_INGOT).add(TekoraItems.ERBIUM_INGOT.get());
        this.tag(TekoraTags.Items.EUROPIUM_INGOT).add(TekoraItems.EUROPIUM_INGOT.get());
        this.tag(TekoraTags.Items.GADOLINIUM_INGOT).add(TekoraItems.GADOLINIUM_INGOT.get());
        this.tag(TekoraTags.Items.GALLIUM_INGOT).add(TekoraItems.GALLIUM_INGOT.get());
        this.tag(TekoraTags.Items.HAFNIUM_INGOT).add(TekoraItems.HAFNIUM_INGOT.get());
        this.tag(TekoraTags.Items.HOLMIUM_INGOT).add(TekoraItems.HOLMIUM_INGOT.get());
        this.tag(TekoraTags.Items.INDIUM_INGOT).add(TekoraItems.INDIUM_INGOT.get());
        this.tag(TekoraTags.Items.IRIDIUM_INGOT).add(TekoraItems.IRIDIUM_INGOT.get());
        this.tag(TekoraTags.Items.LANTHANUM_INGOT).add(TekoraItems.LANTHANUM_INGOT.get());
        this.tag(TekoraTags.Items.LEAD_INGOT).add(TekoraItems.LEAD_INGOT.get());
        this.tag(TekoraTags.Items.LITHIUM_INGOT).add(TekoraItems.LITHIUM_INGOT.get());
        this.tag(TekoraTags.Items.LUTETIUM_INGOT).add(TekoraItems.LUTETIUM_INGOT.get());
        this.tag(TekoraTags.Items.MAGNESIUM_INGOT).add(TekoraItems.MAGNESIUM_INGOT.get());
        this.tag(TekoraTags.Items.MANGANESE_INGOT).add(TekoraItems.MANGANESE_INGOT.get());
        this.tag(TekoraTags.Items.MOLYBDENUM_INGOT).add(TekoraItems.MOLYBDENUM_INGOT.get());
        this.tag(TekoraTags.Items.NEODYMIUM_INGOT).add(TekoraItems.NEODYMIUM_INGOT.get());
        this.tag(TekoraTags.Items.NICKEL_INGOT).add(TekoraItems.NICKEL_INGOT.get());
        this.tag(TekoraTags.Items.NIOBIUM_INGOT).add(TekoraItems.NIOBIUM_INGOT.get());
        this.tag(TekoraTags.Items.OSMIUM_INGOT).add(TekoraItems.OSMIUM_INGOT.get());
        this.tag(TekoraTags.Items.PALLADIUM_INGOT).add(TekoraItems.PALLADIUM_INGOT.get());
        this.tag(TekoraTags.Items.PLATINUM_INGOT).add(TekoraItems.PLATINUM_INGOT.get());
        this.tag(TekoraTags.Items.POTASSIUM_INGOT).add(TekoraItems.POTASSIUM_INGOT.get());
        this.tag(TekoraTags.Items.PRASEODYMIUM_INGOT).add(TekoraItems.PRASEODYMIUM_INGOT.get());
        this.tag(TekoraTags.Items.RHENIUM_INGOT).add(TekoraItems.RHENIUM_INGOT.get());
        this.tag(TekoraTags.Items.RHODIUM_INGOT).add(TekoraItems.RHODIUM_INGOT.get());
        this.tag(TekoraTags.Items.RUBIDIUM_INGOT).add(TekoraItems.RUBIDIUM_INGOT.get());
        this.tag(TekoraTags.Items.RUTHENIUM_INGOT).add(TekoraItems.RUTHENIUM_INGOT.get());
        this.tag(TekoraTags.Items.SCANDIUM_INGOT).add(TekoraItems.SCANDIUM_INGOT.get());
        this.tag(TekoraTags.Items.SAMARIUM_INGOT).add(TekoraItems.SAMARIUM_INGOT.get());
        this.tag(TekoraTags.Items.SODIUM_INGOT).add(TekoraItems.SODIUM_INGOT.get());
        this.tag(TekoraTags.Items.STRONTIUM_INGOT).add(TekoraItems.STRONTIUM_INGOT.get());
        this.tag(TekoraTags.Items.SILVER_INGOT).add(TekoraItems.SILVER_INGOT.get());
        this.tag(TekoraTags.Items.TANTALUM_INGOT).add(TekoraItems.TANTALUM_INGOT.get());
        this.tag(TekoraTags.Items.TERBIUM_INGOT).add(TekoraItems.TERBIUM_INGOT.get());
        this.tag(TekoraTags.Items.THALLIUM_INGOT).add(TekoraItems.THALLIUM_INGOT.get());
        this.tag(TekoraTags.Items.THORIUM_INGOT).add(TekoraItems.THORIUM_INGOT.get());
        this.tag(TekoraTags.Items.THULIUM_INGOT).add(TekoraItems.THULIUM_INGOT.get());
        this.tag(TekoraTags.Items.TIN_INGOT).add(TekoraItems.TIN_INGOT.get());
        this.tag(TekoraTags.Items.TITANIUM_INGOT).add(TekoraItems.TITANIUM_INGOT.get());
        this.tag(TekoraTags.Items.TUNGSTEN_INGOT).add(TekoraItems.TUNGSTEN_INGOT.get());
        this.tag(TekoraTags.Items.URANIUM_INGOT).add(TekoraItems.URANIUM_INGOT.get());
        this.tag(TekoraTags.Items.VANADIUM_INGOT).add(TekoraItems.VANADIUM_INGOT.get());
        this.tag(TekoraTags.Items.YTTERBIUM_INGOT).add(TekoraItems.YTTERBIUM_INGOT.get());
        this.tag(TekoraTags.Items.YTTRIUM_INGOT).add(TekoraItems.YTTRIUM_INGOT.get());
        this.tag(TekoraTags.Items.ZINC_INGOT).add(TekoraItems.ZINC_INGOT.get());
        this.tag(TekoraTags.Items.ZIRCONIUM_INGOT).add(TekoraItems.ZIRCONIUM_INGOT.get());
        this.tag(TekoraTags.Items.BRASS_INGOT).add(TekoraItems.BRASS_INGOT.get());
        this.tag(TekoraTags.Items.BRONZE_INGOT).add(TekoraItems.BRONZE_INGOT.get());
        this.tag(TekoraTags.Items.CARBON_STEEL_INGOT).add(TekoraItems.CARBON_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.CHROMOLY_STEEL_INGOT).add(TekoraItems.CHROMOLY_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_INGOT).add(TekoraItems.CUPRONICKEL_INGOT.get());
        this.tag(TekoraTags.Items.ELECTRUM_INGOT).add(TekoraItems.ELECTRUM_INGOT.get());
        this.tag(TekoraTags.Items.FERROBORON_INGOT).add(TekoraItems.FERROBORON_INGOT.get());
        this.tag(TekoraTags.Items.GALVANIZED_STEEL_INGOT).add(TekoraItems.GALVANIZED_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.HSLA_STEEL_INGOT).add(TekoraItems.HSLA_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.INCONEL_INGOT).add(TekoraItems.INCONEL_INGOT.get());
        this.tag(TekoraTags.Items.INVAR_INGOT).add(TekoraItems.INVAR_INGOT.get());
        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT).add(TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get());
        this.tag(TekoraTags.Items.MU_METAL_INGOT).add(TekoraItems.MU_METAL_INGOT.get());
        this.tag(TekoraTags.Items.REACTOR_STEEL_INGOT).add(TekoraItems.REACTOR_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.STAINLESS_STEEL_INGOT).add(TekoraItems.STAINLESS_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.STEEL_INGOT).add(TekoraItems.STEEL_INGOT.get());
        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT).add(TekoraItems.TUNGSTEN_CARBIDE_INGOT.get());
        this.tag(TekoraTags.Items.TUNGSTEN_STEEL_INGOT).add(TekoraItems.TUNGSTEN_STEEL_INGOT.get());
        this.tag(TekoraTags.Items.VANASTEEL_INGOT).add(TekoraItems.VANASTEEL_INGOT.get());
        this.tag(TekoraTags.Items.ZIRCALOY_INGOT).add(TekoraItems.ZIRCALOY_INGOT.get());

        this.tag(TekoraTags.Items.ALUMINUM_NUGGET).add(TekoraItems.ALUMINUM_NUGGET.get());
        this.tag(TekoraTags.Items.BARIUM_NUGGET).add(TekoraItems.BARIUM_NUGGET.get());
        this.tag(TekoraTags.Items.BERYLLIUM_NUGGET).add(TekoraItems.BERYLLIUM_NUGGET.get());
        this.tag(TekoraTags.Items.BISMUTH_NUGGET).add(TekoraItems.BISMUTH_NUGGET.get());
        this.tag(TekoraTags.Items.CADMIUM_NUGGET).add(TekoraItems.CADMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.CALCIUM_NUGGET).add(TekoraItems.CALCIUM_NUGGET.get());
        this.tag(TekoraTags.Items.CERIUM_NUGGET).add(TekoraItems.CERIUM_NUGGET.get());
        this.tag(TekoraTags.Items.CESIUM_NUGGET).add(TekoraItems.CESIUM_NUGGET.get());
        this.tag(TekoraTags.Items.CHROMIUM_NUGGET).add(TekoraItems.CHROMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.COBALT_NUGGET).add(TekoraItems.COBALT_NUGGET.get());
        this.tag(TekoraTags.Items.COPPER_NUGGET).add(TekoraItems.COPPER_NUGGET.get());
        this.tag(TekoraTags.Items.DYSPROSIUM_NUGGET).add(TekoraItems.DYSPROSIUM_NUGGET.get());
        this.tag(TekoraTags.Items.ERBIUM_NUGGET).add(TekoraItems.ERBIUM_NUGGET.get());
        this.tag(TekoraTags.Items.EUROPIUM_NUGGET).add(TekoraItems.EUROPIUM_NUGGET.get());
        this.tag(TekoraTags.Items.GADOLINIUM_NUGGET).add(TekoraItems.GADOLINIUM_NUGGET.get());
        this.tag(TekoraTags.Items.GALLIUM_NUGGET).add(TekoraItems.GALLIUM_NUGGET.get());
        this.tag(TekoraTags.Items.HAFNIUM_NUGGET).add(TekoraItems.HAFNIUM_NUGGET.get());
        this.tag(TekoraTags.Items.HOLMIUM_NUGGET).add(TekoraItems.HOLMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.INDIUM_NUGGET).add(TekoraItems.INDIUM_NUGGET.get());
        this.tag(TekoraTags.Items.IRIDIUM_NUGGET).add(TekoraItems.IRIDIUM_NUGGET.get());
        this.tag(TekoraTags.Items.LANTHANUM_NUGGET).add(TekoraItems.LANTHANUM_NUGGET.get());
        this.tag(TekoraTags.Items.LEAD_NUGGET).add(TekoraItems.LEAD_NUGGET.get());
        this.tag(TekoraTags.Items.LITHIUM_NUGGET).add(TekoraItems.LITHIUM_NUGGET.get());
        this.tag(TekoraTags.Items.LUTETIUM_NUGGET).add(TekoraItems.LUTETIUM_NUGGET.get());
        this.tag(TekoraTags.Items.MAGNESIUM_NUGGET).add(TekoraItems.MAGNESIUM_NUGGET.get());
        this.tag(TekoraTags.Items.MANGANESE_NUGGET).add(TekoraItems.MANGANESE_NUGGET.get());
        this.tag(TekoraTags.Items.MOLYBDENUM_NUGGET).add(TekoraItems.MOLYBDENUM_NUGGET.get());
        this.tag(TekoraTags.Items.NEODYMIUM_NUGGET).add(TekoraItems.NEODYMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.NICKEL_NUGGET).add(TekoraItems.NICKEL_NUGGET.get());
        this.tag(TekoraTags.Items.NIOBIUM_NUGGET).add(TekoraItems.NIOBIUM_NUGGET.get());
        this.tag(TekoraTags.Items.OSMIUM_NUGGET).add(TekoraItems.OSMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.PALLADIUM_NUGGET).add(TekoraItems.PALLADIUM_NUGGET.get());
        this.tag(TekoraTags.Items.PLATINUM_NUGGET).add(TekoraItems.PLATINUM_NUGGET.get());
        this.tag(TekoraTags.Items.POTASSIUM_NUGGET).add(TekoraItems.POTASSIUM_NUGGET.get());
        this.tag(TekoraTags.Items.PRASEODYMIUM_NUGGET).add(TekoraItems.PRASEODYMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.RHENIUM_NUGGET).add(TekoraItems.RHENIUM_NUGGET.get());
        this.tag(TekoraTags.Items.RHODIUM_NUGGET).add(TekoraItems.RHODIUM_NUGGET.get());
        this.tag(TekoraTags.Items.RUBIDIUM_NUGGET).add(TekoraItems.RUBIDIUM_NUGGET.get());
        this.tag(TekoraTags.Items.RUTHENIUM_NUGGET).add(TekoraItems.RUTHENIUM_NUGGET.get());
        this.tag(TekoraTags.Items.SCANDIUM_NUGGET).add(TekoraItems.SCANDIUM_NUGGET.get());
        this.tag(TekoraTags.Items.SAMARIUM_NUGGET).add(TekoraItems.SAMARIUM_NUGGET.get());
        this.tag(TekoraTags.Items.STRONTIUM_NUGGET).add(TekoraItems.STRONTIUM_NUGGET.get());
        this.tag(TekoraTags.Items.SILVER_NUGGET).add(TekoraItems.SILVER_NUGGET.get());
        this.tag(TekoraTags.Items.SODIUM_NUGGET).add(TekoraItems.SODIUM_NUGGET.get());
        this.tag(TekoraTags.Items.TANTALUM_NUGGET).add(TekoraItems.TANTALUM_NUGGET.get());
        this.tag(TekoraTags.Items.TERBIUM_NUGGET).add(TekoraItems.TERBIUM_NUGGET.get());
        this.tag(TekoraTags.Items.THALLIUM_NUGGET).add(TekoraItems.THALLIUM_NUGGET.get());
        this.tag(TekoraTags.Items.THORIUM_NUGGET).add(TekoraItems.THORIUM_NUGGET.get());
        this.tag(TekoraTags.Items.THULIUM_NUGGET).add(TekoraItems.THULIUM_NUGGET.get());
        this.tag(TekoraTags.Items.TIN_NUGGET).add(TekoraItems.TIN_NUGGET.get());
        this.tag(TekoraTags.Items.TITANIUM_NUGGET).add(TekoraItems.TITANIUM_NUGGET.get());
        this.tag(TekoraTags.Items.TUNGSTEN_NUGGET).add(TekoraItems.TUNGSTEN_NUGGET.get());
        this.tag(TekoraTags.Items.URANIUM_NUGGET).add(TekoraItems.URANIUM_NUGGET.get());
        this.tag(TekoraTags.Items.VANADIUM_NUGGET).add(TekoraItems.VANADIUM_NUGGET.get());
        this.tag(TekoraTags.Items.YTTERBIUM_NUGGET).add(TekoraItems.YTTERBIUM_NUGGET.get());
        this.tag(TekoraTags.Items.YTTRIUM_NUGGET).add(TekoraItems.YTTRIUM_NUGGET.get());
        this.tag(TekoraTags.Items.ZINC_NUGGET).add(TekoraItems.ZINC_NUGGET.get());
        this.tag(TekoraTags.Items.ZIRCONIUM_NUGGET).add(TekoraItems.ZIRCONIUM_NUGGET.get());
        this.tag(TekoraTags.Items.BRASS_NUGGET).add(TekoraItems.BRASS_NUGGET.get());
        this.tag(TekoraTags.Items.BRONZE_NUGGET).add(TekoraItems.BRONZE_NUGGET.get());
        this.tag(TekoraTags.Items.CARBON_STEEL_NUGGET).add(TekoraItems.CARBON_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.CHROMOLY_STEEL_NUGGET).add(TekoraItems.CHROMOLY_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_NUGGET).add(TekoraItems.CUPRONICKEL_NUGGET.get());
        this.tag(TekoraTags.Items.ELECTRUM_NUGGET).add(TekoraItems.ELECTRUM_NUGGET.get());
        this.tag(TekoraTags.Items.FERROBORON_NUGGET).add(TekoraItems.FERROBORON_NUGGET.get());
        this.tag(TekoraTags.Items.HSLA_STEEL_NUGGET).add(TekoraItems.HSLA_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.INCONEL_NUGGET).add(TekoraItems.INCONEL_NUGGET.get());
        this.tag(TekoraTags.Items.INVAR_NUGGET).add(TekoraItems.INVAR_NUGGET.get());
        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM_NUGGET).add(TekoraItems.MAGNETIC_NEODYMIUM_NUGGET.get());
        this.tag(TekoraTags.Items.MU_METAL_NUGGET).add(TekoraItems.MU_METAL_NUGGET.get());
        this.tag(TekoraTags.Items.REACTOR_STEEL_NUGGET).add(TekoraItems.REACTOR_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.STAINLESS_STEEL_NUGGET).add(TekoraItems.STAINLESS_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.STEEL_NUGGET).add(TekoraItems.STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE_NUGGET).add(TekoraItems.TUNGSTEN_CARBIDE_NUGGET.get());
        this.tag(TekoraTags.Items.TUNGSTEN_STEEL_NUGGET).add(TekoraItems.TUNGSTEN_STEEL_NUGGET.get());
        this.tag(TekoraTags.Items.VANASTEEL_NUGGET).add(TekoraItems.VANASTEEL_NUGGET.get());
        this.tag(TekoraTags.Items.ZIRCALOY_NUGGET).add(TekoraItems.ZIRCALOY_NUGGET.get());

        this.tag(TekoraTags.Items.ALUMINUM_PLATE).add(TekoraItems.ALUMINUM_PLATE.get());
        this.tag(TekoraTags.Items.BISMUTH_PLATE).add(TekoraItems.BISMUTH_PLATE.get());
        this.tag(TekoraTags.Items.CADMIUM_PLATE).add(TekoraItems.CADMIUM_PLATE.get());
        this.tag(TekoraTags.Items.CHROMIUM_PLATE).add(TekoraItems.CHROMIUM_PLATE.get());
        this.tag(TekoraTags.Items.COBALT_PLATE).add(TekoraItems.COBALT_PLATE.get());
        this.tag(TekoraTags.Items.COPPER_PLATE).add(TekoraItems.COPPER_PLATE.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_PLATE).add(TekoraItems.CUPRONICKEL_PLATE.get());
        this.tag(TekoraTags.Items.ELECTRUM_PLATE).add(TekoraItems.ELECTRUM_PLATE.get());
        this.tag(TekoraTags.Items.GOLD_PLATE).add(TekoraItems.GOLD_PLATE.get());
        this.tag(TekoraTags.Items.INDIUM_PLATE).add(TekoraItems.INDIUM_PLATE.get());
        this.tag(TekoraTags.Items.IRIDIUM_PLATE).add(TekoraItems.IRIDIUM_PLATE.get());
        this.tag(TekoraTags.Items.IRON_PLATE).add(TekoraItems.IRON_PLATE.get());
        this.tag(TekoraTags.Items.LEAD_PLATE).add(TekoraItems.LEAD_PLATE.get());
        this.tag(TekoraTags.Items.MAGNESIUM_PLATE).add(TekoraItems.MAGNESIUM_PLATE.get());
        this.tag(TekoraTags.Items.MANGANESE_PLATE).add(TekoraItems.MANGANESE_PLATE.get());
        this.tag(TekoraTags.Items.MOLYBDENUM_PLATE).add(TekoraItems.MOLYBDENUM_PLATE.get());
        this.tag(TekoraTags.Items.NICKEL_PLATE).add(TekoraItems.NICKEL_PLATE.get());
        this.tag(TekoraTags.Items.NIOBIUM_PLATE).add(TekoraItems.NIOBIUM_PLATE.get());
        this.tag(TekoraTags.Items.OSMIUM_PLATE).add(TekoraItems.OSMIUM_PLATE.get());
        this.tag(TekoraTags.Items.PALLADIUM_PLATE).add(TekoraItems.PALLADIUM_PLATE.get());
        this.tag(TekoraTags.Items.PLATINUM_PLATE).add(TekoraItems.PLATINUM_PLATE.get());
        this.tag(TekoraTags.Items.RHODIUM_PLATE).add(TekoraItems.RHODIUM_PLATE.get());
        this.tag(TekoraTags.Items.SCANDIUM_PLATE).add(TekoraItems.SCANDIUM_PLATE.get());;
        this.tag(TekoraTags.Items.SILVER_PLATE).add(TekoraItems.SILVER_PLATE.get());
        this.tag(TekoraTags.Items.THORIUM_PLATE).add(TekoraItems.THORIUM_PLATE.get());
        this.tag(TekoraTags.Items.THULIUM_PLATE).add(TekoraItems.THULIUM_PLATE.get());
        this.tag(TekoraTags.Items.TIN_PLATE).add(TekoraItems.TIN_PLATE.get());
        this.tag(TekoraTags.Items.TITANIUM_PLATE).add(TekoraItems.TITANIUM_PLATE.get());
        this.tag(TekoraTags.Items.TUNGSTEN_PLATE).add(TekoraItems.TUNGSTEN_PLATE.get());
        this.tag(TekoraTags.Items.YTTERBIUM_PLATE).add(TekoraItems.YTTERBIUM_PLATE.get());
        this.tag(TekoraTags.Items.ZINC_PLATE).add(TekoraItems.ZINC_PLATE.get());
        this.tag(TekoraTags.Items.ZIRCONIUM_PLATE).add(TekoraItems.ZIRCONIUM_PLATE.get());
        this.tag(TekoraTags.Items.BRASS_PLATE).add(TekoraItems.BRASS_PLATE.get());
        this.tag(TekoraTags.Items.BRONZE_PLATE).add(TekoraItems.BRONZE_PLATE.get());
        this.tag(TekoraTags.Items.CHROMOLY_STEEL_PLATE).add(TekoraItems.CHROMOLY_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.COPPER_STEEL_PLATE).add(TekoraItems.COPPER_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.FERROBORON_PLATE).add(TekoraItems.FERROBORON_PLATE.get());
        this.tag(TekoraTags.Items.GALVANIZED_STEEL_PLATE).add(TekoraItems.GALVANIZED_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.HSLA_STEEL_PLATE).add(TekoraItems.HSLA_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.INCONEL_PLATE).add(TekoraItems.INCONEL_PLATE.get());
        this.tag(TekoraTags.Items.INVAR_PLATE).add(TekoraItems.INVAR_PLATE.get());
        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM_PLATE).add(TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get());
        this.tag(TekoraTags.Items.MU_METAL_PLATE).add(TekoraItems.MU_METAL_PLATE.get());
        this.tag(TekoraTags.Items.REACTOR_STEEL_PLATE).add(TekoraItems.REACTOR_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.STAINLESS_STEEL_PLATE).add(TekoraItems.STAINLESS_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.STEEL_PLATE).add(TekoraItems.STEEL_PLATE.get());
        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE_PLATE).add(TekoraItems.TUNGSTEN_CARBIDE_PLATE.get());
        this.tag(TekoraTags.Items.TUNGSTEN_STEEL_PLATE).add(TekoraItems.TUNGSTEN_STEEL_PLATE.get());
        this.tag(TekoraTags.Items.VANASTEEL_PLATE).add(TekoraItems.VANASTEEL_PLATE.get());
        this.tag(TekoraTags.Items.ZIRCALOY_PLATE).add(TekoraItems.ZIRCALOY_PLATE.get());

        this.tag(TekoraTags.Items.ALUMINUM_DUST).add(TekoraItems.ALUMINUM_DUST.get());
        this.tag(TekoraTags.Items.BARIUM_DUST).add(TekoraItems.BARIUM_DUST.get());
        this.tag(TekoraTags.Items.BERYLLIUM_DUST).add(TekoraItems.BERYLLIUM_DUST.get());
        this.tag(TekoraTags.Items.BISMUTH_DUST).add(TekoraItems.BISMUTH_DUST.get());
        this.tag(TekoraTags.Items.CADMIUM_DUST).add(TekoraItems.CADMIUM_DUST.get());
        this.tag(TekoraTags.Items.CALCIUM_DUST).add(TekoraItems.CALCIUM_DUST.get());
        this.tag(TekoraTags.Items.CERIUM_DUST).add(TekoraItems.CERIUM_DUST.get());
        this.tag(TekoraTags.Items.CESIUM_DUST).add(TekoraItems.CESIUM_DUST.get());
        this.tag(TekoraTags.Items.CHROMIUM_DUST).add(TekoraItems.CHROMIUM_DUST.get());
        this.tag(TekoraTags.Items.COBALT_DUST).add(TekoraItems.COBALT_DUST.get());
        this.tag(TekoraTags.Items.COPPER_DUST).add(TekoraItems.COPPER_DUST.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_DUST).add(TekoraItems.CUPRONICKEL_DUST.get());
        this.tag(TekoraTags.Items.ELECTRUM_DUST).add(TekoraItems.ELECTRUM_DUST.get());
        this.tag(TekoraTags.Items.GOLD_DUST).add(TekoraItems.GOLD_DUST.get());
        this.tag(TekoraTags.Items.DYSPROSIUM_DUST).add(TekoraItems.DYSPROSIUM_DUST.get());
        this.tag(TekoraTags.Items.ERBIUM_DUST).add(TekoraItems.ERBIUM_DUST.get());
        this.tag(TekoraTags.Items.EUROPIUM_DUST).add(TekoraItems.EUROPIUM_DUST.get());
        this.tag(TekoraTags.Items.GADOLINIUM_DUST).add(TekoraItems.GADOLINIUM_DUST.get());
        this.tag(TekoraTags.Items.GALLIUM_DUST).add(TekoraItems.GALLIUM_DUST.get());
        this.tag(TekoraTags.Items.HAFNIUM_DUST).add(TekoraItems.HAFNIUM_DUST.get());
        this.tag(TekoraTags.Items.HOLMIUM_DUST).add(TekoraItems.HOLMIUM_DUST.get());
        this.tag(TekoraTags.Items.INDIUM_DUST).add(TekoraItems.INDIUM_DUST.get());
        this.tag(TekoraTags.Items.IRIDIUM_DUST).add(TekoraItems.IRIDIUM_DUST.get());
        this.tag(TekoraTags.Items.IRON_DUST).add(TekoraItems.IRON_DUST.get());
        this.tag(TekoraTags.Items.LANTHANUM_DUST).add(TekoraItems.LANTHANUM_DUST.get());
        this.tag(TekoraTags.Items.LEAD_DUST).add(TekoraItems.LEAD_DUST.get());
        this.tag(TekoraTags.Items.LITHIUM_DUST).add(TekoraItems.LITHIUM_DUST.get());
        this.tag(TekoraTags.Items.LUTETIUM_DUST).add(TekoraItems.LUTETIUM_DUST.get());
        this.tag(TekoraTags.Items.MAGNESIUM_DUST).add(TekoraItems.MAGNESIUM_DUST.get());
        this.tag(TekoraTags.Items.MANGANESE_DUST).add(TekoraItems.MANGANESE_DUST.get());
        this.tag(TekoraTags.Items.MOLYBDENUM_DUST).add(TekoraItems.MOLYBDENUM_DUST.get());
        this.tag(TekoraTags.Items.NEODYMIUM_DUST).add(TekoraItems.NEODYMIUM_DUST.get());
        this.tag(TekoraTags.Items.NICKEL_DUST).add(TekoraItems.NICKEL_DUST.get());
        this.tag(TekoraTags.Items.NIOBIUM_DUST).add(TekoraItems.NIOBIUM_DUST.get());
        this.tag(TekoraTags.Items.OSMIUM_DUST).add(TekoraItems.OSMIUM_DUST.get());
        this.tag(TekoraTags.Items.PALLADIUM_DUST).add(TekoraItems.PALLADIUM_DUST.get());
        this.tag(TekoraTags.Items.PLATINUM_DUST).add(TekoraItems.PLATINUM_DUST.get());
        this.tag(TekoraTags.Items.POTASSIUM_DUST).add(TekoraItems.POTASSIUM_DUST.get());
        this.tag(TekoraTags.Items.PRASEODYMIUM_DUST).add(TekoraItems.PRASEODYMIUM_DUST.get());
        this.tag(TekoraTags.Items.RHENIUM_DUST).add(TekoraItems.RHENIUM_DUST.get());
        this.tag(TekoraTags.Items.RHODIUM_DUST).add(TekoraItems.RHODIUM_DUST.get());
        this.tag(TekoraTags.Items.RUBIDIUM_DUST).add(TekoraItems.RUBIDIUM_DUST.get());
        this.tag(TekoraTags.Items.RUTHENIUM_DUST).add(TekoraItems.RUTHENIUM_DUST.get());
        this.tag(TekoraTags.Items.SCANDIUM_DUST).add(TekoraItems.SCANDIUM_DUST.get());
        this.tag(TekoraTags.Items.SAMARIUM_DUST).add(TekoraItems.SAMARIUM_DUST.get());
        this.tag(TekoraTags.Items.SODIUM_DUST).add(TekoraItems.SODIUM_DUST.get());
        this.tag(TekoraTags.Items.STRONTIUM_DUST).add(TekoraItems.STRONTIUM_DUST.get());
        this.tag(TekoraTags.Items.SILVER_DUST).add(TekoraItems.SILVER_DUST.get());
        this.tag(TekoraTags.Items.TANTALUM_DUST).add(TekoraItems.TANTALUM_DUST.get());
        this.tag(TekoraTags.Items.TERBIUM_DUST).add(TekoraItems.TERBIUM_DUST.get());
        this.tag(TekoraTags.Items.THALLIUM_DUST).add(TekoraItems.THALLIUM_DUST.get());
        this.tag(TekoraTags.Items.THORIUM_DUST).add(TekoraItems.THORIUM_DUST.get());
        this.tag(TekoraTags.Items.THULIUM_DUST).add(TekoraItems.THULIUM_DUST.get());
        this.tag(TekoraTags.Items.TIN_DUST).add(TekoraItems.TIN_DUST.get());
        this.tag(TekoraTags.Items.TITANIUM_DUST).add(TekoraItems.TITANIUM_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_DUST).add(TekoraItems.TUNGSTEN_DUST.get());
        this.tag(TekoraTags.Items.URANIUM_DUST).add(TekoraItems.URANIUM_DUST.get());
        this.tag(TekoraTags.Items.VANADIUM_DUST).add(TekoraItems.VANADIUM_DUST.get());
        this.tag(TekoraTags.Items.YTTERBIUM_DUST).add(TekoraItems.YTTERBIUM_DUST.get());
        this.tag(TekoraTags.Items.YTTRIUM_DUST).add(TekoraItems.YTTRIUM_DUST.get());
        this.tag(TekoraTags.Items.ZINC_DUST).add(TekoraItems.ZINC_DUST.get());
        this.tag(TekoraTags.Items.ZIRCONIUM_DUST).add(TekoraItems.ZIRCONIUM_DUST.get());
        this.tag(TekoraTags.Items.BRASS_DUST).add(TekoraItems.BRASS_DUST.get());
        this.tag(TekoraTags.Items.BRONZE_DUST).add(TekoraItems.BRONZE_DUST.get());
        this.tag(TekoraTags.Items.CARBON_STEEL_DUST).add(TekoraItems.CARBON_STEEL_DUST.get());
        this.tag(TekoraTags.Items.CHROMOLY_STEEL_DUST).add(TekoraItems.CHROMOLY_STEEL_DUST.get());
        this.tag(TekoraTags.Items.FERROBORON_DUST).add(TekoraItems.FERROBORON_DUST.get());
        this.tag(TekoraTags.Items.HSLA_STEEL_DUST).add(TekoraItems.HSLA_STEEL_DUST.get());
        this.tag(TekoraTags.Items.INCONEL_DUST).add(TekoraItems.INCONEL_DUST.get());
        this.tag(TekoraTags.Items.INVAR_DUST).add(TekoraItems.INVAR_DUST.get());
        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM_DUST).add(TekoraItems.MAGNETIC_NEODYMIUM_DUST.get());
        this.tag(TekoraTags.Items.MU_METAL_DUST).add(TekoraItems.MU_METAL_DUST.get());
        this.tag(TekoraTags.Items.REACTOR_STEEL_DUST).add(TekoraItems.REACTOR_STEEL_DUST.get());
        this.tag(TekoraTags.Items.STAINLESS_STEEL_DUST).add(TekoraItems.STAINLESS_STEEL_DUST.get());
        this.tag(TekoraTags.Items.STEEL_DUST).add(TekoraItems.STEEL_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE_DUST).add(TekoraItems.TUNGSTEN_CARBIDE_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_STEEL_DUST).add(TekoraItems.TUNGSTEN_STEEL_DUST.get());
        this.tag(TekoraTags.Items.VANASTEEL_DUST).add(TekoraItems.VANASTEEL_DUST.get());
        this.tag(TekoraTags.Items.ZIRCALOY_DUST).add(TekoraItems.ZIRCALOY_DUST.get());

        this.tag(TekoraTags.Items.ANTIMONY_DUST).add(TekoraItems.ANTIMONY_DUST.get());
        this.tag(TekoraTags.Items.ARSENIC_DUST).add(TekoraItems.ARSENIC_DUST.get());
        this.tag(TekoraTags.Items.BORON_DUST).add(TekoraItems.BORON_DUST.get());
        this.tag(TekoraTags.Items.GERMANIUM_DUST).add(TekoraItems.GERMANIUM_DUST.get());
        this.tag(TekoraTags.Items.SILICON_DUST).add(TekoraItems.SILICON_DUST.get());
        this.tag(TekoraTags.Items.TELLURIUM_DUST).add(TekoraItems.TELLURIUM_DUST.get());

        this.tag(TekoraTags.Items.ALUMINUM_TINY_DUST).add(TekoraItems.ALUMINUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.BARIUM_TINY_DUST).add(TekoraItems.BARIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.BERYLLIUM_TINY_DUST).add(TekoraItems.BERYLLIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.BISMUTH_TINY_DUST).add(TekoraItems.BISMUTH_TINY_DUST.get());
        this.tag(TekoraTags.Items.CADMIUM_TINY_DUST).add(TekoraItems.CADMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.CALCIUM_TINY_DUST).add(TekoraItems.CALCIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.CERIUM_TINY_DUST).add(TekoraItems.CERIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.CESIUM_TINY_DUST).add(TekoraItems.CESIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.CHROMIUM_TINY_DUST).add(TekoraItems.CHROMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.COBALT_TINY_DUST).add(TekoraItems.COBALT_TINY_DUST.get());
        this.tag(TekoraTags.Items.COPPER_TINY_DUST).add(TekoraItems.COPPER_TINY_DUST.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_TINY_DUST).add(TekoraItems.CUPRONICKEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.ELECTRUM_TINY_DUST).add(TekoraItems.ELECTRUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.GOLD_TINY_DUST).add(TekoraItems.GOLD_TINY_DUST.get());
        this.tag(TekoraTags.Items.DYSPROSIUM_TINY_DUST).add(TekoraItems.DYSPROSIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.ERBIUM_TINY_DUST).add(TekoraItems.ERBIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.EUROPIUM_TINY_DUST).add(TekoraItems.EUROPIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.GADOLINIUM_TINY_DUST).add(TekoraItems.GADOLINIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.GALLIUM_TINY_DUST).add(TekoraItems.GALLIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.HAFNIUM_TINY_DUST).add(TekoraItems.HAFNIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.HOLMIUM_TINY_DUST).add(TekoraItems.HOLMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.INDIUM_TINY_DUST).add(TekoraItems.INDIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.IRIDIUM_TINY_DUST).add(TekoraItems.IRIDIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.IRON_TINY_DUST).add(TekoraItems.IRON_TINY_DUST.get());
        this.tag(TekoraTags.Items.LANTHANUM_TINY_DUST).add(TekoraItems.LANTHANUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.LEAD_TINY_DUST).add(TekoraItems.LEAD_TINY_DUST.get());
        this.tag(TekoraTags.Items.LITHIUM_TINY_DUST).add(TekoraItems.LITHIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.LUTETIUM_TINY_DUST).add(TekoraItems.LUTETIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.MAGNESIUM_TINY_DUST).add(TekoraItems.MAGNESIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.MANGANESE_TINY_DUST).add(TekoraItems.MANGANESE_TINY_DUST.get());
        this.tag(TekoraTags.Items.MOLYBDENUM_TINY_DUST).add(TekoraItems.MOLYBDENUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.NEODYMIUM_TINY_DUST).add(TekoraItems.NEODYMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.NICKEL_TINY_DUST).add(TekoraItems.NICKEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.NIOBIUM_TINY_DUST).add(TekoraItems.NIOBIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.OSMIUM_TINY_DUST).add(TekoraItems.OSMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.PALLADIUM_TINY_DUST).add(TekoraItems.PALLADIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.PLATINUM_TINY_DUST).add(TekoraItems.PLATINUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.POTASSIUM_TINY_DUST).add(TekoraItems.POTASSIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.PRASEODYMIUM_TINY_DUST).add(TekoraItems.PRASEODYMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.RHENIUM_TINY_DUST).add(TekoraItems.RHENIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.RHODIUM_TINY_DUST).add(TekoraItems.RHODIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.RUBIDIUM_TINY_DUST).add(TekoraItems.RUBIDIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.RUTHENIUM_TINY_DUST).add(TekoraItems.RUTHENIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.SCANDIUM_TINY_DUST).add(TekoraItems.SCANDIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.SAMARIUM_TINY_DUST).add(TekoraItems.SAMARIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.SODIUM_TINY_DUST).add(TekoraItems.SODIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.STRONTIUM_TINY_DUST).add(TekoraItems.STRONTIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.SILVER_TINY_DUST).add(TekoraItems.SILVER_TINY_DUST.get());
        this.tag(TekoraTags.Items.TANTALUM_TINY_DUST).add(TekoraItems.TANTALUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.TERBIUM_TINY_DUST).add(TekoraItems.TERBIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.THALLIUM_TINY_DUST).add(TekoraItems.THALLIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.THORIUM_TINY_DUST).add(TekoraItems.THORIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.THULIUM_TINY_DUST).add(TekoraItems.THULIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.TIN_TINY_DUST).add(TekoraItems.TIN_TINY_DUST.get());
        this.tag(TekoraTags.Items.TITANIUM_TINY_DUST).add(TekoraItems.TITANIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_TINY_DUST).add(TekoraItems.TUNGSTEN_TINY_DUST.get());
        this.tag(TekoraTags.Items.URANIUM_TINY_DUST).add(TekoraItems.URANIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.VANADIUM_TINY_DUST).add(TekoraItems.VANADIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.YTTERBIUM_TINY_DUST).add(TekoraItems.YTTERBIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.YTTRIUM_TINY_DUST).add(TekoraItems.YTTRIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.ZINC_TINY_DUST).add(TekoraItems.ZINC_TINY_DUST.get());
        this.tag(TekoraTags.Items.ZIRCONIUM_TINY_DUST).add(TekoraItems.ZIRCONIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.BRASS_TINY_DUST).add(TekoraItems.BRASS_TINY_DUST.get());
        this.tag(TekoraTags.Items.BRONZE_TINY_DUST).add(TekoraItems.BRONZE_TINY_DUST.get());
        this.tag(TekoraTags.Items.CARBON_STEEL_TINY_DUST).add(TekoraItems.CARBON_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.CHROMOLY_STEEL_TINY_DUST).add(TekoraItems.CHROMOLY_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.FERROBORON_TINY_DUST).add(TekoraItems.FERROBORON_TINY_DUST.get());
        this.tag(TekoraTags.Items.HSLA_STEEL_TINY_DUST).add(TekoraItems.HSLA_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.INCONEL_TINY_DUST).add(TekoraItems.INCONEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.INVAR_TINY_DUST).add(TekoraItems.INVAR_TINY_DUST.get());
        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM_TINY_DUST).add(TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.MU_METAL_TINY_DUST).add(TekoraItems.MU_METAL_TINY_DUST.get());
        this.tag(TekoraTags.Items.REACTOR_STEEL_TINY_DUST).add(TekoraItems.REACTOR_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.STAINLESS_STEEL_TINY_DUST).add(TekoraItems.STAINLESS_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.STEEL_TINY_DUST).add(TekoraItems.STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE_TINY_DUST).add(TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST.get());
        this.tag(TekoraTags.Items.TUNGSTEN_STEEL_TINY_DUST).add(TekoraItems.TUNGSTEN_STEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.VANASTEEL_TINY_DUST).add(TekoraItems.VANASTEEL_TINY_DUST.get());
        this.tag(TekoraTags.Items.ZIRCALOY_TINY_DUST).add(TekoraItems.ZIRCALOY_TINY_DUST.get());

        this.tag(TekoraTags.Items.ANTIMONY_TINY_DUST).add(TekoraItems.ANTIMONY_TINY_DUST.get());
        this.tag(TekoraTags.Items.ARSENIC_TINY_DUST).add(TekoraItems.ARSENIC_TINY_DUST.get());
        this.tag(TekoraTags.Items.BORON_TINY_DUST).add(TekoraItems.BORON_TINY_DUST.get());
        this.tag(TekoraTags.Items.GERMANIUM_TINY_DUST).add(TekoraItems.GERMANIUM_TINY_DUST.get());
        this.tag(TekoraTags.Items.SILICON_TINY_DUST).add(TekoraItems.SILICON_TINY_DUST.get());
        this.tag(TekoraTags.Items.TELLURIUM_TINY_DUST).add(TekoraItems.TELLURIUM_TINY_DUST.get());

        this.tag(TekoraTags.Items.GRAPHITE_DUST).add(TekoraItems.GRAPHITE_DUST.get());
        this.tag(TekoraTags.Items.IODINE_DUST).add(TekoraItems.IODINE_DUST.get());

        this.tag(TekoraTags.Items.ALUMINUM_WIRE).add(TekoraItems.ALUMINUM_WIRE.get());
        this.tag(TekoraTags.Items.COPPER_WIRE).add(TekoraItems.COPPER_WIRE.get());
        this.tag(TekoraTags.Items.CUPRONICKEL_WIRE).add(TekoraItems.CUPRONICKEL_WIRE.get());
        this.tag(TekoraTags.Items.ELECTRUM_WIRE).add(TekoraItems.ELECTRUM_WIRE.get());
        this.tag(TekoraTags.Items.GOLD_WIRE).add(TekoraItems.GOLD_WIRE.get());
        this.tag(TekoraTags.Items.SILVER_WIRE).add(TekoraItems.SILVER_WIRE.get());
        this.tag(TekoraTags.Items.TIN_WIRE).add(TekoraItems.TIN_WIRE.get());

        this.tag(TekoraTags.Items.AQUAMARINE_GEM).add(TekoraItems.AQUAMARINE.get());
        this.tag(TekoraTags.Items.BAUXITE_GEM).add(TekoraItems.BAUXITE.get());
        this.tag(TekoraTags.Items.CHROMITE_GEM).add(TekoraItems.CHROMITE.get());
        this.tag(TekoraTags.Items.CINNABAR_GEM).add(TekoraItems.CINNABAR.get());
        this.tag(TekoraTags.Items.COLTAN_GEM).add(TekoraItems.COLTAN.get());
        this.tag(TekoraTags.Items.HALITE_GEM).add(TekoraItems.HALITE.get());
        this.tag(TekoraTags.Items.MONAZITE_GEM).add(TekoraItems.MONAZITE.get());
        this.tag(TekoraTags.Items.PYROLUSITE_GEM).add(TekoraItems.PYROLUSITE.get());
        this.tag(TekoraTags.Items.RUBY_GEM).add(TekoraItems.RUBY.get());
        this.tag(TekoraTags.Items.RUTILE_GEM).add(TekoraItems.RUTILE.get());
        this.tag(TekoraTags.Items.SAPPHIRE_GEM).add(TekoraItems.SAPPHIRE.get());
        this.tag(TekoraTags.Items.URANINITE_GEM).add(TekoraItems.URANINITE.get());
        this.tag(TekoraTags.Items.WOLFRAMITE_GEM).add(TekoraItems.WOLFRAMITE.get());
        this.tag(TekoraTags.Items.ZIRCON_GEM).add(TekoraItems.ZIRCON.get());

        this.tag(TekoraTags.Items.RAW_LEAD).add(TekoraItems.RAW_LEAD.get());
        this.tag(TekoraTags.Items.RAW_NICKEL).add(TekoraItems.RAW_NICKEL.get());
        this.tag(TekoraTags.Items.RAW_PLATINUM).add(TekoraItems.RAW_PLATINUM.get());
        this.tag(TekoraTags.Items.RAW_SILVER).add(TekoraItems.RAW_SILVER.get());
        this.tag(TekoraTags.Items.RAW_TIN).add(TekoraItems.RAW_TIN.get());
        this.tag(TekoraTags.Items.RAW_ZINC).add(TekoraItems.RAW_ZINC.get());

        this.tag(TekoraTags.Items.CARBON_STEEL_ROD).add(TekoraItems.CARBON_STEEL_ROD.get());
        this.tag(TekoraTags.Items.STEEL_ROD).add(TekoraItems.STEEL_ROD.get());

        this.tag(TekoraTags.Items.ALUMINUM).addTags(TekoraTags.Items.ALUMINUM_DUST,
                TekoraTags.Items.ALUMINUM_INGOT,
                TekoraTags.Items.ALUMINUM_PLATE);


        this.tag(TekoraTags.Items.BARIUM).addTags(TekoraTags.Items.BARIUM_DUST,
                TekoraTags.Items.BARIUM_INGOT);

        this.tag(TekoraTags.Items.BERYLLIUM).addTags(TekoraTags.Items.BERYLLIUM_DUST,
                TekoraTags.Items.BERYLLIUM_INGOT);

        this.tag(TekoraTags.Items.BISMUTH).addTags(TekoraTags.Items.BISMUTH_DUST,
                TekoraTags.Items.BISMUTH_INGOT,
                TekoraTags.Items.BISMUTH_PLATE);

        this.tag(TekoraTags.Items.CADMIUM).addTags(TekoraTags.Items.CADMIUM_DUST,
                TekoraTags.Items.CADMIUM_INGOT,
                TekoraTags.Items.CADMIUM_PLATE);

        this.tag(TekoraTags.Items.CALCIUM).addTags(TekoraTags.Items.CALCIUM_DUST,
                TekoraTags.Items.CALCIUM_INGOT);

        this.tag(TekoraTags.Items.CERIUM).addTags(TekoraTags.Items.CERIUM_DUST,
                TekoraTags.Items.CERIUM_INGOT);

        this.tag(TekoraTags.Items.CESIUM).addTags(TekoraTags.Items.CESIUM_DUST,
                TekoraTags.Items.CESIUM_INGOT);

        this.tag(TekoraTags.Items.CHROMIUM).addTags(TekoraTags.Items.CHROMIUM_DUST,
                TekoraTags.Items.CHROMIUM_INGOT,
                TekoraTags.Items.CHROMIUM_PLATE);

        this.tag(TekoraTags.Items.COBALT).addTags(TekoraTags.Items.COBALT_DUST,
                TekoraTags.Items.COBALT_INGOT,
                TekoraTags.Items.COBALT_PLATE);

        this.tag(TekoraTags.Items.COPPER).addTags(TekoraTags.Items.COPPER_PLATE,
                TekoraTags.Items.COPPER_PLATE).add(Items.COPPER_INGOT);

        this.tag(TekoraTags.Items.GOLD).addTags(TekoraTags.Items.GOLD_DUST,
                TekoraTags.Items.GOLD_PLATE).add(Items.GOLD_INGOT);

        this.tag(TekoraTags.Items.DYSPROSIUM).addTags(TekoraTags.Items.DYSPROSIUM_DUST,
                TekoraTags.Items.DYSPROSIUM_INGOT);

        this.tag(TekoraTags.Items.ERBIUM).addTags(TekoraTags.Items.ERBIUM_DUST,
                TekoraTags.Items.ERBIUM_INGOT);

        this.tag(TekoraTags.Items.EUROPIUM).addTags(TekoraTags.Items.EUROPIUM_DUST,
                TekoraTags.Items.EUROPIUM_INGOT);

        this.tag(TekoraTags.Items.GADOLINIUM).addTags(TekoraTags.Items.GADOLINIUM_DUST,
                TekoraTags.Items.GADOLINIUM_INGOT);

        this.tag(TekoraTags.Items.GALLIUM).addTags(TekoraTags.Items.GALLIUM_DUST,
                TekoraTags.Items.GALLIUM_INGOT);

        this.tag(TekoraTags.Items.HAFNIUM).addTags(TekoraTags.Items.HAFNIUM_DUST,
                TekoraTags.Items.HAFNIUM_INGOT);

        this.tag(TekoraTags.Items.HOLMIUM).addTags(TekoraTags.Items.HOLMIUM_DUST,
                TekoraTags.Items.HOLMIUM_INGOT);

        this.tag(TekoraTags.Items.INDIUM).addTags(TekoraTags.Items.INDIUM_DUST,
                TekoraTags.Items.INDIUM_INGOT,
                TekoraTags.Items.INDIUM_PLATE);

        this.tag(TekoraTags.Items.IRIDIUM).addTags(TekoraTags.Items.IRIDIUM_DUST,
                TekoraTags.Items.IRIDIUM_INGOT,
                TekoraTags.Items.IRIDIUM_PLATE);

        this.tag(TekoraTags.Items.IRON).addTags(TekoraTags.Items.IRON_DUST,
                TekoraTags.Items.IRON_PLATE).add(Items.IRON_INGOT);

        this.tag(TekoraTags.Items.LANTHANUM).addTags(TekoraTags.Items.LANTHANUM_DUST,
                TekoraTags.Items.LANTHANUM_INGOT);

        this.tag(TekoraTags.Items.LEAD).addTags(TekoraTags.Items.LEAD_DUST,
                TekoraTags.Items.LEAD_INGOT,
                TekoraTags.Items.LEAD_PLATE);

        this.tag(TekoraTags.Items.LITHIUM).addTags(TekoraTags.Items.LITHIUM_DUST,
                TekoraTags.Items.LITHIUM_INGOT);

        this.tag(TekoraTags.Items.LUTETIUM).addTags(TekoraTags.Items.LUTETIUM_DUST,
                TekoraTags.Items.LUTETIUM_INGOT);

        this.tag(TekoraTags.Items.MAGNESIUM).addTags(TekoraTags.Items.MAGNESIUM_DUST,
                TekoraTags.Items.MAGNESIUM_INGOT,
                TekoraTags.Items.MAGNESIUM_PLATE);

        this.tag(TekoraTags.Items.MANGANESE).addTags(TekoraTags.Items.MANGANESE_DUST,
                TekoraTags.Items.MANGANESE_INGOT,
                TekoraTags.Items.MANGANESE_PLATE);

        this.tag(TekoraTags.Items.MOLYBDENUM).addTags(TekoraTags.Items.MOLYBDENUM_DUST,
                TekoraTags.Items.MOLYBDENUM_INGOT,
                TekoraTags.Items.MOLYBDENUM_PLATE);

        this.tag(TekoraTags.Items.NEODYMIUM).addTags(TekoraTags.Items.NEODYMIUM_DUST,
                TekoraTags.Items.NEODYMIUM_INGOT);

        this.tag(TekoraTags.Items.NICKEL).addTags(TekoraTags.Items.NICKEL_DUST,
                TekoraTags.Items.NICKEL_INGOT,
                TekoraTags.Items.NICKEL_PLATE);

        this.tag(TekoraTags.Items.NIOBIUM).addTags(TekoraTags.Items.NIOBIUM_DUST,
                TekoraTags.Items.NIOBIUM_INGOT,
                TekoraTags.Items.NIOBIUM_PLATE);

        this.tag(TekoraTags.Items.OSMIUM).addTags(TekoraTags.Items.OSMIUM_DUST,
                TekoraTags.Items.OSMIUM_INGOT,
                TekoraTags.Items.OSMIUM_PLATE);

        this.tag(TekoraTags.Items.PALLADIUM).addTags(TekoraTags.Items.PALLADIUM_DUST,
                TekoraTags.Items.PALLADIUM_INGOT,
                TekoraTags.Items.PALLADIUM_PLATE);

        this.tag(TekoraTags.Items.PLATINUM).addTags(TekoraTags.Items.PLATINUM_DUST,
                TekoraTags.Items.PLATINUM_INGOT,
                TekoraTags.Items.PLATINUM_PLATE);

        this.tag(TekoraTags.Items.POTASSIUM).addTags(TekoraTags.Items.POTASSIUM_DUST,
                TekoraTags.Items.POTASSIUM_INGOT);

        this.tag(TekoraTags.Items.PRASEODYMIUM).addTags(TekoraTags.Items.PRASEODYMIUM_DUST,
                TekoraTags.Items.PRASEODYMIUM_INGOT);

        this.tag(TekoraTags.Items.RHENIUM).addTags(TekoraTags.Items.RHENIUM_DUST,
                TekoraTags.Items.RHENIUM_INGOT);

        this.tag(TekoraTags.Items.RHODIUM).addTags(TekoraTags.Items.RHODIUM_DUST,
                TekoraTags.Items.RHODIUM_INGOT,
                TekoraTags.Items.RHODIUM_PLATE);

        this.tag(TekoraTags.Items.RUBIDIUM).addTags(TekoraTags.Items.RUBIDIUM_DUST,
                TekoraTags.Items.RUBIDIUM_INGOT);

        this.tag(TekoraTags.Items.RUTHENIUM).addTags(TekoraTags.Items.RUTHENIUM_DUST,
                TekoraTags.Items.RUTHENIUM_INGOT);

        this.tag(TekoraTags.Items.SCANDIUM).addTags(TekoraTags.Items.SCANDIUM_DUST,
                TekoraTags.Items.SCANDIUM_INGOT,
                TekoraTags.Items.SCANDIUM_PLATE);

        this.tag(TekoraTags.Items.SAMARIUM).addTags(TekoraTags.Items.SAMARIUM_DUST,
                TekoraTags.Items.SAMARIUM_INGOT);

        this.tag(TekoraTags.Items.SODIUM).addTags(TekoraTags.Items.SODIUM_DUST,
                TekoraTags.Items.SODIUM_INGOT);

        this.tag(TekoraTags.Items.STRONTIUM).addTags(TekoraTags.Items.STRONTIUM_DUST,
                TekoraTags.Items.STRONTIUM_INGOT);

        this.tag(TekoraTags.Items.SILVER).addTags(TekoraTags.Items.SILVER_DUST,
                TekoraTags.Items.SILVER_INGOT,
                TekoraTags.Items.SILVER_PLATE);

        this.tag(TekoraTags.Items.TANTALUM).addTags(TekoraTags.Items.TANTALUM_DUST,
                TekoraTags.Items.TANTALUM_INGOT);

        this.tag(TekoraTags.Items.TERBIUM).addTags(TekoraTags.Items.TERBIUM_DUST,
                TekoraTags.Items.TERBIUM_INGOT);

        this.tag(TekoraTags.Items.THALLIUM).addTags(TekoraTags.Items.THALLIUM_DUST,
                TekoraTags.Items.THALLIUM_INGOT);

        this.tag(TekoraTags.Items.THORIUM).addTags(TekoraTags.Items.THORIUM_DUST,
                TekoraTags.Items.THORIUM_INGOT,
                TekoraTags.Items.THORIUM_PLATE);

        this.tag(TekoraTags.Items.THULIUM).addTags(TekoraTags.Items.THULIUM_DUST,
                TekoraTags.Items.THULIUM_INGOT,
                TekoraTags.Items.THULIUM_PLATE);

        this.tag(TekoraTags.Items.TIN).addTags(TekoraTags.Items.TIN_DUST,
                TekoraTags.Items.TIN_INGOT,
                TekoraTags.Items.TIN_PLATE);

        this.tag(TekoraTags.Items.TITANIUM).addTags(TekoraTags.Items.TITANIUM_DUST,
                TekoraTags.Items.TITANIUM_INGOT,
                TekoraTags.Items.TITANIUM_PLATE);

        this.tag(TekoraTags.Items.TUNGSTEN).addTags(TekoraTags.Items.TUNGSTEN_DUST,
                TekoraTags.Items.TUNGSTEN_INGOT,
                TekoraTags.Items.TUNGSTEN_PLATE);

        this.tag(TekoraTags.Items.URANIUM).addTags(TekoraTags.Items.URANIUM_DUST,
                TekoraTags.Items.URANIUM_INGOT);

        this.tag(TekoraTags.Items.VANADIUM).addTags(TekoraTags.Items.VANADIUM_DUST,
                TekoraTags.Items.VANADIUM_INGOT);

        this.tag(TekoraTags.Items.YTTERBIUM).addTags(TekoraTags.Items.YTTERBIUM_DUST,
                TekoraTags.Items.YTTERBIUM_INGOT);

        this.tag(TekoraTags.Items.YTTRIUM).addTags(TekoraTags.Items.YTTRIUM_DUST,
                TekoraTags.Items.YTTRIUM_INGOT);

        this.tag(TekoraTags.Items.ZINC).addTags(TekoraTags.Items.ZINC_DUST,
                TekoraTags.Items.ZINC_INGOT,
                TekoraTags.Items.ZINC_PLATE);

        this.tag(TekoraTags.Items.ZIRCONIUM).addTags(TekoraTags.Items.ZIRCONIUM_DUST,
                TekoraTags.Items.ZIRCONIUM_INGOT,
                TekoraTags.Items.ZIRCONIUM_PLATE);

        this.tag(TekoraTags.Items.BRASS).addTags(TekoraTags.Items.BRASS_DUST,
                TekoraTags.Items.BRASS_INGOT,
                TekoraTags.Items.BRASS_PLATE);

        this.tag(TekoraTags.Items.BRONZE).addTags(TekoraTags.Items.BRONZE_DUST,
                TekoraTags.Items.BRONZE_INGOT,
                TekoraTags.Items.BRONZE_PLATE);

        this.tag(TekoraTags.Items.CARBON_STEEL).addTags(TekoraTags.Items.CARBON_STEEL_DUST,
                TekoraTags.Items.CARBON_STEEL_INGOT);

        this.tag(TekoraTags.Items.CHROMOLY_STEEL).addTags(TekoraTags.Items.CHROMOLY_STEEL_DUST,
                TekoraTags.Items.CHROMOLY_STEEL_INGOT,
                TekoraTags.Items.CHROMOLY_STEEL_PLATE);

        this.tag(TekoraTags.Items.CUPRONICKEL).addTags(TekoraTags.Items.CUPRONICKEL_DUST,
                TekoraTags.Items.CUPRONICKEL_INGOT,
                TekoraTags.Items.CUPRONICKEL_PLATE);

        this.tag(TekoraTags.Items.ELECTRUM).addTags(TekoraTags.Items.ELECTRUM_DUST,
                TekoraTags.Items.ELECTRUM_INGOT,
                TekoraTags.Items.ELECTRUM_PLATE);

        this.tag(TekoraTags.Items.FERROBORON).addTags(TekoraTags.Items.FERROBORON_DUST,
                TekoraTags.Items.FERROBORON_INGOT,
                TekoraTags.Items.FERROBORON_PLATE);

        this.tag(TekoraTags.Items.GALVANIZED_STEEL).addTags(TekoraTags.Items.GALVANIZED_STEEL_INGOT,
                TekoraTags.Items.GALVANIZED_STEEL_PLATE);

        this.tag(TekoraTags.Items.HSLA_STEEL).addTags(TekoraTags.Items.HSLA_STEEL_DUST,
                TekoraTags.Items.HSLA_STEEL_INGOT,
                TekoraTags.Items.HSLA_STEEL_PLATE);

        this.tag(TekoraTags.Items.INCONEL).addTags(TekoraTags.Items.INCONEL_DUST,
                TekoraTags.Items.INCONEL_INGOT,
                TekoraTags.Items.INCONEL_PLATE);

        this.tag(TekoraTags.Items.INVAR).addTags(TekoraTags.Items.INVAR_DUST,
                TekoraTags.Items.INVAR_INGOT,
                TekoraTags.Items.INVAR_PLATE);

        this.tag(TekoraTags.Items.MAGNETIC_NEODYMIUM).addTags(TekoraTags.Items.MAGNETIC_NEODYMIUM_DUST,
                TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT,
                TekoraTags.Items.MAGNETIC_NEODYMIUM_PLATE);

        this.tag(TekoraTags.Items.MU_METAL).addTags(TekoraTags.Items.MU_METAL_DUST,
                TekoraTags.Items.MU_METAL_INGOT,
                TekoraTags.Items.MU_METAL_PLATE);

        this.tag(TekoraTags.Items.REACTOR_STEEL).addTags(TekoraTags.Items.REACTOR_STEEL_DUST,
                TekoraTags.Items.REACTOR_STEEL_INGOT,
                TekoraTags.Items.REACTOR_STEEL_PLATE);

        this.tag(TekoraTags.Items.STAINLESS_STEEL).addTags(TekoraTags.Items.STAINLESS_STEEL_DUST,
                TekoraTags.Items.STAINLESS_STEEL_INGOT,
                TekoraTags.Items.STAINLESS_STEEL_PLATE);

        this.tag(TekoraTags.Items.STEEL).addTags(TekoraTags.Items.STEEL_DUST,
                TekoraTags.Items.STEEL_INGOT,
                TekoraTags.Items.STEEL_PLATE);

        this.tag(TekoraTags.Items.TUNGSTEN_CARBIDE).addTags(TekoraTags.Items.TUNGSTEN_CARBIDE_DUST,
                TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT,
                TekoraTags.Items.TUNGSTEN_CARBIDE_PLATE);

        this.tag(TekoraTags.Items.TUNGSTEN_STEEL).addTags(TekoraTags.Items.TUNGSTEN_STEEL_DUST,
                TekoraTags.Items.TUNGSTEN_STEEL_INGOT,
                TekoraTags.Items.TUNGSTEN_STEEL_PLATE);

        this.tag(TekoraTags.Items.VANASTEEL).addTags(TekoraTags.Items.VANASTEEL_DUST,
                TekoraTags.Items.VANASTEEL_INGOT,
                TekoraTags.Items.VANASTEEL_PLATE);

        this.tag(TekoraTags.Items.ZIRCALOY).addTags(TekoraTags.Items.ZIRCALOY_DUST,
                TekoraTags.Items.ZIRCALOY_INGOT,
                TekoraTags.Items.ZIRCALOY_PLATE);

        this.tag(TekoraTags.Items.INGOTS).addTags(
                TekoraTags.Items.ALUMINUM_INGOT,
                TekoraTags.Items.BARIUM_INGOT,
                TekoraTags.Items.BERYLLIUM_INGOT,
                TekoraTags.Items.BISMUTH_INGOT,
                TekoraTags.Items.CADMIUM_INGOT,
                TekoraTags.Items.CALCIUM_INGOT,
                TekoraTags.Items.CERIUM_INGOT,
                TekoraTags.Items.CESIUM_INGOT,
                TekoraTags.Items.CHROMIUM_INGOT,
                TekoraTags.Items.COBALT_INGOT,
                TekoraTags.Items.DYSPROSIUM_INGOT,
                TekoraTags.Items.ERBIUM_INGOT,
                TekoraTags.Items.EUROPIUM_INGOT,
                TekoraTags.Items.GADOLINIUM_INGOT,
                TekoraTags.Items.GALLIUM_INGOT,
                TekoraTags.Items.HAFNIUM_INGOT,
                TekoraTags.Items.HOLMIUM_INGOT,
                TekoraTags.Items.INDIUM_INGOT,
                TekoraTags.Items.IRIDIUM_INGOT,
                TekoraTags.Items.LANTHANUM_INGOT,
                TekoraTags.Items.LEAD_INGOT,
                TekoraTags.Items.LITHIUM_INGOT,
                TekoraTags.Items.LUTETIUM_INGOT,
                TekoraTags.Items.MAGNESIUM_INGOT,
                TekoraTags.Items.MANGANESE_INGOT,
                TekoraTags.Items.MOLYBDENUM_INGOT,
                TekoraTags.Items.NEODYMIUM_INGOT,
                TekoraTags.Items.NICKEL_INGOT,
                TekoraTags.Items.NIOBIUM_INGOT,
                TekoraTags.Items.OSMIUM_INGOT,
                TekoraTags.Items.PALLADIUM_INGOT,
                TekoraTags.Items.PLATINUM_INGOT,
                TekoraTags.Items.POTASSIUM_INGOT,
                TekoraTags.Items.PRASEODYMIUM_INGOT,
                TekoraTags.Items.RHENIUM_INGOT,
                TekoraTags.Items.RHODIUM_INGOT,
                TekoraTags.Items.RUBIDIUM_INGOT,
                TekoraTags.Items.RUTHENIUM_INGOT,
                TekoraTags.Items.SAMARIUM_INGOT,
                TekoraTags.Items.SCANDIUM_INGOT,
                TekoraTags.Items.SILVER_INGOT,
                TekoraTags.Items.SODIUM_INGOT,
                TekoraTags.Items.STRONTIUM_INGOT,
                TekoraTags.Items.TANTALUM_INGOT,
                TekoraTags.Items.TERBIUM_INGOT,
                TekoraTags.Items.THALLIUM_INGOT,
                TekoraTags.Items.THORIUM_INGOT,
                TekoraTags.Items.THULIUM_INGOT,
                TekoraTags.Items.TIN_INGOT,
                TekoraTags.Items.TITANIUM_INGOT,
                TekoraTags.Items.TUNGSTEN_INGOT,
                TekoraTags.Items.URANIUM_INGOT,
                TekoraTags.Items.VANADIUM_INGOT,
                TekoraTags.Items.YTTERBIUM_INGOT,
                TekoraTags.Items.YTTRIUM_INGOT,
                TekoraTags.Items.ZINC_INGOT,
                TekoraTags.Items.ZIRCONIUM_INGOT,
                TekoraTags.Items.BRASS_INGOT,
                TekoraTags.Items.BRONZE_INGOT,
                TekoraTags.Items.CARBON_STEEL_INGOT,
                TekoraTags.Items.CHROMOLY_STEEL_INGOT,
                TekoraTags.Items.FERROBORON_INGOT,
                TekoraTags.Items.GALVANIZED_STEEL_INGOT,
                TekoraTags.Items.HSLA_STEEL_INGOT,
                TekoraTags.Items.INCONEL_INGOT,
                TekoraTags.Items.INVAR_INGOT,
                TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT,
                TekoraTags.Items.MU_METAL_INGOT,
                TekoraTags.Items.REACTOR_STEEL_INGOT,
                TekoraTags.Items.STAINLESS_STEEL_INGOT,
                TekoraTags.Items.STEEL_INGOT,
                TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT,
                TekoraTags.Items.TUNGSTEN_STEEL_INGOT,
                TekoraTags.Items.VANASTEEL_INGOT,
                TekoraTags.Items.ZIRCALOY_INGOT
        );

        this.tag(TekoraTags.Items.CRUSHED_ANCIENT_DEBRIS_ORE).add(TekoraItems.PULVERIZED_ANCIENT_DEBRIS.get());
        this.tag(TekoraTags.Items.PULVERIZED_ANCIENT_DEBRIS_ORE).add(TekoraItems.PULVERIZED_ANCIENT_DEBRIS.get());
        this.tag(TekoraTags.Items.CRUSHED_AQUAMARINE_ORE).add(TekoraItems.PULVERIZED_AQUAMARINE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_AQUAMARINE_ORE).add(TekoraItems.PULVERIZED_AQUAMARINE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_BAUXITE_ORE).add(TekoraItems.PULVERIZED_BAUXITE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_BAUXITE_ORE).add(TekoraItems.PULVERIZED_BAUXITE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_CINNABAR_ORE).add(TekoraItems.PULVERIZED_CINNABAR_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_CINNABAR_ORE).add(TekoraItems.PULVERIZED_CINNABAR_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_COAL_ORE).add(TekoraItems.PULVERIZED_COAL_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_COAL_ORE).add(TekoraItems.PULVERIZED_COAL_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_DIAMOND_ORE).add(TekoraItems.PULVERIZED_DIAMOND_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_DIAMOND_ORE).add(TekoraItems.PULVERIZED_DIAMOND_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_EMERALD_ORE).add(TekoraItems.PULVERIZED_EMERALD_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_EMERALD_ORE).add(TekoraItems.PULVERIZED_EMERALD_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_HALITE_ORE).add(TekoraItems.PULVERIZED_HALITE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_HALITE_ORE).add(TekoraItems.PULVERIZED_HALITE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_LAPIS_ORE).add(TekoraItems.PULVERIZED_LAPIS_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_LAPIS_ORE).add(TekoraItems.PULVERIZED_LAPIS_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_QUARTZ_ORE).add(TekoraItems.PULVERIZED_QUARTZ_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_QUARTZ_ORE).add(TekoraItems.PULVERIZED_QUARTZ_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_REDSTONE_ORE).add(TekoraItems.PULVERIZED_REDSTONE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_REDSTONE_ORE).add(TekoraItems.PULVERIZED_REDSTONE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_RUBY_ORE).add(TekoraItems.PULVERIZED_RUBY_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_RUBY_ORE).add(TekoraItems.PULVERIZED_RUBY_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_SAPPHIRE_ORE).add(TekoraItems.PULVERIZED_SAPPHIRE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_SAPPHIRE_ORE).add(TekoraItems.PULVERIZED_SAPPHIRE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_URANINITE_ORE).add(TekoraItems.PULVERIZED_URANINITE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_URANINITE_ORE).add(TekoraItems.PULVERIZED_URANINITE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_WOLFRAMITE_ORE).add(TekoraItems.PULVERIZED_WOLFRAMITE_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_WOLFRAMITE_ORE).add(TekoraItems.PULVERIZED_WOLFRAMITE_ORE.get());
        this.tag(TekoraTags.Items.CRUSHED_ZIRCON_ORE).add(TekoraItems.PULVERIZED_ZIRCON_ORE.get());
        this.tag(TekoraTags.Items.PULVERIZED_ZIRCON_ORE).add(TekoraItems.PULVERIZED_ZIRCON_ORE.get());

        this.tag(TekoraTags.Items.NUGGETS).addTags(
                TekoraTags.Items.ALUMINUM_NUGGET,
                TekoraTags.Items.BARIUM_NUGGET,
                TekoraTags.Items.BERYLLIUM_NUGGET,
                TekoraTags.Items.BISMUTH_NUGGET,
                TekoraTags.Items.CADMIUM_NUGGET,
                TekoraTags.Items.CALCIUM_NUGGET,
                TekoraTags.Items.CERIUM_NUGGET,
                TekoraTags.Items.CESIUM_NUGGET,
                TekoraTags.Items.CHROMIUM_NUGGET,
                TekoraTags.Items.COBALT_NUGGET,
                TekoraTags.Items.DYSPROSIUM_NUGGET,
                TekoraTags.Items.ERBIUM_NUGGET,
                TekoraTags.Items.EUROPIUM_NUGGET,
                TekoraTags.Items.GADOLINIUM_NUGGET,
                TekoraTags.Items.GALLIUM_NUGGET,
                TekoraTags.Items.HAFNIUM_NUGGET,
                TekoraTags.Items.HOLMIUM_NUGGET,
                TekoraTags.Items.INDIUM_NUGGET,
                TekoraTags.Items.IRIDIUM_NUGGET,
                TekoraTags.Items.LANTHANUM_NUGGET,
                TekoraTags.Items.LEAD_NUGGET,
                TekoraTags.Items.LITHIUM_NUGGET,
                TekoraTags.Items.LUTETIUM_NUGGET,
                TekoraTags.Items.MAGNESIUM_NUGGET,
                TekoraTags.Items.MANGANESE_NUGGET,
                TekoraTags.Items.MOLYBDENUM_NUGGET,
                TekoraTags.Items.NEODYMIUM_NUGGET,
                TekoraTags.Items.NICKEL_NUGGET,
                TekoraTags.Items.NIOBIUM_NUGGET,
                TekoraTags.Items.OSMIUM_NUGGET,
                TekoraTags.Items.PALLADIUM_NUGGET,
                TekoraTags.Items.PLATINUM_NUGGET,
                TekoraTags.Items.POTASSIUM_NUGGET,
                TekoraTags.Items.PRASEODYMIUM_NUGGET,
                TekoraTags.Items.RHENIUM_NUGGET,
                TekoraTags.Items.RHODIUM_NUGGET,
                TekoraTags.Items.RUBIDIUM_NUGGET,
                TekoraTags.Items.RUTHENIUM_NUGGET,
                TekoraTags.Items.SAMARIUM_NUGGET,
                TekoraTags.Items.SCANDIUM_NUGGET,
                TekoraTags.Items.SILVER_NUGGET,
                TekoraTags.Items.SODIUM_NUGGET,
                TekoraTags.Items.STRONTIUM_NUGGET,
                TekoraTags.Items.TANTALUM_NUGGET,
                TekoraTags.Items.TERBIUM_NUGGET,
                TekoraTags.Items.THALLIUM_NUGGET,
                TekoraTags.Items.THORIUM_NUGGET,
                TekoraTags.Items.THULIUM_NUGGET,
                TekoraTags.Items.TIN_NUGGET,
                TekoraTags.Items.TITANIUM_NUGGET,
                TekoraTags.Items.TUNGSTEN_NUGGET,
                TekoraTags.Items.URANIUM_NUGGET,
                TekoraTags.Items.VANADIUM_NUGGET,
                TekoraTags.Items.YTTERBIUM_NUGGET,
                TekoraTags.Items.YTTRIUM_NUGGET,
                TekoraTags.Items.ZINC_NUGGET,
                TekoraTags.Items.ZIRCONIUM_NUGGET
        );

        this.tag(TekoraTags.Items.PLATES).addTags(
                TekoraTags.Items.ALUMINUM_PLATE,
                TekoraTags.Items.BISMUTH_PLATE,
                TekoraTags.Items.CADMIUM_PLATE,
                TekoraTags.Items.CHROMIUM_PLATE,
                TekoraTags.Items.COBALT_PLATE,
                TekoraTags.Items.INDIUM_PLATE,
                TekoraTags.Items.IRIDIUM_PLATE,
                TekoraTags.Items.LEAD_PLATE,
                TekoraTags.Items.MAGNESIUM_PLATE,
                TekoraTags.Items.MANGANESE_PLATE,
                TekoraTags.Items.MOLYBDENUM_PLATE,
                TekoraTags.Items.NICKEL_PLATE,
                TekoraTags.Items.NIOBIUM_PLATE,
                TekoraTags.Items.OSMIUM_PLATE,
                TekoraTags.Items.PALLADIUM_PLATE,
                TekoraTags.Items.PLATINUM_PLATE,
                TekoraTags.Items.RHODIUM_PLATE,
                TekoraTags.Items.SCANDIUM_PLATE,
                TekoraTags.Items.SILVER_PLATE,
                TekoraTags.Items.THORIUM_PLATE,
                TekoraTags.Items.THULIUM_PLATE,
                TekoraTags.Items.TIN_PLATE,
                TekoraTags.Items.TITANIUM_PLATE,
                TekoraTags.Items.TUNGSTEN_PLATE,
                TekoraTags.Items.YTTERBIUM_PLATE,
                TekoraTags.Items.ZINC_PLATE,
                TekoraTags.Items.ZIRCONIUM_PLATE,
                TekoraTags.Items.BRASS_PLATE,
                TekoraTags.Items.BRONZE_PLATE,
                TekoraTags.Items.CHROMOLY_STEEL_PLATE,
                TekoraTags.Items.FERROBORON_PLATE,
                TekoraTags.Items.GALVANIZED_STEEL_PLATE,
                TekoraTags.Items.HSLA_STEEL_PLATE,
                TekoraTags.Items.INCONEL_PLATE,
                TekoraTags.Items.INVAR_PLATE,
                TekoraTags.Items.MAGNETIC_NEODYMIUM_PLATE,
                TekoraTags.Items.MU_METAL_PLATE,
                TekoraTags.Items.REACTOR_STEEL_PLATE,
                TekoraTags.Items.STAINLESS_STEEL_PLATE,
                TekoraTags.Items.STEEL_PLATE,
                TekoraTags.Items.TUNGSTEN_CARBIDE_PLATE,
                TekoraTags.Items.TUNGSTEN_STEEL_PLATE,
                TekoraTags.Items.VANASTEEL_PLATE,
                TekoraTags.Items.ZIRCALOY_PLATE);

        this.tag(TekoraTags.Items.HAMMER).add(
                TekoraItems.BORON_HAMMER.get(),
                TekoraItems.BRONZE_HAMMER.get(),
                TekoraItems.DIAMOND_HAMMER.get(),
                TekoraItems.GOLDEN_HAMMER.get(),
                TekoraItems.IRON_HAMMER.get(),
                TekoraItems.NETHERITE_HAMMER.get(),
                TekoraItems.PLATINUM_HAMMER.get(),
                TekoraItems.SILVER_HAMMER.get(),
                TekoraItems.STEEL_HAMMER.get(),
                TekoraItems.THORIUM_HAMMER.get(),
                TekoraItems.TITANIUM_HAMMER.get(),
                TekoraItems.TUNGSTEN_STEEL_HAMMER.get(),
                TekoraItems.VANASTEEL_HAMMER.get()
        );
    }
}
