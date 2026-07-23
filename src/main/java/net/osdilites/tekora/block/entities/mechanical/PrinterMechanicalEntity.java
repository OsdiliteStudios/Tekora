package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class PrinterMechanicalEntity extends AbstractModularMachineEntity {
    public PrinterMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PRINTER.get(), pPos, pBlockState);
    }

    @Override
    protected double partMoment() {
        return 0; // todo find value
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        super.tick(pLevel, pPos, pState);
    }
}
