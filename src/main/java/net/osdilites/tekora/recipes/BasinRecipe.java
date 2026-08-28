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
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public record BasinRecipe(List<FluidIngredient> fluids, List<Ingredient> items, FluidStackTemplate fluidOutput, ItemStackTemplate itemOutput, String machineType, double cutTorque, double ratedVelocity) implements TekoraMechanicalRecipe<BasinRecipeInput> {
    public static MapCodec<BasinRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(BasinRecipe::fluids),
            Ingredient.CODEC.listOf().fieldOf("items").forGetter(BasinRecipe::items),
            FluidStackTemplate.CODEC.fieldOf("fluid_output").forGetter(BasinRecipe::fluidOutput),
            ItemStackTemplate.CODEC.fieldOf("item_output").forGetter(BasinRecipe::itemOutput),
            Codec.STRING.fieldOf("machine_type").forGetter(BasinRecipe::machineType),
            Codec.DOUBLE.fieldOf("cut_torque").forGetter(BasinRecipe::cutTorque),
            Codec.DOUBLE.fieldOf("rated_velocity").forGetter(BasinRecipe::ratedVelocity)
    ).apply(inst, BasinRecipe::new));

    public static StreamCodec<RegistryFriendlyByteBuf, BasinRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidIngredient.STREAM_CODEC.apply(ByteBufCodecs.list()), BasinRecipe::fluids,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), BasinRecipe::items,
            FluidStackTemplate.STREAM_CODEC, BasinRecipe::fluidOutput,
            ItemStackTemplate.STREAM_CODEC, BasinRecipe::itemOutput,
            ByteBufCodecs.STRING_UTF8, BasinRecipe::machineType,
            ByteBufCodecs.DOUBLE, BasinRecipe::cutTorque,
            ByteBufCodecs.DOUBLE, BasinRecipe::ratedVelocity,
            BasinRecipe::new
    );

    @Override
    public boolean matches(BasinRecipeInput basinRecipeInput, Level level) {
        Queue<Ingredient> ingredients = new LinkedList<>(items());
        LinkedList<ItemStack> items = new LinkedList<>(basinRecipeInput.items());
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
        LinkedList<FluidStack> fluids = new LinkedList<>(basinRecipeInput.fluids());
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
    public ItemStack assemble(BasinRecipeInput basinRecipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "Basin";
    }

    @Override
    public RecipeSerializer<? extends Recipe<BasinRecipeInput>> getSerializer() {
        return TekoraRecipes.BASIN_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<BasinRecipeInput>> getType() {
        return TekoraRecipes.BASIN_TYPE.get();
    }
}
