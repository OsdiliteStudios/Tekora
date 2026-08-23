package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.menu.BasinMenu;
import net.osdilites.tekora.recipes.CompressingRecipe;
import net.osdilites.tekora.recipes.MacerationRecipe;
import net.osdilites.tekora.recipes.MixingRecipe;
import net.osdilites.tekora.recipes.TekoraRecipes;
import net.osdilites.tekora.recipes.inputs.BasinRecipeInput;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasinEntity extends AbstractModularCraftEntity {
    private final FluidStacksResourceHandler tank = new FluidStacksResourceHandler(1, 8000) {
        @Override
        protected void onContentsChanged(int index, FluidStack previousContents) {
            setChanged();
            Level lvl = getLevel();
            if (lvl != null && !lvl.isClientSide()) {
                lvl.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isValid(int index, FluidResource resource) {
            return true;
        }
        // todo, for this value allow fluids to "mix", the "mixing" process may trigger a chemical reaction so keep that in mind on every tick.
    };

    public BasinEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.BASIN.get(), pPos, pState);
    }

    // meaning of each index in the inventory
    // 0 = fluid container input
    // 1 = fluid container output
    // 2-10 = items...
    protected ItemStacksResourceHandler makeHandler() {
        return new ItemStacksResourceHandler(11) {
            @Override
            protected void onContentsChanged(int index, ItemStack previousContents) {
                super.onContentsChanged(index, previousContents);
                BasinEntity.this.setChanged();
                if(level != null && !level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            protected int getCapacity(int index, ItemResource resource) {
                return 11;
            }
        };
    }

    @Override
    protected double startCutting(double velocity, double torque) { // does nothing here
        return 0;
    }

    @Override
    protected double startCrushing(double velocity, double torque) {
        BasinRecipeInput input = new BasinRecipeInput(this.handler.copyToList(), this.tank.copyToList());
        Optional<RecipeHolder<MacerationRecipe>> recipe = getCurrentRecipe(TekoraRecipes.MACERATION_TYPE.get(), input);
        if (level != null && recipe.isPresent()) {
            MacerationRecipe unwrapped = recipe.get().value();

            ItemStack output = unwrapped.assemble(input);
            double ratedVelocity = unwrapped.ratedVelocity();

            List<Ingredient> reqItems = unwrapped.items();
            List<FluidIngredient> reqFluids = unwrapped.fluids();
            List<Integer> removed = new ArrayList<>();
            //todo algorithm to determine available slot

            int availSlot = 0;
            boolean canWork = false;
            for (int i = 2; i < 12; i++) {
                var resource = handler.getResource(availSlot);
                if (output == null) break;

                if (!canWork && (resource.isEmpty() || resource.is(output.getItem()))
                        && (resource.isEmpty() ? 64 : output.getMaxStackSize()) >= handler.getAmountAsInt(availSlot) + output.getCount()) {
                    canWork = true;
                    availSlot = i;
                }

                // todo replace with a more efficient algorithm in the future
                if (removed.size() < reqItems.size()) {
                    int removedInd = 0;
                    for (Ingredient ingredient : reqItems) {
                        if (!removed.contains(removedInd) && ingredient.test(handler.getResource(availSlot).toStack())) {
                            removed.add(removedInd);
                        }
                        removedInd++;
                    }
                }
            }
            // todo include fluid handling here
            if (canWork && Math.abs(velocity) >= ratedVelocity) {
                double cutTorque = recipe.get().value().cutTorque();
                double cutConst = (torque - cutTorque) / ratedVelocity;
                progress++;
                setChanged(level, getBlockPos(), getBlockState());
                if (progress == MAX_PROGRESS) {
                    try (Transaction transaction = Transaction.openRoot()) {
                        ItemAccess access = ItemAccess.forHandlerIndex(handler, availSlot);
                        // todo, make it so that it looks through the relevant components and outputs in the relevant component
                        for (int val : removed) {
                            handler.extract(handler.getResource(val), 1, transaction);
                        }
                        handler.set(availSlot, ItemResource.of(output), access.getAmount() + output.getCount());
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
    protected double startPressing(double velocity, double torque) {
        BasinRecipeInput input = new BasinRecipeInput(this.handler.copyToList(), this.tank.copyToList());
        Optional<RecipeHolder<CompressingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.COMPRESSING_TYPE.get(), input);
        return 0;
    }

    @Override
    protected double startPrinting(double velocity, double torque) {
        return 0; // does nothing here
    }

    @Override
    protected double startMixing(double velocity, double torque) {
        // todo, ensure to check for the special case
        BasinRecipeInput input = new BasinRecipeInput(this.handler.copyToList(), this.tank.copyToList());
        Optional<RecipeHolder<MixingRecipe>> recipe = getCurrentRecipe(TekoraRecipes.MIXING_TYPE.get(), input);
        return 0;
    }

    private double craftItem() {
        return 0;
    }

    protected boolean fluidCanCraft() {
        return true; // todo, make the recipe consume fluid
    }

    @Override
    public Component getDisplayName() {
        Level level = getLevel();
        if (level != null) {
            Block block = level.getBlockState(getBlockPos().above()).getBlock();
            if (block.equals(TekoraBlocks.CRUSHER.get())) {
                return Component.translatable("blockfunc.tekora.macerator");
            } else if (block.equals(TekoraBlocks.PRESS.get())) {
                return Component.translatable("blockfunc.tekora.compressor");
            } else if (block.equals(TekoraBlocks.PRINTER.get())) {
                return Component.translatable("blockfunc.tekora.printer");
            } else if (block.equals(TekoraBlocks.MIXER.get())) {
                return Component.translatable("blockfunc.tekora.mixer");
            } else {
                return Component.translatable("block.tekora.basin");
            }
        }
        return Component.translatable("block.tekora.basin");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BasinMenu(pContainerId, pPlayerInventory, this, data);
    }
}
