package net.nukollodda.tekora.item.tools.thorium;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.item.tools.RadioactiveTools;
import net.nukollodda.tekora.tiers.ModTiers;
import org.jetbrains.annotations.NotNull;

public class ThoriumAxe extends AxeItem implements RadioactiveTools {
    public ThoriumAxe() {
        super(ModTiers.THORIUM, 6.0f, -3.0f, new Item.Properties().fireResistant());
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
}
