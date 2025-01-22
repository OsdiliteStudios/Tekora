package net.tekoramods.tekora.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;

public class TekoraBlockStateProvider extends BlockStateProvider {
    public TekoraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tekora.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(TekoraBlocks.BORAX_BLOCK);
        //blockWithItem(TekoraBlocks.SALT_BLOCK);
        blockWithItem(TekoraBlocks.EVAPORITE);
        blockWithItem(TekoraBlocks.LIMESTONE);
        blockWithItem(TekoraBlocks.ALUMINUM_BLOCK);
        blockWithItem(TekoraBlocks.BISMUTH_BLOCK);
        blockWithItem(TekoraBlocks.COBALT_BLOCK);
        blockWithItem(TekoraBlocks.LEAD_BLOCK);
        blockWithItem(TekoraBlocks.MAGNESIUM_BLOCK);
        blockWithItem(TekoraBlocks.MANGANESE_BLOCK);
        blockWithItem(TekoraBlocks.MOLYBDENUM_BLOCK);
        blockWithItem(TekoraBlocks.NICKEL_BLOCK);
        blockWithItem(TekoraBlocks.PLATINUM_BLOCK);
        blockWithItem(TekoraBlocks.SILVER_BLOCK);
        blockWithItem(TekoraBlocks.TIN_BLOCK);
        blockWithItem(TekoraBlocks.TUNGSTEN_BLOCK);
        blockWithItem(TekoraBlocks.ZINC_BLOCK);
        blockWithItem(TekoraBlocks.RAW_LEAD_BLOCK);
        blockWithItem(TekoraBlocks.RAW_NICKEL_BLOCK);
        blockWithItem(TekoraBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(TekoraBlocks.RAW_SILVER_BLOCK);
        blockWithItem(TekoraBlocks.RAW_TIN_BLOCK);
        blockWithItem(TekoraBlocks.RAW_ZINC_BLOCK);
        blockWithItem(TekoraBlocks.AQUAMARINE_BLOCK);
        blockWithItem(TekoraBlocks.BAUXITE_BLOCK);
        blockWithItem(TekoraBlocks.CINNABAR_BLOCK);
        blockWithItem(TekoraBlocks.DOLOMITE_BLOCK);
        blockWithItem(TekoraBlocks.FLUORITE_BLOCK);
        blockWithItem(TekoraBlocks.HALITE_BLOCK);
        blockWithItem(TekoraBlocks.RUBY_BLOCK);
        blockWithItem(TekoraBlocks.SAPPHIRE_BLOCK);
        blockWithItem(TekoraBlocks.WOLFRAMITE_BLOCK);
        blockWithItem(TekoraBlocks.FIREBRICKS);
        blockWithItem(TekoraBlocks.CASTING_BRICKS);

        blockWithItem(TekoraBlocks.AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.BAUXITE_ORE);
        blockWithItem(TekoraBlocks.CINNABAR_ORE);
        blockWithItem(TekoraBlocks.HALITE_ORE);
        blockWithItem(TekoraBlocks.LEAD_ORE);
        blockWithItem(TekoraBlocks.NICKEL_ORE);
        blockWithItem(TekoraBlocks.RUBY_ORE);
        blockWithItem(TekoraBlocks.SAPPHIRE_ORE);
        blockWithItem(TekoraBlocks.TIN_ORE);
        blockWithItem(TekoraBlocks.WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.ZINC_ORE);

        blockWithItem(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_BAUXITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_CINNABAR_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_HALITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_LEAD_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_NICKEL_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_ZINC_ORE);
    }

    private void blockWithItem(RegistryObject<Block> registryObject) {
        simpleBlockWithItem(registryObject.get(), cubeAll(registryObject.get()));
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}
