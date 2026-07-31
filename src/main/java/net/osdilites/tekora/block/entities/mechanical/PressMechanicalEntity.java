package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class PressMechanicalEntity extends AbstractModularMachineEntity {
    public PressMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PRESS.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0; // todo define value
    }
}
