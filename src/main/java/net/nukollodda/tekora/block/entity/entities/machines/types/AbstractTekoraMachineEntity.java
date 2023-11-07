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
import net.nukollodda.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.nukollodda.tekora.block.entity.entities.IElectricEntity;
import net.nukollodda.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTekoraMachineEntity extends BlockEntity implements MenuProvider, IElectricEntity {
    protected final ContainerData data; // this data is being sent to the menu
    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected int progress = 0;
    protected int maxProgress = 72;

    protected final TekoraEnergyStorage ENERGY_STORAGE = new TekoraEnergyStorage(this,4096, 256);
    protected int containerSize;

    protected static final int ENERGY_REQ = 16; // energy consumed per tick for crafting

    public AbstractTekoraMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        super(pType, pPos, pBlockState);
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

    public void changeEnergy(int pAmount) {
        int curEn = this.ENERGY_STORAGE.getEnergyStored();
        this.ENERGY_STORAGE.setEnergy(curEn + pAmount);
    }

    public int maxEnergy() {
        return this.ENERGY_STORAGE.getMaxEnergyStored();
    }

    public int currentEnergy() {
        return this.ENERGY_STORAGE.getEnergyStored();
    }

    public boolean hasElectricity() {
        return ENERGY_STORAGE.getEnergyStored() > 0;
    }
    public boolean hasEnoughElectricity() {
        return ENERGY_STORAGE.getEnergyStored() >= ENERGY_REQ * this.maxProgress;
    }

    protected void resetProgress() {
        if (level != null) {
            BlockState state = this.getBlockState().setValue(AbstractMachineBlock.LIT, false);
            level.setBlock(this.getBlockPos(), state, 3);
        }
        this.progress = 0;
    }

    protected boolean canInsertItemIntoOutputSlot(SimpleContainer inv, ItemStack stack) {
        return inv.getItem(this.containerSize - 1).getItem().equals(stack.getItem()) || inv.getItem(this.containerSize - 1).isEmpty();
    }

    protected boolean canInsertAmountIntoOutputSlot(SimpleContainer inv) {
        return inv.getItem(this.containerSize - 1).getMaxStackSize() > inv.getItem(this.containerSize - 1).getCount();
    }

    @Override
    public Component getDisplayName() {
        return getBlockState().getBlock().getName();
    }
    @Nullable
    @Override
    public abstract AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer);
    protected abstract boolean hasRecipe();
    protected abstract void craftItem();
}
