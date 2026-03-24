package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.util.StringRepresentable;

// in the future we might want this to be encoded using JSON files instead of the current system.
public enum GearType implements StringRepresentable {
    WOOD("wood"),
    STEEL("steel"),
    BRASS("brass");

    private final String name;
    GearType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
