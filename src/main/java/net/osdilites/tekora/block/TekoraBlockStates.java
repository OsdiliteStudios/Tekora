package net.osdilites.tekora.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;

public class TekoraBlockStates {
    public static final EnumProperty<GearType> GEAR_TYPE = EnumProperty.create("gear_type", GearType.class);
    public static final BooleanProperty IS_LARGE = BooleanProperty.create("is_large");
}
