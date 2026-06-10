package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;

public class RotationalEntityRenderer implements BlockEntityRenderer<RotationalAbstractEntity, BlockEntityRenderState> {
    private final BlockEntityRenderDispatcher blockRenderer;

    public RotationalEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.blockRenderer = pContext.blockEntityRenderDispatcher();
    }

    @Override
    public BlockEntityRenderState createRenderState() {
        return null;
    }

    @Override
    public void submit(BlockEntityRenderState blockEntityRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        Level level = null; // todo, set it to not null
        if (level != null) {
//            ModelBlockRenderer.enableCaching();
//            BlockState state = ;
//            if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
//                pPoseStack.pushPose();
//
//                Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
//                int ord = axis.ordinal();
//                Axis rotAxis = switch (ord) {
//                    case 0 -> Axis.XP;
//                    case 1 -> Axis.YP;
//                    default -> Axis.ZP;
//                };
//                float rendPos = pBlockEntity.getRenderingRotation();
//                pPoseStack.translate(0.5f, 0.5f, 0.5f);
//                pPoseStack.mulPose(rotAxis.rotation(rendPos));
//                pPoseStack.translate(-0.5f, -0.5f, -0.5f);
//                UtilFunctions.renderInvisibleModels(blockRenderer, state, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
//                pPoseStack.popPose();
//            }
        }
    }
}