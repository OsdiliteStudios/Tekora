package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.transfer.ResourceHandlerUtil;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractDeployingMachineEntity;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.menu.BasinMenu;
import net.osdilites.tekora.recipes.TekoraMechanicalRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

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

    private final ArrayList<ItemStack> toBeRemoved = new ArrayList<>(11);

    public BasinEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.BASIN.get(), pPos, pState);
    }

    // meaning of each index in the inventory
    // 0 = fluid container input
    // 1 = fluid container output
    // 2-10 = items...
    protected ItemStacksResourceHandler makeInventory() {
        return new ItemStacksResourceHandler(11) {
            @Override
            protected void onContentsChanged(int index, ItemStack previousContents) {
                super.onContentsChanged(index, previousContents);
                BasinEntity.this.setChanged();
                if(level != null && !level.isClientSide()) {
                    if (index == 0) {
                        fillTank();
                    } else if (index == 1) {
                        emptyTank();
                    }
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            protected int getCapacity(int index, ItemResource resource) {
                return 11;
            }
        };
    }

    private double craftItem() {
        return 0;
    }

    protected boolean fluidCanCraft() {
        return true; // todo, make the recipe consume fluid
    }

    protected double crafting(Level level, AbstractModularMachineEntity ent, String type, double velocity, double torque) {
        // todo, use handler to check if a recipe containing them exists.
        // note, it is possible to hardcode mole behavior
        if (type.equals(TekoraMechanicalRecipe.MIXER)) {
            // todo, create chemical reaction recipes

            // test code for compoundTags
            FluidResource fluidResource = tank.getResource(0);

        }
        if (ent instanceof AbstractDeployingMachineEntity deployer) {
            // todo, add applying and printing recipes here
            // possible idea, maybe this creates ink water and allows maps to be made
            return 0;
        }
        return 0;
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
        return new BasinMenu(pContainerId, pPlayerInventory, this, inventory, data);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putChild("modcraft.tank", tank);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.child("modcraft.tank").ifPresent(tank::deserialize);
    }

    // FLUID HANDLING
    public FluidStacksResourceHandler getFluidTank(@Nullable Direction direction) {
        return this.tank;
    }

    public FluidStack getFluid() {
        return new FluidStack(tank.getResource(0).getFluid(), tank.getAmountAsInt(0));
    }

    private void fillTank() {
        try(Transaction transaction = Transaction.openRoot()) {
            ItemAccess itemAccess = ItemAccess.forHandlerIndex(inventory, 0);
            var itemCapability = itemAccess.getCapability(Capabilities.Fluid.ITEM);

            // todo, allow water bottles to get used.
            // water bottles has a value of 333 mB
            int fluidMoved = ResourceHandlerUtil.move(itemCapability, tank,
                    fluidResource -> tank.getResource(0).isEmpty() || tank.getResource(0).is(fluidResource.getFluidType()),
                    FluidType.BUCKET_VOLUME, transaction);

            if(fluidMoved == FluidType.BUCKET_VOLUME) {
                transaction.commit();
            }
        }
    }

    private void emptyTank() {
        try(Transaction transaction = Transaction.openRoot()) {
            int amt = tank.getAmountAsInt(0);
            if (amt >= 1000) {
                FluidResource fluid = tank.getResource(0);

                ItemAccess itemAccess = ItemAccess.forHandlerIndex(inventory, 1);
                var itemCapability = itemAccess.getCapability(Capabilities.Fluid.ITEM);
                // todo, implement a mechanism by which a tank could be emptied.

                tank.set(0, fluid, amt - 1000);
            }
        }
    }

    private boolean hasFluidItemStackInSlot() {
        return !inventory.getResource(0).isEmpty()
                && ItemAccess.forHandlerIndex(inventory, 0).getCapability(Capabilities.Fluid.ITEM) != null
                && ItemAccess.forHandlerIndex(inventory, 0).getCapability(Capabilities.Fluid.ITEM).getAmountAsInt(0) != 0;
    }

    // todo, modify the two methods below in accordance with the JSON files
    private void extractFluidForCrafting() {
        try(Transaction transaction = Transaction.openRoot()) {
            tank.extract(tank.getResource(0), 1000, transaction);
            transaction.commit();
        }
    }
}
