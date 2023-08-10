package net.nukollodda.tekora.block.fluid;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.minecraft.resources.ResourceLocation;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidData;
import net.nukollodda.tekora.block.fluid.data.TekoraFluidPresets;
import org.joml.Vector3f;

public class TekoraFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");

    // fluid texture registration
    public static final ResourceLocation GAS_RL = new ResourceLocation(Tekora.MODID, "fluid/gas");
    public static final ResourceLocation ARGON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_argon");
    public static final ResourceLocation BROMINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_bromine");
    public static final ResourceLocation CHLORINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_chlorine");
    public static final ResourceLocation FLUORINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_fluorine");
    public static final ResourceLocation HELIUM_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_helium");
    public static final ResourceLocation HYDROGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_hydrogen");
    public static final ResourceLocation KRYPTON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_krypton");
    public static final ResourceLocation NEON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_neon");
    public static final ResourceLocation NITROGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_nitrogen");
    public static final ResourceLocation OXYGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_oxygen");
    public static final ResourceLocation XENON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_xenon");
    public static final ResourceLocation MERCURY_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_mercury");
    private static final ResourceLocation STEAM_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "fluid/in_steam");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Tekora.MODID);

    /* viscosity of common gases
     * NH4 - 25
     * Ar - 57
     * Benzene - 19 - likely a BioTekora addition
     * CO2 - 38
     * CO - 45
     * Chloroform - 26
     * C2H4 - 26
     * He - 50
     * CH4 - 28
     * Ne - 80
     * N2O - 38 (nitrous oxide)
     * H2O - 25
     * SO2 - 32
     * Xe - 58
     * rgb(199, 219, 225)
     */
    // fluid registration

    public static final RegistryObject<FluidType> HYDROGEN_GAS = register("hydrogen_gas",
            FluidType.Properties.create().density(1).viscosity(22).temperature(300), HYDROGEN_OVERLAY_RL, 0xA1F2D9D2,
            true, TekoraFluidPresets.HYDROGEN);

    public static final RegistryObject<FluidType> NITROGEN_GAS = register("nitrogen_gas",
            FluidType.Properties.create().density(1).viscosity(45).temperature(300), NITROGEN_OVERLAY_RL, 0xA1C7DBE1,
            true, TekoraFluidPresets.NITROGEN);

    public static final RegistryObject<FluidType> OXYGEN_GAS = register("oxygen_gas",
            FluidType.Properties.create().density(1).viscosity(52).temperature(300), OXYGEN_OVERLAY_RL, 0xA158A4D6,
            true, TekoraFluidPresets.OXYGEN);

    public static final RegistryObject<FluidType> FLUORINE_GAS = register("fluorine_gas",
            FluidType.Properties.create().density(2).viscosity(58).temperature(300), FLUORINE_OVERLAY_RL, 0xA1C5E55E,
            true, TekoraFluidPresets.FLUORINE);
    public static final RegistryObject<FluidType> CHLORINE_GAS = register("chlorine_gas",
            FluidType.Properties.create().density(3).viscosity(33).temperature(300), CHLORINE_OVERLAY_RL, 0xA1A1E639,
            true, TekoraFluidPresets.CHLORINE);

    public static final RegistryObject<FluidType> STEAM = register("steam",
            FluidType.Properties.create().density(1).viscosity(25).temperature(500), STEAM_OVERLAY_RL, 0xA1DFDFDF,
            true, TekoraFluidPresets.WATER);
    public static final RegistryObject<FluidType> MERCURY_FLUID = register("mercury_fluid",
            FluidType.Properties.create().density(13906).viscosity(16384).temperature(300), MERCURY_OVERLAY_RL, 0xA1666666,
            false, TekoraFluidPresets.MERCURY);


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties, ResourceLocation location, int color, boolean isGaseous,
                                                      TekoraFluidData data) {
        FluidType.Properties modifiedProp = isGaseous ? properties.canDrown(false).
                canExtinguish(false).canSwim(false).canPushEntity(false).supportsBoating(false) : properties;
        ResourceLocation stillTexture = isGaseous ? GAS_RL : WATER_STILL_RL;
        ResourceLocation flowingTexture = isGaseous ? GAS_RL : WATER_FLOWING_RL;

        return FLUID_TYPES.register(name, () -> new TekoraFluidType(stillTexture, flowingTexture,
                location, color, new Vector3f(161f / 255f, 230 / 255f, 57 / 255f), modifiedProp, data, isGaseous));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
