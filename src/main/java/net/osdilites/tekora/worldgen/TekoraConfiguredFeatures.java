package net.osdilites.tekora.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.osdilites.tekora.Config;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;

import java.util.List;

public class TekoraConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAUXITE_OVERWORLD_ORES = registerKey("bauxite_overworld_ores");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NICKEL_OVERWORLD_ORE = registerKey("nickel_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_OVERWORLD_ORE = registerKey("zinc_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_OVERWORLD_ORE = registerKey("silver_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_OVERWORLD_ORE = registerKey("tin_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_OVERWORLD_ORE = registerKey("lead_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLATINUM_OVERWORLD_ORE = registerKey("platinum_overworld_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
//        List<OreConfiguration.TargetBlockState> overworldZirconOres = List.of(
//                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), TekoraBlocks.BAUXITE_ORE.get().defaultBlockState()),
//                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), TekoraBlocks.BAUXITE_DEEPSLATE_ORE.get().defaultBlockState()));
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, NICKEL_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.NICKEL_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.NICKEL_ORE.get().defaultBlockState())), 8
        ));

        register(context, ZINC_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.ZINC_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.ZINC_ORE.get().defaultBlockState())), 9
        ));

        register(context, SILVER_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.SILVER_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.SILVER_ORE.get().defaultBlockState())), 9, 0.5f
        ));

        register(context, TIN_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.TIN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.TIN_ORE.get().defaultBlockState())), 11
        ));

        register(context, LEAD_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.LEAD_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.LEAD_ORE.get().defaultBlockState())), 8
        ));

        register(context, PLATINUM_OVERWORLD_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, TekoraBlocks.PLATINUM_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, TekoraBlocks.PLATINUM_ORE.get().defaultBlockState())), 5, 0.7f
        ));



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Tekora.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
