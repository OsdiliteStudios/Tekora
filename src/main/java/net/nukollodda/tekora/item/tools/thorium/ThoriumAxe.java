package net.nukollodda.tekora.item.tools.thorium;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.item.IRadioactiveItems;
import net.nukollodda.tekora.item.isotopic.radioactive.Thorium;
import net.nukollodda.tekora.item.tools.TekoraAxeItem;
import net.nukollodda.tekora.item.typical.RawItem;
import net.nukollodda.tekora.tiers.TekoraTiers;
import org.jetbrains.annotations.NotNull;

public class ThoriumAxe extends TekoraAxeItem implements IRadioactiveItems {
    public ThoriumAxe() {
        super(TekoraTiers.THORIUM, 6.0f, -3.0f, true, RawItem.THORIUM);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pTarget, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 600, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1050, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1350, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1500, 1, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1500, 1, true, false, false));
        return true;
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return Thorium.Isotopes.TH232.getRadiationVal();
    }
}
