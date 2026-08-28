package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachineEntity;
import net.osdilites.tekora.recipes.TekoraMechanicalRecipe;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class AbstractModularCraftEntity extends BlockEntity implements MenuProvider {
    public final ItemStacksResourceHandler handler;
    protected final ContainerData data;
    protected int progress = 0; // we have to take equilibrium constants and rate laws into consideration here for the chemical reaction recipes
    public static final int MAX_PROGRESS = 128;

    public AbstractModularCraftEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
        this.handler = makeHandler();
        this.data = new ContainerData() { // for mechanical and fluid mech entities, we just need these two
            @Override
            public int get(int i) {
                return AbstractModularCraftEntity.this.progress;
            }

            @Override
            public void set(int i, int i1) {
                if (i == 0) {
                    AbstractModularCraftEntity.this.progress = i1;
                }
                ;
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    protected abstract ItemStacksResourceHandler makeHandler();

    public void drops() {
        SimpleContainer inv = new SimpleContainer(handler.size());
        for(int i = 0; i < handler.size(); i++) {
            ItemAccess itemAccess = ItemAccess.forHandlerIndex(handler, 0);
            inv.setItem(i, new ItemStack(itemAccess.getResource().getItem(), itemAccess.getAmount()));
        }
        if (this.level != null) Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("modcraft.progress", progress);
        output.putChild("inventory", handler);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        progress = input.getIntOr("modcraft.progress", 0);

        input.child("inventory").ifPresent(handler::deserialize);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel != null && pLevel.getBlockEntity(pPos.above()) instanceof AbstractModularMachineEntity ent) {
            // this calculates for "angular" acceleration specifically
            double torque = ent.getTorque(); // determines recipe progress
            Block block = ent.getBlockState().getBlock();

            String machineType = "";
            if (block.equals(TekoraBlocks.CRUSHER.get())) {
                machineType = TekoraMechanicalRecipe.CRUSHER;
            } else if (block.equals(TekoraBlocks.MIXER.get())) {
                machineType = TekoraMechanicalRecipe.MIXER;
            } else if (block.equals(TekoraBlocks.PRESS.get())) {
                machineType = TekoraMechanicalRecipe.PRESS;
            } else if (block.equals(TekoraBlocks.PRINTER.get())) {
                machineType = TekoraMechanicalRecipe.PRINTER;
            } else if (block.equals(TekoraBlocks.CUTTER.get())) {
                machineType = TekoraMechanicalRecipe.CUTTER;
            } //else if (block.equals(TekoraBlocks.MAGNETIC_SPLITTER.get())) {
//                machineType = TekoraMechanicalRecipe.SPLITTER;
//            }
            if (!machineType.isEmpty()) ent.addTorque(crafting(machineType, ent.getVelocity(), torque));
        }
    }

    abstract protected double crafting(String type, double velocity, double torque);

    protected <S extends RecipeInput, T extends Recipe<S>> Optional<RecipeHolder<T>> getCurrentRecipe(RecipeType<T> recipeType, S input) {
        return ((ServerLevel) level).recipeAccess()
                .getRecipeFor(recipeType, input, level);
    }

    public int getProgress() {
        return progress;
    }

    // BLOCK ENTITY SYNC
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Override
    public void onDataPacket(Connection net, ValueInput valueInput) {
        super.onDataPacket(net, valueInput);
    }
}
