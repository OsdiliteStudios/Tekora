package net.osdilites.tekora.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;

import java.util.List;

public class TekoraConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAUXITE_OVERWORLD_ORES = registerKey("bauxite_overworld_ores");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
//        List<OreConfiguration.TargetBlockState> overworldZirconOres = List.of(
//                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), TekoraBlocks.BAUXITE_ORE.get().defaultBlockState()),
//                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), TekoraBlocks.BAUXITE_DEEPSLATE_ORE.get().defaultBlockState()));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
