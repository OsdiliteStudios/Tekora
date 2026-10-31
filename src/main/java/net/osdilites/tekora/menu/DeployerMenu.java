package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractDeployingMachineEntity;

public class DeployerMenu extends TekoraItemMenu {
    public final AbstractDeployingMachineEntity blockEntity;

    public DeployerMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ItemStacksResourceHandler handler, ContainerData data) {
        super(TekoraMenus.PRINTER_MENU.get(), containerId, inventory, data);
        this.blockEntity = (AbstractDeployingMachineEntity) blockEntity;

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 80, 32));

        addDataSlots(data);
    }

    public DeployerMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new ItemStacksResourceHandler(2), new SimpleContainerData(1));
    }

    @Override
    protected int teInventorySlotCount() {
        return 1;
    }

    // verify that client can actually access UI of checked blocks; auto-closed otherwise  
    @Override
    public boolean stillValid(Player player) {
        ContainerLevelAccess containerLevelAccess = ContainerLevelAccess.create(level, blockEntity.getBlockPos());
        return stillValid(containerLevelAccess, player, TekoraBlocks.PRINTER.get()) 
            || stillValid(containerLevelAccess, player, TekoraBlocks.APPLYER.get());
    }
}
