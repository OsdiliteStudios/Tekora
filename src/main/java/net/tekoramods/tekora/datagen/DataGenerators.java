package net.tekoramods.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tekoramods.tekora.Tekora;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Tekora.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        boolean includeServer = event.includeServer();

        TekoraBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new TekoraBlockTagGenerator(output, lookup, fileHelper));

        generator.addProvider(includeServer,
                new TekoraItemTagGenerator(output, lookup, blockTagGenerator.contentsGetter(), fileHelper));

        generator.addProvider(includeServer, new TekoraRecipeProvider(output, lookup));
        generator.addProvider(includeServer, new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(TekoraBlockLootTables::new, LootContextParamSets.BLOCK)), lookup));

        generator.addProvider(event.includeClient(), new TekoraBlockStateProvider(output, fileHelper));
        generator.addProvider(event.includeClient(), new TekoraItemModelProvider(output, fileHelper));

        generator.addProvider(includeServer, new TekoraWorldGenProvider(output, lookup));
    }
}
