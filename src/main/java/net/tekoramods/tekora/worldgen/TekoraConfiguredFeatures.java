package net.tekoramods.tekora.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;

import java.util.List;

public class TekoraConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_KEY = registerKey("ore_aquamarine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAUXITE_ORE_KEY = registerKey("ore_bauxite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNABAR_ORE_KEY = registerKey("ore_cinnabar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HALITE_ORE_KEY = registerKey("ore_halite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("ore_lead");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NICKEL_ORE_KEY = registerKey("ore_nickel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ore_ruby");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("ore_sapphire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("ore_tin");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> URANINITE_ORE_KEY = registerKey("ore_uraninite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WOLFRAMITE_ORE_KEY = registerKey("ore_wolframite");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_ORE_KEY = registerKey("ore_zircon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("ore_zinc");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EVAPORITE_PLACED_KEY = registerKey("placed_evaporite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_PLACED_KEY = registerKey("placed_limestone");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> aquamarineOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.AQUAMARINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> bauxiteOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.BAUXITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> cinnabarOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.CINNABAR_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> haliteOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.HALITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_HALITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> leadOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> nickelOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.NICKEL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> rubyOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> sapphireOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> tinOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));

//        List<OreConfiguration.TargetBlockState> uraniniteOres = List.of(
//                OreConfiguration.target(stoneReplaceable, TekoraBlocks.URANINITE_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_URANINITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> wolframiteOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.WOLFRAMITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get().defaultBlockState()));

//        List<OreConfiguration.TargetBlockState> zirconOres = List.of(
//                OreConfiguration.target(stoneReplaceable, TekoraBlocks.ZIRCON_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> zincOres = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, TekoraBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> limestone = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.LIMESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> evaporite = List.of(
                OreConfiguration.target(stoneReplaceable, TekoraBlocks.EVAPORITE.get().defaultBlockState()));

        registerOre(context, AQUAMARINE_ORE_KEY, aquamarineOres, 6);
        registerOre(context, BAUXITE_ORE_KEY, bauxiteOres, 10);
        registerOre(context, CINNABAR_ORE_KEY, cinnabarOres, 8);
        registerOre(context, HALITE_ORE_KEY, haliteOres, 8);
        registerOre(context, LEAD_ORE_KEY, leadOres, 8);
        registerOre(context, NICKEL_ORE_KEY, nickelOres, 16);
        registerOre(context, RUBY_ORE_KEY, rubyOres, 6);
        registerOre(context, SAPPHIRE_ORE_KEY, sapphireOres, 6);
        registerOre(context, TIN_ORE_KEY, tinOres, 12);
        //registerOre(context, URANINITE_ORE_KEY, uraniniteOres, 6);
        registerOre(context, WOLFRAMITE_ORE_KEY, wolframiteOres, 8);
        //registerOre(context, ZIRCON_ORE_KEY, zirconOres, 10);
        registerOre(context, ZINC_ORE_KEY, zincOres, 8);
        registerOre(context, EVAPORITE_PLACED_KEY, evaporite, 20);
        registerOre(context, LIMESTONE_PLACED_KEY, limestone, 27);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Tekora.MODID, name));
    }

    // this register method must be kept for potential future uses.
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ? >> key,
            F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static void registerOre(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ? >> key,
            List<OreConfiguration.TargetBlockState> target, int size) {
        context.register(key, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(target, size)));
    }
}
