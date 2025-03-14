package net.tekoramods.tekora.block.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entities.transporter.rotational.CogwheelEntity;
import net.tekoramods.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.tekoramods.tekora.block.entities.transporter.rotational.WaterwheelEntity;
import net.tekoramods.tekora.block.entities.thermal.KilnFurnaceEntity;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Tekora.MODID);

    public static final RegistryObject<BlockEntityType<CogwheelEntity.Wood>> WOODEN_COGWHEEL =
            BLOCK_ENTITIES.register("wooden_cogwheel", () -> BlockEntityType.Builder.of(CogwheelEntity.Wood::new,
                    TekoraBlocks.WOODEN_COGWHEEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShaftEntity.Steel>> STEEL_SHAFT =
            BLOCK_ENTITIES.register("shaft", () -> BlockEntityType.Builder.of(ShaftEntity.Steel::new,
                    TekoraBlocks.SHAFT.get()).build(null));

    public static final RegistryObject<BlockEntityType<WaterwheelEntity.Wood>> WOODEN_WATERWHEEL =
            BLOCK_ENTITIES.register("wooden_waterwheel", () -> BlockEntityType.Builder.of(WaterwheelEntity.Wood::new,
                    TekoraBlocks.WOODEN_WATERWHEEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<KilnFurnaceEntity>> KILN_FURNACE =
            BLOCK_ENTITIES.register("kiln_furnace", () -> BlockEntityType.Builder.of(KilnFurnaceEntity::new,
                    TekoraBlocks.KILN_FURNACE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
