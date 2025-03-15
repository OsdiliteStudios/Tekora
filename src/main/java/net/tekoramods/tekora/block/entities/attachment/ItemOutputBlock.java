package net.tekoramods.tekora.block.entities.attachment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.AbstractTekoraDirectionalBlock;
import org.jetbrains.annotations.Nullable;

public class ItemOutputBlock extends AbstractTekoraDirectionalBlock {
    public static final MapCodec<ItemOutputBlock> CODEC = simpleCodec(ItemOutputBlock::new);

    public ItemOutputBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ItemOutputEntity(pPos, pState);
    }
}
