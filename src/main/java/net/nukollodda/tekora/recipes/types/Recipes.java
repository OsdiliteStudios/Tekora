package net.nukollodda.tekora.recipes.types;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;

public abstract class Recipes implements Recipe<SimpleContainer> {
    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }
}
