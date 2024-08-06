package net.tekoramods.tekora.item.armors;

import net.minecraft.world.item.*;

public class HeatResArmor extends TekoraArmor {
    public HeatResArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot, int color) {
        super(pMaterial, pSlot,  new Item.Properties().fireResistant(), color);
    }
}
