package net.tekoramods.tekora.block.basic;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TekoraBaseBlock extends Block {
    public TekoraBaseBlock(float strength, Block material, SoundType sound) {
        super(BlockBehaviour.Properties.ofFullCopy(material).requiresCorrectToolForDrops()
             .strength(strength).sound(sound));
    }

    public TekoraBaseBlock(float strength, Block material) {
        this(strength, material, SoundType.METAL);
    }

    public TekoraBaseBlock(float strength) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL);
    }

    public TekoraBaseBlock() {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL);
    }
}
