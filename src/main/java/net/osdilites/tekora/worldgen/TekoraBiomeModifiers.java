package net.osdilites.tekora.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.osdilites.tekora.Tekora;

import java.util.List;

public class TekoraBiomeModifiers {
    // public static final ResourceKey<PlacedFeature> BAUXITE_OVERWORLD_ORES_PLACED = registerKey("bauxite_overworld_ores_placed");

    // followed from KaupenJoe tutorial
    public static final ResourceKey<BiomeModifier> NICKEL_OVERWORLD_ORES_PLACED = registerKey("nickel_overworld_ores_placed");
    public static final ResourceKey<BiomeModifier> TIN_OVERWORLD_ORES_PLACED = registerKey("tin_overworld_ores_placed");
    public static final ResourceKey<BiomeModifier> ZINC_OVERWORLD_ORES_PLACED = registerKey("zinc_overworld_ores_placed");
    public static final ResourceKey<BiomeModifier> LEAD_OVERWORLD_ORES_PLACED = registerKey("lead_overworld_ores_placed");
    public static final ResourceKey<BiomeModifier> SILVER_OVERWORLD_ORES_PLACED = registerKey("silver_overworld_ores_placed");
    public static final ResourceKey<BiomeModifier> PLATINUM_OVERWORLD_ORES_PLACED = registerKey("platinum_overworld_ores_placed");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // followed from KaupenJoe tutorial
        context.register(NICKEL_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.NICKEL_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(TIN_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.TIN_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ZINC_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.ZINC_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(LEAD_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.LEAD_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(SILVER_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.SILVER_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(PLATINUM_OVERWORLD_ORES_PLACED, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TekoraPlacedFeatures.PLATINUM_OVERWORLD_ORES_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));



//        register(context, BAUXITE_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.BAUXITE_OVERWORLD_ORES),
//                TekoraOrePlacements.commonOrePlacement(12,
//                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

//        register(context, RUBBER_TREE_PLACED_KEY, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.RUBBER_TREE_KEY),
//                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
//                        ModBlocks.RUBBER_SAPLING.get()));

    }

//    private static ResourceKey<PlacedFeature> registerKey(String name) {
//        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
//    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
