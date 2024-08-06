package net.leng.tekora.item.tools;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class TekoraShovelItem extends ShovelItem implements ITekoraColored {
    private final int color;

    public TekoraShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, boolean pFireRes, int pColor) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pFireRes ? new Properties().fireResistant() : new Properties());
        this.color = pColor;
    }

    public TekoraShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, int pColor) {
        this(pTier, pAttackDamageModifier, pAttackSpeedModifier, false, pColor);
    }

    @Override
    public int getColor() {
        return color;
    }
}
