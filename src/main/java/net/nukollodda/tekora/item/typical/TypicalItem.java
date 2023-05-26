package net.nukollodda.tekora.item.custom;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.ModCreativeModTab;

public class TypicalItem extends Item {
    public TypicalItem() {
        super(new Item.Properties().tab(ModCreativeModTab.TEKORA_ITEMS));
    }
}
