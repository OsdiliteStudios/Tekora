package net.nukollodda.tekora.block.entity.blocks.connecters.cables;

import net.nukollodda.tekora.block.entity.blocks.connecters.AbstractConnector;

public abstract class AbstractEnergyCable extends AbstractConnector {
    private final int color;
    public AbstractEnergyCable(float strength, int color) {
        super(strength);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
