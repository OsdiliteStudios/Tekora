package net.osdilites.tekora.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.item.TekoraItems;

import java.util.Set;

public class TekoraLootTableProvider extends BlockLootSubProvider {
    public TekoraLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //var enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT);

        dropSelf(TekoraBlocks.BASIN.get());
        dropSelf(TekoraBlocks.DEPOT.get());
        dropSelf(TekoraBlocks.STEEL_SHAFT.get());
        dropSelf(TekoraBlocks.HAND_CRANK.get());
        dropSelf(TekoraBlocks.KILN_FURNACE.get());
        dropSelf(TekoraBlocks.MECH_TOP.get());

        add(TekoraBlocks.CRUSHER.get(), b -> dropMechTopPart(TekoraItems.CRUSHING_WHEEL.get()));
        add(TekoraBlocks.MIXER.get(), b -> dropMechTopPart(TekoraItems.WHISK.get()));
        add(TekoraBlocks.PRINTER.get(), b -> dropMechTopPart(TekoraItems.INK_PRESS_SHAFT.get()));
        add(TekoraBlocks.PRESS.get(), b -> dropMechTopPart(TekoraItems.PRESS_SHAFT.get()));
        add(TekoraBlocks.CUTTER.get(), b -> dropMechTopPart(TekoraItems.CUTTER_SHAFT.get()));
    }

    private LootTable.Builder dropMechTopPart(Item part) {
        return dropParts(TekoraBlocks.MECH_TOP.get(), part);
    }

    private LootTable.Builder dropParts(Block block, Item part) {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(block.asItem()))
                .add(LootItem.lootTableItem(part)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
