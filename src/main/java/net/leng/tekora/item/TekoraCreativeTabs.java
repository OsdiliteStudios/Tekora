package net.leng.tekora.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.leng.tekora.Tekora;
import net.leng.tekora.block.TekoraBlocks;

public class TekoraCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tekora.MODID);

    public static RegistryObject<CreativeModeTab> TEKORA_MACHINES = CREATIVE_MODE_TABS.register("tekora_machines", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraBlocks.ALLOY_FURNACE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_machines"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraBlocks.INFINITE_BATTERY.get());
                        pOutput.accept(TekoraBlocks.ALLOY_FURNACE.get());
                        pOutput.accept(TekoraBlocks.INFUSION_FURNACE.get());
                        pOutput.accept(TekoraBlocks.COMPRESSOR.get());
                        pOutput.accept(TekoraBlocks.CUTTER.get());
                        pOutput.accept(TekoraBlocks.ELECTRIC_FURNACE.get());
                        pOutput.accept(TekoraBlocks.EXTRUDER.get());
                        pOutput.accept(TekoraBlocks.PULVERIZER.get());
                        pOutput.accept(TekoraBlocks.HYDROELECTRIC_GENERATOR.get());
                        pOutput.accept(TekoraBlocks.CENTRIFUGE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_BLOCKS = CREATIVE_MODE_TABS.register("tekora_blocks", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraBlocks.BAUXITE_ORE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_blocks"))
                    .displayItems((((pParameters, pOutput) -> {
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

                        pOutput.accept(TekoraBlocks.AQUAMARINE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.BAUXITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CHROMITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.CINNABAR_BLOCK.get());
                        pOutput.accept(TekoraBlocks.COLTAN_BLOCK.get());
                        pOutput.accept(TekoraBlocks.DOLOMITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.FLUORITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.HALITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.MONAZITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RUBY_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RUTILE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.URANINITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.WOLFRAMITE_BLOCK.get());
                        pOutput.accept(TekoraBlocks.ZIRCON_BLOCK.get());

                        pOutput.accept(TekoraBlocks.RAW_LEAD_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RAW_NICKEL_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RAW_SILVER_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RAW_TIN_BLOCK.get());
                        pOutput.accept(TekoraBlocks.RAW_ZINC_BLOCK.get());

                        pOutput.accept(TekoraBlocks.AQUAMARINE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        pOutput.accept(TekoraBlocks.BAUXITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get());
                        pOutput.accept(TekoraBlocks.CINNABAR_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get());
                        pOutput.accept(TekoraBlocks.HALITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_HALITE_ORE.get());
                        pOutput.accept(TekoraBlocks.LEAD_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_LEAD_ORE.get());
                        pOutput.accept(TekoraBlocks.NICKEL_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_NICKEL_ORE.get());
                        pOutput.accept(TekoraBlocks.RUBY_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_RUBY_ORE.get());
                        pOutput.accept(TekoraBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(TekoraBlocks.TIN_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_TIN_ORE.get());
                        pOutput.accept(TekoraBlocks.URANINITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_URANINITE_ORE.get());
                        pOutput.accept(TekoraBlocks.WOLFRAMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());
                        pOutput.accept(TekoraBlocks.ZINC_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_ZINC_ORE.get());
                        pOutput.accept(TekoraBlocks.ZIRCON_ORE.get());
                        pOutput.accept(TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_MATERIALS = CREATIVE_MODE_TABS.register("tekora_materials", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.WOLFRAMITE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_minerals"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.RAW_LEAD.get());
                        pOutput.accept(TekoraItems.RAW_NICKEL.get());
                        pOutput.accept(TekoraItems.RAW_SILVER.get());
                        pOutput.accept(TekoraItems.RAW_PLATINUM.get());
                        pOutput.accept(TekoraItems.RAW_TIN.get());
                        pOutput.accept(TekoraItems.RAW_ZINC.get());

                        pOutput.accept(TekoraItems.AQUAMARINE.get());
                        pOutput.accept(TekoraItems.BAUXITE.get());
                        pOutput.accept(TekoraItems.CHROMITE.get());
                        pOutput.accept(TekoraItems.CINNABAR.get());
                        pOutput.accept(TekoraItems.HALITE.get());
                        pOutput.accept(TekoraItems.RUBY.get());
                        pOutput.accept(TekoraItems.SAPPHIRE.get());
                        pOutput.accept(TekoraItems.URANINITE.get());
                        pOutput.accept(TekoraItems.ZIRCON.get());

                        pOutput.accept(TekoraItems.COLTAN.get());
                        pOutput.accept(TekoraItems.COLTAN_PIECE.get());

                        pOutput.accept(TekoraItems.MONAZITE.get());
                        pOutput.accept(TekoraItems.MONAZITE_SHARD.get());

                        pOutput.accept(TekoraItems.PYROLUSITE.get());
                        pOutput.accept(TekoraItems.PYROLUSITE_PIECE.get());

                        pOutput.accept(TekoraItems.RUTILE.get());
                        pOutput.accept(TekoraItems.RUTILE_SHARD.get());

                        pOutput.accept(TekoraItems.WOLFRAMITE.get());
                        pOutput.accept(TekoraItems.WOLFRAMITE_PIECE.get());

                        pOutput.accept(TekoraItems.DOLOMITE.get());
                        pOutput.accept(TekoraItems.FLUORITE.get());

                        pOutput.accept(TekoraItems.PULVERIZED_ANCIENT_DEBRIS.get());
                        pOutput.accept(TekoraItems.PULVERIZED_AQUAMARINE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_BAUXITE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_CINNABAR_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_COAL_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_DIAMOND_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_EMERALD_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_HALITE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_LAPIS_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_QUARTZ_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_REDSTONE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_RUBY_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_SAPPHIRE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_URANINITE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_WOLFRAMITE_ORE.get());
                        pOutput.accept(TekoraItems.PULVERIZED_ZIRCON_ORE.get());

                        pOutput.accept(TekoraItems.COPPER_DUST.get());
                        pOutput.accept(TekoraItems.COPPER_PLATE.get());
                        pOutput.accept(TekoraItems.COPPER_WIRE.get());
                        pOutput.accept(TekoraItems.COPPER_TINY_DUST.get());
                        pOutput.accept(TekoraItems.GOLD_DUST.get());
                        pOutput.accept(TekoraItems.GOLD_PLATE.get());
                        pOutput.accept(TekoraItems.GOLD_WIRE.get());
                        pOutput.accept(TekoraItems.GOLD_TINY_DUST.get());
                        pOutput.accept(TekoraItems.IRON_DUST.get());
                        pOutput.accept(TekoraItems.IRON_PLATE.get());
                        pOutput.accept(TekoraItems.IRON_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ALUMINUM_INGOT.get());
                        pOutput.accept(TekoraItems.ALUMINUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ALUMINUM_DUST.get());
                        pOutput.accept(TekoraItems.ALUMINUM_PLATE.get());
                        pOutput.accept(TekoraItems.ALUMINUM_WIRE.get());
                        pOutput.accept(TekoraItems.ALUMINUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BARIUM_INGOT.get());
                        pOutput.accept(TekoraItems.BARIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.BARIUM_DUST.get());
                        pOutput.accept(TekoraItems.BARIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BERYLLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_DUST.get());
                        pOutput.accept(TekoraItems.BERYLLIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BISMUTH_INGOT.get());
                        pOutput.accept(TekoraItems.BISMUTH_NUGGET.get());
                        pOutput.accept(TekoraItems.BISMUTH_DUST.get());
                        pOutput.accept(TekoraItems.BISMUTH_PLATE.get());

                        pOutput.accept(TekoraItems.CADMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CADMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CADMIUM_DUST.get());
                        pOutput.accept(TekoraItems.CADMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.CADMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CALCIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CALCIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CALCIUM_DUST.get());
                        pOutput.accept(TekoraItems.CALCIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CERIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CERIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CERIUM_DUST.get());
                        pOutput.accept(TekoraItems.CERIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CESIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CESIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CESIUM_DUST.get());
                        pOutput.accept(TekoraItems.CESIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CHROMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.CHROMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.CHROMIUM_DUST.get());
                        pOutput.accept(TekoraItems.CHROMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.CHROMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.COBALT_INGOT.get());
                        pOutput.accept(TekoraItems.COBALT_NUGGET.get());
                        pOutput.accept(TekoraItems.COBALT_DUST.get());
                        pOutput.accept(TekoraItems.COBALT_PLATE.get());
                        pOutput.accept(TekoraItems.COBALT_TINY_DUST.get());

                        pOutput.accept(TekoraItems.DYSPROSIUM_INGOT.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_DUST.get());
                        pOutput.accept(TekoraItems.DYSPROSIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.ERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.ERBIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.EUROPIUM_INGOT.get());
                        pOutput.accept(TekoraItems.EUROPIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.EUROPIUM_DUST.get());
                        pOutput.accept(TekoraItems.EUROPIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.GADOLINIUM_INGOT.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_DUST.get());
                        pOutput.accept(TekoraItems.GADOLINIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.GALLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.GALLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.GALLIUM_DUST.get());
                        pOutput.accept(TekoraItems.GALLIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.HAFNIUM_INGOT.get());
                        pOutput.accept(TekoraItems.HAFNIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.HAFNIUM_DUST.get());
                        pOutput.accept(TekoraItems.HAFNIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.HOLMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.HOLMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.HOLMIUM_DUST.get());
                        pOutput.accept(TekoraItems.HOLMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.INDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.INDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.INDIUM_DUST.get());
                        pOutput.accept(TekoraItems.INDIUM_PLATE.get());
                        pOutput.accept(TekoraItems.INDIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.IRIDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.IRIDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.IRIDIUM_DUST.get());
                        pOutput.accept(TekoraItems.IRIDIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.LANTHANUM_INGOT.get());
                        pOutput.accept(TekoraItems.LANTHANUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LANTHANUM_DUST.get());
                        pOutput.accept(TekoraItems.LANTHANUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.LEAD_INGOT.get());
                        pOutput.accept(TekoraItems.LEAD_NUGGET.get());
                        pOutput.accept(TekoraItems.LEAD_DUST.get());
                        pOutput.accept(TekoraItems.LEAD_PLATE.get());
                        pOutput.accept(TekoraItems.LEAD_TINY_DUST.get());

                        pOutput.accept(TekoraItems.LITHIUM_INGOT.get());
                        pOutput.accept(TekoraItems.LITHIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LITHIUM_DUST.get());
                        pOutput.accept(TekoraItems.LITHIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.LUTETIUM_INGOT.get());
                        pOutput.accept(TekoraItems.LUTETIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.LUTETIUM_DUST.get());
                        pOutput.accept(TekoraItems.LUTETIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MAGNESIUM_INGOT.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_DUST.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_PLATE.get());
                        pOutput.accept(TekoraItems.MAGNESIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MANGANESE_INGOT.get());
                        pOutput.accept(TekoraItems.MANGANESE_NUGGET.get());
                        pOutput.accept(TekoraItems.MANGANESE_DUST.get());
                        pOutput.accept(TekoraItems.MANGANESE_PLATE.get());
                        pOutput.accept(TekoraItems.MANGANESE_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MOLYBDENUM_INGOT.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_NUGGET.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_DUST.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_PLATE.get());
                        pOutput.accept(TekoraItems.MOLYBDENUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.NEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.NEODYMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.NICKEL_INGOT.get());
                        pOutput.accept(TekoraItems.NICKEL_NUGGET.get());
                        pOutput.accept(TekoraItems.NICKEL_DUST.get());
                        pOutput.accept(TekoraItems.NICKEL_PLATE.get());
                        pOutput.accept(TekoraItems.NICKEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.NIOBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.NIOBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.NIOBIUM_DUST.get());
                        pOutput.accept(TekoraItems.NIOBIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.OSMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.OSMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.OSMIUM_DUST.get());
                        pOutput.accept(TekoraItems.OSMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.OSMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.PALLADIUM_INGOT.get());
                        pOutput.accept(TekoraItems.PALLADIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PALLADIUM_DUST.get());
                        pOutput.accept(TekoraItems.PALLADIUM_PLATE.get());
                        pOutput.accept(TekoraItems.PALLADIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.PLATINUM_INGOT.get());
                        pOutput.accept(TekoraItems.PLATINUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PLATINUM_DUST.get());
                        pOutput.accept(TekoraItems.PLATINUM_PLATE.get());
                        pOutput.accept(TekoraItems.PLATINUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.PRASEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.PRASEODYMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.POTASSIUM_INGOT.get());
                        pOutput.accept(TekoraItems.POTASSIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.POTASSIUM_DUST.get());
                        pOutput.accept(TekoraItems.POTASSIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.RHENIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RHENIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RHENIUM_DUST.get());
                        pOutput.accept(TekoraItems.RHENIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.RHODIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RHODIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RHODIUM_DUST.get());
                        pOutput.accept(TekoraItems.RHODIUM_PLATE.get());
                        pOutput.accept(TekoraItems.RHODIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.RUBIDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_DUST.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RUBIDIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.RUTHENIUM_INGOT.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_DUST.get());
                        pOutput.accept(TekoraItems.RUTHENIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.SAMARIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SAMARIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SAMARIUM_DUST.get());
                        pOutput.accept(TekoraItems.SAMARIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.SCANDIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SCANDIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SCANDIUM_DUST.get());
                        pOutput.accept(TekoraItems.SCANDIUM_PLATE.get());
                        pOutput.accept(TekoraItems.SCANDIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.SILVER_INGOT.get());
                        pOutput.accept(TekoraItems.SILVER_NUGGET.get());
                        pOutput.accept(TekoraItems.SILVER_DUST.get());
                        pOutput.accept(TekoraItems.SILVER_PLATE.get());
                        pOutput.accept(TekoraItems.SILVER_TINY_DUST.get());
                        pOutput.accept(TekoraItems.SILVER_WIRE.get());

                        pOutput.accept(TekoraItems.SODIUM_INGOT.get());
                        pOutput.accept(TekoraItems.SODIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.SODIUM_DUST.get());
                        pOutput.accept(TekoraItems.SODIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.STRONTIUM_INGOT.get());
                        pOutput.accept(TekoraItems.STRONTIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.STRONTIUM_DUST.get());
                        pOutput.accept(TekoraItems.STRONTIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TANTALUM_INGOT.get());
                        pOutput.accept(TekoraItems.TANTALUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TANTALUM_DUST.get());
                        pOutput.accept(TekoraItems.TANTALUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.TERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.TERBIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.THALLIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THALLIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THALLIUM_DUST.get());
                        pOutput.accept(TekoraItems.THALLIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.THORIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THORIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THORIUM_DUST.get());
                        pOutput.accept(TekoraItems.THORIUM_PLATE.get());
                        pOutput.accept(TekoraItems.THORIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.THULIUM_INGOT.get());
                        pOutput.accept(TekoraItems.THULIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.THULIUM_DUST.get());
                        pOutput.accept(TekoraItems.THULIUM_PLATE.get());
                        pOutput.accept(TekoraItems.THULIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TIN_INGOT.get());
                        pOutput.accept(TekoraItems.TIN_NUGGET.get());
                        pOutput.accept(TekoraItems.TIN_DUST.get());
                        pOutput.accept(TekoraItems.TIN_PLATE.get());
                        pOutput.accept(TekoraItems.TIN_TINY_DUST.get());
                        pOutput.accept(TekoraItems.TIN_WIRE.get());

                        pOutput.accept(TekoraItems.TITANIUM_INGOT.get());
                        pOutput.accept(TekoraItems.TITANIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.TITANIUM_DUST.get());
                        pOutput.accept(TekoraItems.TITANIUM_PLATE.get());
                        pOutput.accept(TekoraItems.TITANIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TUNGSTEN_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_NUGGET.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_TINY_DUST.get());

                        pOutput.accept(TekoraItems.URANIUM_INGOT.get());
                        pOutput.accept(TekoraItems.URANIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.URANIUM_DUST.get());
                        pOutput.accept(TekoraItems.URANIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.VANADIUM_INGOT.get());
                        pOutput.accept(TekoraItems.VANADIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.VANADIUM_DUST.get());
                        pOutput.accept(TekoraItems.VANADIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.YTTERBIUM_INGOT.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_DUST.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_PLATE.get());
                        pOutput.accept(TekoraItems.YTTERBIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.YTTRIUM_INGOT.get());
                        pOutput.accept(TekoraItems.YTTRIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.YTTRIUM_DUST.get());
                        pOutput.accept(TekoraItems.YTTRIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ZINC_INGOT.get());
                        pOutput.accept(TekoraItems.ZINC_NUGGET.get());
                        pOutput.accept(TekoraItems.ZINC_DUST.get());
                        pOutput.accept(TekoraItems.ZINC_PLATE.get());
                        pOutput.accept(TekoraItems.ZINC_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ZIRCONIUM_INGOT.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_DUST.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_PLATE.get());
                        pOutput.accept(TekoraItems.ZIRCONIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BRASS_INGOT.get());
                        pOutput.accept(TekoraItems.BRASS_NUGGET.get());
                        pOutput.accept(TekoraItems.BRASS_DUST.get());
                        pOutput.accept(TekoraItems.BRASS_PLATE.get());
                        pOutput.accept(TekoraItems.BRASS_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BRONZE_INGOT.get());
                        pOutput.accept(TekoraItems.BRONZE_NUGGET.get());
                        pOutput.accept(TekoraItems.BRONZE_DUST.get());
                        pOutput.accept(TekoraItems.BRONZE_PLATE.get());
                        pOutput.accept(TekoraItems.BRONZE_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CARBON_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_ROD.get());
                        pOutput.accept(TekoraItems.CARBON_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.CHROMOLY_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.CUPRONICKEL_INGOT.get());
                        pOutput.accept(TekoraItems.CUPRONICKEL_NUGGET.get());
                        pOutput.accept(TekoraItems.CUPRONICKEL_DUST.get());
                        pOutput.accept(TekoraItems.CUPRONICKEL_PLATE.get());
                        pOutput.accept(TekoraItems.CUPRONICKEL_TINY_DUST.get());
                        pOutput.accept(TekoraItems.CUPRONICKEL_WIRE.get());

                        pOutput.accept(TekoraItems.ELECTRUM_INGOT.get());
                        pOutput.accept(TekoraItems.ELECTRUM_NUGGET.get());
                        pOutput.accept(TekoraItems.ELECTRUM_DUST.get());
                        pOutput.accept(TekoraItems.ELECTRUM_PLATE.get());
                        pOutput.accept(TekoraItems.ELECTRUM_TINY_DUST.get());
                        pOutput.accept(TekoraItems.ELECTRUM_WIRE.get());

                        pOutput.accept(TekoraItems.FERROBORON_INGOT.get());
                        pOutput.accept(TekoraItems.FERROBORON_NUGGET.get());
                        pOutput.accept(TekoraItems.FERROBORON_DUST.get());
                        pOutput.accept(TekoraItems.FERROBORON_PLATE.get());
                        pOutput.accept(TekoraItems.FERROBORON_TINY_DUST.get());

                        pOutput.accept(TekoraItems.GALVANIZED_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.GALVANIZED_STEEL_PLATE.get());

                        pOutput.accept(TekoraItems.HSLA_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.HSLA_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.INCONEL_INGOT.get());
                        pOutput.accept(TekoraItems.INCONEL_NUGGET.get());
                        pOutput.accept(TekoraItems.INCONEL_DUST.get());
                        pOutput.accept(TekoraItems.INCONEL_TINY_DUST.get());
                        pOutput.accept(TekoraItems.INCONEL_PLATE.get());

                        pOutput.accept(TekoraItems.INVAR_INGOT.get());
                        pOutput.accept(TekoraItems.INVAR_NUGGET.get());
                        pOutput.accept(TekoraItems.INVAR_DUST.get());
                        pOutput.accept(TekoraItems.INVAR_PLATE.get());
                        pOutput.accept(TekoraItems.INVAR_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_NUGGET.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_DUST.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get());
                        pOutput.accept(TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MU_METAL_INGOT.get());
                        pOutput.accept(TekoraItems.MU_METAL_NUGGET.get());
                        pOutput.accept(TekoraItems.MU_METAL_DUST.get());
                        pOutput.accept(TekoraItems.MU_METAL_PLATE.get());
                        pOutput.accept(TekoraItems.MU_METAL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.REACTOR_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.REACTOR_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.STAINLESS_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.STAINLESS_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.STEEL_DUST.get());
                        pOutput.accept(TekoraItems.STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.STEEL_ROD.get());
                        pOutput.accept(TekoraItems.STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_NUGGET.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_INGOT.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_DUST.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_PLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.VANASTEEL_INGOT.get());
                        pOutput.accept(TekoraItems.VANASTEEL_NUGGET.get());
                        pOutput.accept(TekoraItems.VANASTEEL_DUST.get());
                        pOutput.accept(TekoraItems.VANASTEEL_PLATE.get());
                        pOutput.accept(TekoraItems.VANASTEEL_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ZIRCALOY_INGOT.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_NUGGET.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_DUST.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_PLATE.get());
                        pOutput.accept(TekoraItems.ZIRCALOY_TINY_DUST.get());

                        pOutput.accept(TekoraItems.COPPER_STEEL.get());
                        pOutput.accept(TekoraItems.COPPER_STEEL_DUST.get());

                        pOutput.accept(TekoraItems.GRAPHITE_BAR.get());
                        pOutput.accept(TekoraItems.GRAPHITE_DUST.get());

                        pOutput.accept(TekoraItems.IODINE_BAR.get());
                        pOutput.accept(TekoraItems.IODINE_DUST.get());

                        pOutput.accept(TekoraItems.ANTIMONY_PIECE.get());
                        pOutput.accept(TekoraItems.ANTIMONY_DUST.get());
                        pOutput.accept(TekoraItems.ANTIMONY_TINY_DUST.get());

                        pOutput.accept(TekoraItems.ARSENIC_PIECE.get());
                        pOutput.accept(TekoraItems.ARSENIC_DUST.get());
                        pOutput.accept(TekoraItems.ARSENIC_TINY_DUST.get());

                        pOutput.accept(TekoraItems.BORON_PIECE.get());
                        pOutput.accept(TekoraItems.BORON_DUST.get());
                        pOutput.accept(TekoraItems.BORON_TINY_DUST.get());

                        pOutput.accept(TekoraItems.GERMANIUM_PIECE.get());
                        pOutput.accept(TekoraItems.GERMANIUM_DUST.get());
                        pOutput.accept(TekoraItems.GERMANIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.SILICON_PIECE.get());
                        pOutput.accept(TekoraItems.SILICON_DUST.get());
                        pOutput.accept(TekoraItems.SILICON_TINY_DUST.get());

                        pOutput.accept(TekoraItems.TELLURIUM_PIECE.get());
                        pOutput.accept(TekoraItems.TELLURIUM_DUST.get());
                        pOutput.accept(TekoraItems.TELLURIUM_TINY_DUST.get());

                        pOutput.accept(TekoraItems.MAGNESIUM_DIBORIDE.get());
                        pOutput.accept(TekoraItems.NIOBIUM_TIN.get());
                        pOutput.accept(TekoraItems.SILICON_CARBIDE.get());

                        pOutput.accept(TekoraItems.PHOSPHORUS_DUST.get());
                        pOutput.accept(TekoraItems.SULFUR_DUST.get());
                        pOutput.accept(TekoraItems.SELENIUM_DUST.get());

                        pOutput.accept(TekoraItems.ALUMINA.get());
                        pOutput.accept(TekoraItems.AHCP.get());
                        pOutput.accept(TekoraItems.APT.get());
                        pOutput.accept(TekoraItems.BAKING_SODA.get());
                        pOutput.accept(TekoraItems.BN_DUST.get());
                        pOutput.accept(TekoraItems.BORAX.get());
                        pOutput.accept(TekoraItems.POTASSIUM_PM.get());
                        pOutput.accept(TekoraItems.SALT.get());
                        pOutput.accept(TekoraItems.SILICA.get());
                        pOutput.accept(TekoraItems.BORIC_ACID.get());
                        pOutput.accept(TekoraItems.PHOSPHORIC_ACID.get());
                        pOutput.accept(TekoraItems.SODIUM_HYDRIDE.get());
                    }))).build());

    public static RegistryObject<CreativeModeTab> TEKORA_PARTS = CREATIVE_MODE_TABS.register("tekora_parts", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TekoraItems.COIL.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("itemGroup.tekora_parts"))
                    .displayItems((((pParameters, pOutput) -> {
                        pOutput.accept(TekoraItems.BASIC_WRENCH.get());
                        pOutput.accept(TekoraItems.ADVANCED_WRENCH.get());

                        pOutput.accept(TekoraItems.STAINLESS_STEEL_TURBINE.get());
                        pOutput.accept(TekoraItems.TURBINE_GENERATOR.get());
                        pOutput.accept(TekoraItems.TURBINE_STATOR.get());
                        pOutput.accept(TekoraItems.TURBINE_ROTOR.get());
                        pOutput.accept(TekoraItems.COIL.get());

                        pOutput.accept(TekoraBlocks.ALUMINUM_CABLE.get());
                        pOutput.accept(TekoraBlocks.COPPER_CABLE.get());
                        pOutput.accept(TekoraBlocks.CUPRONICKEL_CABLE.get());
                        pOutput.accept(TekoraBlocks.ELECTRUM_CABLE.get());
                        pOutput.accept(TekoraBlocks.GOLD_CABLE.get());
                        pOutput.accept(TekoraBlocks.SILVER_CABLE.get());
                        pOutput.accept(TekoraBlocks.TIN_CABLE.get());

                        pOutput.accept(TekoraItems.TITANIUM_TEMPLATE.get());
                        pOutput.accept(TekoraItems.THORIUM_TEMPLATE.get());
                        pOutput.accept(TekoraItems.TUNGSTEN_STEEL_TEMPLATE.get());
                        pOutput.accept(TekoraItems.VANASTEEL_TEMPLATE.get());
                    }))).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
