package net.tekoramods.tekora.block.entities.mechanical.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTekoraAxialBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    protected AbstractTekoraAxialBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AXIS);
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (pState.hasProperty(AXIS) && entity instanceof RotationalAbstractEntity) {
                Direction.Axis axis = pState.getValue(AXIS);
                if (axis == Direction.Axis.X) {
                    BlockPos e = pPos.east();
                    BlockEntity east = pLevel.getBlockEntity(e);
                    BlockState eSt = pLevel.getBlockState(e);
                    if (eSt.hasProperty(AXIS) && east instanceof RotationalAbstractEntity rot) rot.reset();
                    BlockPos w = pPos.west();
                    BlockEntity west = pLevel.getBlockEntity(w);
                    BlockState wSt = pLevel.getBlockState(w);
                    if (wSt.hasProperty(AXIS) && west instanceof RotationalAbstractEntity rot) rot.reset();
                } else if (axis == Direction.Axis.Y) {
                    BlockPos u = pPos.above();
                    BlockEntity up = pLevel.getBlockEntity(u);
                    BlockState uSt = pLevel.getBlockState(u);
                    if (uSt.hasProperty(AXIS) && up instanceof RotationalAbstractEntity rot) rot.reset();
                    BlockPos d = pPos.below();
                    BlockEntity down = pLevel.getBlockEntity(d);
                    BlockState dSt = pLevel.getBlockState(d);
                    if (dSt.hasProperty(AXIS) && down instanceof RotationalAbstractEntity rot) rot.reset();
                } else if (axis == Direction.Axis.Z) {
                    BlockPos n = pPos.north();
                    BlockEntity north = pLevel.getBlockEntity(n);
                    BlockState nSt = pLevel.getBlockState(n);
                    if (nSt.hasProperty(AXIS) && north instanceof RotationalAbstractEntity rot) rot.reset();
                    BlockPos s = pPos.south();
                    BlockEntity south = pLevel.getBlockEntity(s);
                    BlockState sSt = pLevel.getBlockState(s);
                    if (sSt.hasProperty(AXIS) && south instanceof RotationalAbstractEntity rot) rot.reset();
                }
            }
        }
        super.destroy(pLevel, pPos, pState);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(AXIS, pContext.getNearestLookingDirection().getAxis());
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return switch (direction) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
                case X -> state.setValue(AXIS, Direction.Axis.Z);
                case Z -> state.setValue(AXIS, Direction.Axis.X);
                default -> state;
            };
            default -> state;
        };
    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return this.defaultBlockState().setValue(AXIS, pState.getValue(AXIS));
    }
}
