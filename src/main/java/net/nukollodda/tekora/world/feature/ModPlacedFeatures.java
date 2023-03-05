package net.nukollodda.tekora.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Tekora.MODID);

    public static final RegistryObject<PlacedFeature> APATITE_ORE_PLACED = PLACED_FEATURES.register("apatite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.APATITE_ORE.getHolder().get(),
                    commonOrePlacement(32,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(90), VerticalAnchor.aboveBottom(-45)))));

    public static final RegistryObject<PlacedFeature> AQUAMARINE_ORE_PLACED = PLACED_FEATURES.register("aquamarine_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.AQUAMARINE_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-20), VerticalAnchor.aboveBottom(58)))));

    public static final RegistryObject<PlacedFeature> BAUXITE_ORE_PLACED = PLACED_FEATURES.register("bauxite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BAUXITE_ORE.getHolder().get(),
                    commonOrePlacement(28,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(101)))));

    public static final RegistryObject<PlacedFeature> CASSITERITE_ORE_PLACED = PLACED_FEATURES.register("cassiterite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CASSITERITE_ORE.getHolder().get(),
                    commonOrePlacement(20,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(125), VerticalAnchor.aboveBottom(6)))));

    public static final RegistryObject<PlacedFeature> CHROMITE_ORE_PLACED = PLACED_FEATURES.register("chromite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHROMITE_ORE.getHolder().get(),
                    commonOrePlacement(8,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(30)))));

    public static final RegistryObject<PlacedFeature> CINNABAR_ORE_PLACED = PLACED_FEATURES.register("cinnabar_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CINNABAR_ORE.getHolder().get(),
                    commonOrePlacement(18,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> GALENA_ORE_PLACED = PLACED_FEATURES.register("galena_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GALENA_ORE.getHolder().get(),
                    commonOrePlacement(28,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-28), VerticalAnchor.aboveBottom(110)))));

    public static final RegistryObject<PlacedFeature> GARNET_ORE_PLACED = PLACED_FEATURES.register("garnet_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GARNET_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-18), VerticalAnchor.aboveBottom(48)))));

    public static final RegistryObject<PlacedFeature> GRAPHITE_ORE_PLACED = PLACED_FEATURES.register("graphite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GRAPHITE_ORE.getHolder().get(),
                    commonOrePlacement(26,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> PENTLANDITE_ORE_PLACED = PLACED_FEATURES.register("pentlandite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PENTLANDITE_ORE.getHolder().get(),
                    commonOrePlacement(24,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-35), VerticalAnchor.aboveBottom(89)))));

    public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = PLACED_FEATURES.register("ruby_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-20), VerticalAnchor.aboveBottom(96)))));


    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE_PLACED = PLACED_FEATURES.register("sapphire_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAPPHIRE_ORE.getHolder().get(),
                    commonOrePlacement(9,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-10), VerticalAnchor.aboveBottom(76)))));

    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = PLACED_FEATURES.register("silver_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-48), VerticalAnchor.aboveBottom(10)))));

    public static final RegistryObject<PlacedFeature> URANINITE_ORE_PLACED = PLACED_FEATURES.register("uraninite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.URANINITE_ORE.getHolder().get(),
                    commonOrePlacement(8,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-50), VerticalAnchor.aboveBottom(38)))));

    public static final RegistryObject<PlacedFeature> ZIRCON_ORE_PLACED = PLACED_FEATURES.register("zircon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ZIRCON_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-23), VerticalAnchor.aboveBottom(41)))));

    public static final RegistryObject<PlacedFeature> NETHER_CHROMITE_ORE_PLACED = PLACED_FEATURES.register("nether_chromite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_CHROMITE_ORE.getHolder().get(),
                    commonOrePlacement(8,
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(200)))));

    public static final RegistryObject<PlacedFeature> RIVER_BAUXITE_ORE_PLACED = PLACED_FEATURES.register("river_bauxite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RIVER_BAUXITE_ORE.getHolder().get(),
                    commonOrePlacement(8,
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(20), VerticalAnchor.aboveBottom(100)))));


    public static final RegistryObject<PlacedFeature> BORAX_SPAWNED = PLACED_FEATURES.register("borax_spawned",
            () -> new PlacedFeature(ModConfiguredFeatures.BORAX_SPAWN.getHolder().get(),
                    commonOrePlacement(5,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(72), VerticalAnchor.aboveBottom(50)))));

    public static final RegistryObject<PlacedFeature> EPSOMITE_SPAWNED = PLACED_FEATURES.register("epsomite_spawned",
            () -> new PlacedFeature(ModConfiguredFeatures.EPSOMITE_SPAWN.getHolder().get(),
                    commonOrePlacement(3,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(40), VerticalAnchor.aboveBottom(75)))));

    public static final RegistryObject<PlacedFeature> SALT_SPAWNED = PLACED_FEATURES.register("salt_spawned",
            () -> new PlacedFeature(ModConfiguredFeatures.SALT_SPAWN.getHolder().get(),
                    commonOrePlacement(16,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(30), VerticalAnchor.aboveBottom(75)))));


    public static final RegistryObject<PlacedFeature> EVAPORITE_SPAWNED = PLACED_FEATURES.register("evaporite_spawned",
            () -> new PlacedFeature(ModConfiguredFeatures.EVAPORITE_SPAWN.getHolder().get(),
                    commonOrePlacement(6,
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(68), VerticalAnchor.aboveBottom(0)))));

    public static final RegistryObject<PlacedFeature> LIMESTONE_SPAWNED = PLACED_FEATURES.register("limestone_spawned",
            () -> new PlacedFeature(ModConfiguredFeatures.LIMESTONE_SPAWN.getHolder().get(),
                    commonOrePlacement(9,
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(90), VerticalAnchor.aboveBottom(-25)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(veinsPerChunk), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
