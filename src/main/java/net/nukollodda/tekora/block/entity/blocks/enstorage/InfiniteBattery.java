package net.nukollodda.tekora.block.entity.blocks.enstorage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nukollodda.tekora.block.entity.entities.enstorage.InfiniteBatteryEntity;
import org.jetbrains.annotations.Nullable;

public class InfiniteBattery extends AbstractBattery {
    public InfiniteBattery() {
        super();
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new InfiniteBatteryEntity(pPos, pState);
    }
}
