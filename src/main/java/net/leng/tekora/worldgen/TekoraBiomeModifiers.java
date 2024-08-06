package net.leng.tekora.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.leng.tekora.Tekora;

public class TekoraBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_ORE = registerKey("ore_aquamarine");
    public static final ResourceKey<BiomeModifier> ADD_BAUXITE_ORE = registerKey("ore_bauxite");
    public static final ResourceKey<BiomeModifier> ADD_CINNABAR_ORE = registerKey("ore_cinnabar");
    public static final ResourceKey<BiomeModifier> ADD_HALITE_ORE = registerKey("ore_halite");
    public static final ResourceKey<BiomeModifier> ADD_LEAD_ORE = registerKey("ore_lead");
    public static final ResourceKey<BiomeModifier> ADD_NICKEL_ORE = registerKey("ore_nickel");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("ore_ruby");
    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("ore_sapphire");
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("ore_tin");
    public static final ResourceKey<BiomeModifier> ADD_URANINITE_ORE = registerKey("ore_uraninite");
    public static final ResourceKey<BiomeModifier> ADD_WOLFRAMITE_ORE = registerKey("ore_wolframite");
    public static final ResourceKey<BiomeModifier> ADD_ZINC_ORE = registerKey("ore_zinc");
    public static final ResourceKey<BiomeModifier> ADD_ZIRCON_ORE = registerKey("ore_zircon");
    public static final ResourceKey<BiomeModifier> ADD_EVAPORITE = registerKey("placed_evaporite");
    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE = registerKey("placed_limestone");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_AQUAMARINE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.AQUAMARINE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_BAUXITE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.BAUXITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CINNABAR_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.CINNABAR_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_HALITE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.HALITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LEAD_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.LEAD_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NICKEL_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.NICKEL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RUBY_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.RUBY_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SAPPHIRE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.SAPPHIRE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TIN_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.TIN_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_URANINITE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.URANINITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WOLFRAMITE_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.WOLFRAMITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ZINC_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.ZINC_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ZIRCON_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.ZIRCON_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EVAPORITE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.EVAPORITE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LIMESTONE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.LIMESTONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Tekora.MODID, name));
    }
}
