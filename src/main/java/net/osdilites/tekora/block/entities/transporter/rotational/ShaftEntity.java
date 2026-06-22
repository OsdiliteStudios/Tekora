package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class ShaftEntity extends RotationalAbstractEntity {
    public static final double I_MASS = 1543.307391075986;
    //public static final double NICHROME_MASS = 0;
    public static final double STEEL_RES = 10; // todo, find the actual value in the future.

    public ShaftEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.SHAFT.get(), pPos, pBlockState); // todo again, figure out how this should best be handled
    }

    @Override
    public double getMoment() {
        return I_MASS;
    }

    @Override
    public double componentRadius() {
        return 0.125;
    }
}
