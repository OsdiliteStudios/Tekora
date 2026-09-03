package net.osdilites.tekora.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.AbstractModularCraftEntity;
import net.osdilites.tekora.block.entities.BasinEntity;

public class BasinMenu extends TekoraItemMenu {
    public final BasinEntity blockEntity;

    public BasinMenu(int containerId, Inventory inventory, BlockEntity blockEntity, ItemStacksResourceHandler handler, ContainerData data) {
        super(TekoraMenus.BASIN_MENU.get(), containerId, inventory, data);
        this.blockEntity = (BasinEntity) blockEntity;

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 52, 11) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof BucketItem;
            }
        });
        addSlot(new ResourceHandlerSlot(handler, handler::set, 1, 52, 55) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof BucketItem bucket && bucket.content == Fluids.EMPTY;
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addSlot(new ResourceHandlerSlot(handler, handler::set, i * 3 + j + 2, 97 + i * 18, 15 + j * 18));
            }
        }

        addDataSlots(data);
    }

    public BasinMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()), new ItemStacksResourceHandler(11), new SimpleContainerData(3));
    }

    @Override
    protected int teInventorySlotCount() {
        return 11;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, TekoraBlocks.BASIN.get());
    }

    public float getProgress() {
        return blockEntity.getProgress();
    }
}
