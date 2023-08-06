package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.item.RadioactiveItems;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;

public abstract class AbstractRadioactiveItem extends AbstractIsotopicItem implements RadioactiveItems {
    public AbstractRadioactiveItem(Properties pProperties) {
        super(pProperties);
    }

    public Item getAbsorbedItem() {
        return null;
    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{100};
    }

    public static String formatRad(double pRadVal) {
        if (pRadVal > 1000000) {
            return (int)(pRadVal / 1000000) + "Sv";
        } else if (pRadVal > 1000) {
            return (int)(pRadVal / 1000) + "mSv";
        } else if (pRadVal > 1) {
            return (int)(pRadVal) + "μSv";
        } else if (pRadVal > 0.001) {
            return (int)(pRadVal * 1000) + "nSv";
        } else if (pRadVal > 0.000001) {
            return (long)(pRadVal * 1000000) + "pSv";
        }
        return "0Sv";
    }

    protected static ChatFormatting radColor(double pRadVal) {
        if (pRadVal > 1000000) {
            return ChatFormatting.DARK_PURPLE;
        } else if (pRadVal > 1000) {
            return ChatFormatting.RED;
        } else if (pRadVal > 0.001) {
            return ChatFormatting.YELLOW;
        }
        return ChatFormatting.WHITE;
    }

    public interface Isotopes extends AbstractIsotopicItem.Isotopes {
        default Item getItem(int[] pRatio) {
            if (this instanceof Uranium.Isotopes) {
                return TekoraItems.URANIUM_INGOT.get();
            } else if (this instanceof Thorium.Isotopes) {
                return TekoraItems.THORIUM_INGOT.get();
            }

            return null;
        }
        double getRadiationVal();
        AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope();
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (getRadiation() > 0.001) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1500, 0, true, false, false));
            pTarget.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1500, 0, true, false, false));
        }
        if (getRadiation() > 1) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1350, 0, true, false, false));
            pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1350, 0, true, false, false));
        }
        if (getRadiation() > 1000) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0, true, false, false));
            pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1050, 0, true, false, false));
        }
        if (getRadiation() > 1000000) {
            pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 600, 0, true, false, false));
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    /* Basic Idea:
     * There should be nbt values stored using only percents and a key, ie the id
     * something akin to the size of the enum being the number of keys of the nbt value
     * the nbt should also be readable as to return numerous important values
     */
}
