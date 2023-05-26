package net.nukollodda.tekora.block.entity.type;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class Basic extends Block {
    public Basic() {
        super(Properties.of(Material.STONE)
                .strength(0.6f).requiresCorrectToolForDrops().noOcclusion());
    }
    /*
     * list of classes for blockentities
     *
     * block (directory block/entity)
     * block entity (directory block/entity/entities)
     * menu (directory menu/menus)
     * recipes (directory recipes)
     *
     * goal of each object
     * block - allows for the block implemented to be used
     * blockentity - allows for the storage of nbt value and determines behavior of the block
     * menu - allows the block to have a visual form upon right-clicking
     * recipes - allows custom recipes for the blockentity
     */
}
