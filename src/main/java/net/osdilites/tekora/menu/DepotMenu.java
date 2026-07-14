package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.DepotEntity;

public class DepotMenu extends TekoraItemMenu {
    public final DepotEntity blockEntity;

    public DepotMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ItemStacksResourceHandler handler) {
        super(TekoraMenus.DEPOT_MENU.get(), containerId, inventory);
        this.blockEntity = (DepotEntity) blockEntity;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 55, 34));
        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 115, 34));
    }

    public DepotMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new ItemStacksResourceHandler(11));
    }

    @Override
    protected int teInventorySlotCount() {
        return 2;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, TekoraBlocks.DEPOT.get());
    }
}
