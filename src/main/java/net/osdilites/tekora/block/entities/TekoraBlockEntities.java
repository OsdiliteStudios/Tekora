package net.osdilites.tekora.block.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.attachment.ItemInputEntity;
import net.osdilites.tekora.block.entities.attachment.ItemOutputEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.CogwheelEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.block.entities.transporter.rotational.WaterwheelEntity;
import net.osdilites.tekora.block.entities.thermal.KilnFurnaceEntity;

import java.util.Set;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Tekora.MODID);

    public static final RegistryObject<BlockEntityType<ItemInputEntity>> ITEM_INPUT_ENTITY =
            BLOCK_ENTITIES.register("item_input_entity", () -> new BlockEntityType<>(ItemInputEntity::new,
                    Set.of(TekoraBlocks.ITEM_INPUT_BLOCK.get())));

    public static final RegistryObject<BlockEntityType<ItemOutputEntity>> ITEM_OUTPUT_ENTITY =
            BLOCK_ENTITIES.register("item_output_entity", () -> new BlockEntityType<>(ItemOutputEntity::new,
                    Set.of(TekoraBlocks.ITEM_OUTPUT_BLOCK.get())));

    public static final RegistryObject<BlockEntityType<CogwheelEntity.Wood>> WOODEN_COGWHEEL =
            BLOCK_ENTITIES.register("wooden_cogwheel", () -> new BlockEntityType<>(CogwheelEntity.Wood::new,
                    Set.of(TekoraBlocks.WOODEN_COGWHEEL.get())));

    public static final RegistryObject<BlockEntityType<ShaftEntity.Steel>> STEEL_SHAFT =
            BLOCK_ENTITIES.register("shaft", () -> new BlockEntityType<>(ShaftEntity.Steel::new,
                    Set.of(TekoraBlocks.SHAFT.get())));

    public static final RegistryObject<BlockEntityType<WaterwheelEntity.Wood>> WOODEN_WATERWHEEL =
            BLOCK_ENTITIES.register("wooden_waterwheel", () -> new BlockEntityType<>(WaterwheelEntity.Wood::new,
                    Set.of(TekoraBlocks.WOODEN_WATERWHEEL.get())));

    public static final RegistryObject<BlockEntityType<KilnFurnaceEntity>> KILN_FURNACE =
            BLOCK_ENTITIES.register("kiln_furnace", () -> new BlockEntityType<>(KilnFurnaceEntity::new,
                    Set.of(TekoraBlocks.KILN_FURNACE.get())));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
