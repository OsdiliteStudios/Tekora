package net.nukollodda.tekora.block.entity.blocks.generators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nukollodda.tekora.block.entity.entities.generators.HydroelectricGeneratorEntity;
import org.jetbrains.annotations.Nullable;

public class HydroelectricGeneratorBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public HydroelectricGeneratorBlock() {
        super(Properties.copy(Blocks.IRON_BLOCK));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new HydroelectricGeneratorEntity(pPos, pState);
    }
}
