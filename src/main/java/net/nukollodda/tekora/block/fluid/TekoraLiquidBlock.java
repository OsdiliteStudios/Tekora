package net.nukollodda.tekora.block.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class TekoraLiquidBlock extends LiquidBlock {
    private float temperature;
    private float storedEnergy;
    public TekoraLiquidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        /*
         * The temperature of the biome along should make the block either freeze or disappear
         * the properties of the block will cause entities get effects in the liquid
         */
        ResourceKey<Level> dimension = pLevel.dimension();
        float biomeTemp = (pLevel.getBiome(pPos).get().getBaseTemperature() / 35.85f) - 0.15f;
        float pressure = 1;
        float dimensionCp = 0.82f;
        // this will also be set to whatever the biome gas composition is

        if (dimension.equals(Level.END)) pressure = 0.895f;
        else if (dimension.equals(Level.NETHER)) pressure = 1.121f;

        FluidType fluid = this.getFluid().getFluidType();
        if (fluid instanceof TekoraFluidType tekoraFluid) {
            TekoraFluidData data = tekoraFluid.getFluidData();
            float bp = getMinecraftTemperature(data.getBoilingPoint(pressure));
            float mp = getMinecraftTemperature(data.getMeltingPoint());
            float cp = getTemperatureChangedPerTick(tekoraFluid.getSpecificHeat(), dimensionCp);
            if (this.temperature < 7.465f) {
                this.temperature = getMinecraftTemperature(pLevel.getBiome(pPos).get().getBaseTemperature());
            } else if (this.temperature > bp - cp && this.temperature < bp + cp &&
                    this.storedEnergy < data.getVaporizationHeat()) {
                this.storedEnergy += dimensionCp;
            } else if (this.temperature > mp - cp && this.temperature < mp + cp &&
                    this.storedEnergy < data.getFusionHeat()) {
                this.storedEnergy += dimensionCp;
            } else if (this.storedEnergy == 0) {
                if (this.temperature > biomeTemp + cp) {
                    this.temperature -= cp;
                } else if (this.temperature < biomeTemp - cp) {
                    this.temperature += cp;
                }
            }
            boolean canEvaporate = bp >= biomeTemp && !tekoraFluid.isGas();
            boolean canLiquefy = bp <= biomeTemp && mp >= biomeTemp && data.getLiquidForm() != null && tekoraFluid.isGas();
            boolean canSolidify = mp < biomeTemp && data.getSolidForm() != null;
            List<LivingEntity> _entfound = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(32 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(pPos.getX(), pPos.getY(), pPos.getZ()))).toList();
            for (LivingEntity ent : _entfound) {
                if (data.getEffects() != null) {
                    for (MobEffect effect : data.getEffects()) {
                        ent.addEffect(new MobEffectInstance(effect, 5, (int) pressure));
                        ent.hurt(ent.level().damageSources().generic(), data.getFluidDmg());
                    }
                }
            }
            if (canEvaporate) {
                this.storedEnergy = 0;
                double x = pPos.getX();
                double y = pPos.getY();
                double z = pPos.getZ();
                for (int i = 0; i < 4; i++) {
                    double x0 = x + (4 * Math.random());
                    double y0 = y + (4 * Math.random());
                    double z0 = z + (4 * Math.random());
                    double dx = (4 * Math.random() - 0.5) * 0.5;
                    double dy = (4 * Math.random() - 0.5) * 0.5;
                    double dz = (4 * Math.random() - 0.5) * 0.5;
                    pLevel.addParticle(ParticleTypes.CLOUD, x0, y0, z0, dx, dy, dz);
                }
                pLevel.playSound((Player)null, pPos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS);
                pLevel.destroyBlock(pPos, false);
            } else if (canSolidify) {
                this.storedEnergy = 0;
                pLevel.setBlock(pPos, data.getSolidForm().defaultBlockState(), 3);
            } else if (canLiquefy) {
                this.storedEnergy = 0;
                pLevel.setBlock(pPos, data.getLiquidForm().defaultBlockState(), 3);
            }
            // all entities in a fluid will take damage and be effected by the designated effects
        }

        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    public static float getTemperatureChangedPerTick(float materialCp, float environmentCp) {
        return materialCp > 0 ? (environmentCp / materialCp) / 35.85f : 0;
        // note: this function auto converts from kelvins to minecraft temperature units
        // also, the inputs needs to be in J/L K
    }

    public static float getMinecraftTemperature(float forgeTemp) {
        return (forgeTemp / 35.85f) - 7.465f;
    }

    // note: forge temperature is in kelvins
    public static float getForgeTemperature(float mcTemp) {
        return 35.85f * (mcTemp + 7.465f);
    }
}
