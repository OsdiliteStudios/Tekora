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

public record ApplyingRecipe(Ingredient input, Ingredient deployed, ItemStackTemplate output, double cutTorque, double ratedVelocity, boolean isConsumed) implements TekoraMechanicalRecipe<DeployingRecipeInput>  {
    public static final MapCodec<ApplyingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(ApplyingRecipe::input),
            Ingredient.CODEC.fieldOf("deployed").forGetter(ApplyingRecipe::deployed),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(ApplyingRecipe::output),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(ApplyingRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(ApplyingRecipe::ratedVelocity),
            Codec.BOOL.fieldOf("consumed").forGetter(ApplyingRecipe::isConsumed)
    ).apply(inst, ApplyingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ApplyingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, ApplyingRecipe::input,
            Ingredient.CONTENTS_STREAM_CODEC, ApplyingRecipe::deployed,
            ItemStackTemplate.STREAM_CODEC, ApplyingRecipe::output,
            ByteBufCodecs.DOUBLE, ApplyingRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, ApplyingRecipe::ratedVelocity,
            ByteBufCodecs.BOOL, ApplyingRecipe::isConsumed,
            ApplyingRecipe::new
    );

    @Override
    public boolean matches(DeployingRecipeInput recipeInput, Level level) {
        return !level.isClientSide() && input().test(recipeInput.getItem(0)) && deployed.test(recipeInput.deployed());
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
        return "Applying";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DeployingRecipeInput>> getSerializer() {
        return TekoraRecipes.APPLYING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DeployingRecipeInput>> getType() {
        return TekoraRecipes.APPLYING_TYPE.get();
    }
}
