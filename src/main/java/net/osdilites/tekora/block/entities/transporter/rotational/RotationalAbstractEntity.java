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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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

    public void setBody(TekoraBody1D body) {
        this.body = body;
        updateTickerStatus();
    }

    @Override
    public void setRemoved() {
        if (!(level == null || body == null)) {
            BlockState state = getBlockState();
            BlockPos pos = getBlockPos();
            if (state.hasProperty(BlockStateProperties.FACING)) {
                Direction dir = state.getValue(BlockStateProperties.FACING).getOpposite();
                BlockPos checkPos = switch(dir) {
                    case EAST -> pos.east();
                    case WEST -> pos.west();
                    case NORTH -> pos.north();
                    case SOUTH -> pos.south();
                    case UP -> pos.above();
                    case DOWN -> pos.below();
                };
                if (level.getBlockEntity(checkPos) instanceof RotationalAbstractEntity) {
                    boolean callFirst = dir == Direction.UP || dir == Direction.EAST || dir == Direction.SOUTH;
                    if (callFirst) {
                        body.trimFirst();
                    } else {
                        body.trimLast();
                    }
                }
            } else if (state.hasProperty(BlockStateProperties.AXIS)) {
                Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                BlockPos afterPos = switch (axis) {
                    case X -> pos.west();
                    case Y -> pos.above();
                    case Z -> pos.south();
                };
                BlockPos beforePos = switch (axis) {
                    case X -> pos.east();
                    case Y -> pos.below();
                    case Z -> pos.north();
                };
                if (level.getBlockEntity(beforePos) instanceof RotationalAbstractEntity) {
                    if (level.getBlockEntity(afterPos) instanceof RotationalAbstractEntity) {
                        body.split(pos, this);
                    } else {
                        body.trimLast();
                    }
                } else if (level.getBlockEntity(afterPos) instanceof RotationalAbstractEntity) {
                    body.trimFirst();
                }
            }

            if (bodyTicker && level.getBlockEntity(body.getStart()) instanceof RotationalAbstractEntity newFirst) {
                bodyTicker = false;
                newFirst.bodyTicker = true;
            }
        }

        super.setRemoved();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        boolean hasFacing = pState.hasProperty(BlockStateProperties.FACING);
        boolean hasAxis = pState.hasProperty(BlockStateProperties.AXIS);
        if (pLevel.isClientSide() && bodyTicker && (hasFacing || hasAxis)) {
            body.tick();
        }
        if (!pLevel.isClientSide()) {
            if (body != null) {
                double pressure = 1; // in bars todo make this number dimension specific
                // If Tekora space became a thing, this may also need to read from dimension json files.
                // For any possible Ad Astra, Stellaris, or Northstar compatibility, read off json files.
                // For other mods that add dimensions, we'll treat 1 as the default value.

                // todo, beyond air resistance, we need to wonder about friction applied by blocks in contact with the block.
                //  This could be done by hard coding it (as in using class hierarchies etc) or the use of json files for datapack creators or mods.
                body.addTorque(pPos, -0.5 * pressure * componentRadius() * body.getVelocity()); // this value inputted in air resistance
            }
            this.setChanged(); // ensures that the block gets calculated.
        } else {
            pLevel.sendBlockUpdated(pPos, pState, pState, 3); // used on client side.
        }
    }

    public float getOldAngle() {
        if (body == null) {
            return 0;
        }
        return body.getOldAngle();
    }

    public float getAngle() {
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

    @Override
    public void setChanged() {
        super.setChanged();
        if (body != null) {
            BlockState state = getBlockState();
            if (state.hasProperty(BlockStateProperties.FACING)) {
                Direction.Axis axis = state.getValue(BlockStateProperties.FACING).getAxis();
                if (!body.axisMatch(axis)) {
                    body.split(getBlockPos(), this);
                    createBody(axis);
                }
            } else if (state.hasProperty(BlockStateProperties.AXIS)) {
                Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                if (!body.axisMatch(axis)) {
                    body.split(getBlockPos(), this);
                    createBody(axis);
                }
            }
        }
    }

    public boolean hasBody() {
        return body != null;
    }

    protected void createOrJoinBody() {
        if (level != null) {
            BlockState state = getBlockState();
            BlockPos pos = getBlockPos();
            if (state.hasProperty(BlockStateProperties.FACING)) {
                Direction dir = state.getValue(BlockStateProperties.FACING).getOpposite();

                BlockPos checkedPos = switch (dir) {
                    case EAST -> pos.east();
                    case WEST -> pos.west();
                    case NORTH -> pos.north();
                    case SOUTH -> pos.south();
                    case UP -> pos.above();
                    case DOWN -> pos.below();
                };

                Direction.Axis axis = dir.getAxis();
                BlockState checkedState = level.getBlockState(checkedPos);

                if (level.getBlockEntity(checkedPos) instanceof RotationalAbstractEntity checkedEnt) {
                    if (checkedEnt.body == null) {
                        createBody(axis);
                        if (connectable(checkedState, dir.getOpposite(), axis)) {
                            body.join(checkedPos, checkedEnt.getMoment());
                        }
                    } else if (connectable(checkedState, dir.getOpposite(), axis)) {
                        checkedEnt.body.join(pos, getMoment());
                        body = checkedEnt.body;
                    } else {
                        createBody(axis);
                    }
                    checkedEnt.synchronizeEntities();
                } else {
                    createBody(axis);
                }
            } else if (state.hasProperty(BlockStateProperties.AXIS)) {
                Direction.Axis axis = state.getValue(BlockStateProperties.AXIS); // inherent problem here

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
                BlockState beforeState = level.getBlockState(before);
                BlockState afterState = level.getBlockState(after);
                if (level.getBlockEntity(before) instanceof RotationalAbstractEntity bRotEnt) {
                    if (level.getBlockEntity(after) instanceof RotationalAbstractEntity aRotEnt) {
                        if (bRotEnt.body == null) {
                            if (aRotEnt.body == null) {
                                createBody(axis);
                                if (connectable(afterState, axis, true)) {
                                    body.join(after, aRotEnt.getMoment());
                                }
                                if (connectable(beforeState, axis, false)) {
                                    body.join(before, bRotEnt.getMoment());
                                }
                            } else if (connectable(afterState, axis, true)) {
                                aRotEnt.body.join(pos, getMoment());
                                if (connectable(beforeState, axis, false)) {
                                    aRotEnt.body.join(before, bRotEnt.getMoment());
                                }
                                body = aRotEnt.body;
                            } else {
                                createBody(axis);
                            }
                        } else if (connectable(beforeState, axis, false)) {
                            if (aRotEnt.body == null) {
                                bRotEnt.body.join(pos, getMoment());
                                if (connectable(afterState, axis, true)) {
                                    bRotEnt.body.join(after, aRotEnt.getMoment());
                                }
                                body = bRotEnt.body;
                            } else if (connectable(afterState, axis, true)) {
                                bRotEnt.body.join(aRotEnt.body, pos, aRotEnt.getMoment());
                                body = bRotEnt.body;
                            } else {
                                createBody(axis);
                            }
                        } else {
                            createBody(axis);
                        }
                    } else {
                        if (bRotEnt.body == null) {
                            createBody(axis);
                            if (connectable(beforeState, axis, false)) {
                                body.join(before, bRotEnt.getMoment());
                            }
                        } else if (connectable(beforeState, axis, false)) {
                            bRotEnt.body.join(pos, getMoment());
                            body = bRotEnt.body;
                        } else {
                            createBody(axis);
                        }
                    }
                } else {
                    if (level.getBlockEntity(after) instanceof RotationalAbstractEntity aRotEnt) {
                        if (aRotEnt.body == null) {
                            createBody(axis);
                            if (connectable(afterState, axis, true)) {
                                body.join(after, aRotEnt.getMoment());
                            }
                        } else if (connectable(afterState, axis, true)) {
                            aRotEnt.body.join(pos, getMoment());
                            body = aRotEnt.body;
                        } else {
                            createBody(axis);
                        }
                    } else {
                        createBody(axis);
                    }
                }
                synchronizeEntities();
            }
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

    public TekoraBody1D getBody() {
        return body;
    }

    public void updateTickerStatus() {
        if (body != null) {
            this.bodyTicker = body.isStart(getBlockPos());
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (body == null && level != null) {
            createOrJoinBody(); // there is a random statistic chance that both bodies are null
            // that is unlikely but if it does happen, a solution needs to be present to remove this issue.
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (body != null) {
            body.save(output);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        if (body != null && isBodyTicker()) {
            body.load(input);
        }
    }

    private boolean connectable(BlockState checkedState, Direction.Axis axis, boolean isPos) {
        if (checkedState.hasProperty(BlockStateProperties.FACING)) {
            Direction checkedDir = checkedState.getValue(BlockStateProperties.FACING);
            return (checkedDir.getAxisDirection() == Direction.AxisDirection.POSITIVE) == isPos && checkedDir.getAxis() == axis;
        }
        return checkedState.hasProperty(BlockStateProperties.AXIS) && checkedState.getValue(BlockStateProperties.AXIS) == axis;
    }

    private boolean connectable(BlockState checkedState, Direction dir, Direction.Axis axis) {
        if (axis != dir.getAxis()) {
            return false;
        }
        if (checkedState.hasProperty(BlockStateProperties.FACING)) {
            Direction checkedDir = checkedState.getValue(BlockStateProperties.FACING);
            return checkedDir == dir.getOpposite();
        }
        return checkedState.hasProperty(BlockStateProperties.AXIS) && checkedState.getValue(BlockStateProperties.AXIS) == axis;
    }

    // for debugging purposes
    public int getBodyHashcode() {
        return hasBody() ? body.hashCode() : 0;
    }
    public boolean isBodyTicker() {
        return bodyTicker;
    }
}
