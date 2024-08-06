package net.leng.tekora.block.entity.entities.storage;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
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
import net.leng.tekora.block.entity.entities.IElectricEntity;
import net.leng.tekora.item.containers.Battery;
import net.leng.tekora.menu.BatteryMenu;
import net.leng.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BatteryEntity extends BlockEntity implements MenuProvider, IElectricEntity {
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
                case 0 -> BatteryEntity.this.ENERGY_STORAGE.getEnergyStored();
                case 1 -> BatteryEntity.this.ENERGY_STORAGE.getMaxEnergyStored();
                default -> 0;
            };
        }

        @Override
        public void set(int pIndex, int pValue) {
            if (pIndex == 0) {
                BatteryEntity.this.ENERGY_STORAGE.setEnergy(pValue);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };
    protected final TekoraEnergyStorage ENERGY_STORAGE;
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    public BatteryEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int maxEnergy) {
        super(pType, pPos, pBlockState);
        this.ENERGY_STORAGE = new TekoraEnergyStorage(this, maxEnergy, 256);
    }

    public void changeEnergy(int pAmount) {
        int curEn = this.ENERGY_STORAGE.getEnergyStored();
        this.ENERGY_STORAGE.setEnergy(curEn + pAmount);
    }

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
    @Override
    public Component getDisplayName() {
        return this.level != null ? this.level.getBlockState(this.getBlockPos()).getBlock().getName() : null;
    };

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pId, Inventory pInventory, Player pPlayer) {
        return new BatteryMenu(pId, pInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("battery.electricity", ENERGY_STORAGE.getEnergyStored());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        ENERGY_STORAGE.setEnergy(tag.getInt("battery.electricity"));
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
