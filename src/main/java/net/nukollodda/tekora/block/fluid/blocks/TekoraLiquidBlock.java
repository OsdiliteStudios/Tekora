package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.util.FluidFunctions;

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
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
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
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
            ResourceKey<Level> dimension = pLevel.dimension();
            float areaTemp = FluidFunctions.getForgeTemperature(
                    pLevel.getBiome(pPos).get().getBaseTemperature()) + pLevel.getLightEmission(pPos) / 15f;
            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            if (tekoraFluid.getBoilingPoint(pressure) < areaTemp) {
                onBoil(pLevel, pPos, tekoraFluid, pressure);
            } else if (tekoraFluid.getMeltingPoint() > areaTemp
                    && pState.hasProperty(LiquidBlock.LEVEL) && pState.getValue(LiquidBlock.LEVEL) == 0) {
                int dif = (int)(areaTemp - tekoraFluid.getMeltingPoint());
                int rand = pRandom.nextInt((int)(tekoraFluid.getFusionHeat() * tekoraFluid.getSpecificHeat()) / (100 + dif));
                if (rand == 0) {
                    freezeLiquid(pLevel, pPos);
                }
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    protected void onBoil(Level pLevel, BlockPos pPos, TekoraFluidType pType, float pPressure) {
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
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
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
