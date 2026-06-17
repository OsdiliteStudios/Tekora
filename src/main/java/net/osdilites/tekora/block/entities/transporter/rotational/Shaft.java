package net.osdilites.tekora.block.entities.transporter.rotational;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import org.jetbrains.annotations.Nullable;

public class Shaft extends AbstractTekoraAxialBlock {
    public static final MapCodec<Shaft> CODEC = simpleCodec(Shaft::new);

    private static final VoxelShape SHAPE_X = box(0, 6, 6, 16, 10, 10);
    private static final VoxelShape SHAPE_Y = box(6, 0, 6, 10, 16, 10);
    private static final VoxelShape SHAPE_Z = box(6, 6, 0, 10, 10, 16);

    private Shaft(Properties properties) {
        super(properties);
    }

    public Shaft(String pName) {
        this(Properties.ofFullCopy(Blocks.IRON_BARS).setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tekora.MODID, pName))));
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

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @org.jspecify.annotations.Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ShaftEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return createTickerHelper(pType, TekoraBlockEntities.SHAFT.get(), (level, pos, state, block) -> block.tick(level, pos, state));
    }
}
