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

public class TekoraFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Tekora.MODID);
    /* viscosity of common gases https://www.engineeringtoolbox.com/gases-absolute-dynamic-viscosity-d_1888.html
     */

    public static final RegistryObject<FluidType> HYDROGEN_GAS = register("hydrogen_gas",
            FluidType.Properties.create().density(1).viscosity(22).temperature(300), TekoraFluidTextures.HYDROGEN_OVERLAY_RL,
            true, TekoraFluidPresets.HYDROGEN);

    public static final RegistryObject<FluidType> NITROGEN_GAS = register("nitrogen_gas",
            FluidType.Properties.create().density(1).viscosity(45).temperature(300), TekoraFluidTextures.NITROGEN_OVERLAY_RL,
            true, TekoraFluidPresets.NITROGEN);

    public static final RegistryObject<FluidType> OXYGEN_GAS = register("oxygen_gas",
            FluidType.Properties.create().density(1).viscosity(52).temperature(300).canDrown(false), TekoraFluidTextures.OXYGEN_OVERLAY_RL,
            true, TekoraFluidPresets.OXYGEN);

    public static final RegistryObject<FluidType> FLUORINE_GAS = register("fluorine_gas",
            FluidType.Properties.create().density(2).viscosity(58).temperature(300), TekoraFluidTextures.FLUORINE_OVERLAY_RL,
            true, TekoraFluidPresets.FLUORINE);
    public static final RegistryObject<FluidType> CHLORINE_GAS = register("chlorine_gas",
            FluidType.Properties.create().density(3).viscosity(33).temperature(300), TekoraFluidTextures.CHLORINE_OVERLAY_RL,
            true, TekoraFluidPresets.CHLORINE);

    public static final RegistryObject<FluidType> STEAM = register("steam",
            FluidType.Properties.create().density(1).viscosity(25).temperature(500), TekoraFluidTextures.STEAM_OVERLAY_RL,
            true, TekoraFluidPresets.WATER);

    public static final RegistryObject<FluidType> MOLTEN_ALUMINUM = register("molten_aluminum",
            FluidType.Properties.create().density(2700).viscosity(16384).temperature(1000), TekoraFluidTextures.METAL_OVERLAY_RL,
            false, TekoraFluidPresets.ALUMINUM);

    public static final RegistryObject<FluidType> GALLIUM_FLUID = register("gallium_fluid",
            FluidType.Properties.create().density(6095).viscosity(16384).temperature(300), TekoraFluidTextures.METAL_OVERLAY_RL,
            false, TekoraFluidPresets.GALLIUM);
    public static final RegistryObject<FluidType> MERCURY_FLUID = register("mercury_fluid",
            FluidType.Properties.create().density(13500).viscosity(16384).temperature(300), TekoraFluidTextures.METAL_OVERLAY_RL,
            false, TekoraFluidPresets.MERCURY);


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties, ResourceLocation location, boolean isGaseous,
                                                      TekoraFluidData data) {
        FluidType.Properties modifiedProp = isGaseous ? properties.canExtinguish(false).
                canSwim(false).canPushEntity(false).supportsBoating(false).fallDistanceModifier(0) : properties;

        return FLUID_TYPES.register(name, () -> new TekoraFluidType(location, isGaseous ? data.getGasColor() : data.getLiquidColor(), modifiedProp, data, isGaseous));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
