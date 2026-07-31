package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CutterMechanicalEntity extends AbstractModularMachineEntity {
    public CutterMechanicalEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.CUTTER.get(), pPos, pState);
    }

    @Override
    protected double partMoment() {
        return 0; // todo, find value
    }
}
