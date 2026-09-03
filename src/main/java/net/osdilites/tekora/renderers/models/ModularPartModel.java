package net.osdilites.tekora.renderers.models;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.osdilites.tekora.renderers.states.MechRenderState;

public class ModularPartModel extends Model<MechRenderState> {
    public ModularPartModel(ModelPart root) {
        super(root, RenderTypes::entityCutoutCull);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();

        part.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0).addBox(-5f, 0, -5f, 10f, 10f, 10f),
                PartPose.offset(0f, 0f, 0f));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
