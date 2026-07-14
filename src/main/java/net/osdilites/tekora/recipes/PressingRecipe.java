package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record PressingRecipe(Ingredient input, ItemStack output, double forcePerTick) implements Recipe<RecipeInput> {
    public static final MapCodec<PressingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(PressingRecipe::input),
            ItemStack.CODEC.fieldOf("result").forGetter(PressingRecipe::output),
            Codec.DOUBLE.fieldOf("force_tick").forGetter(PressingRecipe::forcePerTick)
    ).apply(inst, PressingRecipe::new));

    @Override
    public boolean matches(RecipeInput RecipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(RecipeInput RecipeInput) {
        return null;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Pressing";
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
