package net.osdilites.tekora.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.WaterFluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.data.Partners;
import net.osdilites.tekora.data.TekoraComponents;

import java.util.ArrayList;
import java.util.List;

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

    @SubscribeEvent
    public static void inWater(BlockEvent event) {
        BlockState state = event.getState();
        if (state.getBlock() instanceof LiquidBlock liquid) {
            if (liquid.fluid instanceof WaterFluid) {
                // todo make any alkali metals explode if is in water.
                // turn into a config option if this proves to be too laggy.
            }
        }
    }

    // this type of code could also be applied to Tekora cables in the future.
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

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.registerBlockEntity(Capabilities.Item.BLOCK, TekoraBlockEntities.BASIN.get(), TekoraBlockEntities::getItemHandler);
    }
}
