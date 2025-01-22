package net.tekoramods.tekora.menu.item;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

public abstract class TekoraMenu extends AbstractContainerMenu {
    // likely to have 5 inheritors: presser, printing press, miller, cutter, grinder
    protected TekoraMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }
}
