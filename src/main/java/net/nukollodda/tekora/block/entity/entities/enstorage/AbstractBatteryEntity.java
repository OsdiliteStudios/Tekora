package net.nukollodda.tekora.block.entity.entities.enstorage;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.item.containers.Battery;
import net.nukollodda.tekora.util.TekoraEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBatteryEntity extends BlockEntity implements MenuProvider {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return stack.getItem() instanceof Battery; // should always be something that can be charged
        }
    };

    protected final ContainerData data;
    protected final TekoraEnergyStorage ENERGY_STORAGE;
    public AbstractBatteryEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, int maxEnergy) {
        super(pType, pPos, pBlockState);
        this.ENERGY_STORAGE = new TekoraEnergyStorage(maxEnergy, 256) {
            @Override
            public void onEnergyChanged() {
                setChanged();
            }
        };;
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> AbstractBatteryEntity.this.ENERGY_STORAGE.getEnergyStored();
                    case 1 -> AbstractBatteryEntity.this.ENERGY_STORAGE.getMaxEnergyStored();
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                if (pIndex == 0) {
                    AbstractBatteryEntity.this.ENERGY_STORAGE.setEnergy(pValue);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }
    @Override
    public abstract Component getDisplayName();

    @Nullable
    @Override
    public abstract AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer);
}
