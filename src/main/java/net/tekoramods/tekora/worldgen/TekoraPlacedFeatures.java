package net.tekoramods.tekora.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.tekoramods.tekora.Tekora;

import java.util.List;

public class TekoraPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AQUAMARINE_ORE = registerKey("ore_aquamarine");
    public static final ResourceKey<PlacedFeature> BAUXITE_ORE = registerKey("ore_bauxite");
    public static final ResourceKey<PlacedFeature> CINNABAR_ORE = registerKey("ore_cinnabar");
    public static final ResourceKey<PlacedFeature> HALITE_ORE = registerKey("ore_halite");
    public static final ResourceKey<PlacedFeature> LEAD_ORE = registerKey("ore_lead");
    public static final ResourceKey<PlacedFeature> NICKEL_ORE = registerKey("ore_nickel");
    public static final ResourceKey<PlacedFeature> RUBY_ORE = registerKey("ore_ruby");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE = registerKey("ore_sapphire");
    public static final ResourceKey<PlacedFeature> TIN_ORE = registerKey("ore_tin");
    public static final ResourceKey<PlacedFeature> URANINITE_ORE = registerKey("ore_uraninite");
    public static final ResourceKey<PlacedFeature> WOLFRAMITE_ORE = registerKey("ore_wolframite");
    public static final ResourceKey<PlacedFeature> ZINC_ORE = registerKey("ore_zinc");
    public static final ResourceKey<PlacedFeature> ZIRCON_ORE = registerKey("ore_zircon");
    public static final ResourceKey<PlacedFeature> EVAPORITE = registerKey("placed_evaporite");
    public static final ResourceKey<PlacedFeature> LIMESTONE = registerKey("placed_limestone");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, AQUAMARINE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.AQUAMARINE_ORE_KEY),
                commonOrePlacement(2,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(58))));

        register(context, BAUXITE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.BAUXITE_ORE_KEY),
                commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-45), VerticalAnchor.absolute(58))));

        register(context, CINNABAR_ORE, configured.getOrThrow(TekoraConfiguredFeatures.CINNABAR_ORE_KEY),
                commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(8), VerticalAnchor.absolute(80))));

        register(context, HALITE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.HALITE_ORE_KEY),
                commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(110))));

        register(context, LEAD_ORE, configured.getOrThrow(TekoraConfiguredFeatures.LEAD_ORE_KEY),
                commonOrePlacement(18,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-28), VerticalAnchor.absolute(110))));

        register(context, NICKEL_ORE, configured.getOrThrow(TekoraConfiguredFeatures.NICKEL_ORE_KEY),
                commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(96))));

        register(context, RUBY_ORE, configured.getOrThrow(TekoraConfiguredFeatures.RUBY_ORE_KEY),
                commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(96))));

        register(context, SAPPHIRE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.SAPPHIRE_ORE_KEY),
                commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(76))));

        register(context, TIN_ORE, configured.getOrThrow(TekoraConfiguredFeatures.TIN_ORE_KEY),
                commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(125))));

        register(context, URANINITE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.URANINITE_ORE_KEY),
                commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(30))));

        register(context, WOLFRAMITE_ORE, configured.getOrThrow(TekoraConfiguredFeatures.WOLFRAMITE_ORE_KEY),
                commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(15))));

        register(context, ZINC_ORE, configured.getOrThrow(TekoraConfiguredFeatures.ZINC_ORE_KEY),
                commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-23), VerticalAnchor.absolute(65))));

        register(context, ZIRCON_ORE, configured.getOrThrow(TekoraConfiguredFeatures.ZIRCON_ORE_KEY),
                commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-23), VerticalAnchor.absolute(41))));

        register(context, EVAPORITE, configured.getOrThrow(TekoraConfiguredFeatures.EVAPORITE_PLACED_KEY),
                commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(68))));

        register(context, LIMESTONE, configured.getOrThrow(TekoraConfiguredFeatures.LIMESTONE_PLACED_KEY),
                commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(90))));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier pModifier, PlacementModifier pSecondaryModifier) {
        return List.of(pModifier, InSquarePlacement.spread(), pSecondaryModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Tekora.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> holder, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(holder, List.copyOf(modifiers)));
    }
}
