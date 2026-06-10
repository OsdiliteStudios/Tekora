package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.thermal.KilnFurnaceEntity;

public class KilnFurnaceMenu extends TekoraItemMenu {
    public final KilnFurnaceEntity blockEntity;

    // idea for design (fluid input, fluid output,
    public KilnFurnaceMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public KilnFurnaceMenu(int pContainerId, Inventory inv, BlockEntity blockEntity) {
        super(TekoraMenus.KILN_FURNACE_MENU.get(), pContainerId, inv);
        this.blockEntity = (KilnFurnaceEntity)blockEntity;
        //addSlot(new ResourceHandlerSlot(this.blockEntity.getInventory(), this.blockEntity.getInventory(), 0, 80, 52));
    }

    @Override
    protected int teInventorySlotCount() {
        return 1;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, TekoraBlocks.KILN_FURNACE.get());
    }
}
