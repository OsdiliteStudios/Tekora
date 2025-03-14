package net.tekoramods.tekora.block.entities.transporter.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import org.jetbrains.annotations.Nullable;

public abstract class Waterwheel extends AbstractTekoraAxialBlock {
    private static final VoxelShape SHAPE_X = Shapes.join(
            box(0, 6, 6, 16, 10, 10),
            box(4, 0, 0, 12, 16, 16),
            (b1, b2) -> b1 || b2);
    private static final VoxelShape SHAPE_Y = Shapes.join(
            box(6, 0, 6, 10, 16, 10),
            box(0, 4, 0, 16, 12, 16),
            (b1, b2) -> b1 || b2);
    private static final VoxelShape SHAPE_Z = Shapes.join(
            box(6, 6, 0, 10, 10, 16),
            box(0, 0, 4, 16, 16, 12),
            (b1, b2) -> b1 || b2);

    protected Waterwheel(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.hasProperty(AXIS)) {
            Direction.Axis axis = pState.getValue(AXIS);
            return switch (axis) {
                case X -> SHAPE_X;
                case Y -> SHAPE_Y;
                case Z -> SHAPE_Z;
            };
        }
        return SHAPE_Y;
    }

    public static class Wood extends Waterwheel {
        public static final MapCodec<Wood> CODEC = simpleCodec(p -> new Wood());

        public Wood() {
            super(Properties.ofFullCopy(Blocks.OAK_WOOD).noOcclusion());
        }

        @Override
        protected MapCodec<? extends BaseEntityBlock> codec() {
            return CODEC;
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new WaterwheelEntity.Wood(pPos, pState);
        }

        @Nullable
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
            return createTickerHelper(pType, TekoraBlockEntities.WOODEN_WATERWHEEL.get(), (level, pos, state, block) -> block.tick(level, pos, state));
        }
    }
}
