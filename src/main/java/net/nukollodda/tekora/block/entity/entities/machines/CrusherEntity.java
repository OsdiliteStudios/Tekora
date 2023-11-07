package net.nukollodda.tekora.block.entity.entities.machines;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
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
import net.nukollodda.tekora.datagen.tags.TekoraTags;
import net.nukollodda.tekora.menu.CrusherMenu;
import net.nukollodda.tekora.recipes.types.CrushingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrusherEntity extends AbstractTekoraBasicMachineEntity implements MenuProvider {
    public CrusherEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.CRUSHER.get(), pPos, pBlockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CrusherMenu(id, inv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("crusher.progress", this.progress);
        tag.putInt("crusher.electricity", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("crusher.progress");
        this.ENERGY_STORAGE.setEnergy(tag.getInt("crusher.electricity"));
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

    public static void tick(Level level, BlockPos pos, BlockState state, CrusherEntity entity) {
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
    protected Item getJsonRecipeOutput(SimpleContainer inv, Level level) {
        Optional<CrushingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CrushingRecipe.Type.INSTANCE, inv, level);
        return recipe.get().getResultItem(level.registryAccess()).getItem(); // the 1 needs to be replaced by the count
    }

    protected boolean hasRecipe() {
        Level level = this.level;
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots()); // makes an inventory from the block
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        Optional<CrushingRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(CrushingRecipe.Type.INSTANCE, inv, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inv) &&
                canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem(level.registryAccess()));
    }

    protected ItemStack getHardCodedRecipeResult() { // this method will also exist for pulverizers, metal cutters, ect.
        // there may be a better way to do this...
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        inv.setItem(0, this.itemHandler.getStackInSlot(0));
        String itemName = inv.getItem(0).getItem().toString();
        String subsec = itemName.contains("_ingot") ? itemName.substring(0, itemName.lastIndexOf('_')) : itemName;
        TagKey<Item> itemTag = ItemTags.create(new ResourceLocation("forge",
                (Ingredient.of(TekoraTags.Items.INGOTS).test(inv.getItem(0)) ? "plates/" : "dusts/") + subsec));
        Ingredient.TagValue items = new Ingredient.TagValue(itemTag);
        ItemStack tagItem = items.getItems().toArray(new ItemStack[0])[0];
        if (!tagItem.getItem().equals(Items.BARRIER) &&
                canInsertItemIntoOutputSlot(inv, tagItem) && canInsertAmountIntoOutputSlot(inv)) {
            tagItem.setCount(this.itemHandler.getStackInSlot(1).getCount() + 1);
            return tagItem;
        }
        return null;
    }
}
