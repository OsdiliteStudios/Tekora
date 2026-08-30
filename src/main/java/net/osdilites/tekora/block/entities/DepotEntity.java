package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
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

    protected double crafting(Level level, String type, double velocity, double torque) {
        DepotRecipeInput input = new DepotRecipeInput(this.handler.getResource(0).toStack(), type);
        Optional<RecipeHolder<DepotRecipe>> recipe = getCurrentRecipe(TekoraRecipes.DEPOT_TYPE.get(), input);
        if (recipe.isPresent()) {
            DepotRecipe val = recipe.get().value();
            ItemStack output = val.assemble(input);
            double ratedVelocity = val.ratedVelocity();
            var resource = handler.getResource(1);
            boolean hasRecipe = val.matches(input, level) && (resource.isEmpty() || resource.is(output.getItem()))
                    && (resource.isEmpty() ? 64 : output.getMaxStackSize()) >= handler.getAmountAsInt(1) + output.getCount();
            if (hasRecipe /*&& Math.abs(velocity) >= ratedVelocity*/) {
                double cutTorque = val.cutTorque();
                double cutConst = (torque - cutTorque) / ratedVelocity;
                if (progress == 1.0f) {
                    try (Transaction transaction = Transaction.openRoot()) {
                        ItemAccess access = ItemAccess.forHandlerIndex(handler, 1);
                        handler.extract(handler.getResource(0), 1, transaction);
                        handler.set(1, ItemResource.of(output), access.getAmount() + output.getCount());
                        transaction.commit();
                    }
                    progress = 0;
                    setChanged();
                    return 0;
                }
                progress += 0.015625f; // todo, make this physically motivated
                setChanged();
                return (torque < 0 ? -1 : 1) * Math.max(0, Math.min(cutTorque, cutTorque + cutConst * Math.abs(velocity)));
            }
        } else {
            progress = 0;
            setChanged(level, getBlockPos(), getBlockState());
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
