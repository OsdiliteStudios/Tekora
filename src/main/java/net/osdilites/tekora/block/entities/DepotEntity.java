package net.osdilites.tekora.block.entities;

import java.util.Optional;

import org.jspecify.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
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
import net.osdilites.tekora.menu.DeployerMenu;
import net.osdilites.tekora.menu.DepotMenu;
import net.osdilites.tekora.recipes.DepotRecipe;
import net.osdilites.tekora.recipes.ApplyingRecipe;
import net.osdilites.tekora.recipes.PrintingRecipe;
import net.osdilites.tekora.recipes.TekoraRecipes;
import net.osdilites.tekora.recipes.inputs.DeployingRecipeInput;
import net.osdilites.tekora.recipes.inputs.DepotRecipeInput;

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
        ItemStack itemDeployed = this.inventory.getResource(1).toStack(); // TODO: CHANGE THIS
        ItemStack output = itemToConvert; // TODO: temporary

        // Variables that should be initialized based on instance type
        double ratedVelocity = 0.0;
        var resource = this.inventory.getResource(1); // ??
        boolean hasRecipe = false;

        double cutTorque = 0.0;
        double cutConst = 0.0;

        if (deployer instanceof PrinterMechanicalEntity printer) {
            // TODO: figure out how to fetch info that recipe input requires
            // TODO: fetch exp gain depending on the crafted item
            int exp = 0;
            DeployingRecipeInput input = new DeployingRecipeInput(itemToConvert, itemDeployed, exp);

            // TODO: figure out relevant printer properties besides deployed 
            BlockState printerState = level.getBlockState(printer.getBlockPos());
            // me when i have genuinely made no progress LOL
            // hardcode it ig

            itemDeployed = this.inventory.getResource(1).toStack(); // TODO: CHANGE THIS
            input = new DeployingRecipeInput(itemToConvert, null, exp);

            RecipeManager recipeManager = ((ServerLevel) level).recipeAccess();
            // without the "experience" field in the recipe json file, no recipe matches 
            var printingRecipes = recipeManager.recipeMap().byType(TekoraRecipes.PRINTING_TYPE.get());
            Optional<RecipeHolder<PrintingRecipe>> recipe = Optional.ofNullable(null);
            // TODO: investigate how to get recipe without this ugly loop
            for (RecipeHolder<PrintingRecipe> printRecipe : printingRecipes) {
                // ?
                recipe = Optional.of(printRecipe);
                break;
            }

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
                && (resource.isEmpty() || resource.is(output.getItem()))
                && (resource.isEmpty() ? 64 : output.getMaxStackSize()) 
                >= inventory.getAmountAsInt(1) + output.getCount();

            cutTorque = val.cutTorque();
            cutConst = (torque - cutTorque) / ratedVelocity;

        } else if (deployer instanceof ApplyerMechanicalEntity) {
            // ...similar process to printer, except also maybe change these files:
            // ...
            return 0.0;
        } else {
            System.err.println("Unsupported deployer!");
            return 0.0;
        }
        // ... rest is basically the same as crafting for depot recipes

        boolean canProgress = activeMode && hasRecipe && Math.abs(velocity) >= ratedVelocity;
        if (!canProgress) {
            deployer.decrement(level);
            if (deployer.getHeightPosition() >= 0) {
                this.activeMode = true;
            }
            return 0;
        }

        // TODO: better name needed
        var craftProgress = (torque < 0 ? -1 : 1) * Math.max(0, Math.min(cutTorque, cutTorque + cutConst * Math.abs(velocity)));

        if (!deployer.canCraft(ratedVelocity)) {
            deployer.increment(level);
            return craftProgress;
        }
        
        this.progress += (float) (Math.abs(velocity) / (256 * ratedVelocity));
        if (this.progress >= 1.0f) {
            try (Transaction transaction = Transaction.openRoot()) {
                ItemAccess access = ItemAccess.forHandlerIndex(inventory, 1);
                inventory.extract(inventory.getResource(0), 1, transaction);
                inventory.set(1, ItemResource.of(output), access.getAmount() + output.getCount());
                transaction.commit();
                System.err.println("PRINTING. APPLYING!");
            }
            this.progress = 0;
            deployer.decrement(level);
            this.activeMode = false;
        }
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);

        return craftProgress;
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
