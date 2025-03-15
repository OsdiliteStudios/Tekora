package net.tekoramods.tekora.block.entities.attachment;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.TekoraBlockEntity;
import net.tekoramods.tekora.menu.ItemTransportMenu;
import org.jetbrains.annotations.Nullable;

public abstract class ItemTransportEntity extends TekoraBlockEntity {
    public ItemTransportEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public void clearContents() {
        getInventory().setStackInSlot(0, ItemStack.EMPTY);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ItemTransportMenu(pContainerId, pPlayerInventory, this);
    }
}
