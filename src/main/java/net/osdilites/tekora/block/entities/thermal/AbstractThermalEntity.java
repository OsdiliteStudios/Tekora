package net.osdilites.tekora.block.entities.thermal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.osdilites.tekora.block.entities.IHeatSensitive;
import net.osdilites.tekora.util.UtilFunctions;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractThermalEntity extends BlockEntity implements MenuProvider, IHeatSensitive {
    protected float temperature;
    protected int burnTime;
    private final float heatCapacity;
    private final float conductivity;

    public AbstractThermalEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, float heatCapacity, float conductivity) {
        super(pType, pPos, pBlockState);
        this.heatCapacity = heatCapacity;
        this.conductivity = conductivity;
    }

    public void drops() {
//        SimpleContainer inv = new SimpleContainer(getInventory());
//        for (int i = 0; i < getInventory().getSlots(); i++) {
//            inv.setItem(i, getInventory().getStackInSlot(i));
//        }
//
//        if (level != null)
//            Containers.dropContents(level, worldPosition, inv);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putFloat("temperature", this.temperature);
        output.putFloat("burntime", this.burnTime);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.temperature = input.getFloatOr("temperature", 300.0f);
        this.burnTime = input.getIntOr("burntime", 0);
    }
    public void tick(Level level, BlockPos pos, BlockState blockState) {
        if (level != null && !level.isClientSide()) {
            float biomeTemp = (float) UtilFunctions.fromMcTempToKelvins(UtilFunctions.getBiomeTemperature(level, pos));
            if (!Float.isFinite(temperature) || temperature < 0) {
                temperature = biomeTemp;
            }
//            temperature += getTotalTempDiff(level, pos, biomeTemp);
        }
    }
    public abstract ItemStacksResourceHandler getInventory();
    public abstract void clearContents();

    public Component getDisplayName() {
        BlockState state = getBlockState();
        return state.getBlock().getName();
    }

    @Override
    public float getHeatCapacity() {
        return heatCapacity;
    }

    @Override
    public float getConductivity() {
        return conductivity;
    }

    @Override
    public float getContactArea() {
        return 1.0f;
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    public int getBurnTime() {
        return burnTime;
    }

    // BLOCK ENTITY SYNC
    @Override
    public void handleUpdateTag(ValueInput input) {
        super.handleUpdateTag(input);
        loadAdditional(input);
    }

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
