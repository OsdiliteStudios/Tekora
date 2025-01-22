package net.tekoramods.tekora;

import com.mojang.logging.LogUtils;
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
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import net.tekoramods.tekora.fluid.TekoraFluidTypes;
import net.tekoramods.tekora.item.TekoraItems;
import net.tekoramods.tekora.item.TekoraCreativeTabs;
import net.tekoramods.tekora.menu.TekoraMenus;
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
        TekoraMenus.register(modEventBus);
        TekoraCreativeTabs.register(modEventBus);
        TekoraFluidTypes.register(modEventBus);
        //TekoraRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        //modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            // todo
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            // todo
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {}

        @SubscribeEvent
        public static void modelInit(ModelEvent.RegisterGeometryLoaders event) {
        }

        @SubscribeEvent
        public static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
        }
    }
}
