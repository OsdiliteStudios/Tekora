package net.osdilites.tekora.block.entities.mechanical;

import org.jspecify.annotations.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.AbstractModularCraftEntity;
import net.osdilites.tekora.block.entities.DepotEntity;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.menu.DeployerMenu;
import net.osdilites.tekora.menu.DepotMenu;

public class PrinterMechanicalEntity extends AbstractDeployingMachineEntity implements MenuProvider {

    public final ItemStacksResourceHandler inventory;
    protected final ContainerData data;

    public PrinterMechanicalEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.PRINTER.get(), pPos, pBlockState);
        this.inventory = makeInventory();
        this.data = new ContainerData() { 
            @Override
            public int get(int i) {
                return 1;
            }

            @Override
            public void set(int i, int i1) {
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    @Override
    protected double partMoment() {
        return 0; // todo find value
    }

    protected ItemStacksResourceHandler makeInventory() {
        return new ItemStacksResourceHandler(1) {
            @Override
            protected void onContentsChanged(int index, ItemStack previousContents) {
                super.onContentsChanged(index, previousContents);
                PrinterMechanicalEntity.this.setChanged();
                if (level == null || level.isClientSide()) return;
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        Level level = getLevel();
        if (level == null) return null;

        // so I'm supposed to give the deploying machine (mechanical top)
        // an inventory, and make the player interact with it...

        Block block = level.getBlockState(getBlockPos().below()).getBlock();
        if (!block.equals(TekoraBlocks.DEPOT.get())) return null;

        return new DeployerMenu(i, inventory, this, this.inventory, data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("blockfunc.tekora.printer");
    }
}
