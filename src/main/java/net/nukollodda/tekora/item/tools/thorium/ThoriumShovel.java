package net.nukollodda.tekora.item.tools.thorium;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.nukollodda.tekora.item.IRadioactiveItems;
import net.nukollodda.tekora.item.isotopic.radioactive.Thorium;
import net.nukollodda.tekora.tiers.TekoraTiers;
import org.jetbrains.annotations.NotNull;

public class ThoriumShovel extends ShovelItem implements IRadioactiveItems {
    public ThoriumShovel() {
        super(TekoraTiers.THORIUM, 1.5f, -3.0f, new Item.Properties().fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pTarget, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 700, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.HUNGER, 900, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1000, 1, true, false, false));
        return true;
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return Thorium.Isotopes.TH232.getRadiationVal();
    }
}
