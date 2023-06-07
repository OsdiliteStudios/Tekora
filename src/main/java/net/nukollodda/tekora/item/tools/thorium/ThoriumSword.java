package net.nukollodda.tekora.item.tools.thorium;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.nukollodda.tekora.item.tools.RadioactiveTools;
import net.nukollodda.tekora.tiers.ModTiers;
import org.jetbrains.annotations.NotNull;

public class ThoriumSword extends SwordItem implements RadioactiveTools {
    public ThoriumSword() {
        super(ModTiers.THORIUM, 3, -2.4f, new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pTarget, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 1200, 2, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 2100, 0, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.HUNGER, 2700, 2, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 3000, 2, true, false, false));
        pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3000, 2, true, false, false));
        return true;
    }
}
