package net.osdilites.tekora.event;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.renderer.ModularGearRenderer;
import net.osdilites.tekora.block.renderer.ModularRotatingRenderer;
import net.osdilites.tekora.block.renderer.ModularUpDownPartRenderer;
import net.osdilites.tekora.block.renderer.RotationalEntityRenderer;
import net.osdilites.tekora.menu.TekoraMenus;
import net.osdilites.tekora.menu.screens.BasinScreen;
import net.osdilites.tekora.menu.screens.DepotScreen;
import net.osdilites.tekora.menu.screens.KilnFurnaceScreen;

@EventBusSubscriber(modid = Tekora.MODID)
public class ClientEvent {
    private static final Identifier CRUSHING_WHEEL = Identifier.fromNamespaceAndPath(Tekora.MODID, "crushing_wheel");
    private static final Identifier MIXER = Identifier.fromNamespaceAndPath(Tekora.MODID, "mixer");
    private static final Identifier CUTTER = Identifier.fromNamespaceAndPath(Tekora.MODID, "cutter");
    private static final Identifier INK_PRESS_SHAFT = Identifier.fromNamespaceAndPath(Tekora.MODID, "ink_press_shaft");
    private static final Identifier PRESS_SHAFT = Identifier.fromNamespaceAndPath(Tekora.MODID, "press_shaft");

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        registerGeneralRotator(event, TekoraBlockEntities.HAND_CRANK.get());
        registerGeneralRotator(event, TekoraBlockEntities.SHAFT.get());

        registerModularRotating(event, TekoraBlockEntities.CRUSHER.get(), CRUSHING_WHEEL);
        registerWithGearPart(event, TekoraBlockEntities.CRUSHER.get());

        registerModularRotating(event, TekoraBlockEntities.MIXER.get(), MIXER);
        registerWithGearPart(event, TekoraBlockEntities.MIXER.get());

        registerModularUpDown(event, TekoraBlockEntities.CUTTER.get(), CUTTER);
        registerWithGearPart(event, TekoraBlockEntities.CUTTER.get());

        registerModularUpDown(event, TekoraBlockEntities.PRINTER.get(), INK_PRESS_SHAFT);
        registerWithGearPart(event, TekoraBlockEntities.PRINTER.get());

        registerModularUpDown(event, TekoraBlockEntities.PRESS.get(), PRESS_SHAFT);
        registerWithGearPart(event, TekoraBlockEntities.PRESS.get());

        registerWithGearPart(event, TekoraBlockEntities.TOP_MECH.get());
    }

    private static void registerWithGearPart(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type) {
        event.registerBlockEntityRenderer(type, ModularGearRenderer::new);
    }

    private static void registerModularUpDown(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type, Identifier identifier) {
        event.registerBlockEntityRenderer(type, c -> new ModularUpDownPartRenderer(c, identifier));
    }

    private static void registerModularRotating(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type, Identifier identifier) {
        event.registerBlockEntityRenderer(type, c -> new ModularRotatingRenderer(c, identifier));
    }

    private static void registerGeneralRotator(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type) {
        event.registerBlockEntityRenderer(type, RotationalEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(TekoraMenus.BASIN_MENU.get(), BasinScreen::new);
        event.register(TekoraMenus.DEPOT_MENU.get(), DepotScreen::new);
        event.register(TekoraMenus.KILN_FURNACE_MENU.get(), KilnFurnaceScreen::new);
    }
}
