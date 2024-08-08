package net.tekoramods.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.tekoramods.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElectricAlloyerEntity {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            // setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return slot > 0 && slot < 5;
        }
    };

    public ElectricAlloyerEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        // super(pType, pPos, pBlockState, containerSize);
    }

    // @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    // @Override
    protected boolean hasRecipe() {
        return false;
    }

    // @Override
    protected void craftItem() {

    }
}
