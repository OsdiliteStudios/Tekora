package net.nukollodda.tekora.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.menu.CrusherMenu;

public class CrusherScreen extends AbstractContainerScreen<CrusherMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/crusher_gui.png");

    public CrusherScreen(CrusherMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
    }

    private void renderProgressArrow(GuiGraphics pGraphics, int x, int y) {
        if (menu.isCrafting()) {
            pGraphics.blit(TEXTURE, x + 70, y + 27, 176, 0, menu.getScaledProgress(), 17);
            // var 2 & 3 determines pos, var 4 && 5 determines rendered item pos, var 6 & 7 determines size of rendered item
        }
    }

    @Override
    public void render(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGraphics);
        super.render(pGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGraphics, pMouseX, pMouseY);
    }
}
