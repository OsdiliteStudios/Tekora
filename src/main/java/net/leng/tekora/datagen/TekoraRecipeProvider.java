package net.leng.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.leng.tekora.Tekora;
import net.leng.tekora.block.TekoraBlocks;
import net.leng.tekora.datagen.tags.TekoraTags;
import net.leng.tekora.item.TekoraItems;
import net.leng.tekora.item.TekoraToolsAndArmorList;
import net.leng.tekora.recipes.builders.CompressionRecipeBuilder;
import net.leng.tekora.recipes.builders.ExtrusionRecipeBuilder;
import net.leng.tekora.recipes.builders.PulverizingRecipeBuilder;

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
        oreBlasting(pWriter, TekoraTags.Items.CUPRONICKEL_DUST, TekoraItems.CUPRONICKEL_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.DYSPROSIUM_DUST, TekoraItems.DYSPROSIUM_INGOT.get());
        oreBlasting(pWriter, TekoraTags.Items.ELECTRUM_DUST, TekoraItems.ELECTRUM_INGOT.get());
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

        oreBlasting(pWriter, TekoraTags.Items.ALUMINUM_TINY_DUST, TekoraItems.ALUMINUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.BARIUM_TINY_DUST, TekoraItems.BARIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.BERYLLIUM_TINY_DUST, TekoraItems.BERYLLIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.BISMUTH_TINY_DUST, TekoraItems.BISMUTH_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CADMIUM_TINY_DUST, TekoraItems.CADMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CALCIUM_TINY_DUST, TekoraItems.CALCIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CERIUM_TINY_DUST, TekoraItems.CERIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CHROMIUM_TINY_DUST, TekoraItems.CHROMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.COBALT_TINY_DUST, TekoraItems.COBALT_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.COPPER_TINY_DUST, TekoraItems.COPPER_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CUPRONICKEL_TINY_DUST, TekoraItems.CUPRONICKEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.DYSPROSIUM_TINY_DUST, TekoraItems.DYSPROSIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.ELECTRUM_TINY_DUST, TekoraItems.ELECTRUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.ERBIUM_TINY_DUST, TekoraItems.ERBIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.EUROPIUM_TINY_DUST, TekoraItems.EUROPIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.GADOLINIUM_TINY_DUST, TekoraItems.GADOLINIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.GALLIUM_TINY_DUST, TekoraItems.GALLIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.GOLD_TINY_DUST, Items.GOLD_NUGGET);
        oreBlasting(pWriter, TekoraTags.Items.HAFNIUM_TINY_DUST, TekoraItems.HAFNIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.HOLMIUM_TINY_DUST, TekoraItems.HOLMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.INDIUM_TINY_DUST, TekoraItems.INDIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.IRIDIUM_TINY_DUST, TekoraItems.IRIDIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.IRON_TINY_DUST, Items.IRON_NUGGET);
        oreBlasting(pWriter, TekoraTags.Items.LANTHANUM_TINY_DUST, TekoraItems.LANTHANUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.LEAD_TINY_DUST, TekoraItems.LEAD_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.LUTETIUM_TINY_DUST, TekoraItems.LUTETIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.MAGNESIUM_TINY_DUST, TekoraItems.MAGNESIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.MANGANESE_TINY_DUST, TekoraItems.MANGANESE_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.MOLYBDENUM_TINY_DUST, TekoraItems.MOLYBDENUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.NEODYMIUM_TINY_DUST, TekoraItems.NEODYMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.NICKEL_TINY_DUST, TekoraItems.NICKEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.NIOBIUM_TINY_DUST, TekoraItems.NIOBIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.OSMIUM_TINY_DUST, TekoraItems.OSMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.PALLADIUM_TINY_DUST, TekoraItems.PALLADIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.PLATINUM_TINY_DUST, TekoraItems.PLATINUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.PRASEODYMIUM_TINY_DUST, TekoraItems.PRASEODYMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.RHENIUM_TINY_DUST, TekoraItems.RHENIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.RHODIUM_TINY_DUST, TekoraItems.RHODIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.RUTHENIUM_TINY_DUST, TekoraItems.RUTHENIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.SCANDIUM_TINY_DUST, TekoraItems.SCANDIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.SAMARIUM_TINY_DUST, TekoraItems.SAMARIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.STRONTIUM_TINY_DUST, TekoraItems.STRONTIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.SILVER_TINY_DUST, TekoraItems.SILVER_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TANTALUM_TINY_DUST, TekoraItems.TANTALUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TERBIUM_TINY_DUST, TekoraItems.TERBIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.THALLIUM_TINY_DUST, TekoraItems.THALLIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.THORIUM_TINY_DUST, TekoraItems.THORIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.THULIUM_TINY_DUST, TekoraItems.THULIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TIN_TINY_DUST, TekoraItems.TIN_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TITANIUM_TINY_DUST, TekoraItems.TITANIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_TINY_DUST, TekoraItems.TUNGSTEN_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.URANIUM_TINY_DUST, TekoraItems.URANIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.VANADIUM_TINY_DUST, TekoraItems.VANADIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.YTTERBIUM_TINY_DUST, TekoraItems.YTTERBIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.YTTRIUM_TINY_DUST, TekoraItems.YTTRIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.ZINC_TINY_DUST, TekoraItems.ZINC_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.ZIRCONIUM_TINY_DUST, TekoraItems.ZIRCONIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.BRASS_TINY_DUST, TekoraItems.BRASS_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.BRONZE_TINY_DUST, TekoraItems.BRONZE_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CARBON_STEEL_TINY_DUST, TekoraItems.CARBON_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.CHROMOLY_STEEL_TINY_DUST, TekoraItems.CHROMOLY_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.FERROBORON_TINY_DUST, TekoraItems.FERROBORON_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.HSLA_STEEL_TINY_DUST, TekoraItems.HSLA_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.INCONEL_TINY_DUST, TekoraItems.INCONEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.INVAR_TINY_DUST, TekoraItems.INVAR_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.MAGNETIC_NEODYMIUM_TINY_DUST, TekoraItems.MAGNETIC_NEODYMIUM_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.MU_METAL_TINY_DUST, TekoraItems.MU_METAL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.REACTOR_STEEL_TINY_DUST, TekoraItems.REACTOR_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.STAINLESS_STEEL_TINY_DUST, TekoraItems.STAINLESS_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.STEEL_TINY_DUST, TekoraItems.STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_CARBIDE_TINY_DUST, TekoraItems.TUNGSTEN_CARBIDE_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.TUNGSTEN_STEEL_TINY_DUST, TekoraItems.TUNGSTEN_STEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.VANASTEEL_TINY_DUST, TekoraItems.VANASTEEL_NUGGET.get());
        oreBlasting(pWriter, TekoraTags.Items.ZIRCALOY_TINY_DUST, TekoraItems.ZIRCALOY_NUGGET.get());

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
        storageBlockRecipe(pWriter, TekoraItems.BRASS_INGOT.get(), TekoraTags.Items.BRASS_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.BRONZE_INGOT.get(), TekoraTags.Items.BRONZE_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CARBON_STEEL_INGOT.get(), TekoraTags.Items.CARBON_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CHROMOLY_STEEL_INGOT.get(), TekoraTags.Items.CHROMOLY_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.CUPRONICKEL_INGOT.get(), TekoraTags.Items.CUPRONICKEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.ELECTRUM_INGOT.get(), TekoraTags.Items.ELECTRUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.FERROBORON_INGOT.get(), TekoraTags.Items.FERROBORON_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.HSLA_STEEL_INGOT.get(), TekoraTags.Items.HSLA_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.INCONEL_INGOT.get(), TekoraTags.Items.INCONEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.INVAR_INGOT.get(), TekoraTags.Items.INVAR_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get(), TekoraTags.Items.MAGNETIC_NEODYMIUM_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.MU_METAL_INGOT.get(), TekoraTags.Items.MU_METAL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.REACTOR_STEEL_INGOT.get(), TekoraTags.Items.REACTOR_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.STAINLESS_STEEL_INGOT.get(), TekoraTags.Items.STAINLESS_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.STEEL_INGOT.get(), TekoraTags.Items.STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_CARBIDE_INGOT.get(), TekoraTags.Items.TUNGSTEN_CARBIDE_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_STEEL_INGOT.get(), TekoraTags.Items.TUNGSTEN_STEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.VANASTEEL_INGOT.get(), TekoraTags.Items.VANASTEEL_NUGGET);
        storageBlockRecipe(pWriter, TekoraItems.ZIRCALOY_INGOT.get(), TekoraTags.Items.ZIRCALOY_NUGGET);

        storageBlockRecipe(pWriter, TekoraItems.ALUMINUM_DUST.get(), TekoraTags.Items.ALUMINUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.BARIUM_DUST.get(), TekoraTags.Items.BARIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.BERYLLIUM_DUST.get(), TekoraTags.Items.BERYLLIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.BISMUTH_DUST.get(), TekoraTags.Items.BISMUTH_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CADMIUM_DUST.get(), TekoraTags.Items.CADMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CALCIUM_DUST.get(), TekoraTags.Items.CALCIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CERIUM_DUST.get(), TekoraTags.Items.CERIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CHROMIUM_DUST.get(), TekoraTags.Items.CHROMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.COBALT_DUST.get(), TekoraTags.Items.COBALT_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.DYSPROSIUM_DUST.get(), TekoraTags.Items.DYSPROSIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.ERBIUM_DUST.get(), TekoraTags.Items.ERBIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.EUROPIUM_DUST.get(), TekoraTags.Items.EUROPIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.GADOLINIUM_DUST.get(), TekoraTags.Items.GADOLINIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.GALLIUM_DUST.get(), TekoraTags.Items.GALLIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.HAFNIUM_DUST.get(), TekoraTags.Items.HAFNIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.HOLMIUM_DUST.get(), TekoraTags.Items.HOLMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.INDIUM_DUST.get(), TekoraTags.Items.INDIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.IRIDIUM_DUST.get(), TekoraTags.Items.IRIDIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.LANTHANUM_DUST.get(), TekoraTags.Items.LANTHANUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.LEAD_DUST.get(), TekoraTags.Items.LEAD_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.LUTETIUM_DUST.get(), TekoraTags.Items.LUTETIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.MAGNESIUM_DUST.get(), TekoraTags.Items.MAGNESIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.MANGANESE_DUST.get(), TekoraTags.Items.MANGANESE_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.MOLYBDENUM_DUST.get(), TekoraTags.Items.MOLYBDENUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.NEODYMIUM_DUST.get(), TekoraTags.Items.NEODYMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.NICKEL_DUST.get(), TekoraTags.Items.NICKEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.NIOBIUM_DUST.get(), TekoraTags.Items.NIOBIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.OSMIUM_DUST.get(), TekoraTags.Items.OSMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.PALLADIUM_DUST.get(), TekoraTags.Items.PALLADIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.PLATINUM_DUST.get(), TekoraTags.Items.PLATINUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.PRASEODYMIUM_DUST.get(), TekoraTags.Items.PRASEODYMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.RHENIUM_DUST.get(), TekoraTags.Items.RHENIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.RHODIUM_DUST.get(), TekoraTags.Items.RHODIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.RUTHENIUM_DUST.get(), TekoraTags.Items.RUTHENIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.SCANDIUM_DUST.get(), TekoraTags.Items.SCANDIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.SAMARIUM_DUST.get(), TekoraTags.Items.SAMARIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.STRONTIUM_DUST.get(), TekoraTags.Items.STRONTIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.SILVER_DUST.get(), TekoraTags.Items.SILVER_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TANTALUM_DUST.get(), TekoraTags.Items.TANTALUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TERBIUM_DUST.get(), TekoraTags.Items.TERBIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.THALLIUM_DUST.get(), TekoraTags.Items.THALLIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.THORIUM_DUST.get(), TekoraTags.Items.THORIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.THULIUM_DUST.get(), TekoraTags.Items.THULIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TIN_DUST.get(), TekoraTags.Items.TIN_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TITANIUM_DUST.get(), TekoraTags.Items.TITANIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_DUST.get(), TekoraTags.Items.TUNGSTEN_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.URANIUM_DUST.get(), TekoraTags.Items.URANIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.VANADIUM_DUST.get(), TekoraTags.Items.VANADIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.YTTERBIUM_DUST.get(), TekoraTags.Items.YTTERBIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.YTTRIUM_DUST.get(), TekoraTags.Items.YTTRIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.ZINC_DUST.get(), TekoraTags.Items.ZINC_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.ZIRCONIUM_DUST.get(), TekoraTags.Items.ZIRCONIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.BRASS_DUST.get(), TekoraTags.Items.BRASS_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.BRONZE_DUST.get(), TekoraTags.Items.BRONZE_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CARBON_STEEL_DUST.get(), TekoraTags.Items.CARBON_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CHROMOLY_STEEL_DUST.get(), TekoraTags.Items.CHROMOLY_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.CUPRONICKEL_DUST.get(), TekoraTags.Items.CUPRONICKEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.ELECTRUM_DUST.get(), TekoraTags.Items.ELECTRUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.FERROBORON_DUST.get(), TekoraTags.Items.FERROBORON_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.HSLA_STEEL_DUST.get(), TekoraTags.Items.HSLA_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.INCONEL_DUST.get(), TekoraTags.Items.INCONEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.INVAR_DUST.get(), TekoraTags.Items.INVAR_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.MAGNETIC_NEODYMIUM_DUST.get(), TekoraTags.Items.MAGNETIC_NEODYMIUM_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.MU_METAL_DUST.get(), TekoraTags.Items.MU_METAL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.REACTOR_STEEL_DUST.get(), TekoraTags.Items.REACTOR_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.STAINLESS_STEEL_DUST.get(), TekoraTags.Items.STAINLESS_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.STEEL_DUST.get(), TekoraTags.Items.STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_CARBIDE_DUST.get(), TekoraTags.Items.TUNGSTEN_CARBIDE_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.TUNGSTEN_STEEL_DUST.get(), TekoraTags.Items.TUNGSTEN_STEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.VANASTEEL_DUST.get(), TekoraTags.Items.VANASTEEL_TINY_DUST);
        storageBlockRecipe(pWriter, TekoraItems.ZIRCALOY_DUST.get(), TekoraTags.Items.ZIRCALOY_TINY_DUST);

        storageBlockRecipe(pWriter, TekoraBlocks.RAW_LEAD_BLOCK.get(), TekoraTags.Items.RAW_LEAD);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_NICKEL_BLOCK.get(), TekoraTags.Items.RAW_NICKEL);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_PLATINUM_BLOCK.get(), TekoraTags.Items.RAW_PLATINUM);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_SILVER_BLOCK.get(), TekoraTags.Items.RAW_SILVER);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_TIN_BLOCK.get(), TekoraTags.Items.RAW_TIN);
        storageBlockRecipe(pWriter, TekoraBlocks.RAW_ZINC_BLOCK.get(), TekoraTags.Items.RAW_ZINC);

        storageBlockRecipe(pWriter, TekoraBlocks.AQUAMARINE_BLOCK.get(), TekoraTags.Items.AQUAMARINE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.BAUXITE_BLOCK.get(), TekoraTags.Items.BAUXITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.CHROMITE_BLOCK.get(), TekoraTags.Items.CHROMITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.CINNABAR_BLOCK.get(), TekoraTags.Items.CINNABAR_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.COLTAN_BLOCK.get(), TekoraTags.Items.COLTAN_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.DOLOMITE_BLOCK.get(), TekoraItems.DOLOMITE.get());
        storageBlockRecipe(pWriter, TekoraBlocks.FLUORITE_BLOCK.get(), TekoraItems.FLUORITE.get());
        storageBlockRecipe(pWriter, TekoraBlocks.HALITE_BLOCK.get(), TekoraTags.Items.HALITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.MONAZITE_BLOCK.get(), TekoraTags.Items.MONAZITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.RUBY_BLOCK.get(), TekoraTags.Items.RUBY_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.RUTILE_BLOCK.get(), TekoraTags.Items.RUTILE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.SAPPHIRE_BLOCK.get(), TekoraTags.Items.SAPPHIRE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.URANINITE_BLOCK.get(), TekoraTags.Items.URANINITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.WOLFRAMITE_BLOCK.get(), TekoraTags.Items.WOLFRAMITE_GEM);
        storageBlockRecipe(pWriter, TekoraBlocks.ZIRCON_BLOCK.get(), TekoraTags.Items.ZIRCON_GEM);

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
        nineBlockStorageRecipes(pWriter, TekoraItems.COPPER_NUGGET.get(), Tags.Items.INGOTS_COPPER);
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
        nineBlockStorageRecipes(pWriter, TekoraItems.BRASS_NUGGET.get(), TekoraTags.Items.BRASS_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.BRONZE_NUGGET.get(), TekoraTags.Items.BRONZE_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CARBON_STEEL_NUGGET.get(), TekoraTags.Items.CARBON_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMOLY_STEEL_NUGGET.get(), TekoraTags.Items.CHROMOLY_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.CUPRONICKEL_NUGGET.get(), TekoraTags.Items.CUPRONICKEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.ELECTRUM_NUGGET.get(), TekoraTags.Items.ELECTRUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.FERROBORON_NUGGET.get(), TekoraTags.Items.FERROBORON_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.HSLA_STEEL_NUGGET.get(), TekoraTags.Items.HSLA_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.INCONEL_NUGGET.get(), TekoraTags.Items.INCONEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.INVAR_NUGGET.get(), TekoraTags.Items.INVAR_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNETIC_NEODYMIUM_NUGGET.get(), TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.MU_METAL_NUGGET.get(), TekoraTags.Items.MU_METAL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.REACTOR_STEEL_NUGGET.get(), TekoraTags.Items.REACTOR_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.STAINLESS_STEEL_NUGGET.get(), TekoraTags.Items.STAINLESS_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.STEEL_NUGGET.get(), TekoraTags.Items.STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_CARBIDE_NUGGET.get(), TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_STEEL_NUGGET.get(), TekoraTags.Items.TUNGSTEN_STEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.VANASTEEL_NUGGET.get(), TekoraTags.Items.VANASTEEL_INGOT);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCALOY_NUGGET.get(), TekoraTags.Items.ZIRCALOY_INGOT);

        nineBlockStorageRecipes(pWriter, TekoraItems.ANTIMONY_PIECE.get(), TekoraTags.Items.ANTIMONY_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ARSENIC_PIECE.get(), TekoraTags.Items.ARSENIC_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BORON_PIECE.get(), TekoraTags.Items.BORON_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.GERMANIUM_PIECE.get(), TekoraTags.Items.GERMANIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILICON_PIECE.get(), TekoraTags.Items.SILICON_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.TELLURIUM_PIECE.get(), TekoraTags.Items.TELLURIUM_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.AQUAMARINE.get(), TekoraTags.Items.AQUAMARINE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.BAUXITE.get(), TekoraTags.Items.BAUXITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMITE.get(), TekoraTags.Items.CHROMITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.CINNABAR.get(), TekoraTags.Items.CINNABAR_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.COLTAN.get(), TekoraTags.Items.COLTAN_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.DOLOMITE.get(), TekoraTags.Items.DOLOMITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.FLUORITE.get(), TekoraTags.Items.FLUORITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.HALITE.get(), TekoraTags.Items.HALITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.MONAZITE.get(), TekoraTags.Items.MONAZITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUBY.get(), TekoraTags.Items.RUBY_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUTILE.get(), TekoraTags.Items.RUTILE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.SAPPHIRE.get(), TekoraTags.Items.SAPPHIRE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.URANINITE.get(), TekoraTags.Items.URANINITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.WOLFRAMITE.get(), TekoraTags.Items.WOLFRAMITE_BLOCK);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCON.get(), TekoraTags.Items.ZIRCON_BLOCK);

        nineBlockStorageRecipes(pWriter, TekoraItems.ALUMINUM_TINY_DUST.get(), TekoraTags.Items.ALUMINUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.BARIUM_TINY_DUST.get(), TekoraTags.Items.BARIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.BERYLLIUM_TINY_DUST.get(), TekoraTags.Items.BERYLLIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.BISMUTH_TINY_DUST.get(), TekoraTags.Items.BISMUTH_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CADMIUM_TINY_DUST.get(), TekoraTags.Items.CADMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CALCIUM_TINY_DUST.get(), TekoraTags.Items.CALCIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CERIUM_TINY_DUST.get(), TekoraTags.Items.CERIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMIUM_TINY_DUST.get(), TekoraTags.Items.CHROMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.COBALT_TINY_DUST.get(), TekoraTags.Items.COBALT_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.DYSPROSIUM_TINY_DUST.get(), TekoraTags.Items.DYSPROSIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.ERBIUM_TINY_DUST.get(), TekoraTags.Items.ERBIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.EUROPIUM_TINY_DUST.get(), TekoraTags.Items.EUROPIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.GADOLINIUM_TINY_DUST.get(), TekoraTags.Items.GADOLINIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.GALLIUM_TINY_DUST.get(), TekoraTags.Items.GALLIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.HAFNIUM_TINY_DUST.get(), TekoraTags.Items.HAFNIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.HOLMIUM_TINY_DUST.get(), TekoraTags.Items.HOLMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.INDIUM_TINY_DUST.get(), TekoraTags.Items.INDIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.IRIDIUM_TINY_DUST.get(), TekoraTags.Items.IRIDIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.LANTHANUM_TINY_DUST.get(), TekoraTags.Items.LANTHANUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.LEAD_TINY_DUST.get(), TekoraTags.Items.LEAD_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.LUTETIUM_TINY_DUST.get(), TekoraTags.Items.LUTETIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNESIUM_TINY_DUST.get(), TekoraTags.Items.MAGNESIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.MANGANESE_TINY_DUST.get(), TekoraTags.Items.MANGANESE_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.MOLYBDENUM_TINY_DUST.get(), TekoraTags.Items.MOLYBDENUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.NEODYMIUM_TINY_DUST.get(), TekoraTags.Items.NEODYMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.NICKEL_TINY_DUST.get(), TekoraTags.Items.NICKEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.NIOBIUM_TINY_DUST.get(), TekoraTags.Items.NIOBIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.OSMIUM_TINY_DUST.get(), TekoraTags.Items.OSMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.PALLADIUM_TINY_DUST.get(), TekoraTags.Items.PALLADIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.PLATINUM_TINY_DUST.get(), TekoraTags.Items.PLATINUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.PRASEODYMIUM_TINY_DUST.get(), TekoraTags.Items.PRASEODYMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHENIUM_TINY_DUST.get(), TekoraTags.Items.RHENIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.RHODIUM_TINY_DUST.get(), TekoraTags.Items.RHODIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.RUTHENIUM_TINY_DUST.get(), TekoraTags.Items.RUTHENIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.SCANDIUM_TINY_DUST.get(), TekoraTags.Items.SCANDIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.SAMARIUM_TINY_DUST.get(), TekoraTags.Items.SAMARIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.STRONTIUM_TINY_DUST.get(), TekoraTags.Items.STRONTIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.SILVER_TINY_DUST.get(), TekoraTags.Items.SILVER_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TANTALUM_TINY_DUST.get(), TekoraTags.Items.TANTALUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TERBIUM_TINY_DUST.get(), TekoraTags.Items.TERBIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.THALLIUM_TINY_DUST.get(), TekoraTags.Items.THALLIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.THORIUM_TINY_DUST.get(), TekoraTags.Items.THORIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.THULIUM_TINY_DUST.get(), TekoraTags.Items.THULIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TIN_TINY_DUST.get(), TekoraTags.Items.TIN_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TITANIUM_TINY_DUST.get(), TekoraTags.Items.TITANIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_TINY_DUST.get(), TekoraTags.Items.TUNGSTEN_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.URANIUM_TINY_DUST.get(), TekoraTags.Items.URANIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.VANADIUM_TINY_DUST.get(), TekoraTags.Items.VANADIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTERBIUM_TINY_DUST.get(), TekoraTags.Items.YTTERBIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.YTTRIUM_TINY_DUST.get(), TekoraTags.Items.YTTRIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZINC_TINY_DUST.get(), TekoraTags.Items.ZINC_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCONIUM_TINY_DUST.get(), TekoraTags.Items.ZIRCONIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.BRASS_TINY_DUST.get(), TekoraTags.Items.BRASS_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.BRONZE_TINY_DUST.get(), TekoraTags.Items.BRONZE_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CARBON_STEEL_TINY_DUST.get(), TekoraTags.Items.CARBON_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CHROMOLY_STEEL_TINY_DUST.get(), TekoraTags.Items.CHROMOLY_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.CUPRONICKEL_TINY_DUST.get(), TekoraTags.Items.CUPRONICKEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.ELECTRUM_TINY_DUST.get(), TekoraTags.Items.ELECTRUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.FERROBORON_TINY_DUST.get(), TekoraTags.Items.FERROBORON_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.HSLA_STEEL_TINY_DUST.get(), TekoraTags.Items.HSLA_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.INCONEL_TINY_DUST.get(), TekoraTags.Items.INCONEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.INVAR_TINY_DUST.get(), TekoraTags.Items.INVAR_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST.get(), TekoraTags.Items.MAGNETIC_NEODYMIUM_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.MU_METAL_TINY_DUST.get(), TekoraTags.Items.MU_METAL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.REACTOR_STEEL_TINY_DUST.get(), TekoraTags.Items.REACTOR_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.STAINLESS_STEEL_TINY_DUST.get(), TekoraTags.Items.STAINLESS_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.STEEL_TINY_DUST.get(), TekoraTags.Items.STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST.get(), TekoraTags.Items.TUNGSTEN_CARBIDE_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.TUNGSTEN_STEEL_TINY_DUST.get(), TekoraTags.Items.TUNGSTEN_STEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.VANASTEEL_TINY_DUST.get(), TekoraTags.Items.VANASTEEL_DUST);
        nineBlockStorageRecipes(pWriter, TekoraItems.ZIRCALOY_TINY_DUST.get(), TekoraTags.Items.ZIRCALOY_DUST);

        compressionRecipe(pWriter, TekoraTags.Items.ALUMINUM_INGOT, TekoraItems.ALUMINUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.BISMUTH_INGOT, TekoraItems.BISMUTH_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.CADMIUM_INGOT, TekoraItems.CADMIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.CHROMIUM_INGOT, TekoraItems.CHROMIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.COBALT_INGOT, TekoraItems.COBALT_PLATE.get());
        compressionRecipe(pWriter, Tags.Items.INGOTS_COPPER, TekoraItems.COPPER_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.CUPRONICKEL_INGOT, TekoraItems.CUPRONICKEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.ELECTRUM_INGOT, TekoraItems.ELECTRUM_PLATE.get());
        compressionRecipe(pWriter, Tags.Items.INGOTS_GOLD, TekoraItems.GOLD_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.INDIUM_INGOT, TekoraItems.INDIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.IRIDIUM_INGOT, TekoraItems.IRIDIUM_PLATE.get());
        compressionRecipe(pWriter, Tags.Items.INGOTS_IRON, TekoraItems.IRON_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.LEAD_INGOT, TekoraItems.LEAD_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.MAGNESIUM_INGOT, TekoraItems.MAGNESIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.MANGANESE_INGOT, TekoraItems.MANGANESE_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.MOLYBDENUM_INGOT, TekoraItems.MOLYBDENUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.NICKEL_INGOT, TekoraItems.NICKEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.NIOBIUM_INGOT, TekoraItems.NIOBIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.OSMIUM_INGOT, TekoraItems.OSMIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.PALLADIUM_INGOT, TekoraItems.PALLADIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.PLATINUM_INGOT, TekoraItems.PLATINUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.RHODIUM_INGOT, TekoraItems.RHODIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.SCANDIUM_INGOT, TekoraItems.SCANDIUM_PLATE.get());;
        compressionRecipe(pWriter, TekoraTags.Items.SILVER_INGOT, TekoraItems.SILVER_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.THORIUM_INGOT, TekoraItems.THORIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.THULIUM_INGOT, TekoraItems.THULIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TIN_INGOT, TekoraItems.TIN_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TITANIUM_INGOT, TekoraItems.TITANIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TUNGSTEN_INGOT, TekoraItems.TUNGSTEN_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.YTTERBIUM_INGOT, TekoraItems.YTTERBIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.ZINC_INGOT, TekoraItems.ZINC_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.ZIRCONIUM_INGOT, TekoraItems.ZIRCONIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.BRASS_INGOT, TekoraItems.BRASS_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.BRONZE_INGOT, TekoraItems.BRONZE_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.CHROMOLY_STEEL_INGOT, TekoraItems.CHROMOLY_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.FERROBORON_INGOT, TekoraItems.FERROBORON_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.GALVANIZED_STEEL_INGOT, TekoraItems.GALVANIZED_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.HSLA_STEEL_INGOT, TekoraItems.HSLA_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.INCONEL_INGOT, TekoraItems.INCONEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.INVAR_INGOT, TekoraItems.INVAR_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT, TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.MU_METAL_INGOT, TekoraItems.MU_METAL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.REACTOR_STEEL_INGOT, TekoraItems.REACTOR_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.STAINLESS_STEEL_INGOT, TekoraItems.STAINLESS_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.STEEL_INGOT, TekoraItems.STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT, TekoraItems.TUNGSTEN_CARBIDE_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TUNGSTEN_STEEL_INGOT, TekoraItems.TUNGSTEN_STEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.VANASTEEL_INGOT, TekoraItems.VANASTEEL_PLATE.get());
        compressionRecipe(pWriter, TekoraTags.Items.ZIRCALOY_INGOT, TekoraItems.ZIRCALOY_PLATE.get());

        compressionRecipe(pWriter, TekoraTags.Items.ARSENIC_DUST, TekoraItems.ARSENIC_PIECE.get());
        compressionRecipe(pWriter, TekoraTags.Items.ANTIMONY_DUST, TekoraItems.ANTIMONY_PIECE.get());
        compressionRecipe(pWriter, TekoraTags.Items.BORON_DUST, TekoraItems.BORON_PIECE.get());
        compressionRecipe(pWriter, TekoraTags.Items.GERMANIUM_DUST, TekoraItems.GERMANIUM_PIECE.get());
        compressionRecipe(pWriter, TekoraTags.Items.SILICON_DUST, TekoraItems.SILICON_PIECE.get());
        compressionRecipe(pWriter, TekoraTags.Items.TELLURIUM_DUST, TekoraItems.TELLURIUM_PIECE.get());

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.BASIC_WRENCH.get())
                .pattern("0 0")
                .pattern("010")
                .pattern(" 0 ")
                .define('0', TekoraTags.Items.IRON_PLATE).define('1', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(TekoraItems.IRON_PLATE.get()), has(TekoraItems.IRON_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":basic_wrench_from_crafting");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TekoraItems.ADVANCED_WRENCH.get())
                .pattern("0 0")
                .pattern("010")
                .pattern(" 0 ")
                .define('0', TekoraTags.Items.VANASTEEL_PLATE).define('1', TekoraItems.STEEL_PLATE.get())
                .unlockedBy(getHasName(TekoraItems.VANASTEEL_PLATE.get()), has(TekoraItems.VANASTEEL_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":advanced_wrench_from_crafting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)
                .requires(TekoraTags.Items.GOLD_PLATE)
                .unlockedBy(getHasName(TekoraItems.GOLD_PLATE.get()), has(TekoraItems.GOLD_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":light_weighted_pressure_plate_from_plate");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .requires(TekoraTags.Items.IRON_PLATE)
                .unlockedBy(getHasName(TekoraItems.IRON_PLATE.get()), has(TekoraItems.IRON_PLATE.get()))
                .save(pWriter, Tekora.MODID + ":heavy_weighted_pressure_plate_from_plate");

        CompressionRecipeBuilder.basic(new ItemStack(TekoraItems.GRAPHITE_BAR.get()), Ingredient.of(TekoraTags.Items.GRAPHITE_DUST))
                .save(pWriter, "tekora:graphite_bar_from_compression");
        CompressionRecipeBuilder.basic(new ItemStack(TekoraItems.IODINE_BAR.get()), Ingredient.of(TekoraTags.Items.IODINE_DUST))
                .save(pWriter, "tekora:iodine_bar_from_compression");

        PulverizingRecipeBuilder.create(new ItemStack(TekoraItems.COPPER_DUST.get()), Ingredient.of(Tags.Items.RAW_MATERIALS_COPPER))
                .save(pWriter, Tekora.MODID + ":copper_from_raw_pulverization");
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GOLD_DUST.get()),
                new ItemStack(TekoraItems.SILVER_TINY_DUST.get()), Ingredient.of(Tags.Items.RAW_MATERIALS_GOLD));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRON_DUST.get()),
                new ItemStack(TekoraItems.MANGANESE_TINY_DUST.get()), Ingredient.of(Tags.Items.RAW_MATERIALS_IRON));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LEAD_DUST.get()),
                new ItemStack(TekoraItems.SILVER_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RAW_LEAD));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NICKEL_DUST.get()),
                new ItemStack(TekoraItems.COBALT_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RAW_NICKEL));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILVER_DUST.get()),
                new ItemStack(TekoraItems.ANTIMONY_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RAW_SILVER));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TIN_DUST.get()),
                new ItemStack(TekoraItems.WOLFRAMITE_PIECE.get()), Ingredient.of(TekoraTags.Items.RAW_TIN));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZINC_DUST.get()), Ingredient.of(TekoraTags.Items.RAW_ZINC));

        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ALUMINUM_DUST.get()), Ingredient.of(TekoraTags.Items.ALUMINUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BARIUM_DUST.get()), Ingredient.of(TekoraTags.Items.BARIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BERYLLIUM_DUST.get()), Ingredient.of(TekoraTags.Items.BERYLLIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BISMUTH_DUST.get()), Ingredient.of(TekoraTags.Items.BISMUTH_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CADMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CADMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CALCIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CALCIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CERIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CERIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CESIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CESIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COBALT_DUST.get()), Ingredient.of(TekoraTags.Items.COBALT_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_DUST.get()), Ingredient.of(Tags.Items.INGOTS_COPPER));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.DYSPROSIUM_DUST.get()), Ingredient.of(TekoraTags.Items.DYSPROSIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ERBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.ERBIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.EUROPIUM_DUST.get()), Ingredient.of(TekoraTags.Items.EUROPIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GADOLINIUM_DUST.get()), Ingredient.of(TekoraTags.Items.GADOLINIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GALLIUM_DUST.get()), Ingredient.of(TekoraTags.Items.GALLIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GOLD_DUST.get()), Ingredient.of(Tags.Items.INGOTS_GOLD));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HAFNIUM_DUST.get()), Ingredient.of(TekoraTags.Items.HAFNIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HOLMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.HOLMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.INDIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRIDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.IRIDIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRON_DUST.get()), Ingredient.of(Tags.Items.INGOTS_IRON));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LANTHANUM_DUST.get()), Ingredient.of(TekoraTags.Items.LANTHANUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LITHIUM_DUST.get()), Ingredient.of(TekoraTags.Items.LITHIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LEAD_DUST.get()), Ingredient.of(TekoraTags.Items.LEAD_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LUTETIUM_DUST.get()), Ingredient.of(TekoraTags.Items.LUTETIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNESIUM_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNESIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MANGANESE_DUST.get()), Ingredient.of(TekoraTags.Items.MANGANESE_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MOLYBDENUM_DUST.get()), Ingredient.of(TekoraTags.Items.MOLYBDENUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NEODYMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.NEODYMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NICKEL_DUST.get()), Ingredient.of(TekoraTags.Items.NICKEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NIOBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.NIOBIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.OSMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.OSMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PALLADIUM_DUST.get()), Ingredient.of(TekoraTags.Items.PALLADIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PLATINUM_DUST.get()), Ingredient.of(TekoraTags.Items.PLATINUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.POTASSIUM_DUST.get()), Ingredient.of(TekoraTags.Items.POTASSIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PRASEODYMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.PRASEODYMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RHENIUM_DUST.get()), Ingredient.of(TekoraTags.Items.RHENIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RHODIUM_DUST.get()), Ingredient.of(TekoraTags.Items.RHODIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RUBIDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.RUBIDIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RUTHENIUM_DUST.get()), Ingredient.of(TekoraTags.Items.RUTHENIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SAMARIUM_DUST.get()), Ingredient.of(TekoraTags.Items.SAMARIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SCANDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.SCANDIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILVER_DUST.get()), Ingredient.of(TekoraTags.Items.SILVER_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SODIUM_DUST.get()), Ingredient.of(TekoraTags.Items.SODIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STRONTIUM_DUST.get()), Ingredient.of(TekoraTags.Items.STRONTIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TANTALUM_DUST.get()), Ingredient.of(TekoraTags.Items.TANTALUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TERBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.TERBIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THALLIUM_DUST.get()), Ingredient.of(TekoraTags.Items.THALLIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THORIUM_DUST.get()), Ingredient.of(TekoraTags.Items.THORIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THULIUM_DUST.get()), Ingredient.of(TekoraTags.Items.THULIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TIN_DUST.get()), Ingredient.of(TekoraTags.Items.TIN_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TITANIUM_DUST.get()), Ingredient.of(TekoraTags.Items.TITANIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.VANADIUM_DUST.get()), Ingredient.of(TekoraTags.Items.VANADIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.URANIUM_DUST.get()), Ingredient.of(TekoraTags.Items.URANIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.YTTERBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.YTTERBIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.YTTRIUM_DUST.get()), Ingredient.of(TekoraTags.Items.YTTRIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCONIUM_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCONIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ARSENIC_DUST.get()), Ingredient.of((TekoraItems.ARSENIC_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ANTIMONY_DUST.get()), Ingredient.of((TekoraItems.ANTIMONY_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BORON_DUST.get()), Ingredient.of((TekoraItems.BORON_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GERMANIUM_DUST.get()), Ingredient.of((TekoraItems.GERMANIUM_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILICON_DUST.get()), Ingredient.of(TekoraItems.SILICON_PIECE.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TELLURIUM_DUST.get()), Ingredient.of(TekoraItems.TELLURIUM_PIECE.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRASS_DUST.get()), Ingredient.of(TekoraTags.Items.BRASS_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRONZE_DUST.get()), Ingredient.of(TekoraTags.Items.BRONZE_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CARBON_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.CARBON_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMOLY_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMOLY_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_STEEL_DUST.get()), Ingredient.of(TekoraItems.COPPER_STEEL.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CUPRONICKEL_DUST.get()), Ingredient.of(TekoraTags.Items.CUPRONICKEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ELECTRUM_DUST.get()), Ingredient.of(TekoraTags.Items.ELECTRUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.FERROBORON_DUST.get()), Ingredient.of(TekoraTags.Items.FERROBORON_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HSLA_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.HSLA_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INCONEL_DUST.get()), Ingredient.of(TekoraTags.Items.INCONEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INVAR_DUST.get()), Ingredient.of(TekoraTags.Items.INVAR_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNETIC_NEODYMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNETIC_NEODYMIUM_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MU_METAL_DUST.get()), Ingredient.of(TekoraTags.Items.MU_METAL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.REACTOR_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.REACTOR_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STAINLESS_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.STAINLESS_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_CARBIDE_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_CARBIDE_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.VANASTEEL_DUST.get()), Ingredient.of(TekoraTags.Items.VANASTEEL_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCALOY_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCALOY_INGOT));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GRAPHITE_DUST.get()), Ingredient.of(TekoraItems.GRAPHITE_BAR.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IODINE_DUST.get()), Ingredient.of(TekoraItems.IODINE_BAR.get()));

        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ALUMINUM_DUST.get()), Ingredient.of(TekoraTags.Items.ALUMINUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BISMUTH_DUST.get()), Ingredient.of(TekoraTags.Items.BISMUTH_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CADMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CADMIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COBALT_DUST.get()), Ingredient.of(TekoraTags.Items.COBALT_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_DUST.get()), Ingredient.of(TekoraTags.Items.COPPER_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GOLD_DUST.get()), Ingredient.of(TekoraTags.Items.GOLD_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRON_DUST.get()), Ingredient.of(TekoraTags.Items.IRON_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.INDIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRIDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.IRIDIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LEAD_DUST.get()), Ingredient.of(TekoraTags.Items.LEAD_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNESIUM_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNESIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MANGANESE_DUST.get()), Ingredient.of(TekoraTags.Items.MANGANESE_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MOLYBDENUM_DUST.get()), Ingredient.of(TekoraTags.Items.MOLYBDENUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NICKEL_DUST.get()), Ingredient.of(TekoraTags.Items.NICKEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NIOBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.NIOBIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.OSMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.OSMIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PALLADIUM_DUST.get()), Ingredient.of(TekoraTags.Items.PALLADIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PLATINUM_DUST.get()), Ingredient.of(TekoraTags.Items.PLATINUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RHODIUM_DUST.get()), Ingredient.of(TekoraTags.Items.RHODIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SCANDIUM_DUST.get()), Ingredient.of(TekoraTags.Items.SCANDIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILVER_DUST.get()), Ingredient.of(TekoraTags.Items.SILVER_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THORIUM_DUST.get()), Ingredient.of(TekoraTags.Items.THORIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THULIUM_DUST.get()), Ingredient.of(TekoraTags.Items.THULIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TIN_DUST.get()), Ingredient.of(TekoraTags.Items.TIN_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TITANIUM_DUST.get()), Ingredient.of(TekoraTags.Items.TITANIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.YTTERBIUM_DUST.get()), Ingredient.of(TekoraTags.Items.YTTERBIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCONIUM_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCONIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ARSENIC_DUST.get()), Ingredient.of((TekoraItems.ARSENIC_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ANTIMONY_DUST.get()), Ingredient.of((TekoraItems.ANTIMONY_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BORON_DUST.get()), Ingredient.of((TekoraItems.BORON_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GERMANIUM_DUST.get()), Ingredient.of((TekoraItems.GERMANIUM_PIECE.get())));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILICON_DUST.get()), Ingredient.of(TekoraItems.SILICON_PIECE.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TELLURIUM_DUST.get()), Ingredient.of(TekoraItems.TELLURIUM_PIECE.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRASS_DUST.get()), Ingredient.of(TekoraTags.Items.BRASS_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRONZE_DUST.get()), Ingredient.of(TekoraTags.Items.BRONZE_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMOLY_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMOLY_STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_STEEL_DUST.get()), Ingredient.of(TekoraItems.COPPER_STEEL.get()));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CUPRONICKEL_DUST.get()), Ingredient.of(TekoraTags.Items.CUPRONICKEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ELECTRUM_DUST.get()), Ingredient.of(TekoraTags.Items.ELECTRUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.FERROBORON_DUST.get()), Ingredient.of(TekoraTags.Items.FERROBORON_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HSLA_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.HSLA_STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INCONEL_DUST.get()), Ingredient.of(TekoraTags.Items.INCONEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INVAR_DUST.get()), Ingredient.of(TekoraTags.Items.INVAR_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNETIC_NEODYMIUM_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNETIC_NEODYMIUM_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MU_METAL_DUST.get()), Ingredient.of(TekoraTags.Items.MU_METAL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.REACTOR_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.REACTOR_STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STAINLESS_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.STAINLESS_STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_CARBIDE_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_CARBIDE_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_STEEL_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.VANASTEEL_DUST.get()), Ingredient.of(TekoraTags.Items.VANASTEEL_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCALOY_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCALOY_PLATE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ALUMINUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.ALUMINUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BARIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.BARIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BERYLLIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.BERYLLIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BISMUTH_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.BISMUTH_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CADMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CADMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CALCIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CALCIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CERIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CERIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CESIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CESIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COBALT_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.COBALT_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.COPPER_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.DYSPROSIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.DYSPROSIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ERBIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.ERBIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.EUROPIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.EUROPIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GADOLINIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.GADOLINIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GALLIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.GALLIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GOLD_TINY_DUST.get()), Ingredient.of(Tags.Items.NUGGETS_GOLD));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HAFNIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.HAFNIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HOLMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.HOLMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INDIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.INDIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRIDIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.IRIDIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.IRON_TINY_DUST.get()), Ingredient.of(Tags.Items.NUGGETS_IRON));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LANTHANUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.LANTHANUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LITHIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.LITHIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LEAD_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.LEAD_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.LUTETIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.LUTETIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNESIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNESIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MANGANESE_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.MANGANESE_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MOLYBDENUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.MOLYBDENUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NEODYMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.NEODYMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NICKEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.NICKEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.NIOBIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.NIOBIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.OSMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.OSMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PALLADIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.PALLADIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PLATINUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.PLATINUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.POTASSIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.POTASSIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.PRASEODYMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.PRASEODYMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RHENIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RHENIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RHODIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RHODIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RUBIDIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RUBIDIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.RUTHENIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.RUTHENIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SAMARIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.SAMARIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SCANDIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.SCANDIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILVER_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.SILVER_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SODIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.SODIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STRONTIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.STRONTIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TANTALUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TANTALUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TERBIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TERBIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THALLIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.THALLIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THORIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.THORIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.THULIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.THULIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TIN_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TIN_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TITANIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TITANIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.VANADIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.VANADIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.URANIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.URANIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.YTTERBIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.YTTERBIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.YTTRIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.YTTRIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCONIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCONIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRASS_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.BRASS_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.BRONZE_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.BRONZE_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CARBON_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CARBON_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CHROMOLY_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CHROMOLY_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CUPRONICKEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.CUPRONICKEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ELECTRUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.ELECTRUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.FERROBORON_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.FERROBORON_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.HSLA_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.HSLA_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INCONEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.INCONEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.INVAR_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.INVAR_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.MAGNETIC_NEODYMIUM_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.MU_METAL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.MU_METAL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.REACTOR_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.REACTOR_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STAINLESS_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.STAINLESS_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_CARBIDE_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TUNGSTEN_STEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.TUNGSTEN_STEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.VANASTEEL_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.VANASTEEL_NUGGET));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ZIRCALOY_TINY_DUST.get()), Ingredient.of(TekoraTags.Items.ZIRCALOY_NUGGET));

        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ALUMINUM_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.ALUMINUM_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.COPPER_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.COPPER_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CUPRONICKEL_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.CUPRONICKEL_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.ELECTRUM_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.ELECTRUM_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.GOLD_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.GOLD_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.SILVER_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.SILVER_WIRE));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.TIN_TINY_DUST.get(), 3), Ingredient.of(TekoraTags.Items.TIN_WIRE));

        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.CARBON_STEEL_TINY_DUST.get(), 4), Ingredient.of(TekoraTags.Items.CARBON_STEEL_ROD));
        createPulverizingRecipe(pWriter, new ItemStack(TekoraItems.STEEL_TINY_DUST.get(), 4), Ingredient.of(TekoraTags.Items.STEEL_ROD));

        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.ALUMINUM_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.ALUMINUM_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.COPPER_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.COPPER_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.CUPRONICKEL_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.CUPRONICKEL_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.ELECTRUM_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.ELECTRUM_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.GOLD_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.GOLD_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.SILVER_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.SILVER_PLATE));
        createExtrusionRecipe(pWriter, new ItemStack(TekoraItems.TIN_WIRE.get(), 3), Ingredient.of(TekoraTags.Items.TIN_PLATE));
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

    protected static void compressionRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pInput, ItemLike pResult) {
        compressionRecipe(pWriter, Ingredient.of(pInput), pResult);
    }

    protected static void compressionRecipe(Consumer<FinishedRecipe> pWriter, TagKey<Item> pInput, ItemLike pResult) {
        compressionRecipe(pWriter, Ingredient.of(pInput), pResult);
    }

    protected static void compressionRecipe(Consumer<FinishedRecipe> pWriter, Ingredient pInput, ItemLike pResult) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
                .requires(pInput).requires(TekoraTags.Items.HAMMER).group(pResult.asItem().toString())
                .unlockedBy(getHasName(TekoraItems.IRON_HAMMER.get()), has(TekoraItems.IRON_HAMMER.get()))
                .save(pWriter, getItemName(pResult) + "_from_hammer");

        CompressionRecipeBuilder.basic(new ItemStack(pResult), pInput, 1)
                .save(pWriter, Tekora.MODID + ":" + getItemName(pResult) + "_from_compression");
    }

    protected static void createPulverizingRecipe(Consumer<FinishedRecipe> pWriter, ItemStack pResult, Ingredient pIng) {
        PulverizingRecipeBuilder.create(pResult, 0.5f, pIng)
                .save(pWriter, Tekora.MODID + ":" + getItemName(pResult.getItem()) + "_from_pulverization" + pIng.hashCode());
    }

    protected static void createPulverizingRecipe(Consumer<FinishedRecipe> pWriter, ItemStack pResult, ItemStack pResidue, Ingredient pIng) {
        PulverizingRecipeBuilder.create(pResult, 0.5f, pResidue, 0.25f, pIng)
                .save(pWriter, Tekora.MODID + ":" + getItemName(pResult.getItem()) + "_and_" + getItemName(pResidue.getItem()) + "_from_pulverization");
    }

    protected static void createExtrusionRecipe(Consumer<FinishedRecipe> pWriter, ItemStack pResult, Ingredient pIng) {
        ExtrusionRecipeBuilder.basic(pResult, pIng).save(pWriter, Tekora.MODID + ":" + getItemName(pResult.getItem()) + "_from_extrusion");
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
