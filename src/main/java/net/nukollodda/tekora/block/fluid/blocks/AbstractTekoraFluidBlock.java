package net.nukollodda.tekora.block.fluid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;

import java.util.function.Supplier;

public abstract class AbstractTekoraFluidBlock extends LiquidBlock {
    protected float temperature;
    protected float storedEnergy;
    protected final Block solidForm;

    public AbstractTekoraFluidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties, Block pSolid) {
        super(pFluid, pProperties.noLootTable());
        this.solidForm = pSolid;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getStoredEnergy() {
        return storedEnergy;
    }

    public Block getSolidForm() {
        return solidForm;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity living) {
            if (this.getFluid().getFluidType() instanceof TekoraFluidType tekoraFluid) {
                TekoraFluidData data = tekoraFluid.getFluidData();
                ResourceKey<Level> dimension = pLevel.dimension();

                float pressure = 1;
                if (dimension.equals(Level.END)) pressure = 0.895f;
                else if (dimension.equals(Level.NETHER)) pressure = 1.121f;
                if (data.getEffects() != null) {
                    for (MobEffect effect : data.getEffects()) {
                        living.addEffect(new MobEffectInstance(effect, 200, (int) Math.pow(pressure - 1, 2) - 1));
                    }
                }
                living.hurt(living.level().damageSources().generic(), data.getFluidDmg());
                if (data.getMeltingPoint() > 700) {
                    living.setSecondsOnFire((int) data.getMeltingPoint() / 200);
                }
            } else {
                if (this.getFluid().getFluidType().getTemperature() > 700) {
                    living.setSecondsOnFire(this.getFluid().getFluidType().getTemperature() / 200);
                }
            }
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
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
