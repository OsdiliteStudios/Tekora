package net.osdilites.tekora.block.entities.transporter.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.block.TekoraBlockStates;
import org.jspecify.annotations.Nullable;

public abstract class AbstractTekoraPipe extends BaseEntityBlock {
    protected static final IntegerProperty CONNECTION = TekoraBlockStates.CONNECTION;

    private static final VoxelShape CENTER = Block.box(4, 4, 4, 12, 12, 12);

    private static final VoxelShape EAST = Shapes.or(
            Block.box(0, 4, 4, 8, 12, 12),
            Block.box(0, 3, 3, 2, 13, 13)
    );
    private static final VoxelShape WEST = Shapes.or(
            Block.box(8, 4, 4, 16, 12, 12),
            Block.box(14, 3, 3, 16, 13, 13)
    );
    private static final VoxelShape NORTH = Shapes.or(
            Block.box(4, 4, 0, 12, 12, 8),
            Block.box(3, 3, 0, 13, 13, 2)
    );
    private static final VoxelShape SOUTH = Shapes.or(
            Block.box(4, 4, 8, 12, 12, 16),
            Block.box(3, 3, 14, 13, 13, 16)
    );
    private static final VoxelShape ABOVE = Shapes.or(
            Block.box(4, 0, 4, 12, 8, 12),
            Block.box(3, 0, 3, 13, 2, 13)
    );
    private static final VoxelShape BELOW = Shapes.or(
            Block.box(4, 8, 4, 12, 16, 12),
            Block.box(3, 14, 3, 13, 16, 13)
    );

    private static final VoxelShape[] SHAPES = shapes();

    private static VoxelShape[] shapes() {
        VoxelShape[] shapes = new VoxelShape[0b111111];
        for (int a = 0; a < 2; a++) {
            VoxelShape joined = a == 0 ? CENTER : EAST;
            for (int b = 0; b < 2; b++) {
                joined = b == 0 ? joined : Shapes.or(joined, WEST);
                for (int c = 0; c < 2; c++) {
                    joined = c == 0 ? joined : Shapes.or(joined, ABOVE);
                    for (int d = 0; d < 2; d++) {
                        joined = d == 0 ? joined : Shapes.or(joined, BELOW);
                        for (int e = 0; e < 2; e++) {
                            joined = e == 0 ? joined : Shapes.or(joined, NORTH);
                            for (int f = 0; f < 2; f++) {
                                joined = f == 0 ? joined : Shapes.or(joined, SOUTH);
                                int val = f + e * 2 + d * 4 + c * 8 + b * 16 + a * 32;
                                shapes[val] = joined;
                            }
                        }
                    }
                }
            }
        }
        // boolean structure
        // [isEast, isWest, isAbove, isBelow, isNorth, isSouth]
        return shapes;
    }

    protected AbstractTekoraPipe(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CONNECTION);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        changeState(level, state, pos);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);
        if (level instanceof Level world) changeState(world, state, pos);
    }

    private void changeState(Level level, BlockState state, BlockPos pos) {
        BlockState newState = state;
        int orgVal = state.getValueOrElse(CONNECTION, 0);
        BlockState aboveState = level.getBlockState(pos.above());
        newState = newState.setValue(CONNECTION, aboveState.is(this) && aboveState.hasProperty(CONNECTION) ? orgVal | 0b001000 : orgVal & 0b110111);

        BlockState belowState = level.getBlockState(pos.below());
        newState = newState.setValue(CONNECTION, belowState.is(this) && belowState.hasProperty(CONNECTION) ? orgVal | 0b000100 : orgVal & 0b111011);

        BlockState northState = level.getBlockState(pos.north());
        newState = newState.setValue(CONNECTION, northState.is(this) && northState.hasProperty(CONNECTION) ? orgVal | 0b000010 : orgVal & 0b111101);

        BlockState southState = level.getBlockState(pos.south());
        newState = newState.setValue(CONNECTION, southState.is(this) && southState.hasProperty(CONNECTION) ? orgVal | 0b000001 : orgVal & 0b111110);

        BlockState eastState = level.getBlockState(pos.east());
        newState = newState.setValue(CONNECTION, eastState.is(this) && eastState.hasProperty(CONNECTION) ? orgVal | 0b100000 : orgVal & 0b011111);

        BlockState westState = level.getBlockState(pos.west());
        newState = newState.setValue(CONNECTION, westState.is(this) && westState.hasProperty(CONNECTION) ? orgVal | 0b010000 : orgVal & 0b101111);

        level.setBlock(pos, newState, 3);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(CONNECTION, 0);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.hasProperty(CONNECTION)) {
            return SHAPES[state.getValue(CONNECTION)];
        }
        return CENTER;
    }
}
