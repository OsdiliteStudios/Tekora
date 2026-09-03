package net.osdilites.tekora.block.entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.*;
import net.osdilites.tekora.block.entities.transporter.rotational.HandCrankEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.block.entities.thermal.KilnFurnaceEntity;

import java.util.Set;
import java.util.function.Supplier;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Tekora.MODID);

    public static final Supplier<BlockEntityType<HandCrankEntity>> HAND_CRANK =
            BLOCK_ENTITIES.register("hand_crank", () -> new BlockEntityType<>(HandCrankEntity::new,
                    Set.of(TekoraBlocks.HAND_CRANK.get())));

    public static final Supplier<BlockEntityType<ShaftEntity>> SHAFT =
            BLOCK_ENTITIES.register("shaft", () -> new BlockEntityType<>(ShaftEntity::new,
                    Set.of(TekoraBlocks.STEEL_SHAFT.get())));

    public static final Supplier<BlockEntityType<AssemblerMechanicalEntity>> ASSEMBLER =
            BLOCK_ENTITIES.register("assmbler", () -> new BlockEntityType<>(AssemblerMechanicalEntity::new,
                    Set.of(TekoraBlocks.ASSEMBLER.get())));

    public static final Supplier<BlockEntityType<MixerMechanicalEntity>> MIXER =
            BLOCK_ENTITIES.register("mixer", () -> new BlockEntityType<>(MixerMechanicalEntity::new,
                    Set.of(TekoraBlocks.MIXER.get())));

    public static final Supplier<BlockEntityType<CrusherMechanicalEntity>> CRUSHER =
            BLOCK_ENTITIES.register("crusher", () -> new BlockEntityType<>(CrusherMechanicalEntity::new,
                    Set.of(TekoraBlocks.CRUSHER.get())));

    public static final Supplier<BlockEntityType<PrinterMechanicalEntity>> PRINTER =
            BLOCK_ENTITIES.register("printer", () -> new BlockEntityType<>(PrinterMechanicalEntity::new,
                    Set.of(TekoraBlocks.PRINTER.get())));

    public static final Supplier<BlockEntityType<PressMechanicalEntity>> PRESS =
            BLOCK_ENTITIES.register("press", () -> new BlockEntityType<>(PressMechanicalEntity::new,
                    Set.of(TekoraBlocks.PRESS.get())));

    public static final Supplier<BlockEntityType<CutterMechanicalEntity>> CUTTER =
            BLOCK_ENTITIES.register("cutter", () -> new BlockEntityType<>(CutterMechanicalEntity::new,
                    Set.of(TekoraBlocks.CUTTER.get())));

    public static final Supplier<BlockEntityType<TopMechanicalEntity>> TOP_MECH =
            BLOCK_ENTITIES.register("mechanical_top", () -> new BlockEntityType<>(TopMechanicalEntity::new,
                    Set.of(TekoraBlocks.MECH_TOP.get())));

    public static final Supplier<BlockEntityType<BasinEntity>> BASIN =
            BLOCK_ENTITIES.register("basin", () -> new BlockEntityType<>(BasinEntity::new,
                    Set.of(TekoraBlocks.BASIN.get())));

    public static final Supplier<BlockEntityType<DepotEntity>> DEPOT =
            BLOCK_ENTITIES.register("depot", () -> new BlockEntityType<>(DepotEntity::new,
                    Set.of(TekoraBlocks.DEPOT.get())));

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
