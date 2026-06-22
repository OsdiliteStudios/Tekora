package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CogwheelEntity extends RotationalAbstractEntity {
    public static final double I_WOOD = 1653.7540078037523;
    // public static final double I_BRASS = ;
    // public static final double I_STAINLESS = ;

    public CogwheelEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.COGWHEEL.get(), pPos, pBlockState); // basically component entity varies for different block
        // todo make the super class use a non final variable for mass.
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (body != null && pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
            BlockEntity up = pLevel.getBlockEntity(pPos.above());
            BlockEntity down = pLevel.getBlockEntity(pPos.below());
            BlockEntity north = pLevel.getBlockEntity(pPos.north());
            BlockEntity south = pLevel.getBlockEntity(pPos.south());
            BlockEntity east = pLevel.getBlockEntity(pPos.east());
            BlockEntity west = pLevel.getBlockEntity(pPos.west());
            double forceSum = 0;
            double c = 1;
            if (axis == Direction.Axis.X) {
                if (up instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (down instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (north instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (south instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
            } else if (axis == Direction.Axis.Y) {
                if (east instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (west instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (north instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (south instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
            } else if (axis == Direction.Axis.Z) {
                if (east instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (west instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (up instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
                if (down instanceof CogwheelEntity cog) forceSum -= c * cog.componentRadius() * cog.body.getVelocity();
            }
            body.addForce(pPos, forceSum);
        }
        super.tick(pLevel, pPos, pState);
    }

    @Override
    public double getMoment() {
        return I_WOOD;
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }
}
