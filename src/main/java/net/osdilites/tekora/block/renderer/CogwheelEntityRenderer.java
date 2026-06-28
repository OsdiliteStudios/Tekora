package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.transporter.rotational.CogwheelEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import org.jspecify.annotations.Nullable;

public class CogwheelEntityRenderer extends RotationalEntityRenderer {
    public CogwheelEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void extractRenderState(RotationalAbstractEntity blockEntity, TekoraRotatingRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        if (blockEntity instanceof CogwheelEntity cog && state instanceof CogwheelRenderState cogState) {
            cogState.attachedParts = cog.getAttachedPartners();
        }
        super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
    }

    @Override
    public TekoraRotatingRenderState createRenderState() {
        return new CogwheelRenderState();
    }

    @Override
    public void submit(TekoraRotatingRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState renderState) {
        if (state instanceof CogwheelRenderState cogState) {}
        super.submit(state, poseStack, collector, renderState);
    }
}
