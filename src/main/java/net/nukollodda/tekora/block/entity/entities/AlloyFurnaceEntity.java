package net.nukollodda.tekora.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.item.ModItems;
import net.nukollodda.tekora.menu.AlloyFurnaceMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class AlloyFurnaceEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data; // this data is being sent to the menu
    private int progress = 0;
    private int maxProgress = 45;

    public AlloyFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ALLOY_FURNACE.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) { // returns the progress
                    case 0 -> AlloyFurnaceEntity.this.progress;
                    case 1 -> AlloyFurnaceEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) { // sets progress values
                    case 0 -> AlloyFurnaceEntity.this.progress = pValue;
                    case 1 -> AlloyFurnaceEntity.this.maxProgress = pValue;
                };

            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Alloy Furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new AlloyFurnaceMenu(id, inv, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        // drops all the contents of this particular block entity

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AlloyFurnaceEntity entity) {
        if (level.isClientSide()) {
            return;
        } // if a recipe exists, the tick does something

        if (hasRecipe(entity)) {
            entity.progress++;
            setChanged(level, pos, state);

            if (entity.progress > entity.maxProgress) { // crafts the item
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(AlloyFurnaceEntity entity) { // extracts one of the ingrediants
        if (hasRecipe(entity)) {
            entity.itemHandler.extractItem(1,1, false); // checks the slots to make sure
            // slot organization, slot 1 = coal input, slot 2-4 = item inputs, slot 5 = output, for the electric variant, slot 1 = residue
            entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.GRAPHITE_DUST.get(),
                    entity.itemHandler.getStackInSlot(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(AlloyFurnaceEntity entity) {
        SimpleContainer inv = new SimpleContainer(entity.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inv.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        boolean hasIngred = true; // if the recipe was shaped, there'd be only one variable
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) { // the i value and max will change as a result of there only being 3 input slots
            if (entity.itemHandler.getStackInSlot(i).getItem() != ModItems.GRAPHITE_DUST.get() ||
                    entity.itemHandler.getStackInSlot(i).getItem() != Items.IRON_INGOT) {
                hasIngred = false;
                break;
            }
        }

        return hasIngred && canInsertAmountIntoOutputSlot(inv) &&
                canInsertItemIntoOutputSlot(inv, new ItemStack(ModItems.STEEL_INGOT.get(), 1));
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inv, ItemStack stack) { // getItem() returns the slot number
        return inv.getItem(2).getItem() == stack.getItem() || inv.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inv) { // make it so items cap out at 64
        return inv.getItem(2).getMaxStackSize() > inv.getItem(2).getCount();
    }

}
