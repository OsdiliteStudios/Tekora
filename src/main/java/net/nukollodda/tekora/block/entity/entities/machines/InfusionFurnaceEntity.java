package net.nukollodda.tekora.block.entity.entities.machines;

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
import net.minecraft.world.item.crafting.BlastingRecipe;
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
import net.nukollodda.tekora.block.WrappedHandler;
import net.nukollodda.tekora.block.entity.blocks.machines.AlloyFurnace;
import net.nukollodda.tekora.block.entity.entities.machines.types.AbstractTekoraFurnaceEntity;
import net.nukollodda.tekora.menu.InfusionFurnaceMenu;
import net.nukollodda.tekora.recipes.types.InfusionRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;


public class InfusionFurnaceEntity extends AbstractTekoraFurnaceEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) { // temporary
                case 0 -> FurnaceBlockEntity.isFuel(stack);
                case 1, 2 -> true;
                case 3 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<WrappedHandler>> directionHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 4, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(0, s))),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 4, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(2, s))),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(0, s))));

    public InfusionFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.INFUSION_FURNACE.get(), pos, blockState, 4);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.infusion_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new InfusionFurnaceMenu(id, inv, this, this.data);
    }
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();

            if (directionHandlerMap.containsKey(side)) {
                Direction local = this.getBlockState().getValue(AlloyFurnace.FACING);
                if (side == Direction.UP || side == Direction.DOWN) {
                    return directionHandlerMap.get(side).cast();
                }
                return switch (local) {
                    case NORTH -> directionHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionHandlerMap.get(side.getClockWise()).cast();
                    case WEST -> directionHandlerMap.get(side.getCounterClockWise()).cast();
                    default -> directionHandlerMap.get(side).cast();
                };
            }
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
        tag.putInt("infusion_furnace.progress", this.progress);
        tag.putInt("infusion_furnace.fuel", this.fuel);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("infusion_furnace.progress");
        this.fuel = tag.getInt("infusion_furnace.fuel");
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        // drops all the contents of this particular block entity

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, InfusionFurnaceEntity entity) {
        if (level.isClientSide()) {
            return;
        } // if a recipe exists, the tick does something

        ItemStack itemFuel = new ItemStack(entity.itemHandler.getStackInSlot(0).getItem());

        if (entity.hasRecipe()) {
            if (FurnaceBlockEntity.isFuel(itemFuel) && entity.fuel == 0) {
                entity.maxFuel = ForgeHooks.getBurnTime(itemFuel, RecipeType.BLASTING);
                entity.fuel = entity.maxFuel;
                entity.itemHandler.extractItem(0, 1, false);
            }

            if (entity.fuel > 0) {
                entity.progress++;
                entity.fuel--;
            }
            setChanged(level, pos, state);

            if (entity.progress > entity.maxProgress) { // crafts the item
                entity.craftItem();
            }

        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
            if (entity.fuel > 0) {
                entity.fuel--;
            }
        }
    }

    protected void resetProgress() {
        this.progress = 0;
    }

    protected void craftItem() { // extracts one of the ingredients
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<InfusionRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(InfusionRecipe.Type.INSTANCE, inv, level);

        if (this.hasRecipe()) {
            this.itemHandler.extractItem(1, recipe.get().getInputAmount(), false); // checks the slots to make sure
            this.itemHandler.extractItem(2, recipe.get().getCatalystAmount(), false);
            // slot organization, slot 0 = coal input, slot 1-2 = item inputs, slot 3 = output, for the electric variant, slot 1 = residue
            this.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(),
                    this.itemHandler.getStackInSlot(3).getCount() + 1)); // the 1 needs to be replaced by the count

            this.resetProgress();
        }
    }

    protected boolean hasRecipe() {
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<InfusionRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(InfusionRecipe.Type.INSTANCE, inv, level);

        Optional<BlastingRecipe> blast; // will be revisited

        return recipe.isPresent() && this.canInsertAmountIntoOutputSlot(inv) &&
                this.canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }

}
