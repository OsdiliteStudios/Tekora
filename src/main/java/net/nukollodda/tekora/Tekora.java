package net.nukollodda.tekora;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.blocks.connecters.EnergyCable;
import net.nukollodda.tekora.block.models.CableModel;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.fluid.TekoraFluidTypes;
import net.nukollodda.tekora.fluid.TekoraFluids;
import net.nukollodda.tekora.client.screens.*;
import net.nukollodda.tekora.item.TekoraCreativeTabs;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.menu.*;
import net.nukollodda.tekora.recipes.TekoraRecipes;
import net.nukollodda.tekora.util.UtilFunctions;
import org.slf4j.Logger;

@Mod(Tekora.MODID)
public class Tekora {
    /** Thanks to <a href="https://github.com/Tutorials-By-Kaupenjoe">Kaupenjoe</a> for making a tutorial for modding for
     * the Tekora team! As some code in this project were copied directly from his tutorials.
     */
    public static final String MODID = "tekora";
    public static final Logger LOGGER = LogUtils.getLogger();
    public Tekora() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TekoraItems.register(modEventBus);
        TekoraBlocks.register(modEventBus);
        TekoraBlockEntities.register(modEventBus);
        TekoraMenuTypes.register(modEventBus);
        TekoraCreativeTabs.register(modEventBus);
        TekoraFluidTypes.register(modEventBus);
        TekoraFluids.register(modEventBus);
        TekoraRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(TekoraItems.BORON_SWORD.get());
            event.accept(TekoraItems.BRONZE_SWORD.get());
            event.accept(TekoraItems.PLATINUM_SWORD.get());
            event.accept(TekoraItems.SILVER_SWORD.get());
            event.accept(TekoraItems.STEEL_SWORD.get());
            event.accept(TekoraItems.THORIUM_SWORD.get());
            event.accept(TekoraItems.TITANIUM_SWORD.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_SWORD.get());
            event.accept(TekoraItems.VANASTEEL_SWORD.get());

            event.accept(TekoraItems.BORON_AXE.get());
            event.accept(TekoraItems.BRONZE_AXE.get());
            event.accept(TekoraItems.PLATINUM_AXE.get());
            event.accept(TekoraItems.SILVER_AXE.get());
            event.accept(TekoraItems.STEEL_AXE.get());
            event.accept(TekoraItems.THORIUM_AXE.get());
            event.accept(TekoraItems.TITANIUM_AXE.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_AXE.get());
            event.accept(TekoraItems.VANASTEEL_AXE.get());

            event.accept(TekoraItems.DIAMOND_HAMMER.get());
            event.accept(TekoraItems.GOLDEN_HAMMER.get());
            event.accept(TekoraItems.IRON_HAMMER.get());
            event.accept(TekoraItems.NETHERITE_HAMMER.get());

            event.accept(TekoraItems.BORON_HAMMER.get());
            event.accept(TekoraItems.BRONZE_HAMMER.get());
            event.accept(TekoraItems.PLATINUM_HAMMER.get());
            event.accept(TekoraItems.SILVER_HAMMER.get());
            event.accept(TekoraItems.STEEL_HAMMER.get());
            event.accept(TekoraItems.THORIUM_HAMMER.get());
            event.accept(TekoraItems.TITANIUM_HAMMER.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_HAMMER.get());
            event.accept(TekoraItems.VANASTEEL_HAMMER.get());

            event.accept(TekoraItems.BORON_HELMET.get());
            event.accept(TekoraItems.BORON_CHESTPLATE.get());
            event.accept(TekoraItems.BORON_LEGGINGS.get());
            event.accept(TekoraItems.BORON_BOOTS.get());
            event.accept(TekoraItems.BRONZE_HELMET.get());
            event.accept(TekoraItems.BRONZE_CHESTPLATE.get());
            event.accept(TekoraItems.BRONZE_LEGGINGS.get());
            event.accept(TekoraItems.BRONZE_BOOTS.get());
            event.accept(TekoraItems.PLATINUM_HELMET.get());
            event.accept(TekoraItems.PLATINUM_CHESTPLATE.get());
            event.accept(TekoraItems.PLATINUM_LEGGINGS.get());
            event.accept(TekoraItems.PLATINUM_BOOTS.get());
            event.accept(TekoraItems.SILVER_HELMET.get());
            event.accept(TekoraItems.SILVER_CHESTPLATE.get());
            event.accept(TekoraItems.SILVER_LEGGINGS.get());
            event.accept(TekoraItems.SILVER_BOOTS.get());
            event.accept(TekoraItems.STEEL_HELMET.get());
            event.accept(TekoraItems.STEEL_CHESTPLATE.get());
            event.accept(TekoraItems.STEEL_LEGGINGS.get());
            event.accept(TekoraItems.STEEL_BOOTS.get());
            event.accept(TekoraItems.TITANIUM_HELMET.get());
            event.accept(TekoraItems.TITANIUM_CHESTPLATE.get());
            event.accept(TekoraItems.TITANIUM_LEGGINGS.get());
            event.accept(TekoraItems.TITANIUM_BOOTS.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_HELMET.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_CHESTPLATE.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_LEGGINGS.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_BOOTS.get());
            event.accept(TekoraItems.VANASTEEL_HELMET.get());
            event.accept(TekoraItems.VANASTEEL_CHESTPLATE.get());
            event.accept(TekoraItems.VANASTEEL_LEGGINGS.get());
            event.accept(TekoraItems.VANASTEEL_BOOTS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(TekoraItems.AMMONIUM_HYDROXIDE_BUCKET);
            event.accept(TekoraItems.BROMINE_BUCKET);
            event.accept(TekoraItems.HYDROFLUORIC_ACID_BUCKET);
            event.accept(TekoraItems.NITRIC_ACID_BUCKET);
            event.accept(TekoraItems.SULFURIC_ACID_BUCKET);

            event.accept(TekoraItems.GALLIUM_BUCKET);
            event.accept(TekoraItems.MERCURY_BUCKET);

            event.accept(TekoraItems.BORON_HAMMER.get());
            event.accept(TekoraItems.BRONZE_HAMMER.get());
            event.accept(TekoraItems.PLATINUM_HAMMER.get());
            event.accept(TekoraItems.SILVER_HAMMER.get());
            event.accept(TekoraItems.STEEL_HAMMER.get());
            event.accept(TekoraItems.THORIUM_HAMMER.get());
            event.accept(TekoraItems.TITANIUM_HAMMER.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_HAMMER.get());
            event.accept(TekoraItems.VANASTEEL_HAMMER.get());

            event.accept(TekoraItems.BORON_SHOVEL.get());
            event.accept(TekoraItems.BORON_PICKAXE.get());
            event.accept(TekoraItems.BORON_AXE.get());
            event.accept(TekoraItems.BORON_HOE.get());
            event.accept(TekoraItems.BRONZE_SHOVEL.get());
            event.accept(TekoraItems.BRONZE_PICKAXE.get());
            event.accept(TekoraItems.BRONZE_AXE.get());
            event.accept(TekoraItems.BRONZE_HOE.get());
            event.accept(TekoraItems.PLATINUM_SHOVEL.get());
            event.accept(TekoraItems.PLATINUM_PICKAXE.get());
            event.accept(TekoraItems.PLATINUM_AXE.get());
            event.accept(TekoraItems.PLATINUM_HOE.get());
            event.accept(TekoraItems.SILVER_SHOVEL.get());
            event.accept(TekoraItems.SILVER_PICKAXE.get());
            event.accept(TekoraItems.SILVER_AXE.get());
            event.accept(TekoraItems.SILVER_HOE.get());
            event.accept(TekoraItems.STEEL_SHOVEL.get());
            event.accept(TekoraItems.STEEL_PICKAXE.get());
            event.accept(TekoraItems.STEEL_AXE.get());
            event.accept(TekoraItems.STEEL_HOE.get());
            event.accept(TekoraItems.THORIUM_SHOVEL.get());
            event.accept(TekoraItems.THORIUM_PICKAXE.get());
            event.accept(TekoraItems.THORIUM_AXE.get());
            event.accept(TekoraItems.THORIUM_HOE.get());
            event.accept(TekoraItems.TITANIUM_SHOVEL.get());
            event.accept(TekoraItems.TITANIUM_PICKAXE.get());
            event.accept(TekoraItems.TITANIUM_AXE.get());
            event.accept(TekoraItems.TITANIUM_HOE.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_SHOVEL.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_PICKAXE.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_AXE.get());
            event.accept(TekoraItems.TUNGSTEN_STEEL_HOE.get());
            event.accept(TekoraItems.VANASTEEL_SHOVEL.get());
            event.accept(TekoraItems.VANASTEEL_PICKAXE.get());
            event.accept(TekoraItems.VANASTEEL_AXE.get());
            event.accept(TekoraItems.VANASTEEL_HOE.get());
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // source block rendering
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_DEUTERIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_TRITIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HELIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_NITROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_OXYGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_FLUORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_NEON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_CHLORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_ARGON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_KRYPTON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_XENON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_STEAM.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_AMMONIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROGEN_CYANIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROGEN_FLUORIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROGEN_CHLORIDE.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_BROMINE_FLUID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_AMMONIA_FLUID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_AMMONIUM_HYDROXIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROFLUORIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROCHLORIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_NITRIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_SULFURIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_PRUSSIC_ACID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_GALLIUM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_MERCURY_FLUID.get(), RenderType.solid());

            // flowing block rendering
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_DEUTERIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_TRITIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HELIUM_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_NITROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_OXYGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_FLUORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_NEON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_CHLORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_ARGON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_KRYPTON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_XENON_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_STEAM.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_AMMONIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROGEN_CYANIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROGEN_FLUORIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROGEN_CHLORIDE.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_BROMINE_FLUID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_AMMONIA_FLUID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_AMMONIUM_HYDROXIDE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROFLUORIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROCHLORIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_NITRIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_SULFURIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_PRUSSIC_ACID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_GALLIUM_FLUID.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_MERCURY_FLUID.get(), RenderType.solid());

            MenuScreens.register(TekoraMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.INFUSION_FURNACE_MENU.get(), InfusionFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.CENTRIFUGE_MENU.get(), CentrifugeScreen::new);
            MenuScreens.register(TekoraMenuTypes.COMPRESSOR_MENU.get(), CompressorScreen::new);
            MenuScreens.register(TekoraMenuTypes.ELECTRIC_FURNACE_MENU.get(), ElectricFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.BATTERY_MENU.get(), BatteryScreen::new);
            MenuScreens.register(TekoraMenuTypes.PULVERIZER_MENU.get(), PulverizerScreen::new);
            MenuScreens.register(TekoraMenuTypes.HYDROELECTRIC_GENERATOR_MENU.get(), HydroelectricGeneratorScreen::new);
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            event.register((stack, tint) -> tint == 0 ? UtilFunctions.getColor(stack) : -1,
                    TekoraItems.TIN_CANISTER.get(),
                    TekoraItems.AMMONIUM_HYDROXIDE_BUCKET.get(), TekoraItems.BROMINE_BUCKET.get(),
                    TekoraItems.MERCURY_BUCKET.get(), TekoraItems.GALLIUM_BUCKET.get(),
                    TekoraItems.HYDROFLUORIC_ACID_BUCKET.get(), TekoraItems.NITRIC_ACID_BUCKET.get(),
                    TekoraItems.SULFURIC_ACID_BUCKET.get(),

                    TekoraItems.BORON_HELMET.get(),
                    TekoraItems.BORON_CHESTPLATE.get(),
                    TekoraItems.BORON_LEGGINGS.get(),
                    TekoraItems.BORON_BOOTS.get(),
                    TekoraItems.BRONZE_HELMET.get(),
                    TekoraItems.BRONZE_CHESTPLATE.get(),
                    TekoraItems.BRONZE_LEGGINGS.get(),
                    TekoraItems.BRONZE_BOOTS.get(),
                    TekoraItems.PLATINUM_HELMET.get(),
                    TekoraItems.PLATINUM_CHESTPLATE.get(),
                    TekoraItems.PLATINUM_LEGGINGS.get(),
                    TekoraItems.PLATINUM_BOOTS.get(),
                    TekoraItems.SILVER_HELMET.get(),
                    TekoraItems.SILVER_CHESTPLATE.get(),
                    TekoraItems.SILVER_LEGGINGS.get(),
                    TekoraItems.SILVER_BOOTS.get(),
                    TekoraItems.STEEL_HELMET.get(),
                    TekoraItems.STEEL_CHESTPLATE.get(),
                    TekoraItems.STEEL_LEGGINGS.get(),
                    TekoraItems.STEEL_BOOTS.get(),
                    TekoraItems.TITANIUM_HELMET.get(),
                    TekoraItems.TITANIUM_CHESTPLATE.get(),
                    TekoraItems.TITANIUM_LEGGINGS.get(),
                    TekoraItems.TITANIUM_BOOTS.get(),
                    TekoraItems.TUNGSTEN_STEEL_HELMET.get(),
                    TekoraItems.TUNGSTEN_STEEL_CHESTPLATE.get(),
                    TekoraItems.TUNGSTEN_STEEL_LEGGINGS.get(),
                    TekoraItems.TUNGSTEN_STEEL_BOOTS.get(),
                    TekoraItems.VANASTEEL_HELMET.get(),
                    TekoraItems.VANASTEEL_CHESTPLATE.get(),
                    TekoraItems.VANASTEEL_LEGGINGS.get(),
                    TekoraItems.VANASTEEL_BOOTS.get(),

                    TekoraBlocks.ALUMINUM_CABLE.get().asItem(),
                    TekoraBlocks.CUPRONICKEL_CABLE.get().asItem(),
                    TekoraBlocks.ELECTRUM_CABLE.get().asItem(),
                    TekoraBlocks.GOLD_CABLE.get().asItem(),
                    TekoraBlocks.SILVER_CABLE.get().asItem(),
                    TekoraBlocks.TIN_CABLE.get().asItem(),

                    TekoraItems.ALUMINUM_INGOT.get(),
                    TekoraItems.ALUMINUM_NUGGET.get(),
                    TekoraItems.ALUMINUM_DUST.get(),
                    TekoraItems.ALUMINUM_PLATE.get(),
                    TekoraItems.ALUMINUM_WIRE.get(),
                    TekoraItems.ALUMINUM_TINY_DUST.get(),

                    TekoraItems.BARIUM_INGOT.get(),
                    TekoraItems.BARIUM_NUGGET.get(),
                    TekoraItems.BARIUM_DUST.get(),
                    TekoraItems.BARIUM_TINY_DUST.get(),

                    TekoraItems.BERYLLIUM_INGOT.get(),
                    TekoraItems.BERYLLIUM_NUGGET.get(),
                    TekoraItems.BERYLLIUM_DUST.get(),
                    TekoraItems.BERYLLIUM_TINY_DUST.get(),

                    TekoraItems.CADMIUM_INGOT.get(),
                    TekoraItems.CADMIUM_NUGGET.get(),
                    TekoraItems.CADMIUM_DUST.get(),
                    TekoraItems.CADMIUM_PLATE.get(),
                    TekoraItems.CADMIUM_TINY_DUST.get(),

                    TekoraItems.CALCIUM_INGOT.get(),
                    TekoraItems.CALCIUM_NUGGET.get(),
                    TekoraItems.CALCIUM_DUST.get(),
                    TekoraItems.CALCIUM_TINY_DUST.get(),

                    TekoraItems.CERIUM_INGOT.get(),
                    TekoraItems.CERIUM_NUGGET.get(),
                    TekoraItems.CERIUM_DUST.get(),
                    TekoraItems.CERIUM_TINY_DUST.get(),

                    TekoraItems.CESIUM_INGOT.get(),
                    TekoraItems.CESIUM_NUGGET.get(),
                    TekoraItems.CESIUM_DUST.get(),
                    TekoraItems.CESIUM_TINY_DUST.get(),

                    TekoraItems.CHROMIUM_INGOT.get(),
                    TekoraItems.CHROMIUM_NUGGET.get(),
                    TekoraItems.CHROMIUM_DUST.get(),
                    TekoraItems.CHROMIUM_PLATE.get(),
                    TekoraItems.CHROMIUM_TINY_DUST.get(),

                    TekoraItems.COBALT_INGOT.get(),
                    TekoraItems.COBALT_NUGGET.get(),
                    TekoraItems.COBALT_DUST.get(),
                    TekoraItems.COBALT_PLATE.get(),
                    TekoraItems.COBALT_TINY_DUST.get(),

                    TekoraItems.DYSPROSIUM_INGOT.get(),
                    TekoraItems.DYSPROSIUM_NUGGET.get(),
                    TekoraItems.DYSPROSIUM_DUST.get(),
                    TekoraItems.DYSPROSIUM_TINY_DUST.get(),

                    TekoraItems.ERBIUM_INGOT.get(),
                    TekoraItems.ERBIUM_NUGGET.get(),
                    TekoraItems.ERBIUM_DUST.get(),
                    TekoraItems.ERBIUM_TINY_DUST.get(),

                    TekoraItems.EUROPIUM_INGOT.get(),
                    TekoraItems.EUROPIUM_NUGGET.get(),
                    TekoraItems.EUROPIUM_DUST.get(),
                    TekoraItems.EUROPIUM_TINY_DUST.get(),

                    TekoraItems.GADOLINIUM_INGOT.get(),
                    TekoraItems.GADOLINIUM_NUGGET.get(),
                    TekoraItems.GADOLINIUM_DUST.get(),
                    TekoraItems.GADOLINIUM_TINY_DUST.get(),

                    TekoraItems.GALLIUM_INGOT.get(),
                    TekoraItems.GALLIUM_NUGGET.get(),
                    TekoraItems.GALLIUM_DUST.get(),
                    TekoraItems.GALLIUM_TINY_DUST.get(),

                    TekoraItems.HAFNIUM_INGOT.get(),
                    TekoraItems.HAFNIUM_NUGGET.get(),
                    TekoraItems.HAFNIUM_DUST.get(),
                    TekoraItems.HAFNIUM_TINY_DUST.get(),

                    TekoraItems.HOLMIUM_INGOT.get(),
                    TekoraItems.HOLMIUM_NUGGET.get(),
                    TekoraItems.HOLMIUM_DUST.get(),
                    TekoraItems.HOLMIUM_TINY_DUST.get(),

                    TekoraItems.INDIUM_INGOT.get(),
                    TekoraItems.INDIUM_NUGGET.get(),
                    TekoraItems.INDIUM_DUST.get(),
                    TekoraItems.INDIUM_PLATE.get(),
                    TekoraItems.INDIUM_TINY_DUST.get(),

                    TekoraItems.IRIDIUM_INGOT.get(),
                    TekoraItems.IRIDIUM_NUGGET.get(),
                    TekoraItems.IRIDIUM_DUST.get(),
                    TekoraItems.IRIDIUM_TINY_DUST.get(),

                    TekoraItems.LANTHANUM_INGOT.get(),
                    TekoraItems.LANTHANUM_NUGGET.get(),
                    TekoraItems.LANTHANUM_DUST.get(),
                    TekoraItems.LANTHANUM_TINY_DUST.get(),

                    TekoraItems.LEAD_INGOT.get(),
                    TekoraItems.LEAD_NUGGET.get(),
                    TekoraItems.LEAD_DUST.get(),
                    TekoraItems.LEAD_PLATE.get(),
                    TekoraItems.LEAD_TINY_DUST.get(),

                    TekoraItems.LITHIUM_INGOT.get(),
                    TekoraItems.LITHIUM_NUGGET.get(),
                    TekoraItems.LITHIUM_DUST.get(),
                    TekoraItems.LITHIUM_TINY_DUST.get(),

                    TekoraItems.LUTETIUM_INGOT.get(),
                    TekoraItems.LUTETIUM_NUGGET.get(),
                    TekoraItems.LUTETIUM_DUST.get(),
                    TekoraItems.LUTETIUM_TINY_DUST.get(),

                    TekoraItems.MAGNESIUM_INGOT.get(),
                    TekoraItems.MAGNESIUM_NUGGET.get(),
                    TekoraItems.MAGNESIUM_DUST.get(),
                    TekoraItems.MAGNESIUM_PLATE.get(),
                    TekoraItems.MAGNESIUM_TINY_DUST.get(),

                    TekoraItems.MANGANESE_INGOT.get(),
                    TekoraItems.MANGANESE_NUGGET.get(),
                    TekoraItems.MANGANESE_DUST.get(),
                    TekoraItems.MANGANESE_PLATE.get(),
                    TekoraItems.MANGANESE_TINY_DUST.get(),

                    TekoraItems.MOLYBDENUM_INGOT.get(),
                    TekoraItems.MOLYBDENUM_NUGGET.get(),
                    TekoraItems.MOLYBDENUM_DUST.get(),
                    TekoraItems.MOLYBDENUM_PLATE.get(),
                    TekoraItems.MOLYBDENUM_TINY_DUST.get(),

                    TekoraItems.NEODYMIUM_INGOT.get(),
                    TekoraItems.NEODYMIUM_NUGGET.get(),
                    TekoraItems.NEODYMIUM_DUST.get(),
                    TekoraItems.NEODYMIUM_TINY_DUST.get(),

                    TekoraItems.NICKEL_INGOT.get(),
                    TekoraItems.NICKEL_NUGGET.get(),
                    TekoraItems.NICKEL_DUST.get(),
                    TekoraItems.NICKEL_PLATE.get(),
                    TekoraItems.NICKEL_TINY_DUST.get(),

                    TekoraItems.NIOBIUM_INGOT.get(),
                    TekoraItems.NIOBIUM_NUGGET.get(),
                    TekoraItems.NIOBIUM_DUST.get(),
                    TekoraItems.NIOBIUM_TINY_DUST.get(),

                    TekoraItems.OSMIUM_INGOT.get(),
                    TekoraItems.OSMIUM_NUGGET.get(),
                    TekoraItems.OSMIUM_DUST.get(),
                    TekoraItems.OSMIUM_PLATE.get(),
                    TekoraItems.OSMIUM_TINY_DUST.get(),

                    TekoraItems.PALLADIUM_INGOT.get(),
                    TekoraItems.PALLADIUM_NUGGET.get(),
                    TekoraItems.PALLADIUM_DUST.get(),
                    TekoraItems.PALLADIUM_PLATE.get(),
                    TekoraItems.PALLADIUM_TINY_DUST.get(),

                    TekoraItems.PLATINUM_INGOT.get(),
                    TekoraItems.PLATINUM_NUGGET.get(),
                    TekoraItems.PLATINUM_DUST.get(),
                    TekoraItems.PLATINUM_PLATE.get(),
                    TekoraItems.PLATINUM_TINY_DUST.get(),

                    TekoraItems.PRASEODYMIUM_INGOT.get(),
                    TekoraItems.PRASEODYMIUM_NUGGET.get(),
                    TekoraItems.PRASEODYMIUM_DUST.get(),
                    TekoraItems.PRASEODYMIUM_TINY_DUST.get(),

                    TekoraItems.POTASSIUM_INGOT.get(),
                    TekoraItems.POTASSIUM_NUGGET.get(),
                    TekoraItems.POTASSIUM_DUST.get(),
                    TekoraItems.POTASSIUM_TINY_DUST.get(),

                    TekoraItems.RHENIUM_INGOT.get(),
                    TekoraItems.RHENIUM_NUGGET.get(),
                    TekoraItems.RHENIUM_DUST.get(),
                    TekoraItems.RHENIUM_TINY_DUST.get(),

                    TekoraItems.RHODIUM_INGOT.get(),
                    TekoraItems.RHODIUM_NUGGET.get(),
                    TekoraItems.RHODIUM_DUST.get(),
                    TekoraItems.RHODIUM_PLATE.get(),
                    TekoraItems.RHODIUM_TINY_DUST.get(),

                    TekoraItems.RUBIDIUM_INGOT.get(),
                    TekoraItems.RUBIDIUM_DUST.get(),
                    TekoraItems.RUBIDIUM_NUGGET.get(),
                    TekoraItems.RUBIDIUM_TINY_DUST.get(),

                    TekoraItems.RUTHENIUM_INGOT.get(),
                    TekoraItems.RUTHENIUM_NUGGET.get(),
                    TekoraItems.RUTHENIUM_DUST.get(),
                    TekoraItems.RUTHENIUM_TINY_DUST.get(),

                    TekoraItems.SAMARIUM_INGOT.get(),
                    TekoraItems.SAMARIUM_NUGGET.get(),
                    TekoraItems.SAMARIUM_DUST.get(),
                    TekoraItems.SAMARIUM_TINY_DUST.get(),

                    TekoraItems.SCANDIUM_INGOT.get(),
                    TekoraItems.SCANDIUM_NUGGET.get(),
                    TekoraItems.SCANDIUM_DUST.get(),
                    TekoraItems.SCANDIUM_PLATE.get(),
                    TekoraItems.SCANDIUM_TINY_DUST.get(),

                    TekoraItems.SILVER_INGOT.get(),
                    TekoraItems.SILVER_NUGGET.get(),
                    TekoraItems.SILVER_DUST.get(),
                    TekoraItems.SILVER_PLATE.get(),
                    TekoraItems.SILVER_TINY_DUST.get(),
                    TekoraItems.SILVER_WIRE.get(),

                    TekoraItems.SODIUM_INGOT.get(),
                    TekoraItems.SODIUM_NUGGET.get(),
                    TekoraItems.SODIUM_DUST.get(),
                    TekoraItems.SODIUM_TINY_DUST.get(),

                    TekoraItems.STRONTIUM_INGOT.get(),
                    TekoraItems.STRONTIUM_NUGGET.get(),
                    TekoraItems.STRONTIUM_DUST.get(),
                    TekoraItems.STRONTIUM_TINY_DUST.get(),

                    TekoraItems.TANTALUM_INGOT.get(),
                    TekoraItems.TANTALUM_NUGGET.get(),
                    TekoraItems.TANTALUM_DUST.get(),
                    TekoraItems.TANTALUM_TINY_DUST.get(),

                    TekoraItems.TERBIUM_INGOT.get(),
                    TekoraItems.TERBIUM_NUGGET.get(),
                    TekoraItems.TERBIUM_DUST.get(),
                    TekoraItems.TERBIUM_TINY_DUST.get(),

                    TekoraItems.THALLIUM_INGOT.get(),
                    TekoraItems.THALLIUM_NUGGET.get(),
                    TekoraItems.THALLIUM_DUST.get(),
                    TekoraItems.THALLIUM_TINY_DUST.get(),

                    TekoraItems.THORIUM_INGOT.get(),
                    TekoraItems.THORIUM_NUGGET.get(),
                    TekoraItems.THORIUM_DUST.get(),
                    TekoraItems.THORIUM_PLATE.get(),
                    TekoraItems.THORIUM_TINY_DUST.get(),

                    TekoraItems.THULIUM_INGOT.get(),
                    TekoraItems.THULIUM_NUGGET.get(),
                    TekoraItems.THULIUM_DUST.get(),
                    TekoraItems.THULIUM_PLATE.get(),
                    TekoraItems.THULIUM_TINY_DUST.get(),

                    TekoraItems.TIN_INGOT.get(),
                    TekoraItems.TIN_NUGGET.get(),
                    TekoraItems.TIN_DUST.get(),
                    TekoraItems.TIN_PLATE.get(),
                    TekoraItems.TIN_TINY_DUST.get(),
                    TekoraItems.TIN_WIRE.get(),

                    TekoraItems.TITANIUM_INGOT.get(),
                    TekoraItems.TITANIUM_NUGGET.get(),
                    TekoraItems.TITANIUM_DUST.get(),
                    TekoraItems.TITANIUM_PLATE.get(),
                    TekoraItems.TITANIUM_TINY_DUST.get(),

                    TekoraItems.TUNGSTEN_INGOT.get(),
                    TekoraItems.TUNGSTEN_NUGGET.get(),
                    TekoraItems.TUNGSTEN_DUST.get(),
                    TekoraItems.TUNGSTEN_PLATE.get(),
                    TekoraItems.TUNGSTEN_TINY_DUST.get(),

                    TekoraItems.URANIUM_INGOT.get(),
                    TekoraItems.URANIUM_NUGGET.get(),
                    TekoraItems.URANIUM_DUST.get(),
                    TekoraItems.URANIUM_TINY_DUST.get(),

                    TekoraItems.VANADIUM_INGOT.get(),
                    TekoraItems.VANADIUM_NUGGET.get(),
                    TekoraItems.VANADIUM_DUST.get(),
                    TekoraItems.VANADIUM_TINY_DUST.get(),

                    TekoraItems.YTTERBIUM_INGOT.get(),
                    TekoraItems.YTTERBIUM_NUGGET.get(),
                    TekoraItems.YTTERBIUM_DUST.get(),
                    TekoraItems.YTTERBIUM_PLATE.get(),
                    TekoraItems.YTTERBIUM_TINY_DUST.get(),

                    TekoraItems.YTTRIUM_INGOT.get(),
                    TekoraItems.YTTRIUM_NUGGET.get(),
                    TekoraItems.YTTRIUM_DUST.get(),
                    TekoraItems.YTTRIUM_TINY_DUST.get(),

                    TekoraItems.ZINC_INGOT.get(),
                    TekoraItems.ZINC_NUGGET.get(),
                    TekoraItems.ZINC_DUST.get(),
                    TekoraItems.ZINC_PLATE.get(),
                    TekoraItems.ZINC_TINY_DUST.get(),

                    TekoraItems.ZIRCONIUM_INGOT.get(),
                    TekoraItems.ZIRCONIUM_NUGGET.get(),
                    TekoraItems.ZIRCONIUM_DUST.get(),
                    TekoraItems.ZIRCONIUM_PLATE.get(),
                    TekoraItems.ZIRCONIUM_TINY_DUST.get(),

                    TekoraItems.BRASS_INGOT.get(),
                    TekoraItems.BRASS_NUGGET.get(),
                    TekoraItems.BRASS_DUST.get(),
                    TekoraItems.BRASS_PLATE.get(),
                    TekoraItems.BRASS_TINY_DUST.get(),

                    TekoraItems.BRONZE_INGOT.get(),
                    TekoraItems.BRONZE_NUGGET.get(),
                    TekoraItems.BRONZE_DUST.get(),
                    TekoraItems.BRONZE_PLATE.get(),
                    TekoraItems.BRONZE_TINY_DUST.get(),

                    TekoraItems.CARBON_STEEL_INGOT.get(),
                    TekoraItems.CARBON_STEEL_NUGGET.get(),
                    TekoraItems.CARBON_STEEL_DUST.get(),
                    TekoraItems.CARBON_STEEL_ROD.get(),
                    TekoraItems.CARBON_STEEL_TINY_DUST.get(),

                    TekoraItems.CHROMOLY_STEEL_INGOT.get(),
                    TekoraItems.CHROMOLY_STEEL_NUGGET.get(),
                    TekoraItems.CHROMOLY_STEEL_DUST.get(),
                    TekoraItems.CHROMOLY_STEEL_PLATE.get(),
                    TekoraItems.CHROMOLY_STEEL_TINY_DUST.get(),

                    TekoraItems.CUPRONICKEL_INGOT.get(),
                    TekoraItems.CUPRONICKEL_NUGGET.get(),
                    TekoraItems.CUPRONICKEL_DUST.get(),
                    TekoraItems.CUPRONICKEL_PLATE.get(),
                    TekoraItems.CUPRONICKEL_TINY_DUST.get(),
                    TekoraItems.CUPRONICKEL_WIRE.get(),

                    TekoraItems.ELECTRUM_INGOT.get(),
                    TekoraItems.ELECTRUM_NUGGET.get(),
                    TekoraItems.ELECTRUM_DUST.get(),
                    TekoraItems.ELECTRUM_PLATE.get(),
                    TekoraItems.ELECTRUM_TINY_DUST.get(),
                    TekoraItems.ELECTRUM_WIRE.get(),

                    TekoraItems.FERROBORON_INGOT.get(),
                    TekoraItems.FERROBORON_NUGGET.get(),
                    TekoraItems.FERROBORON_DUST.get(),
                    TekoraItems.FERROBORON_PLATE.get(),
                    TekoraItems.FERROBORON_TINY_DUST.get(),

                    TekoraItems.GALVANIZED_STEEL_INGOT.get(),
                    TekoraItems.GALVANIZED_STEEL_PLATE.get(),

                    TekoraItems.HSLA_STEEL_INGOT.get(),
                    TekoraItems.HSLA_STEEL_NUGGET.get(),
                    TekoraItems.HSLA_STEEL_DUST.get(),
                    TekoraItems.HSLA_STEEL_PLATE.get(),
                    TekoraItems.HSLA_STEEL_TINY_DUST.get(),

                    TekoraItems.INCONEL_INGOT.get(),
                    TekoraItems.INCONEL_NUGGET.get(),
                    TekoraItems.INCONEL_DUST.get(),
                    TekoraItems.INCONEL_TINY_DUST.get(),
                    TekoraItems.INCONEL_PLATE.get(),

                    TekoraItems.INVAR_INGOT.get(),
                    TekoraItems.INVAR_NUGGET.get(),
                    TekoraItems.INVAR_DUST.get(),
                    TekoraItems.INVAR_PLATE.get(),
                    TekoraItems.INVAR_TINY_DUST.get(),

                    TekoraItems.MAGNETIC_NEODYMIUM_INGOT.get(),
                    TekoraItems.MAGNETIC_NEODYMIUM_NUGGET.get(),
                    TekoraItems.MAGNETIC_NEODYMIUM_DUST.get(),
                    TekoraItems.MAGNETIC_NEODYMIUM_PLATE.get(),
                    TekoraItems.MAGNETIC_NEODYMIUM_TINY_DUST.get(),

                    TekoraItems.MU_METAL_INGOT.get(),
                    TekoraItems.MU_METAL_NUGGET.get(),
                    TekoraItems.MU_METAL_DUST.get(),
                    TekoraItems.MU_METAL_PLATE.get(),
                    TekoraItems.MU_METAL_TINY_DUST.get(),

                    TekoraItems.REACTOR_STEEL_INGOT.get(),
                    TekoraItems.REACTOR_STEEL_NUGGET.get(),
                    TekoraItems.REACTOR_STEEL_DUST.get(),
                    TekoraItems.REACTOR_STEEL_PLATE.get(),
                    TekoraItems.REACTOR_STEEL_TINY_DUST.get(),

                    TekoraItems.STAINLESS_STEEL_INGOT.get(),
                    TekoraItems.STAINLESS_STEEL_NUGGET.get(),
                    TekoraItems.STAINLESS_STEEL_DUST.get(),
                    TekoraItems.STAINLESS_STEEL_PLATE.get(),
                    TekoraItems.STAINLESS_STEEL_TINY_DUST.get(),

                    TekoraItems.STEEL_INGOT.get(),
                    TekoraItems.STEEL_NUGGET.get(),
                    TekoraItems.STEEL_DUST.get(),
                    TekoraItems.STEEL_PLATE.get(),
                    TekoraItems.STEEL_ROD.get(),
                    TekoraItems.STEEL_TINY_DUST.get(),

                    TekoraItems.TUNGSTEN_CARBIDE_INGOT.get(),
                    TekoraItems.TUNGSTEN_CARBIDE_NUGGET.get(),
                    TekoraItems.TUNGSTEN_CARBIDE_DUST.get(),
                    TekoraItems.TUNGSTEN_CARBIDE_PLATE.get(),
                    TekoraItems.TUNGSTEN_CARBIDE_TINY_DUST.get(),

                    TekoraItems.TUNGSTEN_STEEL_INGOT.get(),
                    TekoraItems.TUNGSTEN_STEEL_NUGGET.get(),
                    TekoraItems.TUNGSTEN_STEEL_DUST.get(),
                    TekoraItems.TUNGSTEN_STEEL_PLATE.get(),
                    TekoraItems.TUNGSTEN_STEEL_TINY_DUST.get(),

                    TekoraItems.VANASTEEL_INGOT.get(),
                    TekoraItems.VANASTEEL_NUGGET.get(),
                    TekoraItems.VANASTEEL_DUST.get(),
                    TekoraItems.VANASTEEL_PLATE.get(),
                    TekoraItems.VANASTEEL_TINY_DUST.get(),

                    TekoraItems.ZIRCALOY_INGOT.get(),
                    TekoraItems.ZIRCALOY_NUGGET.get(),
                    TekoraItems.ZIRCALOY_DUST.get(),
                    TekoraItems.ZIRCALOY_PLATE.get(),
                    TekoraItems.ZIRCALOY_TINY_DUST.get(),

                    TekoraItems.ANTIMONY_PIECE.get(),
                    TekoraItems.ANTIMONY_DUST.get(),
                    TekoraItems.ANTIMONY_TINY_DUST.get(),

                    TekoraItems.ARSENIC_PIECE.get(),
                    TekoraItems.ARSENIC_DUST.get(),
                    TekoraItems.ARSENIC_TINY_DUST.get(),

                    TekoraItems.BORON_PIECE.get(),
                    TekoraItems.BORON_DUST.get(),
                    TekoraItems.BORON_TINY_DUST.get(),

                    TekoraItems.GERMANIUM_PIECE.get(),
                    TekoraItems.GERMANIUM_DUST.get(),
                    TekoraItems.GERMANIUM_TINY_DUST.get(),

                    TekoraItems.SILICON_PIECE.get(),
                    TekoraItems.SILICON_DUST.get(),
                    TekoraItems.SILICON_TINY_DUST.get(),

                    TekoraItems.TELLURIUM_PIECE.get(),
                    TekoraItems.TELLURIUM_DUST.get(),
                    TekoraItems.TELLURIUM_TINY_DUST.get(),

                    TekoraItems.MAGNESIUM_DIBORIDE.get(),
                    TekoraItems.NIOBIUM_TIN.get(),
                    TekoraItems.SILICON_CARBIDE.get()
            );

            event.register((stack, tint) -> tint == 1 ? UtilFunctions.getColor(stack) : -1,
                    TekoraItems.BORON_SWORD.get(),
                    TekoraItems.BRONZE_SWORD.get(),
                    TekoraItems.PLATINUM_SWORD.get(),
                    TekoraItems.SILVER_SWORD.get(),
                    TekoraItems.STEEL_SWORD.get(),
                    TekoraItems.THORIUM_SWORD.get(),
                    TekoraItems.TITANIUM_SWORD.get(),
                    TekoraItems.TUNGSTEN_STEEL_SWORD.get(),
                    TekoraItems.VANASTEEL_SWORD.get(),
                    TekoraItems.BORON_AXE.get(),
                    TekoraItems.BRONZE_AXE.get(),
                    TekoraItems.PLATINUM_AXE.get(),
                    TekoraItems.SILVER_AXE.get(),
                    TekoraItems.STEEL_AXE.get(),
                    TekoraItems.THORIUM_AXE.get(),
                    TekoraItems.TITANIUM_AXE.get(),
                    TekoraItems.TUNGSTEN_STEEL_AXE.get(),
                    TekoraItems.VANASTEEL_AXE.get(),
                    TekoraItems.BORON_PICKAXE.get(),
                    TekoraItems.BRONZE_PICKAXE.get(),
                    TekoraItems.PLATINUM_PICKAXE.get(),
                    TekoraItems.SILVER_PICKAXE.get(),
                    TekoraItems.STEEL_PICKAXE.get(),
                    TekoraItems.THORIUM_PICKAXE.get(),
                    TekoraItems.TITANIUM_PICKAXE.get(),
                    TekoraItems.TUNGSTEN_STEEL_PICKAXE.get(),
                    TekoraItems.VANASTEEL_PICKAXE.get(),
                    TekoraItems.DIAMOND_HAMMER.get(),
                    TekoraItems.GOLDEN_HAMMER.get(),
                    TekoraItems.IRON_HAMMER.get(),
                    TekoraItems.NETHERITE_HAMMER.get(),
                    TekoraItems.BORON_HAMMER.get(),
                    TekoraItems.BRONZE_HAMMER.get(),
                    TekoraItems.PLATINUM_HAMMER.get(),
                    TekoraItems.SILVER_HAMMER.get(),
                    TekoraItems.STEEL_HAMMER.get(),
                    TekoraItems.THORIUM_HAMMER.get(),
                    TekoraItems.TITANIUM_HAMMER.get(),
                    TekoraItems.TUNGSTEN_STEEL_HAMMER.get(),
                    TekoraItems.VANASTEEL_HAMMER.get(),
                    TekoraItems.BORON_SHOVEL.get(),
                    TekoraItems.BRONZE_SHOVEL.get(),
                    TekoraItems.PLATINUM_SHOVEL.get(),
                    TekoraItems.SILVER_SHOVEL.get(),
                    TekoraItems.STEEL_SHOVEL.get(),
                    TekoraItems.THORIUM_SHOVEL.get(),
                    TekoraItems.TITANIUM_SHOVEL.get(),
                    TekoraItems.TUNGSTEN_STEEL_SHOVEL.get(),
                    TekoraItems.VANASTEEL_SHOVEL.get(),
                    TekoraItems.BORON_HOE.get(),
                    TekoraItems.BRONZE_HOE.get(),
                    TekoraItems.PLATINUM_HOE.get(),
                    TekoraItems.SILVER_HOE.get(),
                    TekoraItems.STEEL_HOE.get(),
                    TekoraItems.THORIUM_HOE.get(),
                    TekoraItems.TITANIUM_HOE.get(),
                    TekoraItems.TUNGSTEN_STEEL_HOE.get(),
                    TekoraItems.VANASTEEL_HOE.get()
            );
        }

        @SubscribeEvent
        public static void modelInit(ModelEvent.RegisterGeometryLoaders event) {
            CableModel.register(event);
        }

        @SubscribeEvent
        public static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
            event.register((state, lvl, pos, ind) -> state.getBlock() instanceof EnergyCable cable ? cable.getColor() : -1,
                    TekoraBlocks.ALUMINUM_CABLE.get(), TekoraBlocks.ALUMINUM_CABLE_FACADE.get(),
                    TekoraBlocks.COPPER_CABLE_FACADE.get(), TekoraBlocks.COPPER_CABLE.get(),
                    TekoraBlocks.CUPRONICKEL_CABLE_FACADE.get(), TekoraBlocks.CUPRONICKEL_CABLE.get(),
                    TekoraBlocks.ELECTRUM_CABLE_FACADE.get(), TekoraBlocks.ELECTRUM_CABLE.get(),
                    TekoraBlocks.GOLD_CABLE_FACADE.get(), TekoraBlocks.GOLD_CABLE.get(),
                    TekoraBlocks.SILVER_CABLE_FACADE.get(), TekoraBlocks.SILVER_CABLE.get(),
                    TekoraBlocks.TIN_CABLE_FACADE.get(), TekoraBlocks.TIN_CABLE.get());
        }
    }
}
