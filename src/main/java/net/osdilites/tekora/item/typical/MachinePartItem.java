package net.osdilites.tekora.item.typical;

import net.osdilites.tekora.block.entities.mechanical.AbstractTekoraMechanicalBlock;

public class MachinePartItem extends TekoraItem {
    private final AbstractTekoraMechanicalBlock block;

    public MachinePartItem(String name, AbstractTekoraMechanicalBlock block) {
        super(name);
        this.block = block;
    }

    public MachinePartItem(String name, AbstractTekoraMechanicalBlock block, boolean fireRes) {
        super(fireRes, name);
        this.block = block;
    }
}
