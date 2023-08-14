package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidType;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;

import java.util.List;
import java.util.function.Supplier;

public class TekoraGasBlock extends AbstractTekoraFluidBlock {
    protected final LiquidBlock liquidForm;

    public TekoraGasBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties, LiquidBlock pLiquid, Block pSolid) {
        super(pFluid, pProperties, pSolid);
        this.liquidForm = pLiquid;
    }

    public TekoraGasBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties, LiquidBlock pLiquid) {
        this(pFluid, pProperties, pLiquid, null);
    }

    public TekoraGasBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        this(pFluid, pProperties, null, null);
    }

    public LiquidBlock getLiquidForm() {
        return liquidForm;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
            TekoraFluidData data = tekoraFluid.getFluidData();
            ResourceKey<Level> dimension = pLevel.dimension();
            float biomeTemp = pLevel.getBiome(pPos).get().getBaseTemperature();

            float pressure = 1;
            if (dimension.equals(Level.END)) pressure = 0.895f;
            else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

            float bp = getMinecraftTemperature(data.getBoilingPoint(pressure));
            if (biomeTemp < bp) {
                double x = pPos.getX();
                double y = pPos.getY();
                double z = pPos.getZ();
                for (int i = 0; i < 4; i++) {
                    double x0 = x + (4 * Math.random());
                    double y0 = y + (4 * Math.random());
                    double z0 = z + (4 * Math.random());
                    double dx = (4 * Math.random() + 0.5) * 0.5;
                    double dy = (4 * Math.random() + 0.5) * 0.5;
                    double dz = (4 * Math.random() + 0.5) * 0.5;
                    pLevel.addParticle(ParticleTypes.FALLING_WATER, x0, y0, z0, dx, dy, dz);
                }
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }

        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
