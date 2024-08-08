package net.tekoramods.tekora.block.entity.blocks.connecters;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.ticks.ScheduledTick;
import net.minecraftforge.client.model.data.ModelProperty;
import net.tekoramods.tekora.block.FluidloggedBlock;
import net.tekoramods.tekora.block.entity.entities.connectors.AbstractConnectorEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractConnector extends BaseEntityBlock implements FluidloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final EnumProperty<ConnectorType> NORTH = EnumProperty.create("north", ConnectorType.class);
    public static final EnumProperty<ConnectorType> SOUTH = EnumProperty.create("south", ConnectorType.class);
    public static final EnumProperty<ConnectorType> EAST = EnumProperty.create("east", ConnectorType.class);
    public static final EnumProperty<ConnectorType> WEST = EnumProperty.create("west", ConnectorType.class);
    public static final EnumProperty<ConnectorType> UP = EnumProperty.create("up", ConnectorType.class);
    public static final EnumProperty<ConnectorType> DOWN = EnumProperty.create("down", ConnectorType.class);

    public static final ModelProperty<BlockState> FACADE_ID = new ModelProperty<>();
    protected VoxelShape[] shapeCache = null;

    public AbstractConnector(float strength, SoundType sound) {
        super(Properties.of().strength(strength).requiresCorrectToolForDrops().sound(sound).noOcclusion());
    }

    public AbstractConnector(float strength) {
        this(strength, SoundType.METAL);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.tekora.tier").append(" " + this.getTier()).withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level lvl = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        return calculateState(lvl, pos, defaultBlockState()).setValue(WATERLOGGED,
                lvl.getFluidState(pos).getType().isSame(Fluids.WATER) && lvl.getFluidState(pos).isSource());
    }

    protected BlockState calculateState(LevelAccessor pLevel, BlockPos pCurrentPos, BlockState pState) {
        ConnectorType north = getConnectorType(pLevel, pCurrentPos, Direction.NORTH);
        ConnectorType south = getConnectorType(pLevel, pCurrentPos, Direction.SOUTH);
        ConnectorType east = getConnectorType(pLevel, pCurrentPos, Direction.EAST);
        ConnectorType west = getConnectorType(pLevel, pCurrentPos, Direction.WEST);
        ConnectorType up = getConnectorType(pLevel, pCurrentPos, Direction.UP);
        ConnectorType down = getConnectorType(pLevel, pCurrentPos, Direction.DOWN);

        return pState.setValue(NORTH, north).setValue(SOUTH, south).setValue(EAST, east).setValue(WEST, west)
                .setValue(UP, up).setValue(DOWN, down);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected void makeShapes() {
    }

    protected VoxelShape combineShape(VoxelShape shape, ConnectorType connectorType, VoxelShape cableShape) {
        return connectorType == ConnectorType.CABLE ? Shapes.join(shape, cableShape, BooleanOp.OR) : shape;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        ConnectorType north = getConnectorType(pLevel, pPos, Direction.NORTH);
        ConnectorType south = getConnectorType(pLevel, pPos, Direction.SOUTH);
        ConnectorType west = getConnectorType(pLevel, pPos, Direction.WEST);
        ConnectorType east = getConnectorType(pLevel, pPos, Direction.EAST);
        ConnectorType up = getConnectorType(pLevel, pPos, Direction.UP);
        ConnectorType down = getConnectorType(pLevel, pPos, Direction.DOWN);
        int index = getShapeIndex(north, south, west, east, up, down);
        return shapeCache[index];
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.getFluidTicks().schedule(new ScheduledTick<>(Fluids.WATER, pCurrentPos, Fluids.WATER.getTickDelay(pLevel), 0));
            // fluid may be changed later as a result of new states.
        }
        return calculateState(pLevel, pCurrentPos, pState);
    }

    @Override
    public void onNeighborChange(BlockState pState, LevelReader pLevel, BlockPos pPos, BlockPos pNeighbor) {
        super.onNeighborChange(pState, pLevel, pPos, pNeighbor);
        if (!pLevel.isClientSide() && pLevel.getBlockEntity(pPos) instanceof AbstractConnectorEntity connector) {
            connector.markDirty();
        }
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide && pLevel.getBlockEntity(pPos) instanceof AbstractConnectorEntity connector) {
            connector.markDirty();
        }
        BlockState state = calculateState(pLevel, pPos, pState);
        if (!state.equals(pState)) {
            pLevel.setBlockAndUpdate(pPos, pState);
        }
    }

    protected ConnectorType getConnectorType(BlockGetter pLevel, BlockPos pPos, Direction pDir) {
        BlockPos pos = pPos.relative(pDir);
        BlockState state = pLevel.getBlockState(pos);
        Block block = state.getBlock();
        return block instanceof AbstractConnector || canConnect(pLevel.getBlockEntity(pos)) ? ConnectorType.CABLE : ConnectorType.NONE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected abstract int getShapeIndex(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east,
                                         ConnectorType up, ConnectorType down);
    protected abstract int getTier();

    protected abstract boolean canConnect(BlockEntity pEntity);

    protected abstract VoxelShape makeShape(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down);

    public abstract void changeBlockState(BlockState state, Direction direction);
    public enum ConnectorType implements StringRepresentable {
        NONE,
        CABLE,
        BLOCK_IN,
        BLOCK_OUT,
        BLOCK; // used for pipes only

        public static final ConnectorType[] VALUES = values();

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }
    }
}
