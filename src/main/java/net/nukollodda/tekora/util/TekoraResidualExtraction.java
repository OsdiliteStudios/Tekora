package net.nukollodda.tekora.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.item.mixtures.Residue;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.recipes.types.IResidueRecipes;

public class TekoraResidualExtraction {
    private static final String COUNT = "count";
    private static final String SYMBOL = "symbol";

    public static byte[] getCationsFromJson(JsonObject pJson) {
        byte[] cationList = new byte[IonicParts.CATION_SIZE];
        final String cation = "cations";
        if (pJson.has(cation)) {
            JsonArray cations = GsonHelper.getAsJsonArray(pJson, cation);
            for (int i = 0; i < cations.size(); i++) {
                JsonObject internalObj = cations.get(i).getAsJsonObject();
                byte count = 1;
                if (internalObj.has(COUNT)) {
                    count = GsonHelper.getAsByte(internalObj, COUNT);
                }
                if (internalObj.has(SYMBOL)) {
                    cationList[convertStringToCationIndex(internalObj.get(SYMBOL).getAsString())] = count;
                }
            }
        }
        return cationList;
    }

    public static byte[] getAnionsFromJson(JsonObject pJson) {
        byte[] anionList = new byte[IonicParts.ANION_SIZE];
        final String anion = "anions";
        if (pJson.has(anion)) {
            JsonArray anions = GsonHelper.getAsJsonArray(pJson, anion);
            for (int i = 0; i < anions.size(); i++) {
                JsonObject internalObj = anions.get(i).getAsJsonObject();
                byte count = 1;
                if (internalObj.has(COUNT)) {
                    count = GsonHelper.getAsByte(internalObj, COUNT);
                }
                if (internalObj.has(SYMBOL)) {
                    anionList[convertStringToAnionIndex(internalObj.get(SYMBOL).getAsString())] = count;
                }
            }
        }
        return anionList;
    }

    public static boolean areIonsMergeable(ItemStack pOriginal, IResidueRecipes pRecipe) {
        int totalCations = 0;
        int totalAnions = 0;
        if (pOriginal.getItem() instanceof Residue residue) {
            for (byte val : pRecipe.getCations()) {
                totalCations += val;
            }
            for (byte val : residue.getCationRatio(pOriginal)) {
                totalCations += val;
            }

            for (byte val : pRecipe.getAnions()) {
                totalAnions += val;
            }
            for (byte val : residue.getAnionRatio(pOriginal)) {
                totalAnions += val;
            }
        }
        return totalAnions < 24 && totalCations < 24;
    }

    public static ItemStack residualIonMerger(ItemStack pOriginal, IResidueRecipes pRecipe) {
        ItemStack residue = new ItemStack(TekoraItems.RESIDUE.get());
        if (pOriginal.getItem() instanceof Residue res) {
            residue = res.mergeIons(pOriginal, pRecipe.getCations(), pRecipe.getAnions());
            residue.setCount(pOriginal.getCount() + 1);
        }
        return residue;
    }

    public static boolean recipeHasIons(IResidueRecipes pRecipe) {
        return pRecipe.hasCations() && pRecipe.hasAnions();
    }

    public static int convertStringToCationIndex(String str) {
        for (IonicParts.Cations cation : IonicParts.Cations.values()) {
            if (cation.getSymbol().equals(str)) {
                return cation.ordinal();
            }
        }
        return -1;
    }
    public static int convertStringToAnionIndex(String str) {
        for (IonicParts.Anions anion : IonicParts.Anions.values()) {
            if (anion.getSymbol().equals(str)) {
                return anion.ordinal();
            }
        }
        return -1;
    }
    /* Electrolysis will utilize functions here more than likely
     * This will be utilized in solvent extraction recipes as well
     */


}
