package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.block.entities.transporter.rotational.RotationalAbstractEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.util.UtilFunctions;

public abstract class AbstractMechMachineEntity extends AbstractMechanicalEntity {
    private float oldRot;
    private float curRot;
    private float velocity;

    public AbstractMechMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public float getOldRotation() {
        return oldRot;
    }

    public float getRenderingRotation() {
        return curRot;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // todo, make an implementation plan here
        if (pLevel != null) {
            double orgV = componentRadius() * velocity;
            double c = 512;
            double tot = 0;

            BlockPos above = pPos.above();

            BlockEntity north = pLevel.getBlockEntity(pPos.north());
            BlockEntity south = pLevel.getBlockEntity(pPos.south());
            BlockEntity east = pLevel.getBlockEntity(pPos.east());
            BlockEntity west = pLevel.getBlockEntity(pPos.west());

            if (pLevel.getBlockEntity(above) instanceof RotationalAbstractEntity) {}

            if (north instanceof ShaftEntity cog && cog.canBeCog())
                tot += contact(pLevel, pPos, pPos.above(), orgV, c, cog);

            if (south instanceof ShaftEntity cog && cog.canBeCog())
                tot += contact(pLevel, pPos, pPos.below(), orgV, c, cog);
            if (east instanceof ShaftEntity cog && cog.canBeCog())
                tot += contact(pLevel, pPos, pPos.north(), orgV, c, cog);
            if (west instanceof ShaftEntity cog && cog.canBeCog())
                tot += contact(pLevel, pPos, pPos.south(), orgV, c, cog);

            if (getMoment() != 0) {
                velocity += (float) (tot / getMoment());
            }
        }
        oldRot = curRot;
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, double c, AbstractMechanicalEntity ent) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;
        BlockState otherState = pLevel.getBlockState(otherPos);
        BlockState selfState = pLevel.getBlockState(curPos);
        if (ent instanceof ShaftEntity cog && otherState.hasProperty(BlockStateProperties.AXIS) && selfState.hasProperty(BlockStateProperties.AXIS)) {
            Direction.Axis otherVal = otherState.getValue(BlockStateProperties.AXIS);
            if (otherVal == Direction.Axis.Y) {
                double otherV = cog.componentRadius() * cog.getBody().getVelocity();
                double slipV = selfV + otherV;
                double contactForce = -c * slipV;
                cog.getBody().addForce(otherPos, contactForce);
                if (cog.getBody().getVelocity() == 0) cog.getBody().adjustAngle(curRot);
                return contactForce;
            }
        } else if (ent instanceof AbstractMechMachineEntity mech) {
            double otherV = mech.componentRadius() * mech.velocity;
            double slipV = selfV + otherV;
            double contactForce = -c * slipV;
            velocity += (float) (contactForce / getMoment());
            if (mech.velocity == 0) oldRot = curRot = UtilFunctions.fitAngleInRange(curRot) + (float)Math.PI / 6;
            return contactForce;
        }
        return 0;
    }
}
