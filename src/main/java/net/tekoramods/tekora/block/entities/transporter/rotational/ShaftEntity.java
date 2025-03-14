package net.tekoramods.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;

public abstract class ShaftEntity extends RotationalAbstractEntity {
    public static final double STEEL_MASS = 1543.307391075986;
    //public static final double NICHROME_MASS = 0;

    protected ShaftEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    @Override
    public double componentRadius() {
        return 0.125;
    }

    public static class Steel extends ShaftEntity {
        public Steel(BlockPos pPos, BlockState pBlockState) {
            super(TekoraBlockEntities.STEEL_SHAFT.get(), pPos, pBlockState, STEEL_MASS);
        }
    }
}
