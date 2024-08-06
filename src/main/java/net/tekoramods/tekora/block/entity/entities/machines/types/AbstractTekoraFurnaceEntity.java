package net.tekoramods.tekora.block.entity.entities.machines.types;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;


public abstract class AbstractTekoraFurnaceEntity extends BlockEntity implements MenuProvider {
    protected final ItemStackHandler itemHandler;

    protected final ContainerData data; // this data is being sent to the menu

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected int progress = 0;
    protected int maxProgress = 72;
    protected int fuel = 0;
    protected int maxFuel = 0;
    protected int containerSize;

    public AbstractTekoraFurnaceEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        super(pType, pPos, pBlockState);
        this.itemHandler = new ItemStackHandler(containerSize);
        this.containerSize = containerSize;

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) { // returns the progress
                    case 0 -> AbstractTekoraFurnaceEntity.this.progress;
                    case 1 -> AbstractTekoraFurnaceEntity.this.maxProgress;
                    case 2 -> AbstractTekoraFurnaceEntity.this.fuel;
                    case 3 -> AbstractTekoraFurnaceEntity.this.maxFuel;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) { // sets progress values
                    case 0 -> AbstractTekoraFurnaceEntity.this.progress = pValue;
                    case 1 -> AbstractTekoraFurnaceEntity.this.maxProgress = pValue;
                    case 2 -> AbstractTekoraFurnaceEntity.this.fuel = pValue; // temp code
                    case 3 -> AbstractTekoraFurnaceEntity.this.maxFuel = pValue;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    public boolean isLit() { return fuel > 0; }

    public boolean isSmelting() {
        return fuel > 0;
    }

    protected void resetProgress() {
        this.progress = 0;
    }

    protected boolean canInsertItemIntoOutputSlot(SimpleContainer inv, ItemStack stack) {
        return inv.getItem(this.containerSize - 1).getItem() == stack.getItem() || inv.getItem(this.containerSize - 1).isEmpty();
    }

    protected boolean canInsertAmountIntoOutputSlot(SimpleContainer inv) {
        return inv.getItem(this.containerSize - 1).getMaxStackSize() > inv.getItem(this.containerSize - 1).getCount();
    }

    @Override
    public Component getDisplayName() {
        return this.level != null ? this.level.getBlockState(this.getBlockPos()).getBlock().getName() : Component.literal("");
    }
    @Nullable
    @Override
    public abstract AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer);
    protected abstract boolean hasRecipe();
    protected abstract void craftItem();
}
