package net.nukollodda.tekora.item.tools;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class TekoraSwordItem extends SwordItem implements ITekoraColored {
    private final int color;

    public TekoraSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, boolean pFireRes, int pColor) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pFireRes ? new Properties().fireResistant() : new Properties());
        this.color = pColor;
    }

    public TekoraSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, int pColor) {
        this(pTier, pAttackDamageModifier, pAttackSpeedModifier, false, pColor);
    }

    @Override
    public int getColor() {
        return color;
    }
}
