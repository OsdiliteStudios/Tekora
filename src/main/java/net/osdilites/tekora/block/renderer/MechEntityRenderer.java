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
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;

public class MechEntityRenderer implements BlockEntityRenderer<AbstractMechanicalEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;

    private static final Identifier ALUMINUM_GEAR = getGearIdentifier("aluminum");
    private static final Identifier BRASS_GEAR = getGearIdentifier("brass");
    private static final Identifier BRONZE_GEAR = getGearIdentifier("bronze");
    private static final Identifier STEEL_GEAR = getGearIdentifier("steel");
    private static final Identifier PLASTIC_GEAR = getGearIdentifier("plastic");
    private static final Identifier WOOD_GEAR = getGearIdentifier("wood");

    private static final Identifier SHAFT = Identifier.fromNamespaceAndPath(Tekora.MODID, "shafts/steel");

    private static Identifier getGearIdentifier(String name) {
        return Identifier.fromNamespaceAndPath(Tekora.MODID, "gears/" + name);
    }

    public MechEntityRenderer(BlockEntityRendererProvider.Context pContext) {
        renderer = pContext.blockEntityRenderDispatcher();
    }

    @Override
    public void extractRenderState(AbstractMechanicalEntity blockEntity, MechRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        if (state.blockState == null) {
            state.blockState = blockEntity.getBlockState();
        }
        state.setAngle(Mth.lerp(partialTicks, blockEntity.getOldRotation(), blockEntity.getRenderingRotation()));
        BlockStateModel model = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(blockEntity.getBlockState());
        state.parts = new ArrayList<>();
        if (blockEntity.getLevel() instanceof BlockAndTintGetter getter) {
            model.collectParts(getter, blockEntity.getBlockPos(), blockEntity.getBlockState(), RandomSource.create(42L), state.parts);
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
            poseStack.mulPose(Axis.YP.rotationDegrees((float)(state.getAngle() * 180 / Math.PI)));
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            collector.submitMultiLayerBlockModel(poseStack, state.parts, true, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF}, state.packedLight, OverlayTexture.NO_OVERLAY, 0);

            poseStack.popPose();
        }
    }
}
