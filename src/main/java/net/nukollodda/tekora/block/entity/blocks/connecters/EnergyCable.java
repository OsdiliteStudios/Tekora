package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.nukollodda.tekora.block.entity.entities.connectors.EnergyCableEntity;
import org.jetbrains.annotations.Nullable;

public class EnergyCable extends AbstractCable {
    protected final int color;

    private final int capacity;

    public EnergyCable(float strength, int color, int capacity) {
        super(strength);
        this.color = color;
        this.capacity = capacity;
    }

    protected int getCapacity() {
        return capacity;
    }

    public int getColor() {
        return color;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EnergyCableEntity(pPos, pState, capacity);
    }

    @Override
    protected int getTier() {
        int value = this.capacity / 256;
        int count = 1;
        while (value > 1) {
            count++;
            value /= 2;
        }
        return count;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return pLevel.isClientSide() ? null : (lvl, pos, state, entity) -> ((EnergyCableEntity)entity).tick();
    }
}
