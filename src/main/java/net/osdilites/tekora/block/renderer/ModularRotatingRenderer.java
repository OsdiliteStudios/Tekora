package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import org.jspecify.annotations.Nullable;

public class ModularRotatingRenderer implements BlockEntityRenderer<AbstractMechanicalEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;
    private final ModularRotatingModel model;
    public ModularRotatingRenderer(BlockEntityRendererProvider.Context pContext, Identifier texture) {
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
            poseStack.mulPose(getAxisFromState(state.blockState).rotationDegrees((float)(state.getAngle() * 180 / Math.PI)));
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            //collector.submitMultiLayerBlockModel(poseStack, state.parts, true, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, state.packedLight, OverlayTexture.NO_OVERLAY, 0);

            collector.submitModel(this.model, state, poseStack, RenderTypes.cutoutMovingBlock(), state.packedLight, OverlayTexture.NO_OVERLAY, state.lightCoords, state.crumbling);
            poseStack.popPose();
        }
    }

    private Axis getAxisFromState(BlockState state) {
        if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            return switch (state.getValue(BlockStateProperties.HORIZONTAL_AXIS)) {
                case X -> Axis.XP;
                case Z -> Axis.ZP;
                default -> Axis.YP;
            };
        }
        return Axis.YP;
    }
}
