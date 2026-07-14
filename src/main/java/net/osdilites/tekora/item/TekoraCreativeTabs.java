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

                        out.accept(TekoraItems.WRENCH.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}