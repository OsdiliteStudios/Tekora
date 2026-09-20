package net.osdilites.tekora.menu.screens;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.fluids.FluidStack;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.menu.BasinMenu;
import net.osdilites.tekora.menu.infoboxes.FluidTankRenderer;

public class BasinScreen extends AbstractContainerScreen<BasinMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/container/basin_gui.png");
    private static final Identifier PROCESS_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/sprites/container/basin/process.png");
    private static final Identifier REACTION_TEXTURE = Identifier.fromNamespaceAndPath(Tekora.MODID, "textures/gui/sprites/container/basin/reaction.png");

    private FluidTankRenderer fluidRenderer;

    public BasinScreen(BasinMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        assignFluidRenderer();
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        fluidRenderer.render(graphics, x + 18, y + 24, menu.blockEntity.getFluid());
    }

    private void assignFluidRenderer() {
        fluidRenderer = new FluidTankRenderer(1000, true, 15, 44);
    }

    private void renderFluidTooltipArea(GuiGraphicsExtractor guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight())) {
            guiGraphics.setComponentTooltipForNextFrame(this.font, renderer.getTooltip(stack), pMouseX, pMouseY);
        }
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        super.extractLabels(graphics, xm, ym);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidTooltipArea(graphics, xm, ym, x, y, menu.blockEntity.getFluid(), 27, 18, fluidRenderer);
        // renderProcess(graphics, x, y);
    }

    private void renderProcess(GuiGraphicsExtractor guiGraphics, int x, int y) {
        // things to take into consideration
        // for most basin recipes, we can just use a basic up-down arrow to show progress
        // for reaction recipes, we will use this equation instead:
        // x = 12 * tanh((ln(Q) - ln(K)) / 4);
        // note: tanh is the hyperbolic tangent, Java should have this function in the default Math class
        int process = Mth.ceil(this.menu.getProgress() * 24.0f);
        guiGraphics.blit(
                RenderPipelines.GUI_TEXTURED, PROCESS_TEXTURE, x+80, y+34, 0, 0, process, 16, 24, 16);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y) {
        return isMouseOver(mouseX, mouseY, x, y, 16);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int size) {
        return isMouseOver(mouseX, mouseY, x, y, size, size);
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int sizeX, int sizeY) {
        return (mouseX >= x && mouseX <= x + sizeX) && (mouseY >= y && mouseY <= y + sizeY);
    }
}
