package net.leng.tekora.menu;

import net.minecraft.world.inventory.Slot;
import net.leng.tekora.recipes.types.ItemFluidContainer;

public class FluidSlot extends Slot {
    public FluidSlot(ItemFluidContainer pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }
}
