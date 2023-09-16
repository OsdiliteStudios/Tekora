package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.nukollodda.tekora.block.entity.entities.connectors.EnergyCableEntity;
import org.jetbrains.annotations.Nullable;

public class EnergyCable extends AbstractCable {
    protected final int color;

    private final int capacity;
    private final int maxCapacity;
    /* Blockstate idea
     * 64 possible values
     * represented this way:
     * 000000 or 111111 or anywhere in between
     * the first three protrudes in to the negatives
     * the second three goes in to the positives
     */

    public EnergyCable(float strength, int color, int capacity, int maxCapacity) {
        super(strength);
        this.color = color;
        this.capacity = capacity;
        this.maxCapacity = maxCapacity;
    }

    public int getColor() {
        return color;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EnergyCableEntity(pPos, pState, capacity, maxCapacity);
    }

    protected BlockState setDirExtensions(Level pLevel, BlockPos pPos, BlockState pState, BlockPos pNeighbor) {
        BlockEntity entity = pLevel.getBlockEntity(pNeighbor);
        if (entity != null && entity.getCapability(ForgeCapabilities.ENERGY).isPresent()) {
            int difX = pNeighbor.getX() - pPos.getX();
            int difY = pNeighbor.getY() - pPos.getY();
            int difZ = pNeighbor.getZ() - pPos.getZ();
            int prevVal = pState.getValue(EXTENSIONS);
            int finVal = 0;
            /* notes about the dif vars
             * if difX is neg, neighbor has a greater X
             */
            if (difX < 0) {
                finVal = prevVal | 32; // 10 0000
            } else if (difY < 0) {
                finVal = prevVal | 16; // 01 0000
            } else if (difZ < 0) {
                finVal = prevVal | 8; // 00 1000
            } else if (difX > 0) {
                finVal = prevVal | 4; // 00 0100
            } else if (difY > 0) {
                finVal = prevVal | 2; // 00 0010
            } else if (difZ > 0) {
                finVal = prevVal | 1; // 00 0001
            }
            pState = pState.setValue(EXTENSIONS, finVal);
            pLevel.setBlock(pPos, pState, 3);
        }
        return pState;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return pLevel.isClientSide() ? null : (lvl, pos, state, entity) -> ((EnergyCableEntity)entity).tick();
    }
}
