package net.leng.tekora.block.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.leng.tekora.fluid.TekoraChemicalFluidType;
import net.leng.tekora.util.FluidFunctions;

import java.util.function.Supplier;

public class TekoraGasBlock extends AbstractTekoraFluidBlock {

    public TekoraGasBlock(Supplier<? extends FlowingFluid> pFluid) {
        super(pFluid, BlockBehaviour.Properties.copy(Blocks.WATER));
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        if (this.getFluid().getFluidType() instanceof TekoraChemicalFluidType tekoraFluid) {
            ResourceKey<Level> dimension = pLevel.dimension();
            float areaTemp = FluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature()) + pLevel.getLightEmission(pPos) / 15f;

            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (tekoraFluid.getBoilingPoint(pressure) > areaTemp) {
                makeCondensationParticles(pLevel, pPos, tekoraFluid.isMetallic());
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            } else if (tekoraFluid.getMeltingPoint() > areaTemp) {
                makeHailParticles(pLevel, pPos, tekoraFluid.isMetallic());
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    private void makeCondensationParticles(Level pLevel, BlockPos pPos, boolean pIsMetal) {
        FluidFunctions.makeParticles(pLevel, pPos, pIsMetal ? SoundEvents.COPPER_BREAK : SoundEvents.WEATHER_RAIN,
                pIsMetal ? ParticleTypes.ASH : ParticleTypes.RAIN);
    }

    public void makeHailParticles(Level pLevel, BlockPos pPos, boolean pIsMetal) {
        FluidFunctions.makeParticles(pLevel, pPos, pIsMetal ? SoundEvents.ELDER_GUARDIAN_CURSE : SoundEvents.PLAYER_HURT_FREEZE,
                pIsMetal ? ParticleTypes.ASH : ParticleTypes.SNOWFLAKE);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
