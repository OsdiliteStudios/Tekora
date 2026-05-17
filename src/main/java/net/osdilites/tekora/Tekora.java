package net.osdilites.tekora;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.renderer.RotationalEntityRenderer;
import net.osdilites.tekora.fluid.TekoraFluidTypes;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.item.TekoraCreativeTabs;
import net.osdilites.tekora.menu.TekoraMenus;
import net.osdilites.tekora.menu.screens.ItemTransportScreen;
import net.osdilites.tekora.menu.screens.KilnFurnaceScreen;
import org.slf4j.Logger;

@Mod(Tekora.MODID)
public class Tekora {
    /** Thanks to <a href="https://github.com/Tutorials-By-Kaupenjoe">Kaupenjoe</a> for making a tutorial for modding for
     * the Tekora team! As some code in this project were copied directly from his tutorials.
     */
    public static final String MODID = "tekora";
    public static final Logger LOGGER = LogUtils.getLogger();
    public Tekora(IEventBus modEventBus, ModContainer modContainer) {
        //modEventBus.addListener(this::commonSetup);
        TekoraBlocks.register(modEventBus);
        TekoraItems.register(modEventBus);
        TekoraBlockEntities.register(modEventBus);
        TekoraMenus.register(modEventBus);

        TekoraCreativeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
//        }
//        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
//        }
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
//        MenuScreens.register(TekoraMenus.KILN_FURNACE_MENU, KilnFurnaceScreen::new);
//        MenuScreens.register(TekoraMenus.ITEM_TRANSPORT_MENU, ItemTransportScreen::new);
    }

    @SubscribeEvent
    public static void registerBlockRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(TekoraBlockEntities.COGWHEEL.get(), RotationalEntityRenderer::new);
    }
}
