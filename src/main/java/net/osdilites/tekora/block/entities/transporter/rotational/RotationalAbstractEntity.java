package net.osdilites.tekora.block.entities.transporter.rotational;

import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
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
import net.osdilites.tekora.block.entities.mechanical.AbstractMechanicalEntity;
import net.osdilites.tekora.util.TekoraBody1D;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.Nullable;

import java.util.List;

public abstract class RotationalAbstractEntity extends AbstractMechanicalEntity {
    protected TekoraBody1D body;

    private float rotation; // todo, attach this later on to the force and acceleration values related to this block entity
    private BlockPos pA; // todo, make the pA and pB defined in the 1D physics object
    private BlockPos pB;
    private boolean bodyStart = false;

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
        this.bodyStart = body.isStart(getBlockPos());
    }

    public boolean sameAxis(Direction.Axis pAxis) {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
            Direction.Axis axis = state.getValue(AbstractTekoraAxialBlock.AXIS);
            return axis.equals(pAxis);
        }
        return false;
    }

    public void remove() {
        body.split(getLevel(), getBlockPos());
    }

    void reset() {
        body.reset();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide()) {
            if (pState.hasProperty(BlockStateProperties.FACING)) {
                this.setChanged(); // ensures that the block gets calculated.
            }
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                double rc = componentRadius();
                double mc = componentMass();
                this.setChanged(); // ensures that the block gets calculated.
                if (bodyStart) {
                    body.tick();
                }
            }
        } else {
            pLevel.sendBlockUpdated(pPos, pState, pState, 3); // used on client side.
        }
    }

    public float getOldRotation() {
        return rotation;
    }

    public float getRenderingRotation() {
        return rotation += 0.05f;
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

    public void createBody() {
        BlockState state = getBlockState();
        Direction.Axis axis = Direction.Axis.Y;
        if (state.hasProperty(BlockStateProperties.FACING)) {
            axis = state.getValue(BlockStateProperties.FACING).getAxis();
        } else if (state.hasProperty(BlockStateProperties.AXIS)) {
            axis = state.getValue(BlockStateProperties.AXIS);
        }
        body = new TekoraBody1D(axis, getBlockPos(), getBlockPos(), List.of(componentMass()));
    }

    // for debugging purposes
    public int getBodyHashcode() {
        return hasBody() ? body.hashCode() : 0;
    }
}
