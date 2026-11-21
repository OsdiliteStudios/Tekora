package net.osdilites.tekora.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;

public class TekoraCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tekora.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MACHINES = CREATIVE_MODE_TABS.register("machines",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tekora_machines"))
                    .icon(() -> TekoraBlocks.STEEL_SHAFT.get().asItem().getDefaultInstance())
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((param, out) -> {
                        out.accept(TekoraBlocks.MECH_TOP.get().asItem());
                        out.accept(TekoraBlocks.STEEL_SHAFT.get().asItem());
                        out.accept(TekoraBlocks.HAND_CRANK.get().asItem());
                        out.accept(TekoraBlocks.DEPOT.get().asItem());
                        out.accept(TekoraBlocks.BASIN.get().asItem());

                        out.accept(TekoraBlocks.COMBUSTION_CHAMBER.get().asItem());
                        out.accept(TekoraBlocks.KILN_FURNACE.get().asItem());
                        out.accept(TekoraBlocks.COPPER_PIPE.get().asItem());

                        out.accept(TekoraBlocks.STEEL_BLOCK.get().asItem());
                        out.accept(TekoraBlocks.FIRE_BRICKS.get().asItem());
                        out.accept(TekoraBlocks.FIRE_CLAY.get().asItem());

                        out.accept(TekoraItems.ALUMINUM_GEAR.get());
                        out.accept(TekoraItems.BRASS_GEAR.get());
                        out.accept(TekoraItems.BRONZE_GEAR.get());
                        out.accept(TekoraItems.PLASTIC_GEAR.get());
                        out.accept(TekoraItems.STEEL_GEAR.get());
                        out.accept(TekoraItems.WOODEN_GEAR.get());
                        out.accept(TekoraItems.ALUMINUM_GEAR_PART.get());
                        out.accept(TekoraItems.BRASS_GEAR_PART.get());
                        out.accept(TekoraItems.BRONZE_GEAR_PART.get());
                        out.accept(TekoraItems.PLASTIC_GEAR_PART.get());
                        out.accept(TekoraItems.STEEL_GEAR_PART.get());
                        out.accept(TekoraItems.WOODEN_GEAR_PART.get());

                        out.accept(TekoraItems.CRUSHING_WHEEL.get());
                        out.accept(TekoraItems.WHISK.get());
                        out.accept(TekoraItems.PRESS_SHAFT.get());
                        out.accept(TekoraItems.INK_PRESS_SHAFT.get());
                        out.accept(TekoraItems.CUTTER_SHAFT.get());
                    }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PARTS = CREATIVE_MODE_TABS.register("parts",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tekora_parts"))
                    .icon(() -> TekoraItems.STEEL_PLATE.get().asItem().getDefaultInstance())
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((param, out) -> {
                        out.accept(TekoraItems.STEEL_INGOT.get());
                        out.accept(TekoraItems.STEEL_PLATE.get());
                        out.accept(TekoraItems.STEEL_ROD.get());
                        out.accept(TekoraItems.FIRE_BRICK.get());
                        out.accept(TekoraItems.FIRE_CLAY_BALL.get());
                        out.accept(TekoraItems.BAUXITE.get());
                        out.accept(TekoraItems.CINNABAR_SHARD.get());
                        out.accept(TekoraItems.MAGNESIUM_CARBONATE.get());
                        out.accept(TekoraItems.SODIUM_CHLORIDE.get());
                        out.accept(TekoraItems.AMMONIUM_PHOSPHATE.get());
                    }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS = CREATIVE_MODE_TABS.register("tools",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tekora_tools"))
                    .icon(() -> TekoraItems.STEEL_PLATE.get().asItem().getDefaultInstance())
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((param, out) -> {
                        out.accept(TekoraItems.MERCURY_THERMOMETER.get());
                        out.accept(TekoraItems.GALINSTAN_THERMOMETER.get());
                        out.accept(TekoraItems.GALINSTAN_QUARTZ_THERMOMETER.get());
                        out.accept(TekoraItems.WRENCH.get());
                    }).build());

    // TODO: maybe switch later to "Chemicals" or "Elements" or "Chemical Elements" or something
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FLUIDS = CREATIVE_MODE_TABS.register("fluids",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tekora_fluids"))
                    .icon(() -> TekoraItems.AMMONIA_BUCKET.get().asItem().getDefaultInstance())
                    .withTabsBefore(TOOLS.getKey())
                    .displayItems((param, out) -> {
                        out.accept(TekoraItems.ACETIC_ACID_BUCKET.get());
                        out.accept(TekoraItems.ACETONE_BUCKET.get());
                        out.accept(TekoraItems.AMMONIA_BUCKET.get());
                        out.accept(TekoraItems.BENZENE_BUCKET.get());
                        out.accept(TekoraItems.BROMINE_BUCKET.get());
                        out.accept(TekoraItems.ETHANOL_BUCKET.get());
                        out.accept(TekoraItems.FORMIC_ACID_BUCKET.get());
                        out.accept(TekoraItems.HYDRAZINE_BUCKET.get());
                        out.accept(TekoraItems.HYDROGEN_FLUORIDE_BUCKET.get());
                        out.accept(TekoraItems.HYDROGEN_PEROXIDE_BUCKET.get());
                        out.accept(TekoraItems.METHANOL_BUCKET.get());
                        out.accept(TekoraItems.SULFUR_DIOXIDE_BUCKET.get());
                        out.accept(TekoraItems.SULFUR_TRIOXIDE_BUCKET.get());
                        out.accept(TekoraItems.SULFURIC_ACID_BUCKET.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}