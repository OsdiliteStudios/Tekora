package net.osdilites.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

//    // renders block models of RenderType.INVISIBLE, essentially overriding a method
//    public static void renderInvisibleModels(BlockEntityRenderDispatcher pRenderer, BlockState pState, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
//        BlockColors colors = Minecraft.getInstance().getBlockColors();
//        BakedMo bakedmodel = pRenderer.getBlockModel(pState);
//        int i = colors.getColor(pState, null, null, 0);
//        float f = (float)(i >> 16 & 0xFF) / 255.0F;
//        float f1 = (float)(i >> 8 & 0xFF) / 255.0F;
//        float f2 = (float)(i & 0xFF) / 255.0F;
//        for (var rt : bakedmodel.getRenderTypes(pState, RandomSource.create(42), ModelData.EMPTY))
//            pRenderer.getModelRenderer().renderModel(
//                    pPoseStack.last(), pBufferSource.getBuffer(RenderType.solid()), pState, bakedmodel,
//                    f, f1, f2, pPackedLight, pPackedOverlay, ModelData.EMPTY, rt);
//
//    }

    public static VoxelShape[] generateShapeForAllRotations(double pX1, double pY1, double pZ1, double pX2, double pY2, double pZ2) {
        VoxelShape[] shapes = new VoxelShape[3];
        shapes[0] = Shapes.box(pX1, pY1, pZ1, pX2, pY2, pZ2);
        shapes[1] = Shapes.box(pZ1, pX1, pY1, pZ2, pX2, pY2);
        shapes[2] = Shapes.box(pY1, pZ1, pX1, pY2, pZ2, pX2);
        return shapes;
    }

    public static double distance(BlockPos a, BlockPos b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
