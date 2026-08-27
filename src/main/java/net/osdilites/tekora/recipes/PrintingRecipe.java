package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public record PrintingRecipe(Ingredient input, ItemStackTemplate output, double cutTorque, double ratedVelocity) implements TekoraDepotRecipe {
    public static final MapCodec<PrintingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(PrintingRecipe::input),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(PrintingRecipe::output),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(PrintingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(PrintingRecipe::ratedVelocity)
    ).apply(inst, PrintingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PrintingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, PrintingRecipe::input,
            ItemStackTemplate.STREAM_CODEC, PrintingRecipe::output,
            ByteBufCodecs.DOUBLE, PrintingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, PrintingRecipe::ratedVelocity,
            PrintingRecipe::new
    );

    @Override
    public ItemStack assemble(DepotRecipeInput RecipeInput) {
        return output.create().copy();
    }

    @Override
    public String group() {
        return "Printing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DepotRecipeInput>> getSerializer() {
        return TekoraRecipes.PRINTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DepotRecipeInput>> getType() {
        return TekoraRecipes.PRINTING_TYPE.get();
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
