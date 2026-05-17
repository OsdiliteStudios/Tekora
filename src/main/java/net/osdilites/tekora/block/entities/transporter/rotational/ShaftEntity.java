package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public abstract class ShaftEntity extends RotationalAbstractEntity {
    public static final double STEEL_MASS = 1543.307391075986;
    //public static final double NICHROME_MASS = 0;

    public ShaftEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass); // todo again, figure out how this should best be handled
    }

    @Override
    public double componentRadius() {
        return 0.125;
    }

    @Deprecated
    public static class Steel extends ShaftEntity {
        public Steel(BlockPos pPos, BlockState pBlockState) {
            super(TekoraBlockEntities.STEEL_SHAFT.get(), pPos, pBlockState, STEEL_MASS);
        }

        @Override
        public double componentResistance() {
            return 0;
        }
    }
}
