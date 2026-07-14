package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class PressMechanicalEntity extends AbstractMechMachineEntity {
    public PressMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PRESS.get(), pPos, pBlockState);
    }

    @Override
    public double getMoment() {
        return 0;
    }

    @Override
    public double componentRadius() {
        return 0;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        super.tick(pLevel, pPos, pState);
    }
}
