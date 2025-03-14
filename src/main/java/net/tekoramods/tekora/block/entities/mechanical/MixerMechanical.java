package net.tekoramods.tekora.block.entities.mechanical;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.AbstractTekoraDirectionalBlock;
import org.jetbrains.annotations.Nullable;

public class MixerMechanical extends AbstractTekoraDirectionalBlock {
    public MixerMechanical() {
        super(Properties.ofFullCopy(Blocks.STONECUTTER));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MixerMechanicalEntity(null, blockPos, blockState);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }
}
