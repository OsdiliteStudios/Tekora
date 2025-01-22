package net.tekoramods.tekora.block.entities.mechanical.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import org.jetbrains.annotations.Nullable;

public abstract class Cogwheel extends AbstractTekoraAxialBlock {
    private static final VoxelShape SHAPE = Shapes.join(
            Block.box(6, 0, 6, 10, 16, 10),
            Block.box(0, 7, 0, 16, 9, 16),
            (b1, b2) -> b1 || b2);

    private final boolean isMetal;

    protected Cogwheel(boolean isMetal) {
        super(Properties.ofFullCopy(isMetal ? Blocks.IRON_BLOCK : Blocks.OAK_WOOD).noOcclusion());
        this.isMetal = isMetal;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL; // TODO change to animated whenever possible
    }

    public boolean isMetal() {
        return isMetal;
    }

    public static class Wood extends Cogwheel {
        public static final MapCodec<Cogwheel> CODEC = simpleCodec(p -> new Wood());

        public Wood() {
            super(false);
        }

        @Override
        protected MapCodec<? extends BaseEntityBlock> codec() {
            return CODEC;
        }


        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
            return new CogwheelEntity.Wood(blockPos, blockState);
        }

        @Nullable
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
            return createTickerHelper(pType, TekoraBlockEntities.WOODEN_COGWHEEL.get(), (level, pos, state, block) -> block.tick(level, pos, state));
        }
    }
}
