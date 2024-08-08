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
import net.tekoramods.tekora.block.models.CableModel;

public class TekoraBlockStateProvider extends BlockStateProvider {
    public TekoraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tekora.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
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

        blockWithItem(TekoraBlocks.AQUAMARINE_BLOCK);
        blockWithItem(TekoraBlocks.BAUXITE_BLOCK);
        blockWithItem(TekoraBlocks.CHROMITE_BLOCK);
        blockWithItem(TekoraBlocks.CINNABAR_BLOCK);
        blockWithItem(TekoraBlocks.COLTAN_BLOCK);
        blockWithItem(TekoraBlocks.DOLOMITE_BLOCK);
        blockWithItem(TekoraBlocks.FLUORITE_BLOCK);
        blockWithItem(TekoraBlocks.HALITE_BLOCK);
        blockWithItem(TekoraBlocks.MONAZITE_BLOCK);
        blockWithItem(TekoraBlocks.RUBY_BLOCK);
        blockWithItem(TekoraBlocks.RUTILE_BLOCK);
        blockWithItem(TekoraBlocks.SAPPHIRE_BLOCK);
        blockWithItem(TekoraBlocks.URANINITE_BLOCK);
        blockWithItem(TekoraBlocks.WOLFRAMITE_BLOCK);
        blockWithItem(TekoraBlocks.ZIRCON_BLOCK);

        blockWithItem(TekoraBlocks.AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE);
        blockWithItem(TekoraBlocks.BAUXITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_BAUXITE_ORE);
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
        blockWithItem(TekoraBlocks.TIN_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(TekoraBlocks.URANINITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_URANINITE_ORE);
        blockWithItem(TekoraBlocks.WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE);
        blockWithItem(TekoraBlocks.ZINC_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_ZINC_ORE);
        blockWithItem(TekoraBlocks.ZIRCON_ORE);
        blockWithItem(TekoraBlocks.DEEPSLATE_ZIRCON_ORE);

        registerCable(TekoraBlocks.ALUMINUM_CABLE);
        registerCable(TekoraBlocks.COPPER_CABLE);
        registerCable(TekoraBlocks.CUPRONICKEL_CABLE);
        registerCable(TekoraBlocks.ELECTRUM_CABLE);
        registerCable(TekoraBlocks.GOLD_CABLE);
        registerCable(TekoraBlocks.SILVER_CABLE);
        registerCable(TekoraBlocks.TIN_CABLE);

        registerFacade(TekoraBlocks.ALUMINUM_CABLE_FACADE);
        registerFacade(TekoraBlocks.COPPER_CABLE_FACADE);
        registerFacade(TekoraBlocks.CUPRONICKEL_CABLE_FACADE);
        registerFacade(TekoraBlocks.ELECTRUM_CABLE_FACADE);
        registerFacade(TekoraBlocks.GOLD_CABLE_FACADE);
        registerFacade(TekoraBlocks.SILVER_CABLE_FACADE);
        registerFacade(TekoraBlocks.TIN_CABLE_FACADE);
    }

    private void blockWithItem(RegistryObject<Block> registryObject) {
        simpleBlockWithItem(registryObject.get(), cubeAll(registryObject.get()));
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }


    private void registerCable(RegistryObject<Block> cable) {
        BlockModelBuilder model = models().getBuilder("cable")
                .parent(models().getExistingFile(mcLoc("cube")))
                .customLoader((builder, helper) -> new CableLoaderBuilder(CableModel.LOADER, builder, helper, false))
                .end();
        simpleBlock(cable.get(), model);
    }

    private void registerFacade(RegistryObject<Block> facade) {
        BlockModelBuilder model = models().getBuilder("facade")
                .parent(models().getExistingFile(mcLoc("cube")))
                .customLoader((builder, helper) -> new CableLoaderBuilder(CableModel.LOADER, builder, helper, true))
                .end();
        simpleBlock(facade.get(), model);
    }

    public static class CableLoaderBuilder extends CustomLoaderBuilder<BlockModelBuilder> {

        private final boolean facade;

        public CableLoaderBuilder(ResourceLocation loader, BlockModelBuilder parent, ExistingFileHelper existingFileHelper,
                                  boolean facade) {
            super(loader, parent, existingFileHelper);
            this.facade = facade;
        }

        @Override
        public JsonObject toJson(JsonObject json) {
            JsonObject obj = super.toJson(json);
            obj.addProperty("facade", facade);
            return obj;
        }
    }
}
