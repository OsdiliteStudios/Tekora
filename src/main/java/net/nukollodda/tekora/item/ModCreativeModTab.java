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
    public static final CreativeModeTab TEKORA_BLOCKS = new CreativeModeTab("tekora_blocks") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(ModBlocks.BAUXITE_ORE.get()); }
    };
}
