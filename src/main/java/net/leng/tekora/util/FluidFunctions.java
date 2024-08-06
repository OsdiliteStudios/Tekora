package net.leng.tekora.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.leng.tekora.fluid.TekoraChemicalFluidType;
import net.leng.tekora.fluid.data.TekoraFluidData;
import org.checkerframework.checker.units.qual.A;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class FluidFunctions {
    public static final float END_PRESSURE = 0.895f;
    public static final float NETHER_PRESSURE = 1.121f;
    public static final float OVERWORLD_PRESSURE = 1;
    private static final Random RANDOM_VAL = new Random();

    public static float getTemperatureChangedPerTick(float materialCp, float environmentCp) {
        return materialCp > 0 ? (environmentCp / materialCp) / 35.85f : 0;
        // note: this function auto converts from kelvins to minecraft temperature units
        // only used for pipes in Tekora
    }

    public static float getMinecraftTemperature(float forgeTemp) {
        return ((forgeTemp - 275.66f) / 16.74f);
    }

    public static float getForgeTemperature(float mcTemp) {
        return 16.74f * mcTemp + 275.66f;
    }

    public static String getDisplayedTemperature(float forgeTemp) {
        return ": " + (forgeTemp - 273) + "C/" + (int)((forgeTemp - 255.22f) * 1.8f) + "F";
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
    public static void makeBoilingParticles(Level pLevel, BlockPos pPos) { // fluid needs a clientside effect
        makeParticles(pLevel, pPos, SoundEvents.GENERIC_BURN, ParticleTypes.CLOUD);
    }

    public static void makeParticles(Level pLevel, BlockPos pPos, SoundEvent pSound, ParticleOptions pParticle) {
        double x = pPos.getX();
        double y = pPos.getY();
        double z = pPos.getZ();
        for (int i = 0; i < 25; i++) {
            double x0 = x + RANDOM_VAL.nextInt(-2,2);
            double y0 = y + RANDOM_VAL.nextInt(-2,2);
            double z0 = z + RANDOM_VAL.nextInt(-2,2);
            double dx = RANDOM_VAL.nextDouble(0.5,4.5) * 0.5;
            double dy = RANDOM_VAL.nextDouble(0.5,4.5) * 0.5;
            double dz = RANDOM_VAL.nextDouble(0.5,4.5) * 0.5;
            pLevel.addParticle(pParticle, x0, y0, z0, dx, dy, dz);
        }
        pLevel.playSound((Player)null, pPos, pSound, SoundSource.BLOCKS);
    }

    public static void applyBoilingEffectsToEntities(Level pLevel, BlockPos pPos, TekoraChemicalFluidType pData, float pPressure) {
        List<LivingEntity> entities = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(4), e -> true);
        for (LivingEntity ent : entities) {
            if (pData.getEffects() != null) {
                for (MobEffect effect : pData.getEffects()) {
                    ent.addEffect(new MobEffectInstance(effect, 1200, (int) pPressure,
                            true, false, false));
                }
            }
            ent.hurt(ent.level().damageSources().generic(), pData.getFluidDmg() * 3);
        }
    }

    public static void applyBoilingEffectsToEntities(Level pLevel, BlockPos pPos, TekoraFluidData pData, float pPressure) {
        List<LivingEntity> entities = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(4), e -> true);
        for (LivingEntity ent : entities) {
            if (pData.getEffects() != null) {
                for (MobEffect effect : pData.getEffects()) {
                    ent.addEffect(new MobEffectInstance(effect, 1200, (int) pPressure,
                            true, false, false));
                }
            }
            ent.hurt(ent.level().damageSources().generic(), pData.getFluidDmg() * 3);
        }
    }

    public static boolean containerMatchFluid(ItemStack pContainer, FluidStack pFluid, int tankNum) {
        AtomicBoolean bool = new AtomicBoolean(false);
        pContainer.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(handler -> {
            FluidStack fluid = handler.getFluidInTank(tankNum);
            if (pFluid.isEmpty() || fluid.getFluid().equals(pFluid.getFluid())) {
                bool.set(true);
            }
        });
        return bool.get();
    }

    /** Credit to Kaupenjoe for the functions below
     */
    public static FluidStack readFluid(JsonObject json) {
        return json != null ? FluidStack.CODEC.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst() : FluidStack.EMPTY;
    }

    public static JsonElement toJson(FluidStack stack) {
        return FluidStack.CODEC.encodeStart(JsonOps.INSTANCE, stack).result().orElseThrow();
    }
}
