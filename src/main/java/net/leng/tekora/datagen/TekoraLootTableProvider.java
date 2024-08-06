package net.leng.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.leng.tekora.datagen.loot.TekoraBlockLootTables;

import java.util.List;
import java.util.Set;

public class TekoraLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(TekoraBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
