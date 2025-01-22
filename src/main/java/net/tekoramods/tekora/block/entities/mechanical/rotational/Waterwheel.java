package net.tekoramods.tekora.block.entities.mechanical.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.mechanical.machines.AbstractTekoraDirectionalBlock;
import org.jetbrains.annotations.Nullable;

public abstract class Waterwheel extends AbstractTekoraAxialBlock implements SimpleWaterloggedBlock {
    private final boolean isMetal;

    protected Waterwheel(boolean isMetal) {
        super(Properties.ofFullCopy(isMetal ? Blocks.IRON_BLOCK : Blocks.OAK_WOOD).noOcclusion());
        this.isMetal = isMetal;
    }

    public static class Wood extends Waterwheel {
        protected Wood() {
            super(false);
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
}
