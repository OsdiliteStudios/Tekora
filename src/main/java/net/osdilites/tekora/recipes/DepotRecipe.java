package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
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
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public record DepotRecipe(Ingredient input, ItemStackTemplate output, String machineType, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<DepotRecipeInput> {
    public static final MapCodec<DepotRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(DepotRecipe::input),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(DepotRecipe::output),
            Codec.STRING.fieldOf("machine_type").forGetter(DepotRecipe::machineType),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(DepotRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(DepotRecipe::ratedVelocity)
    ).apply(inst, DepotRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, DepotRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, DepotRecipe::input,
            ItemStackTemplate.STREAM_CODEC, DepotRecipe::output,
            ByteBufCodecs.STRING_UTF8, DepotRecipe::machineType,
            ByteBufCodecs.DOUBLE, DepotRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, DepotRecipe::ratedVelocity,
            DepotRecipe::new
    );

    @Override
    public boolean matches(DepotRecipeInput recipeInput, Level level) {
        return !level.isClientSide() && recipeInput.machineType().equals(machineType) && input().test(recipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(DepotRecipeInput depotRecipeInput) {
        return output().create().copy();
    }

    public NonNullList<Ingredient> getIngredient() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input());
        return list;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "Depot";
    }

    @Override
    public RecipeSerializer<? extends Recipe<DepotRecipeInput>> getSerializer() {
        return TekoraRecipes.DEPOT_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<DepotRecipeInput>> getType() {
        return TekoraRecipes.DEPOT_TYPE.get();
    }
}
