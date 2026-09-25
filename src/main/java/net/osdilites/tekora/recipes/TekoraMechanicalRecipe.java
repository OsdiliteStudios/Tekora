package net.osdilites.tekora.recipes;

import net.minecraft.world.item.crafting.*;

public interface TekoraMechanicalRecipe<T extends RecipeInput> extends TekoraGeneralRecipe<T> {
    String PRESS = "press";
    String MIXER = "mixer";
    String CUTTER = "cutter";
    String CRUSHER = "crusher";
    String PRINTER = "printer";
    String APPLYER = "applyer";
    String SPLITTER = "splitter"; // magnetic separation

    double cutTorque();
    double ratedVelocity();
}
