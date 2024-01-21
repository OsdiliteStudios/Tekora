package net.nukollodda.tekora.fluid;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.fluid.data.TekoraFluidPresets;
import net.nukollodda.tekora.fluid.data.TekoraMixturePresets;

public class TekoraFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Tekora.MODID);
    // viscosity of common gases https://www.engineeringtoolbox.com/gases-absolute-dynamic-viscosity-d_1888.html

    public static final RegistryObject<FluidType> HYDROGEN_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(22).temperature(300),
            true, TekoraFluidPresets.HYDROGEN);
    public static final RegistryObject<FluidType> DEUTERIUM_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(22).temperature(300),
            true, TekoraFluidPresets.DEUTERIUM);
    public static final RegistryObject<FluidType> TRITIUM_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(22).temperature(300),
            true, TekoraFluidPresets.TRITIUM);
    public static final RegistryObject<FluidType> HELIUM_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(20).temperature(300),
            true, TekoraFluidPresets.HELIUM);
    public static final RegistryObject<FluidType> NITROGEN_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(45).temperature(300),
            true, TekoraFluidPresets.NITROGEN);
    public static final RegistryObject<FluidType> OXYGEN_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(52).temperature(300).canDrown(false),
            true, TekoraFluidPresets.OXYGEN);
    public static final RegistryObject<FluidType> FLUORINE_GAS = register(FluidType.Properties.create()
                    .density(2).viscosity(58).temperature(300),
            true, TekoraFluidPresets.FLUORINE);
    public static final RegistryObject<FluidType> NEON_GAS = register(FluidType.Properties.create()
                    .density(1).viscosity(32).temperature(300),
            true, TekoraFluidPresets.NEON);
    public static final RegistryObject<FluidType> CHLORINE_GAS = register(FluidType.Properties.create()
                    .density(3).viscosity(33).temperature(300),
            true, TekoraFluidPresets.CHLORINE);
    public static final RegistryObject<FluidType> ARGON_GAS = register(FluidType.Properties.create()
                    .density(2).viscosity(23).temperature(300),
            true, TekoraFluidPresets.ARGON);
    public static final RegistryObject<FluidType> LIQUID_BROMINE = register(FluidType.Properties.create()
                    .density(3120).viscosity(996).temperature(300),
            false, TekoraFluidPresets.BROMINE);
    public static final RegistryObject<FluidType> BROMINE_VAPOR = register(FluidType.Properties.create()
                    .density(8).viscosity(40).temperature(340),
            true, TekoraFluidPresets.BROMINE);
    public static final RegistryObject<FluidType> KRYPTON_GAS = register(FluidType.Properties.create()
                    .density(4).viscosity(50).temperature(300),
            true, TekoraFluidPresets.KRYPTON);
    public static final RegistryObject<FluidType> XENON_GAS = register(FluidType.Properties.create()
                    .density(6).viscosity(23).temperature(300),
            true, TekoraFluidPresets.XENON);

    public static final RegistryObject<FluidType> STEAM = register(FluidType.Properties.create()
                    .density(1).viscosity(25).temperature(500),
            true, TekoraFluidPresets.WATER);
    public static final RegistryObject<FluidType> AMMONIA = register(FluidType.Properties.create()
                    .density(8).viscosity(10).temperature(300),
            true, TekoraFluidPresets.AMMONIA);
    public static final RegistryObject<FluidType> HYDROGEN_FLUORIDE = register(FluidType.Properties.create()
                    .density(1).viscosity(20).temperature(300),
            true, TekoraFluidPresets.HYDROGEN_FLUORIDE);

    public static final RegistryObject<FluidType> HYDROGEN_CHLORIDE = register(FluidType.Properties.create()
                    .density(1).viscosity(311).temperature(300),
            true, TekoraFluidPresets.HYDROGEN_CHLORIDE);
    public static final RegistryObject<FluidType> HYDROGEN_CYANIDE = register(FluidType.Properties.create()
                    .density(1).viscosity(18).temperature(350),
            true, TekoraFluidPresets.HYDROGEN_CYANIDE);

    public static final RegistryObject<FluidType> LIQUID_AMMONIA = register(FluidType.Properties.create()
                    .density(632).viscosity(266).temperature(200),
            false, TekoraFluidPresets.AMMONIA);
    public static final RegistryObject<FluidType> HYDROFLUORIC_ACID = register(FluidType.Properties.create()
                    .density(990).viscosity(1020).temperature(200),
            false, TekoraFluidPresets.HYDROGEN_FLUORIDE);

    public static final RegistryObject<FluidType> HYDROCHLORIC_ACID = register(FluidType.Properties.create()
                    .density(1190).viscosity(1120).temperature(160),
            false, TekoraFluidPresets.HYDROGEN_CHLORIDE);

    public static final RegistryObject<FluidType> NITRIC_ACID = register(FluidType.Properties.create()
                    .density(1510).viscosity(1200).temperature(300),
            false, TekoraFluidPresets.NITRIC_ACID);

    public static final RegistryObject<FluidType> SULFURIC_ACID = register(FluidType.Properties.create()
                    .density(1830).viscosity(2670).temperature(300),
            false, TekoraFluidPresets.SULFURIC_ACID);
    public static final RegistryObject<FluidType> PRUSSIC_ACID = register(FluidType.Properties.create()
                    .density(687).viscosity(183).temperature(265),
            false, TekoraFluidPresets.HYDROGEN_CYANIDE);

    // will be placed in a separate file
    public static final RegistryObject<FluidType> MOLTEN_ALUMINUM = register(FluidType.Properties.create()
                    .density(2700).viscosity(16384).temperature(1000),
            false, TekoraFluidPresets.ALUMINUM);
    public static final RegistryObject<FluidType> GALLIUM_FLUID = register(FluidType.Properties.create()
                    .density(6095).viscosity(16384).temperature(300),
            false, TekoraFluidPresets.GALLIUM);
    public static final RegistryObject<FluidType> MERCURY_FLUID = register(FluidType.Properties.create()
                    .density(13500).viscosity(16384).temperature(300),
            false, TekoraFluidPresets.MERCURY);


    public static final RegistryObject<FluidType> AMMONIUM_HYDROXIDE = register(FluidType.Properties.create()
                    .density(816).viscosity(633).temperature(300),
            false, TekoraMixturePresets.AMMONIA_HYDROXIDE);

    public static final RegistryObject<FluidType> AQUA_REGIA = register(FluidType.Properties
                    .create().density(1270).viscosity(1140).temperature(300),
            false, TekoraMixturePresets.AQUA_REGIA);

    private static RegistryObject<FluidType> register(FluidType.Properties properties, boolean isGaseous,
                                                      TekoraFluidData data) {
        FluidType.Properties modifiedProp = isGaseous ? properties.canExtinguish(false).
                canSwim(false).canPushEntity(false).supportsBoating(false).fallDistanceModifier(0) : properties;

        return FLUID_TYPES.register(isGaseous ? data.getGasName() : data.getLiquidName(), () ->
                new TekoraChemicalFluidType(modifiedProp, data, isGaseous));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
