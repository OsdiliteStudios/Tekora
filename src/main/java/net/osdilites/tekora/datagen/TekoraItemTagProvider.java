package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.item.TekoraItems;

import java.util.concurrent.CompletableFuture;

public class TekoraItemTagProvider extends ItemTagsProvider {
    public TekoraItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Tekora.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TekoraTags.Items.INGOTS_STEEL).add(TekoraItems.getKey(TekoraItems.STEEL_INGOT.get()));
        tag(TekoraTags.Items.PLATES_STEEL).add(TekoraItems.getKey(TekoraItems.STEEL_PLATE.get()));
    }
}
