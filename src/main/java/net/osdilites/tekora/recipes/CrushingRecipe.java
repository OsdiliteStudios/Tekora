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

public record CrushingRecipe(Ingredient input, ItemStack output, double cutTorque, double ratedVelocity) implements TekoraDepotRecipe {
    public static final MapCodec<CrushingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(CrushingRecipe::input),
            ItemStack.CODEC.fieldOf("result").forGetter(CrushingRecipe::output),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(CrushingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(CrushingRecipe::ratedVelocity)
    ).apply(inst, CrushingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CrushingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, CrushingRecipe::input,
            ItemStack.STREAM_CODEC, CrushingRecipe::output,
            ByteBufCodecs.DOUBLE, CrushingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, CrushingRecipe::ratedVelocity,
            CrushingRecipe::new
    );

    @Override
    public ItemStack assemble(DepotRecipeInput recipeInput) {
        return null;
    }

    @Override
    public String group() {
        return "Crushing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DepotRecipeInput>> getSerializer() {
        return TekoraRecipes.CRUSHING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DepotRecipeInput>> getType() {
        return TekoraRecipes.CRUSHING_TYPE.get();
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
