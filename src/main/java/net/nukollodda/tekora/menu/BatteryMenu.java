package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.storage.BatteryEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class BatteryMenu extends AbstractTekoraMenu {
    public final BatteryEntity blockEnt;

    public BatteryMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public BatteryMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.BATTERY_MENU.get(), inv, data, id, 1);
        this.blockEnt = (BatteryEntity) entity;
        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 77, 53));
        });

        addDataSlots(data);
    }

    public int getEnergy() {
        int electricity = this.data.get(2);
        int maxElectricity = this.data.get(3);

        return maxElectricity != 0 && electricity != 0 ? electricity * 48 / maxElectricity : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        Block[] batteries = {TekoraBlocks.INFINITE_BATTERY.get()};
        for (Block battery : batteries) {
            if (stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()), pPlayer, battery)) return true;
        }
        return false;
    }
}
