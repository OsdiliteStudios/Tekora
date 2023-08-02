package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.ModItems;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;

public abstract class AbstractRadioactiveItem extends AbstractIsotopicItem {
    private int[] isotopicRatio;
    public AbstractRadioactiveItem(Properties pProperties) {
        super(pProperties);
    }

    public void setIsotopicRatio(int[] pRatio) {
        isotopicRatio = pRatio;
    }

    public Item getAbsorbedItem() {
        return null;
    }

    public abstract void saveData(CompoundTag pTag);
    public abstract void readData();

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{100};
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        // needs to cause things within a vicinity to be radioactive
    }
    public abstract double getRadiation();

    public interface Isotopes extends AbstractIsotopicItem.Isotopes {
        default Item getItem(int[] pRatio) {
            if (this instanceof Uranium.Isotopes) {
                return ModItems.URANIUM_INGOT.get();
            } else if (this instanceof Thorium.Isotopes) {
                return ModItems.THORIUM_INGOT.get();
            }

            return null;
        }
        double getRadiationVal();
        AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope();
    }
    /* Basic Idea:
     * There should be nbt values stored using only percents and a key, ie the id
     * something akin to the size of the enum being the number of keys of the nbt value
     * the nbt should also be readable as to return numerous important values
     */
}
