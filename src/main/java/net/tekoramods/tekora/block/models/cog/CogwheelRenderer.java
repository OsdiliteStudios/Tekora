package net.tekoramods.tekora.block.models.cog;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.tekoramods.tekora.block.entities.transporter.rotational.CogwheelEntity;

public class CogwheelRenderer implements BlockEntityRenderer<CogwheelEntity> {
    private BlockRenderDispatcher blockRenderer;

    public CogwheelRenderer(BlockEntityRendererProvider.Context pContext) {
        this.blockRenderer = pContext.getBlockRenderDispatcher();
    }
    @Override
    public void render(CogwheelEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        Level level = pBlockEntity.getLevel();
        if (level != null) {
            ModelBlockRenderer.enableCaching();
            BlockState state = pBlockEntity.getBlockState();
            if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                BlockRenderDispatcher renderer = Minecraft.getInstance().getBlockRenderer();
                pPoseStack.pushPose();

                Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
                int ord = axis.ordinal();
                Axis rotAxis = switch (ord) {
                    case 0 -> Axis.XP;
                    case 1 -> Axis.YP;
                    default -> Axis.ZP;
                };
                pPoseStack.mulPose(rotAxis.rotationDegrees(pBlockEntity.getRenderingRotation()));
                renderer.renderSingleBlock(state, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, ModelData.builder().build(), RenderType.cutout());
                pPoseStack.popPose();
            }
        }
    }
}
