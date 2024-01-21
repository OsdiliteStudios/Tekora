package net.nukollodda.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import net.nukollodda.tekora.menu.CompressorMenu;
import net.nukollodda.tekora.recipes.types.CompressionRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class CompressorEntity extends AbstractTekoraMachineEntity<SimpleContainer, CompressionRecipe> {
    protected final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> true;
                case 1 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }};

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

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

    public CompressorEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.COMPRESSOR.get(), pPos, pBlockState, 2);
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

    protected boolean hasHardCodedRecipe() {
        ItemStack result = getHardCodedRecipeResult();
        if (result == null) {
            return false;
        }
        return !result.isEmpty() ||
                !result.getItem().equals(Items.BARRIER);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CompressorMenu(id, inv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("compressor.progress", this.progress);
        tag.putInt("compressor.electricity", energyStorage.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("compressor.progress");
        this.energyStorage.setEnergy(tag.getInt("compressor.electricity"));
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

    public static void tick(Level level, BlockPos pos, BlockState state, CompressorEntity entity) {
        if (level.isClientSide()) {
            return;
        } // if a recipe exists, the tick does something
        if (entity.hasElectricity()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
        } else {
            state = state.setValue(AbstractMachineBlock.LIT, false);
            level.setBlock(pos, state, 3);
        }

        SimpleContainer inv = entity.getContainer();
        Optional<CompressionRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CompressionRecipe.Type.INSTANCE, inv, level);
        if (recipe.isPresent()) {
            CompressionRecipe obtRecipe = recipe.get();
            if ((entity.hasRecipe(obtRecipe, inv) || entity.hasHardCodedRecipe()) && entity.hasEnoughElectricity()) {
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
    protected boolean hasRecipe(CompressionRecipe pRecipe, SimpleContainer pContainer) {
        return canInsertItemIntoOutputSlot(pContainer, pRecipe.getResultItem(level.registryAccess()));
    }

    @Override
    protected void craftItem(CompressionRecipe pRecipe, SimpleContainer pContainer) { // extracts one of the ingredients
        if (hasRecipe(pRecipe, pContainer)) {
            this.itemHandler.setStackInSlot(1, getJsonRecipeOutput(pContainer, level)); // the 1 needs to be replaced by the count
            this.itemHandler.extractItem(0,1, false); // checks the slots to make sure
            this.resetProgress();
        }
        if (hasHardCodedRecipe()) {
            this.itemHandler.setStackInSlot(1, getHardCodedRecipeResult());
            this.itemHandler.extractItem(0,1, false);
            this.resetProgress();
        }
    }

    @Override
    protected SimpleContainer getContainer() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return inv;
    }

    protected ItemStack getHardCodedRecipeResult() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        inv.setItem(0, this.itemHandler.getStackInSlot(0));
        String itemName = inv.getItem(0).getItem().toString();
        String subsec = itemName.contains("_") ? itemName.substring(0, itemName.lastIndexOf('_')) : itemName;
        String path = "ingots/";
        if (Ingredient.of(TekoraTags.Items.INGOTS).test(inv.getItem(0))) {
            path = "plates/";
        }
        TagKey<Item> itemTag = ItemTags.create(new ResourceLocation("forge", path + subsec));
        Ingredient.TagValue items = new Ingredient.TagValue(itemTag);
        ItemStack tagItem = items.getItems().toArray(new ItemStack[0])[0];
        if (!tagItem.getItem().equals(Items.BARRIER) &&
                canInsertItemIntoOutputSlot(inv, tagItem)) {
            tagItem.setCount(this.itemHandler.getStackInSlot(1).getCount() + 1);
            return tagItem;
        }
        return null;
    }

    protected ItemStack getJsonRecipeOutput(SimpleContainer inv, Level level) {
        Optional<CompressionRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CompressionRecipe.Type.INSTANCE, inv, level);
        ItemStack out = recipe.get().getResultItem(level.registryAccess());
        out.setCount(out.getCount() + this.itemHandler.getStackInSlot(1).getCount() + inv.getItem(1).getCount());
        return out; // the 1 needs to be replaced by the count
    }
}
