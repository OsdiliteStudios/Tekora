package net.leng.tekora.block.entity.blocks.connecters;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractPipe extends AbstractConnector {

    protected static final VoxelShape CORE = Block.box(5, 5, 5, 9, 9, 9);

    protected static final VoxelShape SHAPE_NORTH = Shapes.box(0.4, 0.4, 0, 0.6, 0.6, 0.4);
    protected static final VoxelShape SHAPE_SOUTH = Shapes.box(0.4, 0.4, 0.6, 0.6, 0.6, 1);
    protected static final VoxelShape SHAPE_WEST = Shapes.box(0, 0.4, 0.4, 0.4, 0.6, 0.6);
    protected static final VoxelShape SHAPE_EAST = Shapes.box(0.6, 0.4, 0.4, 1, 0.6, 0.6);
    protected static final VoxelShape SHAPE_UP = Shapes.box(0.4, 0.6, 0.4, 0.6, 1, 0.6);
    protected static final VoxelShape SHAPE_DOWN = Shapes.box(0.4, 0, 0.4, 0.6, 0.4, 0.6);
    public AbstractPipe(float strength, SoundType sound) {
        super(strength, sound);
    }

    public AbstractPipe(float strength) {
        super(strength);
    }

    @Override
    protected int getShapeIndex(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down) {
        return ((((south.ordinal() * 5 + north.ordinal()) * 5 + west.ordinal()) * 5 + east.ordinal()) * 5 + up.ordinal()) * 5 + down.ordinal();
    }

    @Override
    protected void makeShapes() {
        if (this.shapeCache == null) {
            shapeCache = new VoxelShape[15625];

            for (ConnectorType up : ConnectorType.VALUES) {
                for (ConnectorType down : ConnectorType.VALUES) {
                    for (ConnectorType north : ConnectorType.VALUES) {
                        for (ConnectorType south : ConnectorType.VALUES) {
                            for (ConnectorType east : ConnectorType.VALUES) {
                                for (ConnectorType west : ConnectorType.VALUES) {
                                    int ind = getShapeIndex(north, south, west, east, up, down);
                                    shapeCache[ind] = makeShape(north, south, west, east, up, down);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected VoxelShape makeShape(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down) {
        VoxelShape shape = Shapes.box(0.3, 0.3, 0.3, 0.7, 0.7, 0.7);
        shape = combineShape(shape, north, SHAPE_NORTH);
        shape = combineShape(shape, south, SHAPE_SOUTH);
        shape = combineShape(shape, west, SHAPE_WEST);
        shape = combineShape(shape, east, SHAPE_EAST);
        shape = combineShape(shape, up, SHAPE_UP);
        shape = combineShape(shape, down, SHAPE_DOWN);
        return shape;
    }

    @Override
    public void changeBlockState(BlockState state, Direction direction) {
        Direction dir = direction.getOpposite();
        ConnectorType[] values = ConnectorType.values();
        switch (dir) {
            case UP -> state.setValue(AbstractConnector.UP, values[state.getValue(AbstractConnector.UP).ordinal() % values.length]);
            case DOWN -> state.setValue(AbstractConnector.DOWN, values[state.getValue(AbstractConnector.DOWN).ordinal() % values.length]);
            case NORTH -> state.setValue(AbstractConnector.NORTH, values[state.getValue(AbstractConnector.NORTH).ordinal() % values.length]);
            case SOUTH -> state.setValue(AbstractConnector.SOUTH, values[state.getValue(AbstractConnector.SOUTH).ordinal() % values.length]);
            case EAST -> state.setValue(AbstractConnector.EAST, values[state.getValue(AbstractConnector.EAST).ordinal() % values.length]);
            case WEST -> state.setValue(AbstractConnector.WEST, values[state.getValue(AbstractConnector.WEST).ordinal() % values.length]);
        }
    }
}
