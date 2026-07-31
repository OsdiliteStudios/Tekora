package net.osdilites.tekora.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.osdilites.tekora.event.ClientEvent;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ModularUpDownPartRenderer implements BlockEntityRenderer<AbstractMechanicalEntity, MechRenderState> {
    protected final BlockEntityRenderDispatcher renderer;
    private final ModularRotatingModel model;
    private final Identifier texture;
    public ModularUpDownPartRenderer(BlockEntityRendererProvider.Context pContext, Identifier texture) {
        this.renderer = pContext.blockEntityRenderDispatcher();
        this.model = new ModularRotatingModel(pContext.bakeLayer(new ModelLayerLocation(texture, "main")));
        this.texture = texture;
    }

    @Override
    public void extractRenderState(AbstractMechanicalEntity blockEntity, MechRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        if (state.blockState == null) {
            state.blockState = blockEntity.getBlockState();
        }

        state.texture = this.texture;
        state.crumbling = breakProgress;
        state.parts = new ArrayList<>();
        StandaloneModelLoader.BakedModels bakedModels = ClientEvent.getBakedModels();
        if (bakedModels == null) return;
        state.bakedModels = bakedModels;
    }

    @Override
    public MechRenderState createRenderState() {
        return new MechRenderState();
    }

    @Override
    public void submit(MechRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        if (state.parts != null && !state.parts.isEmpty() && state.texture != null) {
            poseStack.pushPose();
            RenderType layer = Sheets.cutoutBlockSheet();

            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.translate(0, Math.sin(state.getAngle()), 0);
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            if (model != null) {
                List<BlockStateModelPart> parts = state.parts;
                collector.submitBlockModel(poseStack, layer, parts, new int[]{0xFFFFFFFF}, 0, state.packedLight, OverlayTexture.NO_OVERLAY);
            }
            poseStack.popPose();
        }
    }
}
