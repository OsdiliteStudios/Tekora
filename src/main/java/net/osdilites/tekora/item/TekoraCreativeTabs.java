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
                    .icon(() -> TekoraBlocks.WOODEN_COGWHEEL.get().asItem().getDefaultInstance())
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((param, out) -> {
                        out.accept(TekoraBlocks.WOODEN_COGWHEEL.get().asItem());
                        out.accept(TekoraBlocks.SHAFT.get().asItem());
                        out.accept(TekoraBlocks.WOODEN_HAND_CRANK.get().asItem());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}