package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.transfer.ResourceHandlerUtil;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.fluid.FluidStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;
import net.neoforged.neoforge.transfer.transaction.Transaction.Lifecycle;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractDeployingMachineEntity;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.item.BottleResourceHandler;
import net.osdilites.tekora.menu.BasinMenu;
import net.osdilites.tekora.recipes.ReactionRecipe;
import net.osdilites.tekora.recipes.TekoraMechanicalRecipe;
import net.osdilites.tekora.recipes.TekoraRecipes;
import net.osdilites.tekora.recipes.ingredient.ChemicalIngredient;
import net.osdilites.tekora.recipes.inputs.ReactionRecipeInput;
import net.osdilites.tekora.util.UtilFunctions;

import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BasinEntity extends AbstractModularCraftEntity {
    private final FluidStacksResourceHandler tank = new FluidStacksResourceHandler(1, 10000) {
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

    // variables for chemical reaction recipes
    private boolean hasRxn = false;
    private double lnK = 0;
    private double lnQ = 0;
    private final Map<Integer, float[]> itemReactants = new HashMap<>();
    private final Map<Integer, float[]> fluidReactants = new HashMap<>();
    private final Map<Integer, float[]> itemProducts = new HashMap<>();
    private final Map<Integer, float[]> fluidProducts = new HashMap<>();

    public BasinEntity(BlockPos pPos, BlockState pState) {
        super(TekoraBlockEntities.BASIN.get(), pPos, pState, 4.815f);
    }

    private final int FLUID_INPUT_SLOT = 0;
    private final int FLUID_OUTPUT_SLOT = 1;

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
                    // Note: fillTank and emptyTank can lead to another call to onContentsChanged,
                    // but only the second call can change the item in the slot, delete or leave alone
                    // if (index == 0) {
                    //     fillTank();
                    // } else if (index == 1) {
                    //     emptyTank();
                    // }
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            protected int getCapacity(int index, ItemResource resource) {
                return resource.getMaxStackSize();
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

        if (ent instanceof AbstractDeployingMachineEntity deployer) {
            // todo, add applying and printing recipes here
            // possible idea, maybe this creates ink water and allows maps to be copied
            return 0;
        }

        if (type.equals(TekoraMechanicalRecipe.MIXER)) {
            // the following code below reads the ingredients in inventory/tank
            HashMap<ChemicalIngredient, Double> ingredients = new HashMap<>();
            HashMap<SoluteKey, Double> liquidSolutes = new HashMap<>();
            float volume = ReactionRecipeInput.fromReadingHandlersGetVolume(ingredients, liquidSolutes, inventory, tank);

            ReactionRecipeInput input = new ReactionRecipeInput(ingredients, torque); // todo, replace torque with an actual more legit form of energy
            Optional<RecipeHolder<ReactionRecipe>> recipe = TekoraRecipes.getCurrentRecipe((ServerLevel)level, TekoraRecipes.REACTION_TYPE.get(), input);

            if (!recipe.isPresent()) {
                this.hasRxn = false;
                itemReactants.clear();
                itemProducts.clear();
                fluidReactants.clear();
                fluidProducts.clear();
                return 0;
            }        
            
            ReactionRecipe accessedRec = recipe.get().value();
            // something to debug, if you switch recipes fast enough, does it still register as present?
            if (!this.hasRxn) {
                // description: use this to develop a map of indices containing reactants/products including those with solutes
                accessedRec.fillWithReactants(itemReactants, inventory, fluidReactants, tank);
                accessedRec.fillWithProducts(itemProducts, inventory, fluidProducts, tank);
                this.hasRxn = true;
            }
            this.lnQ = accessedRec.getLnQ(liquidSolutes, volume);
            this.lnK = accessedRec.getLnK(temperature);

            // disabled realistic rate law checking for now
            float rate = 1;//accessedRec.getRateTicks(liquidSolutes, temperature);
            // if (rate == 0) {
            //   break;
            // }
            //if (rate != 0) {
                int action = Double.compare(lnQ, lnK);

                // this code has been untested
                // todo, test this piece of code
                accessedRec.modifyCrafterInventory(itemReactants, inventory, rate, action);
                accessedRec.modifyCrafterTank(fluidReactants, tank, rate, action);

                accessedRec.modifyCrafterInventory(itemProducts, inventory, rate, -action);
                accessedRec.modifyCrafterTank(fluidProducts, tank, rate, -action);
                
            //}
        }

        // todo, include misc test cases here
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
            ItemAccess itemAccess = ItemAccess.forHandlerIndexStrict(inventory, FLUID_INPUT_SLOT);
            var itemCapability = itemAccess.getCapability(Capabilities.Fluid.ITEM);


            // todo, allow water bottles to get used.
            // water bottles has a value of 333 mB        
            int fluidMoved = ResourceHandlerUtil.move(itemCapability, tank,
                    fluidResource -> tank.getResource(0).isEmpty() || tank.getResource(0).is(fluidResource.getFluidType()),
                    FluidType.BUCKET_VOLUME, transaction);
            
            // case fallthrough is intentional
            switch(fluidMoved) {
            case FluidType.BUCKET_VOLUME:
                if (itemAccess.getResource().getItem() instanceof BucketItem) {
                    // note, possible incompatibility here if multiple types of buckets exist
                    itemAccess.exchange(ItemResource.of(Items.BUCKET), itemAccess.getAmount(), transaction);
                }
            case BottleResourceHandler.BOTTLE_VOLUME:
                transaction.commit();
                break;
            default:   
            }
        }
    }

    private void emptyTank() {
        int amt = tank.getAmountAsInt(0);
        if (amt < BottleResourceHandler.BOTTLE_VOLUME) return;

        try(Transaction transaction = Transaction.openRoot()) {
            // FluidResource fluid = tank.getResource(0);

            ItemAccess itemAccess = ItemAccess.forHandlerIndexStrict(inventory, FLUID_OUTPUT_SLOT);
            var itemCapability = itemAccess.getCapability(Capabilities.Fluid.ITEM);
            // todo, implement a mechanism by which a tank could be emptied.
            
            int fluidMoved = ResourceHandlerUtil.move(tank, itemCapability, 
                fluidResource -> itemCapability.getResource(0).isEmpty() || itemCapability.getResource(0).is(fluidResource.getFluidType()), 
                FluidType.BUCKET_VOLUME, transaction);
            
            // case fallthrough is intentional
            switch(fluidMoved) {
            case BottleResourceHandler.BOTTLE_VOLUME:
            case FluidType.BUCKET_VOLUME:
                transaction.commit();
                break;
            default:
            }   
        }
    }

    /// Answers: "Can fluid be transferred to the item in this basin's inventory slot?"
    private boolean hasFluidCapability(int index) {
        return !inventory.getResource(index).isEmpty()
                && ItemAccess.forHandlerIndex(inventory, index).getCapability(Capabilities.Fluid.ITEM) != null;
    }

    private boolean hasFluidItemStackInSlot() {
        return hasFluidCapability(FLUID_INPUT_SLOT)
                && ItemAccess.forHandlerIndex(inventory, FLUID_INPUT_SLOT).getCapability(Capabilities.Fluid.ITEM).getAmountAsInt(0) != 0;
    }

    // THANK YOU KAUPENJOE FOR GIVING ME THE IDEA TO CHECK FLUID ITEMS 
    // ON TICK INSTEAD OF HAVING TO DEAL WITH SOMEONE'S ELSE'S DECISION TO PUT 
    // FILL EMPTY ON A ONCONTENTSCHANGED FUNCTION THAT CAN INDIRECTLY
    // RECURSIVELY CALL ITSELF
    @Override 
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        super.tick(pLevel, pPos, pState);

        // prevent an open transaction on the same thread from calling fill or empty across ticks?
        if (Transaction.getLifecycle() != Lifecycle.NONE) return;

        // while this is not really that efficient, it avoids some of the tricky
        // problems with putting fill and empty logic in onContentsChanged:
        // because items can change in-slot during a transaction, unwanted calls are triggered
        if (hasFluidItemStackInSlot()) {
            fillTank();
        } else if (hasFluidCapability(FLUID_OUTPUT_SLOT)) {
            emptyTank();
        }
    }

    // todo, modify the two methods below in accordance with the JSON files
    private void extractFluidForCrafting() {
        try(Transaction transaction = Transaction.openRoot()) {
            tank.extract(tank.getResource(0), 1000, transaction);
            transaction.commit();
        }
    }

    public double getLnK() {
        return lnK;
    }

    public double getLnQ() {
        return lnQ;
    }

    public boolean hasReaction() {
        return hasRxn;
    }
}
