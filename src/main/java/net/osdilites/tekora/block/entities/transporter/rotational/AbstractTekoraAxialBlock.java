package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.osdilites.tekora.util.TekoraBody1D;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTekoraAxialBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    protected AbstractTekoraAxialBlock(Properties pProperties) {
        super(pProperties.noOcclusion());
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
            if (entity instanceof RotationalAbstractEntity ent) {
                ent.remove();
            }
        }
        super.destroy(pLevel, pPos, pState);
    }

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        // todo, implement a system in which the center of any block entity a part of this gets recalculated on placement
        // implementation idea
        //      Upon placement, the endpoint touching it gets removed and
        //      If it only has one neighbor, this point itself becomes the end point
        //      If it has two neighbors, the endpoints get swapped.
        //      If it has zero neighbors, its two endpoints are defined as itself.

        if (!pLevel.isClientSide() && pState.hasProperty(AXIS)) {
            BlockEntity thisEnt = pLevel.getBlockEntity(pPos);
            if (thisEnt instanceof RotationalAbstractEntity ent) {
                Direction.Axis axis = pState.getValue(AXIS);
                BlockPos a;
                BlockPos b;
                if (axis == Direction.Axis.X) {
                    a = pPos.east();
                    b = pPos.west();
                } else if (axis == Direction.Axis.Y) {
                    a = pPos.above();
                    b = pPos.below();
                } else {
                    a = pPos.north();
                    b = pPos.south();
                }
                BlockEntity aEnt = pLevel.getBlockEntity(a);
                BlockEntity bEnt = pLevel.getBlockEntity(b);

                boolean aValid = aEnt instanceof RotationalAbstractEntity;
                boolean bValid = bEnt instanceof RotationalAbstractEntity;
                TekoraBody1D body;
                if (aValid && bValid) {
                    body = ((RotationalAbstractEntity) aEnt).combine((RotationalAbstractEntity) bEnt, pPos, ent.componentMass());
                } else if (aValid) {
                    body = ((RotationalAbstractEntity) aEnt).combine(pPos, ent.componentMass());
                } else if (bValid) {
                    body = ((RotationalAbstractEntity) bEnt).combine(pPos, ent.componentMass());
                } else {
                    List<Double> masses = new ArrayList<>(List.of(ent.componentMass()));
                    body = new TekoraBody1D(axis, pPos, pPos, masses);
                }
                ent.setBody(body);
            }
        }
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        // todo replace the current system with one such that the axis is obtained from the face of the block it is placed on rather than looking direction
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

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
}
