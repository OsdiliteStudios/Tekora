package net.tekoramods.tekora.util;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.energy.EnergyStorage;

public class TekoraEnergyStorage extends EnergyStorage {
    private final BlockEntity blockEntity;

    public TekoraEnergyStorage(BlockEntity entity, int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
        this.blockEntity = entity;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractedEn = super.extractEnergy(maxExtract, simulate);
        if (extractedEn != 0) blockEntity.setChanged();
        this.blockEntity.setChanged();
        return extractedEn;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receivedEn = super.receiveEnergy(maxReceive, simulate);
        if (receivedEn != 0) blockEntity.setChanged();
        this.blockEntity.setChanged();
        return receivedEn;
    }

    public int setEnergy(int pEnergy) {
        this.energy = Math.max(0, Math.min(pEnergy, this.capacity));
        return this.energy;
    }
}
