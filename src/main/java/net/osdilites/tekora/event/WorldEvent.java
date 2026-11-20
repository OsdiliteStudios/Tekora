package net.osdilites.tekora.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.data.Partners;
import net.osdilites.tekora.data.TekoraComponents;
import net.osdilites.tekora.datagen.modelcases.BiomeTemperature;
import net.osdilites.tekora.datagen.tags.TekoraTags;
import net.osdilites.tekora.item.BottleResourceHandler;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Tekora.MODID)
public class WorldEvent {
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Entity target = event.getTarget();
        if (target instanceof LivingEntity living) {
            Player player = event.getEntity();
            Item item = player.getWeaponItem().getItem();
            if (item.equals(Items.TORCH)) {
                living.setRemainingFireTicks(50);
            }
            if (item.equals(Items.LAVA_BUCKET)) {
                living.hurt(event.getTarget().damageSources().onFire(), 2);
                living.setRemainingFireTicks(500);
            }
        }
    }

    // Commented out since using a BlockEvent is not allowed by NeoForge here else crash, for some reason
    // @SubscribeEvent
    // public static void inWater(BlockEvent event) {
    //     BlockState state = event.getState();
    //     if (state.getBlock() instanceof LiquidBlock liquid) {
    //         if (liquid.fluid instanceof WaterFluid) {
    //             // todo make any alkali metals explode if is in water.
    //             // turn into a config option if this proves to be too laggy.
    //         }
    //     }
    // }

    // this machineType of code could also be applied to Tekora cables in the future.
    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickItem event) {
        ItemStack stack = event.getItemStack();
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        if (Ingredient.of(Items.IRON_CHAIN).acceptsItem(stack.typeHolder()) && stack.has(TekoraComponents.PARTNERS.get())
                && level.getBlockEntity(pos) instanceof ShaftEntity shaft && shaft.canBeCog()) {
            Partners partners = stack.get(TekoraComponents.PARTNERS.get());
            if (partners != null) {
                List<BlockPos> poses = partners.partners();
                if (poses != null) {
                    poses.add(pos);
                } else {
                    partners.addPartner(pos);
                }
            } else {
                stack.set(TekoraComponents.PARTNERS.get(), new Partners(new ArrayList<>(List.of(pos))));
            }
        }
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//    event.registerBlockEntity(Capabilities.Item.BLOCK, TekoraBlockEntities.BASIN.get(), TekoraBlockEntities::getItemHandler);

        // Possible compatibility issue with other mods?
        event.registerItem(Capabilities.Fluid.ITEM, 
            (stack, itemAccess) -> new BottleResourceHandler(itemAccess), 
            Items.POTION, Items.GLASS_BOTTLE);
    }

    @SubscribeEvent
    public static void registerRangeSelectProperties(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(
                Identifier.fromNamespaceAndPath("tekora", "biome_temperature"),
                BiomeTemperature.MAP_CODEC
        );
    }

//    @SubscribeEvent
//    public static void registerBlockTickEvent(BlockEvent event) {
//        BlockPos pos = event.getPos();
//        if (!event.getLevel().isClientSide() && event.getLevel().getBlockEntity(pos) != null && event.getState().hasProperty(BlockStateProperties.LIT)) {
//            BlockEntity blockEntity = event.getLevel().getBlockEntity(pos);
//            if (blockEntity instanceof AbstractFurnaceBlockEntity furnace && event.getLevel() instanceof Level level) {
//                // todo finish up this code
//                ItemStack item = furnace.getItem(1);
//                AreaEffectCloud cloud = new AreaEffectCloud(level, pos.getX(), pos.getY(), pos.getZ());
//                MobEffectInstance instance;
//                if (item.is(TekoraTags.Items.TOXIC_FUMES_ON_SMELT)) {
//                    instance = new MobEffectInstance(MobEffects.POISON, 200, 0, false, false);
//                } else if (item.is(TekoraTags.Items.BLINDING_FUMES_ON_SMELT)) {
//                    instance = new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false);
//                } else {
//                    instance = new MobEffectInstance((Holder<MobEffect>) null);
//                }
//                cloud.addEffect(instance);
//            }
//        }
//    }
}
