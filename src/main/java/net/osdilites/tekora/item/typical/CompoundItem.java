package net.osdilites.tekora.item.typical;

public class CompoundItem extends TekoraItem {
    // the goal is that this class is intended to store compounds rather than just pure elements
    // for modding compatibility purposes, we may opt to use JSON to store keys instead of using this class for some materials
    private final double moles; // number of moles in a 1/9 kL space or a 1/4 kL space depending on material
    private final String formula;
    public CompoundItem(String pName, String formula, double moles) {
        super(pName);
        this.moles = moles;
        this.formula = formula;
    }

    public CompoundItem(boolean fireRes, String name, String formula, double moles) {
        super(fireRes, name);
        this.moles = moles;
        this.formula = formula;
    }

    public double getMoles() {
        return moles;
    }
}
