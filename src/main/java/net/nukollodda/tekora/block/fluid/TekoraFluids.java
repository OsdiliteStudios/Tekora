package net.nukollodda.tekora.block.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;

public class TekoraFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Tekora.MODID);

    // source fluids
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_GAS = FLUIDS.register("hydrogen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_NITROGEN_GAS = FLUIDS.register("nitrogen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.NITROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_OXYGEN_GAS = FLUIDS.register("oxygen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.OXYGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_FLUORINE_GAS = FLUIDS.register("fluorine_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.FLUORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_CHLORINE_GAS = FLUIDS.register("chlorine_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.CHLORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_STEAM = FLUIDS.register("steam",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.STEAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_CYANIDE = FLUIDS.register("hydrogen_cyanide",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_CYANIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_FLUORIDE = FLUIDS.register("hydrogen_fluoride",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AMMONIA = FLUIDS.register("ammonia",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AMMONIA_FLUID = FLUIDS.register("ammonia_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.LIQUID_AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_PRUSSIC_ACID = FLUIDS.register("prussic_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.PRUSSIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROFLUORIC_ACID = FLUIDS.register("hydrofluoric_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROFLUORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_ALUMINUM_MOLTEN = FLUIDS.register("molten_aluminum",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.MOLTEN_ALUMINUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_GALLIUM_FLUID = FLUIDS.register("gallium_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.GALLIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MERCURY_FLUID = FLUIDS.register("mercury_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.MERCURY_FLUID_PROPERTIES));

    // flowing fluids
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_GAS = FLUIDS.register("flowing_hydrogen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NITROGEN_GAS = FLUIDS.register("flowing_nitrogen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.NITROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN_GAS = FLUIDS.register("flowing_oxygen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.OXYGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_FLUORINE_GAS = FLUIDS.register("flowing_fluorine_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.FLUORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE_GAS = FLUIDS.register("flowing_chlorine_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.CHLORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STEAM = FLUIDS.register("flowing_steam",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.STEAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AMMONIA = FLUIDS.register("flowing_ammonia",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_CYANIDE = FLUIDS.register("flowing_hydrogen_cyanide",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_CYANIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_FLUORIDE = FLUIDS.register("flowing_hydrogen_fluoride",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AMMONIA_FLUID = FLUIDS.register("flowing_ammonia_fluid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.LIQUID_AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PRUSSIC_ACID = FLUIDS.register("flowing_prussic_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.PRUSSIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROFLUORIC_ACID = FLUIDS.register("flowing_hydrofluoric_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROFLUORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ALUMINUM_MOLTEN = FLUIDS.register("flowing_aluminum",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.MOLTEN_ALUMINUM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GALLIUM_FLUID = FLUIDS.register("flowing_gallium",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.GALLIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MERCURY_FLUID = FLUIDS.register("flowing_mercury",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.MERCURY_FLUID_PROPERTIES));


    // property registration
    public static final ForgeFlowingFluid.Properties HYDROGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_GAS, SOURCE_HYDROGEN_GAS, FLOWING_HYDROGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties NITROGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.NITROGEN_GAS, SOURCE_NITROGEN_GAS, FLOWING_NITROGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.NITROGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties OXYGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.OXYGEN_GAS, SOURCE_OXYGEN_GAS, FLOWING_OXYGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.OXYGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties FLUORINE_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.FLUORINE_GAS, SOURCE_FLUORINE_GAS, FLOWING_FLUORINE_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.FLUORINE_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties CHLORINE_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.CHLORINE_GAS, SOURCE_CHLORINE_GAS, FLOWING_CHLORINE_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.CHLORINE_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties STEAM_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.STEAM, SOURCE_STEAM, FLOWING_STEAM)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.STEAM_BLOCK);

    public static final ForgeFlowingFluid.Properties AMMONIA_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.AMMONIA, SOURCE_AMMONIA, FLOWING_AMMONIA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.AMMONIA_BLOCK);
    public static final ForgeFlowingFluid.Properties HYDROGEN_FLUORIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_FLUORIDE, SOURCE_HYDROGEN_FLUORIDE, FLOWING_HYDROGEN_FLUORIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_FLUORIDE_BLOCK);
    public static final ForgeFlowingFluid.Properties HYDROGEN_CYANIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_CYANIDE, SOURCE_HYDROGEN_CYANIDE, FLOWING_HYDROGEN_CYANIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_CYANIDE_BLOCK);

    public static final ForgeFlowingFluid.Properties LIQUID_AMMONIA_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.LIQUID_AMMONIA, SOURCE_AMMONIA_FLUID, FLOWING_AMMONIA_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.LIQUID_AMMONIA_BLOCK);
    public static final ForgeFlowingFluid.Properties PRUSSIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.PRUSSIC_ACID, SOURCE_PRUSSIC_ACID, FLOWING_PRUSSIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.PRUSSIC_ACID_BLOCK);
    public static final ForgeFlowingFluid.Properties HYDROFLUORIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROFLUORIC_ACID, SOURCE_HYDROFLUORIC_ACID, FLOWING_HYDROFLUORIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROFLUORIC_ACID_BLOCK);
    public static final ForgeFlowingFluid.Properties MOLTEN_ALUMINUM_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.MOLTEN_ALUMINUM, SOURCE_ALUMINUM_MOLTEN, FLOWING_ALUMINUM_MOLTEN)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.ALUMINUM_MOLTEN_BLOCK);
    public static final ForgeFlowingFluid.Properties GALLIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.GALLIUM_FLUID, SOURCE_GALLIUM_FLUID, FLOWING_GALLIUM_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.GALLIUM_FLUID_BLOCK);
    public static final ForgeFlowingFluid.Properties MERCURY_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.MERCURY_FLUID, SOURCE_MERCURY_FLUID, FLOWING_MERCURY_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.MERCURY_FLUID_BLOCK);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
