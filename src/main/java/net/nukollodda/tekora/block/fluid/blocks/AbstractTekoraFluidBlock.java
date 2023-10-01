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
    public AbstractTekoraFluidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties.noLootTable());
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
                        living.addEffect(new MobEffectInstance(effect, 200, (int) Math.pow(pressure - 1, 2) - 1,
                                true, false, false));
                    }
                }
                if (data.getFluidDmg() > 0) {
                    living.hurt(living.level().damageSources().generic(), data.getFluidDmg());
                }
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
}
