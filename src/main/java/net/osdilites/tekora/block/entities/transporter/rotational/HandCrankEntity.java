package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class HandCrankEntity extends RotationalAbstractEntity {
    public HandCrankEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.HAND_CRANK.get(), pPos, pBlockState);
    }

    // Function used to apply force by the player
    public void applyForce(FoodData data) {
        int hunger = data.getFoodLevel();
        float saturation = data.getSaturationLevel();
        double energy = (hunger + saturation) / 25;
        double speed = Math.abs(body.getVelocity());
        double radius = componentRadius();

        if (energy > 0) {
            double force = 30.0 * (0.25 + 0.75 * energy) * Math.max(0, 1 - 4 * speed / (Math.PI));
            body.addTorque(getBlockPos(), force);

            if (saturation > 0) {
                float foodDrain = (float) (1.5E-5 * force * speed * radius);
                data.addExhaustion(foodDrain);
            }
        }
    }

    @Override
    public double componentRadius() {
        return 0.5;
    }

    @Override
    public double getMoment() {
        return 50; // todo, use recipe to determine moment of inertia
    }
}
