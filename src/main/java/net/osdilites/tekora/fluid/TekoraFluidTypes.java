package net.osdilites.tekora.fluid;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.osdilites.tekora.Tekora;

// test
public class TekoraFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Tekora.MODID);

    public static final DeferredHolder<FluidType, FluidType> ACETIC_ACID_TYPE =
            FLUID_TYPES.register(
                    "acetic_acid",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(1060)
                                    .density(1049)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.05715)
                                    .triplePoint(289.8, 0.0152)
                                    .boilingPoint(391.2)
                                    .criticalPoint(593, 57.81)
                                    .meltingPointSP(290)
                                    .vacuumSublimationPoint(254.1)
                                    .heatFusion(11720)
                                    .tripleHeatVaporization(42000)
                                    .specificHeat(2.15)
                                    .gasSpecificHeat(63.4)
                                    .metalDegradationRate(0.003)
                                    .polymerDegradationRate(0.0005)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> ACETONE_TYPE =
            FLUID_TYPES.register(
                    "acetone",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(320)
                                    .density(785)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.07404)
                                    .triplePoint(178.5, 2.3304E-5)
                                    .boilingPoint(329.3)
                                    .criticalPoint(508, 48)
                                    .meltingPointSP(178.2)
                                    .sublimationPoint(168, 1.8E-6)
                                    .heatFusion(5720)
                                    .tripleHeatVaporization(25500)
                                    .specificHeat(1.7)
                                    .gasSpecificHeat(75)
                                    .metalDegradationRate(0.0005)
                                    .polymerDegradationRate(0.005)
                    )
            );

    public static final FluidType AMMONIA_FLUID_DATA = 
        new ChemicalFluidType(
            FluidType.Properties.create()
                    .viscosity(250)
                    .density(682)
                    .temperature(220)
                    .canExtinguish(false),
            ChemicalFluidType.ChemicalProperties.create()
                    .molarVolume(0.02413)
                    .triplePoint(195.49, 0.0606)
                    .boilingPoint(239.82)
                    .criticalPoint(405.4, 113)
                    .meltingPointSP(195.42)
                    .vacuumSublimationPoint(161.1)
                    .heatFusion(5650)
                    .tripleHeatVaporization(188000)
                    .specificHeat(3.2)
                    .gasSpecificHeat(35.6)
                    .metalDegradationRate(0.003)
                    .polymerDegradationRate(0.001)
        );
    public static final DeferredHolder<FluidType, FluidType> AMMONIA_TYPE =
            FLUID_TYPES.register(
                    "ammonia",
                    () -> AMMONIA_FLUID_DATA
            );

    public static final DeferredHolder<FluidType, FluidType> BENZENE_TYPE =
            FLUID_TYPES.register(
                    "benzene",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(604)
                                    .density(874)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.089)
                                    .triplePoint(278.68, 0.05)
                                    .boilingPoint(353.24)
                                    .criticalPoint(562.02, 48.95)
                                    .meltingPointSP(278.68)
                                    .vacuumSublimationPoint(240)
                                    .heatFusion(10600)
                                    .tripleHeatVaporization(33500)
                                    .specificHeat(1.63)
                                    .gasSpecificHeat(82.4)
                                    .metalDegradationRate(0.0005)
                                    .polymerDegradationRate(0.01)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> BROMINE_TYPE =
            FLUID_TYPES.register(
                    "bromine",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(950)
                                    .density(3103)
                                    .temperature(298)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0515)
                                    .triplePoint(265.9, 0.058)
                                    .boilingPoint(332)
                                    .criticalPoint(588, 103)
                                    .meltingPointSP(265.9)
                                    .vacuumSublimationPoint(238)
                                    .heatFusion(10570)
                                    .tripleHeatVaporization(31000)
                                    .specificHeat(1.47)
                                    .gasSpecificHeat(75.7)
                                    .metalDegradationRate(0.08)
                                    .polymerDegradationRate(0.03)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> ETHANOL_TYPE =
            FLUID_TYPES.register(
                    "ethanol",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(1070)
                                    .density(789)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0584)
                                    .triplePoint(150, 4.3E-9)
                                    .boilingPoint(351.5)
                                    .criticalPoint(514, 63)
                                    .meltingPointSP(159.1)
                                    .sublimationPoint(142.35, 1.0E-10)
                                    .heatFusion(4970)
                                    .tripleHeatVaporization(46000)
                                    .specificHeat(1.93)
                                    .gasSpecificHeat(65.4)
                                    .metalDegradationRate(0.0002)
                                    .polymerDegradationRate(0.0005)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> FORMIC_ACID_TYPE =
            FLUID_TYPES.register(
                    "formic_acid",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(1600)
                                    .density(1220)
                                    .temperature(298)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0377)
                                    .triplePoint(281, 0.01)
                                    .boilingPoint(373.8)
                                    .criticalPoint(588, 58)
                                    .meltingPointSP(281)
                                    .vacuumSublimationPoint(250)
                                    .heatFusion(12700)
                                    .tripleHeatVaporization(50000)
                                    .specificHeat(2.62)
                                    .gasSpecificHeat(47)
                                    .metalDegradationRate(0.005)
                                    .polymerDegradationRate(0.002)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> HYDRAZINE_TYPE =
            FLUID_TYPES.register(
                    "hydrazine",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(974)
                                    .density(1004)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0319)
                                    .triplePoint(274.6, 0.01)
                                    .boilingPoint(386.6)
                                    .criticalPoint(924, 147)
                                    .meltingPointSP(274.6)
                                    .vacuumSublimationPoint(245)
                                    .heatFusion(3000)
                                    .tripleHeatVaporization(44500)
                                    .specificHeat(3.1)
                                    .gasSpecificHeat(45)
                                    .metalDegradationRate(0.02)
                                    .polymerDegradationRate(0.01)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> HYDROGEN_FLUORIDE_TYPE =
            FLUID_TYPES.register(
                    "hydrogen_fluoride",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(250)
                                    .density(1000)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.02)
                                    .triplePoint(190, 0.06)
                                    .boilingPoint(292.7)
                                    .criticalPoint(461, 64)
                                    .meltingPointSP(190)
                                    .vacuumSublimationPoint(175)
                                    .heatFusion(2500)
                                    .tripleHeatVaporization(25000)
                                    .specificHeat(2)
                                    .gasSpecificHeat(29)
                                    .metalDegradationRate(0.05)
                                    .polymerDegradationRate(0.01)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> HYDROGEN_PEROXIDE_TYPE =
            FLUID_TYPES.register(
                    "hydrogen_peroxide",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(1200)
                                    .density(1445)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0236)
                                    .triplePoint(252, 0.0001)
                                    .boilingPoint(423.35)
                                    .criticalPoint(728, 220)
                                    .meltingPointSP(252.9)
                                    .vacuumSublimationPoint(225)
                                    .heatFusion(12500)
                                    .tripleHeatVaporization(51500)
                                    .specificHeat(3.8)
                                    .gasSpecificHeat(45)
                                    .metalDegradationRate(0.03)
                                    .polymerDegradationRate(0.02)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> METHANOL_TYPE =
            FLUID_TYPES.register(
                    "methanol",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(545)
                                    .density(792)
                                    .temperature(298)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0405)
                                    .triplePoint(175.5, 2E-05)
                                    .boilingPoint(337.85)
                                    .criticalPoint(512.6, 80.9)
                                    .meltingPointSP(175.5)
                                    .vacuumSublimationPoint(155)
                                    .heatFusion(3180)
                                    .tripleHeatVaporization(44000)
                                    .specificHeat(2.01)
                                    .gasSpecificHeat(42.4)
                                    .metalDegradationRate(0.0005)
                                    .polymerDegradationRate(0.001)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> SULFUR_DIOXIDE_TYPE =
            FLUID_TYPES.register(
                    "sulfur_dioxide",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(13)
                                    .density(1461)
                                    .temperature(210)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0439)
                                    .triplePoint(197.64, 0.0167)
                                    .boilingPoint(263)
                                    .criticalPoint(430.34, 78.84)
                                    .meltingPointSP(200.75)
                                    .sublimationPoint(147, 1E-05)
                                    .heatFusion(1750)
                                    .tripleHeatVaporization(27000)
                                    .specificHeat(2.8)
                                    .gasSpecificHeat(40)
                                    .metalDegradationRate(4)
                                    .polymerDegradationRate(1)
                    )
            );

    public static final DeferredHolder<FluidType, FluidType> SULFUR_TRIOXIDE_TYPE =
            FLUID_TYPES.register(
                    "sulfur_trioxide",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create()
                                    .viscosity(746)
                                    .density(1513)
                                    .canExtinguish(false),
                            ChemicalFluidType.ChemicalProperties.create()
                                    .molarVolume(0.0417)
                                    .triplePoint(231.55, 0.05)
                                    .boilingPoint(356.15)
                                    .criticalPoint(520, 68.9)
                                    .meltingPointSP(290.1)
                                    .vacuumSublimationPoint(261.1)
                                    .heatFusion(9350)
                                    .tripleHeatVaporization(46700)
                                    .specificHeat(2.64)
                                    .gasSpecificHeat(53.5)
                                    .metalDegradationRate(25)
                                    .polymerDegradationRate(8)
                    )
            );

    public static final ChemicalFluidType SULFURIC_ACID_DATA =
        new ChemicalFluidType(
            FluidType.Properties.create()
                    .viscosity(24000)
                    .density(1830)
                    .canExtinguish(false),
            ChemicalFluidType.ChemicalProperties.create()
                    .molarVolume(0.0533)
                    .triplePoint(283.46, 1.29E-8)
                    .boilingPoint(610)
                    .criticalPoint(924, 64)
                    .meltingPointSP(283.46)
                    .sublimationPoint(270, 1.25E-10)
                    .heatFusion(10500)
                    .tripleHeatVaporization(72500)
                    .specificHeat(2.6)
                    .gasSpecificHeat(83.7)
                    .metalDegradationRate(0.02)
                    .polymerDegradationRate(0.005)
        );
    public static final DeferredHolder<FluidType, FluidType> SULFURIC_ACID_TYPE =
            FLUID_TYPES.register(
                    "sulfuric_acid",
                    () -> SULFURIC_ACID_DATA
            );

    public static final DeferredHolder<FluidType, FluidType> WATER_TYPE =
            FLUID_TYPES.register("water_chemical",
                    () -> new ChemicalFluidType(
                            FluidType.Properties.create(),
                            ChemicalFluidType.ChemicalProperties.create()
                    ));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
