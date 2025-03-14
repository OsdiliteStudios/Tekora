package net.tekoramods.tekora.util;

import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Comparator;
import java.util.TreeMap;

public class FluidItemHandler extends ItemStackHandler {
    TreeMap<Fluid, Integer> container;
    public FluidItemHandler() {
        super();
        container = new TreeMap<>(Comparator.comparingDouble(a -> a.getFluidType().getDensity()));
    }

    public void addFluid(Fluid fluid) {
        addFluid(fluid, 1);
    }

    public void addFluid(Fluid fluid, int amt) {
        // todo add fluids
        container.put(fluid, container.getOrDefault(fluid, 0) + amt);
    }

    public boolean containsValue(Fluid fluid) {
        return container.containsKey(fluid);
    }

    public int fluidInContainer(Fluid fluid) {
        return container.getOrDefault(fluid, 0);
    }

    public FluidStack extractFluid(Fluid fluid, int amt) {
        if (containsValue(fluid)) {
            container.put(fluid, Math.max(container.get(fluid) - amt, 0));
            return new FluidStack(fluid, amt);
        }
        return null;
    }
}
