package net.osdilites.tekora.fluid.types;

import net.neoforged.neoforge.fluids.FluidType;
import net.osdilites.tekora.util.UtilFunctions;

public class ChemicalFluidType extends FluidType {
    private static final double LATENT_CONVERSION = 1 / (Math.log(10) * UtilFunctions.IDEAL_GAS_CONST);

    private double molarVolume; // mol/m^3 or mol/block
    private double specificHeat; // J/mol K

    // anchor values
    private double tripleTemperature; // K
    private double triplePressure; // bar
    private double criticalTemperature; // K
    private double criticalPressure; // bar

    // note: heatSublimation = heatFus + heatVap;
    private double heatFus; // J/mol
    private double refHeatVap; // heat of vaporization at the triple point, J/mol

    // the two variables below determine the melting point of a fluid
    private double meltSlope;
    private double meltConst;

    // these variables determine the boiling/sublimation points of a fluid
    private double volatility;
    private double calmerValue;

    // this determines when pipes break when attempting to store this fluid
    private double corrosivity;

    private CompoundType type;

    public ChemicalFluidType(final Properties properties, final ChemicalProperties chemProperties) {
        super(properties);
    }

    public double getMeltingPoint(double pressure) {
        return meltSlope * pressure + meltConst;
    }

    public double getBoilingPoint(double pressure) {
        if (pressure >= criticalPressure) {
            return Double.POSITIVE_INFINITY;
        }
        double latentHeat = getHeatVap(pressure) * LATENT_CONVERSION;
        return latentHeat / (volatility - Math.log10(pressure)) - calmerValue;
    }

    public double getHeatVap(double pressure) {
        return refHeatVap * (criticalPressure - pressure) / (criticalPressure - triplePressure);
    }

    public double fluidness(double temperature, double pressure) {
        if (pressure < criticalPressure) {
            return getBoilingPoint(pressure) < temperature ? 0 : 1;
        } else {
            return Math.clamp(((1 - getHeatVap(pressure) / refHeatVap) + (temperature - tripleTemperature) / (criticalTemperature - tripleTemperature)) / 2, 0, 1);
        }
    }

    public static final class ChemicalProperties {
        private double molarVolume; // mol/m^3 or mol/block
        private double specificHeat = 75.38; // J/mol K

        private double heatFus = 6020; // J/mol
        private double heatVap = 40650; // J/mol

        // the two variables below determine the melting point of a fluid
        private double meltSlope;
        private double meltConst;

        // these variables determine the boiling/sublimation points of a fluid
        private double volatility;
        private double calmerValue;

        // this determines whether pipes break when attempting to store this fluid
        private double corrosivity;
        private CompoundType type;

        private ChemicalProperties() {}

        public static ChemicalProperties create() { return new ChemicalProperties(); }

        public ChemicalProperties molarVolume(final double molarVolume) {
            this.molarVolume = molarVolume;
            return this;
        }

        public ChemicalProperties specificHeat(final double specificHeat) {
            this.specificHeat = specificHeat;
            return this;
        }

        public ChemicalProperties heatFusion(final double heatFus) {
            this.heatFus = heatFus;
            return this;
        }

        public ChemicalProperties heatVaporization(final double heatVap) {
            this.heatVap = heatVap;
            return this;
        }

        public ChemicalProperties freezingPointSTP(final double freezingPoint, final double triplePointTemp, final double triplePointPressure) {
            this.meltSlope = (freezingPoint - triplePointTemp) / (1 - triplePointPressure);
            return this;
        }

        public ChemicalProperties boilingPointSTP(final double boilingPoint, final double triplePointTemp, final double triplePointPressure) {
            return this;
        }
    }
}
