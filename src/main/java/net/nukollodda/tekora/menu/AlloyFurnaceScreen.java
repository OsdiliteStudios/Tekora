package net.nukollodda.tekora.menu;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nukollodda.tekora.Tekora;

public class AlloyFurnaceScreen extends AbstractContainerScreen<AlloyFurnaceMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/alloy_furnace_gui.png");

    public AlloyFurnaceScreen(AlloyFurnaceMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics pGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight); // renders texture

        renderProgressArrow(pGraphics, x, y);
        renderFuelAmount(pGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics pGraphics, int x, int y) {
        if (menu.isCrafting()) {
            pGraphics.blit(TEXTURE, x + 79, y + 27, 176, 12, menu.getScaledProgress(), 17);
            // var 2 & 3 determines pos, var 4 && 5 determines rendered item pos, var 6 & 7 determines size of rendered item
        }
    }

    private void renderFuelAmount(GuiGraphics pGraphics, int x, int y) {
        pGraphics.blit(TEXTURE, x + 100, y + 55 + (14 - menu.getFuelAmt()), 176, 14 - menu.getFuelAmt(), 14, menu.getFuelAmt());
    }

    @Override
    public void render(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGraphics);
        super.render(pGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGraphics, pMouseX, pMouseY);
    }
}


