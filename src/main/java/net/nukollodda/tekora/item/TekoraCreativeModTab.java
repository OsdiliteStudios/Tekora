package net.nukollodda.tekora.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;

public class TekoraCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tekora.MODID);

    public static RegistryObject<CreativeModeTab> TEKORA_MACHINES = CREATIVE_MODE_TABS.register("tekora_machines", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraBlocks.ALLOY_FURNACE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_machines"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraBlocks.ALLOY_FURNACE.get());
                        pOutput.accept(TekoraBlocks.CRUSHER.get());
                        pOutput.accept(TekoraBlocks.INFUSION_FURNACE.get());
                        pOutput.accept(TekoraBlocks.ELECTRIC_FURNACE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_BLOCKS = CREATIVE_MODE_TABS.register("tekora_blocks", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraBlocks.BAUXITE_ORE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_blocks"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraBlocks.BORAX_BLOCK.get());
                        pOutput.accept(TekoraBlocks.EPSOMITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SALT_BLOCK.get());
                        pOutput.accept(TekoraBlocks.EVAPORITE.get());
                        pOutput.accept(TekoraBlocks.LIMESTONE.get());

                        pOutput.accept(TekoraBlocks.ALUMINUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ANTIMONY_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ARSENIC_BLOCK.get());
                        pOutput.accept(TekoraBlocks.BARIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.BERYLLIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.BISMUTH_BLOCK.get());
                        pOutput.accept(TekoraBlocks.BORON_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CADMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CALCIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CERIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CHROMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.COBALT_BLOCK.get());
                        pOutput.accept(TekoraBlocks.DYSPROSIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ERBIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.EUROPIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.GADOLINIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.GALLIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.GERMANIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.HAFNIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.HOLMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.INDIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.IRIDIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.LANTHANUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.LEAD_BLOCK.get());
                        pOutput.accept(TekoraBlocks.LUTETIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.MAGNESIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.MANGANESE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.MOLYBDENUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.NEODYMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.NICKEL_BLOCK.get());
                        pOutput.accept(TekoraBlocks.NIOBIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.OSMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.PALLADIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.PLATINUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.PRASEODYMIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RHENIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RHODIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RUTHENIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SAMARIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SCANDIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SILVER_BLOCK.get());
                        pOutput.accept(TekoraBlocks.STRONTIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SILICON_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TANTALUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TELLURIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TERBIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.THALLIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.THORIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.THULIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TIN_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TITANIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.TUNGSTEN_BLOCK.get());
                        pOutput.accept(TekoraBlocks.URANIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.VANADIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.YTTERBIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.YTTRIUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ZINC_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ZIRCONIUM_BLOCK.get());

                        pOutput.accept(TekoraBlocks.APATITE_ORE.get());
                        pOutput.accept(TekoraBlocks.CALCITE_APATITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_APATITE_ORE.get());
                        pOutput.accept(TekoraBlocks.GRANITE_APATITE_ORE.get());
                        pOutput.accept(TekoraBlocks.AQUAMARINE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        pOutput.accept(TekoraBlocks.BAUXITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get());
                        pOutput.accept(TekoraBlocks.SAND_BAUXITE_ORE.get());
                        pOutput.accept(TekoraBlocks.CASSITERITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_CASSITERITE_ORE.get());
                        pOutput.accept(TekoraBlocks.CHROMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.BASALT_CHROMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_CHROMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.NETHER_BASALT_CHROMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.TUFF_CHROMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.CINNABAR_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get());
                        pOutput.accept(TekoraBlocks.GALENA_ORE.get());
                        pOutput.accept(TekoraBlocks.BASALT_GALENA_ORE.get());
                        pOutput.accept(TekoraBlocks.CALCITE_GALENA_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_GALENA_ORE.get());
                        pOutput.accept(TekoraBlocks.TUFF_GALENA_ORE.get());
                        pOutput.accept(TekoraBlocks.GARNET_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_GARNET_ORE.get());
                        pOutput.accept(TekoraBlocks.GRAPHITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_GRAPHITE_ORE.get());
                        pOutput.accept(TekoraBlocks.TUFF_GRAPHITE_ORE.get());
                        pOutput.accept(TekoraBlocks.PENTLANDITE_ORE.get());
                        pOutput.accept(TekoraBlocks.BASALT_PENTLANDITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_PENTLANDITE_ORE.get());
                        pOutput.accept(TekoraBlocks.GRANITE_PENTLANDITE_ORE.get());
                        pOutput.accept(TekoraBlocks.TUFF_PENTLANDITE_ORE.get());
                        pOutput.accept(TekoraBlocks.RUBY_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(TekoraBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(TekoraBlocks.SILVER_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_SILVER_ORE.get());
                        pOutput.accept(TekoraBlocks.URANINITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_URANINITE_ORE.get());
                        pOutput.accept(TekoraBlocks.ZIRCON_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get());
                        pOutput.accept(TekoraBlocks.GRANITE_ZIRCON_ORE.get());
                        pOutput.accept(TekoraBlocks.SANSTONE_ZIRCON_ORE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_MINERALS = CREATIVE_MODE_TABS.register("tekora_minerals", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.APATITE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_minerals"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.APATITE.get());
                        pOutput.accept(TekoraItems.AQUAMARINE.get());
                        pOutput.accept(TekoraItems.BAUXITE.get());
                        pOutput.accept(TekoraItems.CASSITERITE.get());
                        pOutput.accept(TekoraItems.CHROMITE.get());
                        pOutput.accept(TekoraItems.CINNABAR.get());
                        pOutput.accept(TekoraItems.GALENA.get());
                        pOutput.accept(TekoraItems.GARNET.get());
                        pOutput.accept(TekoraItems.PENTLANDITE.get());
                        pOutput.accept(TekoraItems.RAW_SILVER.get());
                        pOutput.accept(TekoraItems.RUBY.get());
                        pOutput.accept(TekoraItems.SAPPHIRE.get());
                        pOutput.accept(TekoraItems.URANINITE.get());
                        pOutput.accept(TekoraItems.ZIRCON.get());

                        pOutput.accept(TekoraItems.BASTNAESITE_SHARD.get());
                        pOutput.accept(TekoraItems.MAGNETITE_SHARD.get());
                        pOutput.accept(TekoraItems.MONAZITE_SHARD.get());
                        pOutput.accept(TekoraItems.ORPIMENT_SHARD.get());
                        pOutput.accept(TekoraItems.RUTILE_SHARD.get());
                        pOutput.accept(TekoraItems.SCHEELITE_SHARD.get());
                        pOutput.accept(TekoraItems.SPERRYLITE_SHARD.get());
                        pOutput.accept(TekoraItems.STIBNITE_SHARD.get());

                        pOutput.accept(TekoraItems.COLTAN_PIECE.get());
                        pOutput.accept(TekoraItems.PYRITE_PIECE.get());
                        pOutput.accept(TekoraItems.PYROLUSITE_PIECE.get());
                        pOutput.accept(TekoraItems.SPHALERITE_PIECE.get());
                        pOutput.accept(TekoraItems.THORITE_PIECE.get());
                        pOutput.accept(TekoraItems.WOLFRAMITE_PIECE.get());

                        pOutput.accept(TekoraItems.BASTNAESITE.get());
                        pOutput.accept(TekoraItems.COLTAN.get());
                        pOutput.accept(TekoraItems.MAGNETITE.get());
                        pOutput.accept(TekoraItems.MONAZITE.get());
                        pOutput.accept(TekoraItems.ORPIMENT.get());
                        pOutput.accept(TekoraItems.PYRITE.get());
                        pOutput.accept(TekoraItems.PYROLUSITE.get());
                        pOutput.accept(TekoraItems.RUTILE.get());
                        pOutput.accept(TekoraItems.SCHEELITE.get());
                        pOutput.accept(TekoraItems.SPERRYLITE.get());
                        pOutput.accept(TekoraItems.SPHALERITE.get());
                        pOutput.accept(TekoraItems.STIBNITE.get());
                        pOutput.accept(TekoraItems.THORITE.get());
                        pOutput.accept(TekoraItems.WOLFRAMITE.get());

                        pOutput.accept(TekoraItems.DOLOMITE.get());
                        pOutput.accept(TekoraItems.FLUORITE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_ITEMS = CREATIVE_MODE_TABS.register("tekora_items", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.COBALT_INGOT.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_items"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.ALUMINUM_INGOT.get());
                        pOutput.accept(TekoraItems.BARIUM_INGOT.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.BISMUTH_INGOT.get());
                        pOutput.accept(TekoraItems.CADMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CALCIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CERIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CESIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CHROMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.COBALT_INGOT.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_INGOT.get());
                        pOutput.accept(TekoraItems.ERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.EUROPIUM_INGOT.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_INGOT.get());
                        pOutput.accept(TekoraItems.GALLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.HAFNIUM_INGOT.get());
                        pOutput.accept(TekoraItems.HOLMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.INDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.IRIDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.LANTHANUM_INGOT.get());
                        pOutput.accept(TekoraItems.LEAD_INGOT.get());
                        pOutput.accept(TekoraItems.LITHIUM_INGOT.get());
                        pOutput.accept(TekoraItems.LUTETIUM_INGOT.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_INGOT.get());
                        pOutput.accept(TekoraItems.MANGANESE_INGOT.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_INGOT.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.NICKEL_INGOT.get());
                        pOutput.accept(TekoraItems.NIOBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.OSMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.PALLADIUM_INGOT.get());
                        pOutput.accept(TekoraItems.PLATINUM_INGOT.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.POTASSIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RHENIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RHODIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SAMARIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SCANDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SILVER_INGOT.get());
                        pOutput.accept(TekoraItems.SODIUM_INGOT.get());
                        pOutput.accept(TekoraItems.STRONTIUM_INGOT.get());
                        pOutput.accept(TekoraItems.TANTALUM_INGOT.get());
                        pOutput.accept(TekoraItems.TERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THALLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THORIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THULIUM_INGOT.get());
                        pOutput.accept(TekoraItems.TIN_INGOT.get());
                        pOutput.accept(TekoraItems.TITANIUM_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_INGOT.get());
                        pOutput.accept(TekoraItems.URANIUM_INGOT.get());
                        pOutput.accept(TekoraItems.VANADIUM_INGOT.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.YTTRIUM_INGOT.get());
                        pOutput.accept(TekoraItems.ZINC_INGOT.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_INGOT.get());

                        pOutput.accept(TekoraItems.BRASS_INGOT.get());
                        pOutput.accept(TekoraItems.BRONZE_INGOT.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.FERROBORON_INGOT.get());
                        pOutput.accept(TekoraItems.GALVANIZED_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.INCONEL_INGOT.get());
                        pOutput.accept(TekoraItems.INVAR_INGOT.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.MU_METAL_INGOT.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.VANASTEEL_INGOT.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_INGOT.get());

                        pOutput.accept(TekoraItems.COPPER_STEEL.get());

                        pOutput.accept(TekoraItems.GRAPHITE_BAR.get());
                        pOutput.accept(TekoraItems.IODINE_BAR.get());

                        pOutput.accept(TekoraItems.ANTIMONY_PIECE.get());
                        pOutput.accept(TekoraItems.ARSENIC_PIECE.get());
                        pOutput.accept(TekoraItems.BORON_PIECE.get());
                        pOutput.accept(TekoraItems.GERMANIUM_PIECE.get());
                        pOutput.accept(TekoraItems.SILICON_PIECE.get());
                        pOutput.accept(TekoraItems.TELLURIUM_PIECE.get());

                        pOutput.accept(TekoraItems.MAGNESIUM_DIBORIDE.get());
                        pOutput.accept(TekoraItems.NIOBIUM_TIN.get());
                        pOutput.accept(TekoraItems.SILICON_CARBIDE.get());

                        pOutput.accept(TekoraItems.ALUMINUM_NUGGET.get());
                        pOutput.accept(TekoraItems.BARIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.BISMUTH_NUGGET.get());
                        pOutput.accept(TekoraItems.CADMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CALCIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CERIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CESIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CHROMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.COBALT_NUGGET.get());
                        pOutput.accept(TekoraItems.COPPER_NUGGET.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.EUROPIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.GALLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.HAFNIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.HOLMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.INDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.IRIDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LANTHANUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LEAD_NUGGET.get());
                        pOutput.accept(TekoraItems.LITHIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LUTETIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.MANGANESE_NUGGET.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_NUGGET.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.NICKEL_NUGGET.get());
                        pOutput.accept(TekoraItems.NIOBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.OSMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PALLADIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PLATINUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.POTASSIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RHENIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RHODIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SAMARIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SCANDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SILVER_NUGGET.get());
                        pOutput.accept(TekoraItems.SODIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.STRONTIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TANTALUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THALLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THORIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THULIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TIN_NUGGET.get());
                        pOutput.accept(TekoraItems.TITANIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_NUGGET.get());
                        pOutput.accept(TekoraItems.URANIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.VANADIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.YTTRIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ZINC_NUGGET.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_NUGGET.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_DUSTS = CREATIVE_MODE_TABS.register("tekora_dusts", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.SULFUR_DUST.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_dusts"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.PHOSPHORUS_DUST.get());
                        pOutput.accept(TekoraItems.SULFUR_DUST.get());
                        pOutput.accept(TekoraItems.SELENIUM_DUST.get());

                        pOutput.accept(TekoraItems.GRAPHITE_DUST.get());
                        pOutput.accept(TekoraItems.IODINE_DUST.get());

                        pOutput.accept(TekoraItems.COPPER_DUST.get());
                        pOutput.accept(TekoraItems.GOLD_DUST.get());
                        pOutput.accept(TekoraItems.IRON_DUST.get());

                        pOutput.accept(TekoraItems.ALUMINUM_DUST.get());
                        pOutput.accept(TekoraItems.BARIUM_DUST.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_DUST.get());
                        pOutput.accept(TekoraItems.BISMUTH_DUST.get());
                        pOutput.accept(TekoraItems.CADMIUM_DUST.get());
                        pOutput.accept(TekoraItems.CALCIUM_DUST.get());
                        pOutput.accept(TekoraItems.CERIUM_DUST.get());
                        pOutput.accept(TekoraItems.CESIUM_DUST.get());
                        pOutput.accept(TekoraItems.CHROMIUM_DUST.get());
                        pOutput.accept(TekoraItems.COBALT_DUST.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_DUST.get());
                        pOutput.accept(TekoraItems.ERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.EUROPIUM_DUST.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_DUST.get());
                        pOutput.accept(TekoraItems.GALLIUM_DUST.get());
                        pOutput.accept(TekoraItems.HAFNIUM_DUST.get());
                        pOutput.accept(TekoraItems.HOLMIUM_DUST.get());
                        pOutput.accept(TekoraItems.INDIUM_DUST.get());
                        pOutput.accept(TekoraItems.IRIDIUM_DUST.get());
                        pOutput.accept(TekoraItems.LANTHANUM_DUST.get());
                        pOutput.accept(TekoraItems.LEAD_DUST.get());
                        pOutput.accept(TekoraItems.LITHIUM_DUST.get());
                        pOutput.accept(TekoraItems.LUTETIUM_DUST.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_DUST.get());
                        pOutput.accept(TekoraItems.MANGANESE_DUST.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_DUST.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.NICKEL_DUST.get());
                        pOutput.accept(TekoraItems.NIOBIUM_DUST.get());
                        pOutput.accept(TekoraItems.OSMIUM_DUST.get());
                        pOutput.accept(TekoraItems.PALLADIUM_DUST.get());
                        pOutput.accept(TekoraItems.PLATINUM_DUST.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.POTASSIUM_DUST.get());
                        pOutput.accept(TekoraItems.RHENIUM_DUST.get());
                        pOutput.accept(TekoraItems.RHODIUM_DUST.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_DUST.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_DUST.get());
                        pOutput.accept(TekoraItems.SAMARIUM_DUST.get());
                        pOutput.accept(TekoraItems.SCANDIUM_DUST.get());
                        pOutput.accept(TekoraItems.SILVER_DUST.get());
                        pOutput.accept(TekoraItems.SODIUM_DUST.get());
                        pOutput.accept(TekoraItems.STRONTIUM_DUST.get());
                        pOutput.accept(TekoraItems.TANTALUM_DUST.get());
                        pOutput.accept(TekoraItems.TERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.THALLIUM_DUST.get());
                        pOutput.accept(TekoraItems.THORIUM_DUST.get());
                        pOutput.accept(TekoraItems.THULIUM_DUST.get());
                        pOutput.accept(TekoraItems.TIN_DUST.get());
                        pOutput.accept(TekoraItems.TITANIUM_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_DUST.get());
                        pOutput.accept(TekoraItems.URANIUM_DUST.get());
                        pOutput.accept(TekoraItems.VANADIUM_DUST.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.YTTRIUM_DUST.get());
                        pOutput.accept(TekoraItems.ZINC_DUST.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_DUST.get());

                        pOutput.accept(TekoraItems.COPPER_STEEL_DUST.get());

                        pOutput.accept(TekoraItems.BRASS_DUST.get());
                        pOutput.accept(TekoraItems.BRONZE_DUST.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.FERROBORON_DUST.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.INCONEL_DUST.get());
                        pOutput.accept(TekoraItems.INVAR_DUST.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.MU_METAL_DUST.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.STEEL_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.VANASTEEL_DUST.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_DUST.get());

                        pOutput.accept(TekoraItems.ALUMINA.get());
                        pOutput.accept(TekoraItems.AHCP.get());
                        pOutput.accept(TekoraItems.APT.get());
                        pOutput.accept(TekoraItems.BAKING_SODA.get());
                        pOutput.accept(TekoraItems.BN_DUST.get());
                        pOutput.accept(TekoraItems.BORAX.get());
                        pOutput.accept(TekoraItems.POTASSIUM_PM.get());
                        pOutput.accept(TekoraItems.SALT.get());
                        pOutput.accept(TekoraItems.SILICA.get());
                        pOutput.accept(TekoraItems.SODIUM_CYANIDE.get());

                        pOutput.accept(TekoraItems.AMMONIUM_CHLORIDE.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_CHLORIDE.get());
                        pOutput.accept(TekoraItems.CALCIUM_CHLORIDE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_CHLORIDE.get());
                        pOutput.accept(TekoraItems.POTASSIUM_CHLORIDE.get());

                        pOutput.accept(TekoraItems.ALUMINUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.CALCIUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.LITHIUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.SODIUM_FLUORIDE.get());
                        pOutput.accept(TekoraItems.THORIUM_TETRAFLUORIDE.get());
                        pOutput.accept(TekoraItems.URANIUM_TETRAFLUORIDE.get());
                        pOutput.accept(TekoraItems.NIOBIUM_PENTAFLUORIDE.get());
                        pOutput.accept(TekoraItems.TANTALUM_PENTAFLUORIDE.get());
                        pOutput.accept(TekoraItems.URANIUM_HEXAFLUORIDE.get());

                        pOutput.accept(TekoraItems.NICKEL_IODIDE.get());
                        pOutput.accept(TekoraItems.POTASSIUM_IODIDE.get());

                        pOutput.accept(TekoraItems.BORIC_ACID.get());
                        pOutput.accept(TekoraItems.PHOSPHORIC_ACID.get());
                        pOutput.accept(TekoraItems.SODIUM_HYDRIDE.get());

                        pOutput.accept(TekoraItems.CALCIUM_CARBONATE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_CARBONATE.get());
                        pOutput.accept(TekoraItems.NICKEL_CARBONATE.get());
                        pOutput.accept(TekoraItems.SODIUM_CARBONATE.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_HYDROXIDE.get());
                        pOutput.accept(TekoraItems.POTASSIUM_HYDROXIDE.get());
                        pOutput.accept(TekoraItems.SODIUM_HYDROXIDE.get());
                        pOutput.accept(TekoraItems.CALCIUM_PHOSPHATE.get());
                        pOutput.accept(TekoraItems.COPPER_NITRATE.get());
                        pOutput.accept(TekoraItems.SILVER_NITRATE.get());
                        pOutput.accept(TekoraItems.ZINC_NITRATE.get());
                        pOutput.accept(TekoraItems.SODIUM_SULFITE.get());
                        pOutput.accept(TekoraItems.BARIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.CALCIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.POTASSIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.SODIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.STRONTIUM_SULFATE.get());
                        pOutput.accept(TekoraItems.SODIUM_THIOSULFATE.get());

                        pOutput.accept(TekoraItems.BARIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.CADMIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.CALCIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.CHROMIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.COBALT_OXIDE.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.ERBIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.EUROPIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.FERRIC_OXIDE.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.HOLMIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.LANTHANUM_OXIDE.get());
                        pOutput.accept(TekoraItems.LEAD_OXIDE.get());
                        pOutput.accept(TekoraItems.LUTETIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.MANGANESE_OXIDE.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_OXIDE.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.POTASSIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.PROTACTINIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.SAMARIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.SCANDIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.SODIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.STRONTIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.SODIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.TERBIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.THULIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_OXIDE.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.YTTRIUM_OXIDE.get());
                        pOutput.accept(TekoraItems.CERIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.MANGANESE_DIOXIDE.get());
                        pOutput.accept(TekoraItems.SELENIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.THORIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.TIN_DIOXIDE.get());
                        pOutput.accept(TekoraItems.TITANIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.URANIUM_DIOXIDE.get());
                        pOutput.accept(TekoraItems.BORON_TRIOXIDE.get());
                        pOutput.accept(TekoraItems.PHOSPHORUS_PENTOXIDE.get());
                        pOutput.accept(TekoraItems.VANADIUM_PENTOXIDE.get());
                        pOutput.accept(TekoraItems.RHENIUM_HEPTOXIDE.get());

                        pOutput.accept(TekoraItems.BISMUTH_SULFIDE.get());
                        pOutput.accept(TekoraItems.CADMIUM_SULFIDE.get());
                        pOutput.accept(TekoraItems.COPPER_SULFIDE.get());
                        pOutput.accept(TekoraItems.FERRIC_SULFIDE.get());
                        pOutput.accept(TekoraItems.FERROUS_SULFIDE.get());
                        pOutput.accept(TekoraItems.GERMANIUM_SULFIDE.get());
                        pOutput.accept(TekoraItems.LEAD_SULFIDE.get());
                        pOutput.accept(TekoraItems.MANGANESE_SULFIDE.get());
                        pOutput.accept(TekoraItems.SODIUM_SULFIDE.get());
                        pOutput.accept(TekoraItems.THALLIUM_SULFIDE.get());
                        pOutput.accept(TekoraItems.ZINC_SULFIDE.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_DISULFIDE.get());
                        pOutput.accept(TekoraItems.RHENIUM_DISULFIDE.get());
                        pOutput.accept(TekoraItems.ARSENIC_TRISULFIDE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_PARTS = CREATIVE_MODE_TABS.register("tekora_parts", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.BISMUTH_PLATE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_parts"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.RESIDUE.get());

                        pOutput.accept(TekoraItems.COPPER_PLATE.get());
                        pOutput.accept(TekoraItems.GOLD_PLATE.get());
                        pOutput.accept(TekoraItems.IRON_PLATE.get());

                        pOutput.accept(TekoraItems.ALUMINUM_PLATE.get());
                        pOutput.accept(TekoraItems.BISMUTH_PLATE.get());
                        pOutput.accept(TekoraItems.CADMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.CHROMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.COBALT_PLATE.get());
                        pOutput.accept(TekoraItems.INDIUM_PLATE.get());
                        pOutput.accept(TekoraItems.IRIDIUM_PLATE.get());
                        pOutput.accept(TekoraItems.LEAD_PLATE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_PLATE.get());
                        pOutput.accept(TekoraItems.MANGANESE_PLATE.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_PLATE.get());
                        pOutput.accept(TekoraItems.NICKEL_PLATE.get());
                        pOutput.accept(TekoraItems.NIOBIUM_PLATE.get());
                        pOutput.accept(TekoraItems.OSMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.PALLADIUM_PLATE.get());
                        pOutput.accept(TekoraItems.PLATINUM_PLATE.get());
                        pOutput.accept(TekoraItems.RHODIUM_PLATE.get());
                        pOutput.accept(TekoraItems.SCANDIUM_PLATE.get());
                        pOutput.accept(TekoraItems.SILVER_PLATE.get());
                        pOutput.accept(TekoraItems.THORIUM_PLATE.get());
                        pOutput.accept(TekoraItems.THULIUM_PLATE.get());
                        pOutput.accept(TekoraItems.TIN_PLATE.get());
                        pOutput.accept(TekoraItems.TITANIUM_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_PLATE.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_PLATE.get());
                        pOutput.accept(TekoraItems.ZINC_PLATE.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_PLATE.get());

                        pOutput.accept(TekoraItems.COPPER_STEEL_PLATE.get());

                        pOutput.accept(TekoraItems.BRASS_PLATE.get());
                        pOutput.accept(TekoraItems.BRONZE_PLATE.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.FERROBORON_PLATE.get());
                        pOutput.accept(TekoraItems.GALVANZIED_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.INCONEL_PLATE.get());
                        pOutput.accept(TekoraItems.INVAR_PLATE.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.MU_METAL_PLATE.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.VANASTEEL_PLATE.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_PLATE.get());
                    }))).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
