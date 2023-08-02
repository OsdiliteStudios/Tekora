package net.nukollodda.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class TekoraBlocks extends Block {
    private int tier;
    public TekoraBlocks(float strength, Block material, SoundType sound, int tier) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
             .strength(strength).sound(sound));
        this.tier = tier;
    }

    public TekoraBlocks(float strength, Block material, SoundType sound) {
        this(strength, material, sound, 2);
    }

    public TekoraBlocks(float strength, Block material) {
        this(strength, material, SoundType.METAL, 2);
    }

    public TekoraBlocks(float strength) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL, 2);
    }

    public TekoraBlocks() {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL, 2);
    }

    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
            return tieredItem.getTier().getLevel() >= tier;
        return false;
    }
}
