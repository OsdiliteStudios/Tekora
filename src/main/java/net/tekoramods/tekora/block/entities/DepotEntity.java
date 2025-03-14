package net.tekoramods.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DepotEntity extends BlockEntity {
    public DepotEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pState) {
        super(pType, pPos, pState);
    }
}
