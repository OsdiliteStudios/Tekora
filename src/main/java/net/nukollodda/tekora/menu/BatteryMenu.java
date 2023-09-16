package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.enstorage.BatteryEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class BatteryMenu extends AbstractTekoraMenu {
    public final BatteryEntity blockEnt;
    private final Level level;
    private final ContainerData data;

    public BatteryMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public BatteryMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.BATTERY_MENU.get(), id, 1);
        checkContainerSize(inv, 1);
        blockEnt = (BatteryEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 77, 53));
        });

        addDataSlots(data);
    }

    public int getEnergy() {
        int energy = this.data.get(0);
        int maxEn = this.data.get(1);

        return maxEn != 0 && energy != 0 ? energy * 48 / maxEn : 0;
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
