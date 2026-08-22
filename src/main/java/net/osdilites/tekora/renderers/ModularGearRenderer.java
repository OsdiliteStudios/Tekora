package net.osdilites.tekora.renderers;

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
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;

public class ModularGearRenderer implements BlockEntityRenderer<AbstractMechanicalEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;

    public ModularGearRenderer(BlockEntityRendererProvider.Context pContext) {
        renderer = pContext.blockEntityRenderDispatcher();
    }

    @Override
    public void extractRenderState(AbstractMechanicalEntity blockEntity, MechRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        BlockState gearState = blockEntity.getBlockState();
        BlockState hypothetical = TekoraBlocks.STEEL_SHAFT.get().defaultBlockState()
                .setValue(BlockStateProperties.AXIS, Direction.Axis.Y)
                .setValue(TekoraBlockStates.GEAR_TYPE, gearState.getValue(TekoraBlockStates.GEAR_TYPE))
                .setValue(TekoraBlockStates.IS_LARGE, false);

        if (state.blockState == null) {
            state.blockState = hypothetical;
        }
        state.setAngle(Mth.lerp(partialTicks, blockEntity.getOldAngle(), blockEntity.getAngle()));
        BlockStateModel shaftModel = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(hypothetical);
        state.parts = new ArrayList<>();
        if (blockEntity.getLevel() instanceof BlockAndTintGetter getter) {
            shaftModel.collectParts(getter, blockEntity.getBlockPos(), hypothetical, RandomSource.create(42L), state.parts);
        }
    }

    @Override
    public MechRenderState createRenderState() {
        return new MechRenderState();
    }

    @Override
    public void submit(MechRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState renderState) {
        if (state.parts != null && !state.parts.isEmpty()) {
            poseStack.pushPose();

            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.mulPose(Axis.YP.rotationDegrees(state.getAngle()));
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            collector.submitMultiLayerBlockModel(poseStack, state.parts, true, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, state.packedLight, OverlayTexture.NO_OVERLAY, 0);

            poseStack.popPose();
        }
    }
}
