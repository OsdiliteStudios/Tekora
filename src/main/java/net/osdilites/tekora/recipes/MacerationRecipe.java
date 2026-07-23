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

public record MacerationRecipe(List<FluidIngredient> fluids, List<Ingredient> items, FluidStack fluidOutput, ItemStack itemOutput, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<BasinRecipeInput> {
    public static final MapCodec<MacerationRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(MacerationRecipe::fluids),
            Ingredient.CODEC.listOf().fieldOf("items").forGetter(MacerationRecipe::items),
            FluidStack.CODEC.fieldOf("fluid_output").forGetter(MacerationRecipe::fluidOutput),
            ItemStack.CODEC.fieldOf("item_output").forGetter(MacerationRecipe::itemOutput),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(MacerationRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(MacerationRecipe::ratedVelocity)
    ).apply(inst, MacerationRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, MacerationRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidIngredient.STREAM_CODEC.apply(ByteBufCodecs.list()), MacerationRecipe::fluids,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), MacerationRecipe::items,
            FluidStack.STREAM_CODEC, MacerationRecipe::fluidOutput,
            ItemStack.STREAM_CODEC, MacerationRecipe::itemOutput,
            ByteBufCodecs.DOUBLE, MacerationRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, MacerationRecipe::ratedVelocity,
            MacerationRecipe::new
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
        return "Maceration";
    }

    @Override
    public RecipeSerializer<? extends Recipe<BasinRecipeInput>> getSerializer() {
        return TekoraRecipes.MACERATION_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<BasinRecipeInput>> getType() {
        return TekoraRecipes.MACERATION_TYPE.get();
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
