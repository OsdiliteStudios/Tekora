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
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.osdilites.tekora.menu.CombustionChamberMenu;
import org.jspecify.annotations.Nullable;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;

public class CombustionChamberEntity extends AbstractThermalEntity {
    public final ItemStacksResourceHandler inventory = new ItemStacksResourceHandler(1) {
    };

    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int i) {
            return CombustionChamberEntity.this.burnTime;
        }

        @Override
        public void set(int i, int i1) {
            CombustionChamberEntity.this.burnTime = i1;
        }

        @Override
        public int getCount() {
            return 1;
        }
    };

    public CombustionChamberEntity(BlockPos worldPosition, BlockState blockState) {
        super(TekoraBlockEntities.COMBUSTION_CHAMBER.get(), worldPosition, blockState, 1, 1);
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
                // test

                int nCnt = stack.getCount() - 1;

                if (burnTime > 0) {
                    temperature += 1150.0f * (1.0f - (float) Math.exp(-0.03472 * burnTime));
                    burnTime--;
                    blockState = blockState.setValue(AbstractThermalMachine.LIT, true);
                } else if (nCnt >= 0) {
                    burnTime = stack.getBurnTime(RecipeType.SMELTING, level.fuelValues());
                    if (burnTime > 0) {
                        // todo, make sure lava leaves a bucket behind after smelting.
                        try (Transaction transaction = Transaction.openRoot()) {
                            inventory.extract(inventory.getResource(0), 1, transaction);
                            transaction.commit();
                        }
                        blockState = blockState.setValue(AbstractThermalMachine.LIT, false);
                    }
                }
                level.setBlockAndUpdate(pos, blockState);
                setChanged();
            }
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tekora.combustion_chamber");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CombustionChamberMenu(i, inventory, this, this.data);
    }
}
