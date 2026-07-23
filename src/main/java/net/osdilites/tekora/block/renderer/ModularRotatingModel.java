package net.osdilites.tekora.block.renderer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class ModularRotatingModel extends Model<MechRenderState> {
    private final ModelPart body;
    public ModularRotatingModel(ModelPart root) {
        super(root, loc -> RenderTypes.cutoutMovingBlock()); // todo, define state
        this.body = root.getChild("body");
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
