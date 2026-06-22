package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.osdilites.tekora.util.TekoraBody1D;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class RotationalAbstractEntity extends AbstractMechanicalEntity {
    protected TekoraBody1D body;

    private boolean bodyTicker = false;

    public RotationalAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public TekoraBody1D combine(RotationalAbstractEntity pOther, BlockPos pPos, double mass) {
        body.join(pOther.body, pPos, mass);
        synchronizeEntities();
        return body;
    }

    public TekoraBody1D combine(BlockPos pPos, double mass) {
        body.join(pPos, mass);
        if (level != null && level.getBlockEntity(pPos) instanceof RotationalAbstractEntity rotEnt) {
            rotEnt.body = body;
            rotEnt.bodyTicker = body.isStart(pPos);
            bodyTicker = body.isStart(getBlockPos());
        }
        return body;
    }

    public void setBody(TekoraBody1D body) {
        this.body = body;
        updateTickerStatus();
    }

    public boolean sameAxis(Direction.Axis pAxis) {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            return axis.equals(pAxis);
        }
        return false;
    }

    @Override
    public void setRemoved() {
        if (!(level == null || level.isClientSide() || body == null)) {
            body.split(getBlockPos(), this);
        }

        super.setRemoved();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        boolean hasFacing = pState.hasProperty(BlockStateProperties.FACING);
        boolean hasAxis = pState.hasProperty(BlockStateProperties.AXIS);
        if (bodyTicker) {
            if (hasFacing || hasAxis) {
                body.tick();
            }
        }
        if (!pLevel.isClientSide()) {
            // air res formula:
            // force = -cAir * P * body.radius() * body.getSpeed();
            // -cAir is a constant, defined by the programmer
            // P is the pressure (in bars)
            if (body != null) {
                double pressure = 1; // in bars todo make this number dimension specific
                body.addForce(pPos, -1 * pressure * componentRadius() * body.getVelocity());
            }
            this.setChanged(); // ensures that the block gets calculated.
        } else {
            pLevel.sendBlockUpdated(pPos, pState, pState, 3); // used on client side.
        }
    }

    public float getOldRotation() {
        if (body == null) {
            return 0;
        }
        return body.getOldAngle();
    }

    public float getRenderingRotation() {
        if (body == null) {
            return 0;
        }
        return body.getAngle();
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, registries);
        this.saveAdditional(output);
        return output.buildResult();
    }

    public boolean hasBody() {
        return body != null;
    }

    protected void createOrJoinBody() { // this is called when the server loads often or not
        BlockState state = getBlockState();
        BlockPos pos = getBlockPos();
        Direction.Axis axis = Direction.Axis.Y;
        if (state.hasProperty(BlockStateProperties.FACING)) {
            axis = state.getValue(BlockStateProperties.FACING).getAxis();
        } else if (state.hasProperty(BlockStateProperties.AXIS)) {
            axis = state.getValue(BlockStateProperties.AXIS);
        }

        BlockPos before;
        BlockPos after;
        switch (axis) {
            case X -> {
                before = pos.west();
                after = pos.east();
            }
            case Z -> {
                before = pos.north();
                after = pos.south();
            }
            default -> {
                before = pos.below();
                after = pos.above();
            }
        }

        if (level != null) {
            if (level.getBlockEntity(before) instanceof RotationalAbstractEntity bRotEnt) {
                if (level.getBlockEntity(after) instanceof RotationalAbstractEntity aRotEnt) {
                    if (bRotEnt.body == null) {
                        if (aRotEnt.body == null) {
                            createBody(axis);
                            body.join(after, aRotEnt.getMoment());
                            body.join(before, bRotEnt.getMoment());
                        } else {
                            aRotEnt.body.join(pos, getMoment());
                            aRotEnt.body.join(before, getMoment());
                        }
                    } else {
                        if (aRotEnt.body == null) {
                            bRotEnt.body.join(pos, getMoment());
                            bRotEnt.body.join(after, getMoment());
                        } else {
                            bRotEnt.body.join(aRotEnt.body, pos, getMoment());
                        }
                        body = bRotEnt.body;
                    }
                } else {
                    if (bRotEnt.body == null) {
                        createBody(axis);
                        body.join(after, bRotEnt.getMoment());
                    } else {
                        bRotEnt.body.join(pos, getMoment());
                        bRotEnt.body.join(after, getMoment());
                        body = bRotEnt.body;
                    }
                }
            } else {
                if (level.getBlockEntity(after) instanceof RotationalAbstractEntity aRotEnt) {
                    if (aRotEnt.body == null) {
                        createBody(axis);
                        body.join(after, aRotEnt.getMoment());
                    } else {
                        aRotEnt.body.join(pos, getMoment());
                        aRotEnt.body.join(before, getMoment());
                        body = aRotEnt.body;
                    }
                } else {
                    createBody(axis);
                }
            }
            synchronizeEntities();
        }
    }

    private void synchronizeEntities() {
        if (body != null) {
            Queue<RotationalAbstractEntity> queue = body.getEntities();
            if (!queue.isEmpty()) {
                RotationalAbstractEntity first = queue.poll();
                first.body = body;
                first.bodyTicker = true;
                while (!queue.isEmpty()) {
                    RotationalAbstractEntity current = queue.poll();
                    current.body = body;
                    current.bodyTicker = false;
                }
            }
        }
    }

    private void createBody(Direction.Axis axis) {
        body = new TekoraBody1D(getLevel(), axis, getBlockPos(), getBlockPos(), new ArrayList<>(List.of(getMoment())));
    }

    public void updateTickerStatus() {
        if (body != null) {
            this.bodyTicker = body.isStart(getBlockPos());
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (body == null) {
            createOrJoinBody();
        }
    }

    // for debugging purposes
    public int getBodyHashcode() {
        return hasBody() ? body.hashCode() : 0;
    }
    public boolean isBodyTicker() {
        return bodyTicker;
    }
}
