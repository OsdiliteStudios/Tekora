package net.osdilites.tekora.fluid.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class ChemicalFluid extends BaseFlowingFluid {
    protected ChemicalFluid(Properties p) {
        super(p);
    }

    @Override
    public void tick(ServerLevel level, BlockPos pos, BlockState blockState, FluidState fluidState) {
        super.tick(level, pos, blockState, fluidState);
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return fluidState.getAmount();
    }

    public static class Flowing extends ChemicalFluid {
        public Flowing(Properties p) {
            super(p);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }
    public static class Source extends ChemicalFluid {
        public Source(Properties p) {
            super(p);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
