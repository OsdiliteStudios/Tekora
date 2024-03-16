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
import net.nukollodda.tekora.recipes.types.InfusionRecipe;

public class InfusionCategory implements IRecipeCategory<InfusionRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tekora.MODID, "infusion");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tekora.MODID, "textures/screens/jei/infusion_furnace_gui.png");
    public static final RecipeType<InfusionRecipe> TYPE =
            new RecipeType<>(UID, InfusionRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public InfusionCategory(IGuiHelper pHelper) {
        this.background = pHelper.createDrawable(TEXTURE, 0, 0, 114,30);
        this.icon = pHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(TekoraBlocks.INFUSION_FURNACE.get()));
    }

    @Override
    public RecipeType<InfusionRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tekora.infusion_furnace");
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
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 9).addIngredients(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 9).addIngredients(recipe.getCatalyst());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 90, 9).addItemStack(recipe.getResultItem(null));
    }
}
