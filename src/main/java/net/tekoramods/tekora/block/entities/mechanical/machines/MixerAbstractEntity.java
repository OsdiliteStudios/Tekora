package net.tekoramods.tekora.block.entities.mechanical.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entities.mechanical.AbstractMechanicalEntity;

public abstract class MixerAbstractEntity extends AbstractMechanicalEntity {
    public MixerAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pState, double pComponentMass) {
        super(pType, pPos, pState, pComponentMass);
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }
}
