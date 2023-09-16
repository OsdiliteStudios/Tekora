package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Pipe extends AbstractConnector {

    protected static final VoxelShape CORE = Block.box(5, 5, 5, 9, 9, 9);

    protected static final VoxelShape EXT_HOR_X = Block.box(0, 5, 5, 16, 9, 9);
    protected static final VoxelShape EXT_VER = Block.box(5, 0, 5, 9, 16, 9);
    protected static final VoxelShape EXT_HOR_Z = Block.box(5, 5, 0, 9, 9, 16);

    protected static final VoxelShape HALF_POS_X = Block.box(5, 5, 5, 16, 9, 9);
    protected static final VoxelShape HALF_POS_Y = Block.box(5, 5, 5, 9, 16, 9);
    protected static final VoxelShape HALF_POS_Z = Block.box(5, 5, 5, 9, 9, 16);

    protected static final VoxelShape HALF_NEG_X = Block.box(0, 5, 5, 9, 9, 9);
    protected static final VoxelShape HALF_NEG_Y = Block.box(5, 0, 5, 9, 9, 9);
    protected static final VoxelShape HALF_NEG_Z = Block.box(5, 5, 0, 9, 9, 9);
    public Pipe(float strength, int color) {
        super(strength);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Override
    protected BlockState setDirExtensions(Level pLevel, BlockPos pPos, BlockState pState, BlockPos pNeighbor) {
        // deals with fluids instead here
        return pState;
    }
    /* Tekora Pipe list:
     * Glass - all fluids below 800K
     * Steel - noncorrosive fluids below 1300K
     * Bronze - all fluids below 1300K
     * mechanical - dusts
     */
}
