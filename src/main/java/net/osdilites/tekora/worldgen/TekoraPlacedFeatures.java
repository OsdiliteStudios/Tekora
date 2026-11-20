package net.osdilites.tekora.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.osdilites.tekora.Tekora;

import java.util.List;

import static net.osdilites.tekora.worldgen.TekoraConfiguredFeatures.NICKEL_OVERWORLD_ORE;

public class TekoraPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BAUXITE_OVERWORLD_ORES_PLACED = registerKey("bauxite_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> NICKEL_OVERWORLD_ORES_PLACED = registerKey("nickel_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> TIN_OVERWORLD_ORES_PLACED = registerKey("tin_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> ZINC_OVERWORLD_ORES_PLACED = registerKey("zinc_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> LEAD_OVERWORLD_ORES_PLACED = registerKey("lead_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> SILVER_OVERWORLD_ORES_PLACED = registerKey("silver_overworld_ores_placed");
    public static final ResourceKey<PlacedFeature> PLATINUM_OVERWORLD_ORES_PLACED = registerKey("platinum_overworld_ores_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, NICKEL_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.NICKEL_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48))));

        register(context, TIN_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.TIN_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));

        register(context, ZINC_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.ZINC_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(80))));

        register(context, LEAD_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.LEAD_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));

        register(context, SILVER_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.SILVER_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));

        register(context, PLATINUM_OVERWORLD_ORES_PLACED, configuredFeatures.getOrThrow(TekoraConfiguredFeatures.PLATINUM_OVERWORLD_ORE),
                TekoraOrePlacements.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(16))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
