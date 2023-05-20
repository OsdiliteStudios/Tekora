package net.nukollodda.tekora.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.block.ModBlocks;

public class ModCreativeModTab {
    public static final CreativeModeTab TEKORA_MINERALS = new CreativeModeTab("tekora_minerals") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BAUXITE.get());
        }
    };
    public static final CreativeModeTab TEKORA_ITEMS = new CreativeModeTab("tekora_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COBALT_INGOT.get());
        }
    };
    public static final CreativeModeTab TEKORA_DUSTS = new CreativeModeTab("tekora_dusts") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SULFUR_DUST.get());
        }
    };
/*
    public static final CreativeModeTab TEKORA_PARTS = new CreativeModeTab("tekora_parts") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CANISTER.get());
        }
    };
    public static final CreativeModeTab TEKORA_MACHINES = new CreativeModeTab("tekora_machines") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(ModBlocks.SOLVENT_CHAMBER.get()); }
    };
*/
    public static final CreativeModeTab TEKORA_BLOCKS = new CreativeModeTab("tekora_blocks") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(ModBlocks.BAUXITE_ORE.get()); }
    };
}
