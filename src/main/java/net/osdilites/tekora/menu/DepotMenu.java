package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.DepotEntity;

public class DepotMenu extends TekoraItemMenu {
    public final DepotEntity blockEntity;

    public DepotMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ItemStacksResourceHandler handler, ContainerData data) {
        super(TekoraMenus.DEPOT_MENU.get(), containerId, inventory, data);
        this.blockEntity = (DepotEntity) blockEntity;

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 56, 35));
        addSlot(new ResourceHandlerSlot(handler, handler::set, 1, 116, 35) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }
        });

        addDataSlots(data);
    }

    public DepotMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new ItemStacksResourceHandler(2), new SimpleContainerData(1));
    }

    @Override
    protected int teInventorySlotCount() {
        return 2;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, TekoraBlocks.DEPOT.get());
    }

    public float getProgress() {
        return blockEntity.getProgress();
    }
}
