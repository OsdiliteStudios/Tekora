package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.AbstractShaftConnectableEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.util.TekoraShaftBody;

import javax.annotation.Nullable;

public abstract class AbstractModularMachineEntity extends BlockEntity {
    private float oldRot;
    private float curRot;
    private double torque;
    private float velocity; // note as with all Tekora object classes, velocity here describes angular velocity (omega)

    private float yPos = 0.0f;
    private final float g;
    private final boolean rotational;

    @Nullable
    private TekoraShaftBody body;

    public AbstractModularMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, boolean rotational) {
        super(pType, pPos, pBlockState);
        this.g = -0.49f; // todo, make this defined by dimensional gravity
        this.rotational = rotational;
    }

    public float getOldAngle() {
        return body == null ? oldRot : body.getOldAngle();
    }

    public float getAngle() {
        return body == null ? curRot : body.getAngle();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // todo, make an implementation plan here
        if (pLevel != null) {
            double orgV = componentRadius() * velocity;
            double tot = 0;

            GearType type = pState.getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE);
            if (type != GearType.NONE) {
                BlockEntity north = pLevel.getBlockEntity(pPos.north());
                BlockEntity south = pLevel.getBlockEntity(pPos.south());
                BlockEntity east = pLevel.getBlockEntity(pPos.east());
                BlockEntity west = pLevel.getBlockEntity(pPos.west());

                // the contact math works in theory, the math still needs to be fixed
                tot += contact(pLevel, pPos, pPos.north(), orgV, north);
                tot += contact(pLevel, pPos, pPos.south(), orgV, south);
                tot += contact(pLevel, pPos, pPos.east(), orgV, east);
                tot += contact(pLevel, pPos, pPos.west(), orgV, west);
            }


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
                        usualUpdate(pLevel, pPos, pState, tot);
                    } else {
                        torque = tot;
                        body.addTorque(above, tot); // todo, check for any other potential conditions for calling torque
                        velocity = (float)body.getVelocity();
                        pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                    }
                } else if (getMoment() != 0) {
                    usualUpdate(pLevel, pPos, pState, tot);
                }
            } else if (getMoment() != 0) {
                usualUpdate(pLevel, pPos, pState, tot);
            }
        }
    }

    private void usualUpdate(Level level, BlockPos pos, BlockState state, double torque) {
        if (this.body != null && !this.body.hasAttachment()) {
            this.body.checkAttached();
            this.body = null;
        }
        this.torque = torque;
        this.velocity += (float) (torque / getMoment());
        this.oldRot = this.curRot;
        this.curRot += this.velocity;
        level.sendBlockUpdated(pos, state, state, 3);
    }

    private double contact(Level pLevel, BlockPos curPos, BlockPos otherPos, double selfV, BlockEntity ent) {
        if (curPos.asLong() >= otherPos.asLong()) return 0;

        if (ent instanceof ShaftEntity cog && canBeCog() && cog.canBeCog()) {
            BlockState otherState = pLevel.getBlockState(otherPos);
            if (otherState.hasProperty(BlockStateProperties.AXIS) && otherState.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y && otherState.getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
                double r1 = componentRadius();
                double r2 = cog.componentRadius();

                double otherV = r2 * cog.getBody().getVelocity();
                double slipV = selfV + otherV;
                double j = slipV / (Math.pow(r1, 2) / getMoment() + Math.pow(r2, 2) / cog.getBody().getMoment());
                double factor = -j / 0.05;
                cog.getBody().addTorque(otherPos, r2 * factor);
                return r1 * factor;
            }
        } else if (ent instanceof AbstractModularMachineEntity machine && machine.getBlockState().getValueOrElse(TekoraBlockStates.GEAR_TYPE, GearType.NONE) != GearType.NONE) {
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
        if (!(Double.isNaN(torque) || Double.isInfinite(torque))) {
            if (body == null) {
                this.velocity += (float) (torque * 0.05 / getMoment());
                this.torque += torque;
            } else if (body.axisMatch(Direction.Axis.Y)) {
                this.body.addTorque(getBlockPos().above(), torque);
                this.velocity = (float) this.body.getVelocity();
                this.torque += torque;
            }
        }
    }

    public void increment(Level level) {
        if (yPos > -0.5f) {
            yPos -= (float)Math.sqrt((-2 * yPos + 1) * ((velocity * velocity * -g))) / 20f;
            if (yPos < -0.5f || Double.isNaN(yPos) || Double.isInfinite(yPos)) {
                yPos = -0.5f;
            }
            if (level != null) level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public void decrement(Level level) {
        float factor = (velocity * velocity);
        if (yPos < 0 && factor > g) {
            yPos += (float)Math.sqrt((2 * yPos + 0.5f) * (factor * -g)) / 20f;
            if (yPos >= 0 || Double.isNaN(yPos) || Double.isInfinite(yPos)) {
                yPos = 0;
            }
            if (level != null) level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    public boolean canCraft(double ratedVelocity) {
        if (rotational) {
            return velocity > ratedVelocity;
        } else {
            return yPos <= -0.5f;
        }
    }
    
    public float getHeightPosition() {
        return yPos;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (level != null && body != null) {
            body.save(output);
        } else {
            output.putDouble("velocity", velocity);
            output.putFloat("angle", curRot);
        }
        output.putFloat("machine.ypos", yPos);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        if (body != null) {
            body.load(input);
        } else {
            velocity = input.getFloatOr("velocity", 0);
            curRot = oldRot = input.getFloatOr("angle", 0);
        }
        yPos = input.getFloatOr("machine.ypos", 0);
    }

    // BLOCK ENTITY SYNC
    @Override
    public void handleUpdateTag(ValueInput input) {
        super.handleUpdateTag(input);
        loadAdditional(input);
    }

    @Override
    public @org.jspecify.annotations.Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ValueInput valueInput) {
        this.handleUpdateTag(valueInput);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, registries);
        this.saveAdditional(output);
        tag.merge(output.buildResult());
        return tag;
    }
}