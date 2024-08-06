package net.leng.tekora.menu;

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
import net.leng.tekora.block.TekoraBlocks;
import net.leng.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import net.leng.tekora.menu.types.AbstractTekoraElectricMenu;

public class PulverizerMenu extends AbstractTekoraElectricMenu {
    public final AbstractTekoraMachineEntity blockEnt;

    public PulverizerMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public PulverizerMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.PULVERIZER_MENU.get(), inv, data, id, 3);
        this.blockEnt = (AbstractTekoraMachineEntity) entity;
        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 43, 26));
            this.addSlot(new SlotItemHandler(handler, 1, 114, 36));
            this.addSlot(new SlotItemHandler(handler, 2, 114, 18));
        });
        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1); // max progress

        return maxProgress != 0 && progress != 0 ? progress * 26 / maxProgress : 0;
    }

    public int getEnergy() {
        int electricity = this.data.get(2);
        int maxElectricity = this.data.get(3);

        return maxElectricity != 0 && electricity != 0 ? electricity * 48 / maxElectricity : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        Block[] machines = new Block[]{TekoraBlocks.PULVERIZER.get(), TekoraBlocks.CUTTER.get(), TekoraBlocks.EXTRUDER.get()}; // will be added on to
        for (Block machine : machines) {
            if (stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()), pPlayer, machine)) return true;
        }
        return false;
    }
}
