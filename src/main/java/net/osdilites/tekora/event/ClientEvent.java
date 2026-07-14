package net.osdilites.tekora.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.renderer.RotationalEntityRenderer;

@EventBusSubscriber(modid = Tekora.MODID)
public class ClientEvent {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(
//                TekoraBlockEntities.COGWHEEL.get(),
//                RotationalEntityRenderer::new
//        );

        event.registerBlockEntityRenderer(
                TekoraBlockEntities.HAND_CRANK.get(),
                RotationalEntityRenderer::new
        );

        event.registerBlockEntityRenderer(
                TekoraBlockEntities.SHAFT.get(),
                RotationalEntityRenderer::new
        );
    }
}
