package net.leng.tekora.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.leng.tekora.Tekora;
import net.leng.tekora.item.TekoraItems;
import net.leng.tekora.item.mixtures.Residue;
import net.leng.tekora.item.typical.ICompounds;
import net.leng.tekora.item.typical.IonicParts;

public class DustUtil {
    public static boolean isResidueCategory(Item pItem) {
        return pItem.equals(TekoraItems.GENERIC_DUST.get()) || pItem.equals(TekoraItems.RESIDUE.get())
                || pItem instanceof ICompounds;
    }

    public static ItemStack createDustFromIons(int pCatInd, int pAnInd) {
        IonicParts.Cations cation = IonicParts.ALL_CATIONS[pCatInd];
        IonicParts.Anions anion = IonicParts.ALL_ANIONS[pAnInd];
        ItemStack specialDust = convertGenericDustToSpecialDust(cation, anion);
        if (!specialDust.isEmpty()) {
            return specialDust;
        }
        ItemStack dust = new ItemStack(TekoraItems.GENERIC_DUST.get());
        CompoundTag tag = dust.getOrCreateTag();
        tag.putString(Residue.CATION_KEY, cation.name());
        tag.putString(Residue.ANION_KEY, anion.name());
        dust.setTag(tag);
        return dust;
    }

    public static boolean canCreateDustFromIons(byte[] pCatInd, byte[] pAnInd) {
        int cationCount = 0;
        int anionCount = 0;
        for (byte val : pCatInd) {
            if (val > 0) {
                cationCount++;
            }
            if (cationCount > 1) {
                return false;
            }
        }
        for (byte val : pAnInd) {
            if (val > 0) {
                anionCount++;
            }
            if (anionCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static ItemStack convertGenericDustToSpecialDust(IonicParts.Cations pCation, IonicParts.Anions pAnion) {
        if (pAnion.equals(IonicParts.Anions.OXIDE)) {
            if (pCation.equals(IonicParts.Cations.SILICON)) {
                return new ItemStack(TekoraItems.SILICA.get());
            }
            if (pCation.equals(IonicParts.Cations.ALUMINUM)) {
                return new ItemStack(TekoraItems.ALUMINA.get());
            }
        } else if (pAnion.equals(IonicParts.Anions.CHLORIDE) && pCation.equals(IonicParts.Cations.SODIUM)) {
            return new ItemStack(TekoraItems.SALT.get());
        }
        String catName = pCation.name().toLowerCase();
        String anName = pAnion.name().toLowerCase();
        ResourceLocation loc = new ResourceLocation(Tekora.MODID, catName + "_" + anName);
        ResourceLocation prefixed = new ResourceLocation(Tekora.MODID,
                catName + "_" + UtilFunctions.addPrefix(anName, pCation.getOxidationState()));
        if (ForgeRegistries.ITEMS.containsKey(loc)) {
            Item item = ForgeRegistries.ITEMS.getValue(loc);
            if (item instanceof ICompounds) {
                return new ItemStack(item);
            }
        } else if (ForgeRegistries.ITEMS.containsKey(prefixed)) {
            Item item = ForgeRegistries.ITEMS.getValue(prefixed);
            if (item instanceof ICompounds) {
                return new ItemStack(item);
            }
        }
        return ItemStack.EMPTY;
    }
}
