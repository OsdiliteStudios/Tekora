package net.nukollodda.tekora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.Tekora;
import net.nukollodda.tekora.block.TekoraBlocks;

public class TekoraBlockStateProvider extends BlockStateProvider {
    public TekoraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tekora.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // may be replaceable with a massive for loop
        // such as
        /*
        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if (!block.defaultBlockState().hasProperty(BlockStateProperties.FACING)) {
                blockWithItem(block);
            }
        }*/
        blockWithItem(TekoraBlocks.BORAX_BLOCK);
        blockWithItem(TekoraBlocks.SALT_BLOCK);
        blockWithItem(TekoraBlocks.EVAPORITE);
        blockWithItem(TekoraBlocks.LIMESTONE);

        blockWithItem(TekoraBlocks.ALUMINUM_BLOCK);
        blockWithItem(TekoraBlocks.ANTIMONY_BLOCK);
        blockWithItem(TekoraBlocks.ARSENIC_BLOCK);
        blockWithItem(TekoraBlocks.BARIUM_BLOCK);
        blockWithItem(TekoraBlocks.BERYLLIUM_BLOCK);
        blockWithItem(TekoraBlocks.BISMUTH_BLOCK);
        blockWithItem(TekoraBlocks.BORON_BLOCK);
        blockWithItem(TekoraBlocks.CADMIUM_BLOCK);
        blockWithItem(TekoraBlocks.CALCIUM_BLOCK);
        blockWithItem(TekoraBlocks.CERIUM_BLOCK);
        blockWithItem(TekoraBlocks.CHROMIUM_BLOCK);
        blockWithItem(TekoraBlocks.COBALT_BLOCK);
        blockWithItem(TekoraBlocks.DYSPROSIUM_BLOCK);
        blockWithItem(TekoraBlocks.ERBIUM_BLOCK);
        blockWithItem(TekoraBlocks.EUROPIUM_BLOCK);
        blockWithItem(TekoraBlocks.GADOLINIUM_BLOCK);
        blockWithItem(TekoraBlocks.GALLIUM_BLOCK);
        blockWithItem(TekoraBlocks.GERMANIUM_BLOCK);
        blockWithItem(TekoraBlocks.HAFNIUM_BLOCK);
        blockWithItem(TekoraBlocks.HOLMIUM_BLOCK);
        blockWithItem(TekoraBlocks.INDIUM_BLOCK);
        blockWithItem(TekoraBlocks.IRIDIUM_BLOCK);
        blockWithItem(TekoraBlocks.LANTHANUM_BLOCK);
        blockWithItem(TekoraBlocks.LEAD_BLOCK);
        blockWithItem(TekoraBlocks.LUTETIUM_BLOCK);
        blockWithItem(TekoraBlocks.MAGNESIUM_BLOCK);
        blockWithItem(TekoraBlocks.MANGANESE_BLOCK);
        blockWithItem(TekoraBlocks.MOLYBDENUM_BLOCK);
        blockWithItem(TekoraBlocks.NEODYMIUM_BLOCK);
        blockWithItem(TekoraBlocks.NICKEL_BLOCK);
        blockWithItem(TekoraBlocks.NIOBIUM_BLOCK);
        blockWithItem(TekoraBlocks.OSMIUM_BLOCK);
        blockWithItem(TekoraBlocks.PALLADIUM_BLOCK);
        blockWithItem(TekoraBlocks.PLATINUM_BLOCK);
        blockWithItem(TekoraBlocks.PRASEODYMIUM_BLOCK);
        blockWithItem(TekoraBlocks.RHENIUM_BLOCK);
        blockWithItem(TekoraBlocks.RHODIUM_BLOCK);
        blockWithItem(TekoraBlocks.RUTHENIUM_BLOCK);
        blockWithItem(TekoraBlocks.SAMARIUM_BLOCK);
        blockWithItem(TekoraBlocks.SCANDIUM_BLOCK);
        blockWithItem(TekoraBlocks.SILVER_BLOCK);
        blockWithItem(TekoraBlocks.STRONTIUM_BLOCK);
        blockWithItem(TekoraBlocks.SILICON_BLOCK);
        blockWithItem(TekoraBlocks.TANTALUM_BLOCK);
        blockWithItem(TekoraBlocks.TELLURIUM_BLOCK);
        blockWithItem(TekoraBlocks.TERBIUM_BLOCK);
        blockWithItem(TekoraBlocks.THALLIUM_BLOCK);
        blockWithItem(TekoraBlocks.THORIUM_BLOCK);
        blockWithItem(TekoraBlocks.THULIUM_BLOCK);
        blockWithItem(TekoraBlocks.TIN_BLOCK);
        blockWithItem(TekoraBlocks.TITANIUM_BLOCK);
        blockWithItem(TekoraBlocks.TUNGSTEN_BLOCK);
        blockWithItem(TekoraBlocks.URANIUM_BLOCK);
        blockWithItem(TekoraBlocks.VANADIUM_BLOCK);
        blockWithItem(TekoraBlocks.YTTERBIUM_BLOCK);
        blockWithItem(TekoraBlocks.YTTRIUM_BLOCK);
        blockWithItem(TekoraBlocks.ZINC_BLOCK);
        blockWithItem(TekoraBlocks.ZIRCONIUM_BLOCK);

        blockWithItem(TekoraBlocks.RAW_LEAD_BLOCK);
        blockWithItem(TekoraBlocks.RAW_NICKEL_BLOCK);
        blockWithItem(TekoraBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(TekoraBlocks.RAW_SILVER_BLOCK);
        blockWithItem(TekoraBlocks.RAW_TIN_BLOCK);
        blockWithItem(TekoraBlocks.RAW_ZINC_BLOCK);

        blockWithItem(TekoraBlocks.AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.BAUXITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_BAUXITE_ORE);
        blockWithItem(TekoraBlocks.TIN_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(TekoraBlocks.CINNABAR_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_CINNABAR_ORE);
        blockWithItem(TekoraBlocks.HALITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_HALITE_ORE);
        blockWithItem(TekoraBlocks.LEAD_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_LEAD_ORE);
        blockWithItem(TekoraBlocks.NICKEL_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_NICKEL_ORE);
        blockWithItem(TekoraBlocks.RUBY_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(TekoraBlocks.SAPPHIRE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(TekoraBlocks.URANINITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_URANINITE_ORE);
        blockWithItem(TekoraBlocks.WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.ZINC_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_ZINC_ORE);
        blockWithItem(TekoraBlocks.ZIRCON_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_ZIRCON_ORE);
    }

    private void blockWithItem(RegistryObject<Block> registryObject) {
        simpleBlockWithItem(registryObject.get(), cubeAll(registryObject.get()));
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}
