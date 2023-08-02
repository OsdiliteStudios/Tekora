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
import net.nukollodda.tekora.block.ModBlocks;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tekora.MODID);

    public static RegistryObject<CreativeModeTab> TEKORA_MACHINES = CREATIVE_MODE_TABS.register("tekora_machines", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ALLOY_FURNACE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_machines"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ALLOY_FURNACE.get());
                        pOutput.accept(ModBlocks.CRUSHER.get());
                        pOutput.accept(ModBlocks.INFUSION_FURNACE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_BLOCKS = CREATIVE_MODE_TABS.register("tekora_blocks", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BAUXITE_ORE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_blocks"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BORAX_BLOCK.get());
                        pOutput.accept(ModBlocks.EPSOMITE_BLOCK.get());
                        pOutput.accept(ModBlocks.SALT_BLOCK.get());
                        pOutput.accept(ModBlocks.EVAPORITE.get());
                        pOutput.accept(ModBlocks.LIMESTONE.get());

                        pOutput.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.ANTIMONY_BLOCK.get());
                        pOutput.accept(ModBlocks.ARSENIC_BLOCK.get());
                        pOutput.accept(ModBlocks.BARIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.BERYLLIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.BISMUTH_BLOCK.get());
                        pOutput.accept(ModBlocks.BORON_BLOCK.get());
                        pOutput.accept(ModBlocks.CADMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.CALCIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.CERIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.CHROMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.COBALT_BLOCK.get());
                        pOutput.accept(ModBlocks.DYSPROSIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.ERBIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.EUROPIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.GADOLINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.GALLIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.GERMANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.HAFNIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.HOLMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.INDIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.IRIDIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.LANTHANUM_BLOCK.get());
                        pOutput.accept(ModBlocks.LEAD_BLOCK.get());
                        pOutput.accept(ModBlocks.LUTETIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MAGNESIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.MANGANESE_BLOCK.get());
                        pOutput.accept(ModBlocks.MOLYBDENUM_BLOCK.get());
                        pOutput.accept(ModBlocks.NEODYMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.NICKEL_BLOCK.get());
                        pOutput.accept(ModBlocks.NIOBIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.OSMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.PALLADIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.PLATINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.PRASEODYMIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RHENIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RHODIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RUTHENIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SAMARIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SCANDIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.STRONTIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.SILICON_BLOCK.get());
                        pOutput.accept(ModBlocks.TANTALUM_BLOCK.get());
                        pOutput.accept(ModBlocks.TELLURIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.TERBIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.THALLIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.THORIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.THULIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.TIN_BLOCK.get());
                        pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                        pOutput.accept(ModBlocks.URANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.VANADIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.YTTERBIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.YTTRIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.ZINC_BLOCK.get());
                        pOutput.accept(ModBlocks.ZIRCONIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.APATITE_ORE.get());
                        pOutput.accept(ModBlocks.CALCITE_APATITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_APATITE_ORE.get());
                        pOutput.accept(ModBlocks.GRANITE_APATITE_ORE.get());
                        pOutput.accept(ModBlocks.AQUAMARINE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        pOutput.accept(ModBlocks.BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.SAND_BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.CASSITERITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CASSITERITE_ORE.get());
                        pOutput.accept(ModBlocks.CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.BASALT_CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_BASALT_CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.TUFF_CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.CINNABAR_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CINNABAR_ORE.get());
                        pOutput.accept(ModBlocks.GALENA_ORE.get());
                        pOutput.accept(ModBlocks.BASALT_GALENA_ORE.get());
                        pOutput.accept(ModBlocks.CALCITE_GALENA_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_GALENA_ORE.get());
                        pOutput.accept(ModBlocks.TUFF_GALENA_ORE.get());
                        pOutput.accept(ModBlocks.GARNET_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_GARNET_ORE.get());
                        pOutput.accept(ModBlocks.GRAPHITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_GRAPHITE_ORE.get());
                        pOutput.accept(ModBlocks.TUFF_GRAPHITE_ORE.get());
                        pOutput.accept(ModBlocks.PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.BASALT_PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.GRANITE_PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.TUFF_PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.SILVER_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                        pOutput.accept(ModBlocks.URANINITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_URANINITE_ORE.get());
                        pOutput.accept(ModBlocks.ZIRCON_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ZIRCON_ORE.get());
                        pOutput.accept(ModBlocks.GRANITE_ZIRCON_ORE.get());
                        pOutput.accept(ModBlocks.SANSTONE_ZIRCON_ORE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_MINERALS = CREATIVE_MODE_TABS.register("tekora_minerals", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.APATITE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_minerals"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.APATITE.get());
                        pOutput.accept(ModItems.AQUAMARINE.get());
                        pOutput.accept(ModItems.BAUXITE.get());
                        pOutput.accept(ModItems.CASSITERITE.get());
                        pOutput.accept(ModItems.CHROMITE.get());
                        pOutput.accept(ModItems.CINNABAR.get());
                        pOutput.accept(ModItems.GALENA.get());
                        pOutput.accept(ModItems.GARNET.get());
                        pOutput.accept(ModItems.PENTLANDITE.get());
                        pOutput.accept(ModItems.RAW_SILVER.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.URANINITE.get());
                        pOutput.accept(ModItems.ZIRCON.get());

                        pOutput.accept(ModItems.BASTNAESITE.get());
                        pOutput.accept(ModItems.COLTAN.get());
                        pOutput.accept(ModItems.MAGNETITE.get());
                        pOutput.accept(ModItems.MONAZITE.get());
                        pOutput.accept(ModItems.ORPIMENT.get());
                        pOutput.accept(ModItems.PYRITE.get());
                        pOutput.accept(ModItems.PYROLUSITE.get());
                        pOutput.accept(ModItems.RUTILE.get());
                        pOutput.accept(ModItems.SCHEELITE.get());
                        pOutput.accept(ModItems.SPERRYLITE.get());
                        pOutput.accept(ModItems.SPHALERITE.get());
                        pOutput.accept(ModItems.STIBNITE.get());
                        pOutput.accept(ModItems.THORITE.get());
                        pOutput.accept(ModItems.WOLFRAMITE.get());

                        pOutput.accept(ModItems.BASTNAESITE_SHARD.get());
                        pOutput.accept(ModItems.MAGNETITE_SHARD.get());
                        pOutput.accept(ModItems.MONAZITE_SHARD.get());
                        pOutput.accept(ModItems.ORPIMENT_SHARD.get());
                        pOutput.accept(ModItems.RUTILE_SHARD.get());
                        pOutput.accept(ModItems.SCHEELITE_SHARD.get());
                        pOutput.accept(ModItems.SPERRYLITE_SHARD.get());
                        pOutput.accept(ModItems.STIBNITE_SHARD.get());

                        pOutput.accept(ModItems.COLTAN_PIECE.get());
                        pOutput.accept(ModItems.PYRITE_PIECE.get());
                        pOutput.accept(ModItems.PYROLUSITE_PIECE.get());
                        pOutput.accept(ModItems.SPHALERITE_PIECE.get());
                        pOutput.accept(ModItems.THORITE_PIECE.get());
                        pOutput.accept(ModItems.WOLFRAMITE_PIECE.get());

                        pOutput.accept(ModItems.DOLOMITE.get());
                        pOutput.accept(ModItems.FLUORITE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_ITEMS = CREATIVE_MODE_TABS.register("tekora_items", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.COBALT_INGOT.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_items"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALUMINUM_INGOT.get());
                        pOutput.accept(ModItems.BARIUM_INGOT.get());
                        pOutput.accept(ModItems.BERYLLIUM_INGOT.get());
                        pOutput.accept(ModItems.BISMUTH_INGOT.get());
                        pOutput.accept(ModItems.CADMIUM_INGOT.get());
                        pOutput.accept(ModItems.CALCIUM_INGOT.get());
                        pOutput.accept(ModItems.CERIUM_INGOT.get());
                        pOutput.accept(ModItems.CESIUM_INGOT.get());
                        pOutput.accept(ModItems.CHROMIUM_INGOT.get());
                        pOutput.accept(ModItems.COBALT_INGOT.get());
                        pOutput.accept(ModItems.DYSPROSIUM_INGOT.get());
                        pOutput.accept(ModItems.ERBIUM_INGOT.get());
                        pOutput.accept(ModItems.EUROPIUM_INGOT.get());
                        pOutput.accept(ModItems.GADOLINIUM_INGOT.get());
                        pOutput.accept(ModItems.GALLIUM_INGOT.get());
                        pOutput.accept(ModItems.HAFNIUM_INGOT.get());
                        pOutput.accept(ModItems.HOLMIUM_INGOT.get());
                        pOutput.accept(ModItems.INDIUM_INGOT.get());
                        pOutput.accept(ModItems.IRIDIUM_INGOT.get());
                        pOutput.accept(ModItems.LANTHANUM_INGOT.get());
                        pOutput.accept(ModItems.LEAD_INGOT.get());
                        pOutput.accept(ModItems.LITHIUM_INGOT.get());
                        pOutput.accept(ModItems.LUTETIUM_INGOT.get());
                        pOutput.accept(ModItems.MAGNESIUM_INGOT.get());
                        pOutput.accept(ModItems.MANGANESE_INGOT.get());
                        pOutput.accept(ModItems.MOLYBDENUM_INGOT.get());
                        pOutput.accept(ModItems.NEODYMIUM_INGOT.get());
                        pOutput.accept(ModItems.NICKEL_INGOT.get());
                        pOutput.accept(ModItems.NIOBIUM_INGOT.get());
                        pOutput.accept(ModItems.OSMIUM_INGOT.get());
                        pOutput.accept(ModItems.PALLADIUM_INGOT.get());
                        pOutput.accept(ModItems.PLATINUM_INGOT.get());
                        pOutput.accept(ModItems.PRASEODYMIUM_INGOT.get());
                        pOutput.accept(ModItems.POTASSIUM_INGOT.get());
                        pOutput.accept(ModItems.RHENIUM_INGOT.get());
                        pOutput.accept(ModItems.RHODIUM_INGOT.get());
                        pOutput.accept(ModItems.RUBIDIUM_INGOT.get());
                        pOutput.accept(ModItems.RUTHENIUM_INGOT.get());
                        pOutput.accept(ModItems.SAMARIUM_INGOT.get());
                        pOutput.accept(ModItems.SCANDIUM_INGOT.get());
                        pOutput.accept(ModItems.SILVER_INGOT.get());
                        pOutput.accept(ModItems.SODIUM_INGOT.get());
                        pOutput.accept(ModItems.STRONTIUM_INGOT.get());
                        pOutput.accept(ModItems.TANTALUM_INGOT.get());
                        pOutput.accept(ModItems.TERBIUM_INGOT.get());
                        pOutput.accept(ModItems.THALLIUM_INGOT.get());
                        pOutput.accept(ModItems.THORIUM_INGOT.get());
                        pOutput.accept(ModItems.THULIUM_INGOT.get());
                        pOutput.accept(ModItems.TIN_INGOT.get());
                        pOutput.accept(ModItems.TITANIUM_INGOT.get());
                        pOutput.accept(ModItems.TUNGSTEN_INGOT.get());
                        pOutput.accept(ModItems.URANIUM_INGOT.get());
                        pOutput.accept(ModItems.VANADIUM_INGOT.get());
                        pOutput.accept(ModItems.YTTERBIUM_INGOT.get());
                        pOutput.accept(ModItems.YTTRIUM_INGOT.get());
                        pOutput.accept(ModItems.ZINC_INGOT.get());
                        pOutput.accept(ModItems.ZIRCONIUM_INGOT.get());

                        pOutput.accept(ModItems.BRASS_INGOT.get());
                        pOutput.accept(ModItems.BRONZE_INGOT.get());
                        pOutput.accept(ModItems.CARBON_STEEL_INGOT.get());
                        pOutput.accept(ModItems.CHROMOLY_STEEL_INGOT.get());
                        pOutput.accept(ModItems.FERROBORON_INGOT.get());
                        pOutput.accept(ModItems.GALVANIZED_STEEL_INGOT.get());
                        pOutput.accept(ModItems.HSLA_STEEL_INGOT.get());
                        pOutput.accept(ModItems.INCONEL_INGOT.get());
                        pOutput.accept(ModItems.INVAR_INGOT.get());
                        pOutput.accept(ModItems.MAGNETIC_NEODYMIUM_INGOT.get());
                        pOutput.accept(ModItems.MU_METAL_INGOT.get());
                        pOutput.accept(ModItems.REACTOR_STEEL_INGOT.get());
                        pOutput.accept(ModItems.STAINLESS_STEEL_INGOT.get());
                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModItems.TUNGSTEN_CARBIDE_INGOT.get());
                        pOutput.accept(ModItems.TUNGSTEN_STEEL_INGOT.get());
                        pOutput.accept(ModItems.VANASTEEL_INGOT.get());
                        pOutput.accept(ModItems.ZIRCALOY_INGOT.get());

                        pOutput.accept(ModItems.COPPER_STEEL.get());

                        pOutput.accept(ModItems.GRAPHITE_BAR.get());
                        pOutput.accept(ModItems.IODINE_BAR.get());

                        pOutput.accept(ModItems.ANTIMONY_PIECE.get());
                        pOutput.accept(ModItems.ARSENIC_PIECE.get());
                        pOutput.accept(ModItems.BORON_PIECE.get());
                        pOutput.accept(ModItems.GERMANIUM_PIECE.get());
                        pOutput.accept(ModItems.SILICON_PIECE.get());
                        pOutput.accept(ModItems.TELLURIUM_PIECE.get());

                        pOutput.accept(ModItems.MAGNESIUM_DIBORIDE.get());
                        pOutput.accept(ModItems.NIOBIUM_TIN.get());
                        pOutput.accept(ModItems.SILICON_CARBIDE.get());

                        pOutput.accept(ModItems.ALUMINUM_NUGGET.get());
                        pOutput.accept(ModItems.BARIUM_NUGGET.get());
                        pOutput.accept(ModItems.BERYLLIUM_NUGGET.get());
                        pOutput.accept(ModItems.BISMUTH_NUGGET.get());
                        pOutput.accept(ModItems.CADMIUM_NUGGET.get());
                        pOutput.accept(ModItems.CALCIUM_NUGGET.get());
                        pOutput.accept(ModItems.CERIUM_NUGGET.get());
                        pOutput.accept(ModItems.CESIUM_NUGGET.get());
                        pOutput.accept(ModItems.CHROMIUM_NUGGET.get());
                        pOutput.accept(ModItems.COBALT_NUGGET.get());
                        pOutput.accept(ModItems.COPPER_NUGGET.get());
                        pOutput.accept(ModItems.DYSPROSIUM_NUGGET.get());
                        pOutput.accept(ModItems.ERBIUM_NUGGET.get());
                        pOutput.accept(ModItems.EUROPIUM_NUGGET.get());
                        pOutput.accept(ModItems.GADOLINIUM_NUGGET.get());
                        pOutput.accept(ModItems.GALLIUM_NUGGET.get());
                        pOutput.accept(ModItems.HAFNIUM_NUGGET.get());
                        pOutput.accept(ModItems.HOLMIUM_NUGGET.get());
                        pOutput.accept(ModItems.INDIUM_NUGGET.get());
                        pOutput.accept(ModItems.IRIDIUM_NUGGET.get());
                        pOutput.accept(ModItems.LANTHANUM_NUGGET.get());
                        pOutput.accept(ModItems.LEAD_NUGGET.get());
                        pOutput.accept(ModItems.LITHIUM_NUGGET.get());
                        pOutput.accept(ModItems.LUTETIUM_NUGGET.get());
                        pOutput.accept(ModItems.MAGNESIUM_NUGGET.get());
                        pOutput.accept(ModItems.MANGANESE_NUGGET.get());
                        pOutput.accept(ModItems.MOLYBDENUM_NUGGET.get());
                        pOutput.accept(ModItems.NEODYMIUM_NUGGET.get());
                        pOutput.accept(ModItems.NICKEL_NUGGET.get());
                        pOutput.accept(ModItems.NIOBIUM_NUGGET.get());
                        pOutput.accept(ModItems.OSMIUM_NUGGET.get());
                        pOutput.accept(ModItems.PALLADIUM_NUGGET.get());
                        pOutput.accept(ModItems.PLATINUM_NUGGET.get());
                        pOutput.accept(ModItems.PRASEODYMIUM_NUGGET.get());
                        pOutput.accept(ModItems.POTASSIUM_NUGGET.get());
                        pOutput.accept(ModItems.RHENIUM_NUGGET.get());
                        pOutput.accept(ModItems.RHODIUM_NUGGET.get());
                        pOutput.accept(ModItems.RUBIDIUM_NUGGET.get());
                        pOutput.accept(ModItems.RUTHENIUM_NUGGET.get());
                        pOutput.accept(ModItems.SAMARIUM_NUGGET.get());
                        pOutput.accept(ModItems.SCANDIUM_NUGGET.get());
                        pOutput.accept(ModItems.SILVER_NUGGET.get());
                        pOutput.accept(ModItems.SODIUM_NUGGET.get());
                        pOutput.accept(ModItems.STRONTIUM_NUGGET.get());
                        pOutput.accept(ModItems.TANTALUM_NUGGET.get());
                        pOutput.accept(ModItems.TERBIUM_NUGGET.get());
                        pOutput.accept(ModItems.THALLIUM_NUGGET.get());
                        pOutput.accept(ModItems.THORIUM_NUGGET.get());
                        pOutput.accept(ModItems.THULIUM_NUGGET.get());
                        pOutput.accept(ModItems.TIN_NUGGET.get());
                        pOutput.accept(ModItems.TITANIUM_NUGGET.get());
                        pOutput.accept(ModItems.TUNGSTEN_NUGGET.get());
                        pOutput.accept(ModItems.URANIUM_NUGGET.get());
                        pOutput.accept(ModItems.VANADIUM_NUGGET.get());
                        pOutput.accept(ModItems.YTTERBIUM_NUGGET.get());
                        pOutput.accept(ModItems.YTTRIUM_NUGGET.get());
                        pOutput.accept(ModItems.ZINC_NUGGET.get());
                        pOutput.accept(ModItems.ZIRCONIUM_NUGGET.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_DUSTS = CREATIVE_MODE_TABS.register("tekora_dusts", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SULFUR_DUST.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_dusts"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PHOSPHORUS_DUST.get());
                        pOutput.accept(ModItems.SULFUR_DUST.get());
                        pOutput.accept(ModItems.SELENIUM_DUST.get());

                        pOutput.accept(ModItems.GRAPHITE_DUST.get());
                        pOutput.accept(ModItems.IODINE_DUST.get());

                        pOutput.accept(ModItems.COPPER_DUST.get());
                        pOutput.accept(ModItems.GOLD_DUST.get());
                        pOutput.accept(ModItems.IRON_DUST.get());

                        pOutput.accept(ModItems.ALUMINUM_DUST.get());
                        pOutput.accept(ModItems.BARIUM_DUST.get());
                        pOutput.accept(ModItems.BERYLLIUM_DUST.get());
                        pOutput.accept(ModItems.BISMUTH_DUST.get());
                        pOutput.accept(ModItems.CADMIUM_DUST.get());
                        pOutput.accept(ModItems.CALCIUM_DUST.get());
                        pOutput.accept(ModItems.CERIUM_DUST.get());
                        pOutput.accept(ModItems.CESIUM_DUST.get());
                        pOutput.accept(ModItems.CHROMIUM_DUST.get());
                        pOutput.accept(ModItems.COBALT_DUST.get());
                        pOutput.accept(ModItems.DYSPROSIUM_DUST.get());
                        pOutput.accept(ModItems.ERBIUM_DUST.get());
                        pOutput.accept(ModItems.EUROPIUM_DUST.get());
                        pOutput.accept(ModItems.GADOLINIUM_DUST.get());
                        pOutput.accept(ModItems.GALLIUM_DUST.get());
                        pOutput.accept(ModItems.HAFNIUM_DUST.get());
                        pOutput.accept(ModItems.HOLMIUM_DUST.get());
                        pOutput.accept(ModItems.INDIUM_DUST.get());
                        pOutput.accept(ModItems.IRIDIUM_DUST.get());
                        pOutput.accept(ModItems.LANTHANUM_DUST.get());
                        pOutput.accept(ModItems.LEAD_DUST.get());
                        pOutput.accept(ModItems.LITHIUM_DUST.get());
                        pOutput.accept(ModItems.LUTETIUM_DUST.get());
                        pOutput.accept(ModItems.MAGNESIUM_DUST.get());
                        pOutput.accept(ModItems.MANGANESE_DUST.get());
                        pOutput.accept(ModItems.MOLYBDENUM_DUST.get());
                        pOutput.accept(ModItems.NEODYMIUM_DUST.get());
                        pOutput.accept(ModItems.NICKEL_DUST.get());
                        pOutput.accept(ModItems.NIOBIUM_DUST.get());
                        pOutput.accept(ModItems.OSMIUM_DUST.get());
                        pOutput.accept(ModItems.PALLADIUM_DUST.get());
                        pOutput.accept(ModItems.PLATINUM_DUST.get());
                        pOutput.accept(ModItems.PRASEODYMIUM_DUST.get());
                        pOutput.accept(ModItems.POTASSIUM_DUST.get());
                        pOutput.accept(ModItems.RHENIUM_DUST.get());
                        pOutput.accept(ModItems.RHODIUM_DUST.get());
                        pOutput.accept(ModItems.RUBIDIUM_DUST.get());
                        pOutput.accept(ModItems.RUTHENIUM_DUST.get());
                        pOutput.accept(ModItems.SAMARIUM_DUST.get());
                        pOutput.accept(ModItems.SCANDIUM_DUST.get());
                        pOutput.accept(ModItems.SILVER_DUST.get());
                        pOutput.accept(ModItems.SODIUM_DUST.get());
                        pOutput.accept(ModItems.STRONTIUM_DUST.get());
                        pOutput.accept(ModItems.TANTALUM_DUST.get());
                        pOutput.accept(ModItems.TERBIUM_DUST.get());
                        pOutput.accept(ModItems.THALLIUM_DUST.get());
                        pOutput.accept(ModItems.THORIUM_DUST.get());
                        pOutput.accept(ModItems.THULIUM_DUST.get());
                        pOutput.accept(ModItems.TIN_DUST.get());
                        pOutput.accept(ModItems.TITANIUM_DUST.get());
                        pOutput.accept(ModItems.TUNGSTEN_DUST.get());
                        pOutput.accept(ModItems.URANIUM_DUST.get());
                        pOutput.accept(ModItems.VANADIUM_DUST.get());
                        pOutput.accept(ModItems.YTTERBIUM_DUST.get());
                        pOutput.accept(ModItems.YTTRIUM_DUST.get());
                        pOutput.accept(ModItems.ZINC_DUST.get());
                        pOutput.accept(ModItems.ZIRCONIUM_DUST.get());

                        pOutput.accept(ModItems.COPPER_STEEL_DUST.get());

                        pOutput.accept(ModItems.BRASS_DUST.get());
                        pOutput.accept(ModItems.BRONZE_DUST.get());
                        pOutput.accept(ModItems.CARBON_STEEL_DUST.get());
                        pOutput.accept(ModItems.CHROMOLY_STEEL_DUST.get());
                        pOutput.accept(ModItems.FERROBORON_DUST.get());
                        pOutput.accept(ModItems.HSLA_STEEL_DUST.get());
                        pOutput.accept(ModItems.INCONEL_DUST.get());
                        pOutput.accept(ModItems.INVAR_DUST.get());
                        pOutput.accept(ModItems.MAGNETIC_NEODYMIUM_DUST.get());
                        pOutput.accept(ModItems.MU_METAL_DUST.get());
                        pOutput.accept(ModItems.REACTOR_STEEL_DUST.get());
                        pOutput.accept(ModItems.STAINLESS_STEEL_DUST.get());
                        pOutput.accept(ModItems.STEEL_DUST.get());
                        pOutput.accept(ModItems.TUNGSTEN_CARBIDE_DUST.get());
                        pOutput.accept(ModItems.TUNGSTEN_STEEL_DUST.get());
                        pOutput.accept(ModItems.VANASTEEL_DUST.get());
                        pOutput.accept(ModItems.ZIRCALOY_DUST.get());

                        pOutput.accept(ModItems.ALUMINA.get());
                        pOutput.accept(ModItems.AHCP.get());
                        pOutput.accept(ModItems.APT.get());
                        pOutput.accept(ModItems.BAKING_SODA.get());
                        pOutput.accept(ModItems.BN_DUST.get());
                        pOutput.accept(ModItems.BORAX.get());
                        pOutput.accept(ModItems.POTASSIUM_PM.get());
                        pOutput.accept(ModItems.SALT.get());
                        pOutput.accept(ModItems.SILICA.get());
                        pOutput.accept(ModItems.SODIUM_CYANIDE.get());

                        pOutput.accept(ModItems.AMMONIUM_CHLORIDE.get());
                        pOutput.accept(ModItems.BERYLLIUM_CHLORIDE.get());
                        pOutput.accept(ModItems.CALCIUM_CHLORIDE.get());
                        pOutput.accept(ModItems.MAGNESIUM_CHLORIDE.get());
                        pOutput.accept(ModItems.POTASSIUM_CHLORIDE.get());

                        pOutput.accept(ModItems.ALUMINUM_FLUORIDE.get());
                        pOutput.accept(ModItems.BERYLLIUM_FLUORIDE.get());
                        pOutput.accept(ModItems.CALCIUM_FLUORIDE.get());
                        pOutput.accept(ModItems.LITHIUM_FLUORIDE.get());
                        pOutput.accept(ModItems.MAGNESIUM_FLUORIDE.get());
                        pOutput.accept(ModItems.SODIUM_FLUORIDE.get());
                        pOutput.accept(ModItems.THORIUM_TETRAFLUORIDE.get());
                        pOutput.accept(ModItems.URANIUM_TETRAFLUORIDE.get());
                        pOutput.accept(ModItems.NIOBIUM_PENTAFLUORIDE.get());
                        pOutput.accept(ModItems.TANTALUM_PENTAFLUORIDE.get());
                        pOutput.accept(ModItems.URANIUM_HEXAFLUORIDE.get());

                        pOutput.accept(ModItems.NICKEL_IODIDE.get());
                        pOutput.accept(ModItems.POTASSIUM_IODIDE.get());

                        pOutput.accept(ModItems.BORIC_ACID.get());
                        pOutput.accept(ModItems.PHOSPHORIC_ACID.get());
                        pOutput.accept(ModItems.SODIUM_HYDRIDE.get());

                        pOutput.accept(ModItems.CALCIUM_CARBONATE.get());
                        pOutput.accept(ModItems.MAGNESIUM_CARBONATE.get());
                        pOutput.accept(ModItems.NICKEL_CARBONATE.get());
                        pOutput.accept(ModItems.SODIUM_CARBONATE.get());
                        pOutput.accept(ModItems.PRASEODYMIUM_HYDROXIDE.get());
                        pOutput.accept(ModItems.POTASSIUM_HYDROXIDE.get());
                        pOutput.accept(ModItems.SODIUM_HYDROXIDE.get());
                        pOutput.accept(ModItems.CALCIUM_PHOSPHATE.get());
                        pOutput.accept(ModItems.COPPER_NITRATE.get());
                        pOutput.accept(ModItems.SILVER_NITRATE.get());
                        pOutput.accept(ModItems.ZINC_NITRATE.get());
                        pOutput.accept(ModItems.SODIUM_SULFITE.get());
                        pOutput.accept(ModItems.BARIUM_SULFATE.get());
                        pOutput.accept(ModItems.BERYLLIUM_SULFATE.get());
                        pOutput.accept(ModItems.CALCIUM_SULFATE.get());
                        pOutput.accept(ModItems.MAGNESIUM_SULFATE.get());
                        pOutput.accept(ModItems.POTASSIUM_SULFATE.get());
                        pOutput.accept(ModItems.SODIUM_SULFATE.get());
                        pOutput.accept(ModItems.STRONTIUM_SULFATE.get());
                        pOutput.accept(ModItems.SODIUM_THIOSULFATE.get());

                        pOutput.accept(ModItems.BARIUM_OXIDE.get());
                        pOutput.accept(ModItems.CADMIUM_OXIDE.get());
                        pOutput.accept(ModItems.CALCIUM_OXIDE.get());
                        pOutput.accept(ModItems.CHROMIUM_OXIDE.get());
                        pOutput.accept(ModItems.COBALT_OXIDE.get());
                        pOutput.accept(ModItems.DYSPROSIUM_OXIDE.get());
                        pOutput.accept(ModItems.ERBIUM_OXIDE.get());
                        pOutput.accept(ModItems.EUROPIUM_OXIDE.get());
                        pOutput.accept(ModItems.FERRIC_OXIDE.get());
                        pOutput.accept(ModItems.GADOLINIUM_OXIDE.get());
                        pOutput.accept(ModItems.HOLMIUM_OXIDE.get());
                        pOutput.accept(ModItems.LANTHANUM_OXIDE.get());
                        pOutput.accept(ModItems.LEAD_OXIDE.get());
                        pOutput.accept(ModItems.LUTETIUM_OXIDE.get());
                        pOutput.accept(ModItems.MAGNESIUM_OXIDE.get());
                        pOutput.accept(ModItems.MANGANESE_OXIDE.get());
                        pOutput.accept(ModItems.MOLYBDENUM_OXIDE.get());
                        pOutput.accept(ModItems.NEODYMIUM_OXIDE.get());
                        pOutput.accept(ModItems.POTASSIUM_OXIDE.get());
                        pOutput.accept(ModItems.PRASEODYMIUM_OXIDE.get());
                        pOutput.accept(ModItems.PROTACTINIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.SAMARIUM_OXIDE.get());
                        pOutput.accept(ModItems.SCANDIUM_OXIDE.get());
                        pOutput.accept(ModItems.SODIUM_OXIDE.get());
                        pOutput.accept(ModItems.STRONTIUM_OXIDE.get());
                        pOutput.accept(ModItems.SODIUM_OXIDE.get());
                        pOutput.accept(ModItems.TERBIUM_OXIDE.get());
                        pOutput.accept(ModItems.THULIUM_OXIDE.get());
                        pOutput.accept(ModItems.TUNGSTEN_OXIDE.get());
                        pOutput.accept(ModItems.YTTERBIUM_OXIDE.get());
                        pOutput.accept(ModItems.YTTRIUM_OXIDE.get());
                        pOutput.accept(ModItems.CERIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.MANGANESE_DIOXIDE.get());
                        pOutput.accept(ModItems.SELENIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.THORIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.TIN_DIOXIDE.get());
                        pOutput.accept(ModItems.TITANIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.URANIUM_DIOXIDE.get());
                        pOutput.accept(ModItems.BORON_TRIOXIDE.get());
                        pOutput.accept(ModItems.PHOSPHORUS_PENTOXIDE.get());
                        pOutput.accept(ModItems.VANADIUM_PENTOXIDE.get());
                        pOutput.accept(ModItems.RHENIUM_HEPTOXIDE.get());

                        pOutput.accept(ModItems.BISMUTH_SULFIDE.get());
                        pOutput.accept(ModItems.CADMIUM_SULFIDE.get());
                        pOutput.accept(ModItems.COPPER_SULFIDE.get());
                        pOutput.accept(ModItems.FERRIC_SULFIDE.get());
                        pOutput.accept(ModItems.FERROUS_SULFIDE.get());
                        pOutput.accept(ModItems.GERMANIUM_SULFIDE.get());
                        pOutput.accept(ModItems.LEAD_SULFIDE.get());
                        pOutput.accept(ModItems.MANGANESE_SULFIDE.get());
                        pOutput.accept(ModItems.SODIUM_SULFIDE.get());
                        pOutput.accept(ModItems.THALLIUM_SULFIDE.get());
                        pOutput.accept(ModItems.ZINC_SULFIDE.get());
                        pOutput.accept(ModItems.MOLYBDENUM_DISULFIDE.get());
                        pOutput.accept(ModItems.RHENIUM_DISULFIDE.get());
                        pOutput.accept(ModItems.ARSENIC_TRISULFIDE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_PARTS = CREATIVE_MODE_TABS.register("tekora_parts", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BISMUTH_PLATE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_parts"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COPPER_PLATE.get());
                        pOutput.accept(ModItems.GOLD_PLATE.get());
                        pOutput.accept(ModItems.IRON_PLATE.get());

                        pOutput.accept(ModItems.ALUMINUM_PLATE.get());
                        pOutput.accept(ModItems.BISMUTH_PLATE.get());
                        pOutput.accept(ModItems.CADMIUM_PLATE.get());
                        pOutput.accept(ModItems.CHROMIUM_PLATE.get());
                        pOutput.accept(ModItems.COBALT_PLATE.get());
                        pOutput.accept(ModItems.INDIUM_PLATE.get());
                        pOutput.accept(ModItems.IRIDIUM_PLATE.get());
                        pOutput.accept(ModItems.LEAD_PLATE.get());
                        pOutput.accept(ModItems.MAGNESIUM_PLATE.get());
                        pOutput.accept(ModItems.MANGANESE_PLATE.get());
                        pOutput.accept(ModItems.MOLYBDENUM_PLATE.get());
                        pOutput.accept(ModItems.NICKEL_PLATE.get());
                        pOutput.accept(ModItems.NIOBIUM_PLATE.get());
                        pOutput.accept(ModItems.OSMIUM_PLATE.get());
                        pOutput.accept(ModItems.PALLADIUM_PLATE.get());
                        pOutput.accept(ModItems.PLATINUM_PLATE.get());
                        pOutput.accept(ModItems.RHODIUM_PLATE.get());
                        pOutput.accept(ModItems.SCANDIUM_PLATE.get());
                        pOutput.accept(ModItems.SILVER_PLATE.get());
                        pOutput.accept(ModItems.THORIUM_PLATE.get());
                        pOutput.accept(ModItems.THULIUM_PLATE.get());
                        pOutput.accept(ModItems.TIN_PLATE.get());
                        pOutput.accept(ModItems.TITANIUM_PLATE.get());
                        pOutput.accept(ModItems.TUNGSTEN_PLATE.get());
                        pOutput.accept(ModItems.YTTERBIUM_PLATE.get());
                        pOutput.accept(ModItems.ZINC_PLATE.get());
                        pOutput.accept(ModItems.ZIRCONIUM_PLATE.get());

                        pOutput.accept(ModItems.COPPER_STEEL_PLATE.get());

                        pOutput.accept(ModItems.BRASS_PLATE.get());
                        pOutput.accept(ModItems.BRONZE_PLATE.get());
                        pOutput.accept(ModItems.CHROMOLY_STEEL_PLATE.get());
                        pOutput.accept(ModItems.FERROBORON_PLATE.get());
                        pOutput.accept(ModItems.GALVANZIED_STEEL_PLATE.get());
                        pOutput.accept(ModItems.HSLA_STEEL_PLATE.get());
                        pOutput.accept(ModItems.INCONEL_PLATE.get());
                        pOutput.accept(ModItems.INVAR_PLATE.get());
                        pOutput.accept(ModItems.MAGNETIC_NEODYMIUM_PLATE.get());
                        pOutput.accept(ModItems.MU_METAL_PLATE.get());
                        pOutput.accept(ModItems.REACTOR_STEEL_PLATE.get());
                        pOutput.accept(ModItems.STAINLESS_STEEL_PLATE.get());
                        pOutput.accept(ModItems.STEEL_PLATE.get());
                        pOutput.accept(ModItems.TUNGSTEN_CARBIDE_PLATE.get());
                        pOutput.accept(ModItems.TUNGSTEN_STEEL_PLATE.get());
                        pOutput.accept(ModItems.VANASTEEL_PLATE.get());
                        pOutput.accept(ModItems.ZIRCALOY_PLATE.get());
                    }))).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
