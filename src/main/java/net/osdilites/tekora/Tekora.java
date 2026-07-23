package net.osdilites.tekora;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.item.TekoraCreativeTabs;
import net.osdilites.tekora.menu.TekoraMenus;
import org.slf4j.Logger;

@Mod(Tekora.MODID)
public class Tekora {
    /** Thanks to <a href="https://github.com/Tutorials-By-Kaupenjoe">Kaupenjoe</a> for making a tutorial for modding for
     * the Tekora team! As some code in this project were copied directly from his tutorials.
     */
    public static final String MODID = "tekora";
    public static final Logger LOGGER = LogUtils.getLogger();
    public Tekora(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        TekoraBlocks.register(modEventBus);
        TekoraComponents.register(modEventBus);
        TekoraItems.register(modEventBus);
        TekoraMenus.register(modEventBus);
        TekoraBlockEntities.register(modEventBus);
        TekoraCreativeTabs.register(modEventBus);

        // uncomment the code below if a subscribe event annotated method was here.
        //NeoForge.EVENT_BUS.register(ClientEvent.class);
        //NeoForge.EVENT_BUS.register(WorldEvent.class);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
//        }
//        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
//        }
    }
}
