package net.tekoramods.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class FluidTransportMenu extends TekoraItemMenu {
    protected FluidTransportMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    protected FluidTransportMenu(int pContainerId, Inventory inv, BlockEntity blockEntity) {
        super(null, pContainerId, inv); // todo properly deal with this
        //this.blockEntity = (KilnFurnaceEntity)blockEntity;
        //addSlot(new SlotItemHandler(this.blockEntity.getInventory(), 0, 80, 35));
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    protected int teInventorySlotCount() {
        return 1;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
}
