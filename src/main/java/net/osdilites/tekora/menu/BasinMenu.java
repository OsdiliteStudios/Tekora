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
import net.osdilites.tekora.block.entities.BasinEntity;

public class BasinMenu extends TekoraItemMenu {
    public final BasinEntity blockEntity;

    public BasinMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ContainerData data) {
        super(TekoraMenus.BASIN_MENU.get(), containerId, inventory, data);
        checkContainerSize(inventory, 11);
        this.blockEntity = (BasinEntity) blockEntity;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addSlot(new ResourceHandlerSlot(this.blockEntity.handler, this.blockEntity.handler::set, 0, 52, 11));
        addSlot(new ResourceHandlerSlot(this.blockEntity.handler, this.blockEntity.handler::set, 1, 52, 55));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addSlot(new ResourceHandlerSlot(this.blockEntity.handler, this.blockEntity.handler::set, i * 3 + j + 2, 97 + i * 18, 15 + j * 18));
            }
        }

        addDataSlots(this.data);
    }

    public BasinMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(11));
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
