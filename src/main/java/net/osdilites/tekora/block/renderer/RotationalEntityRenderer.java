package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;

public class RotationalEntityRenderer implements BlockEntityRenderer<RotationalAbstractEntity, TekoraRotatingRenderState> {
    protected final BlockEntityRenderDispatcher renderer;

    public RotationalEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        renderer = pContext.blockEntityRenderDispatcher();
    }

    @Override
    public void extractRenderState(RotationalAbstractEntity blockEntity, TekoraRotatingRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        if (state.blockState == null) {
            state.blockState = blockEntity.getBlockState();
        }
        state.setAngle(Mth.lerp(partialTicks, blockEntity.getOldAngle(), blockEntity.getAngle()));
        BlockStateModel model = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(blockEntity.getBlockState());
        state.parts = new ArrayList<>();
        if (blockEntity.getLevel() instanceof BlockAndTintGetter getter) {
            model.collectParts(getter, blockEntity.getBlockPos(), blockEntity.getBlockState(), RandomSource.create(42L), state.parts);
        }
    }

    @Override
    public TekoraRotatingRenderState createRenderState() {
        return new TekoraRotatingRenderState();
    }

    @Override
    public void submit(TekoraRotatingRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState renderState) {
        if (state.parts != null && !state.parts.isEmpty()) {
            poseStack.pushPose();

            Axis axis = switch (state.getAxis()) {
                case X -> Axis.XP;
                case Z -> Axis.ZP;
                default -> Axis.YP;
            };

            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.mulPose(axis.rotationDegrees(state.getAngle()));
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            collector.submitMultiLayerBlockModel(poseStack, state.parts, true, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, state.packedLight, OverlayTexture.NO_OVERLAY, 0);

            poseStack.popPose();
        }
    }
}