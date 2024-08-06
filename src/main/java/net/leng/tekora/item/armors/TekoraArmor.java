package net.leng.tekora.item.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.leng.tekora.item.tools.ITekoraColored;
import org.jetbrains.annotations.Nullable;

public class TekoraArmor extends ArmorItem implements ITekoraColored {
    private final int color;
    public TekoraArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot, int color) {
        this(pMaterial, pSlot, new Item.Properties(), color);
    }

    public TekoraArmor(ArmorMaterial pMaterial, ArmorItem.Type pSlot, Item.Properties properties, int color) {
        super(pMaterial, pSlot, properties);
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String layer = "1";
        if (slot == EquipmentSlot.LEGS) layer = "2";
        return "tekora:textures/models/armor/" + this.material.getName() + "_layer_" + layer + ".png";
    }
}
