package net.tekoramods.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

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
}
