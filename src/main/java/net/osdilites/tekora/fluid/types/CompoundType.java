package net.osdilites.tekora.fluid.types;

import net.minecraft.util.StringRepresentable;

public enum CompoundType implements StringRepresentable {
    // this is a property specific to Tekora fluids that will affect how it gets displayed in renderers
    // and potentially how it interacts in mixers/reactors
    LDF("ldf"), // blends in ldf only, ex. oils
    AMPHIPATHIC("amphipathic"), // blends in both ldf and polar, if both ldf and polar are present, it turns into bubbles, ex. ethanol
    POLAR("polar"), // blends in amphipathic and polar, ex. water
    IONIC("ionic"); // ex. molten salts
    final String name;
    CompoundType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
