package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.osdilites.tekora.recipes.inputs.DeployingRecipeInput;

public record PrintingRecipe(Ingredient input, ItemStackTemplate output, int exp, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<DeployingRecipeInput> {
    public static final MapCodec<PrintingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(PrintingRecipe::input),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(PrintingRecipe::output),
            Codec.INT.fieldOf("experience").forGetter(PrintingRecipe::exp),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(PrintingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(PrintingRecipe::ratedVelocity)
    ).apply(inst, PrintingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PrintingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, PrintingRecipe::input,
            ItemStackTemplate.STREAM_CODEC, PrintingRecipe::output,
            ByteBufCodecs.INT, PrintingRecipe::exp,
            ByteBufCodecs.DOUBLE, PrintingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, PrintingRecipe::ratedVelocity,
            PrintingRecipe::new
    );


    @Override
    public boolean matches(DeployingRecipeInput recipeInput, Level level) {
        return !level.isClientSide() && input().test(recipeInput.getItem(0)) && recipeInput.deployed().getItem().equals(output.item());
    }

    @Override
    public ItemStack assemble(DeployingRecipeInput recipeInput) {
        return output().create().copy();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "Deploying";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DeployingRecipeInput>> getSerializer() {
        return TekoraRecipes.PRINTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DeployingRecipeInput>> getType() {
        return TekoraRecipes.PRINTING_TYPE.get();
    }
}
