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
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public record PressingRecipe(Ingredient input, ItemStack output, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<DepotRecipeInput> {
    public static final MapCodec<PressingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(PressingRecipe::input),
            ItemStack.CODEC.fieldOf("result").forGetter(PressingRecipe::output),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(PressingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(PressingRecipe::ratedVelocity)
    ).apply(inst, PressingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PressingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, PressingRecipe::input,
            ItemStack.STREAM_CODEC, PressingRecipe::output,
            ByteBufCodecs.DOUBLE, PressingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, PressingRecipe::ratedVelocity,
            PressingRecipe::new
    );

    @Override
    public boolean matches(DepotRecipeInput RecipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(DepotRecipeInput RecipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Pressing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DepotRecipeInput>> getSerializer() {
        return TekoraRecipes.PRESSING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DepotRecipeInput>> getType() {
        return TekoraRecipes.PRESSING_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_EQUIPMENT;
    }
}
