package net.nukollodda.tekora.item.tools;

import net.minecraft.world.item.BowItem;

public class GunItem extends BowItem {
    public GunItem(int pDurability, float pDamage) {
        super(new Properties().durability(pDurability));
    }
}
