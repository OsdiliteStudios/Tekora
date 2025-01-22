package net.tekoramods.tekora.block.entities.mechanical.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import org.jetbrains.annotations.Nullable;

public abstract class Shaft extends AbstractTekoraAxialBlock {
    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 16, 10);

    public Shaft() {
        super(Properties.ofFullCopy(Blocks.IRON_BARS).noOcclusion());
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static class Steel extends Shaft {
        public static final MapCodec<Steel> CODEC = simpleCodec(p -> new Steel());

        @Override
        protected MapCodec<? extends BaseEntityBlock> codec() {
            return CODEC;
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new ShaftEntity.Steel(pPos, pState);
        }

        @Nullable
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
            return createTickerHelper(pType, TekoraBlockEntities.STEEL_SHAFT.get(), (level, pos, state, block) -> block.tick(level, pos, state));
        }
    }
}
