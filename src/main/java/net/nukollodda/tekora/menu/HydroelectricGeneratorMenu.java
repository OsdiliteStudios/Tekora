package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.generators.HydroelectricGeneratorEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class HydroelectricGeneratorMenu extends AbstractTekoraMenu {
    public final HydroelectricGeneratorEntity blockEnt;
    public HydroelectricGeneratorMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(0));
    }

    public HydroelectricGeneratorMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.HYDROELECTRIC_GENERATOR_MENU.get(), inv, data, id, 0);
        this.blockEnt = (HydroelectricGeneratorEntity) entity;
        addDataSlots(data);
    }

    public int getEnergy() {
        int energy = this.blockEnt.currentEnergy();
        int maxEn = this.blockEnt.maxEnergy();

        return maxEn != 0 && energy != 0 ? energy * 48 / maxEn : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()),
                pPlayer, TekoraBlocks.HYDROELECTRIC_GENERATOR.get());
    }
}
