package net.nukollodda.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.item.TekoraToolsAndArmorList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class TekoraRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public TekoraRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, TekoraTags.Items.AQUAMARINE_ORE, TekoraItems.AQUAMARINE.get());
        oreBlasting(pWriter, TekoraTags.Items.BAUXITE_ORE, TekoraItems.BAUXITE.get());
        oreBlasting(pWriter, TekoraTags.Items.CINNABAR_ORE, TekoraItems.CINNABAR.get());
        oreBlasting(pWriter, TekoraTags.Items.HALITE_ORE, TekoraItems.HALITE.get());
        oreBlasting(pWriter, TekoraTags.Items.RUBY_ORE, TekoraItems.RUBY.get());
        oreBlasting(pWriter, TekoraTags.Items.SAPPHIRE_ORE, TekoraItems.SAPPHIRE.get());
        oreBlasting(pWriter, TekoraTags.Items.URANINITE_ORE, TekoraItems.URANINITE.get());
        oreBlasting(pWriter, TekoraTags.Items.WOLFRAMITE_ORE, TekoraItems.WOLFRAMITE.get());
        oreBlasting(pWriter, TekoraTags.Items.ZIRCON_ORE, TekoraItems.ZIRCON.get());

        oreBlasting(pWriter, TekoraTags.Items.LEAD_ORE, TekoraItems.LEAD_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.NICKEL_ORE, TekoraItems.NICKEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TIN_ORE, TekoraItems.TIN_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ZINC_ORE, TekoraItems.ZINC_INGOT.get());

        oreBlasting(pWriter, TekoraTags.Items.RAW_LEAD, TekoraItems.LEAD_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_NICKEL, TekoraItems.NICKEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_SILVER, TekoraItems.SILVER_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_TIN, TekoraItems.TIN_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RAW_ZINC, TekoraItems.ZINC_INGOT.get());

        oreBlasting(pWriter, TekoraTags.Items.BAUXITE_GEM, TekoraItems.ALUMINA.get());
        oreBlasting(pWriter, TekoraItems.APT.get(), TekoraItems.TUNGSTEN_OXIDE.get());
        oreBlasting(pWriter, TekoraItems.RUTILE.get(), TekoraItems.TITANIUM_DIOXIDE.get());

        oreBlasting(pWriter, TekoraTags.Items.ALUMINUM_DUST, TekoraItems.ALUMINUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.BARIUM_DUST, TekoraItems.BARIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.BERYLLIUM_DUST, TekoraItems.BERYLLIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.BISMUTH_DUST, TekoraItems.BISMUTH_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CADMIUM_DUST, TekoraItems.CADMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CALCIUM_DUST, TekoraItems.CALCIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CERIUM_DUST, TekoraItems.CERIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CHROMIUM_DUST, TekoraItems.CHROMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.COBALT_DUST, TekoraItems.COBALT_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.COPPER_DUST, Items.COPPER_INGOT);
        oreBlasting(pWriter, TekoraTags.Items.DYSPROSIUM_DUST, TekoraItems.DYSPROSIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ERBIUM_DUST, TekoraItems.ERBIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.EUROPIUM_DUST, TekoraItems.EUROPIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.GADOLINIUM_DUST, TekoraItems.GADOLINIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.GALLIUM_DUST, TekoraItems.GALLIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.GOLD_DUST, Items.GOLD_INGOT);
        oreBlasting(pWriter, TekoraTags.Items.HAFNIUM_DUST, TekoraItems.HAFNIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.HOLMIUM_DUST, TekoraItems.HOLMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.INDIUM_DUST, TekoraItems.INDIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.IRIDIUM_DUST, TekoraItems.IRIDIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.IRON_DUST, Items.IRON_INGOT);
        oreBlasting(pWriter, TekoraTags.Items.LANTHANUM_DUST, TekoraItems.LANTHANUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.LEAD_DUST, TekoraItems.LEAD_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.LUTETIUM_DUST, TekoraItems.LUTETIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.MAGNESIUM_DUST, TekoraItems.MAGNESIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.MANGANESE_DUST, TekoraItems.MANGANESE_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.MOLYBDENUM_DUST, TekoraItems.MOLYBDENUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.NEODYMIUM_DUST, TekoraItems.NEODYMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.NICKEL_DUST, TekoraItems.NICKEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.NIOBIUM_DUST, TekoraItems.NIOBIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.OSMIUM_DUST, TekoraItems.OSMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.PALLADIUM_DUST, TekoraItems.PALLADIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.PLATINUM_DUST, TekoraItems.PLATINUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.PRASEODYMIUM_DUST, TekoraItems.PRASEODYMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RHENIUM_DUST, TekoraItems.RHENIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RHODIUM_DUST, TekoraItems.RHODIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.RUTHENIUM_DUST, TekoraItems.RUTHENIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.SCANDIUM_DUST, TekoraItems.SCANDIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.SAMARIUM_DUST, TekoraItems.SAMARIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.STRONTIUM_DUST, TekoraItems.STRONTIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.SILVER_DUST, TekoraItems.SILVER_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TANTALUM_DUST, TekoraItems.TANTALUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TERBIUM_DUST, TekoraItems.TERBIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.THALLIUM_DUST, TekoraItems.THALLIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.THORIUM_DUST, TekoraItems.THORIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.THULIUM_DUST, TekoraItems.THULIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TIN_DUST, TekoraItems.TIN_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TITANIUM_DUST, TekoraItems.TITANIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_DUST, TekoraItems.TUNGSTEN_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.URANIUM_DUST, TekoraItems.URANIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.VANADIUM_DUST, TekoraItems.VANADIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.YTTERBIUM_DUST, TekoraItems.YTTERBIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.YTTRIUM_DUST, TekoraItems.YTTRIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ZINC_DUST, TekoraItems.ZINC_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ZIRCONIUM_DUST, TekoraItems.ZIRCONIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.BRASS_DUST, TekoraItems.BRASS_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.BRONZE_DUST, TekoraItems.BRONZE_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CARBON_STEEL_DUST, TekoraItems.CARBON_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.CHROMOLY_STEEL_DUST, TekoraItems.CHROMOLY_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.FERROBORON_DUST, TekoraItems.FERROBORON_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.HSLA_STEEL_DUST, TekoraItems.HSLA_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.INCONEL_DUST, TekoraItems.INCONEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.INVAR_DUST, TekoraItems.INVAR_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.MAGNETIC_NEODYMIUM_DUST, TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.MU_METAL_DUST, TekoraItems.MU_METAL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.REACTOR_STEEL_DUST, TekoraItems.REACTOR_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.STAINLESS_STEEL_DUST, TekoraItems.STAINLESS_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.STEEL_DUST, TekoraItems.STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_CARBIDE_DUST, TekoraItems.TUNGSTEN_CARBIDE_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_STEEL_DUST, TekoraItems.TUNGSTEN_STEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.VANASTEEL_DUST, TekoraItems.VANASTEEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ZIRCALOY_DUST, TekoraItems.ZIRCALOY_INGOT.get());

        storageBlockRecipe(pWriter, TekoraBlocks.ALUMINUM_BLOCK.get(), TekoraTags.Items.ALUMINUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.BARIUM_BLOCK.get(), TekoraTags.Items.BARIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.BERYLLIUM_BLOCK.get(), TekoraTags.Items.BERYLLIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.BISMUTH_BLOCK.get(), TekoraTags.Items.BISMUTH_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.CADMIUM_BLOCK.get(), TekoraTags.Items.CADMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.CALCIUM_BLOCK.get(), TekoraTags.Items.CALCIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.CERIUM_BLOCK.get(), TekoraTags.Items.CERIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.CHROMIUM_BLOCK.get(), TekoraTags.Items.CHROMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.COBALT_BLOCK.get(), TekoraTags.Items.COBALT_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.DYSPROSIUM_BLOCK.get(), TekoraTags.Items.DYSPROSIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.ERBIUM_BLOCK.get(), TekoraTags.Items.ERBIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.EUROPIUM_BLOCK.get(), TekoraTags.Items.EUROPIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.GADOLINIUM_BLOCK.get(), TekoraTags.Items.GADOLINIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.GALLIUM_BLOCK.get(), TekoraTags.Items.GALLIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.HAFNIUM_BLOCK.get(), TekoraTags.Items.HAFNIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.HOLMIUM_BLOCK.get(), TekoraTags.Items.HOLMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.INDIUM_BLOCK.get(), TekoraTags.Items.INDIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.IRIDIUM_BLOCK.get(), TekoraTags.Items.IRIDIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.LANTHANUM_BLOCK.get(), TekoraTags.Items.LANTHANUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.LEAD_BLOCK.get(), TekoraTags.Items.LEAD_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.LUTETIUM_BLOCK.get(), TekoraTags.Items.LUTETIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MAGNESIUM_BLOCK.get(), TekoraTags.Items.MAGNESIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MANGANESE_BLOCK.get(), TekoraTags.Items.MANGANESE_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.MOLYBDENUM_BLOCK.get(), TekoraTags.Items.MOLYBDENUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.NEODYMIUM_BLOCK.get(), TekoraTags.Items.NEODYMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.NICKEL_BLOCK.get(), TekoraTags.Items.NICKEL_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.NIOBIUM_BLOCK.get(), TekoraTags.Items.NIOBIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.OSMIUM_BLOCK.get(), TekoraTags.Items.OSMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.PALLADIUM_BLOCK.get(), TekoraTags.Items.PALLADIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.PLATINUM_BLOCK.get(), TekoraTags.Items.PLATINUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.PRASEODYMIUM_BLOCK.get(), TekoraTags.Items.PRASEODYMIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.RHENIUM_BLOCK.get(), TekoraTags.Items.RHENIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.RHODIUM_BLOCK.get(), TekoraTags.Items.RHODIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.RUTHENIUM_BLOCK.get(), TekoraTags.Items.RUTHENIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.SCANDIUM_BLOCK.get(), TekoraTags.Items.SCANDIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.SAMARIUM_BLOCK.get(), TekoraTags.Items.SAMARIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.STRONTIUM_BLOCK.get(), TekoraTags.Items.STRONTIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.SILVER_BLOCK.get(), TekoraTags.Items.SILVER_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TANTALUM_BLOCK.get(), TekoraTags.Items.TANTALUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TERBIUM_BLOCK.get(), TekoraTags.Items.TERBIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.THALLIUM_BLOCK.get(), TekoraTags.Items.THALLIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.THORIUM_BLOCK.get(), TekoraTags.Items.THORIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.THULIUM_BLOCK.get(), TekoraTags.Items.THULIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TIN_BLOCK.get(), TekoraTags.Items.TIN_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TITANIUM_BLOCK.get(), TekoraTags.Items.TITANIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.TUNGSTEN_BLOCK.get(), TekoraTags.Items.TUNGSTEN_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.URANIUM_BLOCK.get(), TekoraTags.Items.URANIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.VANADIUM_BLOCK.get(), TekoraTags.Items.VANADIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.YTTERBIUM_BLOCK.get(), TekoraTags.Items.YTTERBIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.YTTRIUM_BLOCK.get(), TekoraTags.Items.YTTRIUM_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.ZINC_BLOCK.get(), TekoraTags.Items.ZINC_INGOT);
        storageBlockRecipe(pWriter, TekoraBlocks.ZIRCONIUM_BLOCK.get(), TekoraTags.Items.ZIRCONIUM_INGOT);

        storageBlockRecipe(pWriter, TekoraItems.ALUMINUM_INGOT.get(), TekoraTags.Items.ALUMINUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.BARIUM_INGOT.get(), TekoraTags.Items.BARIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.BERYLLIUM_INGOT.get(), TekoraTags.Items.BERYLLIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.BISMUTH_INGOT.get(), TekoraTags.Items.BISMUTH_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CADMIUM_INGOT.get(), TekoraTags.Items.CADMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CALCIUM_INGOT.get(), TekoraTags.Items.CALCIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CERIUM_INGOT.get(), TekoraTags.Items.CERIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CHROMIUM_INGOT.get(), TekoraTags.Items.CHROMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.COBALT_INGOT.get(), TekoraTags.Items.COBALT_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.DYSPROSIUM_INGOT.get(), TekoraTags.Items.DYSPROSIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.ERBIUM_INGOT.get(), TekoraTags.Items.ERBIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.EUROPIUM_INGOT.get(), TekoraTags.Items.EUROPIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.GADOLINIUM_INGOT.get(), TekoraTags.Items.GADOLINIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.GALLIUM_INGOT.get(), TekoraTags.Items.GALLIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.HAFNIUM_INGOT.get(), TekoraTags.Items.HAFNIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.HOLMIUM_INGOT.get(), TekoraTags.Items.HOLMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.INDIUM_INGOT.get(), TekoraTags.Items.INDIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.IRIDIUM_INGOT.get(), TekoraTags.Items.IRIDIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.LANTHANUM_INGOT.get(), TekoraTags.Items.LANTHANUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.LEAD_INGOT.get(), TekoraTags.Items.LEAD_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.LUTETIUM_INGOT.get(), TekoraTags.Items.LUTETIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.MAGNESIUM_INGOT.get(), TekoraTags.Items.MAGNESIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.MANGANESE_INGOT.get(), TekoraTags.Items.MANGANESE_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.MOLYBDENUM_INGOT.get(), TekoraTags.Items.MOLYBDENUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.NEODYMIUM_INGOT.get(), TekoraTags.Items.NEODYMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.NICKEL_INGOT.get(), TekoraTags.Items.NICKEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.NIOBIUM_INGOT.get(), TekoraTags.Items.NIOBIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.OSMIUM_INGOT.get(), TekoraTags.Items.OSMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.PALLADIUM_INGOT.get(), TekoraTags.Items.PALLADIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.PLATINUM_INGOT.get(), TekoraTags.Items.PLATINUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.PRASEODYMIUM_INGOT.get(), TekoraTags.Items.PRASEODYMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.RHENIUM_INGOT.get(), TekoraTags.Items.RHENIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.RHODIUM_INGOT.get(), TekoraTags.Items.RHODIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.RUTHENIUM_INGOT.get(), TekoraTags.Items.RUTHENIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.SCANDIUM_INGOT.get(), TekoraTags.Items.SCANDIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.SAMARIUM_INGOT.get(), TekoraTags.Items.SAMARIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.STRONTIUM_INGOT.get(), TekoraTags.Items.STRONTIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.SILVER_INGOT.get(), TekoraTags.Items.SILVER_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TANTALUM_INGOT.get(), TekoraTags.Items.TANTALUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TERBIUM_INGOT.get(), TekoraTags.Items.TERBIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.THALLIUM_INGOT.get(), TekoraTags.Items.THALLIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.THORIUM_INGOT.get(), TekoraTags.Items.THORIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.THULIUM_INGOT.get(), TekoraTags.Items.THULIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TIN_INGOT.get(), TekoraTags.Items.TIN_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TITANIUM_INGOT.get(), TekoraTags.Items.TITANIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_INGOT.get(), TekoraTags.Items.TUNGSTEN_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.URANIUM_INGOT.get(), TekoraTags.Items.URANIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.VANADIUM_INGOT.get(), TekoraTags.Items.VANADIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.YTTERBIUM_INGOT.get(), TekoraTags.Items.YTTERBIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.YTTRIUM_INGOT.get(), TekoraTags.Items.YTTRIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.ZINC_INGOT.get(), TekoraTags.Items.ZINC_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.ZIRCONIUM_INGOT.get(), TekoraTags.Items.ZIRCONIUM_NUGGET);

        storageBlockRecipe(pWriter, TekoraBlocks.RAW_LEAD_BLOCK.get(), TekoraTags.Items.RAW_LEAD);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_NICKEL_BLOCK.get(), TekoraTags.Items.RAW_NICKEL);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_PLATINUM_BLOCK.get(), TekoraTags.Items.RAW_PLATINUM);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_SILVER_BLOCK.get(), TekoraTags.Items.RAW_SILVER);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_TIN_BLOCK.get(), TekoraTags.Items.RAW_TIN);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_ZINC_BLOCK.get(), TekoraTags.Items.RAW_ZINC);

        nineBlockStorageRecipes(pWriter, TekoraItems.ALUMINUM_INGOT.get(), TekoraTags.Items.ALUMINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BARIUM_INGOT.get(), TekoraTags.Items.BARIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BERYLLIUM_INGOT.get(), TekoraTags.Items.BERYLLIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BISMUTH_INGOT.get(), TekoraTags.Items.BISMUTH_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CADMIUM_INGOT.get(), TekoraTags.Items.CADMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CALCIUM_INGOT.get(), TekoraTags.Items.CALCIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CERIUM_INGOT.get(), TekoraTags.Items.CERIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMIUM_INGOT.get(), TekoraTags.Items.CHROMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.COBALT_INGOT.get(), TekoraTags.Items.COBALT_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.DYSPROSIUM_INGOT.get(), TekoraTags.Items.DYSPROSIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ERBIUM_INGOT.get(), TekoraTags.Items.ERBIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.EUROPIUM_INGOT.get(), TekoraTags.Items.EUROPIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.GADOLINIUM_INGOT.get(), TekoraTags.Items.GADOLINIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.GALLIUM_INGOT.get(), TekoraTags.Items.GALLIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.HAFNIUM_INGOT.get(), TekoraTags.Items.HAFNIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.HOLMIUM_INGOT.get(), TekoraTags.Items.HOLMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.INDIUM_INGOT.get(), TekoraTags.Items.INDIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.IRIDIUM_INGOT.get(), TekoraTags.Items.IRIDIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.LANTHANUM_INGOT.get(), TekoraTags.Items.LANTHANUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.LEAD_INGOT.get(), TekoraTags.Items.LEAD_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.LUTETIUM_INGOT.get(), TekoraTags.Items.LUTETIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNESIUM_INGOT.get(), TekoraTags.Items.MAGNESIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MANGANESE_INGOT.get(), TekoraTags.Items.MANGANESE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MOLYBDENUM_INGOT.get(), TekoraTags.Items.MOLYBDENUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.NEODYMIUM_INGOT.get(), TekoraTags.Items.NEODYMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.NICKEL_INGOT.get(), TekoraTags.Items.NICKEL_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.NIOBIUM_INGOT.get(), TekoraTags.Items.NIOBIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.OSMIUM_INGOT.get(), TekoraTags.Items.OSMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.PALLADIUM_INGOT.get(), TekoraTags.Items.PALLADIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.PLATINUM_INGOT.get(), TekoraTags.Items.PLATINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.PRASEODYMIUM_INGOT.get(), TekoraTags.Items.PRASEODYMIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHENIUM_INGOT.get(), TekoraTags.Items.RHENIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHODIUM_INGOT.get(), TekoraTags.Items.RHODIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUTHENIUM_INGOT.get(), TekoraTags.Items.RUTHENIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SCANDIUM_INGOT.get(), TekoraTags.Items.SCANDIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SAMARIUM_INGOT.get(), TekoraTags.Items.SAMARIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.STRONTIUM_INGOT.get(), TekoraTags.Items.STRONTIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILVER_INGOT.get(), TekoraTags.Items.SILVER_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TANTALUM_INGOT.get(), TekoraTags.Items.TANTALUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TERBIUM_INGOT.get(), TekoraTags.Items.TERBIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.THALLIUM_INGOT.get(), TekoraTags.Items.THALLIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.THORIUM_INGOT.get(), TekoraTags.Items.THORIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.THULIUM_INGOT.get(), TekoraTags.Items.THULIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TIN_INGOT.get(), TekoraTags.Items.TIN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TITANIUM_INGOT.get(), TekoraTags.Items.TITANIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_INGOT.get(), TekoraTags.Items.TUNGSTEN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.URANIUM_INGOT.get(), TekoraTags.Items.URANIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.VANADIUM_INGOT.get(), TekoraTags.Items.VANADIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTERBIUM_INGOT.get(), TekoraTags.Items.YTTERBIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTRIUM_INGOT.get(), TekoraTags.Items.YTTRIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZINC_INGOT.get(), TekoraTags.Items.ZINC_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCONIUM_INGOT.get(), TekoraTags.Items.ZIRCONIUM_BLOCK);

        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_LEAD.get(), TekoraTags.Items.RAW_LEAD_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_NICKEL.get(), TekoraTags.Items.RAW_NICKEL_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_PLATINUM.get(), TekoraTags.Items.RAW_PLATINUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_SILVER.get(), TekoraTags.Items.RAW_SILVER_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_TIN.get(), TekoraTags.Items.RAW_TIN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RAW_ZINC.get(), TekoraTags.Items.RAW_ZINC_BLOCK);

        nineBlockStorageRecipes(pWriter, TekoraItems.ALUMINUM_NUGGET.get(), TekoraTags.Items.ALUMINUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.BARIUM_NUGGET.get(), TekoraTags.Items.BARIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.BERYLLIUM_NUGGET.get(), TekoraTags.Items.BERYLLIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.BISMUTH_NUGGET.get(), TekoraTags.Items.BISMUTH_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CADMIUM_NUGGET.get(), TekoraTags.Items.CADMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CALCIUM_NUGGET.get(), TekoraTags.Items.CALCIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CERIUM_NUGGET.get(), TekoraTags.Items.CERIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMIUM_NUGGET.get(), TekoraTags.Items.CHROMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.COBALT_NUGGET.get(), TekoraTags.Items.COBALT_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.DYSPROSIUM_NUGGET.get(), TekoraTags.Items.DYSPROSIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.ERBIUM_NUGGET.get(), TekoraTags.Items.ERBIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.EUROPIUM_NUGGET.get(), TekoraTags.Items.EUROPIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.GADOLINIUM_NUGGET.get(), TekoraTags.Items.GADOLINIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.GALLIUM_NUGGET.get(), TekoraTags.Items.GALLIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.HAFNIUM_NUGGET.get(), TekoraTags.Items.HAFNIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.HOLMIUM_NUGGET.get(), TekoraTags.Items.HOLMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.INDIUM_NUGGET.get(), TekoraTags.Items.INDIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.IRIDIUM_NUGGET.get(), TekoraTags.Items.IRIDIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.LANTHANUM_NUGGET.get(), TekoraTags.Items.LANTHANUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.LEAD_NUGGET.get(), TekoraTags.Items.LEAD_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.LUTETIUM_NUGGET.get(), TekoraTags.Items.LUTETIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNESIUM_NUGGET.get(), TekoraTags.Items.MAGNESIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.MANGANESE_NUGGET.get(), TekoraTags.Items.MANGANESE_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.MOLYBDENUM_NUGGET.get(), TekoraTags.Items.MOLYBDENUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.NEODYMIUM_NUGGET.get(), TekoraTags.Items.NEODYMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.NICKEL_NUGGET.get(), TekoraTags.Items.NICKEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.NIOBIUM_NUGGET.get(), TekoraTags.Items.NIOBIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.OSMIUM_NUGGET.get(), TekoraTags.Items.OSMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.PALLADIUM_NUGGET.get(), TekoraTags.Items.PALLADIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.PLATINUM_NUGGET.get(), TekoraTags.Items.PLATINUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.PRASEODYMIUM_NUGGET.get(), TekoraTags.Items.PRASEODYMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHENIUM_NUGGET.get(), TekoraTags.Items.RHENIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHODIUM_NUGGET.get(), TekoraTags.Items.RHODIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUTHENIUM_NUGGET.get(), TekoraTags.Items.RUTHENIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.SCANDIUM_NUGGET.get(), TekoraTags.Items.SCANDIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.SAMARIUM_NUGGET.get(), TekoraTags.Items.SAMARIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.STRONTIUM_NUGGET.get(), TekoraTags.Items.STRONTIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILVER_NUGGET.get(), TekoraTags.Items.SILVER_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TANTALUM_NUGGET.get(), TekoraTags.Items.TANTALUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TERBIUM_NUGGET.get(), TekoraTags.Items.TERBIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.THALLIUM_NUGGET.get(), TekoraTags.Items.THALLIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.THORIUM_NUGGET.get(), TekoraTags.Items.THORIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.THULIUM_NUGGET.get(), TekoraTags.Items.THULIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TIN_NUGGET.get(), TekoraTags.Items.TIN_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TITANIUM_NUGGET.get(), TekoraTags.Items.TITANIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_NUGGET.get(), TekoraTags.Items.TUNGSTEN_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.URANIUM_NUGGET.get(), TekoraTags.Items.URANIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.VANADIUM_NUGGET.get(), TekoraTags.Items.VANADIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTERBIUM_NUGGET.get(), TekoraTags.Items.YTTERBIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTRIUM_NUGGET.get(), TekoraTags.Items.YTTRIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZINC_NUGGET.get(), TekoraTags.Items.ZINC_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCONIUM_NUGGET.get(), TekoraTags.Items.ZIRCONIUM_INGOT);

        nineBlockStorageRecipes(pWriter, TekoraItems.ANTIMONY_PIECE.get(), TekoraTags.Items.ANTIMONY_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ARSENIC_PIECE.get(), TekoraTags.Items.ARSENIC_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BORON_PIECE.get(), TekoraTags.Items.BORON_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.GERMANIUM_PIECE.get(), TekoraTags.Items.GERMANIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILICON_PIECE.get(), TekoraTags.Items.SILICON_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TELLURIUM_PIECE.get(), TekoraTags.Items.TELLURIUM_BLOCK);

        crushingRecipe(pWriter, TekoraTags.Items.ALUMINUM, TekoraItems.ALUMINUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.BISMUTH, TekoraItems.BISMUTH_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.CADMIUM, TekoraItems.CADMIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.CHROMIUM, TekoraItems.CHROMIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.COBALT, TekoraItems.COBALT_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.COPPER, TekoraItems.COPPER_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.GOLD, TekoraItems.GOLD_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.INDIUM, TekoraItems.INDIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.IRIDIUM, TekoraItems.IRIDIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.IRON, TekoraItems.IRON_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.LEAD, TekoraItems.LEAD_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.MAGNESIUM, TekoraItems.MAGNESIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.MANGANESE, TekoraItems.MANGANESE_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.MOLYBDENUM, TekoraItems.MOLYBDENUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.NICKEL, TekoraItems.NICKEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.NIOBIUM, TekoraItems.NIOBIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.OSMIUM, TekoraItems.OSMIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.PALLADIUM, TekoraItems.PALLADIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.PLATINUM, TekoraItems.PLATINUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.RHODIUM, TekoraItems.RHODIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.SCANDIUM, TekoraItems.SCANDIUM_PLATE.get());;
        crushingRecipe(pWriter, TekoraTags.Items.SILVER, TekoraItems.SILVER_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.THORIUM, TekoraItems.THORIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.THULIUM, TekoraItems.THULIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.TIN, TekoraItems.TIN_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.TITANIUM, TekoraItems.TITANIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.TUNGSTEN, TekoraItems.TUNGSTEN_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.YTTERBIUM, TekoraItems.YTTERBIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.ZINC, TekoraItems.ZINC_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.ZIRCONIUM, TekoraItems.ZIRCONIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.BRASS, TekoraItems.BRASS_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.BRONZE, TekoraItems.BRONZE_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.CHROMOLY_STEEL, TekoraItems.CHROMOLY_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.FERROBORON, TekoraItems.FERROBORON_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.GALVANIZED_STEEL, TekoraItems.GALVANIZED_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.HSLA_STEEL, TekoraItems.HSLA_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.INCONEL, TekoraItems.INCONEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.INVAR, TekoraItems.INVAR_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.MAGNETIC_NEODYMIUM, TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.MU_METAL, TekoraItems.MU_METAL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.REACTOR_STEEL, TekoraItems.REACTOR_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.STAINLESS_STEEL, TekoraItems.STAINLESS_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.STEEL, TekoraItems.STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.TUNGSTEN_CARBIDE, TekoraItems.TUNGSTEN_CARBIDE_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.TUNGSTEN_STEEL, TekoraItems.TUNGSTEN_STEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.VANASTEEL, TekoraItems.VANASTEEL_PLATE.get());
        crushingRecipe(pWriter, TekoraTags.Items.ZIRCALOY, TekoraItems.ZIRCALOY_PLATE.get());

        armorRecipe(pWriter, Ingredient.of(TekoraItems.BORON_PIECE.get()), TekoraToolsAndArmorList.BORON_ARMOR);
        armorRecipe(pWriter, Ingredient.of(TekoraTags.Items.BRONZE_INGOT), TekoraToolsAndArmorList.BRONZE_ARMOR);
        armorRecipe(pWriter, Ingredient.of(TekoraTags.Items.PLATINUM_INGOT), TekoraToolsAndArmorList.PLATINUM_ARMOR);
        armorRecipe(pWriter, Ingredient.of(TekoraTags.Items.SILVER_INGOT), TekoraToolsAndArmorList.SILVER_ARMOR);
        armorRecipe(pWriter, Ingredient.of(TekoraTags.Items.STEEL_INGOT), TekoraToolsAndArmorList.STEEL_ARMOR);

        toolRecipe(pWriter, Ingredient.of(TekoraItems.BORON_PIECE.get()), TekoraToolsAndArmorList.BORON_TOOLS);
        toolRecipe(pWriter, Ingredient.of(TekoraTags.Items.BRONZE_INGOT), TekoraToolsAndArmorList.BRONZE_TOOLS);
        toolRecipe(pWriter, Ingredient.of(TekoraTags.Items.PLATINUM_INGOT), TekoraToolsAndArmorList.PLATINUM_TOOLS);
        toolRecipe(pWriter, Ingredient.of(TekoraTags.Items.SILVER_INGOT), TekoraToolsAndArmorList.SILVER_TOOLS);
        toolRecipe(pWriter, Ingredient.of(TekoraTags.Items.STEEL_INGOT), TekoraToolsAndArmorList.STEEL_TOOLS);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.STEEL_ARMOR, Ingredient.of(TekoraTags.Items.TITANIUM_INGOT),
                TekoraItems.TITANIUM_TEMPLATE.get(), TekoraToolsAndArmorList.TITANIUM_ARMOR);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.IRON_ARMOR, Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_INGOT),
                TekoraItems.TUNGSTEN_STEEL_TEMPLATE.get(), TekoraToolsAndArmorList.TUNGSTEN_STEEL_ARMOR);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.IRON_ARMOR, Ingredient.of(TekoraTags.Items.VANASTEEL_INGOT),
                TekoraItems.VANASTEEL_TEMPLATE.get(), TekoraToolsAndArmorList.VANASTEEL_ARMOR);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.STEEL_TOOLS, Ingredient.of(TekoraTags.Items.TITANIUM_INGOT),
                TekoraItems.TITANIUM_TEMPLATE.get(), TekoraToolsAndArmorList.TITANIUM_TOOLS);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.STEEL_TOOLS, Ingredient.of(TekoraTags.Items.THORIUM_INGOT),
                TekoraItems.THORIUM_TEMPLATE.get(), TekoraToolsAndArmorList.THORIUM_TOOLS);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.IRON_TOOLS, Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_INGOT),
                TekoraItems.TUNGSTEN_STEEL_TEMPLATE.get(), TekoraToolsAndArmorList.TUNGSTEN_STEEL_TOOLS);

        upgradeSmithingRecipe(pWriter, TekoraToolsAndArmorList.IRON_TOOLS, Ingredient.of(TekoraTags.Items.VANASTEEL_INGOT),
                TekoraItems.VANASTEEL_TEMPLATE.get(), TekoraToolsAndArmorList.VANASTEEL_TOOLS);

        createHammerRecipe(pWriter, Ingredient.of(Items.DIAMOND), TekoraItems.DIAMOND_HAMMER.get());
        createHammerRecipe(pWriter, Ingredient.of(Items.GOLD_INGOT), TekoraItems.GOLDEN_HAMMER.get());
        createHammerRecipe(pWriter, Ingredient.of(Items.IRON_INGOT), TekoraItems.IRON_HAMMER.get());

        createMixingRecipe(pWriter, TekoraItems.BRASS_DUST.get(), 3, new byte[]{1, 3},
                Ingredient.of(TekoraTags.Items.ZINC_DUST), Ingredient.of(TekoraTags.Items.COPPER_DUST));

        createMixingRecipe(pWriter, TekoraItems.BRONZE_DUST.get(), 3, new byte[]{1, 3},
                Ingredient.of(TekoraTags.Items.TIN_DUST), Ingredient.of(TekoraTags.Items.COPPER_DUST));

        createMixingRecipe(pWriter, TekoraItems.STEEL_DUST.get(), 1, new byte[]{1, 3},
                Ingredient.of(TekoraTags.Items.IRON_DUST), Ingredient.of(Items.COAL)); // temp recipe, will be replaced

        createMixingRecipe(pWriter, TekoraItems.INVAR_DUST.get(), 2, new byte[]{1, 1},
                Ingredient.of(TekoraTags.Items.IRON_DUST), Ingredient.of(TekoraTags.Items.NICKEL_DUST));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(TekoraItems.DIAMOND_HAMMER.get()),
                        Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.MISC, TekoraItems.NETHERITE_HAMMER.get())
                .unlocks(getHasName(TekoraItems.DIAMOND_HAMMER.get()), has(TekoraItems.DIAMOND_HAMMER.get()))
                .save(pWriter, new ResourceLocation(Tekora.MODID,
                        getItemName(TekoraItems.NETHERITE_HAMMER.get()) + "_from_" + getItemName(TekoraItems.DIAMOND_HAMMER.get()) + "_smithing"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraBlocks.ALLOY_FURNACE.get())
                .pattern("111")
                .pattern("121")
                .pattern("000")
                .define('0', Items.SMOOTH_STONE).define('1', TekoraTags.Items.STEEL_INGOT).define('2', Items.FURNACE)
                .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                .save(pWriter, Tekora.MODID + ":alloy_furnace_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraBlocks.INFUSION_FURNACE.get())
                .pattern("111")
                .pattern("121")
                .pattern("000")
                .define('0', Items.SMOOTH_STONE).define('1', Items.BRICK).define('2', Items.FURNACE)
                .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                .save(pWriter, Tekora.MODID + ":infusion_furnace_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.TURBINE_STATOR.get())
                .pattern("000")
                .pattern("0 0")
                .pattern("000")
                .define('0', TekoraTags.Items.STEEL_ROD)
                .unlockedBy(getHasName(TekoraItems.STEEL_ROD.get()), has(TekoraItems.STEEL_ROD.get()))
                .save(pWriter, Tekora.MODID + ":turbine_stator_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.TURBINE_ROTOR.get())
                .pattern("101")
                .pattern("020")
                .pattern("101")
                .define('0', TekoraTags.Items.CHROMOLY_STEEL_PLATE).define('1', TekoraTags.Items.STEEL_INGOT)
                .define('2', TekoraTags.Items.CARBON_STEEL_ROD)
                .unlockedBy(getHasName(TekoraItems.STEEL_ROD.get()), has(TekoraItems.STEEL_ROD.get()))
                .save(pWriter, Tekora.MODID + ":turbine_rotor_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.TURBINE_GENERATOR.get())
                .pattern("010")
                .pattern("020")
                .pattern("030")
                .define('0', TekoraTags.Items.STAINLESS_STEEL_PLATE).define('1', TekoraItems.TURBINE_STATOR.get())
                .define('2', TekoraItems.TURBINE_ROTOR.get()).define('3', TekoraTags.Items.CARBON_STEEL_ROD)
                .unlockedBy(getHasName(TekoraItems.CARBON_STEEL_ROD.get()), has(TekoraItems.CARBON_STEEL_ROD.get()))
                .save(pWriter, Tekora.MODID + ":turbine_generator_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.COIL.get())
                .pattern("010")
                .pattern("010")
                .pattern("010")
                .define('0', TekoraBlocks.COPPER_CABLE.get()).define('1', TekoraTags.Items.ALUMINUM_INGOT)
                // remember to replace ingot to rod at some point
                .unlockedBy(getHasName(TekoraBlocks.COPPER_CABLE.get()), has(TekoraBlocks.COPPER_CABLE.get()))
                .save(pWriter, Tekora.MODID + ":coil_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.STEEL_ROD.get(), 4)
                .pattern("0")
                .pattern("0")
                .define('0', TekoraTags.Items.STEEL_INGOT)
                .unlockedBy(getHasName(TekoraItems.STEEL_INGOT.get()), has(TekoraItems.STEEL_INGOT.get()))
                .save(pWriter, Tekora.MODID + ":steel_rod_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.CARBON_STEEL_ROD.get(), 4)
                .pattern("0")
                .pattern("0")
                .define('0', TekoraTags.Items.CARBON_STEEL_INGOT)
                .unlockedBy(getHasName(TekoraItems.CARBON_STEEL_INGOT.get()), has(TekoraItems.CARBON_STEEL_INGOT.get()))
                .save(pWriter, Tekora.MODID + ":carbon_steel_rod_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.STAINLESS_STEEL_TURBINE.get())
                .pattern("0 0")
                .pattern(" 1 ")
                .pattern("0 0")
                .define('0', TekoraTags.Items.STAINLESS_STEEL_PLATE).define('1', TekoraTags.Items.CARBON_STEEL_ROD)
                .unlockedBy(getHasName(TekoraItems.STAINLESS_STEEL_PLATE.get()), has(TekoraItems.STAINLESS_STEEL_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":stainless_steel_turbine_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraBlocks.HYDROELECTRIC_GENERATOR.get())
                .pattern("020")
                .pattern("343")
                .pattern("010")
                .define('0', TekoraTags.Items.STEEL_PLATE).define('1', TekoraItems.STAINLESS_STEEL_TURBINE.get())
                .define('2', TekoraItems.TURBINE_GENERATOR.get()).define('3', TekoraBlocks.COPPER_CABLE.get())
                .define('4', TekoraTags.Items.CARBON_STEEL_ROD)
                .unlockedBy(getHasName(TekoraBlocks.COPPER_CABLE.get()), has(TekoraBlocks.COPPER_CABLE.get()))
                .save(pWriter, Tekora.MODID + ":hydroelectric_generator_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)
                .requires(TekoraTags.Items.GOLD_PLATE)
                .unlockedBy(getHasName(TekoraItems.GOLD_PLATE.get()), has(TekoraItems.GOLD_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":light_weighted_pressure_plate_from_plate");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .requires(TekoraTags.Items.IRON_PLATE)
                .unlockedBy(getHasName(TekoraItems.IRON_PLATE.get()), has(TekoraItems.IRON_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":heavy_weighted_pressure_plate_from_plate");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredients, ItemLike pResult) {
        oreBlasting(pFinishedRecipeConsumer, List.of(pIngredients), pResult, getItemName(pResult.asItem()));
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     List<ItemLike> pIngredients, ItemLike pResult, String pGroup) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 100, RecipeSerializer.BLASTING_RECIPE)
                    .group(getItemName(pResult)).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting_" + getItemName(itemlike));

            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, 1, 200, RecipeSerializer.SMELTING_RECIPE)
                    .group(getItemName(pResult)).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,
                            Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting_" + getItemName(itemlike));
        }
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     TagKey<Item> pIngredients, ItemLike pResult) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 100, RecipeSerializer.BLASTING_RECIPE)
             .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
             .save(pFinishedRecipeConsumer,
                     Tekora.MODID + ":" + getItemName(pResult) + "_from_blasting" +
                             pIngredients.location().getPath().replace('/', '_'));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), RecipeCategory.MISC, pResult, 1, 200, RecipeSerializer.SMELTING_RECIPE)
                .group(getItemName(pResult)).unlockedBy(getHasName(pResult), has(pIngredients))
                .save(pFinishedRecipeConsumer,
                        Tekora.MODID + ":" + getItemName(pResult) + "_from_smelting" +
                                pIngredients.location().getPath().replace('/', '_'));
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter,
                                                  ItemLike pResult, TagKey<Item> pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter, ItemLike pResult, ItemLike pInput) {
        nineBlockStorageRecipes(pWriter, pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pWriter, ItemLike pResult, Ingredient pInput,
                                                  ItemLike pUnlocker, @Nullable String pGroup) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, 9)
                .requires(pInput).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter);
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, TagKey<Item> pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), Ingredient.of(pInput).getItems()[0].getItem(), pResult.toString());
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, ItemLike pInput) {
        storageBlockRecipe(pWriter, pResult, Ingredient.of(pInput), pInput, pResult.toString());
    }

    protected static void storageBlockRecipe(Consumer<FinishedRecipe> pWriter,
                                             ItemLike pResult, Ingredient pInput, ItemLike pUnlocker, @Nullable String pGroup) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput, 9).group(pGroup)
                .unlockedBy(getHasName(pUnlocker), has(pUnlocker))
                .save(pWriter, getItemName(pResult) + "_from_components");
    }

    protected static void crushingRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        crushingRecipe(pWriter, Ingredient.of(pInput), pResult);
    }

    protected static void crushingRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        crushingRecipe(pWriter, Ingredient.of(pInput), pResult);
    }

    protected static void crushingRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, ItemLike pResult) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(TekoraTags.Items.HAMMER).group(pResult.asItem().toString())
                .unlockedBy(getHasName(TekoraItems.IRON_HAMMER.get()), has(TekoraItems.IRON_HAMMER.get()))
                .save(pWriter, getItemName(pResult) + "_from_hammer");
    }

    protected static void upgradeSmithingRecipe(Consumer<FinishedRecipe> pWriter, ItemLike[] pBase, Ingredient pMaterial, ItemLike pUpgrader,
                                                     ItemLike[] pResults) {
        for (int i = 0; i < pBase.length; i++) {
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(pUpgrader), Ingredient.of(pBase[i]),
                            pMaterial, RecipeCategory.MISC, pResults[i].asItem())
                    .unlocks(getHasName(pBase[i]), has(pBase[i]))
                    .save(pWriter, new ResourceLocation(Tekora.MODID,
                            getItemName(pResults[i]) + "_from_" + getItemName(pBase[i]) + "_smithing"));
        }
    }

    protected static void armorRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, ItemLike[] pArmorItems) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[0])
                .pattern("000")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[0]), has(pArmorItems[0]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[0] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[1])
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[1]), has(pArmorItems[1]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[1] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[2])
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[2]), has(pArmorItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[2] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pArmorItems[3])
                .pattern("0 0")
                .pattern("0 0")
                .define('0', pMaterial)
                .unlockedBy(getHasName(pArmorItems[3]), has(pArmorItems[3]))
                .save(pWriter, Tekora.MODID + ":" + pArmorItems[3] + "_from_crafting");
    }

    protected static void toolRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, ItemLike[] pToolItems) {
        toolRecipe(pWriter, pMaterial, Ingredient.of(Items.STICK), pToolItems);
    }

    protected static void toolRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, Ingredient pStick, ItemLike[] pToolItems) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[0])
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[0]), has(pToolItems[0]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[0] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[1])
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[1]), has(pToolItems[1]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[1] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[2] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[2])
                .pattern("00")
                .pattern("10")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[2]), has(pToolItems[2]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[2] + "_from_crafting_inverted");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[3])
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[3]), has(pToolItems[3]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[3] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[4] + "_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pToolItems[4])
                .pattern("00")
                .pattern("1 ")
                .pattern("1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pToolItems[4]), has(pToolItems[4]))
                .save(pWriter, Tekora.MODID + ":" + pToolItems[4] + "_from_crafting_inverted");

        createHammerRecipe(pWriter, pMaterial, pStick, pToolItems[5]);
    }

    protected static void createHammerRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, ItemLike pHammer) {
        createHammerRecipe(pWriter, pMaterial, Ingredient.of(Items.STICK), pHammer);
    }

    protected static void createHammerRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pMaterial, Ingredient pStick, ItemLike pHammer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pHammer)
                .pattern("000")
                .pattern("000")
                .pattern(" 1 ")
                .define('0', pMaterial).define('1', pStick)
                .unlockedBy(getHasName(pHammer), has(pHammer))
                .save(pWriter, Tekora.MODID + ":" + pHammer + "_from_crafting");
    }

    protected static void createMixingRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pOutput, int pOutCount, byte[] pIngCounts,
                                             Ingredient... pIngredients) {
        ShapelessRecipeBuilder unbuilt = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pOutput, pOutCount);
        int ind = 0;
        int cnt = 0;
        for (Ingredient ing : pIngredients) {
            if (cnt >= 9) break;
            unbuilt.requires(ing, pIngCounts[ind]);
            cnt += pIngCounts[ind];
            ind++;
        }
        unbuilt.unlockedBy(getHasName(pOutput), has(pOutput))
                .save(pWriter, Tekora.MODID + ":" + pOutput + "_from_mixing");
    }
}
