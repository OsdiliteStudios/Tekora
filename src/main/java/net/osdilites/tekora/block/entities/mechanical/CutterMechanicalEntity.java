package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CutterMechanicalEntity extends AbstractMechMachineEntity {
    public CutterMechanicalEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.CUTTER.get(), pPos, pState);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // todo, add recipe capabilities and link it to the force above
    }

    @Override
    public double getMoment() {
        return 4943.728065546406; // todo, possibly turn this into an equation
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }
}
