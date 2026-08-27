package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.menu.DepotMenu;
import net.osdilites.tekora.recipes.*;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class DepotEntity extends AbstractModularCraftEntity {
    public DepotEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.DEPOT.get(), pPos, pState);
    }

    // meaning of each index in the inventory
    // 0 = input
    // 1 = output
    protected ItemStacksResourceHandler makeHandler() {
        return new ItemStacksResourceHandler(2) {
            @Override
            protected void onContentsChanged(int index, ItemStack previousContents) {
                super.onContentsChanged(index, previousContents);
                DepotEntity.this.setChanged();
                if(level != null && !level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }
        };
    }

    @Override
    protected double startCutting(double velocity, double torque) {
        DepotRecipeInput input = new DepotRecipeInput(this.handler.getResource(0).toStack());
        Optional<RecipeHolder<CuttingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.CUTTING_TYPE.get(), input);
        return crafting(recipe, input, velocity, torque);
    }

    @Override
    protected double startCrushing(double velocity, double torque) {
        DepotRecipeInput input = new DepotRecipeInput(this.handler.getResource(0).toStack());
        Optional<RecipeHolder<CrushingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.CRUSHING_TYPE.get(), input);
        return crafting(recipe, input, velocity, torque);
    }

    @Override
    protected double startPressing(double velocity, double torque) {
        DepotRecipeInput input = new DepotRecipeInput(this.handler.getResource(0).toStack());
        Optional<RecipeHolder<PressingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.PRESSING_TYPE.get(), input);
        return crafting(recipe, input, velocity, torque);
    }

    @Override
    protected double startPrinting(double velocity, double torque) {
        DepotRecipeInput input = new DepotRecipeInput(this.handler.getResource(0).toStack());
        Optional<RecipeHolder<PrintingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.PRINTING_TYPE.get(), input);
        return crafting(recipe, input, velocity, torque);
    }

    @Override
    protected double startMixing(double velocity, double torque) {
        return 0; // does nothing here
    }

    private <T extends TekoraMechanicalRecipe<DepotRecipeInput>> double crafting(Optional<RecipeHolder<T>> recipe, DepotRecipeInput input, double velocity, double torque) {
        if (recipe.isPresent()) { // error, recipe not read
            System.out.println("1"); // todo remove debug
            T val = recipe.get().value();
            ItemStack output = val.assemble(input);
            double ratedVelocity = val.ratedVelocity();
            var resource = handler.getResource(1);
            boolean hasRecipe = level != null && val.matches(input, level) && (resource.isEmpty() || resource.is(output.getItem()))
                    && (resource.isEmpty() ? 64 : output.getMaxStackSize()) >= handler.getAmountAsInt(1) + output.getCount();
            System.out.println(hasRecipe); // todo remove debug
            if (hasRecipe && Math.abs(velocity) >= ratedVelocity) {
                double cutTorque = val.cutTorque();
                double cutConst = (torque - cutTorque) / ratedVelocity;
                progress++;
                setChanged(level, getBlockPos(), getBlockState());
                if (progress == MAX_PROGRESS) {
                    try (Transaction transaction = Transaction.openRoot()) {
                        ItemAccess access = ItemAccess.forHandlerIndex(handler, 1);
                        handler.extract(handler.getResource(0), 1, transaction);
                        handler.set(1, ItemResource.of(output), access.getAmount() + output.getCount());
                        transaction.commit();
                    }
                    progress = 0;
                }
                return (torque < 0 ? -1 : 1) * Math.max(0, Math.min(cutTorque, cutTorque + cutConst * Math.abs(velocity)));
            }
        } else {
            progress = 0;
        }
        return 0;
    }

    @Override
    public Component getDisplayName() {
        Level level = getLevel();
        if (level != null) {
            Block block = level.getBlockState(getBlockPos().above()).getBlock();
            if (block.equals(TekoraBlocks.CRUSHER.get())) {
                return Component.translatable("blockfunc.tekora.crusher");
            } else if (block.equals(TekoraBlocks.PRESS.get())) {
                return Component.translatable("blockfunc.tekora.presser");
            } else if (block.equals(TekoraBlocks.PRINTER.get())) {
                return Component.translatable("blockfunc.tekora.printer");
            } else if (block.equals(TekoraBlocks.CUTTER.get())) {
                return Component.translatable("blockfunc.tekora.cutter");
            } else {
                return Component.translatable("block.tekora.depot");
            }
        }
        return Component.translatable("block.tekora.depot");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new DepotMenu(i, inventory, this, data);
    }
}
