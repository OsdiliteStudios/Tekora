package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.util.StringRepresentable;

// in the future we might want this to be encoded using JSON files instead of the current system.
public enum GearType implements StringRepresentable {
    ALUMINUM("aluminum", 225, 2025),
    BRONZE("bronze", 733.33, 6600),
    BRASS("brass", 708.33, 6375),
    STEEL("steel", 654.17, 5887.5),
    PLASTIC("plastic", 44.53, 400.78),
    WOOD("wood", 131.25, 1181.25);

    private final String name;
    private final double smallMoment;
    private final double largeMoment;

    GearType(String name, double smallMoment, double largeMoment) {
        this.name = name;
        this.smallMoment = smallMoment;
        this.largeMoment = largeMoment;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public double getSmallMoment() {
        return smallMoment;
    }

    public double getLargeMoment() {
        return largeMoment;
    }
}
