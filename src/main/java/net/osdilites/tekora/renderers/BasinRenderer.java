package net.osdilites.tekora.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.SubmitNodeCollector.CustomGeometryRenderer;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.fluid.FluidTintSource;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.osdilites.tekora.block.entities.BasinEntity;
import net.osdilites.tekora.renderers.states.BasinRenderState;
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

    // where the basin's chemical input/output inventory starts
    private static final int OFFSET = 2;

    @Override
    public void extractRenderState(BasinEntity blockEntity, BasinRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        state.level = blockEntity.getLevel();
        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValueOrElse(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
        
        final int BUCKET_IN = blockEntity.FLUID_INPUT_SLOT;
        final int BUCKET_OUT = blockEntity.FLUID_OUTPUT_SLOT;
        
        resolver.updateForTopItem(state.bucketIn, blockEntity.inventory.getResource(BUCKET_IN).toStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);
        resolver.updateForTopItem(state.bucketOut, blockEntity.inventory.getResource(BUCKET_OUT).toStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);

        for (int slot = OFFSET; slot < blockEntity.inventory.size(); ++slot) {
            ItemResource item = blockEntity.inventory.getResource(slot);
            resolver.updateForTopItem(state.items.get(slot - OFFSET), item.toStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);
        }

        FluidStacksResourceHandler tank = blockEntity.getFluidTank(direction);
        FluidStack fluid = blockEntity.getFluid();
        float fillRatio = (float)tank.getAmountAsInt(0) / (float)blockEntity.getTankCapacity();
        if (fluid.isEmpty()) {
            state.filled = 0.f;
        } else {
            FluidState fluidState = fluid.getFluid().defaultFluidState();
            FluidModel fluidModel = Minecraft.getInstance().getModelManager().getFluidStateModelSet().get(fluidState);
            state.fluidTexture = fluidModel.stillMaterial().sprite();
            FluidTintSource source = fluidModel.fluidTintSource();
            state.fluidClr = source != null ? source.colorAsStack(fluid) : 0xFF_FFFFFF;
            state.filled = fillRatio;
        }
    }

    @Override
    public void submit(BasinRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        
        // the size of 1 voxel, 1/16
        float pmin = 0.0625f;
        float pmax = 1.f - pmin;

        // top-down, transform the coordinate system
        poseStack.translate(4.f*pmin, 3.f*pmin, 4.f*pmin);
        float gridScale = .5f;
        poseStack.scale(gridScale, gridScale, gridScale);

        // TODO, it would be cool to visually show the count of each item stack
        // note, requires modifying renderstate class with a parallel array,
        // and entire pose stack chain in the loop may be in another loop
        float scl = .5f;
        for (int i = 0; i < state.items.size(); ++i) {
            int x = i / 3;
            int z = i % 3;
            poseStack.pushPose();
            poseStack.translate(1.f - x*scl, 0, 1.f - z*scl);
            poseStack.scale(.5f, .5f, .5f);
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
            state.items.get(i).submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }
        poseStack.popPose();

        if (state.fluidTexture == null || state.filled <= 0.f) {
            return;
        }

        final float HEIGHT = 0.5f;
        CustomGeometryRenderer fluidRenderer = (pose, consumer) -> {
            var t = state.fluidTexture;
            float y = state.filled * HEIGHT + pmin;
            int clr = state.fluidClr;
            int light = state.lightCoords;
            
            // vertex setup just to draw a single quad. wrap around order
            // every single parameter is required due to the RenderType.
            consumer.addVertex(pose, pmin, y, pmin).setUv(t.getU0(), t.getV0()).setNormal(pose, 0, 1, 0).setColor(clr).setLight(light).setOverlay(OverlayTexture.NO_OVERLAY);
            consumer.addVertex(pose, pmin, y, pmax).setUv(t.getU0(), t.getV1()).setNormal(pose, 0, 1, 0).setColor(clr).setLight(light).setOverlay(OverlayTexture.NO_OVERLAY);
            consumer.addVertex(pose, pmax, y, pmax).setUv(t.getU1(), t.getV1()).setNormal(pose, 0, 1, 0).setColor(clr).setLight(light).setOverlay(OverlayTexture.NO_OVERLAY);
            consumer.addVertex(pose, pmax, y, pmin).setUv(t.getU1(), t.getV0()).setNormal(pose, 0, 1, 0).setColor(clr).setLight(light).setOverlay(OverlayTexture.NO_OVERLAY);
        };
        RenderType fluidRenderType = RenderTypes.entityTranslucent(state.fluidTexture.atlasLocation());
        submitNodeCollector.submitCustomGeometry(poseStack, fluidRenderType, fluidRenderer);
    }
}
