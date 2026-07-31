package net.osdilites.tekora.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface TekoraBasinRecipe extends TekoraMechanicalRecipe<BasinRecipeInput> {
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
        return false;
    }

    List<Ingredient> items();
    List<FluidIngredient> fluids();
}
