package net.leng.tekora.block.entity.blocks.connecters;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public abstract class AbstractCable extends AbstractConnector {
    protected static final VoxelShape CORE = Block.box(6, 6, 6, 8, 8, 8);

    private static final VoxelShape SHAPE_NORTH = Shapes.box(.4, .4, 0, .6, .6, .4);
    private static final VoxelShape SHAPE_SOUTH = Shapes.box(.4, .4, .6, .6, .6, 1);
    private static final VoxelShape SHAPE_WEST = Shapes.box(0, .4, .4, .4, .6, .6);
    private static final VoxelShape SHAPE_EAST = Shapes.box(.6, .4, .4, 1, .6, .6);
    private static final VoxelShape SHAPE_UP = Shapes.box(.4, .6, .4, .6, 1, .6);
    private static final VoxelShape SHAPE_DOWN = Shapes.box(.4, 0, .4, .6, .4, .6);

    public AbstractCable(float strength, SoundType sound) {
        super(strength, sound);
        makeShapes();
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    public AbstractCable(float strength) {
        this(strength, SoundType.METAL);
    }

    protected VoxelShape makeShape(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down) {
        VoxelShape shape = Shapes.box(0.4, 0.4, 0.4, 0.6, 0.6, 0.6);
        shape = combineShape(shape, north, SHAPE_NORTH);
        shape = combineShape(shape, south, SHAPE_SOUTH);
        shape = combineShape(shape, west, SHAPE_WEST);
        shape = combineShape(shape, east, SHAPE_EAST);
        shape = combineShape(shape, up, SHAPE_UP);
        shape = combineShape(shape, down, SHAPE_DOWN);
        return shape;
    }

    protected int getShapeIndex(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east,
                                ConnectorType up, ConnectorType down) {
        return ((((south.ordinal() * 2 + north.ordinal()) * 2 + west.ordinal()) * 2 + east.ordinal()) * 2 + up.ordinal()) * 2 + down.ordinal();
    }

    @Override
    protected void makeShapes() {
        if (this.shapeCache == null) {
            final ConnectorType[] values = new ConnectorType[]{ConnectorType.NONE, ConnectorType.CABLE};
            shapeCache = new VoxelShape[729];

            for (ConnectorType up : values) {
                for (ConnectorType down : values) {
                    for (ConnectorType north : values) {
                        for (ConnectorType south : values) {
                            for (ConnectorType east : values) {
                                for (ConnectorType west : values) {
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
    protected boolean canConnect(BlockEntity pEntity) {
        return pEntity != null && pEntity.getCapability(ForgeCapabilities.ENERGY).isPresent();
    }

    @Override
    public void changeBlockState(BlockState state, Direction direction) {
        Direction dir = direction.getOpposite();
        ConnectorType[] values = ConnectorType.values();
        switch (dir) {
            case UP -> state.setValue(AbstractConnector.UP, values[state.getValue(AbstractConnector.UP).ordinal() % 2]);
            case DOWN -> state.setValue(AbstractConnector.DOWN, values[state.getValue(AbstractConnector.DOWN).ordinal() % 2]);
            case NORTH -> state.setValue(AbstractConnector.NORTH, values[state.getValue(AbstractConnector.NORTH).ordinal() % 2]);
            case SOUTH -> state.setValue(AbstractConnector.SOUTH, values[state.getValue(AbstractConnector.SOUTH).ordinal() % 2]);
            case EAST -> state.setValue(AbstractConnector.EAST, values[state.getValue(AbstractConnector.EAST).ordinal() % 2]);
            case WEST -> state.setValue(AbstractConnector.WEST, values[state.getValue(AbstractConnector.WEST).ordinal() % 2]);
        }
    }
}
