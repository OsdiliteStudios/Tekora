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

import java.util.stream.Stream;

public class TekoraModelProvider extends ModelProvider {
    public TekoraModelProvider(PackOutput output) {
        super(output, Tekora.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(TekoraItems.ALUMINUM_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRASS_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRONZE_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.PLASTIC_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_GEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.WOODEN_GEAR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.ALUMINUM_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRASS_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRONZE_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.PLASTIC_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.WOODEN_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.WHISK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.PRESS_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.INK_PRESS_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.CUTTER_SHAFT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_PLATE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.DEBUG_ITEM.get(), ModelTemplates.FLAT_ITEM);

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
            return val != TekoraItems.CRUSHING_WHEEL.get() && val != TekoraItems.WRENCH.get();
        });
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().filter(block -> !TekoraBlocks.BLOCKS.getEntries().contains(block));
    }
}
