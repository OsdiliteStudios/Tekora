package net.nukollodda.tekora.integration.jei;

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
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.recipes.types.CompressionRecipe;

public class CompressionCategory implements IRecipeCategory<CompressionRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tekora.MODID, "compression");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tekora.MODID, "textures/screens/jei/basic_gui.png");
    public static final RecipeType<CompressionRecipe> TYPE =
            new RecipeType<>(UID, CompressionRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public CompressionCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,114,30);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(TekoraBlocks.COMPRESSOR.get()));
    }

    @Override
    public RecipeType<CompressionRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tekora.compressor");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CompressionRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 14, 9).addIngredients(recipe.getRecipeItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 9).addItemStack(recipe.getResultItem(null));
    }
}
