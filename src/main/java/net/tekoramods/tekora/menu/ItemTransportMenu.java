package net.tekoramods.tekora.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

public class ItemTransportMenu extends TekoraItemMenu {
    protected ItemTransportMenu(MenuType<?> pMenuType, int pContainerId, Inventory inv) {
        super(pMenuType, pContainerId, inv);
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
