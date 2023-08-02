package net.nukollodda.tekora.block.entity.type;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

public abstract class IrregularModels extends MachineBlocks {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public IrregularModels(float strength, SoundType sound, int tier) {
        super(strength, sound, tier);
    }

    public IrregularModels(float strength, int tier) {
        super(strength, SoundType.STONE, tier);
    }

    public IrregularModels(float strength, SoundType sound) {
        super(strength, sound, 2);
    }

    public IrregularModels(float strength) {
        super(strength, 2);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
