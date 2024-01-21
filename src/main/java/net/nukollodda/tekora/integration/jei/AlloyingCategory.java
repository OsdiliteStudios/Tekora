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
import net.nukollodda.tekora.recipes.types.AlloyingRecipe;

public class AlloyingCategory implements IRecipeCategory<AlloyingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Tekora.MODID, "alloying");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Tekora.MODID, "textures/screens/jei/alloying_furnace_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public AlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,85);
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
        return Component.literal("Alloying Furnace");
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
        builder.addSlot(RecipeIngredientRole.INPUT, 52, 26).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 44).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 26).addItemStack(recipe.getResultItem(null));

    }
}
