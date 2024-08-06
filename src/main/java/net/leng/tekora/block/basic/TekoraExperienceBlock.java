package net.leng.tekora.block.basic;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TekoraExperienceBlock extends DropExperienceBlock {
    public TekoraExperienceBlock(float strength, float destroyTime, Block material, SoundType sound, int min, int max) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
                .strength(destroyTime, strength).sound(sound), UniformInt.of(min, max));
    }

    public TekoraExperienceBlock(float strength, float destroyTime, Block material, SoundType sound) {
        this(strength, destroyTime, material, sound, 1, 5);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, SoundType sound, int min, int max) {
        this(strength, destroyTime, Blocks.STONE, sound, min, max);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, Block material, int min, int max) {
        this(strength, destroyTime, material, SoundType.STONE, min, max);
    }
    public TekoraExperienceBlock(float strength, float destroyTime, Block material) {
        this(strength, destroyTime, material, SoundType.STONE);
    }
    public TekoraExperienceBlock(float strength, float destroyTime, SoundType sound) {
        this(strength, destroyTime, Blocks.STONE, sound);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, int min, int max) {
        this(strength, destroyTime, Blocks.STONE, min, max);
    }

    public TekoraExperienceBlock(float strength, float destroyTime) {
        this(strength, destroyTime, Blocks.STONE);
    }
}
