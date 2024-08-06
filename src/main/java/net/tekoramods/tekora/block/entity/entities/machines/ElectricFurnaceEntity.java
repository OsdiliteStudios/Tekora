package net.tekoramods.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.ItemStackHandler;
import net.tekoramods.tekora.block.WrappedHandler;
import net.tekoramods.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.tekoramods.tekora.block.entity.blocks.machines.ElectricFurnace;
import net.tekoramods.tekora.block.entity.entities.TekoraBlockEntities;
import net.tekoramods.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import net.tekoramods.tekora.menu.ElectricFurnaceMenu;
import net.tekoramods.tekora.recipes.types.ElectricBlastingRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class ElectricFurnaceEntity extends AbstractTekoraMachineEntity<SimpleContainer, ElectricBlastingRecipe> {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 1 -> false;
                case 0 -> true;
                default -> super.isItemValid(slot, stack);
            };
        }
    };
    private final Map<Direction, LazyOptional<WrappedHandler>> directionHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 0, (i, s) -> itemHandler.isItemValid(0, s))),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 0, (i, s) -> itemHandler.isItemValid(0, s))),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 0, (i, s) -> itemHandler.isItemValid(0, s))),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 0, (i, s) -> itemHandler.isItemValid(0, s))));

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    public ElectricFurnaceEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.ELECTRIC_FURNACE.get(), pPos, pBlockState, 2);
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
        lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
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
        tag.putInt("electric_furnace.electricity", energyStorage.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("electric_furnace.progress");
        energyStorage.setEnergy(tag.getInt("electric_furnace.electricity"));
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

        SimpleContainer inv = entity.getContainer();
        Optional<ElectricBlastingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ElectricBlastingRecipe.Type.INSTANCE, inv, level);
        Optional<BlastingRecipe> blasting = level.getRecipeManager()
                .getRecipeFor(RecipeType.BLASTING, inv, level);
        if (recipe.isPresent()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
            ElectricBlastingRecipe obtRecipe = recipe.get();
            if (entity.hasRecipe(obtRecipe, inv) && entity.hasEnoughElectricity()) {
                entity.progress++;
                entity.energyStorage.extractEnergy(ENERGY_REQ, false);
                setChanged(level, pos, state);
                if (entity.progress > entity.maxProgress) {
                    entity.craftItem(obtRecipe, inv);
                }
            }
        } else if (blasting.isPresent()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
            BlastingRecipe obtRecipe = blasting.get();
            if (entity.level != null &&
                    entity.canInsertItemIntoOutputSlot(inv, obtRecipe.getResultItem(level.registryAccess()))) {
                entity.progress++;
                entity.energyStorage.extractEnergy(ENERGY_REQ, false);
                setChanged(level, pos, state);
                if (entity.progress > entity.maxProgress && entity.level != null &&
                            entity.canInsertItemIntoOutputSlot(inv, obtRecipe.getResultItem(level.registryAccess()))) {
                    entity.itemHandler.extractItem(0,1, false);
                    entity.itemHandler.setStackInSlot(1, new ItemStack(obtRecipe.getResultItem(level.registryAccess()).getItem(),
                            entity.itemHandler.getStackInSlot(1).getCount() + 1));

                    entity.resetProgress();
                }
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new ElectricFurnaceMenu(id, inv, this, this.data);
    }

    @Override
    protected void craftItem(ElectricBlastingRecipe pRecipe, SimpleContainer pContainer) {
        if (this.hasRecipe(pRecipe, pContainer)) {
            this.itemHandler.extractItem(0,1, false);
            this.itemHandler.setStackInSlot(1, new ItemStack(pRecipe.getResultItem(level.registryAccess()).getItem(),
                    this.itemHandler.getStackInSlot(1).getCount() + 1));

            this.resetProgress();
        }
    }

    @Override
    protected boolean hasRecipe(ElectricBlastingRecipe pRecipe, SimpleContainer pContainer) {
        return this.level != null &&
                this.canInsertItemIntoOutputSlot(pContainer, pRecipe.getResultItem(level.registryAccess()));
    }

    @Override
    protected SimpleContainer getContainer() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return inv;
    }
}
