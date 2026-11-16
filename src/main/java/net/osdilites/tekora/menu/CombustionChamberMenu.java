package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.thermal.CombustionChamberEntity;
import org.jspecify.annotations.NonNull;

public class CombustionChamberMenu extends TekoraItemMenu {
    public final CombustionChamberEntity blockEntity;
    public CombustionChamberMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(1));
    }

    public CombustionChamberMenu(int pContainerId, Inventory inv, BlockEntity blockEntity, ContainerData data) {
        super(TekoraMenus.COMBUSTION_CHAMBER_MENU.get(), pContainerId, inv, data);
        this.blockEntity = (CombustionChamberEntity)blockEntity;
        addSlot(new ResourceHandlerSlot(this.blockEntity.getInventory(), this.blockEntity.getInventory()::set, 0, 80, 42) {
            @Override
            public boolean mayPlace(@NonNull ItemStack stack) {
                if (stack.isEmpty()) {
                    return false;
                }
                return stack.getBurnTime(RecipeType.SMELTING, level.fuelValues()) > 0;
            }
        });
    }

    @Override
    protected int teInventorySlotCount() {
        return 1;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, TekoraBlocks.COMBUSTION_CHAMBER.get());
    }

    public float getBurnPercent() {
        return blockEntity.getBurnPercentage();
    }
}
