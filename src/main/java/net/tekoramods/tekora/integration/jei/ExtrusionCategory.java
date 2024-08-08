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
import net.tekoramods.tekora.recipes.types.ExtrusionRecipe;

public class ExtrusionCategory implements IRecipeCategory<ExtrusionRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tekora.MODID, "extrusion");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tekora.MODID, "textures/screens/jei/basic_gui.png");
    public static final RecipeType<ExtrusionRecipe> TYPE =
            new RecipeType<>(UID, ExtrusionRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public ExtrusionCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,114,30);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(TekoraBlocks.EXTRUDER.get()));
    }

    @Override
    public RecipeType<ExtrusionRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tekora.extruder");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ExtrusionRecipe recipe, IFocusGroup group) {
        builder.addSlot(RecipeIngredientRole.INPUT, 14, 9).addIngredients(recipe.getRecipeItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 9).addItemStack(recipe.getResultItem(null));
    }
}
