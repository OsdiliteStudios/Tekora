package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class ApplyerMechanicalEntity extends AbstractDeployingMachineEntity {
    public ApplyerMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.ASSEMBLER.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0;
    }
}
