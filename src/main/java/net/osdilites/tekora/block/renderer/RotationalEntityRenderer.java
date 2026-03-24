package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.osdilites.tekora.util.UtilFunctions;

public class RotationalEntityRenderer implements BlockEntityRenderer<RotationalAbstractEntity> {
    private final BlockRenderDispatcher blockRenderer;

    public RotationalEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        this.blockRenderer = pContext.getBlockRenderDispatcher();
    }
    @Override
    public void render(RotationalAbstractEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        Level level = pBlockEntity.getLevel();
        if (level != null) {
            ModelBlockRenderer.enableCaching();
            BlockState state = pBlockEntity.getBlockState();
            if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                pPoseStack.pushPose();

                Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
                int ord = axis.ordinal();
                Axis rotAxis = switch (ord) {
                    case 0 -> Axis.XP;
                    case 1 -> Axis.YP;
                    default -> Axis.ZP;
                };
                float rendPos = pBlockEntity.getRenderingRotation();
                pPoseStack.translate(0.5f, 0.5f, 0.5f);
                pPoseStack.mulPose(rotAxis.rotation(rendPos));
                pPoseStack.translate(-0.5f, -0.5f, -0.5f);
                UtilFunctions.renderInvisibleModels(blockRenderer, state, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
                pPoseStack.popPose();
            }
        }
    }
}
