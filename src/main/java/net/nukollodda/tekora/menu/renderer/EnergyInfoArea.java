package net.nukollodda.tekora.menu.renderer;

/*
 * BluSunrise
 * Copyright (c) 2021
 */

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;

public class EnergyInfoArea extends InfoArea {
    private final IEnergyStorage energy;

    public EnergyInfoArea(int xMin, int yMin) {
        this(xMin, yMin, null, 8, 64);
    }

    public EnergyInfoArea(int xMin, int yMin, IEnergyStorage pEnergy) {
        this(xMin, yMin, pEnergy, 8, 64);
    }

    public EnergyInfoArea(int xMin, int yMin, IEnergyStorage pEnergy, int pWidth, int pHeight) {
        super(new Rect2i(xMin, yMin, pWidth, pHeight));
        this.energy = pEnergy;
    }

    public List<Component> getToolTips() {
        return List.of(Component.literal(energy.getEnergyStored() + "/" + energy.getMaxEnergyStored() + "GJ"));
    }

    @Override
    public void draw(PoseStack pTransform) {
        final int height = area.getHeight();
        int stored = (int) (height * (energy.getEnergyStored() / (float) energy.getMaxEnergyStored()));

    }
}
