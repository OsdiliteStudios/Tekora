package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import org.jspecify.annotations.Nullable;

public class ModularUpDownPartRenderer implements BlockEntityRenderer<AbstractMechanicalEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;
    private final ModularRotatingModel model;
    public ModularUpDownPartRenderer(BlockEntityRendererProvider.Context pContext, Identifier texture) {
        this.renderer = pContext.blockEntityRenderDispatcher();
        this.model = new ModularRotatingModel(pContext.bakeLayer(new ModelLayerLocation(texture, "main")));
    }

    @Override
    public void extractRenderState(AbstractMechanicalEntity blockEntity, MechRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        if (state.blockState == null) {
            state.blockState = blockEntity.getBlockState();
        }

        state.crumbling = breakProgress;
    }

    @Override
    public MechRenderState createRenderState() {
        return new MechRenderState();
    }

    @Override
    public void submit(MechRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        if (state.parts != null && !state.parts.isEmpty()) {
            poseStack.pushPose();

            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.translate(0, -1d, 0); // todo make a math equation that connects to this
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            //collector.submitMultiLayerBlockModel(poseStack, state.parts, true, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, state.packedLight, OverlayTexture.NO_OVERLAY, 0);

            collector.submitModel(this.model, state, poseStack, RenderTypes.cutoutMovingBlock(), state.packedLight, OverlayTexture.NO_OVERLAY, state.lightCoords, state.crumbling);

            poseStack.popPose();
        }
    }
}
