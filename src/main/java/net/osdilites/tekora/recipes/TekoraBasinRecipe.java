package net.osdilites.tekora.recipes;

import com.mojang.datafixers.util.Function6;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface TekoraBasinRecipe extends TekoraMechanicalRecipe<BasinRecipeInput> {
    List<Ingredient> items();
    List<FluidIngredient> fluids();
    FluidStackTemplate fluidOutput();
    ItemStackTemplate itemOutput();

    @Override
    default boolean matches(BasinRecipeInput basinRecipeInput, Level level) {
        Queue<Ingredient> ingredients = new LinkedList<>(items());
        LinkedList<ItemStack> items = new LinkedList<>(basinRecipeInput.itemInputs());
        while (!ingredients.isEmpty()) {
            Ingredient tested = ingredients.poll();
            if (tested != null) {
                int contInd = -1;
                for (int i = 0; i < items.size(); i++) {
                    ItemStack candidate = items.get(i);
                    if (tested.test(candidate)) {
                        contInd = i;
                        break;
                    }
                }
                if (contInd == -1) {
                    return false;
                } else {
                    items.remove(contInd);
                }
            }
        }

        Queue<FluidIngredient> fluidIngredients = new LinkedList<>(fluids());
        LinkedList<FluidStack> fluids = new LinkedList<>(basinRecipeInput.fluidInputs());
        while (!fluidIngredients.isEmpty()) {
            FluidIngredient tested = fluidIngredients.poll();
            if (tested != null) {
                int contInd = -1;
                for (int i = 0; i < fluids.size(); i++) {
                    FluidStack candidate = fluids.get(i);
                    if (tested.test(candidate)) {
                        contInd = i;
                        break;
                    }
                }
                if (contInd == -1) {
                    return false;
                } else {
                    fluids.remove(contInd);
                }
            }
        }
        return true;
    }

    @Override
    default boolean showNotification() {
        return true;
    }

    static <T extends TekoraBasinRecipe> MapCodec<T> createMapCodec(Function6<List<FluidIngredient>, List<Ingredient>, FluidStackTemplate, ItemStackTemplate, Double, Double, T> factory) {
        return RecordCodecBuilder.mapCodec(inst -> inst.group(
                FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(TekoraBasinRecipe::fluids),
                Ingredient.CODEC.listOf().fieldOf("items").forGetter(TekoraBasinRecipe::items),
                FluidStackTemplate.CODEC.fieldOf("fluid_output").forGetter(TekoraBasinRecipe::fluidOutput),
                ItemStackTemplate.CODEC.fieldOf("item_output").forGetter(TekoraBasinRecipe::itemOutput),
                Codec.DOUBLE.fieldOf("cut_torque").forGetter(TekoraBasinRecipe::cutTorque),
                Codec.DOUBLE.fieldOf("rated_velocity").forGetter(TekoraBasinRecipe::ratedVelocity)
        ).apply(inst, factory));
    }

    static <T extends TekoraBasinRecipe> StreamCodec<RegistryFriendlyByteBuf, T> createStreamCodec(Function6<List<FluidIngredient>, List<Ingredient>, FluidStackTemplate, ItemStackTemplate, Double, Double, T> factory) {
        return StreamCodec.composite(
                FluidIngredient.STREAM_CODEC.apply(ByteBufCodecs.list()), TekoraBasinRecipe::fluids,
                Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), TekoraBasinRecipe::items,
                FluidStackTemplate.STREAM_CODEC, TekoraBasinRecipe::fluidOutput,
                ItemStackTemplate.STREAM_CODEC, TekoraBasinRecipe::itemOutput,
                ByteBufCodecs.DOUBLE, TekoraBasinRecipe::cutTorque,
                ByteBufCodecs.DOUBLE, TekoraBasinRecipe::ratedVelocity,
                factory
        );
    }
}
