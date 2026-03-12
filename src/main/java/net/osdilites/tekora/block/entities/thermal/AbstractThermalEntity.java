package net.osdilites.tekora.block.entities.thermal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntity;

public abstract class AbstractThermalEntity extends TekoraBlockEntity {

    public AbstractThermalEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }
}
