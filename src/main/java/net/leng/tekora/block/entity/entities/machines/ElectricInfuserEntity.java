package net.leng.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElectricInfuserEntity { // note: fluid handling will be dealt with here
    protected final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            // setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return slot == 1 || slot == 2;
        }
    };

    public ElectricInfuserEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        // super(pType, pPos, pBlockState, containerSize);
    }

    //@Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    //@Override
    protected boolean hasRecipe() {
        // note: for all instances where coal is the catalyst and the input is a carbonate/oxide, the material will purify
        return false;
    }

    //@Override
    protected void craftItem() {

    }
}
