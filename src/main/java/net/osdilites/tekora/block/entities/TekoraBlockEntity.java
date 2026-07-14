package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import org.jetbrains.annotations.Nullable;

public abstract class TekoraBlockEntity extends BlockEntity implements MenuProvider {
    public TekoraBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        BlockState state = getBlockState();
        return state.getBlock().getName();
    }

    public void drops() {
//        SimpleContainer inv = new SimpleContainer(getInventory());
//        for (int i = 0; i < getInventory().getSlots(); i++) {
//            inv.setItem(i, getInventory().getStackInSlot(i));
//        }
//
//        if (level != null)
//            Containers.dropContents(level, worldPosition, inv);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        //.put("inventory", getInventory().serializeNBT(pRegistries));
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        //getInventory().deserializeNBT(pRegistries, pTag.getCompound("inventory"));
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    public abstract ItemStacksResourceHandler getInventory();
    public abstract void clearContents();
}
