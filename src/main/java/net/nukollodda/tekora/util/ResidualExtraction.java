package net.nukollodda.tekora.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.item.mixtures.Residue;
import net.nukollodda.tekora.item.typical.ICompounds;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.recipes.types.IResidueRecipes;

public class ResidualExtraction {
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
                totalCations += val * pOriginal.getCount();
            }

            for (byte val : pRecipe.getAnions()) {
                totalAnions += val;
            }
            for (byte val : residue.getAnionRatio(pOriginal)) {
                totalAnions += val * pOriginal.getCount();
            }
            return totalAnions < 24 && totalCations < 24;
        }
        return false;
        // dust code work differently
    }

    public static ItemStack residualIonMerger(ItemStack pOriginal, IResidueRecipes pRecipe) {
        ItemStack residue = new ItemStack(TekoraItems.RESIDUE.get());
        if (pOriginal.getItem() instanceof Residue) {
            // idea for dust, since dusts will have a final value for cations/anions that value will be used instead for dusts
            CompoundTag orgTag = pOriginal.getOrCreateTag();
            byte count = (byte)pOriginal.getCount();
            return addToResidue(residue, pRecipe,
                    orgTag.getByteArray(Residue.CATION_KEY), orgTag.getByteArray(Residue.ANION_KEY), count);
        } else if (pOriginal.getItem() instanceof ICompounds compound) {
            if (compound.getCation().getIon() instanceof IonicParts.Cations cation &&
                    compound.getAnion().getIon() instanceof IonicParts.Anions anion) {
                byte[] orgCations = new byte[IonicParts.CATION_SIZE];
                byte[] orgAnions = new byte[IonicParts.ANION_SIZE];
                orgCations[cation.ordinal()]++;
                orgAnions[anion.ordinal()]++;
                if (UtilFunctions.arrayMatch(pRecipe.getCations(), orgCations) &&
                        UtilFunctions.arrayMatch(pRecipe.getAnions(), orgAnions)) {
                    pOriginal.setCount(pOriginal.getCount() + 1);
                    return pOriginal;
                } else {
                    byte count = (byte)pOriginal.getCount();
                    return addToResidue(residue, pRecipe, orgCations, orgAnions, count);
                }
            }
        }
        return pOriginal;
    }

    public static ItemStack addToResidue(ItemStack pResidue, IResidueRecipes pRecipe, byte[] pCations, byte[] pAnions, byte orgCount) {
        CompoundTag tag = pResidue.getOrCreateTag();
        byte[] cations = UtilFunctions.combineArrays(pCations, pRecipe.getCations(), orgCount);
        byte[] anions = UtilFunctions.combineArrays(pAnions, pRecipe.getAnions(), orgCount);
        tag.put(Residue.CATION_KEY, new ByteArrayTag(cations));
        tag.put(Residue.ANION_KEY, new ByteArrayTag(anions));
        pResidue.setTag(tag);
        pResidue.setCount(orgCount + 1);
        return pResidue;
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

    public static Item getDustFromIon(IonicParts.Ions pIon) {
        if (pIon instanceof IonicParts.Cations cation) {
            TagKey<Item> itemTag = ItemTags.create(new ResourceLocation("forge", "dusts/" + cation.name().toLowerCase()));
            Ingredient.TagValue items = new Ingredient.TagValue(itemTag);
            ItemStack tagItem = items.getItems().toArray(new ItemStack[0])[0];
            if (!tagItem.getItem().equals(Items.BARRIER)) {
                return tagItem.getItem();
            }
        } else if (pIon instanceof IonicParts.Anions anion) {
            return switch (anion) {
                case IODIDE -> TekoraItems.IODINE_DUST.get();
                case SULFIDE -> TekoraItems.SULFUR_DUST.get();
                case SELENIDE -> TekoraItems.SELENIUM_DUST.get();
                default -> Items.AIR;
            };
        }
        return Items.AIR;
    }
}
