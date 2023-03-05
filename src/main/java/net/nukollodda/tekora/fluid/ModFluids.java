package net.nukollodda.tekora.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.ModBlocks;
import net.nukollodda.tekora.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Tekora.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_CHLORINE = FLUIDS.register("chlorine",
            () -> new ForgeFlowingFluid.Source(ModFluids.CHLORINE_FLOWING_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE = FLUIDS.register("flowing_chlorine",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CHLORINE_FLOWING_PROPERTIES));


    public static final ForgeFlowingFluid.Properties CHLORINE_FLOWING_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CHLORINE_FLUID_TYPE, SOURCE_CHLORINE, FLOWING_CHLORINE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.CHLORINE_BLOCK);

    /*
  "fluid_type.tekora.ammonium_hydroxide": "Ammonium Hydroxide",
  "fluid_type.tekora.aqua_regia": "Aqua Regia",
  "fluid_type.tekora.carbonic_acid": "Carbonic Acid",
  "fluid_type.tekora.brine": "Natural Brine",
  "fluid_type.tekora.oil": "Oil",

  "fluid_type.tekora.argon": "Argon",
  "fluid_type.tekora.bromine": "Bromine",
  "fluid_type.tekora.chlorine": "Chlorine",
  "fluid_type.tekora.fluorine": "Fluorine",
  "fluid_type.tekora.helium": "Helium",
  "fluid_type.tekora.hydrogen": "Hydrogen",
  "fluid_type.tekora.krypton": "Krypton",
  "fluid_type.tekora.neon": "Neon",
  "fluid_type.tekora.nitrogen": "Nitrogen",
  "fluid_type.tekora.oxygen": "Oxygen",
  "fluid_type.tekora.xenon": "Xenon",

  "fluid_type.tekora.acetone": "Acetone",
  "fluid_type.tekora.acetylene": "Acetylene",
  "fluid_type.tekora.ammonia": "Ammonia",
  "fluid_type.tekora.benzene": "Benzene",
  "fluid_type.tekora.borane": "Borane",
  "fluid_type.tekora.carbon_monoxide": "Carbon Monoxide",
  "fluid_type.tekora.carbon_dioxide": "Carbon Dioxide",
  "fluid_type.tekora.ethane": "Ethane",
  "fluid_type.tekora.ethanol": "Ethanol",
  "fluid_type.tekora.ethylene": "Ethylene",
  "fluid_type.tekora.hydrogen_bromide": "Hydrobromic Acid",
  "fluid_type.tekora.hydrogen_chloride": "Hydrochloric Acid",
  "fluid_type.tekora.hydrogen_fluoride": "Hydrofluoric Acid",
  "fluid_type.tekora.hydrogen_selenide": "Hydrogen Selenide",
  "fluid_type.tekora.hydrogen_sulfide": "Hydrogen Sulfide",
  "fluid_type.tekora.hydrogen_iodide": "Hydroiodic Acid",
  "fluid_type.tekora.methane": "Methane",
  "fluid_type.tekora.methanol": "Ethanol",
  "fluid_type.tekora.nitric_acid": "Nitric Acid",
  "fluid_type.tekora.nitric_oxide": "Nitric Oxide",
  "fluid_type.tekora.oxygen_difluoride": "Oxygen Difluoride",
  "fluid_type.tekora.propane": "Propane",
  "fluid_type.tekora.propylene": "Propylene",
  "fluid_type.tekora.hydrogen_cyanide": "Prussic Acid",
     */

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
