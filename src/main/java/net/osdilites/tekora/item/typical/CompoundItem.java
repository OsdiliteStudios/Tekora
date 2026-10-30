package net.osdilites.tekora.item.typical;

import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;

public class CompoundItem extends TekoraItem {
    // the goal is that this class is intended to store compounds rather than just pure elements
    // for modding compatibility purposes, we may opt to use JSON to store keys instead of using this class for some materials
    private final double moles; // number of moles in a 1/9 kL space or a 1/4 kL space depending on material
    private final Solutes formula;
    public CompoundItem(String pName, Solutes formula, double moles) {
        super(pName);
        this.moles = moles;
        this.formula = formula;
    }

    public CompoundItem(boolean fireRes, String name, Solutes formula, double moles) {
        super(fireRes, name);
        this.moles = moles;
        this.formula = formula;
    }

    public double getMoles() {
        return moles;
    }
}
