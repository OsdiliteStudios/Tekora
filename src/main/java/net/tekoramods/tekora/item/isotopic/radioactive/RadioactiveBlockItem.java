package net.tekoramods.tekora.item.isotopic.radioactive;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.tekoramods.tekora.item.IRadioactiveItems;

public class RadioactiveBlockItem extends BlockItem implements IRadioactiveItems {
    private final float[] defaultIsotopeRatio;
    private final Class<? extends AbstractRadioactiveItem.Isotopes> elementType;
    public RadioactiveBlockItem(Block pBlock, float[] defaultIsotopeRatio, Class<? extends AbstractRadioactiveItem.Isotopes> elementType, boolean fireResist) {
        super(pBlock, fireResist ? new Item.Properties().fireResistant() : new Item.Properties());
        this.defaultIsotopeRatio = defaultIsotopeRatio;
        this.elementType = elementType;
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return 0;
    }

    public double getFissionRate(ItemStack pStack) {
        return 0;
    }
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return 0;
    }
    public float getFissionEnergy(ItemStack pStack) {
        return 0;
    }
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        return 0;
    }

    public float[] getDefaultIsotopeRatio() {
        return defaultIsotopeRatio;
    }
}
