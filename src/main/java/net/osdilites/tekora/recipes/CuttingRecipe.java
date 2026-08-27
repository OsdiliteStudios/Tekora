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

public record CuttingRecipe(Ingredient input, ItemStackTemplate output, double cutTorque, double ratedVelocity) implements TekoraDepotRecipe {
    public static final MapCodec<CuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(CuttingRecipe::input),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(CuttingRecipe::output),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(CuttingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(CuttingRecipe::ratedVelocity)
    ).apply(inst, CuttingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CuttingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, CuttingRecipe::input,
            ItemStackTemplate.STREAM_CODEC, CuttingRecipe::output,
            ByteBufCodecs.DOUBLE, CuttingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, CuttingRecipe::ratedVelocity,
            CuttingRecipe::new
    );

    @Override
    public String group() {
        return "Cutting";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DepotRecipeInput>> getSerializer() {
        return TekoraRecipes.CUTTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DepotRecipeInput>> getType() {
        return TekoraRecipes.CUTTING_TYPE.get();
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
