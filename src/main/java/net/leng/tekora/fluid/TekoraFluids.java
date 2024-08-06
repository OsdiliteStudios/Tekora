package net.leng.tekora.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.leng.tekora.Tekora;
import net.leng.tekora.block.TekoraBlocks;
import net.leng.tekora.item.TekoraItems;

public class TekoraFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Tekora.MODID);

    // source fluids
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_GAS = FLUIDS.register("hydrogen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_DEUTERIUM_GAS = FLUIDS.register("deuterium_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.DEUTERIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_TRITIUM_GAS = FLUIDS.register("tritium_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.TRITIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HELIUM_GAS = FLUIDS.register("helium_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HELIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_NITROGEN_GAS = FLUIDS.register("nitrogen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.NITROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_OXYGEN_GAS = FLUIDS.register("oxygen_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.OXYGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_FLUORINE_GAS = FLUIDS.register("fluorine_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.FLUORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_NEON_GAS = FLUIDS.register("neon_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.NEON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_CHLORINE_GAS = FLUIDS.register("chlorine_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.CHLORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_ARGON_GAS = FLUIDS.register("argon_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.ARGON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_KRYPTON_GAS = FLUIDS.register("krypton_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.KRYPTON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_XENON_GAS = FLUIDS.register("xenon_gas",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.XENON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_STEAM = FLUIDS.register("steam",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.STEAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_CYANIDE = FLUIDS.register("hydrogen_cyanide",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_CYANIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_FLUORIDE = FLUIDS.register("hydrogen_fluoride",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROGEN_CHLORIDE = FLUIDS.register("hydrogen_chloride",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROGEN_CHLORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AMMONIA = FLUIDS.register("ammonia",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AMMONIA_FLUID = FLUIDS.register("ammonia_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.LIQUID_AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_BROMINE_FLUID = FLUIDS.register("bromine_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.BROMINE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_PRUSSIC_ACID = FLUIDS.register("prussic_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.PRUSSIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROFLUORIC_ACID = FLUIDS.register("hydrofluoric_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROFLUORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_HYDROCHLORIC_ACID = FLUIDS.register("hydrochloric_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.HYDROCHLORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_NITRIC_ACID = FLUIDS.register("nitric_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.NITRIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_SULFURIC_ACID = FLUIDS.register("sulfuric_acid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.SULFURIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_GALLIUM_FLUID = FLUIDS.register("gallium_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.GALLIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MERCURY_FLUID = FLUIDS.register("mercury_fluid",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.MERCURY_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AMMONIUM_HYDROXIDE = FLUIDS.register("ammonium_hydroxide",
            () -> new ForgeFlowingFluid.Source(TekoraFluids.AMMONIUM_HYDROXIDE_PROPERTIES));

    // flowing fluids
    // flowing gases and gas blocks may be removed in the future in favor of something new
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_GAS = FLUIDS.register("flowing_hydrogen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DEUTERIUM_GAS = FLUIDS.register("flowing_deuterium_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.DEUTERIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TRITIUM_GAS = FLUIDS.register("flowing_tritium_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.TRITIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HELIUM_GAS = FLUIDS.register("flowing_helium_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HELIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NITROGEN_GAS = FLUIDS.register("flowing_nitrogen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.NITROGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN_GAS = FLUIDS.register("flowing_oxygen_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.OXYGEN_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_FLUORINE_GAS = FLUIDS.register("flowing_fluorine_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.FLUORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NEON_GAS = FLUIDS.register("flowing_neon_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.NEON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE_GAS = FLUIDS.register("flowing_chlorine_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.CHLORINE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ARGON_GAS = FLUIDS.register("flowing_argon_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.ARGON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_KRYPTON_GAS = FLUIDS.register("flowing_krypton_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.KRYPTON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_XENON_GAS = FLUIDS.register("flowing_xenon_gas",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.XENON_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STEAM = FLUIDS.register("flowing_steam",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.STEAM_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AMMONIA = FLUIDS.register("flowing_ammonia",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_CYANIDE = FLUIDS.register("flowing_hydrogen_cyanide",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_CYANIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_FLUORIDE = FLUIDS.register("flowing_hydrogen_fluoride",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_FLUORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN_CHLORIDE = FLUIDS.register("flowing_hydrogen_chloride",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROGEN_CHLORIDE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AMMONIA_FLUID = FLUIDS.register("flowing_ammonia_fluid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.LIQUID_AMMONIA_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BROMINE_FLUID = FLUIDS.register("flowing_bromine_fluid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.BROMINE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PRUSSIC_ACID = FLUIDS.register("flowing_prussic_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.PRUSSIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROFLUORIC_ACID = FLUIDS.register("flowing_hydrofluoric_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROFLUORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROCHLORIC_ACID = FLUIDS.register("flowing_hydrochloric_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.HYDROCHLORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NITRIC_ACID = FLUIDS.register("flowing_nitric_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.NITRIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SULFURIC_ACID = FLUIDS.register("flowing_sulfuric_acid",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.SULFURIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GALLIUM_FLUID = FLUIDS.register("flowing_gallium",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.GALLIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MERCURY_FLUID = FLUIDS.register("flowing_mercury",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.MERCURY_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AMMONIUM_HYDROXIDE = FLUIDS.register("flowing_ammonium_hydroxide",
            () -> new ForgeFlowingFluid.Flowing(TekoraFluids.AMMONIUM_HYDROXIDE_PROPERTIES));


    // property registration
    public static final ForgeFlowingFluid.Properties HYDROGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_GAS, SOURCE_HYDROGEN_GAS, FLOWING_HYDROGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties DEUTERIUM_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.DEUTERIUM_GAS, SOURCE_DEUTERIUM_GAS, FLOWING_DEUTERIUM_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.DEUTERIUM_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties TRITIUM_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.TRITIUM_GAS, SOURCE_TRITIUM_GAS, FLOWING_TRITIUM_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.TRITIUM_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties HELIUM_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HELIUM_GAS, SOURCE_HELIUM_GAS, FLOWING_HELIUM_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HELIUM_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties NITROGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.NITROGEN_GAS, SOURCE_NITROGEN_GAS, FLOWING_NITROGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.NITROGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties OXYGEN_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.OXYGEN_GAS, SOURCE_OXYGEN_GAS, FLOWING_OXYGEN_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.OXYGEN_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties FLUORINE_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.FLUORINE_GAS, SOURCE_FLUORINE_GAS, FLOWING_FLUORINE_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.FLUORINE_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties NEON_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.NEON_GAS, SOURCE_NEON_GAS, FLOWING_NEON_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.NEON_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties CHLORINE_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.CHLORINE_GAS, SOURCE_CHLORINE_GAS, FLOWING_CHLORINE_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.CHLORINE_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties ARGON_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.ARGON_GAS, SOURCE_ARGON_GAS, FLOWING_ARGON_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.ARGON_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties KRYPTON_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.KRYPTON_GAS, SOURCE_KRYPTON_GAS, FLOWING_KRYPTON_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.KRYPTON_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties XENON_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.XENON_GAS, SOURCE_XENON_GAS, FLOWING_XENON_GAS)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.XENON_GAS_BLOCK);
    public static final ForgeFlowingFluid.Properties STEAM_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.STEAM, SOURCE_STEAM, FLOWING_STEAM)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.STEAM_BLOCK);

    public static final ForgeFlowingFluid.Properties AMMONIA_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.AMMONIA, SOURCE_AMMONIA, FLOWING_AMMONIA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.AMMONIA_BLOCK);
    public static final ForgeFlowingFluid.Properties HYDROGEN_FLUORIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_FLUORIDE, SOURCE_HYDROGEN_FLUORIDE, FLOWING_HYDROGEN_FLUORIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_FLUORIDE_BLOCK);

    public static final ForgeFlowingFluid.Properties HYDROGEN_CHLORIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROGEN_CHLORIDE, SOURCE_HYDROGEN_CHLORIDE, FLOWING_HYDROGEN_CHLORIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROGEN_CHLORIDE_BLOCK);
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

    public static final ForgeFlowingFluid.Properties HYDROCHLORIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.HYDROCHLORIC_ACID, SOURCE_HYDROCHLORIC_ACID, FLOWING_HYDROCHLORIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.HYDROCHLORIC_ACID_BLOCK);

    public static final ForgeFlowingFluid.Properties NITRIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.NITRIC_ACID, SOURCE_NITRIC_ACID, FLOWING_NITRIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.NITRIC_ACID_BLOCK);

    public static final ForgeFlowingFluid.Properties SULFURIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.SULFURIC_ACID, SOURCE_SULFURIC_ACID, FLOWING_SULFURIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.SULFURIC_ACID_BLOCK);

    public static final ForgeFlowingFluid.Properties BROMINE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.LIQUID_BROMINE, SOURCE_BROMINE_FLUID, FLOWING_BROMINE_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.BROMINE_BLOCK);
    public static final ForgeFlowingFluid.Properties GALLIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.GALLIUM_FLUID, SOURCE_GALLIUM_FLUID, FLOWING_GALLIUM_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.GALLIUM_FLUID_BLOCK);
    public static final ForgeFlowingFluid.Properties MERCURY_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.MERCURY_FLUID, SOURCE_MERCURY_FLUID, FLOWING_MERCURY_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.MERCURY_FLUID_BLOCK);

    public static final ForgeFlowingFluid.Properties AMMONIUM_HYDROXIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            TekoraFluidTypes.AMMONIUM_HYDROXIDE, SOURCE_AMMONIUM_HYDROXIDE, FLOWING_AMMONIUM_HYDROXIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(TekoraBlocks.AMMONIUM_HYDROXIDE_BLOCK).bucket(TekoraItems.AMMONIUM_HYDROXIDE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
