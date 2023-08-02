package net.nukollodda.tekora.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.nukollodda.tekora.block.entity.entities.AlloyFurnaceEntity;
import net.nukollodda.tekora.block.entity.entities.ModBlockEntities;
import net.nukollodda.tekora.block.entity.type.MachineBlocks;

public class AlloyFurnace extends MachineBlocks {
    public AlloyFurnace() {
        super(6f);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level lvl, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEnt = lvl.getBlockEntity(pos);
            if (blockEnt instanceof AlloyFurnaceEntity) {
                ((AlloyFurnaceEntity) blockEnt).drops(); // drops all the contents
            }
        }

        super.onRemove(state,lvl,pos,newState,isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level lvl, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!lvl.isClientSide()) {
            BlockEntity entity = lvl.getBlockEntity(pos);
            if (entity instanceof AlloyFurnaceEntity) {
                NetworkHooks.openScreen(((ServerPlayer) player), (AlloyFurnaceEntity) entity, pos);
            } else {
                throw new IllegalStateException("Container Provider is missing");
            }
        }

        return InteractionResult.sidedSuccess(lvl.isClientSide);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyFurnaceEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level lvl, BlockState state,
                                                                  BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.ALLOY_FURNACE.get(),
                AlloyFurnaceEntity::tick);
    }
}
