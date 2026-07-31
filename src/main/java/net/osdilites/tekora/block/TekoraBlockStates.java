package net.osdilites.tekora.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;

public class TekoraBlockStates {
    public static final EnumProperty<GearType> GEAR_TYPE = EnumProperty.create("gear_type", GearType.class);
    public static final BooleanProperty IS_LARGE = BooleanProperty.create("is_large");
    public static final IntegerProperty CONNECTION = IntegerProperty.create("connection", 0, 0b111111);
}
