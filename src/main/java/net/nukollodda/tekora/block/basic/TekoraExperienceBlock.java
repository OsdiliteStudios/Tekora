package net.nukollodda.tekora.block.basic;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TekoraExperienceBlock extends DropExperienceBlock {
    public TekoraExperienceBlock(float strength, float destroyTime, Block material, SoundType sound, UniformInt uniform) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
                .strength(destroyTime, strength).sound(sound), uniform);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, Block material, SoundType sound) {
        this(strength, destroyTime, material, sound, UniformInt.of(1, 5));
    }

    public TekoraExperienceBlock(float strength, float destroyTime, SoundType sound, UniformInt uniform) {
        this(strength, destroyTime, Blocks.STONE, sound, uniform);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, Block material, UniformInt uniform) {
        this(strength, destroyTime, material, SoundType.STONE, uniform);
    }
    public TekoraExperienceBlock(float strength, float destroyTime, Block material) {
        this(strength, destroyTime, material, SoundType.STONE);
    }
    public TekoraExperienceBlock(float strength, float destroyTime, SoundType sound) {
        this(strength, destroyTime, Blocks.STONE, sound);
    }

    public TekoraExperienceBlock(float strength, float destroyTime, UniformInt uniform) {
        this(strength, destroyTime, Blocks.STONE, uniform);
    }

    public TekoraExperienceBlock(float strength, float destroyTime) {
        this(strength, destroyTime, Blocks.STONE);
    }
}
