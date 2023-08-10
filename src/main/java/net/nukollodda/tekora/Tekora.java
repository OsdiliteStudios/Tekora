package net.nukollodda.tekora;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.fluid.TekoraFluidTypes;
import net.nukollodda.tekora.block.fluid.TekoraFluids;
import net.nukollodda.tekora.client.screens.*;
import net.nukollodda.tekora.item.TekoraCreativeModTab;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.menu.*;
import net.nukollodda.tekora.recipes.TekoraRecipes;
import org.slf4j.Logger;

@Mod(Tekora.MODID)
public class Tekora {
    /** Thanks to <a href="https://github.com/Tutorials-By-Kaupenjoe">Kaupenjoe</a> for making a tutorial for modding for
     * the Tekora team! As some code in this project were copied directly from his tutorials.
     **/
    public static final String MODID = "tekora";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Tekora() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TekoraItems.register(modEventBus);
        TekoraBlocks.register(modEventBus);

        TekoraBlockEntities.register(modEventBus);
        TekoraMenuTypes.register(modEventBus);

        TekoraCreativeModTab.register(modEventBus);

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


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_HYDROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_NITROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_OXYGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_FLUORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_CHLORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_STEAM.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.SOURCE_MERCURY_FLUID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_HYDROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_NITROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_OXYGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_FLUORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_CHLORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_STEAM.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(TekoraFluids.FLOWING_MERCURY_FLUID.get(), RenderType.translucent());

            MenuScreens.register(TekoraMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.INFUSION_FURNACE_MENU.get(), InfusionFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
            MenuScreens.register(TekoraMenuTypes.ELECTRIC_FURNACE_MENU.get(), ElectricFurnaceScreen::new);
            MenuScreens.register(TekoraMenuTypes.BATTERY_MENU.get(), BatteryScreen::new);
        }
    }
}
