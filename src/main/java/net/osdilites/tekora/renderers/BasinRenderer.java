package net.osdilites.tekora.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
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
import net.osdilites.tekora.block.entities.BasinEntity;
import net.osdilites.tekora.renderers.states.BasinRenderState;
import net.osdilites.tekora.renderers.states.DepotRenderState;
import org.jspecify.annotations.Nullable;

public class BasinRenderer implements BlockEntityRenderer<BasinEntity, BasinRenderState> {
    private final ItemModelResolver resolver;

    public BasinRenderer(BlockEntityRendererProvider.Context context) {
        resolver = context.itemModelResolver();
    }

    @Override
    public BasinRenderState createRenderState() {
        return new BasinRenderState();
    }

    @Override
    public void extractRenderState(BasinEntity blockEntity, BasinRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        state.level = blockEntity.getLevel();
        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValueOrElse(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
        // todo, place things in the item
    }

    @Override
    public void submit(BasinRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        // todo, render items
        poseStack.popPose();
    }
}
