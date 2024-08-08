package net.tekoramods.tekora.block.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.fluid.TekoraChemicalFluidType;
import net.tekoramods.tekora.fluid.data.TekoraFluidData;
import net.tekoramods.tekora.util.FluidFunctions;

import java.util.function.Supplier;

public class TekoraLiquidBlock extends AbstractTekoraFluidBlock {
    protected final ResourceLocation solidForm;
    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid, String pLoc) {
        super(pFluid, BlockBehaviour.Properties.copy(Blocks.WATER));
        this.solidForm = new ResourceLocation(pLoc);
    }

    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid) {
        this(pFluid, "");
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (this.getFluid().getFluidType() instanceof TekoraChemicalFluidType tekoraFluid) {
            TekoraFluidData data = tekoraFluid.getFluidData();
            ResourceKey<Level> dimension = pLevel.dimension();
            float areaTemp = FluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature()) + pLevel.getLightEmission(pPos) / 15f;

            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (areaTemp >= data.getBoilingPoint(pressure)) {
                FluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, data, pressure);
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
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
        if (this.getFluid().getFluidType() instanceof TekoraChemicalFluidType tekoraFluid) {
            ResourceKey<Level> dimension = pLevel.dimension();
            float areaTemp = FluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature()) + pLevel.getLightEmission(pPos) / 15f;
            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (tekoraFluid.getBoilingPoint(pressure) < areaTemp) {
                onBoil(pLevel, pPos, tekoraFluid, pressure);
            } else  {
                int dif = (int)(tekoraFluid.getMeltingPoint() - areaTemp);
                int fusTimesSpec = (int)(tekoraFluid.getFusionHeat() * tekoraFluid.getSpecificHeat());
                if (dif > 0 && pState.hasProperty(LEVEL) && pState.getValue(LEVEL) == 0) {
                    int bound = fusTimesSpec / (100 + dif);
                    if (bound > 0) {
                        int rand = pRandom.nextInt(bound);
                        if (rand == 0) {
                            freezeLiquid(pLevel, pPos);
                        }
                    } else {
                        freezeLiquid(pLevel, pPos);
                    }
                }
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    protected void onBoil(Level pLevel, BlockPos pPos, TekoraChemicalFluidType pType, float pPressure) {
        FluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, pType, pPressure);
        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
    }

    public Block getSolidForm() {
        if (ForgeRegistries.BLOCKS.containsKey(solidForm)) {
            return ForgeRegistries.BLOCKS.getValue(solidForm);
        }
        return Blocks.AIR;
    }

    public LiquidBlock getGas() {
        if (this.getFluid().getFluidType() instanceof TekoraChemicalFluidType tekoraFluid) {
            ResourceLocation meltedKey = new ResourceLocation(Tekora.MODID, tekoraFluid.getFluidData().getGasName());
            if (ForgeRegistries.BLOCKS.containsKey(meltedKey) &&
                    ForgeRegistries.BLOCKS.getValue(meltedKey) instanceof LiquidBlock liquid
                    && !liquid.equals(this)) {
                return liquid;
            }
        }
        return null;
    }

    private void freezeLiquid(Level pLevel, BlockPos pPos) {
        pLevel.setBlock(pPos, getSolidForm().defaultBlockState(), 3);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        // acidity and electronegativity stuff will be involved here for itemstacks
    }
}
