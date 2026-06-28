package net.osdilites.tekora.recipes;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

public class TekoraRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Tekora.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Tekora.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ReactionRecipe>> REACTION_SERIALIZER =
            SERIALIZERS.register("reaction", () -> new RecipeSerializer<>(ReactionRecipe.CODEC, ReactionRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<ReactionRecipe>> REACTION_TYPE =
            TYPES.register("reaction", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "reaction";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
