package net.osdilites.tekora.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.QuadInstance;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.geometry.QuadCollection;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelKey;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.event.ClientEvent;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModularUpDownPartRenderer implements BlockEntityRenderer<AbstractModularMachineEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;
    private final Identifier texture;
    private final StandaloneModelKey<QuadCollection> key;
    public ModularUpDownPartRenderer(BlockEntityRendererProvider.Context pContext, Identifier texture, StandaloneModelKey<QuadCollection> key) {
        this.renderer = pContext.blockEntityRenderDispatcher();
        this.texture = texture;
        this.key = key;
    }

    @Override
    public void extractRenderState(AbstractModularMachineEntity blockEntity, MechRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        BlockState gearState = blockEntity.getBlockState();
        BlockState hypothetical = TekoraBlocks.STEEL_SHAFT.get().defaultBlockState()
                .setValue(BlockStateProperties.AXIS, Direction.Axis.Y)
                .setValue(TekoraBlockStates.GEAR_TYPE, gearState.getValue(TekoraBlockStates.GEAR_TYPE))
                .setValue(TekoraBlockStates.IS_LARGE, false);

        if (state.blockState == null) {
            state.blockState = hypothetical;
        }

        state.crumbling = breakProgress;
        state.texture = this.texture;
        state.progress = blockEntity.getProgress();
        state.setAngle(Mth.lerp(partialTicks, blockEntity.getOldAngle(), blockEntity.getAngle()));
        BlockStateModel shaftModel = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(hypothetical);
        state.parts = new ArrayList<>();
        if (blockEntity.getLevel() instanceof BlockAndTintGetter getter) {
            shaftModel.collectParts(getter, blockEntity.getBlockPos(), hypothetical, RandomSource.create(42L), state.parts);
        }
        StandaloneModelLoader.BakedModels bakedModels = ClientEvent.getBakedModels();

        if (bakedModels == null) {
            state.quads = null;
            return;
        }

        state.bakedModels = bakedModels;
        state.quads = bakedModels.get(key);
    }

    @Override
    public MechRenderState createRenderState() {
        return new MechRenderState();
    }

    @Override
    public void submit(MechRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        if (state.quads == null) {
            return;
        }

        // renders the model part
        QuadInstance instance = new QuadInstance();
        instance.setColor(0xFFFFFFFF);
        instance.setLightCoords(state.packedLight);
        instance.setOverlayCoords(OverlayTexture.NO_OVERLAY);
        Map<RenderType, List<BakedQuad>> quadsByRenderType = new HashMap<>();

        for (BakedQuad quad : state.quads.getAll()) {
            RenderType renderType = quad.materialInfo().itemRenderType();

            quadsByRenderType
                    .computeIfAbsent(renderType, ignored -> new ArrayList<>())
                    .add(quad);
        }

        poseStack.pushPose();

        poseStack.translate(0.5D, 0.5D, 0.5D);
        poseStack.translate(0.0D, -(1 - Math.cos(Math.PI * state.progress / 160)) / 2.0d, 0.0D);
        poseStack.translate(-0.5D, -0.5D, -0.5D);

        for (Map.Entry<RenderType, List<BakedQuad>> entry : quadsByRenderType.entrySet()) {
            RenderType renderType = entry.getKey();
            List<BakedQuad> quads = entry.getValue();

            collector.submitCustomGeometry(poseStack, renderType, (pose, vertexConsumer) -> {
                        for (BakedQuad quad : quads) {
                            vertexConsumer.putBakedQuad(pose, quad, instance);
                        }
            });
        }
        poseStack.popPose();

        // render shaft & gear component
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
