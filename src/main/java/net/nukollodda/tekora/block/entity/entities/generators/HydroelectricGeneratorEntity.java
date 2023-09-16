package net.nukollodda.tekora.block.entity.entities.generators;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.nukollodda.tekora.block.entity.blocks.generators.HydroelectricGeneratorBlock;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.menu.HydroelectricGeneratorMenu;
import org.jetbrains.annotations.Nullable;

public class HydroelectricGeneratorEntity extends AbstractElectricGeneratorEntity {
    public HydroelectricGeneratorEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.HYDRO_ELECTRIC_GENERATOR.get(), pPos, pBlockState, 2048, 64);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pId, Inventory pInventory, Player pPlayer) {
        return new HydroelectricGeneratorMenu(pId, pInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("hydroelectric_generator.electricity", ENERGY_STORAGE.getEnergyStored());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        ENERGY_STORAGE.setEnergy(tag.getInt("hydroelectric_generator.electricity"));
    }

    @Override
    public void tick() {
        if (level != null && !level.isClientSide()) {
            if (this.currentEnergy() < this.maxEnergy() - 64) {
                if (this.getBlockState().getBlock() instanceof HydroelectricGeneratorBlock) {
                    if (this.getBlockState().hasProperty(BlockStateProperties.WATERLOGGED) &&
                        this.getBlockState().getValue(BlockStateProperties.WATERLOGGED)) {
                        int energyMade = 0;
                        final BlockState above = this.level.getBlockState(this.getBlockPos().relative(Direction.UP));
                        if (above.getBlock() instanceof LiquidBlock liquid) {
                            if (liquid.getFluid().getFluidType().getTemperature() < 400) {
                                energyMade += 5;
                            }
                        }
                        Direction entDir = this.getBlockState().getValue(BlockStateProperties.FACING);
                        this.changeEnergy(energyMade);
                        // make sure that energy is the most if there is a water source above and behind the generator
                        // note, energy should cancel out if there is water in front of the generator
                        // when a block is behind/above the block, energy production becomes obstructed
                    }
                }
            }
        }
        super.tick();
    }
}
