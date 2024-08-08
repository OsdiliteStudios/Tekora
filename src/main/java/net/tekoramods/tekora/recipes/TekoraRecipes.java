package net.tekoramods.tekora.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.recipes.types.*;

public class TekoraRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Tekora.MODID);

    public static final RegistryObject<RecipeSerializer<InfusionRecipe>> INFUSION_SERIALIZER =
            SERIALIZERS.register("infusion", () -> InfusionRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<AlloyingRecipe>> ALLOYING_SERIALIZER =
            SERIALIZERS.register("alloying", () -> AlloyingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CentrifugeRecipe>> CENTRIFUGE_SERIALIZER =
            SERIALIZERS.register("centrifuge", () -> CentrifugeRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CompressionRecipe>> COMPRESSION_SERIALIZER =
            SERIALIZERS.register("compression", () -> CompressionRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER =
            SERIALIZERS.register("cutting", () -> CuttingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ExtrusionRecipe>> EXTRUSION_SERIALIZER =
            SERIALIZERS.register("extrusion", () -> ExtrusionRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ElectricBlastingRecipe>> BLASTING_SERIALIZER =
            SERIALIZERS.register("blasting", () -> ElectricBlastingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<PulverizingRecipe>> PULVERIZATION_SERIALIZER =
            SERIALIZERS.register("pulverization", () -> PulverizingRecipe.Serializer.INSTANCE);
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
