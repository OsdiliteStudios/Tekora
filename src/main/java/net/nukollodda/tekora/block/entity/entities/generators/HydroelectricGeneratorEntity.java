package net.nukollodda.tekora.block.entity.entities.generators;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.fluids.FluidType;
import net.nukollodda.tekora.block.entity.blocks.generators.HydroelectricGeneratorBlock;
import net.nukollodda.tekora.block.entity.entities.TekoraBlockEntities;
import net.nukollodda.tekora.block.fluid.TekoraFluidType;
import net.nukollodda.tekora.block.fluid.blocks.TekoraGasBlock;
import net.nukollodda.tekora.menu.HydroelectricGeneratorMenu;
import org.jetbrains.annotations.Nullable;

public class HydroelectricGeneratorEntity extends AbstractElectricGeneratorEntity {
    public HydroelectricGeneratorEntity(BlockPos pPos, BlockState pBlockState) {
        super(TekoraBlockEntities.HYDROELECTRIC_GENERATOR.get(), pPos, pBlockState, 2048, 64);
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
                BlockState state = this.getBlockState();
                if (state.getBlock() instanceof HydroelectricGeneratorBlock) {
                    if (state.hasProperty(HydroelectricGeneratorBlock.WATERLOGGED) &&
                            state.getValue(HydroelectricGeneratorBlock.WATERLOGGED) &&
                            state.hasProperty(HydroelectricGeneratorBlock.FACING)) {
                        int energyMade = 0;
                        Direction entDir = state.getValue(HydroelectricGeneratorBlock.FACING);
                        final BlockState above = this.level.getBlockState(this.getBlockPos().relative(Direction.UP));
                        final BlockState behind = this.level.getBlockState(this.getBlockPos().relative(entDir));
                        if (state.hasProperty(HydroelectricGeneratorBlock.WATERLOGGED) &&
                                state.getValue(HydroelectricGeneratorBlock.WATERLOGGED)) {
                            energyMade += makeEnergy(above) + makeEnergy(behind);
                        }
                        this.changeEnergy(energyMade);
                    }
                }
            }
        }
        super.tick();
    }

    // There may be inaccuracies in this method, please correct me if possible
    private int makeEnergy(BlockState pState) {
        if (pState.getBlock() instanceof LiquidBlock liquid && liquid.getFluid().getFluidType().getTemperature() < 400) {
            FluidType type = liquid.getFluid().getFluidType();
            if (!(liquid instanceof TekoraGasBlock) &&
                    !(type instanceof TekoraFluidType fluid && fluid.isMetallic())) {
                final int viscosity = type.getViscosity() / 20;
                final int density = type.getDensity() / 100;
                return viscosity / density;
            }
        }
        return 0;
    }
}
