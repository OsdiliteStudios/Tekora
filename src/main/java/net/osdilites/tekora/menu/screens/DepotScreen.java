package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.menu.DepotMenu;

public class DepotScreen extends AbstractContainerScreen<DepotMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/container/depot_gui.png");

    public DepotScreen(DepotMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }
}
