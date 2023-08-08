package net.nukollodda.tekora.block.entity.blocks.connecters.cables;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nukollodda.tekora.block.entity.blocks.connecters.AbstractConnector;

public abstract class AbstractEnergyCable extends AbstractConnector {
    protected final int color;
    /*
     * all connectors in Tekora has multiple block states
     * they include
     * core: coreState
     * half_length: posX, posY, posZ, negX, negY, negZ
     * full_length: horX, ver, horZ
     * bent:
     * X plane - pZpY, nZpY, pZnY, nZnY
     * Y plane - pXpZ, nXpZ, pXnZ, nXnZ
     * Z plane - pXpY, nXpY, pXnY, nXnY
     *
     * there are thus a total of 22 total block-states here
     */

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
    // the box has x y z parameter, set 1 records smallest possible values, set 2 records largest possible values
    public AbstractEnergyCable(float strength, int color) {
        super(strength);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
