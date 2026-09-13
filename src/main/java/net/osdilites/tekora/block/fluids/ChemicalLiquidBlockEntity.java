package net.osdilites.tekora.block.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.fluid.types.ChemicalFluidType;
import net.osdilites.tekora.util.UtilFunctions;

public class ChemicalLiquidBlockEntity extends BlockEntity {
    private double meltingPoint; // K
    private double boilingPoint; // K
    private double heatVapCapacity; // J/mol
    private double temperature;
    private final double heatFusCapacity; // J/mol
    private final double heatCapacity; // J/K
    private final double moleCount;
    private final ChemicalFluidType type;

    public ChemicalLiquidBlockEntity(ChemicalFluidType type, BlockPos worldPosition, BlockState blockState) {
        super(TekoraBlockEntities.CHEMICAL_LIQUID.get(), worldPosition, blockState);
        this.type = type;
        this.moleCount = type.getMolarVolume() * 1000;
        this.heatFusCapacity = type.getHeatFusion() * this.moleCount;
        this.heatCapacity = type.getSpecificHeat() * 1E+6;
    }

    public ChemicalLiquidBlockEntity(BlockPos pos, BlockState state) {
        super(TekoraBlockEntities.CHEMICAL_LIQUID.get(), pos, state);
        this.type = null;
        this.moleCount = 18;
        this.heatFusCapacity = 6014;
        this.heatCapacity = 4.18E+6;
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {}

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        this.meltingPoint = input.getDoubleOr("chemical.melting_point", type == null ? 273.15 : type.getMeltingPoint(UtilFunctions.getPressure(level)));
        this.boilingPoint = input.getDoubleOr("chemical.boiling_point", type == null ? 373.15 : type.getBoilingPoint(UtilFunctions.getPressure(level)));
        this.heatVapCapacity = input.getDoubleOr("chemical.heat_vap_capacity", type == null ? 811800 : type.getHeatVap(UtilFunctions.getPressure(level)));

        this.temperature = input.getDoubleOr("chemical.temperature", type == null ? (level == null ? 300 : UtilFunctions.fromMcTempToKelvins(level.getBiome(getBlockPos()).value().getBaseTemperature())) : type.getTemperature());
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        output.putDouble("chemical.melting_point", this.meltingPoint);
        output.putDouble("chemical.boiling_point", this.boilingPoint);
        output.putDouble("chemical.heat_vap_capacity", this.heatVapCapacity);
        output.putDouble("chemical.temperature", this.temperature);
    }
}
