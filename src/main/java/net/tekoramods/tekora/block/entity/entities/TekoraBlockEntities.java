package net.tekoramods.tekora.block.entity.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tekoramods.tekora.Tekora;
import net.tekoramods.tekora.block.TekoraBlocks;
import net.tekoramods.tekora.block.entity.entities.connectors.EnergyCableEntity;
import net.tekoramods.tekora.block.entity.entities.connectors.EnergyCableFacadeEntity;
import net.tekoramods.tekora.block.entity.entities.storage.InfiniteBatteryEntity;
import net.tekoramods.tekora.block.entity.entities.generators.HydroelectricGeneratorEntity;
import net.leng.tekora.block.entity.entities.machines.*;
import net.tekoramods.tekora.block.entity.entities.machines.*;

public class TekoraBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Tekora.MODID);

    public static final RegistryObject<BlockEntityType<AlloyFurnaceEntity>> ALLOY_FURNACE =
            BLOCK_ENTITIES.register("alloy_furnace", () ->
                BlockEntityType.Builder.of(AlloyFurnaceEntity::new,
                    TekoraBlocks.ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<InfusionFurnaceEntity>> INFUSION_FURNACE =
            BLOCK_ENTITIES.register("infusion_furnace", () ->
                BlockEntityType.Builder.of(InfusionFurnaceEntity::new,
                    TekoraBlocks.INFUSION_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<CompressorEntity>> COMPRESSOR =
            BLOCK_ENTITIES.register("compressor", () ->
                BlockEntityType.Builder.of(CompressorEntity::new,
                    TekoraBlocks.COMPRESSOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<CutterEntity>> CUTTER =
            BLOCK_ENTITIES.register("cutter", () ->
                    BlockEntityType.Builder.of(CutterEntity::new,
                            TekoraBlocks.CUTTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ExtruderEntity>> EXTRUDER =
            BLOCK_ENTITIES.register("extruder", () ->
                    BlockEntityType.Builder.of(ExtruderEntity::new,
                            TekoraBlocks.EXTRUDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ElectricFurnaceEntity>> ELECTRIC_FURNACE =
            BLOCK_ENTITIES.register("electric_furnace", () ->
                BlockEntityType.Builder.of(ElectricFurnaceEntity::new,
                    TekoraBlocks.ELECTRIC_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<CentrifugeEntity>> CENTRIFUGE =
            BLOCK_ENTITIES.register("centrifuge", () ->
                    BlockEntityType.Builder.of(CentrifugeEntity::new,
                            TekoraBlocks.CENTRIFUGE.get()).build(null));


    public static final RegistryObject<BlockEntityType<InfiniteBatteryEntity>> INFINITE_BATTERY =
            BLOCK_ENTITIES.register("infinite_battery", () ->
                BlockEntityType.Builder.of(InfiniteBatteryEntity::new,
                    TekoraBlocks.INFINITE_BATTERY.get()).build(null));

    public static final RegistryObject<BlockEntityType<EnergyCableEntity>> ENERGY_CABLE =
            BLOCK_ENTITIES.register("energy_cable", () ->
                    BlockEntityType.Builder.of(EnergyCableEntity::new,
                            TekoraBlocks.ALUMINUM_CABLE.get(), TekoraBlocks.COPPER_CABLE.get(), TekoraBlocks.CUPRONICKEL_CABLE.get(),
                            TekoraBlocks.ELECTRUM_CABLE.get(), TekoraBlocks.GOLD_CABLE.get(), TekoraBlocks.SILVER_CABLE.get(),
                            TekoraBlocks.TIN_CABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<HydroelectricGeneratorEntity>> HYDROELECTRIC_GENERATOR =
            BLOCK_ENTITIES.register("hydroelectric_generator", () ->
                    BlockEntityType.Builder.of(HydroelectricGeneratorEntity::new,
                            TekoraBlocks.HYDROELECTRIC_GENERATOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<PulverizerEntity>> PULVERIZER =
            BLOCK_ENTITIES.register("pulverizer", () -> BlockEntityType.Builder.of(PulverizerEntity::new,
                    TekoraBlocks.PULVERIZER.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyCableFacadeEntity>> ENERGY_CABLE_FACADE =
            BLOCK_ENTITIES.register("energy_cable_facade", () -> BlockEntityType.Builder.of(EnergyCableFacadeEntity::new,
                    TekoraBlocks.ALUMINUM_CABLE_FACADE.get(), TekoraBlocks.COPPER_CABLE_FACADE.get(), TekoraBlocks.CUPRONICKEL_CABLE_FACADE.get(),
                    TekoraBlocks.ELECTRUM_CABLE_FACADE.get(), TekoraBlocks.GOLD_CABLE_FACADE.get(), TekoraBlocks.SILVER_CABLE_FACADE.get(),
                    TekoraBlocks.TIN_CABLE_FACADE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
