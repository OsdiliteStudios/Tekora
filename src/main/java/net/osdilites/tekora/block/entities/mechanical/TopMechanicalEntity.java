package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class TopMechanicalEntity extends AbstractModularMachineEntity {
    public TopMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.TOP_MECH.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0; // todo, determine the moment
    }
}
