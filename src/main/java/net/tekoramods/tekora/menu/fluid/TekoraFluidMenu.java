package net.tekoramods.tekora.menu.fluid;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

public abstract class TekoraFluidMenu extends AbstractContainerMenu {
    // potential inheritor list(16 items):
    // mixer, centrifuge, kiln furnace(maybe), crucible(maybe done), boiler
    // extruder, froth floater, air compressor, stove(maybe), distillation chamber, tank, diffusion chamber, fluid chamber
    // electrolysis chamber, magnetic separator, cooler
    protected TekoraFluidMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }
}
