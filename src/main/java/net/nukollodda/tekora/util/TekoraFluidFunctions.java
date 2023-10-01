package net.nukollodda.tekora.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.blocks.TekoraLiquidBlock;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidPresets;
import net.nukollodda.tekora.item.typical.IonicParts;

import java.util.List;

public class TekoraFluidFunctions {
    public static final float END_PRESSURE = 0.895f;
    public static final float NETHER_PRESSURE = 1.121f;
    public static final float OVERWORLD_PRESSURE = 1;

    public static float getTemperatureChangedPerTick(float materialCp, float environmentCp) {
        return materialCp > 0 ? (environmentCp / materialCp) / 35.85f : 0;
        // note: this function auto converts from kelvins to minecraft temperature units
        // also, the inputs needs to be in J/L K
    }

    public static float getMinecraftTemperature(float forgeTemp) {
        return ((forgeTemp - 275.66f) / 16.74f);
    }

    public static float getForgeTemperature(float mcTemp) {
        return 16.74f * mcTemp + 275.66f;
    }

    public static float getSpecificHeatOfWater(boolean isGas) {
        return isGas ? 1.996f : 4170;
    }

    public static float getFusionHeatOfWater() {
        return 333;
    }

    public static float getVaporizationHeatOfWater() {
        return 2250;
    }

    public static float getMeltingPointOfWater() {
        return 273;
    }

    public static float getBoilingPointOfWater(float pressure) {
        return 160 * (float)Math.pow(pressure, 0.348f) + 213;
    }
    public static void makeBoilingParticles(Level pLevel, BlockPos pPos) {
        makeParticles(pLevel, pPos, SoundEvents.GENERIC_BURN, ParticleTypes.CLOUD);
    }

    public static void makeCondensationParticles(Level pLevel, BlockPos pPos, boolean pIsMetal) {
        makeParticles(pLevel, pPos, pIsMetal ? SoundEvents.COPPER_BREAK : SoundEvents.WEATHER_RAIN,
                pIsMetal ? ParticleTypes.ASH : ParticleTypes.RAIN);
    }

    public static void makeHailParticles(Level pLevel, BlockPos pPos, boolean pIsMetal) {
        makeParticles(pLevel, pPos, pIsMetal ? SoundEvents.ELDER_GUARDIAN_CURSE : SoundEvents.PLAYER_HURT_FREEZE,
                pIsMetal ? ParticleTypes.ASH : ParticleTypes.SNOWFLAKE);
    }

    private static void makeParticles(Level pLevel, BlockPos pPos, SoundEvent pSound, ParticleOptions pParticle) {
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
            pLevel.addParticle(pParticle, x0, y0, z0, dx, dy, dz);
        }
        pLevel.playSound((Player)null, pPos, pSound, SoundSource.BLOCKS);
        pLevel.destroyBlock(pPos, false);
    }

    public static void applyBoilingEffectsToEntities(Level pLevel, BlockPos pPos, TekoraFluidType pData, float pPressure) {
        List<LivingEntity> _entfound = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(8 / 2d), e -> true)
                .stream().toList();
        for (LivingEntity ent : _entfound) {
            if (pData.getEffects() != null) {
                for (MobEffect effect : pData.getEffects()) {
                    ent.addEffect(new MobEffectInstance(effect, 1200, (int) pPressure));
                }
            }
            ent.hurt(ent.level().damageSources().generic(), pData.getFluidDmg() * 3);
        }
    }

    public static void applyBoilingEffectsToEntities(Level pLevel, BlockPos pPos, TekoraFluidData pData, float pPressure) {
        List<LivingEntity> _entfound = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(8 / 2d), e -> true)
                .stream().toList();
        for (LivingEntity ent : _entfound) {
            if (pData.getEffects() != null) {
                for (MobEffect effect : pData.getEffects()) {
                    ent.addEffect(new MobEffectInstance(effect, 1200, (int) pPressure));
                }
            }
            ent.hurt(ent.level().damageSources().generic(), pData.getFluidDmg() * 3);
        }
    }

    public static void freezeLiquid(Level pLevel, BlockPos pPos, TekoraLiquidBlock pLiquid) {
        pLevel.setBlock(pPos, pLiquid.getSolidForm().defaultBlockState(), 3);
    }

    public static boolean hasFluidForm(Block pBlock) {
        return getMelted(pBlock) != null;
    }

    public static LiquidBlock getMelted(Block pBlock) {
        String name = pBlock.getDescriptionId().replace("_block", "_fluid")
                .replace("block.tekora.", "");
        ResourceLocation meltedKey = new ResourceLocation(Tekora.MODID, name);
        if (ForgeRegistries.BLOCKS.containsKey(meltedKey) &&
            ForgeRegistries.BLOCKS.getValue(meltedKey) instanceof LiquidBlock liquid) {
            return liquid;
        }
        return null;
    }
}
