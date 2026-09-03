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

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<DepotRecipe>> DEPOT_SERIALIZER =
            SERIALIZERS.register("depot", () -> new RecipeSerializer<>(DepotRecipe.CODEC, DepotRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<DepotRecipe>> DEPOT_TYPE =
            TYPES.register("depot", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "depot";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AssemblingRecipe>> ASSEMBLING_SERIALIZER =
            SERIALIZERS.register("assembling", () -> new RecipeSerializer<>(AssemblingRecipe.CODEC, AssemblingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<AssemblingRecipe>> ASSEMBLING_TYPE =
            TYPES.register("assembling", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "assembling";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PrintingRecipe>> PRINTING_SERIALIZER =
            SERIALIZERS.register("printing", () -> new RecipeSerializer<>(PrintingRecipe.CODEC, PrintingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<PrintingRecipe>> PRINTING_TYPE =
            TYPES.register("printing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "printing";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BasinRecipe>> BASIN_SERIALIZER =
            SERIALIZERS.register("basin", () -> new RecipeSerializer<>(BasinRecipe.CODEC, BasinRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<BasinRecipe>> BASIN_TYPE =
            TYPES.register("basin", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "basin";
                }
            });

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
