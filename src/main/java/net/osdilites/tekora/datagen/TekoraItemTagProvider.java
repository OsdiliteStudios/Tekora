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
        tag(TekoraTags.Items.RODS_STEEL).add(TekoraItems.getKey(TekoraItems.STEEL_ROD.get()));

        tag(TekoraTags.Items.TOXIC_FUMES_ON_SMELT).add(TekoraItems.getKey(TekoraItems.CINNABAR_SHARD.get()));

        tag(TekoraTags.Items.FUMES_ON_SMELT).addTags(
                TekoraTags.Items.TOXIC_FUMES_ON_SMELT/*,
                TekoraTags.Items.BLINDING_FUMES_ON_SMELT,
                TekoraTags.Items.RADIOACTIVE_FUMES_ON_SMELT,
                TekoraTags.Items.WEAKENING_FUMES_ON_SMELT*/);

        // this is for compatibility with cooking mods (like farmer's delight)
        // please do not add other inorganic salts besides NaCl here.
        tag(TekoraTags.Items.SALT).add(TekoraItems.getKey(TekoraItems.SODIUM_CHLORIDE.get()));

        tag(TekoraTags.Items.CHEMICAL_SALT)
                .addTag(TekoraTags.Items.SALT)
                .add(TekoraItems.getKey(TekoraItems.MAGNESIUM_CARBONATE.get()))
                .add(TekoraItems.getKey(TekoraItems.AMMONIUM_PHOSPHATE.get()));
    }
}
