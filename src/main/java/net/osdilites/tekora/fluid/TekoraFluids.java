package net.osdilites.tekora.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.item.TekoraItems;

import java.util.function.Supplier;

public class TekoraFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Tekora.MODID);

    public record ChemicalEntry(
            DeferredHolder<Fluid, FlowingFluid> source,
            DeferredHolder<Fluid, FlowingFluid> flowing,
            BaseFlowingFluid.Properties properties
    ) {
        public FlowingFluid getSource() { return source.get(); }
        public FlowingFluid getFlowing() { return flowing.get(); }
    }

    public static final ChemicalEntry ACETIC_ACID = registerChemical(
            "acetic_acid", TekoraFluidTypes.ACETIC_ACID_TYPE, TekoraFluidTypes.ACETIC_ACID_DATA,
            TekoraBlocks.ACETIC_ACID, TekoraItems.ACETIC_ACID_BUCKET
    );

    public static final ChemicalEntry ACETONE = registerChemical(
            "acetone", TekoraFluidTypes.ACETONE_TYPE, TekoraFluidTypes.ACETONE_DATA,
            TekoraBlocks.ACETONE, TekoraItems.ACETONE_BUCKET
    );

    public static final ChemicalEntry AMMONIA = registerChemical(
            "ammonia", TekoraFluidTypes.AMMONIA_TYPE, TekoraFluidTypes.AMMONIA_DATA,
            TekoraBlocks.AMMONIA, TekoraItems.AMMONIA_BUCKET
    );

    public static final ChemicalEntry BENZENE = registerChemical(
            "benzene", TekoraFluidTypes.BENZENE_TYPE, TekoraFluidTypes.BENZENE_DATA,
            TekoraBlocks.BENZENE, TekoraItems.BENZENE_BUCKET
    );

    public static final ChemicalEntry BROMINE = registerChemical(
            "bromine", TekoraFluidTypes.BROMINE_TYPE, TekoraFluidTypes.BROMINE_DATA,
            TekoraBlocks.BROMINE, TekoraItems.BROMINE_BUCKET
    );

    public static final ChemicalEntry ETHANOL = registerChemical(
            "ethanol", TekoraFluidTypes.ETHANOL_TYPE, TekoraFluidTypes.ETHANOL_DATA,
            TekoraBlocks.ETHANOL, TekoraItems.ETHANOL_BUCKET
    );

    public static final ChemicalEntry FORMIC_ACID = registerChemical(
            "formic_acid", TekoraFluidTypes.FORMIC_ACID_TYPE, TekoraFluidTypes.FORMIC_ACID_DATA,
            TekoraBlocks.FORMIC_ACID, TekoraItems.FORMIC_ACID_BUCKET
    );

    public static final ChemicalEntry HYDRAZINE = registerChemical(
            "hydrazine", TekoraFluidTypes.HYDRAZINE_TYPE, TekoraFluidTypes.HYDRAZINE_DATA,
            TekoraBlocks.HYDRAZINE, TekoraItems.HYDRAZINE_BUCKET
    );

    public static final ChemicalEntry HYDROGEN_FLUORIDE = registerChemical(
            "hydrogen_fluoride", TekoraFluidTypes.HYDROGEN_FLUORIDE_TYPE, TekoraFluidTypes.HYDROGEN_FLUORIDE_DATA,
            TekoraBlocks.HYDROGEN_FLUORIDE, TekoraItems.HYDROGEN_FLUORIDE_BUCKET
    );

    public static final ChemicalEntry HYDROGEN_PEROXIDE = registerChemical(
            "hydrogen_peroxide", TekoraFluidTypes.HYDROGEN_PEROXIDE_TYPE, TekoraFluidTypes.HYDROGEN_PEROXIDE_DATA,
            TekoraBlocks.HYDROGEN_PEROXIDE, TekoraItems.HYDROGEN_PEROXIDE_BUCKET
    );

    public static final ChemicalEntry METHANOL = registerChemical(
            "methanol", TekoraFluidTypes.METHANOL_TYPE, TekoraFluidTypes.METHANOL_DATA,
            TekoraBlocks.METHANOL, TekoraItems.METHANOL_BUCKET
    );

    public static final ChemicalEntry SULFUR_DIOXIDE = registerChemical(
            "sulfur_dioxide", TekoraFluidTypes.SULFUR_DIOXIDE_TYPE, TekoraFluidTypes.SULFUR_DIOXIDE_DATA,
            TekoraBlocks.SULFUR_DIOXIDE, TekoraItems.SULFUR_DIOXIDE_BUCKET
    );

    public static final ChemicalEntry SULFUR_TRIOXIDE = registerChemical(
            "sulfur_trioxide", TekoraFluidTypes.SULFUR_TRIOXIDE_TYPE, TekoraFluidTypes.SULFUR_TRIOXIDE_DATA,
            TekoraBlocks.SULFUR_TRIOXIDE, TekoraItems.SULFUR_TRIOXIDE_BUCKET
    );

    public static final ChemicalEntry SULFURIC_ACID = registerChemical(
            "sulfuric_acid", TekoraFluidTypes.SULFURIC_ACID_TYPE, TekoraFluidTypes.SULFURIC_ACID_DATA,
            TekoraBlocks.SULFURIC_ACID, TekoraItems.SULFURIC_ACID_BUCKET
    );



    private static ChemicalEntry registerChemical(
            String name,
            DeferredHolder<FluidType, FluidType> fluidType,
            ChemicalFluidType fluidData,
            Supplier<? extends LiquidBlock> block,
            Supplier<? extends BucketItem> bucket
    ) {
        final BaseFlowingFluid.Properties[] propsHolder = new BaseFlowingFluid.Properties[1];

        DeferredHolder<Fluid, FlowingFluid> source = FLUIDS.register(name,
                () -> new ChemicalFluid.Source(propsHolder[0]));
        DeferredHolder<Fluid, FlowingFluid> flowing = FLUIDS.register(name + "_flowing",
                () -> new ChemicalFluid.Flowing(propsHolder[0]));

        propsHolder[0] = ChemicalFluid.FluidProperties(fluidType, source, flowing, fluidData)
                .block(block)
                .bucket(bucket);

        return new ChemicalEntry(source, flowing, propsHolder[0]);
    }

    public static ResourceKey<Fluid> getRK(FlowingFluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
