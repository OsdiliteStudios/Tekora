package net.osdilites.tekora.block.entities;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModularCrafter extends BaseEntityBlock {
    private static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public AbstractModularCrafter(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

//    @Override
//    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
//        return switch (direction) {
//            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(FACING)) {
//                case X -> state.setValue(AXIS, Direction.Axis.Z);
//                case Z -> state.setValue(AXIS, Direction.Axis.X);
//                default -> state.setValue(AXIS, Direction.Axis.Y);
//            };
//            default -> state;
//        };
//    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return this.defaultBlockState().setValue(FACING, pState.getValue(FACING));
    }
}
