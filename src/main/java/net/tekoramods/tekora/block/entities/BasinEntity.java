package net.tekoramods.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BasinEntity extends BlockEntity {
    public BasinEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pState) {
        super(pType, pPos, pState);
    }

    // the crafting tick will depend on several boolean factors
}
