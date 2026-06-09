package net.osdilites.tekora.block.basic;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.osdilites.tekora.Tekora;

public class TekoraExperienceBlock extends DropExperienceBlock {
    public TekoraExperienceBlock(String pName, float strength, float destroyTime, Block material, SoundType sound, int min, int max) {
        super(UniformInt.of(min, max), BlockBehaviour.Properties.ofFullCopy(material).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName)))
                .strength(destroyTime, strength).sound(sound));
    }

    public TekoraExperienceBlock(String pName, float strength, float destroyTime, Block material, SoundType sound) {
        this(pName, strength, destroyTime, material, sound, 1, 5);
    }

    public TekoraExperienceBlock(String pName, float strength, float destroyTime, SoundType sound, int min, int max) {
        this(pName, strength, destroyTime, Blocks.STONE, sound, min, max);
    }

    public TekoraExperienceBlock(String pName, float strength, float destroyTime, Block material, int min, int max) {
        this(pName, strength, destroyTime, material, SoundType.STONE, min, max);
    }
    public TekoraExperienceBlock(String pName, float strength, float destroyTime, Block material) {
        this(pName, strength, destroyTime, material, SoundType.STONE);
    }
    public TekoraExperienceBlock(String pName, float strength, float destroyTime, SoundType sound) {
        this(pName, strength, destroyTime, Blocks.STONE, sound);
    }

    public TekoraExperienceBlock(String pName, float strength, float destroyTime, int min, int max) {
        this(pName, strength, destroyTime, Blocks.STONE, min, max);
    }

    public TekoraExperienceBlock(String pName, float strength, float destroyTime) {
        this(pName, strength, destroyTime, Blocks.STONE);
    }
}
