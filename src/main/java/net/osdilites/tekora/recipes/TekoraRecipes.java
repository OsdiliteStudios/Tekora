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

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER =
            SERIALIZERS.register("cutting", () -> new RecipeSerializer<>(CuttingRecipe.CODEC, CuttingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<CuttingRecipe>> CUTTING_TYPE =
            TYPES.register("cutting", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "cutting";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER =
            SERIALIZERS.register("crushing", () -> new RecipeSerializer<>(CrushingRecipe.CODEC, CrushingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<CrushingRecipe>> CRUSHING_TYPE =
            TYPES.register("crushing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "crushing";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PressingRecipe>> PRESSING_SERIALIZER =
            SERIALIZERS.register("pressing", () -> new RecipeSerializer<>(PressingRecipe.CODEC, PressingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<PressingRecipe>> PRESSING_TYPE =
            TYPES.register("pressing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "pressing";
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

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MacerationRecipe>> MACERATION_SERIALIZER =
            SERIALIZERS.register("maceration", () -> new RecipeSerializer<>(MacerationRecipe.CODEC, MacerationRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<MacerationRecipe>> MACERATION_TYPE =
            TYPES.register("maceration", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "maceration";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CompressingRecipe>> COMPRESSING_SERIALIZER =
            SERIALIZERS.register("mixing", () -> new RecipeSerializer<>(CompressingRecipe.CODEC, CompressingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<CompressingRecipe>> COMPRESSING_TYPE =
            TYPES.register("mixing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "mixing";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MixingRecipe>> MIXING_SERIALIZER =
            SERIALIZERS.register("mixing", () -> new RecipeSerializer<>(MixingRecipe.CODEC, MixingRecipe.STREAM_CODEC));
    public static final DeferredHolder<RecipeType<?>, RecipeType<MixingRecipe>> MIXING_TYPE =
            TYPES.register("mixing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "mixing";
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
