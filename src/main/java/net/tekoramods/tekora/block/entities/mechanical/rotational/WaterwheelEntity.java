package net.tekoramods.tekora.block.entities.mechanical.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class WaterwheelEntity extends RotationalAbstractEntity {
    public static final double WOOD_MASS = 10543.30739107599;
    // public static final double STEEL_MASS = ;

    protected WaterwheelEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide) {
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
                boolean isVert = axis.isVertical();
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    @Override
    public double componentRadius() {
        return 1.5;
    }

    public static class Wood extends WaterwheelEntity {
        protected Wood(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
            super(pType, pPos, pBlockState, pComponentMass);
        }
    }
}
