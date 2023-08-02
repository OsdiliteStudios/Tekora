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
import net.nukollodda.tekora.block.ModBlocks;
import net.nukollodda.tekora.block.entity.entities.ModBlockEntities;
import net.nukollodda.tekora.fluid.ModFluidTypes;
import net.nukollodda.tekora.fluid.ModFluids;
import net.nukollodda.tekora.item.ModCreativeModTab;
import net.nukollodda.tekora.item.ModItems;
import net.nukollodda.tekora.menu.*;
import net.nukollodda.tekora.recipes.ModRecipes;
import org.slf4j.Logger;

@Mod(Tekora.MODID)
public class Tekora {
    public static final String MODID = "tekora";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Tekora() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModCreativeModTab.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.BORON_SWORD.get());
            event.accept(ModItems.BRONZE_SWORD.get());
            event.accept(ModItems.PLATINUM_SWORD.get());
            event.accept(ModItems.SILVER_SWORD.get());
            event.accept(ModItems.STEEL_SWORD.get());
            event.accept(ModItems.THORIUM_SWORD.get());
            event.accept(ModItems.TITANIUM_SWORD.get());
            event.accept(ModItems.TUNGSTEN_STEEL_SWORD.get());
            event.accept(ModItems.VANASTEEL_SWORD.get());

            event.accept(ModItems.BORON_AXE.get());
            event.accept(ModItems.BRONZE_AXE.get());
            event.accept(ModItems.PLATINUM_AXE.get());
            event.accept(ModItems.SILVER_AXE.get());
            event.accept(ModItems.STEEL_AXE.get());
            event.accept(ModItems.THORIUM_AXE.get());
            event.accept(ModItems.TITANIUM_AXE.get());
            event.accept(ModItems.TUNGSTEN_STEEL_AXE.get());
            event.accept(ModItems.VANASTEEL_AXE.get());

            event.accept(ModItems.DIAMOND_HAMMER.get());
            event.accept(ModItems.GOLDEN_HAMMER.get());
            event.accept(ModItems.IRON_HAMMER.get());
            event.accept(ModItems.NETHERITE_HAMMER.get());

            event.accept(ModItems.BORON_HAMMER.get());
            event.accept(ModItems.BRONZE_HAMMER.get());
            event.accept(ModItems.PLATINUM_HAMMER.get());
            event.accept(ModItems.SILVER_HAMMER.get());
            event.accept(ModItems.STEEL_HAMMER.get());
            event.accept(ModItems.THORIUM_HAMMER.get());
            event.accept(ModItems.TITANIUM_HAMMER.get());
            event.accept(ModItems.TUNGSTEN_STEEL_HAMMER.get());
            event.accept(ModItems.VANASTEEL_HAMMER.get());

            event.accept(ModItems.BORON_HELMET.get());
            event.accept(ModItems.BORON_CHESTPLATE.get());
            event.accept(ModItems.BORON_LEGGINGS.get());
            event.accept(ModItems.BORON_BOOTS.get());
            event.accept(ModItems.BRONZE_HELMET.get());
            event.accept(ModItems.BRONZE_CHESTPLATE.get());
            event.accept(ModItems.BRONZE_LEGGINGS.get());
            event.accept(ModItems.BRONZE_BOOTS.get());
            event.accept(ModItems.PLATINUM_HELMET.get());
            event.accept(ModItems.PLATINUM_CHESTPLATE.get());
            event.accept(ModItems.PLATINUM_LEGGINGS.get());
            event.accept(ModItems.PLATINUM_BOOTS.get());
            event.accept(ModItems.SILVER_HELMET.get());
            event.accept(ModItems.SILVER_CHESTPLATE.get());
            event.accept(ModItems.SILVER_LEGGINGS.get());
            event.accept(ModItems.SILVER_BOOTS.get());
            event.accept(ModItems.STEEL_HELMET.get());
            event.accept(ModItems.STEEL_CHESTPLATE.get());
            event.accept(ModItems.STEEL_LEGGINGS.get());
            event.accept(ModItems.STEEL_BOOTS.get());
            event.accept(ModItems.TITANIUM_HELMET.get());
            event.accept(ModItems.TITANIUM_CHESTPLATE.get());
            event.accept(ModItems.TITANIUM_LEGGINGS.get());
            event.accept(ModItems.TITANIUM_BOOTS.get());
            event.accept(ModItems.TUNGSTEN_STEEL_HELMET.get());
            event.accept(ModItems.TUNGSTEN_STEEL_CHESTPLATE.get());
            event.accept(ModItems.TUNGSTEN_STEEL_LEGGINGS.get());
            event.accept(ModItems.TUNGSTEN_STEEL_BOOTS.get());
            event.accept(ModItems.VANASTEEL_HELMET.get());
            event.accept(ModItems.VANASTEEL_CHESTPLATE.get());
            event.accept(ModItems.VANASTEEL_LEGGINGS.get());
            event.accept(ModItems.VANASTEEL_BOOTS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.DIAMOND_HAMMER.get());
            event.accept(ModItems.GOLDEN_HAMMER.get());
            event.accept(ModItems.IRON_HAMMER.get());
            event.accept(ModItems.NETHERITE_HAMMER.get());

            event.accept(ModItems.BORON_HAMMER.get());
            event.accept(ModItems.BRONZE_HAMMER.get());
            event.accept(ModItems.PLATINUM_HAMMER.get());
            event.accept(ModItems.SILVER_HAMMER.get());
            event.accept(ModItems.STEEL_HAMMER.get());
            event.accept(ModItems.THORIUM_HAMMER.get());
            event.accept(ModItems.TITANIUM_HAMMER.get());
            event.accept(ModItems.TUNGSTEN_STEEL_HAMMER.get());
            event.accept(ModItems.VANASTEEL_HAMMER.get());

            event.accept(ModItems.BORON_SHOVEL.get());
            event.accept(ModItems.BORON_PICKAXE.get());
            event.accept(ModItems.BORON_AXE.get());
            event.accept(ModItems.BORON_HOE.get());
            event.accept(ModItems.BRONZE_SHOVEL.get());
            event.accept(ModItems.BRONZE_PICKAXE.get());
            event.accept(ModItems.BRONZE_AXE.get());
            event.accept(ModItems.BRONZE_HOE.get());
            event.accept(ModItems.PLATINUM_SHOVEL.get());
            event.accept(ModItems.PLATINUM_PICKAXE.get());
            event.accept(ModItems.PLATINUM_AXE.get());
            event.accept(ModItems.PLATINUM_HOE.get());
            event.accept(ModItems.SILVER_SHOVEL.get());
            event.accept(ModItems.SILVER_PICKAXE.get());
            event.accept(ModItems.SILVER_AXE.get());
            event.accept(ModItems.SILVER_HOE.get());
            event.accept(ModItems.STEEL_SHOVEL.get());
            event.accept(ModItems.STEEL_PICKAXE.get());
            event.accept(ModItems.STEEL_AXE.get());
            event.accept(ModItems.STEEL_HOE.get());
            event.accept(ModItems.THORIUM_SHOVEL.get());
            event.accept(ModItems.THORIUM_PICKAXE.get());
            event.accept(ModItems.THORIUM_AXE.get());
            event.accept(ModItems.THORIUM_HOE.get());
            event.accept(ModItems.TITANIUM_SHOVEL.get());
            event.accept(ModItems.TITANIUM_PICKAXE.get());
            event.accept(ModItems.TITANIUM_AXE.get());
            event.accept(ModItems.TITANIUM_HOE.get());
            event.accept(ModItems.TUNGSTEN_STEEL_SHOVEL.get());
            event.accept(ModItems.TUNGSTEN_STEEL_PICKAXE.get());
            event.accept(ModItems.TUNGSTEN_STEEL_AXE.get());
            event.accept(ModItems.TUNGSTEN_STEEL_HOE.get());
            event.accept(ModItems.VANASTEEL_SHOVEL.get());
            event.accept(ModItems.VANASTEEL_PICKAXE.get());
            event.accept(ModItems.VANASTEEL_AXE.get());
            event.accept(ModItems.VANASTEEL_HOE.get());
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_CHLORINE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_CHLORINE.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.INFUSION_FURNACE_MENU.get(), InfusionFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
        }
    }
}
