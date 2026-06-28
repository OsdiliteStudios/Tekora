package net.osdilites.tekora.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.osdilites.tekora.Tekora;

import java.util.List;

public class TekoraBiomeModifiers {
    // public static final ResourceKey<PlacedFeature> BAUXITE_OVERWORLD_ORES_PLACED = registerKey("bauxite_overworld_ores_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

//        register(context, BAUXITE_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.BAUXITE_OVERWORLD_ORES),
//                TekoraOrePlacements.commonOrePlacement(12,
//                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

//        register(context, RUBBER_TREE_PLACED_KEY, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.RUBBER_TREE_KEY),
//                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
//                        ModBlocks.RUBBER_SAPLING.get()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
