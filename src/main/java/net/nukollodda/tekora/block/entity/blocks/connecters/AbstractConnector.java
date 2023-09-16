package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public abstract class AbstractConnector extends BaseEntityBlock {
    public static final IntegerProperty EXTENSIONS = IntegerProperty.create("extensions", 0, 63);
    // there is a potential for a second block state that pertains to in and outs

    /* Binary integer representation of @var EXTENSIONS
     * first digit (2^5 - 32) = posX
     * second digit (2^4 - 16) = posY
     * third digit (2^3 - 8) = posZ
     * fourth digit (2^2 - 4) = negX
     * fifth digit (2^1 - 2) = negY
     * sixth digit (2^0 - 1) = negZ
     */

    public AbstractConnector(float strength, SoundType sound) {
        super(Properties.of().strength(strength).requiresCorrectToolForDrops().sound(sound).noOcclusion());
    }

    public AbstractConnector(float strength) {
        this(strength, SoundType.METAL);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EXTENSIONS);
    }

    protected abstract BlockState setDirExtensions(Level pLevel, BlockPos pPos, BlockState pState, BlockPos pNeighbor);

    public BlockState setDirExtensions(Level pLevel, BlockPos pPos, BlockState pState) {
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x+1, y, z));
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x, y+1, z));
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x, y, z+1));
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x-1, y, z));
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x, y-1, z));
        pState = setDirExtensions(pLevel, pPos, pState, new BlockPos(x, y, z-1));
        return pState;
    }

    @Override
    public void onNeighborChange(BlockState pState, LevelReader pLevel, BlockPos pPos, BlockPos pNeighbor) {
        if (pLevel instanceof Level level) {
            pState = setDirExtensions(level, pPos, pState, pNeighbor);
        }
        super.onNeighborChange(pState, pLevel, pPos, pNeighbor);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        pState = setDirExtensions(pLevel, pPos, pState);
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }

    public int getExtensions(BlockState pState) {
        return pState.getValue(EXTENSIONS);
    }

    public IntegerProperty getExtensionProperty() {
        return EXTENSIONS;
    }

    public int getMaxExtensions() {
        return 63;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
