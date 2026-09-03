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
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachine;
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

        add(TekoraBlocks.ASSEMBLER.get(), this::dropMechTopPart);
        add(TekoraBlocks.CRUSHER.get(), this::dropMechTopPart);
        add(TekoraBlocks.MIXER.get(), this::dropMechTopPart);
        add(TekoraBlocks.PRINTER.get(), this::dropMechTopPart);
        add(TekoraBlocks.PRESS.get(), this::dropMechTopPart);
        add(TekoraBlocks.CUTTER.get(), this::dropMechTopPart);
    }

    private LootTable.Builder dropMechTopPart(Block block) {
        return dropParts(TekoraBlocks.MECH_TOP.get(), block instanceof AbstractModularMachine machine ? machine : TekoraBlocks.MECH_TOP.get());
    }

    private LootTable.Builder dropParts(Block block, AbstractModularMachine modMech) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(block.asItem()));
        return LootTable.lootTable().withPool(
                modMech.equals(TekoraBlocks.MECH_TOP.get()) ? builder : builder.add(LootItem.lootTableItem(modMech.getAssocItem())));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TekoraBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
