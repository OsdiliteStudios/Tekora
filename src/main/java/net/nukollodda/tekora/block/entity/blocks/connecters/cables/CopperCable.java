package net.nukollodda.tekora.block.entity.blocks.connecters.cables;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CopperCable extends AbstractEnergyCable {

    public CopperCable() {
        super(3f, 16219222);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}
