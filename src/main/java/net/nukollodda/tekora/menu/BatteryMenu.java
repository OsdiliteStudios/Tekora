package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.machines.AlloyFurnaceEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class BatteryMenu extends AbstractTekoraMenu {
    public final AlloyFurnaceEntity blockEnt;
    private final Level level;
    private final ContainerData data;

    public BatteryMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(5));
    }

    public BatteryMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.BATTERY_MENU.get(), id, 1);
        checkContainerSize(inv, 4);
        blockEnt = (AlloyFurnaceEntity) entity;
        this.level = inv.player.level();
        this.data = data;
    }

    public int getEnergy() {
        int energy = this.data.get(0);
        int maxEn = this.data.get(1);
        int enSize = 29;

        return maxEn != 0 && energy != 0 ? energy * enSize / maxEn : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()),
                pPlayer, TekoraBlocks.INFINITE_BATTERY.get());
    }
}
