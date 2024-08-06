package net.tekoramods.tekora.block.entity.blocks.connecters;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Cogs extends AbstractConnector {
    public Cogs(float strength) {
        super(strength);
    }
    // cogs can start from wood or aluminum
    // shafts can be made of steel, ferronickel, chrome ferronickel, and chrome vanasteel.

    @Override
    protected int getShapeIndex(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down) {
        return 0;
    }

    @Override
    protected int getTier() {
        return 0;
    }

    @Override
    protected boolean canConnect(BlockEntity pEntity) {
        return false;
    }

    @Override
    protected VoxelShape makeShape(ConnectorType north, ConnectorType south, ConnectorType west, ConnectorType east, ConnectorType up, ConnectorType down) {
        return null;
    }

    @Override
    public void changeBlockState(BlockState state, Direction direction) {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }
}
