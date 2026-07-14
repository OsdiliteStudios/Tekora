package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;

public abstract class AbstractTekoraMechanicalMachine extends BaseEntityBlock {
    public static final EnumProperty<GearType> GEAR_TYPE = TekoraBlockStates.GEAR_TYPE;

    public AbstractTekoraMechanicalMachine(Properties properties) {
        super(properties);
    }
}
