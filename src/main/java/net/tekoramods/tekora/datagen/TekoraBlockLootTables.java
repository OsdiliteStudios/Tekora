package net.tekoramods.tekora.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.item.TekoraItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class TekoraBlockLootTables extends BlockLootSubProvider {

    public TekoraBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        //dropSelf(TekoraBlocks.BORAX_BLOCK.get());
        //dropSelf(TekoraBlocks.SALT_BLOCK.get());
        dropSelf(TekoraBlocks.EVAPORITE.get());
        dropSelf(TekoraBlocks.LIMESTONE.get());
        dropSelf(TekoraBlocks.ALUMINUM_BLOCK.get());
        dropSelf(TekoraBlocks.BISMUTH_BLOCK.get());
        dropSelf(TekoraBlocks.COBALT_BLOCK.get());
        dropSelf(TekoraBlocks.LEAD_BLOCK.get());
        dropSelf(TekoraBlocks.MAGNESIUM_BLOCK.get());
        dropSelf(TekoraBlocks.MANGANESE_BLOCK.get());
        dropSelf(TekoraBlocks.MOLYBDENUM_BLOCK.get());
        dropSelf(TekoraBlocks.NICKEL_BLOCK.get());
        dropSelf(TekoraBlocks.PLATINUM_BLOCK.get());
        dropSelf(TekoraBlocks.SILVER_BLOCK.get());
        dropSelf(TekoraBlocks.TIN_BLOCK.get());
        dropSelf(TekoraBlocks.TUNGSTEN_BLOCK.get());
        dropSelf(TekoraBlocks.ZINC_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_LEAD_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_NICKEL_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_TIN_BLOCK.get());
        dropSelf(TekoraBlocks.RAW_ZINC_BLOCK.get());
        dropSelf(TekoraBlocks.AQUAMARINE_BLOCK.get());
        dropSelf(TekoraBlocks.BAUXITE_BLOCK.get());
        dropSelf(TekoraBlocks.CINNABAR_BLOCK.get());
        dropSelf(TekoraBlocks.DOLOMITE_BLOCK.get());
        dropSelf(TekoraBlocks.FLUORITE_BLOCK.get());
        dropSelf(TekoraBlocks.HALITE_BLOCK.get());
        dropSelf(TekoraBlocks.RUBY_BLOCK.get());
        dropSelf(TekoraBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(TekoraBlocks.WOLFRAMITE_BLOCK.get());

        dropSelf(TekoraBlocks.FIREBRICKS.get());
        dropSelf(TekoraBlocks.CASTING_BRICKS.get());

        dropSelf(TekoraBlocks.WOODEN_COGWHEEL.get());
        dropSelf(TekoraBlocks.SHAFT.get());
        dropSelf(TekoraBlocks.WOODEN_WATERWHEEL.get());

        createTekoraOreDrops(TekoraBlocks.AQUAMARINE_ORE.get(), TekoraItems.AQUAMARINE.get());
        createTekoraOreDrops(TekoraBlocks.BAUXITE_ORE.get(), TekoraItems.BAUXITE.get());
        createTekoraOreDrops(TekoraBlocks.CINNABAR_ORE.get(), TekoraItems.CINNABAR.get());
        createTekoraOreDrops(TekoraBlocks.HALITE_ORE.get(), TekoraItems.HALITE.get());
        createTekoraOreDrops(TekoraBlocks.LEAD_ORE.get(), TekoraItems.RAW_LEAD.get());
        createTekoraOreDrops(TekoraBlocks.NICKEL_ORE.get(), TekoraItems.RAW_NICKEL.get());
        createTekoraOreDrops(TekoraBlocks.RUBY_ORE.get(), TekoraItems.RUBY.get());
        createTekoraOreDrops(TekoraBlocks.SAPPHIRE_ORE.get(), TekoraItems.SAPPHIRE.get());
        createTekoraOreDrops(TekoraBlocks.TIN_ORE.get(), TekoraItems.RAW_TIN.get());
        createTekoraOreDrops(TekoraBlocks.WOLFRAMITE_ORE.get(), TekoraItems.WOLFRAMITE.get());
        createTekoraOreDrops(TekoraBlocks.ZINC_ORE.get(), TekoraItems.RAW_ZINC.get());

        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), TekoraItems.AQUAMARINE.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get(), TekoraItems.BAUXITE.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get(), TekoraItems.CINNABAR.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_HALITE_ORE.get(), TekoraItems.HALITE.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_LEAD_ORE.get(), TekoraItems.RAW_LEAD.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_NICKEL_ORE.get(), TekoraItems.RAW_NICKEL.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_RUBY_ORE.get(), TekoraItems.RUBY.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), TekoraItems.SAPPHIRE.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_TIN_ORE.get(), TekoraItems.RAW_TIN.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get(), TekoraItems.WOLFRAMITE.get());
        createTekoraOreDrops(TekoraBlocks.DEEPSLATE_ZINC_ORE.get(), TekoraItems.RAW_ZINC.get());
    }

    protected void createTekoraOreDrops(Block pBlock, Item pItem) {
        add(pBlock, block -> createTekoraOreDrops(block, pItem, 1, 1));
    }

    protected LootTable.Builder createTekoraOreDrops(Block pBlock, Item pItem, int max, int min) {
        HolderLookup.RegistryLookup<Enchantment> lookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                                .apply(ApplyBonusCount.addOreBonusCount(lookup.getOrThrow(Enchantments.FORTUNE)))
                        ));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
