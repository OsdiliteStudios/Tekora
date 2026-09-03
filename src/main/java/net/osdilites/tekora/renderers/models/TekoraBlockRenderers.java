package net.osdilites.tekora.renderers.models;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import net.osdilites.tekora.Tekora;

public class TekoraBlockRenderers {
    public static final ModelLayerLocation MODULAR_PART_LAYER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(Tekora.MODID, "modular_part"),
            "main"
    );
}
