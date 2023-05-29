package net.nukollodda.tekora.menu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
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
    protected void renderBg(PoseStack stack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(stack, x, y, 0, 0, imageWidth, imageHeight); // renders texture

        renderProgressArrow(stack, x, y);
    }

    private void renderProgressArrow(PoseStack stack, int x, int y) {
        if (menu.isCrafting()) {
            blit(stack, x + 88, y + 35, 176, 14, menu.getScaledProgress(), 17);
            // var 2 & 3 determines pos, var 4 && 5 determines rendered item pos, var 6 & 7 determines size of rendered item
        }
    }

    @Override
    public void render(PoseStack stack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(stack);
        super.render(stack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(stack, pMouseX, pMouseY);
    }
}
