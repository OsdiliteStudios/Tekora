package net.nukollodda.tekora.recipes.types;

import net.minecraft.core.NonNullList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.stream.Collectors;

public class ItemFluidContainer extends SimpleContainer {
    private final int fluidSize;
    private int ind;
    private final NonNullList<FluidStack> fluids;

    public ItemFluidContainer(int pFluidSize, int pSize) {
        super(pSize);
        this.fluidSize = pFluidSize;
        this.fluids = NonNullList.withSize(pFluidSize, FluidStack.EMPTY);
        this.ind = 0;
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
        this.ind = 0;
        return list;
    }

    public boolean addFluid(FluidStack pFluid) {
        if (this.fluidSize > this.fluids.size()) {
            if (pFluid != null && !pFluid.isEmpty()) {
                this.fluids.set(this.ind, pFluid);
                return true;
            }
            this.ind++;
        }
        return false;
    }

    @Deprecated
    public void addFluid(int pIndex, FluidStack pFluid) {
        if (pIndex <= this.fluids.size()) {
            if (pFluid != null && !pFluid.isEmpty()) {
                this.fluids.add(pIndex, pFluid);
            }
        }
    }

    public void setFluid(int pIndex, FluidStack pFluid) {
        if (pIndex <= this.fluids.size() && pFluid != null && !pFluid.isEmpty()) {
            this.fluids.set(pIndex, pFluid);
        }
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
