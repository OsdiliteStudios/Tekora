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

public class BasicBlock extends Block {
    public BasicBlock(float strength, Block material, SoundType sound) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
             .strength(strength).sound(sound));
    }

    public BasicBlock(float strength, Block material) {
        this(strength, material, SoundType.METAL);
    }

    public BasicBlock(float strength) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL);
    }

    public BasicBlock() {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL);
    }
}
