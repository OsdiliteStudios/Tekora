package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.BasinEntity;

public class BasinMenu extends TekoraItemMenu {
    public final BasinEntity blockEntity;

    public BasinMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ItemStacksResourceHandler handler) {
        super(TekoraMenus.BASIN_MENU.get(), containerId, inventory);
        this.blockEntity = (BasinEntity) blockEntity;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 51, 10));
        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 51, 54));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 96 + i * 18, 14 + j * 18));
            }
        }
    }

    public BasinMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new ItemStacksResourceHandler(11));
    }

    @Override
    protected int teInventorySlotCount() {
        return 11;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, TekoraBlocks.BASIN.get());
    }
}
