package net.osdilites.tekora.util;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelLoader;
import net.neoforged.neoforge.model.data.ModelData;

public class UtilFunctions {
    public static BlockPos posFromDir(BlockPos pPos, Direction pDir) {
        return switch (pDir) {
            case UP -> pPos.above();
            case DOWN -> pPos.below();
            case NORTH -> pPos.north();
            case SOUTH -> pPos.south();
            case EAST -> pPos.east();
            case WEST -> pPos.west();
        };
    }

    public static Direction dirFromAxis(Direction.Axis pAxis, boolean pNeg) {
        return switch (pAxis) {
            case X -> pNeg ? Direction.WEST : Direction.EAST;
            case Y -> pNeg ? Direction.DOWN : Direction.UP;
            case Z -> pNeg ? Direction.NORTH : Direction.SOUTH;
        };
    }

    // renders block models of RenderType.INVISIBLE, essentially overriding a method
    public static void renderInvisibleModels(BlockEntityRenderDispatcher pRenderer, BlockState pState, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        BlockColors colors = Minecraft.getInstance().getBlockColors();
//        StandaloneModelLoader.BakedModels bakedmodel = pRenderer.getRenderer(pState);
//        int i = colors.color(pState, null, null, 0);
//        float f = (float)(i >> 16 & 0xFF) / 255.0F;
//        float f1 = (float)(i >> 8 & 0xFF) / 255.0F;
//        float f2 = (float)(i & 0xFF) / 255.0F;
//        for (var rt : bakedmodel.getRenderTypes(pState, RandomSource.create(42), ModelData.EMPTY))
//            pRenderer.getModelRenderer().renderModel(
//                    // make sure the code works here
//                    pPoseStack.last(), pBufferSource.getBuffer(RenderTypes.solidMovingBlock()), pState, bakedmodel,
//                    f, f1, f2, pPackedLight, pPackedOverlay, ModelData.EMPTY, rt);

    }

    // The values below assume that the block has a blockstate of Direction.UP (or Direction.Axis.Y)
    public static VoxelShape[] generateShapeForAllRotations(double pX1, double pY1, double pZ1, double pX2, double pY2, double pZ2) {
        VoxelShape[] shapes = new VoxelShape[6];
        shapes[0] = Block.box(pY1, pX1, pZ1, pY2, pX2, pZ2);
        shapes[1] = Block.box(pX1, pY1, pZ1, pX2, pY2, pZ2);
        shapes[2] = Block.box(pX1, pZ1, pY1, pX2, pZ2, pY2);
        shapes[3] = Block.box(16 - pY2, 16 - pX2, 16 - pZ2, 16 - pY1, 16 - pX1, 16 - pZ1);
        shapes[4] = Block.box(16 - pX2, 16 - pY2, 16 - pZ2, 16 - pX1, 16 - pY1, 16 - pZ1);
        shapes[5] = Block.box(16 - pX2, 16 - pZ2, 16 - pY2, 16 - pX1, 16 - pZ1, 16 - pY1);
        return shapes;
        // the array is outputted in the order [east, up, south, west, down, north]
    }

    public static double distance(BlockPos a, BlockPos b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
