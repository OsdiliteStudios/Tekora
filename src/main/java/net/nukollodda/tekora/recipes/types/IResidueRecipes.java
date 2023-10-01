package net.nukollodda.tekora.recipes.types;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;

public interface IResidueRecipes extends Recipe<SimpleContainer> {
    byte[] getCations();
    byte[] getAnions();

    default boolean hasCations() {
        for (byte val : getCations()) {
            if (val != 0) {
                return true;
            }
        }
        return false;
    }

    default boolean hasAnions() {
        for (byte val : getAnions()) {
            if (val != 0) {
                return true;
            }
        }
        return false;
    }
    @Override
    default boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }
}
