package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.menu.StoveFurnaceMenu;

public class StoveFurnaceScreen extends AbstractContainerScreen<StoveFurnaceMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/container/stove_furnace_gui.png");
    private static final Identifier LIT_PROGRESS = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/sprites/container/stove_furnace/lit_progress.png");

    public StoveFurnaceScreen(StoveFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = 72;
        titleLabelY = 12;

        inventoryLabelX = 10000;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderProcess(graphics, x, y);
    }

    private void renderProcess(GuiGraphicsExtractor guiGraphics, int x, int y) {
        float percentage = this.menu.getBurnPercent();
        int process = Mth.ceil(percentage * 14.0f);
        // todo, fix rendering
        guiGraphics.blit(
                RenderPipelines.GUI_TEXTURED, LIT_PROGRESS, x+81, y+40-process, 0, 14-process, 14, process, 14, 14);
    }
}
