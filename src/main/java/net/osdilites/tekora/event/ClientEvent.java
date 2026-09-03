package net.osdilites.tekora.event;

import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.geometry.QuadCollection;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelKey;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.renderers.*;
import net.osdilites.tekora.menu.TekoraMenus;
import net.osdilites.tekora.menu.screens.BasinScreen;
import net.osdilites.tekora.menu.screens.DepotScreen;
import net.osdilites.tekora.menu.screens.KilnFurnaceScreen;
import net.osdilites.tekora.renderers.models.ModularPartModel;
import net.osdilites.tekora.renderers.models.TekoraBlockRenderers;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = Tekora.MODID)
public class ClientEvent {
    private static final Identifier CRUSHING_WHEEL = Identifier.fromNamespaceAndPath(Tekora.MODID, "block/crushing_wheel");
    private static final Identifier MIXER = Identifier.fromNamespaceAndPath(Tekora.MODID, "block/whisk");
    private static final Identifier CUTTER = Identifier.fromNamespaceAndPath(Tekora.MODID, "block/cutter");
    private static final Identifier INK_PRESS_SHAFT = Identifier.fromNamespaceAndPath(Tekora.MODID, "block/ink_press_shaft");
    private static final Identifier PRESS_SHAFT = Identifier.fromNamespaceAndPath(Tekora.MODID, "block/press_shaft");

    private static final StandaloneModelKey<QuadCollection> CRUSHING_WHEEL_KEY = new StandaloneModelKey<>(CRUSHING_WHEEL::toString);
    private static final StandaloneModelKey<QuadCollection> MIXER_KEY = new StandaloneModelKey<>(MIXER::toString);
    private static final StandaloneModelKey<QuadCollection> CUTTER_KEY = new StandaloneModelKey<>(CUTTER::toString);
    private static final StandaloneModelKey<QuadCollection> INK_PRESS_SHAFT_KEY = new StandaloneModelKey<>(INK_PRESS_SHAFT::toString);
    private static final StandaloneModelKey<QuadCollection> PRESS_SHAFT_KEY = new StandaloneModelKey<>(PRESS_SHAFT::toString);

    private static StandaloneModelLoader.BakedModels bakedModels;

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TekoraBlockRenderers.MODULAR_PART_LAYER, ModularPartModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        registerGeneralRotator(event, TekoraBlockEntities.HAND_CRANK.get());
        registerGeneralRotator(event, TekoraBlockEntities.SHAFT.get());

        registerModularRotating(event, TekoraBlockEntities.CRUSHER.get(), CRUSHING_WHEEL, CRUSHING_WHEEL_KEY);
        registerModularRotating(event, TekoraBlockEntities.MIXER.get(), MIXER, MIXER_KEY);
        registerModularUpDown(event, TekoraBlockEntities.CUTTER.get(), CUTTER, CUTTER_KEY);
        registerModularUpDown(event, TekoraBlockEntities.PRINTER.get(), INK_PRESS_SHAFT, INK_PRESS_SHAFT_KEY);
        registerModularUpDown(event, TekoraBlockEntities.PRESS.get(), PRESS_SHAFT, PRESS_SHAFT_KEY);

        event.registerBlockEntityRenderer(TekoraBlockEntities.DEPOT.get(), DepotRenderer::new);

        registerWithGearPart(event, TekoraBlockEntities.TOP_MECH.get());
    }

    private static void registerWithGearPart(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type) {
        event.registerBlockEntityRenderer(type, ModularGearRenderer::new);
    }

    private static void registerModularUpDown(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type, Identifier identifier, StandaloneModelKey<QuadCollection> key) {
        event.registerBlockEntityRenderer(type, c -> new ModularUpDownPartRenderer(c, identifier, key));
    }

    private static void registerModularRotating(EntityRenderersEvent.RegisterRenderers event, BlockEntityType type, Identifier identifier, StandaloneModelKey<QuadCollection> key) {
        event.registerBlockEntityRenderer(type, c -> new ModularRotatingRenderer(c, identifier, key));
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

    @SubscribeEvent
    public static void onModifyBakingResult(ModelEvent.ModifyBakingResult event) {
        ModelBakery.BakingResult result = event.getBakingResult();
        Set<BlockStateModel> refModels = new HashSet<>();

        addModel(result, refModels, TekoraBlocks.CRUSHER.get());
        addModel(result, refModels, TekoraBlocks.CUTTER.get());
        addModel(result, refModels, TekoraBlocks.MIXER.get());
        addModel(result, refModels, TekoraBlocks.PRESS.get());
        addModel(result, refModels, TekoraBlocks.PRINTER.get());
    }

    private static void addModel(ModelBakery.BakingResult result, Set<BlockStateModel> refModels, Block block) {
        for (BlockState state : block.getStateDefinition().getPossibleStates()) {
            BlockStateModel active = result.getBlockStateModel(state);
            refModels.add(active);
        }
    }

    @SubscribeEvent
    public static void onRegisterAdditional(ModelEvent.RegisterStandalone event) {
        event.register(CRUSHING_WHEEL_KEY, SimpleUnbakedStandaloneModel.quadCollection(CRUSHING_WHEEL));
        event.register(CUTTER_KEY, SimpleUnbakedStandaloneModel.quadCollection(CUTTER));
        event.register(MIXER_KEY, SimpleUnbakedStandaloneModel.quadCollection(MIXER));
        event.register(INK_PRESS_SHAFT_KEY, SimpleUnbakedStandaloneModel.quadCollection(INK_PRESS_SHAFT));
        event.register(PRESS_SHAFT_KEY, SimpleUnbakedStandaloneModel.quadCollection(PRESS_SHAFT));
    }

    @SubscribeEvent
    public static void onBakingCompleted(ModelEvent.BakingCompleted event) {
        bakedModels = event.getBakingResult().standaloneModels();
    }

    public static StandaloneModelLoader.BakedModels getBakedModels() {
        return bakedModels;
    }
}
