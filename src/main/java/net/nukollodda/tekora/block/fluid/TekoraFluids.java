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
    public static final ForgeFlowingFluid.Properties MERCURY_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.MERCURY_FLUID, SOURCE_MERCURY_FLUID, FLOWING_MERCURY_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.MERCURY_FLUID_BLOCK);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
