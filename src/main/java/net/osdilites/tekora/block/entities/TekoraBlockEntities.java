package net.osdilites.tekora.block.entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.transporter.rotational.CogwheelEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.HandCrankEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.block.entities.thermal.KilnFurnaceEntity;

import java.util.Set;
import java.util.function.Supplier;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Tekora.MODID);

    public static final Supplier<BlockEntityType<CogwheelEntity>> COGWHEEL =
            BLOCK_ENTITIES.register("wooden_cogwheel", () -> new BlockEntityType<>(CogwheelEntity::new,
                    Set.of(TekoraBlocks.WOODEN_COGWHEEL.get())));

    public static final Supplier<BlockEntityType<HandCrankEntity>> HAND_CRANK =
            BLOCK_ENTITIES.register("hand_crank", () -> new BlockEntityType<>(HandCrankEntity::new,
                    Set.of(TekoraBlocks.HAND_CRANK.get())));

    public static final Supplier<BlockEntityType<ShaftEntity>> SHAFT =
            BLOCK_ENTITIES.register("shaft", () -> new BlockEntityType<>(ShaftEntity::new,
                    Set.of(TekoraBlocks.SHAFT.get())));

//    public static final Supplier<BlockEntityType<WaterwheelEntity.Wood>> WOODEN_WATERWHEEL =
//            BLOCK_ENTITIES.register("wooden_waterwheel", () -> new BlockEntityType<>(WaterwheelEntity.Wood::new,
//                    Set.of(TekoraBlocks.WOODEN_WATERWHEEL.get())));

    public static final Supplier<BlockEntityType<KilnFurnaceEntity>> KILN_FURNACE =
            BLOCK_ENTITIES.register("kiln_furnace", () -> new BlockEntityType<>(KilnFurnaceEntity::new,
                    Set.of(TekoraBlocks.KILN_FURNACE.get())));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
