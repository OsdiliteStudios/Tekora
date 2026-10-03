package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;
import org.jspecify.annotations.NonNull;

import java.util.*;

public record ReactionRecipe(List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, FluidIngredient solvent, double deltaEnthalpy, double deltaEntropy, double arrheniusConst, double activationEnergy) implements TekoraGeneralRecipe<ReactionRecipeInput> {
    public static final MapCodec<ReactionRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Chemical.CODEC.listOf().fieldOf("reactants").forGetter(ReactionRecipe::reactants),
            Chemical.CODEC.listOf().fieldOf("products").forGetter(ReactionRecipe::products),
            Catalyst.CODEC.fieldOf("catalyst").forGetter(ReactionRecipe::catalyst),
            FluidIngredient.CODEC.fieldOf("solvent").forGetter(ReactionRecipe::solvent),
            Codec.DOUBLE.fieldOf("d_enthalpy").forGetter(ReactionRecipe::deltaEnthalpy), // J/mol
            Codec.DOUBLE.fieldOf("d_entropy").forGetter(ReactionRecipe::deltaEntropy), // J/mol K
            Codec.DOUBLE.fieldOf("arrhenius_const").forGetter(ReactionRecipe::arrheniusConst),
            Codec.DOUBLE.fieldOf("activation_energy").forGetter(ReactionRecipe::activationEnergy)
    ).apply(inst, ReactionRecipe::new));

    // JSON structure
    // reactants (list)
    //  - name (string)
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // products (list)
    //  - name
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // arrhenius_const (float)
    // activation_energy (float)

    public static final StreamCodec<RegistryFriendlyByteBuf, ReactionRecipe> STREAM_CODEC = StreamCodec.composite(
            Chemical.STREAM_CODEC.apply(ByteBufCodecs.list()), ReactionRecipe::reactants,
            Chemical.STREAM_CODEC.apply(ByteBufCodecs.list()), ReactionRecipe::products,
            Catalyst.STREAM_CODEC, ReactionRecipe::catalyst,
            FluidIngredient.STREAM_CODEC, ReactionRecipe::solvent,
            ByteBufCodecs.DOUBLE, ReactionRecipe::deltaEnthalpy,
            ByteBufCodecs.DOUBLE, ReactionRecipe::deltaEntropy,
            ByteBufCodecs.DOUBLE, ReactionRecipe::arrheniusConst,
            ByteBufCodecs.DOUBLE, ReactionRecipe::activationEnergy,
            ReactionRecipe::new
    );

    @Override
    public boolean matches(@NonNull ReactionRecipeInput input, Level level) {
        if (!level.isClientSide()) {
            double reqEnergy = activationEnergy;
            boolean hasAllOutput = true;
            boolean hasAllInput = true;
            double q = 1;

            Set<ChemicalIngredient> ingredients = input.inputs().keySet();
            for (Chemical chemical : reactants) {
                double c = chemical.coefficient();
                for (ChemicalIngredient ing : ingredients) {
                    if (ing.equals(chemical.chemical())) {
                        q *= Math.pow(input.inputs().get(ing), c);
                    } else {
                        hasAllInput = false;
                        q = 0;
                        break;
                    }
                }
            }
            for (Chemical chemical : products) {
                double c = chemical.coefficient();
                for (ChemicalIngredient ing : ingredients) {
                    if (ing.equals(chemical.chemical())) {
                        q /= Math.pow(input.inputs().get(ing), c);
                    } else {
                        hasAllOutput = false;
                        if (q == 0) return false;
                        else {
                            q = Double.POSITIVE_INFINITY;
                        }
                        break;
                    }
                }
            }


            if (hasAllOutput && !hasAllInput) {
                reqEnergy += deltaEnthalpy;
            }

            return reqEnergy <= input.availableEnergy();
        }
        return false;
    }

    @Override
    public ItemStack assemble(ReactionRecipeInput reactionRecipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Reaction";
    }

    @Override
    public RecipeSerializer<? extends Recipe<ReactionRecipeInput>> getSerializer() {
        return TekoraRecipes.REACTION_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ReactionRecipeInput>> getType() {
        return TekoraRecipes.REACTION_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public double getLnK(double temperature) {
        return (deltaEnthalpy - temperature * deltaEntropy) / (temperature * UtilFunctions.IDEAL_GAS_CONST);
    }
}