package net.nukollodda.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ExperienceBlock extends DropExperienceBlock {
    public ExperienceBlock(float strength, float destroyTime, Block material, SoundType sound, UniformInt uniform) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
                .strength(destroyTime, strength).sound(sound), uniform);
    }

    public ExperienceBlock(float strength, float destroyTime, Block material, SoundType sound) {
        this(strength, destroyTime, material, sound, UniformInt.of(1, 5));
    }

    public ExperienceBlock(float strength, float destroyTime, SoundType sound, UniformInt uniform) {
        this(strength, destroyTime, Blocks.STONE, sound, uniform);
    }

    public ExperienceBlock(float strength, float destroyTime, Block material, UniformInt uniform) {
        this(strength, destroyTime, material, SoundType.STONE, uniform);
    }
    public ExperienceBlock(float strength, float destroyTime, Block material) {
        this(strength, destroyTime, material, SoundType.STONE);
    }
    public ExperienceBlock(float strength, float destroyTime, SoundType sound) {
        this(strength, destroyTime, Blocks.STONE, sound);
    }

    public ExperienceBlock(float strength, float destroyTime, UniformInt uniform) {
        this(strength, destroyTime, Blocks.STONE, uniform);
    }

    public ExperienceBlock(float strength, float destroyTime) {
        this(strength, destroyTime, Blocks.STONE);
    }
}
