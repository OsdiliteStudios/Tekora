package net.leng.tekora.block.entity.blocks.storage;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.leng.tekora.block.entity.entities.storage.InfiniteBatteryEntity;
import org.jetbrains.annotations.Nullable;

public class InfiniteBattery extends Battery {
    public InfiniteBattery() {
        super();
    }

    @Override
    public InteractionResult use(BlockState state, Level lvl, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!lvl.isClientSide()) {
            BlockEntity entity = lvl.getBlockEntity(pos);
            if (entity instanceof InfiniteBatteryEntity furnaceEnt) {
                NetworkHooks.openScreen(((ServerPlayer) player), furnaceEnt, pos);
            } else {
                throw new IllegalStateException("Container Provider is missing");
            }
        }

        return InteractionResult.sidedSuccess(lvl.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new InfiniteBatteryEntity(pPos, pState);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        for (int i = 0; i < 4; i++) {
            int j = pRandom.nextInt(2) * 2 - 1;
            int k = pRandom.nextInt(2) * 2 - 1;
            double x0 = (double)pPos.getX() + 0.5D + 0.25D * (double)j;
            double y0 = ((float)pPos.getY() + pRandom.nextFloat());
            double z0 = (double)pPos.getZ() + 0.5D + 0.25D * (double)k;
            double dx = (pRandom.nextFloat() * (float)j);
            double dy = ((double)pRandom.nextFloat() - 0.5D) * 0.125D;
            double dz = (pRandom.nextFloat() * (float)k);
            pLevel.addParticle(ParticleTypes.PORTAL, x0, y0, z0, dx, dy, dz);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
                                                                  BlockEntityType<T> pType) {
        return pLevel.isClientSide() ? null : (lvl, pos, state, entity) -> ((InfiniteBatteryEntity)entity).tick();
    }
}
