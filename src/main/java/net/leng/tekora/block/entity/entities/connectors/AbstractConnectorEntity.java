package net.leng.tekora.block.entity.entities.connectors;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public abstract class AbstractConnectorEntity extends BlockEntity {
    protected Set<BlockPos> outputs = null;

    public AbstractConnectorEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public abstract void tick();

    public abstract void markDirty();
}
