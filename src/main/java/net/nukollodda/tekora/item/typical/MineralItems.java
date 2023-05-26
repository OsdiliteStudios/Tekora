package net.nukollodda.tekora.item.custom;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.ModCreativeModTab;

public class MineralItems extends Item {
    public MineralItems() {
        super(new Item.Properties().tab(ModCreativeModTab.TEKORA_MINERALS));
    }
}
