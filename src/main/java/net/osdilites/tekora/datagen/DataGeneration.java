package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.osdilites.tekora.Tekora;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Tekora.MODID)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        gatherData(event);
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        gatherData(event);
    }

    private static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        gen.addProvider(true, new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(TekoraLootTableProvider::new, LootContextParamSets.BLOCK)), provider));
        gen.addProvider(true, new TekoraRecipeProvider.Runner(output, provider));
        //gen.addProvider(true, new TekoraDatamapProvider(output, provider));
        gen.addProvider(true, new TekoraModelProvider(output));
        //gen.addProvider(true, new TekoraDatapackProvider(output, provider));
    }
}
