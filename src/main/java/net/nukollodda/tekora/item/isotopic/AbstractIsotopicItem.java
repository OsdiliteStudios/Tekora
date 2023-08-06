package net.nukollodda.tekora.item.isotopic;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.isotopic.radioactive.AbstractRadioactiveItem;

public abstract class AbstractIsotopicItem extends Item {
    protected float[] isotopicRatio;
    public AbstractIsotopicItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (!pStack.isEmpty()) {
            getShareTag(pStack);
        }
    }

    public void setIsotopicRatio(float[] pRatio) {
        isotopicRatio = pRatio;
    }

    public void saveData(CompoundTag pTag) {
    }
    public void readData(CompoundTag pTag) {
        isotopicRatio = new float[]{100f};
    }

    public abstract double getFissionRate();
    public abstract double getNeutronAbsorptionRate();
    public abstract float getFissionEnergy();
    public abstract float getNeutronAbsorptionEnergy();

    public abstract float[] getDefaultIsotopeRatio();

    public interface Isotopes {
        int getId();
        double getFissionRate();
        double getNeutronAbsorptionRate();
        float getFissionEnergy();
        float getNeutronAbsorptionEnergy();
    }
}
