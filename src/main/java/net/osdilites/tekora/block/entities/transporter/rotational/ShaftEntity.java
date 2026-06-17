package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class ShaftEntity extends RotationalAbstractEntity {
    public static final double STEEL_MASS = 1543.307391075986;
    //public static final double NICHROME_MASS = 0;
    public static final double STEEL_RES = 10; // todo, find the actual value in the future.
    private final double compRes;

    public ShaftEntity(BlockPos pPos, BlockState pBlockState, double pComponentMass, double pComponentResistance) {
        super(TekoraBlockEntities.SHAFT.get(), pPos, pBlockState, pComponentMass); // todo again, figure out how this should best be handled
        compRes = pComponentResistance;
    }

    public ShaftEntity(BlockPos pPos, BlockState pBlockState) {
        this(pPos, pBlockState, STEEL_MASS, STEEL_RES);
    }

    @Override
    public double componentResistance() {
        return compRes;
    }

    @Override
    public double componentRadius() {
        return 0.125;
    }
}
