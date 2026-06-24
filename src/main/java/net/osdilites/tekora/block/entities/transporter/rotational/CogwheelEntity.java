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
        if (body != null && pLevel.getBlockEntity(pPos) instanceof RotationalAbstractEntity ent && pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
            BlockEntity up = pLevel.getBlockEntity(pPos.above());
            BlockEntity down = pLevel.getBlockEntity(pPos.below());
            BlockEntity north = pLevel.getBlockEntity(pPos.north());
            BlockEntity south = pLevel.getBlockEntity(pPos.south());
            BlockEntity east = pLevel.getBlockEntity(pPos.east());
            BlockEntity west = pLevel.getBlockEntity(pPos.west());
            double orgV = ent.componentRadius() * ent.getBody().getVelocity();
            double c = 512;
            double tot = 0;
            if (axis == Direction.Axis.X) {
                if (up instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);
                if (down instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.below(), orgV, c, cog);
                if (north instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.north(), orgV, c, cog);
                if (south instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.south(), orgV, c, cog);
            } else if (axis == Direction.Axis.Y) {
                if (east instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.east(), orgV, c, cog);
                if (west instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.west(), orgV, c, cog);
                if (north instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.north(), orgV, c, cog);
                if (south instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.south(), orgV, c, cog);
            } else if (axis == Direction.Axis.Z) {
                if (east instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.east(), orgV, c, cog);
                if (west instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.west(), orgV, c, cog);
                if (up instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);
                if (down instanceof CogwheelEntity cog) tot += contact(pLevel, pPos, pPos.below(), orgV, c, cog);
            }
            body.addForce(pPos, tot);
        }
        super.tick(pLevel, pPos, pState);
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, double c, CogwheelEntity cog) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;
        BlockState otherState = pLevel.getBlockState(otherPos);
        BlockState selfState = pLevel.getBlockState(curPos);
        if (otherState.hasProperty(AbstractTekoraAxialBlock.AXIS) && selfState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis otherVal = otherState.getValue(AbstractTekoraAxialBlock.AXIS);
            Direction.Axis selfVal = selfState.getValue(AbstractTekoraAxialBlock.AXIS);
            if (otherVal == selfVal) {
                double otherV = cog.componentRadius() * cog.body.getVelocity();
                double slipV = selfV + otherV;
                double contactForce = -c * slipV;
                cog.body.addForce(otherPos, contactForce);
                return contactForce;
            }

        }
        return 0;
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
