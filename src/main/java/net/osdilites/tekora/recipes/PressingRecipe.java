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
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public record PressingRecipe(Ingredient input, ItemStackTemplate output, double cutTorque, double ratedVelocity) implements TekoraDepotRecipe {
    public static final MapCodec<PressingRecipe> CODEC = TekoraDepotRecipe.createMapCodec(PressingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, PressingRecipe> STREAM_CODEC = TekoraDepotRecipe.createStreamCodec(PressingRecipe::new);

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
