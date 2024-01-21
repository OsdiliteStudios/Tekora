package net.nukollodda.tekora.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.menu.CompressorMenu;

public class CompressorScreen extends AbstractContainerScreen<CompressorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/compressor_gui.png");

    public CompressorScreen(CompressorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics pGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight); // renders texture

        renderProgressArrow(pGraphics, x, y);
        renderElectricityAmount(pGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics pGraphics, int x, int y) {
        if (menu.isCrafting()) {
            pGraphics.blit(TEXTURE, x + 75, y + 27, 176, 0, menu.getScaledProgress(), 17);
        }
    }

    private void renderElectricityAmount(GuiGraphics pGraphics, int x, int y) {
        pGraphics.blit(TEXTURE, x + 22, y + 22 + (48 - menu.getEnergy()), 176, 17 + (48 - menu.getEnergy()), 6, menu.getEnergy());
    }

    @Override
    public void render(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGraphics);
        super.render(pGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGraphics, pMouseX, pMouseY);
    }
}
