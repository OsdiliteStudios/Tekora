package net.leng.tekora.block.entity.blocks.connecters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.Nullable;

public class ItemPipe extends AbstractPipe {
    public ItemPipe(float strength) {
        super(strength);
    }

    @Override
    protected int getTier() {
        return 0;
    }

    @Override
    protected boolean canConnect(BlockEntity pEntity) {
        return pEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}
