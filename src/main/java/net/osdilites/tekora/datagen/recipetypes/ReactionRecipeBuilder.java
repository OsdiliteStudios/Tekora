package net.osdilites.tekora.datagen.recipetypes;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.recipes.ReactionRecipe;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;

import java.util.List;

public class ReactionRecipeBuilder extends AbstractTekoraRecipeBuilder {
    private final List<Chemical> reactants;
    private final List<Chemical> products;
    private final Catalyst catalyst;
    private final FluidIngredient solvent;
    private final int id;
    private final double deltaEnthalpy;
    private final double deltaEntropy;
    private final double freqFactor;
    private final double activationEnergy;

    private ReactionRecipeBuilder(int id, List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, FluidIngredient solvent, double deltaEnthalpy, double deltaEntropy, double freqFactor, double activationEnergy) {
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
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Tekora.MODID, "reaction_" + id));
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        ReactionRecipe recipe = new ReactionRecipe(reactants, products, catalyst, solvent, deltaEnthalpy, deltaEntropy, freqFactor, activationEnergy);
        recipeOutput.accept(resourceKey, recipe, null);
    }

    public static ReactionRecipeBuilder createReactionRecipe(int id, List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, FluidIngredient solvent, double deltaEnthalpy, double deltaEntropy, double freqFactor, double activationEnergy) {
        return new ReactionRecipeBuilder(id, reactants, products, catalyst, solvent, deltaEnthalpy, deltaEntropy, freqFactor, activationEnergy);
    }
}
