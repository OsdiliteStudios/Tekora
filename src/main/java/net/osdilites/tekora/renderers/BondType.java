package net.osdilites.tekora.renderers;

import net.minecraft.util.StringRepresentable;

public enum BondType implements StringRepresentable {
    // this is a property specific to Tekora fluids that will affect how it gets displayed in renderers
    // and potentially how it interacts in mixers/reactors
    LDF("ldf"),
    DIPOLE_DIPOLE("dipole_dipole"),
    H_BOND("h_bond"),
    IONIC("ionic");
    final String name;
    BondType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
