package net.osdilites.tekora.block.entities.transporter.rotational;

import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class SuperCrankEntity extends HandCrankEntity {

    public SuperCrankEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.SUPER_CRANK.get(), pPos, pBlockState);
    }

    public void applyForce(FoodData data) {
        // default value
        applyForce(data, 6000000.0);
    }
}
