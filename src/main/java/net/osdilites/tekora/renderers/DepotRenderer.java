package net.osdilites.tekora.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.block.entities.DepotEntity;
import net.osdilites.tekora.renderers.states.DepotRenderState;
import org.jspecify.annotations.Nullable;

public class DepotRenderer implements BlockEntityRenderer<DepotEntity, DepotRenderState> {
    private final ItemModelResolver resolver;

    public DepotRenderer(BlockEntityRendererProvider.Context context) {
        resolver = context.itemModelResolver();
    }

    @Override
    public DepotRenderState createRenderState() {
        return new DepotRenderState();
    }

    @Override
    public void extractRenderState(DepotEntity blockEntity, DepotRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        state.level = blockEntity.getLevel();
        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValueOrElse(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
        switch (direction) {
            case NORTH: state.x = 0.5d; state.z = 0.1d; break;
            case SOUTH: state.x = 0.5d; state.z = 0.9d; break;
            case EAST: state.x = 0.9d; state.z = 0.5d; break;
            case WEST: state.x = 0.1d; state.z = 0.5d; break;
        }

        resolver.updateForTopItem(state.input, blockEntity.inventory.getResource(0).toStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);
        resolver.updateForTopItem(state.output, blockEntity.inventory.getResource(1).toStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);
    }

    @Override
    public void submit(DepotRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();

        poseStack.translate(0.5d, 0.5d, 0.5d);
        poseStack.scale(0.4f, 0.4f, 0.4f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        state.input.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        poseStack.popPose();
        // between item input and output
        poseStack.pushPose();

        poseStack.translate(state.x, 0.5d, state.z);
        poseStack.scale(0.4f, 0.4f, 0.4f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        state.output.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        poseStack.popPose();
    }
}
