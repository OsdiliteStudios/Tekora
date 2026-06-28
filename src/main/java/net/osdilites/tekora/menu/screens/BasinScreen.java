package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.menu.BasinMenu;

public class BasinScreen extends AbstractContainerScreen<BasinMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/container/basin_gui.png");
    private static final Identifier PROCESS_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/sprites/container/basin/process.png");

    public BasinScreen(BasinMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }
}
