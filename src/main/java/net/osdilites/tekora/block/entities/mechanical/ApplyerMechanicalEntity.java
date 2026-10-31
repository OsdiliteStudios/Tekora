package net.osdilites.tekora.block.entities.mechanical;

import org.jspecify.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.menu.DeployerMenu;

public class ApplyerMechanicalEntity extends AbstractDeployingMachineEntity {
    public ApplyerMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.APPLYER.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0;
    }

    @Override 
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new DeployerMenu(i, inventory, this, this.handler, data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("blockfunc.tekora.applyer");
    }
}
