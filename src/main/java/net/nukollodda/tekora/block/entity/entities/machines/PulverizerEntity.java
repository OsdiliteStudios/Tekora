package net.nukollodda.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
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
import net.nukollodda.tekora.block.entity.blocks.machines.AbstractMachineBlock;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.entity.entities.machines.types.AbstractTekoraBasicMachineEntity;
import net.nukollodda.tekora.menu.CrusherMenu;
import net.nukollodda.tekora.recipes.types.PulverizingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PulverizerEntity extends AbstractTekoraBasicMachineEntity {
    public PulverizerEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PULVERIZER.get(), pPos, pBlockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CrusherMenu(id, inv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("pulverizer.progress", this.progress);
        tag.putInt("pulverizer.electricity", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("pulverizer.progress");
        this.ENERGY_STORAGE.setEnergy(tag.getInt("pulverizer.electricity"));
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

    public static void tick(Level level, BlockPos pos, BlockState state, PulverizerEntity entity) {
        if (level.isClientSide()) {
            return;
        } // if a recipe exists, the tick does something
        if (entity.hasElectricity()) {
            state = state.setValue(AbstractMachineBlock.LIT, true);
            level.setBlock(pos, state, 3);
        }

        if ((entity.hasRecipe() || entity.hasHardCodedRecipe()) && entity.hasEnoughElectricity()) {
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
    protected boolean hasRecipe() {
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<PulverizingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(PulverizingRecipe.Type.INSTANCE, inv, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inv) &&
                canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }

    @Override
    protected ItemStack getHardCodedRecipeResult() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        inv.setItem(0, this.itemHandler.getStackInSlot(0));
        String itemName = inv.getItem(0).getItem().toString();
        String subsec = itemName.contains("_ingot") || itemName.contains("_piece") || itemName.contains("_gem") ?
                itemName.substring(0, itemName.lastIndexOf('_')) : itemName;
        TagKey<Item> itemTag = ItemTags.create(new ResourceLocation("forge", "dusts/" + subsec));
        Ingredient.TagValue items = new Ingredient.TagValue(itemTag);
        ItemStack tagItem = items.getItems().toArray(new ItemStack[0])[0];
        if (!tagItem.getItem().equals(Items.BARRIER) &&
                canInsertItemIntoOutputSlot(inv, tagItem) && canInsertAmountIntoOutputSlot(inv)) {
            tagItem.setCount(this.itemHandler.getStackInSlot(1).getCount() + 1);
            return tagItem;
        }
        return null;
    }

    @Override
    protected Item getJsonRecipeOutput(SimpleContainer inv, Level level) {
        Optional<PulverizingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(PulverizingRecipe.Type.INSTANCE, inv, level);
        return recipe.get().getResultItem(level.registryAccess()).getItem();
    }
}
