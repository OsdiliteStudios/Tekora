package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum MachineType implements StringRepresentable {
    CRUSHER,
    PRINTER,
    PRESS,
    MIXER;

    @Override
    public @NonNull String getSerializedName() {
        return toString().toLowerCase();
    }
}
