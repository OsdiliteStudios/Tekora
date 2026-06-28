package net.osdilites.tekora.item.typical;

import net.osdilites.tekora.block.entities.transporter.rotational.GearType;

public class GearItem extends TekoraItem {
    private final GearType gearType;

    public GearItem(String name, GearType gearType) {
        super(name);
        this.gearType = gearType;
    }

    public GearItem(String name, GearType gearType, boolean fireRes) {
        super(fireRes, name);
        this.gearType = gearType;
    }
}
