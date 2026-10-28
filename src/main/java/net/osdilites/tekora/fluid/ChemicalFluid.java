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

    /** Helper method.
     * @param fluidData FluidType holding hardcoded properties of the fluid.
     */
    public static Properties FluidProperties(
        Supplier<? extends FluidType> fluidType, 
        Supplier<? extends Fluid> still, 
        Supplier<? extends Fluid> flowing,
        FluidType fluidData) 
    {
        // assumes viscosity of room temp water is 1 cPa and water tickRate = 8
        // this is very very egregiously far from scientifically correct, 
        // but is "okay" for fluids with high viscosity, since high tick/update seems absurdly slow
        // TODO fix this with a better equation
        final double CONVERT_RATIO = 1.0 / 125.0; 
        int viscosityToTickRate = (int) Math.round(CONVERT_RATIO * Math.sqrt(1000 * fluidData.getViscosity()));
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


