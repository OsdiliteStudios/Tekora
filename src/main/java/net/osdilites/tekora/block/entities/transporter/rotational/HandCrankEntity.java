package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class HandCrankEntity extends RotationalAbstractEntity {
    public HandCrankEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.HAND_CRANK.get(), pPos, pBlockState);
    }

    public void addToForce(double force) {
        if (body != null) body.addForce(getBlockPos(), force);
        else createOrJoinBody();
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }

    @Override
    public double getMoment() {
        return 1000;
    }
}
