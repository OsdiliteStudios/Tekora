package net.nukollodda.tekora.block.entity.entities.machines.types;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.nukollodda.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.nukollodda.tekora.block.entity.entities.IElectricEntity;
import net.nukollodda.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class AbstractTekoraMachineEntity<C extends SimpleContainer, T extends Recipe<C>> extends BlockEntity
        implements MenuProvider, IElectricEntity {
    protected final ContainerData data; // this data is being sent to the menu
    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected int progress = 0;
    protected int maxProgress = 72;

    protected final TekoraEnergyStorage energyStorage;
    protected int containerSize;

    protected static final int ENERGY_REQ = 16; // energy consumed per tick for crafting


    public AbstractTekoraMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        this(pType, pPos, pBlockState, containerSize, 4096, 256);
    }

    public AbstractTekoraMachineEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int containerSize,
                                       int pCapacity, int pTransfer) {
        super(pType, pPos, pBlockState);
        this.containerSize = containerSize;
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) { // returns the progress
                    case 0 -> AbstractTekoraMachineEntity.this.progress;
                    case 1 -> AbstractTekoraMachineEntity.this.maxProgress;
                    case 2 -> AbstractTekoraMachineEntity.this.energyStorage.getEnergyStored();
                    case 3 -> AbstractTekoraMachineEntity.this.energyStorage.getMaxEnergyStored();
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> AbstractTekoraMachineEntity.this.progress = pValue;
                    case 1 -> AbstractTekoraMachineEntity.this.maxProgress = pValue;
                    case 2 -> AbstractTekoraMachineEntity.this.energyStorage.setEnergy(pValue);
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
        this.energyStorage = new TekoraEnergyStorage(this, pCapacity, pTransfer);
    }

    public void changeEnergy(int pAmount) {
        int curEn = this.energyStorage.getEnergyStored();
        this.energyStorage.setEnergy(curEn + pAmount);
    }

    public int maxEnergy() {
        return this.energyStorage.getMaxEnergyStored();
    }

    public int currentEnergy() {
        return this.energyStorage.getEnergyStored();
    }

    public boolean hasElectricity() {
        return energyStorage.getEnergyStored() > 0;
    }
    public boolean hasEnoughElectricity() {
        return energyStorage.getEnergyStored() >= ENERGY_REQ * this.maxProgress;
    }

    protected void resetProgress() {
        this.progress = 0;
    }

    protected boolean canInsertItemIntoOutputSlot(SimpleContainer inv, ItemStack stack) {
        ItemStack item = inv.getItem(this.containerSize - 1);
        return (item.getItem().equals(stack.getItem()) && item.getCount() + stack.getCount() < stack.getMaxStackSize())
                || item.isEmpty();
    }

    @Deprecated
    protected boolean canInsertAmountIntoOutputSlot(SimpleContainer inv) {
        return true;
    }
    protected boolean canInsertItemIntoResidueSlot(C inv, ItemStack stack) {
        return (inv.getItem(1).getItem().equals(stack.getItem()) || inv.getItem(1).isEmpty()) &&
                inv.getItem(this.containerSize - 1).getMaxStackSize() > inv.getItem(this.containerSize - 1).getCount();
    }

    protected boolean canInsertAmountIntoResidueSlot(C inv) {
        return inv.getItem(1).getMaxStackSize() > inv.getItem(1).getCount();
    }

    @Override
    public Component getDisplayName() {
        return getBlockState().getBlock().getName();
    }
    @Nullable
    @Override
    public abstract AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer);
    protected abstract boolean hasRecipe(T pRecipe, C pContainer);
    protected abstract C getContainer();
    protected abstract void craftItem(T pRecipe, C pContainer);
}
