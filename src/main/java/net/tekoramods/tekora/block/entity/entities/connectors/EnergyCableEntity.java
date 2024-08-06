package net.tekoramods.tekora.block.entity.entities.connectors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.tekoramods.tekora.block.entity.entities.IElectricEntity;
import net.tekoramods.tekora.block.entity.entities.TekoraBlockEntities;
import net.tekoramods.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class EnergyCableEntity extends AbstractConnectorEntity implements IElectricEntity {
    protected final TekoraEnergyStorage energyStorage;

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    protected EnergyCableEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pState, int pCapacity) {
        super(pType, pPos, pState);
        this.energyStorage = new TekoraEnergyStorage(this, pCapacity, pCapacity);
    }

    public EnergyCableEntity(BlockPos pPos, BlockState pBlockState, int pCapacity) {
        this(TekoraBlockEntities.ENERGY_CABLE.get(), pPos, pBlockState, pCapacity);
    }

    public EnergyCableEntity(BlockPos pPos, BlockState pBlockState) {
        this(pPos, pBlockState, 256);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == ForgeCapabilities.ENERGY ? lazyEnergyHandler.cast() : super.getCapability(cap, side);
    }

    private void checkOutputs() {
        if (outputs == null && getLevel() != null) {
            outputs = new HashSet<>();
            traverse(getBlockPos(), blockEntity -> {
                for (Direction direction : Direction.values()) {
                    BlockPos pos = blockEntity.getBlockPos().relative(direction);
                    BlockEntity entity = getLevel().getBlockEntity(pos);
                    if (entity != null) {
                        entity.getCapability(ForgeCapabilities.ENERGY).ifPresent(storage -> {
                            if (storage.canReceive()) outputs.add(pos);
                        });
                    }
                }
            });
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyEnergyHandler.invalidate();
    }

    public void changeEnergy(int pAmount) {
        int curEn = this.energyStorage.getEnergyStored();
        this.energyStorage.setEnergy(curEn + pAmount);
    }

    @Override
    public void markDirty() {
        traverse(worldPosition, cable -> cable.outputs = null);
    }

    private void traverse(BlockPos pPos, Consumer<EnergyCableEntity> pConsumer) {
        Set<BlockPos> traversed = new HashSet<>();
        traversed.add(pPos);
        pConsumer.accept(this);
        traverse(pPos, traversed, pConsumer);
    }

    private void traverse(BlockPos pPos, Set<BlockPos> pTraversed, Consumer<EnergyCableEntity> pConsumer) {
        for (Direction direction : Direction.values()) {
            BlockPos pos = pPos.relative(direction);
            if (!pTraversed.contains(pPos)) {
                pTraversed.add(pos);
                if (level != null && level.getBlockEntity(pos) instanceof EnergyCableEntity cable) {
                    pConsumer.accept(cable);
                    cable.traverse(pos, pTraversed, pConsumer);
                }
            }
        }
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

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("cable.electricity", energyStorage.getEnergyStored());
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        energyStorage.setEnergy(pTag.getInt("cable.electricity"));
    }

    // https://www.mcjty.eu/docs/1.20/ep5

    public void tick() {
        if (currentEnergy() > 0) {
            checkOutputs();
            if (!outputs.isEmpty() && getLevel() != null) {
                int amount = currentEnergy() / outputs.size();
                for (BlockPos pos : outputs) {
                    BlockEntity entity = getLevel().getBlockEntity(pos);
                    if (entity != null) {
                        entity.getCapability(ForgeCapabilities.ENERGY).ifPresent(storage -> {
                            if (storage.canReceive()) energyStorage.extractEnergy(storage.receiveEnergy(amount, false), false);
                        });
                    }
                }
            }
        }
    }
}
