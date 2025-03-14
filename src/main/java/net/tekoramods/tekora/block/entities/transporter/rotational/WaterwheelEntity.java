package net.tekoramods.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;

public abstract class WaterwheelEntity extends RotationalAbstractEntity {
    public static final double WOOD_MASS = 10543.30739107599;
    // public static final double STEEL_MASS = ;

    protected WaterwheelEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, double pComponentMass) {
        super(pType, pPos, pBlockState, pComponentMass);
    }

    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide) {
            if (pState.hasProperty(AbstractTekoraAxialBlock.AXIS)) {
                Direction.Axis axis = pState.getValue(AbstractTekoraAxialBlock.AXIS);
                boolean horizontal = axis.isHorizontal();
                if (horizontal) {
                    BlockPos lPos = axis == Direction.Axis.X ? pPos.north() : pPos.east();
                    BlockPos rPos = axis == Direction.Axis.X ? pPos.south() : pPos.west();
                    double gravity = getGravity(pLevel);

                    BlockState up = pLevel.getBlockState(pPos.above());
                    BlockState leftUp = pLevel.getBlockState(lPos.above());
                    BlockState rightUp = pLevel.getBlockState(rPos.above());
                    double uTheta = 0; // todo double check the math;
                    double force = 0;
                    if (leftUp.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, leftUp.getFluidState()) * gravity * Math.cos(-Math.PI / 4);
                        uTheta = -3 * Math.PI/8;
                    }
                    if (rightUp.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, rightUp.getFluidState()) * gravity * Math.cos(Math.PI / 4);
                        uTheta += 3 * Math.PI/8;
                    }
                    if (up.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, up.getFluidState()) * gravity * Math.cos(uTheta);
                    }

                    BlockState left = pLevel.getBlockState(lPos);
                    BlockState right = pLevel.getBlockState(rPos);
                    if (left.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, left.getFluidState()) * -gravity;
                    }
                    if (right.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, right.getFluidState()) * gravity;
                    }

                    BlockState leftDown = pLevel.getBlockState(lPos.below());
                    BlockState rightDown = pLevel.getBlockState(rPos.below());
                    if (leftDown.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, leftUp.getFluidState()) * gravity * Math.cos(-3 * Math.PI / 4);
                    }
                    if (rightDown.getBlock() instanceof LiquidBlock liquid) {
                        force += massPerBlock(liquid, rightUp.getFluidState()) * gravity * Math.cos(3 * Math.PI / 4);
                    }
                    super.force = force;
                } // the else statement will be dealt with in the future
            }
        }
        super.tick(pLevel, pPos, pState);
    }

    // function may be changed in the future
    private double getGravity(Level level) {
        return 9.80665;
    }

    private double massPerBlock(LiquidBlock liquid, FluidState state) {
        FlowingFluid fluid = liquid.getFluid();
        double densityOver8 = fluid.getFluidType().getDensity() / 8d;
        // amount may need to be optimized for the future, but for now it's good enough.
        return fluid.getAmount(state) * densityOver8;
    }

    @Override
    public double componentRadius() {
        return 1.5;
    }

    public static class Wood extends WaterwheelEntity {
        public Wood(BlockPos pPos, BlockState pBlockState) {
            super(TekoraBlockEntities.WOODEN_WATERWHEEL.get(), pPos, pBlockState, WOOD_MASS);
        }
    }
}
