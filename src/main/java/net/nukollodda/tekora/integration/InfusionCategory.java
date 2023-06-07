package net.nukollodda.tekora.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.ModBlocks;
import net.nukollodda.tekora.recipes.InfusionRecipe;

public class InfusionCategory implements IRecipeCategory<InfusionRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Tekora.MODID, "infusion");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/jei/infusion_furnace_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public InfusionCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(ModBlocks.INFUSION_FURNACE.get()));
    }
    @Override
    public RecipeType<InfusionRecipe> getRecipeType() {
        return JEITekoraPlugin.INFUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Infusion Furnace");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, InfusionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 52, 26).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 26).addItemStack(recipe.getResultItem());
    }
}
