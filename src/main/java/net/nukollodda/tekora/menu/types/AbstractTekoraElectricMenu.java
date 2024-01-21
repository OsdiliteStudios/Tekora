package net.nukollodda.tekora.menu.types;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTekoraElectricMenu extends AbstractTekoraMenu {
    protected AbstractTekoraElectricMenu(@Nullable MenuType<?> pMenuType, Inventory pInv, ContainerData pData, int pContainerId, int pContainerSize) {
        super(pMenuType, pInv, pData, pContainerId, pContainerSize);
    }
    public abstract boolean isCrafting();
    public abstract int getScaledProgress();
    public abstract int getEnergy();
}
