package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraElectricMenu;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class CompressorMenu extends AbstractTekoraElectricMenu {
    public final AbstractTekoraMachineEntity blockEnt;

    public CompressorMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public CompressorMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.COMPRESSOR_MENU.get(), inv, data, id, 2);
        this.blockEnt = (AbstractTekoraMachineEntity) entity;
        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> { // adds the slots themselves
            this.addSlot(new SlotItemHandler(handler, 0, 43, 26));
            this.addSlot(new SlotItemHandler(handler, 1, 117, 26));
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
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()), pPlayer, TekoraBlocks.COMPRESSOR.get());
    }
}
