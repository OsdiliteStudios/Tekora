package net.leng.tekora.item.tools;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class TekoraAxeItem extends AxeItem implements ITekoraColored {
    private final int color;
    public TekoraAxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, boolean pFireRes, int pColor) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pFireRes ? new Properties().fireResistant() : new Properties());
        this.color = pColor;
    }
    public TekoraAxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, int pColor) {
        this(pTier, pAttackDamageModifier, pAttackSpeedModifier, false, pColor);
    }

    @Override
    public int getColor() {
        return color;
    }
}
