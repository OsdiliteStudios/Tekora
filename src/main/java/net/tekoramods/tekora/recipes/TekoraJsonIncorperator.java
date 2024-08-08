package net.tekoramods.tekora.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nullable;

public class TekoraJsonIncorperator {
    public static int getCount(JsonObject pJson) {
        return pJson.has("count") ? pJson.get("count").getAsInt() : 1;
    }
}
