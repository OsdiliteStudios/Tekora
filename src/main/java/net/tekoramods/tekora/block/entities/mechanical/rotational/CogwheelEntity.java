package net.tekoramods.tekora.block.entities.mechanical.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;

public class CogwheelEntity extends RotationalAbstractEntity {
    public static final double WOOD_MASS = 1653.7540078037523;
    // public static final double BRASS_MASS = ;
    // public static final double STAINLESS_MASS = ;

    public CogwheelEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide) {
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
                BlockEntity up = pLevel.getBlockEntity(pPos.above());
                BlockEntity down = pLevel.getBlockEntity(pPos.below());
                BlockEntity north = pLevel.getBlockEntity(pPos.north());
                BlockEntity south = pLevel.getBlockEntity(pPos.south());
                BlockEntity east = pLevel.getBlockEntity(pPos.east());
                BlockEntity west = pLevel.getBlockEntity(pPos.west());
                double forceSum = 0;
                if (axis == Direction.Axis.X) {
                    if (up instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (down instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (north instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (south instanceof CogwheelEntity cog) forceSum += cog.force;
                } else if (axis == Direction.Axis.Y) {
                    if (east instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (west instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (north instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (south instanceof CogwheelEntity cog) forceSum += cog.force;
                } else if (axis == Direction.Axis.Z) {
                    if (east instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (west instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (up instanceof CogwheelEntity cog) forceSum += cog.force;
                    if (down instanceof CogwheelEntity cog) forceSum += cog.force;
                }
                force = forceSum / componentRadius();
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }

    public static class Wood extends CogwheelEntity {
        public Wood(BlockPos pPos, BlockState pBlockState) {
            super(TekoraBlockEntities.WOODEN_COGWHEEL.get(), pPos, pBlockState, WOOD_MASS);
        }
    }
}
