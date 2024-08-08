package net.tekoramods.tekora.block.entity.entities.connectors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.tekoramods.tekora.block.entity.blocks.connecters.EnergyCable;
import net.tekoramods.tekora.block.entity.entities.TekoraBlockEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnergyCableFacadeEntity extends EnergyCableEntity {
    private BlockState mimicBlock = null;
    public EnergyCableFacadeEntity(BlockPos pPos, BlockState pBlockState, int pCapacity) {
        super(TekoraBlockEntities.ENERGY_CABLE_FACADE.get(), pPos, pBlockState, pCapacity);
    }

    public EnergyCableFacadeEntity(BlockPos pPos, BlockState pBlockState) {
        this(pPos, pBlockState, 256);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
        super.onDataPacket(net, packet);
        if (level != null && level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            requestModelDataUpdate();
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        saveMimic(tag);
        return ClientboundBlockEntityDataPacket.create(this, entity -> tag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = getUpdateTag();
        saveMimic(tag);
        return tag;
    }

    public BlockState getMimicBlock() {
        return mimicBlock;
    }

    @Override
    public @NotNull ModelData getModelData() {
        return ModelData.builder().with(EnergyCable.FACADE_ID, mimicBlock).build();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        saveMimic(pTag);
    }

    protected void saveMimic(CompoundTag pTag) {
        if (mimicBlock != null) {
            CompoundTag tag = NbtUtils.writeBlockState(mimicBlock);
            tag.put("mimic", pTag);
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.mimicBlock = pTag.contains("mimic") ?
                NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), pTag.getCompound("mimic")) : null;
    }

    public void setMimicBlock(BlockState mimicBlock) {
        this.mimicBlock = mimicBlock;
        setChanged();
        getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS + Block.UPDATE_NEIGHBORS);
    }
}
