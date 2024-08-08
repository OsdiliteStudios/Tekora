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
import net.tekoramods.tekora.recipes.types.PulverizingRecipe;

public class PulverizingCategory implements IRecipeCategory<PulverizingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tekora.MODID, "pulverization");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tekora.MODID, "textures/screens/jei/pulverizer_gui.png");
    public static final RecipeType<PulverizingRecipe> TYPE =
            new RecipeType<>(UID, PulverizingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public PulverizingCategory(IGuiHelper pHelper) {
        this.background = pHelper.createDrawable(TEXTURE, 0, 0, 114,40);
        this.icon = pHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(TekoraBlocks.PULVERIZER.get()));
    }

    @Override
    public RecipeType<PulverizingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tekora.pulverizer");
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
    public void setRecipe(IRecipeLayoutBuilder builder, PulverizingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 14, 9).addIngredients(recipe.getRecipeItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 2).addItemStack(recipe.getResultItem(null));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 20).addItemStack(recipe.getResidue());
    }
}
