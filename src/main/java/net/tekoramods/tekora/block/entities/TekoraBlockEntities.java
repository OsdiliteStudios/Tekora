package net.tekoramods.tekora.block.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entities.mechanical.rotational.CogwheelEntity;
import net.tekoramods.tekora.block.entities.mechanical.rotational.ShaftEntity;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Tekora.MODID);

    public static final RegistryObject<BlockEntityType<CogwheelEntity.Wood>> WOODEN_COGWHEEL =
            BLOCK_ENTITIES.register("wooden_cogwheel", () -> BlockEntityType.Builder.of(CogwheelEntity.Wood::new,
                    TekoraBlocks.WOODEN_COGWHEEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShaftEntity.Steel>> STEEL_SHAFT =
            BLOCK_ENTITIES.register("shaft", () -> BlockEntityType.Builder.of(ShaftEntity.Steel::new,
                    TekoraBlocks.SHAFT.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
