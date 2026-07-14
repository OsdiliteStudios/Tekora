package net.osdilites.tekora.block.entities.thermal;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.menu.KilnFurnaceMenu;
import org.jetbrains.annotations.Nullable;

public class KilnFurnaceEntity extends AbstractThermalEntity {
    private final ItemStacksResourceHandler inventory = new ItemStacksResourceHandler(1) {
    };

    public KilnFurnaceEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.KILN_FURNACE.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.kiln_furnace");
    }

    public ItemStacksResourceHandler getInventory() {
        return inventory;
    }

    public void clearContents() {
        inventory.set(0, ItemResource.of(Items.AIR), 1);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new KilnFurnaceMenu(pContainerId, pPlayerInventory, this);
    }
}
