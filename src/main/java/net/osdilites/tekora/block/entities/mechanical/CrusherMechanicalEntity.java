package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CrusherMechanicalEntity extends AbstractMechMachineEntity {
    public CrusherMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.CRUSHER.get(), pPos, pBlockState);
    }

    @Override
    public double getMoment() {
        BlockState state = getBlockState();
        if (state.hasProperty(AbstractTekoraMechanicalMachine.GEAR_TYPE)) {
            return state.getValue(AbstractTekoraMechanicalMachine.GEAR_TYPE).getSmallMoment() + 1000; // todo, change the 1000 to shaft + this moment
        }
        return 1000; // todo, read the previous todo
    }

    @Override
    public double componentRadius() {
        return 0.25;
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        super.tick(pLevel, pPos, pState);
    }
}
