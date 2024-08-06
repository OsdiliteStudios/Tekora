package net.leng.tekora.item.typical;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.leng.tekora.block.TekoraBlocks;

public class WireItem extends RawItem {
    public WireItem(int color) {
        super(false, color);
    }

    public Item getCable() {
        return switch (getColor()) {
            case RawItem.ALUMINUM -> TekoraBlocks.ALUMINUM_CABLE.get().asItem();
            case RawItem.COPPER -> TekoraBlocks.COPPER_CABLE.get().asItem();
            case RawItem.CUPRONICKEL -> TekoraBlocks.CUPRONICKEL_CABLE.get().asItem();
            case RawItem.ELECTRUM -> TekoraBlocks.ELECTRUM_CABLE.get().asItem();
            case RawItem.GOLD -> TekoraBlocks.GOLD_CABLE.get().asItem();
            case RawItem.SILVER -> TekoraBlocks.SILVER_CABLE.get().asItem();
            case RawItem.TIN -> TekoraBlocks.TIN_CABLE.get().asItem();
            default -> Items.AIR;
        };
    }
}
