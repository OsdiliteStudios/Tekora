package net.tekoramods.tekora.recipes.types;

import net.minecraft.core.NonNullList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.stream.Collectors;

public class ItemFluidContainer extends SimpleContainer {
    private final int fluidSize;
    private final NonNullList<FluidStack> fluids;

    public ItemFluidContainer(int pFluidSize, int pSize) {
        super(pSize);
        this.fluidSize = pFluidSize;
        this.fluids = NonNullList.withSize(pFluidSize, FluidStack.EMPTY);
    }

    public ItemFluidContainer(NonNullList<FluidStack> pFluids, ItemStack... pItems) {
        super(pItems);
        this.fluidSize = pFluids.size();
        this.fluids = pFluids;
    }

    public FluidStack getFluid(int pIndex) {
        return pIndex < this.fluids.size() && pIndex >= 0 ? this.fluids.get(pIndex) : FluidStack.EMPTY;
    }

    public int getFluidSize() {
        return fluidSize;
    }
    public List<FluidStack> removeAllFluids() {
        List<FluidStack> list = this.fluids.stream().filter(fluid -> !fluid.isEmpty()).collect(Collectors.toList());
        this.clearContent();
        return list;
    }

    public boolean addFluid(FluidStack pFluid) {
        if (pFluid != null && !pFluid.isEmpty()) {
            this.fluids.add(pFluid);
            return true;
        }
        return false;
    }

    public boolean addFluid(int pIndex, FluidStack pFluid) {
        if (pFluid != null && !pFluid.isEmpty()) {
            this.fluids.add(pIndex, pFluid);
            return true;
        }
        return false;
    }

    public boolean setFluid(int pIndex, FluidStack pFluid) {
        if (pFluid != null && !pFluid.isEmpty()) {
            this.fluids.set(pIndex, pFluid);
            return true;
        }
        return false;
    }

    @Override
    public void clearContent() {
        this.fluids.clear();
        super.clearContent();
    }

    @Override
    public String toString() {
        return super.toString() + ",\n" + this.fluids.stream()
                .filter(fluid -> !fluid.isEmpty()).toList();
    }
}
