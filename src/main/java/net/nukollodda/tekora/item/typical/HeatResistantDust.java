package net.nukollodda.tekora.item.custom;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.ModCreativeModTab;

public class HeatResistantDust extends Item {
    public HeatResistantDust() {
        super(new Item.Properties().tab(ModCreativeModTab.TEKORA_DUSTS).fireResistant());
    }
}
