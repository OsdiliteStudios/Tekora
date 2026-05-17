package net.osdilites.tekora.block.entities.thermal;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class KilnFurnace extends AbstractThermalMachine {
    public static final MapCodec<KilnFurnace> CODEC = simpleCodec(KilnFurnace::new);

    public KilnFurnace(Properties pProperties) {
        super(pProperties, "kiln_furnace");
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new KilnFurnaceEntity(blockPos, blockState);
    }

    @Override
    public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
        if (level.getBlockEntity(pos) instanceof KilnFurnaceEntity entity) {
            entity.drops();
            level.updateNeighborsAt(pos, this);
        }
        super.destroy(level, pos, state);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pLevel.getBlockEntity(pPos) instanceof KilnFurnaceEntity entity) {
            if (!pPlayer.isCrouching() && !pLevel.isClientSide()) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(entity, Component.translatable("block.tekora.kiln_furnace")), pPos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return super.getTicker(pLevel, pState, pBlockEntityType);
    }
}
