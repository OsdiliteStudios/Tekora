package net.tekoramods.tekora.block.entities.attachment;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import org.jetbrains.annotations.NotNull;

public class ItemOutputEntity extends ItemTransportEntity {
    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return super.isItemValid(slot, stack);
        }
    };

    public ItemOutputEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.ITEM_OUTPUT_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.item_output_block");
    }

    @Override
    public ItemStackHandler getInventory() {
        return inventory;
    }
}
