package net.tekoramods.tekora.menu;

import net.minecraft.world.inventory.Slot;
import net.tekoramods.tekora.recipes.types.ItemFluidContainer;

public class FluidSlot extends Slot {
    public FluidSlot(ItemFluidContainer pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }
}
