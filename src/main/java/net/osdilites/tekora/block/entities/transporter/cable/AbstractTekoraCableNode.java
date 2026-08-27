package net.osdilites.tekora.block.entities.transporter.cable;

import net.minecraft.world.level.block.BaseEntityBlock;

public abstract class AbstractTekoraCableNode extends BaseEntityBlock {
    public AbstractTekoraCableNode(Properties properties) {
        super(properties.requiresCorrectToolForDrops());
    }
}
