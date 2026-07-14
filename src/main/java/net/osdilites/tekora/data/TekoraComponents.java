package net.osdilites.tekora.data;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;

public class TekoraComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Tekora.MODID);

//    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Partners>> PARTNERS =
//            COMPONENTS.register("partners", () -> DataComponentType.<Partners>builder()
//                    .persistent(Partners.CODEC)
//                    .networkSynchronized(Partners.STREAM_CODEC)
//                    .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ManuscriptComponent>> MANUSCRIPT_ID =
            COMPONENTS.register("manuscript_id", () -> DataComponentType.<ManuscriptComponent>builder()
                    .persistent(ManuscriptComponent.CODEC)
                    .networkSynchronized(ManuscriptComponent.STREAM_CODEC)
                    .build());

    public static void register(IEventBus eventBus) {
        COMPONENTS.register(eventBus);
    }
}
