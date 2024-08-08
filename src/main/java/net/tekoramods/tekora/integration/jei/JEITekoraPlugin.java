package net.tekoramods.tekora.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.client.screens.CompressorScreen;
import net.tekoramods.tekora.client.screens.InfusionFurnaceScreen;
import net.tekoramods.tekora.client.screens.PulverizerScreen;
import net.tekoramods.tekora.recipes.types.CompressionRecipe;
import net.tekoramods.tekora.recipes.types.ExtrusionRecipe;
import net.tekoramods.tekora.recipes.types.InfusionRecipe;
import net.tekoramods.tekora.recipes.types.PulverizingRecipe;

@JeiPlugin
public class JEITekoraPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Tekora.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new InfusionCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CompressionCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ExtrusionCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new PulverizingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Level level = Minecraft.getInstance().level;
        if (level != null) {
            registration.addRecipes(InfusionCategory.TYPE, level.getRecipeManager().getAllRecipesFor(InfusionRecipe.Type.INSTANCE));
            registration.addRecipes(CompressionCategory.TYPE, level.getRecipeManager().getAllRecipesFor(CompressionRecipe.Type.INSTANCE));
            registration.addRecipes(ExtrusionCategory.TYPE, level.getRecipeManager().getAllRecipesFor(ExtrusionRecipe.Type.INSTANCE));
            registration.addRecipes(PulverizingCategory.TYPE, level.getRecipeManager().getAllRecipesFor(PulverizingRecipe.Type.INSTANCE));
        }
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(InfusionFurnaceScreen.class, 80, 30, 20, 30,
                InfusionCategory.TYPE);

        registration.addRecipeClickArea(CompressorScreen.class, 80, 30, 20, 30,
                CompressionCategory.TYPE);

        /*registration.addRecipeClickArea(CompressorScreen.class, 80, 30, 20, 30,
                ExtrusionCategory.TYPE);*/

        registration.addRecipeClickArea(PulverizerScreen.class, 80, 30, 20, 30,
                PulverizingCategory.TYPE);
    }
}
