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
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.osdilites.tekora.util.TekoraBody1D;
import org.jspecify.annotations.Nullable;

import java.util.List;

public abstract class RotationalAbstractEntity extends AbstractMechanicalEntity {
    protected TekoraBody1D body;
    private boolean bodyTicker = false;

    public RotationalAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    public TekoraBody1D combine(RotationalAbstractEntity pOther, BlockPos pPos, double mass) {
        body.join(pOther.body, pPos, mass);
        return body;
    }

    public TekoraBody1D combine(BlockPos pPos, double mass) {
        body.join(pPos, mass);
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

    void reset() {
        body.reset();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide()) {
            if (pState.hasProperty(BlockStateProperties.FACING)) {
                validTicking(pState.getValue(BlockStateProperties.FACING).getAxis(), 0);
            } else if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                validTicking(pState.getValue(AbstractTekoraAxialBlock.AXIS), 0);
            }
        } else {
            pLevel.sendBlockUpdated(pPos, pState, pState, 3); // used on client side.
        }
    }

    private void validTicking(Direction.Axis axis, double num) {
        if (bodyTicker) {
            body.tick();
        }
        // air res formula:
        // force = -cAir * P * body.radius() * body.getSpeed();
        // -cAir is a constant, defined by the programmer
        // P is the pressure
        this.setChanged(); // ensures that the block gets calculated.
    }

    public float getOldRotation() {
        if (body == null) {
            if (level != null && !level.isClientSide())
                createBody();
            else
                return 0;
        }
        return body.getOldAngle();
    }

    public float getRenderingRotation() {
        if (body == null) {
            if (level != null && !level.isClientSide())
                createBody();
            else
                return 0;
        }
        return body.getAngle();
    }

    public abstract double componentResistance();

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

    @Deprecated
    public void createBody() {
        BlockState state = getBlockState();
        Direction.Axis axis = Direction.Axis.Y;
        if (state.hasProperty(BlockStateProperties.FACING)) {
            axis = state.getValue(BlockStateProperties.FACING).getAxis();
        } else if (state.hasProperty(BlockStateProperties.AXIS)) {
            axis = state.getValue(BlockStateProperties.AXIS);
        }
        body = new TekoraBody1D(getLevel(), axis, getBlockPos(), getBlockPos(), List.of(componentMass()));
    }

    public void updateTickerStatus() {
        this.bodyTicker = body.isStart(getBlockPos());
    }

    // for debugging purposes
    public int getBodyHashcode() {
        return hasBody() ? body.hashCode() : 0;
    }

    public boolean isBodyTicker() {
        return bodyTicker;
    }

}
