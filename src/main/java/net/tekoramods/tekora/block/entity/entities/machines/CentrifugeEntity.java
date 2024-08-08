package net.tekoramods.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tekoramods.tekora.block.WrappedHandler;
import net.tekoramods.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.tekoramods.tekora.block.entity.blocks.machines.Centrifuge;
import net.tekoramods.tekora.block.entity.entities.TekoraBlockEntities;
import net.tekoramods.tekora.block.entity.entities.machines.types.AbstractTekoraMachineEntity;
import net.tekoramods.tekora.menu.CentrifugeMenu;
import net.tekoramods.tekora.recipes.types.CentrifugeRecipe;
import net.tekoramods.tekora.recipes.types.ItemFluidContainer;
import net.tekoramods.tekora.util.UtilFunctions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CentrifugeEntity extends AbstractTekoraMachineEntity<ItemFluidContainer, CentrifugeRecipe> {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged(); // if a change happens to this block, the block gets reloaded
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1 -> true;
                case 2, 3, 4, 5 -> false;
                case 6, 7, 8, 9 -> stack.getItem() instanceof BucketItem item && item.getFluid().equals(Fluids.EMPTY);
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();
    private final FluidTank inputFluidTank = new FluidTank(64000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };

    private final FluidTank fluidTank1 = new FluidTank(32000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };
    private final FluidTank fluidTank2 = new FluidTank(32000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };
    private final FluidTank fluidTank3 = new FluidTank(32000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };
    private final FluidTank fluidTank4 = new FluidTank(32000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
        }
    };
    // in these set of lambdas,
    // 'i' stands for either slot id or index
    // 's' stands for slot
    private final Map<Direction, LazyOptional<WrappedHandler>> directionHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 4, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(3, s))),

                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 4, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 1, (i, s) -> itemHandler.isItemValid(1, s))),

                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(2, s))),

                    Direction.UP, LazyOptional.of(() -> new WrappedHandler(itemHandler,
                            (i) -> i == 2, (i, s) -> itemHandler.isItemValid(0, s))));
    /*
     * "north" is always going to be the away side
     * "south" is always going to be the side facing the player
     * "east" is always the right
     * "west" is always the left
     *
     * the second statement always determines whether we can or can't extract from a certain slot
     */

    public CentrifugeEntity(BlockPos pos, BlockState blockState) {
        super(TekoraBlockEntities.CENTRIFUGE.get(), pos, blockState, 10);
    }

    public void setInputFluid(FluidStack fluid) {
        this.inputFluidTank.setFluid(fluid);
    }

    public FluidStack getInputFluid() {
        return this.inputFluidTank.getFluid();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CentrifugeMenu(id, inv, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();

            if (directionHandlerMap.containsKey(side)) {
                Direction local = this.getBlockState().getValue(Centrifuge.FACING);
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
        lazyFluidHandler = LazyOptional.of(() -> inputFluidTank);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("centrifuge.progress", this.progress);
        tag.putInt("centrifuge.electricity", energyStorage.getEnergyStored());
        tag = inputFluidTank.writeToNBT(tag);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("centrifuge.progress");
        this.energyStorage.setEnergy(tag.getInt("centrifuge.electricity"));
        this.inputFluidTank.readFromNBT(tag);
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
    public static void tick(Level level, BlockPos pos, BlockState state, CentrifugeEntity entity) {
        if (level.isClientSide()) {
            return;
        }
        ItemFluidContainer inv = entity.getContainer();
        Optional<CentrifugeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CentrifugeRecipe.Type.INSTANCE, inv, level);
        if (recipe.isPresent()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
            CentrifugeRecipe obtRecipe = recipe.get();
            if (entity.hasRecipe(obtRecipe, inv) && entity.hasEnoughElectricity()) {
                entity.progress++;
                entity.energyStorage.extractEnergy(ENERGY_REQ, false);
                setChanged(level, pos, state);
                if (entity.progress > entity.maxProgress) { // crafts the item
                    entity.craftItem(obtRecipe, inv);
                }
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    @Override
    protected void craftItem(CentrifugeRecipe pRecipe, ItemFluidContainer pContainer) { // extracts one of the ingredients
        if (this.hasRecipe(pRecipe, pContainer)) {
            this.itemHandler.extractItem(1, pRecipe.getInputCount(), false);
            this.inputFluidTank.drain(pRecipe.getRecipeFluidAmt(), IFluidHandler.FluidAction.EXECUTE);
            NonNullList<ItemStack> outputs = NonNullList.of(ItemStack.EMPTY, pRecipe.getLightest(), pRecipe.getMidLight(),
                    pRecipe.getMidHeavy(), pRecipe.getHeaviest());
            List<Float> prob = pRecipe.getOutputProbabilities(); // will be checked in the future
            for (int i = 2, ind = 0; i < 5; i++) {
                ItemStack item = outputs.get(ind);
                ItemStack itemOfInd = this.itemHandler.getStackInSlot(i);
                if (itemOfInd.is(item.getItem()) || itemOfInd.isEmpty()) {
                    item.setCount(item.getCount() + itemOfInd.getCount());
                    this.itemHandler.setStackInSlot(i, item);
                }
                ind++;
                if (ind >= outputs.size()) break;
            }

            this.resetProgress();
        }
        if (this.hasFluidItemInSourceSlot()) {
            this.transferItemFluidToFluidTank();
        }
    }

    private void transferItemFluidToFluidTank() {
        this.itemHandler.getStackInSlot(0).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(handler -> {
            int drainAmt = Math.min(this.inputFluidTank.getSpace(), 1000);
            FluidStack stack = handler.drain(drainAmt, IFluidHandler.FluidAction.SIMULATE);
            if (this.inputFluidTank.isFluidValid(stack)) {
                stack = handler.drain(drainAmt, IFluidHandler.FluidAction.EXECUTE);
                this.fillTankWithFluid(stack, handler.getContainer());
            }
        });
    }

    private void fillTankWithFluid(FluidStack stack, ItemStack container) {
        int temp = stack.getFluid().getFluidType().getTemperature();
        if (this.level != null) {
            this.level.playSound(null, this.worldPosition,
                    temp > 798 ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY, SoundSource.AMBIENT);
        }
        this.inputFluidTank.fill(stack, IFluidHandler.FluidAction.EXECUTE);
        this.itemHandler.extractItem(0, 1, false);
        this.itemHandler.insertItem(0, container, false);
    }

    private boolean hasFluidItemInSourceSlot() {
        return this.itemHandler.getStackInSlot(0).getCount() > 0;
    }

    @Override
    protected boolean hasRecipe(CentrifugeRecipe pRecipe, ItemFluidContainer pContainer) {
        return this.canInsertItemsIntoOutputSlots(pContainer, List.of(pRecipe.getLightest(), pRecipe.getMidLight(),
                pRecipe.getMidHeavy(), pRecipe.getHeaviest())) /*&&
                this.canInsertFluidsIntoOutputFluids(recipe.get().getFluidOutputs())*/;
    }

    @Override
    protected ItemFluidContainer getContainer() {
        ItemFluidContainer inv = new ItemFluidContainer(5, 5);
        for (int i = 1; i < 6; i++) {
            inv.addItem(this.itemHandler.getStackInSlot(i));
        }
        inv.addFluid(this.inputFluidTank.getFluid());
        inv.addFluid(this.fluidTank1.getFluid());
        inv.addFluid(this.fluidTank2.getFluid());
        inv.addFluid(this.fluidTank3.getFluid());
        inv.addFluid(this.fluidTank4.getFluid());
        return inv;
    }

    private boolean canInsertItemsIntoOutputSlots(ItemFluidContainer inv, final List<ItemStack> items) {
        boolean[] validStatements = new boolean[items.size()];
        for (int i = 1; i < 5; i++) {
            for (int j = i - 1; j < items.size(); j++) {
                ItemStack item = items.get(j);
                validStatements[j] = inv.getItem(i).getCount() + item.getCount() <= item.getMaxStackSize() ||
                        inv.getItem(i).isEmpty();
            }
        }
        return UtilFunctions.countTrueValues(validStatements) >= items.size();
    }

    private boolean canInsertFluidsIntoOutputFluids(final List<FluidStack> fluids) {
        ArrayList<FluidStack> entFluids = new ArrayList<>();
        entFluids.add(this.fluidTank1.getFluid());
        entFluids.add(this.fluidTank2.getFluid());
        entFluids.add(this.fluidTank3.getFluid());
        entFluids.add(this.fluidTank4.getFluid());
        boolean[] validStatements = new boolean[fluids.size()];
        for (int i = 2; i < 6; i++) {
            for (int j = i - 2; j < fluids.size(); j++) {
                FluidStack fluid = fluids.get(j);
                validStatements[j] = entFluids.get(i).getAmount() + fluid.getAmount() <= 32000 ||
                        entFluids.get(i).isEmpty();
            }
        }
        return UtilFunctions.countTrueValues(validStatements) >= fluids.size();
    }
}
