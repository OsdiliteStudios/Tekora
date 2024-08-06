package net.tekoramods.tekora.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.item.TekoraItems;

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

        this.dropSelf(TekoraBlocks.RAW_LEAD_BLOCK.get());
        this.dropSelf(TekoraBlocks.RAW_NICKEL_BLOCK.get());
        this.dropSelf(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
        this.dropSelf(TekoraBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(TekoraBlocks.RAW_TIN_BLOCK.get());
        this.dropSelf(TekoraBlocks.RAW_ZINC_BLOCK.get());
        this.dropSelf(TekoraBlocks.AQUAMARINE_BLOCK.get());
        this.dropSelf(TekoraBlocks.BAUXITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.CHROMITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.CINNABAR_BLOCK.get());
        this.dropSelf(TekoraBlocks.COLTAN_BLOCK.get());
        this.dropSelf(TekoraBlocks.DOLOMITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.FLUORITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.HALITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.MONAZITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.RUBY_BLOCK.get());
        this.dropSelf(TekoraBlocks.RUTILE_BLOCK.get());
        this.dropSelf(TekoraBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(TekoraBlocks.URANINITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.WOLFRAMITE_BLOCK.get());
        this.dropSelf(TekoraBlocks.ZIRCON_BLOCK.get());

        this.dropSelf(TekoraBlocks.COMPRESSOR.get());
        this.dropSelf(TekoraBlocks.ALLOY_FURNACE.get());
        this.dropSelf(TekoraBlocks.INFUSION_FURNACE.get());
        this.dropSelf(TekoraBlocks.CUTTER.get());
        this.dropSelf(TekoraBlocks.ELECTRIC_FURNACE.get());
        this.dropSelf(TekoraBlocks.EXTRUDER.get());
        this.dropSelf(TekoraBlocks.INFINITE_BATTERY.get());
        this.dropSelf(TekoraBlocks.PULVERIZER.get());

        this.dropSelf(TekoraBlocks.CENTRIFUGE.get());

        this.dropSelf(TekoraBlocks.EVAPORITE.get());
        this.dropSelf(TekoraBlocks.LIMESTONE.get());

        this.dropSelf(TekoraBlocks.ALUMINUM_CABLE.get());
        this.dropSelf(TekoraBlocks.COPPER_CABLE.get());
        this.dropSelf(TekoraBlocks.CUPRONICKEL_CABLE.get());
        this.dropSelf(TekoraBlocks.ELECTRUM_CABLE.get());
        this.dropSelf(TekoraBlocks.GOLD_CABLE.get());
        this.dropSelf(TekoraBlocks.SILVER_CABLE.get());
        this.dropSelf(TekoraBlocks.TIN_CABLE.get());
        this.dropSelf(TekoraBlocks.RUBBER_SAPLING.get());

        this.dropOther(TekoraBlocks.ALUMINUM_CABLE_FACADE.get(), TekoraBlocks.ALUMINUM_CABLE.get());
        this.dropOther(TekoraBlocks.COPPER_CABLE_FACADE.get(), TekoraBlocks.COPPER_CABLE.get());
        this.dropOther(TekoraBlocks.CUPRONICKEL_CABLE_FACADE.get(), TekoraBlocks.CUPRONICKEL_CABLE.get());
        this.dropOther(TekoraBlocks.ELECTRUM_CABLE_FACADE.get(), TekoraBlocks.ELECTRUM_CABLE.get());
        this.dropOther(TekoraBlocks.GOLD_CABLE_FACADE.get(), TekoraBlocks.GOLD_CABLE.get());
        this.dropOther(TekoraBlocks.SILVER_CABLE_FACADE.get(), TekoraBlocks.SILVER_CABLE.get());
        this.dropOther(TekoraBlocks.TIN_CABLE_FACADE.get(), TekoraBlocks.TIN_CABLE.get());
        this.dropOther(TekoraBlocks.RUBBER_TREE_LOG.get(), Blocks.JUNGLE_LOG);

        this.dropSelf(TekoraBlocks.HYDROELECTRIC_GENERATOR.get());

        this.add(TekoraBlocks.AQUAMARINE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.AQUAMARINE.get()));
        this.add(TekoraBlocks.BAUXITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.BAUXITE.get(), 2, 1));
        this.add(TekoraBlocks.CINNABAR_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.CINNABAR.get(), 3, 1));
        this.add(TekoraBlocks.HALITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.HALITE.get()));
        this.add(TekoraBlocks.LEAD_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_LEAD.get()));
        this.add(TekoraBlocks.TIN_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_TIN.get()));
        this.add(TekoraBlocks.NICKEL_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_NICKEL.get()));
        this.add(TekoraBlocks.RUBY_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RUBY.get()));
        this.add(TekoraBlocks.SAPPHIRE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.SAPPHIRE.get()));
        this.add(TekoraBlocks.URANINITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.URANINITE.get()));
        this.add(TekoraBlocks.WOLFRAMITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.WOLFRAMITE.get()));
        this.add(TekoraBlocks.ZIRCON_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.ZIRCON.get()));
        this.add(TekoraBlocks.ZINC_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_ZINC.get()));

        this.add(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.AQUAMARINE.get()));
        this.add(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.BAUXITE.get()));
        this.add(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.CINNABAR.get()));
        this.add(TekoraBlocks.DEEPSLATE_HALITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.HALITE.get()));
        this.add(TekoraBlocks.DEEPSLATE_TIN_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_TIN.get()));
        this.add(TekoraBlocks.DEEPSLATE_LEAD_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_LEAD.get()));
        this.add(TekoraBlocks.DEEPSLATE_NICKEL_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_NICKEL.get()));
        this.add(TekoraBlocks.DEEPSLATE_RUBY_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RUBY.get()));
        this.add(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.SAPPHIRE.get()));
        this.add(TekoraBlocks.DEEPSLATE_URANINITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.URANINITE.get()));
        this.add(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.WOLFRAMITE.get()));
        this.add(TekoraBlocks.DEEPSLATE_ZIRCON_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.ZIRCON.get()));
        this.add(TekoraBlocks.DEEPSLATE_ZINC_ORE.get(), block -> createTekoraOreDrops(block, TekoraItems.RAW_ZINC.get()));

        this.add(TekoraBlocks.BORAX_BLOCK.get(), block -> createTekoraOreDrops(TekoraBlocks.BORAX_BLOCK.get(), TekoraItems.BORAX.get(), 2, 4));
        this.add(TekoraBlocks.SALT_BLOCK.get(), block -> createTekoraOreDrops(TekoraBlocks.SALT_BLOCK.get(), TekoraItems.SALT.get(), 2, 4));

        this.add(TekoraBlocks.RUBBER_TREE_LEAVES.get(), block -> createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(TekoraBlocks.RUBBER_SAPLING.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))))));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem) {
        return createTekoraOreDrops(pBlock, pItem, 1, 1);
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
