package net.nukollodda.tekora.block.entity.blocks.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractElectricMachineBlock extends AbstractMachineBlock {
    public AbstractElectricMachineBlock(float strength, SoundType sound) {
        super(strength, sound);
    }

    public AbstractElectricMachineBlock(float strength) {
        super(strength);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double d0 = pPos.getX() + 0.5;
            double d1 = pPos.getY();
            double d2 = pPos.getZ() + 0.5;
            // todo, make a custom sound
            if (pRandom.nextDouble() < 0.1) {
                pLevel.playLocalSound(d0, d1, d2, SoundEvents.BEE_LOOP, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }

            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d4 = pRandom.nextDouble() * 0.6 - 0.3;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : d4;
            double d6 = pRandom.nextDouble() * 6.0 / 16.0;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : d4;
            pLevel.addParticle(ParticleTypes.ELECTRIC_SPARK, d0 + d5, d1 + d6, d2 + d7, 0, 0, 0);
        }
    }
}
