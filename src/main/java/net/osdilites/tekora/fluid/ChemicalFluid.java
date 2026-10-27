package net.osdilites.tekora.fluid;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;

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

    /// Helper method for setting fluid properties based on other properties automatically.
    public static Properties createChemicalFluidProperties(
        Supplier<? extends FluidType> fluidType, 
        Supplier<? extends Fluid> still, 
        Supplier<? extends Fluid> flowing,
        FluidType fluidData) 
    {
        // assumes viscosity of room temp water is 1000 cPa and water tickRate = 8
        final int CONVERT_RATIO = 125; 
        int viscosityToTickRate = fluidData.getViscosity() / CONVERT_RATIO;
        return new BaseFlowingFluid.Properties(fluidType, still, flowing)
            .tickRate(Math.max(viscosityToTickRate, 1));
    }


    public static class Flowing extends ChemicalFluid {
        public Flowing(Properties p) {
            super(p);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
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

        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}


