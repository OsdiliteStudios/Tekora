package net.nukollodda.tekora.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.nukollodda.tekora.worldgen.TekoraConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class RubberTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return TekoraConfiguredFeatures.RUBBER_TREE_KEY;
    }
}
