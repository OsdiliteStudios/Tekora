package net.nukollodda.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.util.TekoraFluidFunctions;

public class TekoraMeltableBlock extends TekoraBaseBlock {
    TekoraFluidData data;
    public TekoraMeltableBlock(float strength, Block material, SoundType sound, TekoraFluidData pData) {
        super(strength, material, sound);
        this.data = pData;
    }

    public TekoraMeltableBlock(float strength, Block material, TekoraFluidData pData) {
        this(strength, material, SoundType.METAL, pData);
    }

    public TekoraMeltableBlock(float strength, TekoraFluidData pData) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL, pData);
    }

    public TekoraMeltableBlock(TekoraFluidData pData) {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL, pData);
    }

    public float getMeltingPoint() {
        return data.getMeltingPoint();
    }
    public float getBoilingPoint(float pPressure) {
        return data.getBoilingPoint(pPressure);
    }

    public TekoraFluidData getFluidData() {
        return data;
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        float biomeTemp = TekoraFluidFunctions.getForgeTemperature(
                pLevel.getBiome(pPos).get().getBaseTemperature());

        ResourceKey<Level> dimension = pLevel.dimension();
        float pressure = TekoraFluidFunctions.OVERWORLD_PRESSURE;
        if (dimension.equals(Level.NETHER)) pressure = TekoraFluidFunctions.NETHER_PRESSURE;
        if (dimension.equals(Level.END)) pressure = TekoraFluidFunctions.END_PRESSURE;

        if (this.getBoilingPoint(pressure) < biomeTemp) {
            int dif = (int)(biomeTemp - this.getBoilingPoint(pressure));
            int rand = (int)(Math.random() * this.data.getFusionHeat() * this.data.getVaporizationHeat()) * dif;
            if (rand == 0) {
                TekoraFluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, this.data, pressure);
                TekoraFluidFunctions.makeBoilingParticles(pLevel, pPos);
            }
        } else if (this.getMeltingPoint() < biomeTemp) {
            int dif = (int)(biomeTemp - this.getMeltingPoint());
            int rand = (int)(Math.random() * this.data.getFusionHeat() * this.data.getSpecificHeat(false)) / (100 + dif);
            LiquidBlock melted = TekoraFluidFunctions.getMelted(this);
            if (rand == 0 && melted != null) {
                pLevel.setBlock(pPos, melted.defaultBlockState(), 3);
            }
        }
    }
}
