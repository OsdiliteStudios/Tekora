package net.osdilites.tekora.block.entities.mechanical;

import org.jspecify.annotations.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.menu.DeployerMenu;

public class PrinterMechanicalEntity extends AbstractDeployingMachineEntity implements MenuProvider {
    public PrinterMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PRINTER.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0; // todo find value
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new DeployerMenu(i, inventory, this, this.handler, data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("blockfunc.tekora.printer");
    }
}
