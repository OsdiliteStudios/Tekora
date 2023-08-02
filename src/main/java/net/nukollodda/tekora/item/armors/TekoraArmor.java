package net.nukollodda.tekora.item.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

public class TekoraArmor extends ArmorItem {
    public TekoraArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot) {
        this(pMaterial, pSlot, new Item.Properties());
    }

    public TekoraArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot, Item.Properties properties) {
        super(pMaterial, pSlot, properties);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String layer = "1";
        if (slot == EquipmentSlot.LEGS) layer = "2";
        return "tekora:textures/models/armor/" + this.material.getName() + "_layer_" + layer + ".png";
    }
}
