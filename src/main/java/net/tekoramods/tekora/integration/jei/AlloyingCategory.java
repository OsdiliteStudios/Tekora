package net.tekoramods.tekora.integration.jei;

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
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.recipes.types.AlloyingRecipe;

public class AlloyingCategory implements IRecipeCategory<AlloyingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Tekora.MODID, "alloying");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/jei/alloying_furnace_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public AlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,114,50);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(TekoraBlocks.ALLOY_FURNACE.get()));
    }

    @Override
    public RecipeType<AlloyingRecipe> getRecipeType() {
        // todo
        return null; // will be changed
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tekora.alloy_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AlloyingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 9).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 15, 27).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 90, 9).addItemStack(recipe.getResultItem(null));
    }
}
