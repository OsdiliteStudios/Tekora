package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractCable extends AbstractConnector {
    protected static final VoxelShape CORE = Block.box(6, 6, 6, 8, 8, 8);

    protected static final VoxelShape EXT_HOR_X = Block.box(0, 6, 6, 16, 8, 8);
    protected static final VoxelShape EXT_VER = Block.box(6, 0, 6, 8, 16, 8);
    protected static final VoxelShape EXT_HOR_Z = Block.box(6, 6, 0, 8, 8, 16);

    protected static final VoxelShape HALF_POS_X = Block.box(6, 6, 6, 16, 8, 8);
    protected static final VoxelShape HALF_POS_Y = Block.box(6, 6, 6, 8, 16, 8);
    protected static final VoxelShape HALF_POS_Z = Block.box(6, 6, 6, 8, 8, 16);

    protected static final VoxelShape HALF_NEG_X = Block.box(0, 6, 6, 8, 8, 8);
    protected static final VoxelShape HALF_NEG_Y = Block.box(6, 0, 6, 8, 8, 8);
    protected static final VoxelShape HALF_NEG_Z = Block.box(6, 6, 0, 8, 8, 8);

    public AbstractCable(float strength, SoundType sound) {
        super(strength, sound);
    }

    public AbstractCable(float strength) {
        super(strength);
    }
    // function that altars appearance needed

}
