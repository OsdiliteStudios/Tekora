package net.osdilites.tekora.client;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.renderer.RotationalEntityRenderer;

public class ClientEvent {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // todo, fix the event method
        event.registerBlockEntityRenderer(
                TekoraBlockEntities.COGWHEEL.get(),
                RotationalEntityRenderer::new
        );
    }
}
