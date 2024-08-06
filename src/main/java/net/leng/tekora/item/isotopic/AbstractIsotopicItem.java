package net.leng.tekora.item.isotopic;

import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.leng.tekora.item.typical.RawItem;

public abstract class AbstractIsotopicItem extends RawItem {
    public AbstractIsotopicItem(boolean fireRes, int color) {
        super(fireRes, color);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (!pStack.isEmpty()) {
            getShareTag(pStack);
        }
    }

    public float[] getIsotopicRatio(ItemStack pStack) {
        if (pStack.getTag() != null) {
            ListTag tag = pStack.getOrCreateTag().getList("isotopes", ListTag.TAG_FLOAT);
            float[] isotopeRatio = new float[5];
            for (int i = 0; i < tag.size(); i++) {
                isotopeRatio[i] = tag.getFloat(i);
            }
            return isotopeRatio;
        }
        float[] ratio = getDefaultIsotopeRatio();
        ListTag isotopeList = new ListTag();
        for (int i = 0; i < ratio.length; i++) {
            isotopeList.addTag(i, FloatTag.valueOf(ratio[i]));
        }
        pStack.getOrCreateTag().put("isotopes", isotopeList);
        return ratio;
    }

    public abstract double getFissionRate(ItemStack pStack);
    public abstract double getNeutronAbsorptionRate(ItemStack pStack);
    public abstract float getFissionEnergy(ItemStack pStack);
    public abstract float getNeutronAbsorptionEnergy(ItemStack pStack);

    public abstract float[] getDefaultIsotopeRatio();

    public interface Isotopes {
        int getId();
        double getFissionRate();
        double getNeutronAbsorptionRate();
        float getFissionEnergy();
        float getNeutronAbsorptionEnergy();
    }
}
