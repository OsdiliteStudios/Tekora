package net.nukollodda.tekora.block.entity.entities.machines.types;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
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
import net.nukollodda.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTekoraMachineEntity extends BlockEntity implements MenuProvider {
    protected final ItemStackHandler itemHandler;

    protected final ContainerData data; // this data is being sent to the menu

    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected int progress = 0;
    protected int maxProgress = 72;

    protected final TekoraEnergyStorage ENERGY_STORAGE = new TekoraEnergyStorage(4096, 256) {
        @Override
        public void onEnergyChanged() {
            setChanged();
        }
    };
    protected int containerSize;

    protected static final int ENERGY_REQ = 32; // energy consumed per tick for crafting

    public AbstractTekoraMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        super(pType, pPos, pBlockState);
        this.itemHandler = new ItemStackHandler(containerSize);
        this.containerSize = containerSize;

        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) { // returns the progress
                    case 0 -> AbstractTekoraMachineEntity.this.progress;
                    case 1 -> AbstractTekoraMachineEntity.this.maxProgress;
                    case 2 -> AbstractTekoraMachineEntity.this.ENERGY_STORAGE.getEnergyStored();
                    case 3 -> AbstractTekoraMachineEntity.this.ENERGY_STORAGE.getMaxEnergyStored();
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> AbstractTekoraMachineEntity.this.progress = pValue;
                    case 1 -> AbstractTekoraMachineEntity.this.maxProgress = pValue;
                    case 2 -> AbstractTekoraMachineEntity.this.ENERGY_STORAGE.setEnergy(pValue);
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }
    public boolean hasEnoughElectricity(AbstractTekoraMachineEntity pEntity) {
        return ENERGY_STORAGE.getEnergyStored() >= ENERGY_REQ * pEntity.maxProgress;
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
    public abstract Component getDisplayName();
    @Nullable
    @Override
    public abstract AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer);
    protected abstract boolean hasRecipe();
    protected abstract void craftItem();
}
