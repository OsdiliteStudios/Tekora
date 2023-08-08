package net.nukollodda.tekora.block.entity.entities.enstorage;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.menu.BatteryMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InfiniteBatteryEntity extends AbstractBatteryEntity {
    public InfiniteBatteryEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.INFINITE_BATTERY.get(), pPos, pBlockState, 1024);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.infinite_battery");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new BatteryMenu(id, inv, this, this.data);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, InfiniteBatteryEntity entity) {
        if (level.isClientSide()) return;
        if (entity.data.get(0) < entity.data.get(1))
            entity.data.set(0, entity.data.get(1));
    }


    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }
}
