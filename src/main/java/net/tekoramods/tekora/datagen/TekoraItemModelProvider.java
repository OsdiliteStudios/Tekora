package net.tekoramods.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entities.TekoraBlockEntities;
import net.tekoramods.tekora.block.fluids.AbstractTekoraFluidBlock;
import net.tekoramods.tekora.item.TekoraItems;
import net.tekoramods.tekora.item.typical.TekoraItem;

public class TekoraItemModelProvider extends ItemModelProvider {
    public TekoraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tekora.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TekoraItems.AQUAMARINE);
        simpleItem(TekoraItems.BAUXITE);
        simpleItem(TekoraItems.CINNABAR);
        simpleItem(TekoraItems.DOLOMITE);
        simpleItem(TekoraItems.FLUORITE);
        simpleItem(TekoraItems.HALITE);
        simpleItem(TekoraItems.RUBY);
        simpleItem(TekoraItems.SAPPHIRE);
        simpleItem(TekoraItems.WOLFRAMITE);
        simpleItem(TekoraItems.RAW_LEAD);
        simpleItem(TekoraItems.RAW_NICKEL);
        simpleItem(TekoraItems.RAW_SILVER);
        simpleItem(TekoraItems.RAW_PLATINUM);
        simpleItem(TekoraItems.RAW_TIN);
        simpleItem(TekoraItems.RAW_ZINC);
        simpleItem(TekoraItems.ALUMINUM_INGOT);
        simpleItem(TekoraItems.BISMUTH_INGOT);
        simpleItem(TekoraItems.COBALT_INGOT);
        simpleItem(TekoraItems.LEAD_INGOT);
        simpleItem(TekoraItems.MAGNESIUM_INGOT);
        simpleItem(TekoraItems.MANGANESE_INGOT);
        simpleItem(TekoraItems.MOLYBDENUM_INGOT);
        simpleItem(TekoraItems.NICKEL_INGOT);
        simpleItem(TekoraItems.PLATINUM_INGOT);
        simpleItem(TekoraItems.POTASSIUM_INGOT);
        simpleItem(TekoraItems.SILVER_INGOT);
        simpleItem(TekoraItems.SODIUM_INGOT);
        simpleItem(TekoraItems.TIN_INGOT);
        simpleItem(TekoraItems.TUNGSTEN_INGOT);
        simpleItem(TekoraItems.ZINC_INGOT);
        simpleItem(TekoraItems.BRASS_INGOT);
        simpleItem(TekoraItems.BRONZE_INGOT);
        simpleItem(TekoraItems.CONSTANTAN_INGOT);
        simpleItem(TekoraItems.ELECTRUM_INGOT);
        simpleItem(TekoraItems.INVAR_INGOT);
        simpleItem(TekoraItems.STEEL_INGOT);
        simpleItem(TekoraItems.PEWTER_INGOT);
        simpleItem(TekoraItems.TUNGSTEN_STEEL_INGOT);
        simpleItem(TekoraItems.FIRE_BRICK);
        simpleItem(TekoraItems.INFUSED_CLAY);

        simpleItem(TekoraItems.DEBUG_ITEM);
    }

    private ItemModelBuilder blockItem(RegistryObject<? extends Block> block) {
        return withExistingParent(block.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "item/" + block.getId().getPath()));
    }

    private ItemModelBuilder cableItem(RegistryObject<? extends Block> block) {
        return withExistingParent(block.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Tekora.MODID, "item/items/cable"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Tekora.MODID,"item/" + item.getId().getPath()));
    }
}
