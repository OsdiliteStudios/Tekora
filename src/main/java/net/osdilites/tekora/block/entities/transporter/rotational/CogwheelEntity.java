package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CogwheelEntity extends RotationalAbstractEntity {
    public static final double WOOD_MASS = 1653.7540078037523;
    // public static final double BRASS_MASS = ;
    // public static final double STAINLESS_MASS = ;

    public CogwheelEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.COGWHEEL.get(), pPos, pBlockState, WOOD_MASS); // basically component entity varies for different block
        // todo make the super class use a non final variable for mass.
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide()) {
            if (body != null && pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
                BlockEntity up = pLevel.getBlockEntity(pPos.above());
                BlockEntity down = pLevel.getBlockEntity(pPos.below());
                BlockEntity north = pLevel.getBlockEntity(pPos.north());
                BlockEntity south = pLevel.getBlockEntity(pPos.south());
                BlockEntity east = pLevel.getBlockEntity(pPos.east());
                BlockEntity west = pLevel.getBlockEntity(pPos.west());
                double torqueSum = 0;
                if (axis == Direction.Axis.X) {
                    if (up instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (down instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (north instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (south instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                } else if (axis == Direction.Axis.Y) {
                    if (east instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (west instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (north instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (south instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                } else if (axis == Direction.Axis.Z) {
                    if (east instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (west instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (up instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                    if (down instanceof CogwheelEntity cog) torqueSum += cog.body.torque;
                }
                body.torque += torqueSum;
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    @Override
    public double componentResistance() {
        return 0;
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }
}
