package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.worldgen.TekoraBiomeModifiers;
import net.osdilites.tekora.worldgen.TekoraConfiguredFeatures;
import net.osdilites.tekora.worldgen.TekoraPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TekoraDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            //.add(Registries.JUKEBOX_SONG, TekoraJukeboxSongs::bootstrap)// could be used for Tekora lore
            //.add(Registries.DAMAGE_TYPE, TekoraDamageTypes::bootstrap) // add if necessary
            //.add(Registries.VILLAGER_TRADE, TekoraVillagerTrades::bootstrap) // add if necessary
            //.add(Registries.TRADE_SET, TekoraTradeSets::bootstrap) // add if necessary
            //.add(Registries.PAINTING_VARIANT, TekoraPaintings::bootstrap) // add if necessary
            //.add(Registries.ENCHANTMENT, TekoraEnchantments::bootstrap) // add if necessary

            .add(Registries.CONFIGURED_FEATURE, TekoraConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, TekoraPlacedFeatures::bootstrap)

            //.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TekoraBiomeModifiers::bootstrap)

            // deployed system for Tekora Space
            //.add(Registries.DIMENSION_TYPE, TekoraDimensions::bootstrapType)
            //.add(Registries.LEVEL_STEM, TekoraDimensions::bootstrapStem)
            //.add(Registries.BIOME, TekoraBiomes::bootstrap)
            ;

    public TekoraDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Tekora.MODID));
    }
}
