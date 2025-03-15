package net.tekoramods.tekora.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;

public class TekoraCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tekora.MODID);

    public static final RegistryObject<CreativeModeTab> INGREDIENTS = TABS.register("tekora_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TekoraItems.INFUSED_CLAY.get()))
                    .title(Component.translatable("itemGroup.tekora_ingredients"))
                    .displayItems((parm, out) -> {
                        out.accept(TekoraItems.AQUAMARINE.get());
                        out.accept(TekoraItems.BAUXITE.get());
                        out.accept(TekoraItems.CINNABAR.get());
                        out.accept(TekoraItems.DOLOMITE.get());
                        out.accept(TekoraItems.FLUORITE.get());
                        out.accept(TekoraItems.HALITE.get());
                        out.accept(TekoraItems.RUBY.get());
                        out.accept(TekoraItems.SAPPHIRE.get());
                        out.accept(TekoraItems.WOLFRAMITE.get());
                        out.accept(TekoraItems.RAW_LEAD.get());
                        out.accept(TekoraItems.RAW_NICKEL.get());
                        out.accept(TekoraItems.RAW_SILVER.get());
                        out.accept(TekoraItems.RAW_PLATINUM.get());
                        out.accept(TekoraItems.RAW_TIN.get());
                        out.accept(TekoraItems.RAW_ZINC.get());
                        out.accept(TekoraItems.ALUMINUM_INGOT.get());
                        out.accept(TekoraItems.BISMUTH_INGOT.get());
                        out.accept(TekoraItems.COBALT_INGOT.get());
                        out.accept(TekoraItems.LEAD_INGOT.get());
                        out.accept(TekoraItems.MAGNESIUM_INGOT.get());
                        out.accept(TekoraItems.MANGANESE_INGOT.get());
                        out.accept(TekoraItems.MOLYBDENUM_INGOT.get());
                        out.accept(TekoraItems.NICKEL_INGOT.get());
                        out.accept(TekoraItems.PLATINUM_INGOT.get());
                        out.accept(TekoraItems.POTASSIUM_INGOT.get());
                        out.accept(TekoraItems.SILVER_INGOT.get());
                        out.accept(TekoraItems.SODIUM_INGOT.get());
                        out.accept(TekoraItems.TIN_INGOT.get());
                        out.accept(TekoraItems.TUNGSTEN_INGOT.get());
                        out.accept(TekoraItems.ZINC_INGOT.get());
                        out.accept(TekoraItems.BRASS_INGOT.get());
                        out.accept(TekoraItems.BRONZE_INGOT.get());
                        out.accept(TekoraItems.CONSTANTAN_INGOT.get());
                        out.accept(TekoraItems.ELECTRUM_INGOT.get());
                        out.accept(TekoraItems.INVAR_INGOT.get());
                        out.accept(TekoraItems.STEEL_INGOT.get());
                        out.accept(TekoraItems.PEWTER_INGOT.get());
                        out.accept(TekoraItems.TUNGSTEN_STEEL_INGOT.get());
                        out.accept(TekoraItems.FIRE_BRICK.get());
                        out.accept(TekoraItems.INFUSED_CLAY.get());
                    }).build());


    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register("tekora_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TekoraBlocks.BISMUTH_BLOCK.get()))
                    .title(Component.translatable("itemGroup.tekora_blocks"))
                    .displayItems((parm, out) -> {
                        out.accept(TekoraBlocks.EVAPORITE.get());
                        out.accept(TekoraBlocks.LIMESTONE.get());
                        out.accept(TekoraBlocks.ALUMINUM_BLOCK.get());
                        out.accept(TekoraBlocks.BISMUTH_BLOCK.get());
                        out.accept(TekoraBlocks.COBALT_BLOCK.get());
                        out.accept(TekoraBlocks.LEAD_BLOCK.get());
                        out.accept(TekoraBlocks.MAGNESIUM_BLOCK.get());
                        out.accept(TekoraBlocks.MANGANESE_BLOCK.get());
                        out.accept(TekoraBlocks.MOLYBDENUM_BLOCK.get());
                        out.accept(TekoraBlocks.NICKEL_BLOCK.get());
                        out.accept(TekoraBlocks.PLATINUM_BLOCK.get());
                        out.accept(TekoraBlocks.SILVER_BLOCK.get());
                        out.accept(TekoraBlocks.TIN_BLOCK.get());
                        out.accept(TekoraBlocks.TUNGSTEN_BLOCK.get());
                        out.accept(TekoraBlocks.ZINC_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_LEAD_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_NICKEL_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_PLATINUM_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_SILVER_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_TIN_BLOCK.get());
                        out.accept(TekoraBlocks.RAW_ZINC_BLOCK.get());
                        out.accept(TekoraBlocks.AQUAMARINE_BLOCK.get());
                        out.accept(TekoraBlocks.BAUXITE_BLOCK.get());
                        out.accept(TekoraBlocks.CINNABAR_BLOCK.get());
                        out.accept(TekoraBlocks.DOLOMITE_BLOCK.get());
                        out.accept(TekoraBlocks.FLUORITE_BLOCK.get());
                        out.accept(TekoraBlocks.HALITE_BLOCK.get());
                        out.accept(TekoraBlocks.RUBY_BLOCK.get());
                        out.accept(TekoraBlocks.SAPPHIRE_BLOCK.get());
                        out.accept(TekoraBlocks.WOLFRAMITE_BLOCK.get());
                        out.accept(TekoraBlocks.AQUAMARINE_ORE.get());
                        out.accept(TekoraBlocks.BAUXITE_ORE.get());
                        out.accept(TekoraBlocks.CINNABAR_ORE.get());
                        out.accept(TekoraBlocks.HALITE_ORE.get());
                        out.accept(TekoraBlocks.LEAD_ORE.get());
                        out.accept(TekoraBlocks.NICKEL_ORE.get());
                        out.accept(TekoraBlocks.RUBY_ORE.get());
                        out.accept(TekoraBlocks.SAPPHIRE_ORE.get());
                        out.accept(TekoraBlocks.TIN_ORE.get());
                        out.accept(TekoraBlocks.WOLFRAMITE_ORE.get());
                        out.accept(TekoraBlocks.ZINC_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_BAUXITE_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_CINNABAR_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_HALITE_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_LEAD_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_NICKEL_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_RUBY_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_TIN_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_WOLFRAMITE_ORE.get());
                        out.accept(TekoraBlocks.DEEPSLATE_ZINC_ORE.get());
                        out.accept(TekoraBlocks.FIREBRICKS.get());
                        out.accept(TekoraBlocks.CASTING_BRICKS.get());
                    }).build());


    public static final RegistryObject<CreativeModeTab> PARTS = TABS.register("tekora_parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TekoraBlocks.WOODEN_COGWHEEL.get()))
                    .title(Component.translatable("itemGroup.tekora_parts"))
                    .displayItems((parm, out) -> {
                        out.accept(TekoraBlocks.SHAFT.get());
                        out.accept(TekoraBlocks.WOODEN_COGWHEEL.get());
                        out.accept(TekoraBlocks.WOODEN_WATERWHEEL.get());
                        out.accept(TekoraBlocks.KILN_FURNACE.get());
                        out.accept(TekoraBlocks.ITEM_INPUT_BLOCK.get());
                        out.accept(TekoraBlocks.ITEM_OUTPUT_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
