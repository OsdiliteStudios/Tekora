package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.osdilites.tekora.block.TekoraBlocks;

import java.util.Set;

public class TekoraLootTableProvider extends BlockLootSubProvider {
    public TekoraLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //var enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT);

        dropSelf(TekoraBlocks.BASIN.get());
        dropSelf(TekoraBlocks.SHAFT.get());
    }
}
