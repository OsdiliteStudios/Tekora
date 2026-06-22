package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class MixerAbstractEntity extends AbstractMechanicalEntity {
    public MixerAbstractEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pState) {
        super(pType, pPos, pState);
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }
}
