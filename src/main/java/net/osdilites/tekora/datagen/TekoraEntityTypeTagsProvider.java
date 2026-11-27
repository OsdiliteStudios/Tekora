package net.osdilites.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityTypes;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.datagen.tags.TekoraTags;

import java.util.concurrent.CompletableFuture;

public class TekoraEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public TekoraEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Tekora.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        // todo, test out whether fluids can harm certain entities.
        tag(TekoraTags.Entities.SULFURIC_ACID_LETHAL).add(
        );
    }
}
