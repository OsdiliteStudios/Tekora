package net.osdilites.tekora.fluid;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.osdilites.tekora.Tekora;

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

    public static final DeferredHolder<FluidType, FluidType> AMMONIA_TYPE =
            FLUID_TYPES.register(
                    "ammonia",
                    () -> new ChemicalFluidType(
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

    public static final DeferredHolder<FluidType, FluidType> SULFURIC_ACID_TYPE =
            FLUID_TYPES.register(
                    "sulfuric_acid",
                    () -> new ChemicalFluidType(
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
                    )
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
