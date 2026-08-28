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
import net.osdilites.tekora.recipes.ingredient.Catalyst;
import net.osdilites.tekora.recipes.ingredient.Chemical;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;

import java.util.HashSet;
import java.util.List;

public record ReactionRecipe(List<Chemical> reactants, List<Chemical> products, Catalyst catalyst, double deltaEnthalpy, double deltaEntropy, double arrheniusConst, double activationEnergy, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<ReactionRecipeInput> {
    public static final MapCodec<ReactionRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Chemical.CODEC.listOf().fieldOf("reactants").forGetter(ReactionRecipe::reactants),
            Chemical.CODEC.listOf().fieldOf("products").forGetter(ReactionRecipe::products),
            Catalyst.CODEC.fieldOf("catalyst").forGetter(ReactionRecipe::catalyst),
            Codec.DOUBLE.fieldOf("d_enthalpy").forGetter(ReactionRecipe::deltaEnthalpy),
            Codec.DOUBLE.fieldOf("d_entropy").forGetter(ReactionRecipe::deltaEntropy),
            Codec.DOUBLE.fieldOf("arrhenius_const").forGetter(ReactionRecipe::arrheniusConst),
            Codec.DOUBLE.fieldOf("activation_energy").forGetter(ReactionRecipe::activationEnergy),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(ReactionRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(ReactionRecipe::ratedVelocity)
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
            ByteBufCodecs.DOUBLE, ReactionRecipe::deltaEnthalpy,
            ByteBufCodecs.DOUBLE, ReactionRecipe::deltaEntropy,
            ByteBufCodecs.DOUBLE, ReactionRecipe::arrheniusConst,
            ByteBufCodecs.DOUBLE, ReactionRecipe::activationEnergy,
            ByteBufCodecs.DOUBLE, ReactionRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, ReactionRecipe::ratedVelocity,
            ReactionRecipe::new
    );

    @Override
    public boolean matches(ReactionRecipeInput reactionRecipeInput, Level level) {
        if (!level.isClientSide()) {
            double energyAvail = activationEnergy - (catalyst != null ? catalyst.energyRed() : 0);
            if (energyAvail < activationEnergy) {
                return false;
            }

            // for mixers in Tekora, the game will always attempt to put atmospheric gases into the inputs somehow in some way.
            // for kiln furnaces or sealed mixers, the situation is different.
            // mixers have an upper temperature limit of 800K while kiln furnaces have an upper limit of 2000K.

            double q_numerator = 1;
            double q_denominator = 1;

            for (Chemical c : reactants) {
                q_denominator *= Math.pow(c.chemical().getMol(), c.coefficient());
            }
            for (Chemical c : products) {
                q_numerator *= Math.pow(c.chemical().getMol(), c.coefficient());
            }

            double temperature = reactionRecipeInput.temperature();
            double k = Math.exp((temperature * deltaEntropy - deltaEnthalpy) / (temperature * UtilFunctions.IDEAL_GAS_CONST));
            double q = q_numerator / q_denominator;
            // todo, figure out the overall behavior (which may require statistical permutations)
//            return (k < q && new HashSet<>(reactionRecipeInput.reactants()).containsAll(reactants))
//                    || (q > k && new HashSet<>(reactionRecipeInput.products()).containsAll(products));
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
}