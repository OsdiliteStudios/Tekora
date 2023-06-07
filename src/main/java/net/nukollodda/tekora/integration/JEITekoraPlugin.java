package net.nukollodda.tekora.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.recipes.AlloyingRecipe;
import net.nukollodda.tekora.recipes.InfusionRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITekoraPlugin implements IModPlugin {
    public static RecipeType<InfusionRecipe> INFUSION_TYPE =
            new RecipeType<>(InfusionCategory.UID, InfusionRecipe.class);
    public static RecipeType<AlloyingRecipe> ALLOYING_TYPE =
            new RecipeType<>(AlloyingCategory.UID, AlloyingRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Tekora.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new InfusionCategory(registration.getJeiHelpers().getGuiHelper()),
                new AlloyingCategory(registration.getJeiHelpers().getGuiHelper())
        );

        // there'll be more in the list if there are more recipes
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<InfusionRecipe> recipesInfusing = rm.getAllRecipesFor(InfusionRecipe.Type.INSTANCE);
        List<AlloyingRecipe> recipesAlloying = rm.getAllRecipesFor(AlloyingRecipe.Type.INSTANCE);

        registration.addRecipes(INFUSION_TYPE, recipesInfusing); // if there are more recipes, it's added to here, expect 14 parts
        registration.addRecipes(ALLOYING_TYPE, recipesAlloying);
    }
}
