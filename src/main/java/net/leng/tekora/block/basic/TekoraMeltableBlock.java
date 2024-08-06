package net.leng.tekora.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import net.leng.tekora.Tekora;
import net.leng.tekora.fluid.data.TekoraFluidData;
import net.leng.tekora.util.FluidFunctions;

public class TekoraMeltableBlock extends TekoraBaseBlock {
    private final TekoraFluidData data;
    private final String fluid;
    public TekoraMeltableBlock(float strength, Block material, SoundType sound, TekoraFluidData pData, String pModid) {
        super(strength, material, sound);
        this.data = pData;
        this.fluid = pModid + ":" + pData.getLiquidName();
    }

    public TekoraMeltableBlock(float strength, Block material, SoundType sound, TekoraFluidData pData) {
        this(strength, material, sound, pData, Tekora.MODID);
    }

    public TekoraMeltableBlock(float strength, Block material, TekoraFluidData pData, String pModid) {
        this(strength, material, SoundType.METAL, pData, pModid);
    }

    public TekoraMeltableBlock(float strength, Block material, TekoraFluidData pData) {
        this(strength, material, SoundType.METAL, pData, Tekora.MODID);
    }

    public TekoraMeltableBlock(float strength, TekoraFluidData pData, String pModid) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL, pData, pModid);
    }

    public TekoraMeltableBlock(float strength, TekoraFluidData pData) {
        this(strength, Blocks.IRON_BLOCK, SoundType.METAL, pData, Tekora.MODID);
    }

    public TekoraMeltableBlock(TekoraFluidData pData, String pModid) {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL, pData, pModid);
    }

    public TekoraMeltableBlock(TekoraFluidData pData) {
        this(5f, Blocks.IRON_BLOCK, SoundType.METAL, pData, Tekora.MODID);
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
        float biomeTemp = FluidFunctions.getForgeTemperature(
                pLevel.getBiome(pPos).get().getBaseTemperature());

        ResourceKey<Level> dimension = pLevel.dimension();
        float pressure = FluidFunctions.OVERWORLD_PRESSURE;
        if (dimension.equals(Level.NETHER)) pressure = FluidFunctions.NETHER_PRESSURE;
        if (dimension.equals(Level.END)) pressure = FluidFunctions.END_PRESSURE;

        if (this.getBoilingPoint(pressure) < biomeTemp) {
            int dif = (int)(biomeTemp - this.getBoilingPoint(pressure));
            int rand = pRandom.nextInt((int)(this.data.getFusionHeat() * this.data.getVaporizationHeat() / (100 + dif)));
            if (rand == 0) {
                FluidFunctions.applyBoilingEffectsToEntities(pLevel, pPos, this.data, pressure);
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            }
        } else {
            double dif = (biomeTemp - this.getMeltingPoint());
            if (this.getMeltingPoint() < biomeTemp && dif > 0) {
                int value = (int)((this.data.getFusionHeat() * this.data.getSpecificHeat(false)) / (100 + dif));
                int rand = pRandom.nextInt(Math.max(value, 1));
                LiquidBlock melted = getMelted();
                if (rand == 0 && melted != null) {
                    pLevel.setBlock(pPos, melted.defaultBlockState(), 3);
                }
            }
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float biomeTemp = FluidFunctions.getForgeTemperature(
                pLevel.getBiome(pPos).get().getBaseTemperature());

        ResourceKey<Level> dimension = pLevel.dimension();
        float pressure = FluidFunctions.OVERWORLD_PRESSURE;
        if (dimension.equals(Level.NETHER)) pressure = FluidFunctions.NETHER_PRESSURE;
        if (dimension.equals(Level.END)) pressure = FluidFunctions.END_PRESSURE;

        if (this.getBoilingPoint(pressure) < biomeTemp) {
            int dif = (int)(biomeTemp - this.getBoilingPoint(pressure));
            int rand = (int)(Math.random() * this.data.getFusionHeat() * this.data.getVaporizationHeat() * dif);
            if (rand == 0) {
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    protected boolean hasFluidForm() {
        return getMelted() != null;
    }

    protected LiquidBlock getMelted() {
        ResourceLocation meltedKey = new ResourceLocation(this.fluid);
        if (ForgeRegistries.BLOCKS.containsKey(meltedKey) &&
                ForgeRegistries.BLOCKS.getValue(meltedKey) instanceof LiquidBlock liquid) {
            return liquid;
        }
        return null;
    }
}
