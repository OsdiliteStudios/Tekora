package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractDeployingMachineEntity;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.block.entities.mechanical.ApplyerMechanicalEntity;
import net.osdilites.tekora.block.entities.mechanical.PrinterMechanicalEntity;
import net.osdilites.tekora.menu.DepotMenu;
import net.osdilites.tekora.recipes.*;
import net.osdilites.tekora.recipes.inputs.DeployingRecipeInput;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class DepotEntity extends AbstractModularCraftEntity {
    boolean activeMode = true;

    public DepotEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.DEPOT.get(), pPos, pState);
    }

    protected ItemStacksResourceHandler makeInventory() {
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

    // called in crafting()
    private double deployerCrafting(Level level, AbstractDeployingMachineEntity deployer, String type, double velocity, double torque) {
        ItemStack itemToConvert = this.inventory.getResource(0).toStack();

        // variables dependent on deployer instance
        
        double ratedVelocity = 0.0;
        double cutTorque = 0.0;
        double cutConst = 0.0;
        var resource = this.inventory.getResource(1);
        // "give" the item back in output slot if not set to something else
        ItemStack output = itemToConvert;
        boolean hasRecipe = false;

        if (deployer instanceof PrinterMechanicalEntity printer) {
            int exp = 0; // TODO: what should be done about this
            ItemStack itemDeployed = printer.getStoredItemResource().toStack();

            DeployingRecipeInput input = new DeployingRecipeInput(itemToConvert, itemDeployed, exp);
            
            // TODO: without the "experience" field in printing_test.json, does a recipe match?
            Optional<RecipeHolder<PrintingRecipe>> recipe = 
                getCurrentRecipe(TekoraRecipes.PRINTING_TYPE.get(), input);

            if (!recipe.isPresent()) {
                this.progress = 0;
                deployer.decrement(level);
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                return 0.0;
            }

            PrintingRecipe val = recipe.get().value();
            output = val.assemble(input);
            ratedVelocity = val.ratedVelocity();

            hasRecipe = val.matches(input, level) 
                && (resource.isEmpty() || resource.equals(ItemResource.of(output)))
                && (resource.isEmpty() ? 64 : output.getMaxStackSize()) 
                >= inventory.getAmountAsInt(1) + output.getCount();

            cutTorque = val.cutTorque();
            cutConst = (torque - cutTorque) / ratedVelocity;

        } else if (deployer instanceof ApplyerMechanicalEntity applyer) {
            ItemStack itemDeployed = applyer.getStoredItemResource().toStack();

            DeployingRecipeInput input = new DeployingRecipeInput(itemToConvert, itemDeployed, 0);
            Optional<RecipeHolder<ApplyingRecipe>> recipe = 
                getCurrentRecipe(TekoraRecipes.APPLYING_TYPE.get(), input);
            
            if (!recipe.isPresent()) {
                this.progress = 0;
                deployer.decrement(level);
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                return 0.0;
            }

            ApplyingRecipe val = recipe.get().value();
            output = val.assemble(input);
            ratedVelocity = val.ratedVelocity();

            hasRecipe = val.matches(input, level)
                && (resource.isEmpty() || resource.is(output.getItem()))
                && (resource.isEmpty() ? 64 : output.getMaxStackSize()) 
                >= inventory.getAmountAsInt(1) + output.getCount();
            
            cutTorque = val.cutTorque();
            cutConst = (torque - cutTorque) / ratedVelocity;

        } else {
            System.err.println("Unsupported deployer!");
            return 0.0;
        }

        boolean canProgress = activeMode && hasRecipe && Math.abs(velocity) >= ratedVelocity;
        if (!canProgress) {
            deployer.decrement(level);
            if (deployer.getHeightPosition() >= 0) {
                this.activeMode = true;
            }
            return 0;
        }

        double addedTorque = (torque < 0 ? -1 : 1) * Math.max(0, Math.min(cutTorque, cutTorque + cutConst * Math.abs(velocity)));

        if (!deployer.canCraft(ratedVelocity)) {
            deployer.increment(level);
            return addedTorque;
        }
        
        this.progress += (float) (Math.abs(velocity) / (256 * ratedVelocity));
        if (this.progress >= 1.0f) {
            try (Transaction transaction = Transaction.openRoot()) {
                ItemAccess access = ItemAccess.forHandlerIndex(inventory, 1);
                inventory.extract(inventory.getResource(0), 1, transaction);
                inventory.insert(1, ItemResource.of(output), output.getCount(), transaction);
                transaction.commit();
            }
            this.progress = 0;
            deployer.decrement(level);
            this.activeMode = false;
        }
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);

        return addedTorque;
    }

    protected double crafting(Level level, AbstractModularMachineEntity ent, String type, double velocity, double torque) {
        if (ent instanceof AbstractDeployingMachineEntity deployer) {
            return deployerCrafting(level, deployer, type, velocity, torque);
        }

        DepotRecipeInput input = new DepotRecipeInput(this.inventory.getResource(0).toStack(), type);
        Optional<RecipeHolder<DepotRecipe>> recipe = getCurrentRecipe(TekoraRecipes.DEPOT_TYPE.get(), input);
        if (recipe.isPresent()) {
            DepotRecipe val = recipe.get().value();
            ItemStack output = val.assemble(input);
            double ratedVelocity = val.ratedVelocity();
            var resource = inventory.getResource(1);
            boolean hasRecipe = val.matches(input, level) && (resource.isEmpty() || resource.is(output.getItem()))
                    && (resource.isEmpty() ? 64 : output.getMaxStackSize()) >= inventory.getAmountAsInt(1) + output.getCount();
            if (activeMode && hasRecipe && Math.abs(velocity) >= ratedVelocity) {
                double cutTorque = val.cutTorque();
                double cutConst = (torque - cutTorque) / ratedVelocity;
                if (ent.canCraft(ratedVelocity)) {
                    progress += (float) (Math.abs(velocity) / (256 * ratedVelocity));
                    if (progress >= 1.0f) {
                        try (Transaction transaction = Transaction.openRoot()) {
                            ItemAccess access = ItemAccess.forHandlerIndex(inventory, 1);
                            inventory.extract(inventory.getResource(0), 1, transaction);
                            // TODO: probably should change .set to .insert for safety
                            inventory.set(1, ItemResource.of(output), access.getAmount() + output.getCount());
                            transaction.commit();
                        }
                        progress = 0;
                        ent.decrement(level);
                        activeMode = false;
                    }
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                } else {
                    ent.increment(level);
                }
                return (torque < 0 ? -1 : 1) * Math.max(0, Math.min(cutTorque, cutTorque + cutConst * Math.abs(velocity)));
            } else {
                ent.decrement(level);
            }
            if (ent.getHeightPosition() >= 0) {
                activeMode = true;
            }
        } else {
            progress = 0;
            ent.decrement(level);
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
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
            } else if (block.equals(TekoraBlocks.APPLYER.get())) {
                return Component.translatable("blockfunc.tekora.applyer");
            } else {
                return Component.translatable("block.tekora.depot");
            }
        }
        return Component.translatable("block.tekora.depot");
    }

    public ResourceHandler<ItemResource> getItemHandler(Direction direction) {
        if (direction == null) {
            return this.inventory;
        }
        // todo, restructure the code after implementing directional blockstates for the basin and the depot
        return null;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new DepotMenu(i, inventory, this, this.inventory, data);
    }
}
