package net.osdilites.tekora.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.util.UtilFunctions;

import java.util.stream.Stream;

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
    
    private void generateGearModel(ItemModelGenerators itemModels, Item item, String name) {
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(Identifier.fromNamespaceAndPath(Tekora.MODID, "item/gears/" + name)));
    }

    private void generateLargeGearModel(ItemModelGenerators itemModels, Item item, String name) {
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(Identifier.fromNamespaceAndPath(Tekora.MODID, "item/large_gears/" + name)));
    }

    private void generateSPlateModel(ItemModelGenerators itemModels, Item item, String name) {
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(Identifier.fromNamespaceAndPath(Tekora.MODID, "item/plates/" + name)));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return TekoraItems.ITEMS.getEntries().stream().filter(item -> {
            Item val = item.get();
            return UtilFunctions.matches(val, TekoraItems.BRASS_GEAR.get(), TekoraItems.STEEL_GEAR.get(), TekoraItems.WOODEN_GEAR.get());
        });
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().filter(block -> !TekoraBlocks.BLOCKS.getEntries().contains(block));
    }
}
