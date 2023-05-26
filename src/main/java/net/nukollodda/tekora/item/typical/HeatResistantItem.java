package net.nukollodda.tekora.item.custom;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.ModCreativeModTab;

public class HeatResistantItem extends Item {
    public HeatResistantItem() {
        super(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS).fireResistant());
    }
}
