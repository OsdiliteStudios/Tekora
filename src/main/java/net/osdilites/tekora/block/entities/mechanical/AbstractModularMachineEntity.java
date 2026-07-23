package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;

public abstract class AbstractModularMachineEntity extends AbstractMechanicalEntity {
    private float oldRot;
    private float curRot;
    private float oldVelocity;
    private float velocity; // note as with all Tekora object classes, velocity here describes angular velocity (omega)

    public AbstractModularMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
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
            oldVelocity = velocity;
            double orgV = componentRadius() * velocity;
            double tot = 0;

            BlockEntity north = pLevel.getBlockEntity(pPos.north());
            BlockEntity south = pLevel.getBlockEntity(pPos.south());
            BlockEntity east = pLevel.getBlockEntity(pPos.east());
            BlockEntity west = pLevel.getBlockEntity(pPos.west());

            tot += contact(pLevel, pPos, pPos.above(), orgV, north);
            tot += contact(pLevel, pPos, pPos.below(), orgV, south);
            tot += contact(pLevel, pPos, pPos.north(), orgV, east);
            tot += contact(pLevel, pPos, pPos.south(), orgV, west);

            if (getMoment() != 0) {
                velocity += (float) (tot / getMoment());
            }
        }
        oldRot = curRot;
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, BlockEntity ent) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;
        BlockState otherState = pLevel.getBlockState(otherPos);
        BlockState selfState = pLevel.getBlockState(curPos);
        oldVelocity = velocity;
        if (canBeCog()) {
            if (ent instanceof ShaftEntity cog && cog.canBeCog()
                    && otherState.hasProperty(BlockStateProperties.AXIS) && selfState.hasProperty(BlockStateProperties.AXIS)) {
                Direction.Axis otherVal = otherState.getValue(BlockStateProperties.AXIS);
                if (otherVal == Direction.Axis.Y) {
                    double r1 = componentRadius();
                    double r2 = cog.componentRadius();

                    double otherV = r2 * cog.getBody().getVelocity();
                    double slipV = selfV + otherV;
                    double j = slipV / (Math.pow(r1, 2) / getMoment() + Math.pow(r2, 2) / cog.getBody().getMoment());
                    double factor = -j / 0.05;
                    cog.getBody().addTorque(otherPos, r2 * factor);
                    return r1 * factor;
                }
            } else if (ent instanceof AbstractModularMachineEntity mech && mech.canBeCog()) {
                BlockState mechState = mech.getBlockState();
                if (mechState.hasProperty(TekoraBlockStates.GEAR_TYPE) && mechState.getValue(TekoraBlockStates.GEAR_TYPE) != GearType.NONE) {
                    double r1 = componentRadius();
                    double r2 = mech.componentRadius();

                    double otherV = r2 * mech.getVelocity();
                    double slipV = selfV + otherV;
                    double j = slipV / (Math.pow(r1, 2) / getMoment() + Math.pow(r2, 2) / mech.getMoment());
                    double factor = -j / 0.05;
                    mech.addTorque(r2 * factor);
                    return r1 * factor;
                }
            }
        }
        return 0;
    }

    @Override
    public double getMoment() {
        double orgMoment = ShaftEntity.STEEL_I + partMoment();
        BlockState state = getBlockState();
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE)) {
            GearType type = state.getValue(TekoraBlockStates.GEAR_TYPE);
            if (type != GearType.NONE) {
                orgMoment += state.getValue(TekoraBlockStates.GEAR_TYPE).getSmallMoment();
            }
        }
        return orgMoment;
    }

    protected abstract double partMoment();

    protected boolean canBeCog() {
        BlockState state = getBlockState();
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE)) {
            return state.getValue(TekoraBlockStates.GEAR_TYPE) != GearType.NONE;
        }
        return false;
    }

    @Override
    public double componentRadius() {
        BlockState state = getBlockState();
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.getValue(TekoraBlockStates.GEAR_TYPE) != GearType.NONE) {
            return 0.5;
        }
        return 0.125;
    }

    public float deltaVelocity() {
        return oldVelocity - velocity;
    }

    public float getVelocity() {
        return velocity;
    }

    public void addTorque(double torque) {
        velocity += (float) (torque / getMoment());
    }
}
