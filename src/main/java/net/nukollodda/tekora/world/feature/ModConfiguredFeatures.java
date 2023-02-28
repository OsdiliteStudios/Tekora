package net.nukollodda.tekora.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Tekora.MODID);


    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_APATITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.APATITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_APATITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CALCITE), ModBlocks.CALCITE_APATITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.GRANITE), ModBlocks.GRANITE_APATITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_AQUAMARINE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AQUAMARINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BAUXITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BAUXITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CASSITERITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CASSITERITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CASSITERITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CHROMITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CHROMITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CHROMITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SMOOTH_BASALT), ModBlocks.BASALT_CHROMITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.TUFF), ModBlocks.TUFF_CHROMITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CINNABAR_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CINNABAR_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_CINNABAR_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GALENA_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GALENA_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GALENA_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SMOOTH_BASALT), ModBlocks.BASALT_GALENA_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CALCITE), ModBlocks.CALCITE_GALENA_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.TUFF), ModBlocks.TUFF_GALENA_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GARNET_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GARNET_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GARNET_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GRAPHITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GRAPHITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_GRAPHITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.TUFF), ModBlocks.TUFF_GRAPHITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PENTLANDITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PENTLANDITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PENTLANDITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SMOOTH_BASALT), ModBlocks.BASALT_PENTLANDITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.GRANITE), ModBlocks.GRANITE_PENTLANDITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.TUFF), ModBlocks.TUFF_PENTLANDITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAPPHIRE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_URANINITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANINITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANINITE_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ZIRCON_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ZIRCON_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.GRANITE), ModBlocks.GRANITE_ZIRCON_ORE.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SANDSTONE), ModBlocks.SANSTONE_ZIRCON_ORE.get().defaultBlockState())
    ))::get;

    public static final Supplier<List<OreConfiguration.TargetBlockState>> RIVER_BAUXITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.SAND_BAUXITE_ORE.get().defaultBlockState())
    ));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> EVAPORITE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.EVAPORITE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.EVAPORITE.get().defaultBlockState())
    ))::get;
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LIMESTONE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LIMESTONE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.LIMESTONE.get().defaultBlockState())
    ))::get;


    public static final Supplier<List<OreConfiguration.TargetBlockState>> BORAX_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.DIRT), ModBlocks.BORAX_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.BORAX_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CLAY), ModBlocks.BORAX_BLOCK.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> EPSOMITE_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.DIRT), ModBlocks.EPSOMITE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.EPSOMITE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CLAY), ModBlocks.EPSOMITE_BLOCK.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SALT_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.DIRT), ModBlocks.SALT_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.SAND), ModBlocks.SALT_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(new BlockMatchTest(Blocks.CLAY), ModBlocks.SALT_BLOCK.get().defaultBlockState())
    ));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_CHROMITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.BASALT), ModBlocks.NETHER_BASALT_CHROMITE_ORE.get().defaultBlockState())
    ));




    // p_161014_ = vein size
    public static final RegistryObject<ConfiguredFeature<?, ?>> APATITE_ORE = CONFIGURED_FEATURES.register("apatite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_APATITE_ORES.get(), 6)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> AQUAMARINE_ORE = CONFIGURED_FEATURES.register("aquamarine_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_AQUAMARINE_ORES.get(), 6)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BAUXITE_ORE = CONFIGURED_FEATURES.register("bauxite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_BAUXITE_ORES.get(), 12)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CASSITERITE_ORE = CONFIGURED_FEATURES.register("cassiterite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_CASSITERITE_ORES.get(), 16)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHROMITE_ORE = CONFIGURED_FEATURES.register("chromite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_CHROMITE_ORES.get(), 16)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CINNABAR_ORE = CONFIGURED_FEATURES.register("cinnabar_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_CINNABAR_ORES.get(), 12)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GALENA_ORE = CONFIGURED_FEATURES.register("galena_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_GALENA_ORES.get(), 14)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GARNET_ORE = CONFIGURED_FEATURES.register("garnet_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_GARNET_ORES.get(), 4)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GRAPHITE_ORE = CONFIGURED_FEATURES.register("graphite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_GRAPHITE_ORES.get(), 18)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PENTLANDITE_ORE = CONFIGURED_FEATURES.register("pentlandite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_PENTLANDITE_ORES.get(), 16)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_ORE = CONFIGURED_FEATURES.register("ruby_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_RUBY_ORES.get(), 6)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPPHIRE_ORE = CONFIGURED_FEATURES.register("sapphire_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_SAPPHIRE_ORES.get(), 8)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_ORE = CONFIGURED_FEATURES.register("silver_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_SILVER_ORES.get(), 10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> URANINITE_ORE = CONFIGURED_FEATURES.register("uraninite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_URANINITE_ORES.get(), 6)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ZIRCON_ORE = CONFIGURED_FEATURES.register("zircon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_ZIRCON_ORES.get(), 10)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_CHROMITE_ORE = CONFIGURED_FEATURES.register("nether_chromite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(NETHER_CHROMITE_ORES.get(), 16)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RIVER_BAUXITE_ORE = CONFIGURED_FEATURES.register("river_bauxite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(RIVER_BAUXITE_ORES.get(), 12)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> BORAX_SPAWN = CONFIGURED_FEATURES.register("borax_spawn",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(BORAX_GEN.get(), 24)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EPSOMITE_SPAWN = CONFIGURED_FEATURES.register("epsomite_spawn",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(EPSOMITE_GEN.get(), 18)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SALT_SPAWN = CONFIGURED_FEATURES.register("salt_spawn",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(SALT_GEN.get(), 32)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> EVAPORITE_SPAWN = CONFIGURED_FEATURES.register("evaporite_spawn",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(EVAPORITE_GEN.get(), 20)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LIMESTONE_SPAWN = CONFIGURED_FEATURES.register("limestone_spawn",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(LIMESTONE_GEN.get(), 27)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
