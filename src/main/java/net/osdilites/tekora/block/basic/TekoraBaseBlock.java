package net.osdilites.tekora.block.basic;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.osdilites.tekora.Tekora;

public class TekoraBaseBlock extends Block {
    public TekoraBaseBlock(String pName, float strength, Block material, SoundType sound) {
        super(BlockBehaviour.Properties.ofFullCopy(material).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))).
                requiresCorrectToolForDrops().strength(strength).sound(sound));
    }

    public TekoraBaseBlock(String pName, float strength, Block material) {
        this(pName, strength, material, SoundType.METAL);
    }

    public TekoraBaseBlock(String pName, float strength) {
        this(pName, strength, Blocks.IRON_BLOCK, SoundType.METAL);
    }

    public TekoraBaseBlock(String pName) {
        this(pName, 5f, Blocks.IRON_BLOCK, SoundType.METAL);
    }
}
