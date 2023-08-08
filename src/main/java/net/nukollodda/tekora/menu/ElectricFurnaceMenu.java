package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.machines.ElectricFurnaceEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class ElectricFurnaceMenu extends AbstractTekoraMenu {
    public final ElectricFurnaceEntity blockEnt;
    private final Level level;
    private final ContainerData data;

    public ElectricFurnaceMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public ElectricFurnaceMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.ELECTRIC_FURNACE_MENU.get(), id, 3);
        checkContainerSize(inv, 3);
        blockEnt = (ElectricFurnaceEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> { // adds the slots themselves
            this.addSlot(new SlotItemHandler(handler, 0, 77, 53));
            this.addSlot(new SlotItemHandler(handler, 1, 56, 26));
            this.addSlot(new SlotItemHandler(handler, 2, 115, 26));
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

    public int getElectricityAmt() {
        int electricity = this.data.get(2);
        int maxElectricity = this.data.get(3);

        return maxElectricity != 0 && electricity != 0 ? electricity * 38 / maxElectricity : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()),
                pPlayer, TekoraBlocks.ELECTRIC_FURNACE.get());
    }
}
