package net.osdilites.tekora.block.entities.thermal;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.menu.StoveFurnaceMenu;
import org.jspecify.annotations.Nullable;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class StoveFurnaceEntity extends AbstractThermalEntity {
    public final ItemStacksResourceHandler inventory = new ItemStacksResourceHandler(1) {
    };

    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int i) {
            return i == 0 ? StoveFurnaceEntity.this.burnTime : StoveFurnaceEntity.this.maxBurnTime;
        }

        @Override
        public void set(int i, int i1) {
            if (i == 0) {
                StoveFurnaceEntity.this.burnTime = i1;
            } else if (i == 1) {
                StoveFurnaceEntity.this.maxBurnTime = i1;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public StoveFurnaceEntity(BlockPos worldPosition, BlockState blockState) {
        super(TekoraBlockEntities.STOVE_FURNACE.get(), worldPosition, blockState, 1, 1);
        // todo define heat capacity and conductivity
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putChild("inventory", inventory);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.child("inventory").ifPresent(inventory::deserialize);
    }

    @Override
    public ItemStacksResourceHandler getInventory() {
        return inventory;
    }

    @Override
    public void clearContents() {
        for (int i = 0; i < inventory.size(); i++) {
            inventory.set(i, ItemResource.of(Items.AIR), 1);
        }
    }

    public void tick(Level level, BlockPos pos, BlockState blockState) {
        super.tick(level, pos, blockState);

        if (level != null && !level.isClientSide()) {
            if (blockState.hasProperty(AbstractThermalMachine.LIT)) {
                ItemStack stack = new ItemStack(inventory.getResource(0).getItem());

                int nCnt = stack.getCount() - 1;

                if (burnTime > 0) {
                    temperature += 0.25f; // todo, do proper modeling for temperature
                    burnTime--;
                    blockState = blockState.setValue(AbstractThermalMachine.LIT, true);
                } else {
                    if (nCnt >= 0) {
                        maxBurnTime = stack.getBurnTime(RecipeType.SMELTING, level.fuelValues());
                        burnTime = maxBurnTime;
                        if (burnTime > 0) {
                            try (Transaction transaction = Transaction.openRoot()) {
                                inventory.extract(inventory.getResource(0), 1, transaction);
                                if (stack.getCraftingRemainder() != null) {
                                    inventory.set(0, ItemResource.of(stack.getCraftingRemainder()), 1);
                                }
                                transaction.commit();
                            }
                        }
                    }
                    blockState = blockState.setValue(AbstractThermalMachine.LIT, false);
                }
                level.setBlockAndUpdate(pos, blockState);
            }
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.stove_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new StoveFurnaceMenu(i, inventory, this, this.data);
    }
}
