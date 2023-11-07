package net.nukollodda.tekora.block.entity.blocks.generators;

import net.minecraft.world.level.block.SoundType;
import net.nukollodda.tekora.block.entity.blocks.machines.AbstractMachineBlock;

public abstract class AbstractGenerator extends AbstractMachineBlock {
    public AbstractGenerator(float strength, SoundType sound) {
        super(strength, sound);
    }

    public AbstractGenerator(float strength) {
        super(strength);
    }
}
