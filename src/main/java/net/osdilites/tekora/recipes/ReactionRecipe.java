package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public record ReactionRecipe(List<Chemical> reactants, List<Chemical> products, double reaction_const) implements Recipe<ReactionRecipeInput> {
    public static final MapCodec<ReactionRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Chemical.CODEC.listOf().fieldOf("reactants").forGetter(ReactionRecipe::reactants),
            Chemical.CODEC.listOf().fieldOf("products").forGetter(ReactionRecipe::products),
            // Codec.DOUBLE.fieldOf("d_enthalpy").forGetter(ReactionRecipe::reaction_const),
            // Codec.DOUBLE.fieldOf("d_entropy").forGetter(ReactionRecipe::reaction_const),
            Codec.DOUBLE.fieldOf("reaction_const").forGetter(ReactionRecipe::reaction_const)
    ).apply(inst, ReactionRecipe::new));

    // json structure
    // reactants (list)
    //  - name (string)
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // products (list)
    //  - name
    //  - coefficient (int) - optional, none means 1
    //  - rate order (int) - optional, none means 0
    // delta_enthalpy (float) - possibly replaced with a different system
    // delta_entropy (float) - possibly replaced with a different system
    // reaction_const (float)

    public static final StreamCodec<RegistryFriendlyByteBuf, ReactionRecipe> STREAM_CODEC = null; // todo, figure out what the hell to do here

    @Override
    public boolean matches(ReactionRecipeInput reactionRecipeInput, Level level) {
        if (!level.isClientSide()) {
            // todo, implement recipe
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
