package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class AssemblerMechanicalEntity extends AbstractDeployingMachineEntity {
    public AssemblerMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.ASSEMBLER.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0;
    }
}
