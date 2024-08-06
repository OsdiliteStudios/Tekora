package net.tekoramods.tekora.block.entity.entities.generators;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.ItemStackHandler;
import net.tekoramods.tekora.block.entity.entities.IElectricEntity;
import net.tekoramods.tekora.item.containers.Battery;
import net.tekoramods.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractElectricGeneratorEntity extends BlockEntity implements MenuProvider, IElectricEntity {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return stack.getItem() instanceof Battery; // should always be something that can be charged
        }
    };

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return switch (pIndex) {
                case 0 -> AbstractElectricGeneratorEntity.this.ENERGY_STORAGE.getEnergyStored();
                case 1 -> AbstractElectricGeneratorEntity.this.ENERGY_STORAGE.getMaxEnergyStored();
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            if (pIndex == 0) {
                AbstractElectricGeneratorEntity.this.ENERGY_STORAGE.setEnergy(pValue);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };
    protected final TekoraEnergyStorage ENERGY_STORAGE;

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    public AbstractElectricGeneratorEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int pMaxEnergy, int pMaxTransfer) {
        super(pType, pPos, pBlockState);
        this.ENERGY_STORAGE = new TekoraEnergyStorage(this, pMaxEnergy, pMaxTransfer);
    }
    // this will include wind turbines, solar panels, and hydroelectric generators

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyEnergyHandler.invalidate();
    }

    public int maxEnergy() {
        return this.ENERGY_STORAGE.getMaxEnergyStored();
    }

    @Override
    public boolean hasElectricity() {
        return ENERGY_STORAGE.getEnergyStored() > 0;
    }

    public int currentEnergy() {
        return this.ENERGY_STORAGE.getEnergyStored();
    }

    public void changeEnergy(int pAmount) {
        int curEn = this.ENERGY_STORAGE.getEnergyStored();
        this.ENERGY_STORAGE.setEnergy(curEn + pAmount);
    }

    @Override
    public Component getDisplayName() {
        return this.level != null ? this.level.getBlockState(this.getBlockPos()).getBlock().getName() : null;
    }

    public void tick() {
        if (this.level != null && !this.level.isClientSide) {
            if (this.ENERGY_STORAGE.getEnergyStored() >= 256) {
                for (final Direction direction : Direction.values()) {
                    final BlockEntity dirEnt = this.level.getBlockEntity(this.getBlockPos().relative(direction));
                    if (dirEnt != null && dirEnt.getCapability(ForgeCapabilities.ENERGY).isPresent() &&
                            direction != Direction.NORTH) {
                        dirEnt.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(storage -> {
                            if ((dirEnt != this) && storage.getEnergyStored() < storage.getMaxEnergyStored()) {
                                final int extracted = this.ENERGY_STORAGE.extractEnergy(16, false);
                                final int received = storage.receiveEnergy(extracted, false);
                                this.changeEnergy(extracted - received);
                            }
                        });
                    }
                }
            }
        }
    }
}
