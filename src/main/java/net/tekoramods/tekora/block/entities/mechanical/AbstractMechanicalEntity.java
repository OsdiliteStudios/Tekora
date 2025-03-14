package net.tekoramods.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.TekoraBlockEntity;

public abstract class AbstractMechanicalEntity extends TekoraBlockEntity {
    private double componentMass;

    public AbstractMechanicalEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState);
        componentMass = pComponentMass;
    }

    public double componentMass() {
        return componentMass;
    }

    public abstract double componentRadius();

    //public abstract void tick(Level pLevel, BlockPos pPos, BlockState pState);
}
