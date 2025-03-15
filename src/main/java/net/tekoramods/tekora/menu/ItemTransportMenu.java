package net.tekoramods.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entities.attachment.ItemInputEntity;
import net.tekoramods.tekora.block.entities.attachment.ItemOutputEntity;
import net.tekoramods.tekora.block.entities.attachment.ItemTransportEntity;

public class ItemTransportMenu extends TekoraItemMenu {
    private final ItemTransportEntity blockEntity;

    public ItemTransportMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ItemTransportMenu(int pContainerId, Inventory inv, BlockEntity blockEntity) {
        super(TekoraMenus.ITEM_TRANSPORT_MENU.get(), pContainerId, inv);
        this.blockEntity = (ItemTransportEntity)blockEntity;
        addSlot(new SlotItemHandler(this.blockEntity.getInventory(), 0, 80, 51));
    }

    @Override
    protected int teInventorySlotCount() {
        return 1;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (blockEntity instanceof ItemInputEntity)
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, TekoraBlocks.ITEM_INPUT_BLOCK.get());
        if (blockEntity instanceof ItemOutputEntity)
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, TekoraBlocks.ITEM_OUTPUT_BLOCK.get());
        return false;
    }
}
