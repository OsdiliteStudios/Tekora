package net.tekoramods.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tekoramods.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.tekoramods.tekora.block.entity.entities.TekoraBlockEntities;
import net.tekoramods.tekora.block.entity.entities.machines.types.AbstractTekoraBasicMachineEntity;
import net.tekoramods.tekora.menu.PulverizerMenu;
import net.tekoramods.tekora.recipes.types.ExtrusionRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ExtruderEntity extends AbstractTekoraBasicMachineEntity<ExtrusionRecipe> {
    public ExtruderEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.EXTRUDER.get(), pPos, pBlockState);
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new PulverizerMenu(id, inv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("extruder.progress", this.progress);
        tag.putInt("extruder.electricity", energyStorage.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("extruder.progress");
        this.energyStorage.setEnergy(tag.getInt("extruder.electricity"));
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

    public static void tick(Level level, BlockPos pos, BlockState state, ExtruderEntity entity) {
        if (level.isClientSide()) {
            return;
        }
        SimpleContainer inv = entity.getContainer();
        Optional<ExtrusionRecipe> recipe = entity.getRecipe(inv);
        if (recipe.isPresent()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
            ExtrusionRecipe obtRecipe = recipe.get();
            if (entity.hasRecipe(obtRecipe, inv) && entity.hasEnoughElectricity()) {
                entity.progress++;
                entity.energyStorage.extractEnergy(ENERGY_REQ, false);
                setChanged(level, pos, state);
                if (entity.progress > entity.maxProgress) {
                    entity.craftItem(obtRecipe, inv);
                }
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    @Override
    protected boolean hasRecipe(ExtrusionRecipe pRecipe, SimpleContainer pContainer) {
        return canInsertItemIntoOutputSlot(pContainer, pRecipe.getResultItem(level.registryAccess()))
                && canInsertAmountIntoResidueSlot(pContainer);
    }

    @Override
    protected SimpleContainer getContainer() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return inv;
    }

    @Override
    protected Optional<ExtrusionRecipe> getRecipe(SimpleContainer pContainer) {
        return level.getRecipeManager().getRecipeFor(ExtrusionRecipe.Type.INSTANCE, pContainer, level);
    }

    protected ItemStack getJsonRecipeOutput(SimpleContainer inv, Level level) {
        Optional<ExtrusionRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ExtrusionRecipe.Type.INSTANCE, inv, level);
        ItemStack result = recipe.get().getResultItem(level.registryAccess());
        result.setCount(result.getCount() + inv.getItem(2).getCount());
        return result;
    }

    protected ItemStack getJsonRecipeResidue(SimpleContainer inv, Level level) {
        return ItemStack.EMPTY;
    }
}
