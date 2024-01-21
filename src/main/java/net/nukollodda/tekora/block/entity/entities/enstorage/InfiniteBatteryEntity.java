package net.nukollodda.tekora.block.entity.entities.enstorage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;

public class InfiniteBatteryEntity extends BatteryEntity {
    public InfiniteBatteryEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.INFINITE_BATTERY.get(), pPos, pBlockState, 1024);
    }

    @Override
    public void changeEnergy(int pAmount) {
    }

    @Override
    public void tick() {
        super.tick();
        if (maxEnergy() > currentEnergy()) {
            this.ENERGY_STORAGE.setEnergy(maxEnergy());
        }
    }
}
