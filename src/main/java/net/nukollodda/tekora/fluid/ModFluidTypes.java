package net.nukollodda.tekora.fluid;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");
    public static final ResourceLocation GAS_RL = new ResourceLocation(Tekora.MODID, "misc/gas");
    public static final ResourceLocation ARGON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_argon");
    public static final ResourceLocation BROMINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_bromine");
    public static final ResourceLocation CHLORINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_chlorine");
    public static final ResourceLocation FLUORINE_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_fluorine");
    public static final ResourceLocation HELIUM_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_helium");
    public static final ResourceLocation HYDROGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_hydrogen");
    public static final ResourceLocation KRYPTON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_krypton");
    public static final ResourceLocation NEON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_neon");
    public static final ResourceLocation NITROGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_nitrogen");
    public static final ResourceLocation OXYGEN_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_oxygen");
    public static final ResourceLocation XENON_OVERLAY_RL = new ResourceLocation(Tekora.MODID, "misc/in_xenon");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Tekora.MODID);

    public static final RegistryObject<FluidType> CHLORINE_FLUID_TYPE = register("chlorine",
            FluidType.Properties.create().density(3).viscosity(33));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(GAS_RL, GAS_RL, CHLORINE_OVERLAY_RL, 0xA1A1E639,
                new Vector3f(161f / 255f, 230 / 255f, 57 / 255f), properties));
    }
    /*
  "fluid_type.tekora.ammonium_hydroxide": "Ammonium Hydroxide",
  "fluid_type.tekora.aqua_regia": "Aqua Regia",
  "fluid_type.tekora.carbonic_acid": "Carbonic Acid",
  "fluid_type.tekora.brine": "Natural Brine",
  "fluid_type.tekora.oil": "Oil",

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
        FLUID_TYPES.register(eventBus);
    }
}
