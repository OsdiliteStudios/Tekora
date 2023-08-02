package net.nukollodda.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class TekoraDropExperienceBlock extends DropExperienceBlock {
    private final int tier;
    public TekoraDropExperienceBlock(float strength, float destroyTime, Block material, SoundType sound, UniformInt uniform, int tier) {
        super(BlockBehaviour.Properties.copy(material).requiresCorrectToolForDrops()
                .strength(destroyTime, strength).sound(sound), uniform);
        this.tier = tier;
    }

    public TekoraDropExperienceBlock(float strength, float destroyTime, Block material, SoundType sound, int tier) {
        this(strength, destroyTime, material, sound, UniformInt.of(1, 5), tier);
    }

    public TekoraDropExperienceBlock(float strength, float destroyTime, SoundType sound, UniformInt uniform, int tier) {
        this(strength, destroyTime, Blocks.STONE, sound, uniform, tier);
    }

    public TekoraDropExperienceBlock(float strength, float destroyTime, Block material, UniformInt uniform, int tier) {
        this(strength, destroyTime, material, SoundType.STONE, uniform, tier);
    }
    public TekoraDropExperienceBlock(float strength, float destroyTime, Block material, int tier) {
        this(strength, destroyTime, material, SoundType.STONE, tier);
    }
    public TekoraDropExperienceBlock(float strength, float destroyTime, SoundType sound, int tier) {
        this(strength, destroyTime, Blocks.STONE, sound, tier);
    }

    public TekoraDropExperienceBlock(float strength, float destroyTime, UniformInt uniform, int tier) {
        this(strength, destroyTime, Blocks.STONE, uniform, tier);
    }

    public TekoraDropExperienceBlock(float strength, float destroyTime, int tier) {
        this(strength, destroyTime, Blocks.STONE, tier);
    }

    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
            return tieredItem.getTier().getLevel() >= tier;
        return false;
    }
}
