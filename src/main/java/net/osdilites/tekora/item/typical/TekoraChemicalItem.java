package net.osdilites.tekora.item.typical;

public class TekoraChemicalItem extends TekoraItem {
    private final double molPerLiter; // mol/L
    public TekoraChemicalItem(String pName, double molPerLiter) {
        super(pName);
        this.molPerLiter = molPerLiter;
    }

    public TekoraChemicalItem(boolean fireRes, String name, double molPerLiter) {
        super(fireRes, name);
        this.molPerLiter = molPerLiter;
    }

    public double getMolPerLiter() {
        return molPerLiter;
    }
}
