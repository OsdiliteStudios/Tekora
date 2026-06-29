package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;

public abstract class AbstractTekoraMechanicalMachine extends BaseEntityBlock {
    public static final EnumProperty<GearType> GEAR_TYPE = EnumProperty.create("gear_type", GearType.class);

    public AbstractTekoraMechanicalMachine(Properties properties) {
        super(properties);
    }
}
