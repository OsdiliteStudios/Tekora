package net.leng.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.leng.tekora.block.TekoraBlocks;
import net.leng.tekora.block.entity.entities.machines.AlloyFurnaceEntity;
import net.leng.tekora.menu.types.AbstractTekoraMenu;

public class AlloyFurnaceMenu extends AbstractTekoraMenu {
    public final AlloyFurnaceEntity blockEnt;

    public AlloyFurnaceMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(5));
    }

    public AlloyFurnaceMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.ALLOY_FURNACE_MENU.get(), inv, data, id, 5);
        this.blockEnt = (AlloyFurnaceEntity)entity;
        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 79, 53));
            this.addSlot(new SlotItemHandler(handler, 1, 52, 26));
            this.addSlot(new SlotItemHandler(handler, 2, 34, 26));
            this.addSlot(new SlotItemHandler(handler, 3, 43, 44));
            this.addSlot(new SlotItemHandler(handler, 4, 117, 26));
        });
        addDataSlots(data);
    }

    public boolean isCrafting() { // checks if the item exists in the block entity
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1); // max progress

        return maxProgress != 0 && progress != 0 ? progress * 26 / maxProgress : 0;
    }

    public int getFuelAmt() {
        int fuel = this.data.get(2);
        int maxFuel = this.data.get(3);
        int fuelSize = 14;

        return maxFuel != 0 && fuel != 0 ? fuel * fuelSize / maxFuel : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()),
                pPlayer, TekoraBlocks.ALLOY_FURNACE.get());
    }
}
