package net.osdilites.tekora.recipes;

import com.mojang.datafixers.util.Function4;
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
import net.minecraft.world.level.Level;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

public interface TekoraDepotRecipe extends TekoraMechanicalRecipe<DepotRecipeInput> {
    Ingredient input();
    ItemStackTemplate output();

    @Override
    default boolean matches(DepotRecipeInput recipeInput, Level level) {
        return !level.isClientSide() && input().test(recipeInput.getItem(0));
    }

    @Override
    default ItemStack assemble(DepotRecipeInput depotRecipeInput) {
        return output().create().copy();
    }

    default NonNullList<Ingredient> getIngredient() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input());
        return list;
    }

    @Override
    default boolean showNotification() {
        return true;
    }

    static <T extends TekoraDepotRecipe> MapCodec<T> createMapCodec(Function4<Ingredient, ItemStackTemplate, Double, Double, T> factory) {
        return RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(TekoraDepotRecipe::input),
                ItemStackTemplate.CODEC.fieldOf("result").forGetter(TekoraDepotRecipe::output),
                Codec.DOUBLE.fieldOf("cut_torque").forGetter(TekoraDepotRecipe::cutTorque),
                Codec.DOUBLE.fieldOf("rated_velocity").forGetter(TekoraDepotRecipe::ratedVelocity)
        ).apply(inst, factory));
    }

    static <T extends TekoraDepotRecipe> StreamCodec<RegistryFriendlyByteBuf, T> createStreamCodec(Function4<Ingredient, ItemStackTemplate, Double, Double, T> factory) {
        return StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, TekoraDepotRecipe::input,
                ItemStackTemplate.STREAM_CODEC, TekoraDepotRecipe::output,
                ByteBufCodecs.DOUBLE, TekoraDepotRecipe::cutTorque,
                ByteBufCodecs.DOUBLE, TekoraDepotRecipe::ratedVelocity,
                factory
        );
    }
}
