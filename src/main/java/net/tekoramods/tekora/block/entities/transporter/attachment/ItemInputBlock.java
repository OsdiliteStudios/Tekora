package net.tekoramods.tekora.block.entities.transporter.attachment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.AbstractTekoraDirectionalBlock;
import org.jetbrains.annotations.Nullable;

public class ItemInputBlock extends AbstractTekoraDirectionalBlock {
    protected ItemInputBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}
