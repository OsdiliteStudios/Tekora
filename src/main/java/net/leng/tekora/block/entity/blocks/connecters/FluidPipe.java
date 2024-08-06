package net.leng.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.Nullable;

public class FluidPipe extends AbstractPipe {
    public FluidPipe(float strength, int color) {
        super(strength);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Override
    protected boolean canConnect(BlockEntity pEntity) {
        return pEntity.getCapability(ForgeCapabilities.FLUID_HANDLER).isPresent();
    }

    @Override
    protected int getTier() {
        return 0;
    }
    /* Tekora Pipe list:
     * Glass - all fluids below 800K
     * Steel - noncorrosive fluids below 1300K
     * Bronze - all fluids below 1300K
     * mechanical - dusts
     */
}
