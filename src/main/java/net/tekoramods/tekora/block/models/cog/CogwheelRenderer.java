package net.tekoramods.tekora.block.models.cog;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.tekoramods.tekora.block.entities.transporter.rotational.AbstractTekoraAxialBlock;
import net.tekoramods.tekora.block.entities.transporter.rotational.CogwheelEntity;
import org.joml.Quaternionf;

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
            BlockState state = level.getBlockState(pBlockEntity.getBlockPos());
            if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
                BlockPos pos = pBlockEntity.getBlockPos();
                int ord = axis.ordinal();
                // todo fix the code below if things are not working
                Quaternionf q = new Quaternionf(ord == 0 ? 1 : 0, ord == 1 ? 1 : 0, ord == 2 ? 1 : 0, 1); // there is an axis angle, use a value from the block entity for that perhaps
                pPoseStack.rotateAround(q, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f); // remove the addition if it rotates weird


                BakedModel model = blockRenderer.getBlockModel(state);
                ModelData data = net.minecraftforge.client.model.data.ModelData.EMPTY;
                for (var rendertype : model.getRenderTypes(state, RandomSource.create(state.getSeed(pos)), data)) {
                    VertexConsumer vertexconsumer = pBufferSource.getBuffer(net.minecraftforge.client.RenderTypeHelper.getMovingBlockRenderType(rendertype));
                    this.blockRenderer.getModelRenderer(); // TODO, add an ending here
                }
            }
        }
    }
}
