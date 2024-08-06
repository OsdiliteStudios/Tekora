package net.leng.tekora.item.typical;

import net.minecraft.world.item.Item;

public class TekoraItem extends Item {
    public TekoraItem() {
        super(new Item.Properties());
    }

    public TekoraItem(boolean fireRes) {
        super(fireRes ? new Item.Properties().fireResistant() : new Item.Properties());
    }
}
