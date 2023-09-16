package net.nukollodda.tekora.block.entity.entities.connectors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.nukollodda.tekora.block.entity.entities.IElectricEntity;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.entity.entities.enstorage.BatteryEntity;
import net.nukollodda.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnergyCableEntity extends AbstractConnectorEntity implements IElectricEntity {
    protected final TekoraEnergyStorage ENERGY_STORAGE;

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private final int maxTransfer;

    public EnergyCableEntity(BlockPos pPos, BlockState pBlockState, int pCapacity, int pMaxTrans) {
        super(TekoraBlockEntities.ENERGY_CABLE.get(), pPos, pBlockState);
        this.ENERGY_STORAGE = new TekoraEnergyStorage(this, pCapacity, pMaxTrans);
        maxTransfer = pMaxTrans;
    }

    public EnergyCableEntity(BlockPos pPos, BlockState pBlockState) {
        this(pPos, pBlockState, 256, 1024);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == ForgeCapabilities.ENERGY ? lazyEnergyHandler.cast() : super.getCapability(cap, side);
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

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("cable.electricity", ENERGY_STORAGE.getEnergyStored());
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        ENERGY_STORAGE.setEnergy(pTag.getInt("cable.electricity"));
    }

    public void tick() {
        if (this.level != null && !this.level.isClientSide) {
            if (this.ENERGY_STORAGE.getEnergyStored() >= maxTransfer) {
                for (final Direction direction : Direction.values()) {
                    final BlockEntity dirEnt = this.level.getBlockEntity(this.getBlockPos().relative(direction));
                    if (dirEnt != null && dirEnt.getCapability(ForgeCapabilities.ENERGY).isPresent() &&
                            !(dirEnt instanceof BatteryEntity && direction == Direction.NORTH)) {
                        dirEnt.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(storage -> {
                            if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {
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
