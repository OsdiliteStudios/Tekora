package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.DepotEntity;

public class DepotMenu extends TekoraItemMenu {
    public final DepotEntity blockEntity;

    public DepotMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ContainerData data) {
        super(TekoraMenus.DEPOT_MENU.get(), containerId, inventory, data);
        checkContainerSize(inventory, 2);
        this.blockEntity = (DepotEntity) blockEntity;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addSlot(new ResourceHandlerSlot(this.blockEntity.handler, this.blockEntity.handler::set, 0, 56, 35));
        addSlot(new ResourceHandlerSlot(this.blockEntity.handler, this.blockEntity.handler::set, 1, 116, 35));
    }

    public DepotMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(2));
    }

    @Override
    protected int teInventorySlotCount() {
        return 2;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, TekoraBlocks.DEPOT.get());
    }

    public int getProgress() {
        return blockEntity.getProgress();
    }
}
