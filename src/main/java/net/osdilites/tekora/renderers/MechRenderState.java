package net.osdilites.tekora.renderers;

import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.resources.model.geometry.QuadCollection;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;

public class MechRenderState extends TekoraRotatingRenderState {
    public ModelFeatureRenderer.CrumblingOverlay crumbling;
    public StandaloneModelLoader.BakedModels bakedModels;
    public Identifier texture;
    public QuadCollection quads;
    public float progress;
}
