package net.nukollodda.tekora.block.entity.blocks.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
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
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.entity.entities.machines.PulverizerEntity;
import org.jetbrains.annotations.Nullable;

public class Pulverizer extends AbstractElectricMachineBlock {
    public Pulverizer() {
        super(6f);
    }

    @Override
    public InteractionResult use(BlockState state, Level lvl, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!lvl.isClientSide()) {
            BlockEntity entity = lvl.getBlockEntity(pos);
            if (entity instanceof PulverizerEntity ent) {
                NetworkHooks.openScreen(((ServerPlayer) player), ent, pos);
            } else {
                throw new IllegalStateException("Container Provider is missing");
            }
        }
        return InteractionResult.sidedSuccess(lvl.isClientSide);
    }

    @Override
    public void onRemove(BlockState state, Level lvl, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEnt = lvl.getBlockEntity(pos);
            if (blockEnt instanceof PulverizerEntity ent) {
                ent.drops(); // drops all the contents
            }
        }

        super.onRemove(state,lvl,pos,newState,isMoving);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PulverizerEntity(pPos, pState); // should find a way to autogenerate recipes
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level lvl, BlockState state,
                                                                  BlockEntityType<T> type) {
        return createTickerHelper(type, TekoraBlockEntities.PULVERIZER.get(),
                PulverizerEntity::tick);
    }
}
