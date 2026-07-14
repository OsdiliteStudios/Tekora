package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record CuttingRecipe(Ingredient input, ItemStack output, double forcePerTick) implements Recipe<RecipeInput> {
    public static final MapCodec<CuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(CuttingRecipe::input),
            ItemStack.CODEC.fieldOf("result").forGetter(CuttingRecipe::output),
            Codec.DOUBLE.fieldOf("force_tick").forGetter(CuttingRecipe::forcePerTick)
    ).apply(inst, CuttingRecipe::new));

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
        return "Cutting";
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
        return RecipeBookCategories.CRAFTING_EQUIPMENT;
    }
}
