package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public abstract class AbstractConnector extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
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

    public AbstractConnector(float strength, SoundType sound) {
        super(Properties.of().strength(strength).requiresCorrectToolForDrops().sound(sound).noOcclusion());
    }

    public AbstractConnector(float strength) {
        this(strength, SoundType.METAL);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
