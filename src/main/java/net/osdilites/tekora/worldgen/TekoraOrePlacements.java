package net.osdilites.tekora.worldgen;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class TekoraOrePlacements {

//    public static final ResourceKey<PlacedFeature> ORE_NICKEL = PlacementUtils.createKey("ore_nickel");

    public static List<PlacementModifier> orePlacement(PlacementModifier frequencyModifier, PlacementModifier heightRange) {
        return List.of(frequencyModifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
        }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightRange);
    }
}
