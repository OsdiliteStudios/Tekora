package net.nukollodda.tekora.item.armors;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class HeatResArmor extends TekoraArmor {
    public HeatResArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot) {
        super(pMaterial, pSlot,  new Item.Properties().fireResistant());
    }
}
