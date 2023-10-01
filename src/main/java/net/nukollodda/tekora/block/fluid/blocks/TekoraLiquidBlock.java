package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.util.TekoraFluidFunctions;

import java.util.function.Supplier;

public class TekoraLiquidBlock extends AbstractTekoraFluidBlock {
    protected final Block solidForm;
    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid, Block pSolid) {
        super(pFluid, BlockBehaviour.Properties.copy(Blocks.WATER));
        this.solidForm = pSolid;
    }

    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid) {
        this(pFluid, null);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
            TekoraFluidData data = tekoraFluid.getFluidData();
            ResourceKey<Level> dimension = pLevel.dimension();
            float biomeTemp = pLevel.getBiome(pPos).get().getBaseTemperature();

            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            float bp = TekoraFluidFunctions.getMinecraftTemperature(data.getBoilingPoint(pressure));

            if (biomeTemp >= bp) {
                TekoraFluidFunctions.makeBoilingParticles(pLevel, pPos);
                TekoraFluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, data, pressure);
            }
        }
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        tick(pState, pLevel, pPos, pRandom);
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
            ResourceKey<Level> dimension = pLevel.dimension();
            float biomeTemp = TekoraFluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature());
            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (tekoraFluid.getBoilingPoint(pressure) < biomeTemp) {
                TekoraFluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, tekoraFluid, pressure);
                TekoraFluidFunctions.makeBoilingParticles(pLevel, pPos);
            } else if (tekoraFluid.getMeltingPoint() > biomeTemp
                    && pState.hasProperty(LiquidBlock.LEVEL) && pState.getValue(LiquidBlock.LEVEL) == 0) {
                int dif = (int)(biomeTemp - tekoraFluid.getMeltingPoint());
                int rand = (int)(Math.random() * tekoraFluid.getFusionHeat() * tekoraFluid.getSpecificHeat()) / (100 + dif);
                if (rand == 0) {
                    TekoraFluidFunctions.freezeLiquid(pLevel, pPos, this);
                }
            }
        }
    }

    public Block getSolidForm() {
        return solidForm;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public float getTemperature(Level pLevel, BlockPos pPos, int pPressure) {
        if (pLevel != null & !pLevel.isClientSide && this.getFluid().getFluidType() instanceof TekoraFluidType type) {
            float biomeTemp = pLevel.getBiome(pPos).get().getBaseTemperature();
            if (biomeTemp < type.getMeltingPoint()) {
                return type.getMeltingPoint();
            } else return Math.min(biomeTemp, type.getBoilingPoint(pPressure));
        }
        return this.getFluid().getFluidType().getTemperature();
    }
}
