package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.osdilites.tekora.util.UtilFunctions;
import org.joml.Matrix4fc;
import org.jspecify.annotations.Nullable;

public class RotationalEntityRenderer implements BlockEntityRenderer<RotationalAbstractEntity, BlockEntityRenderState> {
    private final BlockEntityRenderDispatcher blockRenderer;

    public RotationalEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.blockRenderer = pContext.blockEntityRenderDispatcher();
    }

    @Override
    public void extractRenderState(RotationalAbstractEntity blockEntity, BlockEntityRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        Level level = null; // todo, set it to not null
        if (level != null) {
            //ModelBlockRenderer.enableCaching();
            BlockState blockState = blockEntity.getBlockState();
            if (blockState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                PoseStack.Pose poseStack = breakProgress.cameraPose();

                Direction.Axis axis = blockState.getValue(AbstractTekoraAxialBlock.AXIS);
                int ord = axis.ordinal();
                Axis rotAxis = switch (ord) {
                    case 0 -> Axis.XP;
                    case 1 -> Axis.YP;
                    default -> Axis.ZP;
                };
                float rendPos = blockEntity.getRenderingRotation();
                poseStack.translate(0.5f, 0.5f, 0.5f);
                //poseStack.mulPose(rotAxis.rotation(rendPos).get(null));
                poseStack.translate(-0.5f, -0.5f, -0.5f);
                //UtilFunctions.renderInvisibleModels(blockRenderer, state, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
                //poseStack.popPose();
            }
        }
    }

    @Override
    public BlockEntityRenderState createRenderState() {
        return new BlockEntityRenderState();
    }

    @Override
    public void submit(BlockEntityRenderState blockEntityRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {

    }
}