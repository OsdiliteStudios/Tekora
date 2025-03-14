package net.tekoramods.tekora.menu.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.menu.KilnFurnaceMenu;

public class KilnFurnaceScreen extends AbstractContainerScreen<KilnFurnaceMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "textures/gui/kiln_furnace_gui.png");

    public KilnFurnaceScreen(KilnFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }
}
