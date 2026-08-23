package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.AbstractModularCraftEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractShaftConnectableEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.util.TekoraShaftBody;

import javax.annotation.Nullable;

public abstract class AbstractModularMachineEntity extends AbstractMechanicalEntity {
    private float oldRot;
    private float curRot;
    private double torque;
    private float velocity; // note as with all Tekora object classes, velocity here describes angular velocity (omega)

    @Nullable
    private TekoraShaftBody body;

    public AbstractModularMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public float getOldAngle() {
        return body == null ? oldRot : body.getOldAngle();
    }

    public float getAngle() {
        return body == null ? curRot : body.getAngle();
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // todo, make an implementation plan here
        if (pLevel != null) {
            double orgV = componentRadius() * velocity;
            double tot = 0;

            BlockEntity north = pLevel.getBlockEntity(pPos.north());
            BlockEntity south = pLevel.getBlockEntity(pPos.south());
            BlockEntity east = pLevel.getBlockEntity(pPos.east());
            BlockEntity west = pLevel.getBlockEntity(pPos.west());

            // the contact math works in theory, the math still needs to be fixed
            tot += contact(pLevel, pPos, pPos.north(), orgV, north);
            tot += contact(pLevel, pPos, pPos.south(), orgV, south);
            tot += contact(pLevel, pPos, pPos.east(), orgV, east);
            tot += contact(pLevel, pPos, pPos.west(), orgV, west);

            BlockPos above = pPos.above();
            if (pLevel.getBlockEntity(above) instanceof AbstractShaftConnectableEntity rot) {
                BlockState state = rot.getBlockState();
                if (state.hasProperty(BlockStateProperties.AXIS) && state.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) {
                    TekoraShaftBody rotBody = rot.getBody();
                    if (body == null && rotBody != null) {
                        rotBody.checkAttached();
                        body = rotBody.hasAttachment() ? rotBody : null;
                    }

                    if (body == null) {
                        usualUpdate(tot);
                    } else {
                        torque = tot;
                        body.addTorque(above, tot);
                        velocity = (float)body.getVelocity();
                    }
                } else if (getMoment() != 0) {
                    usualUpdate(tot);
                }
            } else if (getMoment() != 0) {
                usualUpdate(tot);
            }
        }
    }

    private void usualUpdate(double torque) {
        if (this.body != null && !this.body.hasAttachment()) {
            this.body.checkAttached();
            this.body = null;
        }
        this.torque = torque;
        this.velocity += (float) (torque / getMoment());
        this.oldRot = this.curRot;
        this.curRot += this.velocity;
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, BlockEntity ent) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;

        if (ent instanceof ShaftEntity cog && canBeCog() && cog.canBeCog()) {
            BlockState otherState = pLevel.getBlockState(otherPos);
            if (otherState.hasProperty(BlockStateProperties.AXIS) && otherState.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) {
                double r1 = componentRadius();
                double r2 = cog.componentRadius();

                double otherV = r2 * cog.getBody().getVelocity();
                double slipV = selfV + otherV;
                double j = slipV / (Math.pow(r1, 2) / getMoment() + Math.pow(r2, 2) / cog.getBody().getMoment());
                double factor = -j / 0.05;
                cog.getBody().addTorque(otherPos, r2 * factor);
                return r1 * factor;
            }
        } else if (ent instanceof AbstractModularMachineEntity machine) {
            double r1 = componentRadius();
            double r2 = machine.componentRadius();

            double otherV = r2 * machine.getVelocity();
            double slipV = selfV + otherV;
            double j = slipV / (Math.pow(r1, 2) / getMoment() + Math.pow(r2, 2) / machine.getMoment());
            double factor = -j / 0.05;
            machine.addTorque(r2 * factor);
            return r1 * factor;
        }
        return 0;
    }

    @Override
    public double getMoment() {
        if (body != null) {
            return body.getMoment();
        }
        return getSingularMoment();
    }

    public double getSingularMoment() {
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
        return state.getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE;
    }

    @Override
    public double componentRadius() {
        BlockState state = getBlockState();
        if (state.getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
            return 0.5;
        }
        return 0.125;
    }

    public float getVelocity() {
        return velocity;
    }
    public double getTorque() {
        return torque;
    }

    public void addTorque(double torque) {
        if (body == null) {
            velocity += (float) (torque / getMoment());
        } else {
            body.addTorque(getBlockPos().above(), torque);
            velocity = (float)body.getVelocity();
        }
    }

    public float getProgress() {
        if (level != null) {
            BlockPos below = getBlockPos().below();
            if (level.getBlockEntity(below) instanceof AbstractModularCraftEntity crafter) {
                return crafter.getProgress();
            }
        }
        return 0;
    }
}