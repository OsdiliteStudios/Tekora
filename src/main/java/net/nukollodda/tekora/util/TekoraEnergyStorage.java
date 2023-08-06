package net.nukollodda.tekora.util;

import net.minecraftforge.energy.EnergyStorage;

public abstract class TekoraEnergyStorage extends EnergyStorage {
    public TekoraEnergyStorage(int capacity,  int maxTransfer) {
        super(capacity, maxTransfer);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractedEn = super.extractEnergy(maxExtract, simulate);
        if (extractedEn != 0) onEnergyChanged();
        return extractedEn;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receivedEn = super.receiveEnergy(maxReceive, simulate);
        if (receivedEn != 0) onEnergyChanged();
        return receivedEn;
    }

    public int setEnergy(int pEnergy) {
        this.energy = pEnergy;
        return pEnergy;
    }

    public abstract void onEnergyChanged();
}
