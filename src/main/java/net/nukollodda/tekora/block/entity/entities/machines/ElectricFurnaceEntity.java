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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.ItemStackHandler;
import net.nukollodda.tekora.block.WrappedHandler;
import net.nukollodda.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.nukollodda.tekora.block.entity.blocks.machines.ElectricFurnace;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import net.nukollodda.tekora.item.TekoraItems;
import net.nukollodda.tekora.item.mixtures.Residue;
import net.nukollodda.tekora.menu.ElectricFurnaceMenu;
import net.nukollodda.tekora.recipes.types.ElectricBlastingRecipe;
import net.nukollodda.tekora.util.TekoraResidualExtraction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ElectricFurnaceEntity extends AbstractTekoraMachineEntity {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) { // temporary
                case 0, 2 -> false;
                case 1 -> true;
                default -> super.isItemValid(slot, stack);
            };
        }
    };
    private final Map<Direction, LazyOptional<WrappedHandler>> directionHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))));

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    public ElectricFurnaceEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.ELECTRIC_FURNACE.get(), pPos, pBlockState, 3);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();

            if (directionHandlerMap.containsKey(side)) {
                Direction local = this.getBlockState().getValue(ElectricFurnace.FACING);
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
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("electric_furnace.progress", this.progress);
        tag.putInt("electric_furnace.electricity", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("electric_furnace.progress");
        ENERGY_STORAGE.setEnergy(tag.getInt("electric_furnace.electricity"));
    }

    public void drops() {
        if (this.level != null) {
            SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                inv.setItem(i, itemHandler.getStackInSlot(i));
            }
            Containers.dropContents(this.level, this.worldPosition, inv);
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ElectricFurnaceEntity entity) {
        if (level.isClientSide()) {
            return;
        }

        if (entity.hasElectricity()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
        }

        if (entity.hasRecipe() && entity.hasEnoughElectricity(entity)) {
            entity.progress++;
            entity.ENERGY_STORAGE.extractEnergy(ENERGY_REQ, false);
            setChanged(level, pos, state);
            if (entity.progress > entity.maxProgress) { // crafts the item
                entity.craftItem();
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.electric_blast_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new ElectricFurnaceMenu(id, inv, this, this.data);
    }

    protected void craftItem() { // extracts one of the ingredients
        Level level = this.level;
        if (level == null) return;

        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        inv.setItem(1, this.itemHandler.getStackInSlot(1));

        Optional<ElectricBlastingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ElectricBlastingRecipe.Type.INSTANCE, inv, level);

        if (this.hasRecipe()) {
            this.itemHandler.extractItem(1,1, false);
            this.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(),
                    this.itemHandler.getStackInSlot(2).getCount() + 1));

            ItemStack zerothItem = this.itemHandler.getStackInSlot(0);
            if ((zerothItem.getItem() instanceof Residue || zerothItem.isEmpty()) &&
                    TekoraResidualExtraction.recipeHasIons(recipe.get()) && TekoraResidualExtraction.areIonsMergeable(zerothItem, recipe.get())) {
                this.itemHandler.setStackInSlot(0,
                        TekoraResidualExtraction.residualIonMerger(zerothItem, recipe.get()));
            } else if (zerothItem.isEmpty()) {
                Residue residue = TekoraItems.RESIDUE.get();
                ItemStack residual = new ItemStack(residue);
                residual = residue.setIons(residual, recipe.get().getCations(), recipe.get().getAnions());
                this.itemHandler.setStackInSlot(0, residual);
            }

            this.resetProgress();
        }
    }

    protected boolean hasRecipe() {
        Level level = this.level;
        if (level == null) return false;

        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots()); // makes an inventory from the block
        inv.setItem(1, this.itemHandler.getStackInSlot(1));

        Optional<ElectricBlastingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ElectricBlastingRecipe.Type.INSTANCE, inv, level);

        return recipe.isPresent() && this.canInsertAmountIntoOutputSlot(inv) &&
                this.canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }
}
