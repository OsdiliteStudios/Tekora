package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.menu.KilnFurnaceMenu;

public class KilnFurnaceScreen extends AbstractContainerScreen<KilnFurnaceMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/kiln_furnace_gui.png");

    public KilnFurnaceScreen(KilnFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
    }
}
