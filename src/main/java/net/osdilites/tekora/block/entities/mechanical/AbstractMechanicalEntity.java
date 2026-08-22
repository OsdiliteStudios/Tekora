package net.osdilites.tekora.block.entities.mechanical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractMechanicalEntity extends BlockEntity {
    public AbstractMechanicalEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public abstract float getOldAngle();

    public abstract float getAngle();

    public abstract double getMoment();

    public abstract double componentRadius();

    public abstract void tick(Level pLevel, BlockPos pPos, BlockState pState);
}
