package net.tekoramods.tekora.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tekoramods.tekora.Tekora;

public abstract class TekoraItemMenu extends AbstractContainerMenu {
    // potential inheritor list(16 items):
    // mixer, centrifuge, kiln furnace(maybe), crucible(maybe done), boiler
    // extruder, froth floater, air compressor, stove(maybe), distillation chamber, tank, diffusion chamber, fluid chamber
    // electrolysis chamber, magnetic separator, cooler
    protected final Level level;

    protected TekoraItemMenu(MenuType<?> pMenuType, int pContainerId, Inventory inv) {
        super(pMenuType, pContainerId);
        level = inv.player.level();
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();
        if (pIndex < 36) {
            if (!moveItemStackTo(sourceStack, 36, 36 + teInventorySlotCount(), false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < 36 + teInventorySlotCount()) {
            if (!moveItemStackTo(sourceStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            Tekora.LOGGER.debug("Invalid slotIndex: " + pIndex);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(pPlayer, sourceStack);
        return copyOfSourceStack;
    }

    private void addPlayerInventory(Inventory inv) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(inv, i, 8 + i * 18, 142));
        }
    }

    protected abstract int teInventorySlotCount();
}
