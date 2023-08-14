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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.AABB;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;

import java.util.List;
import java.util.function.Supplier;

public class TekoraLiquidBlock extends AbstractTekoraFluidBlock {
    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties, Block pSolid) {
        super(pFluid, pProperties, pSolid);
    }

    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        this(pFluid, pProperties, null);
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

            float bp = getMinecraftTemperature(data.getBoilingPoint(pressure));

            if (biomeTemp >= bp) {
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
                    pLevel.addParticle(ParticleTypes.CLOUD, x0, y0, z0, dx, dy, dz);
                }
                List<LivingEntity> _entfound = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(8 / 2d), e -> true)
                        .stream().toList();
                for (LivingEntity ent : _entfound) {
                    if (data.getEffects() != null) {
                        for (MobEffect effect : data.getEffects()) {
                            ent.addEffect(new MobEffectInstance(effect, 1200, (int) pressure));
                        }
                    }
                    ent.hurt(ent.level().damageSources().generic(), data.getFluidDmg() * 3);
                }
                pLevel.playSound((Player)null, pPos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS);
                pLevel.destroyBlock(pPos, false);
            }
        }
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
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
            float mp = getMinecraftTemperature(data.getMeltingPoint());
            if (biomeTemp < mp && this.solidForm != null && biomeTemp < bp) {
                pLevel.setBlock(pPos, this.solidForm.defaultBlockState(), 3);
            }
        }

        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
    }
}
