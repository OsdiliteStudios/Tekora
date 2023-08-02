package net.nukollodda.tekora.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Tekora.MODID);

    public static final RegistryObject<RecipeSerializer<InfusionRecipe>> INFUSION_SERIALIZER =
            SERIALIZERS.register("infusion", () -> InfusionRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<AlloyingRecipe>> ALLOYING_SERIALIZER =
            SERIALIZERS.register("alloying", () -> AlloyingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER =
            SERIALIZERS.register("crushing", () -> CrushingRecipe.Serializer.INSTANCE);
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
