package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class HandCrankEntity extends RotationalAbstractEntity {

    public HandCrankEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.HAND_CRANK.get(), pPos, pBlockState, 1000);
        // todo, calculate the actual mass of the entity
    }

    public void addToForce(double force) {
        body.addForce(getBlockPos(), force);
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }

    @Override
    public double componentResistance() {
        return 0;
    }
}
