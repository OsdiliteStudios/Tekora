package net.nukollodda.tekora.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.tekora.block.TekoraBlocks;
import net.nukollodda.tekora.item.TekoraItems;

import java.util.Set;

public class TekoraBlockLootTables extends BlockLootSubProvider {
    public TekoraBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TekoraBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.ANTIMONY_BLOCK.get());
        this.dropSelf(TekoraBlocks.ARSENIC_BLOCK.get());
        this.dropSelf(TekoraBlocks.BARIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.BERYLLIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.BISMUTH_BLOCK.get());
        this.dropSelf(TekoraBlocks.BORON_BLOCK.get());
        this.dropSelf(TekoraBlocks.CADMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.CALCIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.CERIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.CHROMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.COBALT_BLOCK.get());
        this.dropSelf(TekoraBlocks.DYSPROSIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.ERBIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.EUROPIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.GADOLINIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.GALLIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.GERMANIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.HAFNIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.HOLMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.INDIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.IRIDIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.LANTHANUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.LEAD_BLOCK.get());
        this.dropSelf(TekoraBlocks.LUTETIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.MAGNESIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.MANGANESE_BLOCK.get());
        this.dropSelf(TekoraBlocks.MOLYBDENUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.NEODYMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.NICKEL_BLOCK.get());
        this.dropSelf(TekoraBlocks.NIOBIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.OSMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.PALLADIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.PRASEODYMIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.RHENIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.RHODIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.RUTHENIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.SCANDIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.SAMARIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.STRONTIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.SILICON_BLOCK.get());
        this.dropSelf(TekoraBlocks.SILVER_BLOCK.get());
        this.dropSelf(TekoraBlocks.TANTALUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.TELLURIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.TERBIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.THALLIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.THORIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.THULIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.TIN_BLOCK.get());
        this.dropSelf(TekoraBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.TUNGSTEN_BLOCK.get());
        this.dropSelf(TekoraBlocks.URANIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.VANADIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.YTTERBIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.YTTRIUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.ZINC_BLOCK.get());
        this.dropSelf(TekoraBlocks.ZIRCONIUM_BLOCK.get());

        this.dropSelf(TekoraBlocks.CRUSHER.get());
        this.dropSelf(TekoraBlocks.ALLOY_FURNACE.get());
        this.dropSelf(TekoraBlocks.INFUSION_FURNACE.get());
        this.dropSelf(TekoraBlocks.ELECTRIC_FURNACE.get());
        this.dropSelf(TekoraBlocks.INFINITE_BATTERY.get());

        this.dropSelf(TekoraBlocks.EVAPORITE.get());
        this.dropSelf(TekoraBlocks.LIMESTONE.get());

        this.add(TekoraBlocks.APATITE_ORE.get(), block -> createApatiteDrops(TekoraBlocks.APATITE_ORE.get()));
        this.add(TekoraBlocks.AQUAMARINE_ORE.get(), block -> createAquamarineDrops(TekoraBlocks.AQUAMARINE_ORE.get()));
        this.add(TekoraBlocks.BAUXITE_ORE.get(), block -> createBauxiteDrops(TekoraBlocks.BAUXITE_ORE.get()));
        this.add(TekoraBlocks.CASSITERITE_ORE.get(), block -> createCassiteriteDrops(TekoraBlocks.CASSITERITE_ORE.get()));
        this.add(TekoraBlocks.CHROMITE_ORE.get(), block -> createChromiteDrops(TekoraBlocks.CHROMITE_ORE.get()));
        this.add(TekoraBlocks.CINNABAR_ORE.get(), block -> createCinnabarDrops(TekoraBlocks.CINNABAR_ORE.get()));
        this.add(TekoraBlocks.GALENA_ORE.get(), block -> createGalenaDrops(TekoraBlocks.GALENA_ORE.get()));
        this.add(TekoraBlocks.GARNET_ORE.get(), block -> createGarnetDrops(TekoraBlocks.GARNET_ORE.get()));
        this.add(TekoraBlocks.GRAPHITE_ORE.get(), block -> createGraphiteDrops(TekoraBlocks.GRAPHITE_ORE.get()));
        this.add(TekoraBlocks.PENTLANDITE_ORE.get(), block -> createPentlanditeDrops(TekoraBlocks.PENTLANDITE_ORE.get()));
        this.add(TekoraBlocks.RUBY_ORE.get(), block -> createRubyDrops(TekoraBlocks.RUBY_ORE.get()));
        this.add(TekoraBlocks.SAPPHIRE_ORE.get(), block -> createSapphireDrops(TekoraBlocks.SAPPHIRE_ORE.get()));
        this.add(TekoraBlocks.SILVER_ORE.get(), block -> createSilverDrops(TekoraBlocks.SILVER_ORE.get()));
        this.add(TekoraBlocks.URANINITE_ORE.get(), block -> createUraniniteDrops(TekoraBlocks.URANINITE_ORE.get()));
        this.add(TekoraBlocks.ZIRCON_ORE.get(), block -> createZirconDrops(TekoraBlocks.ZIRCON_ORE.get()));

        this.add(TekoraBlocks.BASALT_CHROMITE_ORE.get(), block -> createChromiteDrops(TekoraBlocks.BASALT_CHROMITE_ORE.get()));
        this.add(TekoraBlocks.BASALT_GALENA_ORE.get(), block -> createGalenaDrops(TekoraBlocks.BASALT_GALENA_ORE.get()));
        this.add(TekoraBlocks.BASALT_PENTLANDITE_ORE.get(), block -> createPentlanditeDrops(TekoraBlocks.BASALT_PENTLANDITE_ORE.get()));

        this.add(TekoraBlocks.CALCITE_APATITE_ORE.get(), block -> createApatiteDrops(TekoraBlocks.CALCITE_APATITE_ORE.get()));
        this.add(TekoraBlocks.CALCITE_GALENA_ORE.get(), block -> createGalenaDrops(TekoraBlocks.CALCITE_GALENA_ORE.get()));

        this.add(TekoraBlocks.DEEPSLATE_APATITE_ORE.get(), block -> createApatiteDrops(TekoraBlocks.DEEPSLATE_APATITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), block -> createAquamarineDrops(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(), block -> createBauxiteDrops(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_CASSITERITE_ORE.get(), block -> createCassiteriteDrops(TekoraBlocks.DEEPSLATE_CASSITERITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_CHROMITE_ORE.get(), block -> createChromiteDrops(TekoraBlocks.DEEPSLATE_CHROMITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(), block -> createCinnabarDrops(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_GALENA_ORE.get(), block -> createGalenaDrops(TekoraBlocks.DEEPSLATE_GALENA_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_GARNET_ORE.get(), block -> createGarnetDrops(TekoraBlocks.DEEPSLATE_GARNET_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_GRAPHITE_ORE.get(), block -> createGraphiteDrops(TekoraBlocks.DEEPSLATE_GRAPHITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_PENTLANDITE_ORE.get(), block -> createPentlanditeDrops(TekoraBlocks.DEEPSLATE_PENTLANDITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_RUBY_ORE.get(), block -> createRubyDrops(TekoraBlocks.DEEPSLATE_RUBY_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block -> createSapphireDrops(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_SILVER_ORE.get(), block -> createSilverDrops(TekoraBlocks.DEEPSLATE_SILVER_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_URANINITE_ORE.get(), block -> createUraniniteDrops(TekoraBlocks.DEEPSLATE_URANINITE_ORE.get()));
        this.add(TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get(), block -> createZirconDrops(TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get()));

        this.add(TekoraBlocks.GRANITE_APATITE_ORE.get(), block -> createApatiteDrops(TekoraBlocks.GRANITE_APATITE_ORE.get()));
        this.add(TekoraBlocks.GRANITE_PENTLANDITE_ORE.get(), block -> createPentlanditeDrops(TekoraBlocks.GRANITE_PENTLANDITE_ORE.get()));
        this.add(TekoraBlocks.GRANITE_ZIRCON_ORE.get(), block -> createZirconDrops(TekoraBlocks.GRANITE_ZIRCON_ORE.get()));

        this.add(TekoraBlocks.TUFF_CHROMITE_ORE.get(), block -> createChromiteDrops(TekoraBlocks.TUFF_CHROMITE_ORE.get()));
        this.add(TekoraBlocks.TUFF_GALENA_ORE.get(), block -> createGalenaDrops(TekoraBlocks.TUFF_GALENA_ORE.get()));
        this.add(TekoraBlocks.TUFF_GRAPHITE_ORE.get(), block -> createGraphiteDrops(TekoraBlocks.TUFF_GRAPHITE_ORE.get()));
        this.add(TekoraBlocks.TUFF_PENTLANDITE_ORE.get(), block -> createPentlanditeDrops(TekoraBlocks.TUFF_PENTLANDITE_ORE.get()));

        this.add(TekoraBlocks.SAND_BAUXITE_ORE.get(), block -> createBauxiteDrops(TekoraBlocks.SAND_BAUXITE_ORE.get()));
        this.add(TekoraBlocks.NETHER_BASALT_CHROMITE_ORE.get(), block -> createChromiteDrops(TekoraBlocks.NETHER_BASALT_CHROMITE_ORE.get()));
        this.add(TekoraBlocks.SANDSTONE_ZIRCON_ORE.get(), block -> createZirconDrops(TekoraBlocks.SANDSTONE_ZIRCON_ORE.get()));

        this.add(TekoraBlocks.BORAX_BLOCK.get(), block -> createTekoraOreDrops(TekoraBlocks.BORAX_BLOCK.get(), TekoraItems.BORAX.get(), 2, 4));
        this.add(TekoraBlocks.EPSOMITE_BLOCK.get(), block -> createTekoraOreDrops(TekoraBlocks.EPSOMITE_BLOCK.get(), TekoraItems.MAGNESIUM_SULFATE.get(), 2, 4));
        this.add(TekoraBlocks.SALT_BLOCK.get(), block -> createTekoraOreDrops(TekoraBlocks.SALT_BLOCK.get(), TekoraItems.SALT.get(), 2, 4));
    }

    protected LootTable.Builder createApatiteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.APATITE.get(), 2, 3,
                TekoraItems.MONAZITE_SHARD.get(), 0.08f);
    }

    protected LootTable.Builder createAquamarineDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.AQUAMARINE.get(), 1, 1,
                TekoraItems.COLTAN_PIECE.get(), 0.15f);
    }

    protected LootTable.Builder createBauxiteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.BAUXITE.get(), 5, 2,
                TekoraItems.BASTNAESITE_SHARD.get(), 0.08f);
    }

    protected LootTable.Builder createCassiteriteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.CASSITERITE.get(), 3, 1,
                TekoraItems.WOLFRAMITE_PIECE.get(), 0.32f);
    }

    protected LootTable.Builder createChromiteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.CHROMITE.get(), 3, 1,
                TekoraItems.MAGNETITE_SHARD.get(), 0.64f, TekoraItems.RUTILE_SHARD.get(), 0.41f);
    }

    protected LootTable.Builder createCinnabarDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.CINNABAR.get(), 3, 1,
                TekoraItems.ORPIMENT_SHARD.get(), 0.1f, TekoraItems.SPHALERITE_PIECE.get(), 0.45f,
                TekoraItems.WOLFRAMITE_PIECE.get(), 0.34f);
    }

    protected LootTable.Builder createGalenaDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.GALENA.get(), 4, 1,
                TekoraItems.ORPIMENT_SHARD.get(), 0.9f, TekoraItems.PYRITE_PIECE.get(), 0.2f,
                TekoraItems.SPHALERITE_PIECE.get(), 0.51f, TekoraItems.WOLFRAMITE_PIECE.get(), 0.4f);
    }

    protected LootTable.Builder createGarnetDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.GARNET.get(), 1, 1);
    }

    protected LootTable.Builder createGraphiteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.GRAPHITE_BAR.get(), 5, 2);
    }

    protected LootTable.Builder createPentlanditeDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.PENTLANDITE.get(), 3, 1,
                TekoraItems.PYRITE_PIECE.get(), 0.21f, TekoraItems.SPHALERITE_PIECE.get(), 0.61f,
                TekoraItems.WOLFRAMITE_PIECE.get(), 0.51f);
    }

    protected LootTable.Builder createRubyDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.RUBY.get(), 1, 1);
    }

    protected LootTable.Builder createSapphireDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.SAPPHIRE.get(), 1, 1);
    }

    protected LootTable.Builder createSilverDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.RAW_SILVER.get(), 2, 1,
                TekoraItems.PYRITE_PIECE.get(), 0.09f, TekoraItems.SPHALERITE_PIECE.get(), 0.08f);
    }

    protected LootTable.Builder createUraniniteDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.URANINITE.get(), 3, 1,
                TekoraItems.THORITE_PIECE.get(), 0.36f);
    }

    protected LootTable.Builder createZirconDrops(Block pBlock) {
        return createTekoraOreDrops(pBlock, TekoraItems.ZIRCON.get(), 1, 1);
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min, Item pSecondary, float pSecPercentage) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pSecondary)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(pSecPercentage)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min, Item pSecondary, float pSecPercentage,
                                                     Item pTertiary, float pTerPercentage) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pSecondary)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min))
                                .when(LootItemRandomChanceCondition.randomChance(pSecPercentage)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                        this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pTertiary)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                        .when(LootItemRandomChanceCondition.randomChance(pTerPercentage)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min, Item pSecondary, float pSecPercentage,
                                                     Item pTertiary, float pTerPercentage, Item pQuaternary, float pQuaPercentage) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pSecondary)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(pSecPercentage)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                        this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pTertiary)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                        .when(LootItemRandomChanceCondition.randomChance(pTerPercentage)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pQuaternary)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                                .when(LootItemRandomChanceCondition.randomChance(pQuaPercentage)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))))));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min, Item pSecondary, float pSecPercentage,
                                                     Item pTertiary, float pTerPercentage, Item pQuaternary, float pQuaPercentage,
                                                     Item pQuinary, float pQuiPercentage) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pSecondary)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(pSecPercentage)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                        this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pTertiary)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                        .when(LootItemRandomChanceCondition.randomChance(pTerPercentage)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pQuaternary)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                                .when(LootItemRandomChanceCondition.randomChance(pQuaPercentage)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))).append(

                                        this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pQuinary)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))
                                                        .when(LootItemRandomChanceCondition.randomChance(pQuiPercentage)))
                                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
