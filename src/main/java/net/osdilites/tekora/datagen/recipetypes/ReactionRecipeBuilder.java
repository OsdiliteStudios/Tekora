package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;

import java.util.List;

public class ReactionRecipeBuilder extends AbstractTekoraRecipeBuilder {
    private final List<Chemical> reactants;
    private final List<Chemical> products;
    private final Catalyst catalyst;
    private final FluidIngredient solvent;
    private final String id;
    private final double deltaEnthalpy;
    private final double deltaEntropy;
    private final double freqFactor;
    private final double activationEnergy;
    private final RecipeCategory category;

    protected ReactionRecipeBuilder(RecipeCategory category, String id, List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, FluidIngredient solvent, double deltaEnthalpy, double deltaEntropy, double freqFactor, double activationEnergy) {
        this.category = category;
        this.id = id;
        this.reactants = reactants;
        this.products = products;
        this.catalyst = catalyst;
        this.solvent = solvent;
        this.deltaEnthalpy = deltaEnthalpy;
        this.deltaEntropy = deltaEntropy;
        this.freqFactor = freqFactor;
        this.activationEnergy = activationEnergy;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(ItemStack.EMPTY);
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
    }
}
