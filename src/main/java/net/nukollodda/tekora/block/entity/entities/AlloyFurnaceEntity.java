package net.nukollodda.tekora.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.block.entity.entities.types.AbstractTekoraFurnaceEntity;
import net.nukollodda.tekora.menu.AlloyFurnaceMenu;
import net.nukollodda.tekora.recipes.AlloyingRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;


public class AlloyFurnaceEntity extends AbstractTekoraFurnaceEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) { // temporary
                case 0 -> FurnaceBlockEntity.isFuel(stack);
                case 1, 2, 3 -> true;
                case 4 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    /*
    * "north" is always going to be the away side
    * "south" is always going to be the side facing the player
    * "east" is always the right
    * "west" is always the left
    *
    * the second statement always determines whether we can or can't extract from a certain slot
    */

    public AlloyFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ALLOY_FURNACE.get(), pos, blockState, 5);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.alloy_furnace");
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
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
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

        ItemStack itemFuel = new ItemStack(entity.itemHandler.getStackInSlot(0).getItem());

        if (entity.fuel > 0)
            entity.fuel--;

        if (entity.hasRecipe()) {
            if (FurnaceBlockEntity.isFuel(itemFuel) && entity.fuel == 0) {
                entity.maxFuel = ForgeHooks.getBurnTime(itemFuel, RecipeType.BLASTING);
                entity.fuel = entity.maxFuel;
                entity.itemHandler.extractItem(0, 1, false);
            }

            if (entity.fuel > 0) {
                entity.progress++;
            }
            setChanged(level, pos, state);

            if (entity.progress > entity.maxProgress) { // crafts the item
                entity.craftItem();
            }

        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    protected void craftItem() { // extracts one of the ingredients
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<AlloyingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AlloyingRecipe.Type.INSTANCE, inv, level);

        if (this.hasRecipe()) {
            for (int i = 1; i < this.itemHandler.getSlots(); i++) {
                this.itemHandler.extractItem(i, 1, false);
            }
            // slot organization, slot 0 = coal input, slot 1-2 = item inputs, slot 3 = output, for the electric variant, slot 1 = residue
            this.itemHandler.setStackInSlot(this.containerSize - 1, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(),
                    this.itemHandler.getStackInSlot(this.containerSize - 1).getCount() + recipe.get().getResultItem(level.registryAccess()).getCount())); // the 1 needs to be replaced by the count

            this.resetProgress();
        }
    }

    protected boolean hasRecipe() {
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<AlloyingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AlloyingRecipe.Type.INSTANCE, inv, level);

        return recipe.isPresent() && this.canInsertAmountIntoOutputSlot(inv) &&
                this.canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }
}
