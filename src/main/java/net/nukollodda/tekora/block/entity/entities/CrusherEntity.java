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
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.menu.CrusherMenu;
import net.nukollodda.tekora.recipes.CrushingRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrusherEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) { // temporary
                case 0 -> true;
                case 1 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }};

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    public CrusherEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CRUSHER.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) { // returns the progress
                    case 0 -> CrusherEntity.this.progress;
                    case 1 -> CrusherEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) { // sets progress values
                    case 0 -> CrusherEntity.this.progress = pValue;
                    case 1 -> CrusherEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.crusher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CrusherMenu(id, inv, this, this.data);
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
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        // drops all the contents of this particular block entity

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CrusherEntity entity) {
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

    private static void craftItem(CrusherEntity entity) { // extracts one of the ingredients
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inv.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CrushingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CrushingRecipe.Type.INSTANCE, inv, level);

        if (hasRecipe(entity)) {
            entity.itemHandler.extractItem(0,1, false); // checks the slots to make sure
            entity.itemHandler.setStackInSlot(1, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(),
                    entity.itemHandler.getStackInSlot(1).getCount() + 1)); // the 1 needs to be replaced by the count

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(CrusherEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(entity.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inv.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CrushingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CrushingRecipe.Type.INSTANCE, inv, level);

        Optional<BlastingRecipe> blast; // will be revisited

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inv) &&
                canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inv, ItemStack stack) { // getItem() returns the slot number
        return inv.getItem(1).getItem() == stack.getItem() || inv.getItem(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inv) { // make it so items cap out at 64
        return inv.getItem(1).getMaxStackSize() > inv.getItem(1).getCount();
    }
}
