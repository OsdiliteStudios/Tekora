package net.osdilites.tekora.block.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
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

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class AbstractModularCraftEntity extends BlockEntity implements MenuProvider {
    public final ItemStacksResourceHandler handler;
    protected final ContainerData data;
    protected int progress = 0; // we have to take equilibrium constants and rate laws into consideration here for the chemical reaction recipes
    protected int maxProgress = 160;

    public AbstractModularCraftEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
        this.handler = makeHandler();
        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> AbstractModularCraftEntity.this.progress;
                    case 1 -> AbstractModularCraftEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i) {
                    case 0 -> AbstractModularCraftEntity.this.progress = i1;
                    case 1 -> AbstractModularCraftEntity.this.maxProgress = i1;
                };
            }

            @Override
            public int getCount() {
                return 2;
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
        output.putChild("inventory", handler);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.child("inventory").ifPresent(handler::deserialize);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel != null && !pLevel.isClientSide() && pLevel.getBlockEntity(pPos.above()) instanceof AbstractModularMachineEntity ent) {
            // this calculates for "angular" acceleration specifically
            double torque = ent.getTorque(); // determines recipe progress

            Block block = pState.getBlock();

            double newTorque = 0;
            if (block.equals(TekoraBlocks.CRUSHER.get())) {
                newTorque = startCrushing(ent.getVelocity(), torque);
            } else if (block.equals(TekoraBlocks.MIXER.get())) {
                newTorque = startMixing(ent.getVelocity(), torque);
            } else if (block.equals(TekoraBlocks.PRESS.get())) {
                newTorque = startPressing(ent.getVelocity(), torque);
            } else if (block.equals(TekoraBlocks.PRINTER.get())) {
                newTorque = startPrinting(ent.getVelocity(), torque);
            } else if (block.equals(TekoraBlocks.CUTTER.get())) {
                newTorque = startCutting(ent.getVelocity(), torque);
            }
            ent.addTorque(newTorque);
        }
    }

    protected abstract double startCutting(double velocity, double torque);
    protected abstract double startCrushing(double velocity, double torque);
    protected abstract double startPressing(double velocity, double torque);
    protected abstract double startPrinting(double velocity, double torque);
    protected abstract double startMixing(double velocity, double torque);

    protected <S extends RecipeInput, T extends Recipe<S>> Optional<RecipeHolder<T>> getCurrentRecipe(RecipeType<T> recipeType, S input) {
        if (level != null) {
            return ((ServerLevel) level).recipeAccess()
                    .getRecipeFor(recipeType, input, level);
        }
        return Optional.empty();
    }
}
