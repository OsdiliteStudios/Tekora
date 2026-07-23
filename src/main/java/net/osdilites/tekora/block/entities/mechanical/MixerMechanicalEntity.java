package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class MixerMechanicalEntity extends AbstractModularMachineEntity {
    public MixerMechanicalEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.MIXER.get(), pPos, pState);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        // todo, add recipe capabilities and link it to the force above
    }

    @Override
    protected double partMoment() {
        return 0; // todo define value
    }
}
