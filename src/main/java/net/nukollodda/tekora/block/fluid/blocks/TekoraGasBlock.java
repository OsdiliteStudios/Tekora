package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.util.TekoraFluidFunctions;

import java.util.function.Supplier;

public class TekoraGasBlock extends AbstractTekoraFluidBlock {

    public TekoraGasBlock(Supplier<? extends FlowingFluid> pFluid) {
        super(pFluid, BlockBehaviour.Properties.copy(Blocks.WATER));
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
            ResourceKey<Level> dimension = pLevel.dimension();
            float biomeTemp = TekoraFluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature());

            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (tekoraFluid.getBoilingPoint(pressure) > biomeTemp) {
                TekoraFluidFunctions.makeCondensationParticles(pLevel, pPos, tekoraFluid.isMetallic());
            } else if (tekoraFluid.getMeltingPoint() > biomeTemp) {
                TekoraFluidFunctions.makeHailParticles(pLevel, pPos, tekoraFluid.isMetallic());
            }
        }
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
