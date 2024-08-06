package net.leng.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.leng.tekora.Tekora;
import net.leng.tekora.worldgen.TekoraBiomeModifiers;
import net.leng.tekora.worldgen.TekoraConfiguredFeatures;
import net.leng.tekora.worldgen.TekoraPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TekoraWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TekoraConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, TekoraPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, TekoraBiomeModifiers::bootstrap);

    public TekoraWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Tekora.MODID));
    }
}
