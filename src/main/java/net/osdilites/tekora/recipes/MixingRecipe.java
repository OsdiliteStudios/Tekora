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
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;

import java.util.List;

public record MixingRecipe(List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, double cutTorque, double ratedVelocity) implements TekoraBasinRecipe {
    public static final MapCodec<MixingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(MixingRecipe::fluids),
            Ingredient.CODEC.listOf().fieldOf("items").forGetter(MixingRecipe::items),
            FluidStackTemplate.CODEC.fieldOf("fluid_output").forGetter(MixingRecipe::fluidOutput),
            ItemStackTemplate.CODEC.fieldOf("item_output").forGetter(MixingRecipe::itemOutput),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(MixingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(MixingRecipe::ratedVelocity)
    ).apply(inst, MixingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, MixingRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidIngredient.STREAM_CODEC.apply(ByteBufCodecs.list()), MixingRecipe::fluids,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), MixingRecipe::items,
            FluidStackTemplate.STREAM_CODEC, MixingRecipe::fluidOutput,
            ItemStackTemplate.STREAM_CODEC, MixingRecipe::itemOutput,
            ByteBufCodecs.DOUBLE, MixingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, MixingRecipe::ratedVelocity,
            MixingRecipe::new
    );

    @Override
    public ItemStack assemble(BasinRecipeInput input) {
        return itemOutput.create().copy();
    }

    @Override
    public String group() {
        return "Mixing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<BasinRecipeInput>> getSerializer() {
        return TekoraRecipes.MIXING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<BasinRecipeInput>> getType() {
        return TekoraRecipes.MIXING_TYPE.get();
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
