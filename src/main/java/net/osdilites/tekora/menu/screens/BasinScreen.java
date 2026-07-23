package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.BasinEntity;
import net.osdilites.tekora.menu.BasinMenu;

public class BasinScreen extends AbstractContainerScreen<BasinMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/container/basin_gui.png");
    private static final Identifier PROCESS_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/sprites/container/basin/process.png");

    public BasinScreen(BasinMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
    }
}
