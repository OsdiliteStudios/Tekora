package net.nukollodda.tekora.recipes;

import com.google.gson.JsonElement;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nullable;

public class TekoraJsonIncorperator {
    public static Ingredient fromJson(@Nullable JsonElement pJson, boolean pCanBeEmpty) {
        return Ingredient.fromJson(pJson, pCanBeEmpty);
    }
}
