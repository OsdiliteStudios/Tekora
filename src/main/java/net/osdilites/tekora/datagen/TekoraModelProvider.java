package net.osdilites.tekora.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.datagen.modelcases.BiomeTemperature;
import net.osdilites.tekora.item.TekoraItems;
import net.osdilites.tekora.item.tools.ThermometerItem;

import java.util.ArrayList;
import java.util.List;
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
        itemModels.generateFlatItem(TekoraItems.BAUXITE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.ALUMINUM_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRASS_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.BRONZE_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.PLASTIC_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.WOODEN_GEAR_PART.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.APPLYING_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.WHISK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.PRESS_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.INK_PRESS_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.CUTTER_SHAFT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_PLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_ROD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.STEEL_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(TekoraItems.MAGNESIUM_CARBONATE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.WRENCH.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(TekoraItems.DEBUG_ITEM.get(), ModelTemplates.FLAT_ITEM);

        generateThermometerModel(itemModels, (ThermometerItem)TekoraItems.MERCURY_THERMOMETER.get());
        generateThermometerModel(itemModels, (ThermometerItem)TekoraItems.GALINSTAN_THERMOMETER.get());
        generateThermometerModel(itemModels, (ThermometerItem)TekoraItems.GALINSTAN_QUARTZ_THERMOMETER.get());

        blockModels.createTrivialCube(TekoraBlocks.BAUXITE_ORE.get());
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

    private void generateThermometerModel(ItemModelGenerators itemModels, ThermometerItem item) {
        List<RangeSelectItemModel.Entry> overrides = new ArrayList<>();
        ItemModel.Unbaked base = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_0", ModelTemplates.FLAT_ITEM));
        overrides.add(ItemModelUtils.override(base, 0.0f));

        for (int i = 1; i < 11; i++) {
            ItemModel.Unbaked model = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_" + i, ModelTemplates.FLAT_ITEM));
            overrides.add(ItemModelUtils.override(model, i/10.0f));
        }

        itemModels.itemModelOutput.accept(item, ItemModelUtils.rangeSelect(new BiomeTemperature(), 1.0f, overrides));
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
