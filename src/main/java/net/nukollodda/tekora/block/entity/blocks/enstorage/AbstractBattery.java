package net.nukollodda.tekora.block.entity.blocks.enstorage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractBattery extends BaseEntityBlock {
    protected AbstractBattery() {
        super(Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()
                .lightLevel((blockState) -> 5));
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
            return tieredItem.getTier().getLevel() >= 3;
        return false;
    }
}
