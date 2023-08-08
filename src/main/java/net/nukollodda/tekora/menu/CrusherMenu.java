package net.nukollodda.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.entity.entities.machines.CrusherEntity;
import net.nukollodda.tekora.menu.types.AbstractTekoraMenu;

public class CrusherMenu extends AbstractTekoraMenu {
    public final CrusherEntity blockEnt;
    private final Level level;
    private final ContainerData data;

    public CrusherMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public CrusherMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(TekoraMenuTypes.CRUSHER_MENU.get(), id, 2);
        checkContainerSize(inv, 2);
        blockEnt = (CrusherEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEnt.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> { // adds the slots themselves
            this.addSlot(new SlotItemHandler(handler, 0, 43, 26));
            this.addSlot(new SlotItemHandler(handler, 1, 117, 26));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() { // checks if the item exists in the block entity
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1); // max progress
        int progressArrowSize = 33; // height of the arrow in pixels

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEnt.getBlockPos()),
                pPlayer, TekoraBlocks.CRUSHER.get());
    }
}
