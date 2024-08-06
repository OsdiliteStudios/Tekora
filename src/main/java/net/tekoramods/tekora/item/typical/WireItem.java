package net.tekoramods.tekora.item.typical;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.tekoramods.tekora.block.TekoraBlocks;

public class WireItem extends RawItem {
    public WireItem(int color) {
        super(false, color);
    }

    public Item getCable() {
        return switch (getColor()) {
            case ALUMINUM -> TekoraBlocks.ALUMINUM_CABLE.get().asItem();
            case COPPER -> TekoraBlocks.COPPER_CABLE.get().asItem();
            case CUPRONICKEL -> TekoraBlocks.CUPRONICKEL_CABLE.get().asItem();
            case ELECTRUM -> TekoraBlocks.ELECTRUM_CABLE.get().asItem();
            case GOLD -> TekoraBlocks.GOLD_CABLE.get().asItem();
            case SILVER -> TekoraBlocks.SILVER_CABLE.get().asItem();
            case TIN -> TekoraBlocks.TIN_CABLE.get().asItem();
            default -> Items.AIR;
        };
    }
}
