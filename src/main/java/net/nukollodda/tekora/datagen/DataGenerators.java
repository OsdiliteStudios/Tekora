package net.nukollodda.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nukollodda.tekora.Tekora;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Tekora.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TekoraRecipeProvider(output));
        generator.addProvider(event.includeServer(), TekoraLootTableProvider.create(output));

        generator.addProvider(event.includeClient(), new TekoraBlockStateProvider(output, fileHelper));
        generator.addProvider(event.includeClient(), new TekoraItemModelProvider(output, fileHelper));

        TekoraBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new TekoraBlockTagGenerator(output, lookup, fileHelper));

        generator.addProvider(event.includeServer(),
                new TekoraItemTagGenerator(output, lookup, blockTagGenerator.contentsGetter(), fileHelper));
    }
}
