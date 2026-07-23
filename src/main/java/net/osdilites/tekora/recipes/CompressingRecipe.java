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
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;

import java.util.List;

public record CompressingRecipe(List<FluidIngredient> fluids, List<Ingredient> items, FluidStack fluidOutput, ItemStack itemOutput, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<BasinRecipeInput> {
    public static final MapCodec<CompressingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(CompressingRecipe::fluids),
            Ingredient.CODEC.listOf().fieldOf("items").forGetter(CompressingRecipe::items),
            FluidStack.CODEC.fieldOf("fluid_output").forGetter(CompressingRecipe::fluidOutput),
            ItemStack.CODEC.fieldOf("item_output").forGetter(CompressingRecipe::itemOutput),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(CompressingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(CompressingRecipe::ratedVelocity)
    ).apply(inst, CompressingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CompressingRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidIngredient.STREAM_CODEC.apply(ByteBufCodecs.list()), CompressingRecipe::fluids,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), CompressingRecipe::items,
            FluidStack.STREAM_CODEC, CompressingRecipe::fluidOutput,
            ItemStack.STREAM_CODEC, CompressingRecipe::itemOutput,
            ByteBufCodecs.DOUBLE, CompressingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, CompressingRecipe::ratedVelocity,
            CompressingRecipe::new
    );

    @Override
    public boolean matches(BasinRecipeInput input, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(BasinRecipeInput input) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Compressing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<BasinRecipeInput>> getSerializer() {
        return TekoraRecipes.COMPRESSING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<BasinRecipeInput>> getType() {
        return TekoraRecipes.COMPRESSING_TYPE.get();
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
