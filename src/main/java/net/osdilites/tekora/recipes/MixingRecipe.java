package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

import java.util.List;

public record MixingRecipe(List<FluidIngredient> fluids, List<Ingredient> items, FluidStack fluidOutput, ItemStack itemOutput, double forcePerTick) implements Recipe<RecipeInput> {
    public static final MapCodec<MixingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidIngredient.CODEC.listOf().fieldOf("fluids").forGetter(MixingRecipe::fluids),
            Ingredient.CODEC.listOf().fieldOf("items").forGetter(MixingRecipe::items),
            FluidStack.CODEC.fieldOf("fluid_output").forGetter(MixingRecipe::fluidOutput),
            ItemStack.CODEC.fieldOf("item_output").forGetter(MixingRecipe::itemOutput),
            Codec.DOUBLE.fieldOf("force_ticks").forGetter(MixingRecipe::forcePerTick)
    ).apply(inst, MixingRecipe::new));

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Mixing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return null;
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
