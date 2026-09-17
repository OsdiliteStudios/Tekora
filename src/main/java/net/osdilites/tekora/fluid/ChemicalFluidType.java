package net.osdilites.tekora.fluid;

import net.neoforged.neoforge.fluids.FluidType;

public class ChemicalFluidType extends FluidType {
    private final double molarVolume; // mol/L or mol/L, only applies to liquids, for gases we use the ideal gas law

    // anchor values
    private final double tripleTemperature; // K
    private final double triplePressure; // bar
    private final double criticalTemperature; // K
    private final double criticalPressure; // bar

    // note: heatSublimation = heatFus + heatVap;
    private final double heatFus; // J/mL
    private final double refHeatVap; // heat of vaporization at the triple point, J/mL

    // specific heats for states of matter;
    private final double specificHeat; // J/mL K
    private final double gasSpecificHeat; // J/mL K

    // the two variables below determine the melting point of a fluid
    private final double meltSlope;
    private final double meltConst;

    // the two variables below determine the sublimation point of the substance
    private final double sublimationSlope;
    private final double sublimationConst;

    // these variables determine the boiling/sublimation points of a fluid
    private final double antoineA;
    private final double antoineB;
    private final double antoineC;

    // these variables determine how the fluid interacts with its containers and sometimes blocks surrounding it
    private final double metalDegradationRate;
    private final double polymerDegradationRate;

    public ChemicalFluidType(final Properties properties, final ChemicalProperties chemProperties) {
        super(properties);

        this.criticalPressure = chemProperties.criticalPressure;
        this.triplePressure = chemProperties.triplePressure;
        this.criticalTemperature = chemProperties.criticalTemp;
        this.tripleTemperature = chemProperties.tripleTemp;

        this.refHeatVap = chemProperties.heatVap;
        this.heatFus = chemProperties.heatFus;
        this.specificHeat = chemProperties.specificHeat;
        this.gasSpecificHeat = chemProperties.gasSpecificHeat;
        
        this.molarVolume = chemProperties.molarVolume;

        double ratio = Math.log10(chemProperties.triplePressure / chemProperties.anchorPressure) * (chemProperties.anchorTemp - chemProperties.criticalTemp) / (Math.log10(chemProperties.anchorPressure / chemProperties.criticalPressure) * (chemProperties.tripleTemp - chemProperties.anchorTemp));

        this.antoineC = (chemProperties.criticalTemp - ratio * chemProperties.tripleTemp) / (ratio - 1);
        this.antoineB = Math.log10(chemProperties.triplePressure / chemProperties.anchorPressure) * (chemProperties.tripleTemp + this.antoineC) * (chemProperties.anchorTemp + this.antoineC) / (chemProperties.tripleTemp - chemProperties.anchorTemp);
        this.antoineA = Math.log10(chemProperties.triplePressure) + this.antoineB / (chemProperties.tripleTemp + this.antoineC);


        this.meltSlope = (chemProperties.meltTemp - tripleTemperature) / (chemProperties.meltPressure - triplePressure);
        this.meltConst = tripleTemperature - triplePressure * meltSlope;

        this.sublimationSlope = (tripleTemperature - chemProperties.sublimationTemp) / (triplePressure - chemProperties.sublimationPressure);
        this.sublimationConst = tripleTemperature - triplePressure * sublimationSlope;

        this.metalDegradationRate = chemProperties.metalDegradationRate;
        this.polymerDegradationRate = chemProperties.polymerDegradationRate;
    }

    public double getMeltingPoint(double pressure) {
        return pressure < triplePressure ? getSublimationPoint(pressure) : meltSlope * pressure + meltConst;
    }

    public double getBoilingPoint(double pressure) {
        if (pressure >= criticalPressure) {
            return Double.POSITIVE_INFINITY;
        } else if (pressure < triplePressure) {
            return getSublimationPoint(pressure);
        }
        return antoineB / (antoineA - Math.log10(pressure)) - antoineC;
    }

    public double getSublimationPoint(double pressure) {
        return sublimationSlope * pressure + sublimationConst;
    }

    public double getHeatVap(double pressure) {
        return refHeatVap * (criticalPressure - pressure) / (criticalPressure - triplePressure);
    }

    public double getHeatFusion() {
        return this.heatFus;
    }

    public double getHeatSublimation(double pressure) {
        return getHeatFusion() + getHeatVap(pressure);
    }

    public double fluidness(double temperature, double pressure) {
        if (pressure < criticalPressure) {
            return getBoilingPoint(pressure) < temperature ? 0 : 1;
        } else {
            return Math.clamp(((1 - getHeatVap(pressure) / refHeatVap) + (temperature - tripleTemperature) / (criticalTemperature - tripleTemperature)) / 2, 0, 1);
        }
    }

    public boolean isSupercritical(double pressure) {
        return pressure >= this.criticalPressure;
    }

    public double getMolarVolume() {
        return molarVolume;
    }

    public double getSpecificHeat() {
        return specificHeat;
    }

    public double getGasSpecificHeat() {
        return gasSpecificHeat;
    }

    public double getMetalDegradationRate() {
        return metalDegradationRate;
    }

    public double getPolymerDegradationRate() {
        return polymerDegradationRate;
    }

    public static final class ChemicalProperties {
        private double molarVolume = 0.018; // L/mol or block/(1000 mol)

        private double heatFus = 6014; // J/mol
        private double heatVap = 45100; // J/mol

        // the two variables below determine the melting point of a fluid
        private double meltTemp = 273.15;
        private double meltPressure = 1.013;
        private double sublimationTemp = 150;
        private double sublimationPressure = 0.001013;

        // these variables talk about specific heat constants
        private double specificHeat = 4.18; // J/mL K
        private double gasSpecificHeat = 33.58; // J/mol K

        // points of importance
        private double tripleTemp = 273.16;
        private double criticalTemp = 647.096;
        private double anchorTemp = 373.15;

        private double triplePressure = 0.006117;
        private double criticalPressure = 220.64;
        private double anchorPressure = 1.013;

        // rates in mm/year
        private double metalDegradationRate = 0.00001;
        private double polymerDegradationRate = 0.00001;

        private ChemicalProperties() {
        }

        public static ChemicalProperties create() {
            return new ChemicalProperties();
        }

        public ChemicalProperties triplePoint(final double tripleTemp, final double triplePressure) {
            this.tripleTemp = tripleTemp;
            this.triplePressure = triplePressure;
            return this;
        }

        public ChemicalProperties criticalPoint(final double criticalTemp, final double criticalPressure) {
            this.criticalTemp = criticalTemp;
            this.criticalPressure = criticalPressure;
            return this;
        }

        public ChemicalProperties anchorBoilingPoint(final double anchorTemp, final double anchorPressure) {
            this.anchorTemp = anchorTemp;
            this.anchorPressure = anchorPressure;
            return this;
        }

        public ChemicalProperties boilingPoint(final double temp) {
            return anchorBoilingPoint(temp, 1);
        }

        public ChemicalProperties molarVolume(final double molarVolume) {
            this.molarVolume = molarVolume;
            return this;
        }

        public ChemicalProperties heatFusion(final double heatFus) {
            this.heatFus = heatFus;
            return this;
        }

        public ChemicalProperties tripleHeatVaporization(final double heatVap) {
            this.heatVap = heatVap;
            return this;
        }

        public ChemicalProperties meltingPoint(final double meltingPoint, final double pressure) {
            this.meltPressure = pressure;
            this.meltTemp = meltingPoint;
            return this;
        }

        public ChemicalProperties meltingPointSP(final double meltingPoint) {
            return meltingPoint(meltingPoint, 1);
        }

        public ChemicalProperties sublimationPoint(final double sublimationPoint, final double pressure) {
            this.sublimationTemp = sublimationPoint;
            this.sublimationPressure = pressure;
            return this;
        }

        public ChemicalProperties vacuumSublimationPoint(final double sublimationPoint) {
            return sublimationPoint(sublimationPoint, 0.001013);
        }

        public ChemicalProperties specificHeat(final double specificHeat) {
            this.specificHeat = specificHeat;
            return this;
        }

        public ChemicalProperties gasSpecificHeat(final double gasSpecificHeat) {
            this.gasSpecificHeat = gasSpecificHeat;
            return this;
        }

        public ChemicalProperties metalDegradationRate(final double rate) {
            this.metalDegradationRate = rate;
            return this;
        }

        public ChemicalProperties polymerDegradationRate(final double rate) {
            this.polymerDegradationRate = rate;
            return this;
        }
        // todo, include a solid block form property, a smoke particle color property, and an "effect" or "damage" property
    }
}
