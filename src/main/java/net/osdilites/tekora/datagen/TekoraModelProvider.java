package net.osdilites.tekora.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.item.TekoraItems;

public class TekoraModelProvider extends ModelProvider {
    public TekoraModelProvider(PackOutput output) {
        super(output, Tekora.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(TekoraItems.BRASS_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.WOODEN_GEAR.get(), ModelTemplates.FLAT_ITEM);

        // blockModels.createTrivialCube(ModBlocks.BAUXITE_ORE.get());
    }
}
