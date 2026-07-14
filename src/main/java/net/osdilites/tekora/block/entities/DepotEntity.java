package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DepotEntity extends BlockEntity {
    public DepotEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.DEPOT.get(), pPos, pState);
    }
}
