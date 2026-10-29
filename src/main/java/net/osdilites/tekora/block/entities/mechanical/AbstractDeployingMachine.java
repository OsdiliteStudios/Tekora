package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.osdilites.tekora.block.TekoraBlocks;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class AbstractDeployingMachine extends AbstractModularMachine {
    public AbstractDeployingMachine(Properties properties) {
        super(properties);
    }

    // Deployers can hold items inside!
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // return SUCCESS here so client doesn't attempt to place blocks instead of open menu 
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity entity = level.getBlockEntity(pos);

        Block block = level.getBlockState(entity.getBlockPos().below()).getBlock();
        // so that gears can still be placed on use (no shift required)
        if (!block.equals(TekoraBlocks.DEPOT.get())) {
            return InteractionResult.PASS;
        }

        if (entity instanceof AbstractDeployingMachineEntity deployer) {
            player.openMenu(new SimpleMenuProvider(deployer, deployer.getDisplayName()), pos);
        }
        
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AbstractDeployingMachineEntity deployer) {
            deployer.drops();
        }
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }
}
