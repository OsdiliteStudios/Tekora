package net.osdilites.tekora.client;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.WaterFluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.TekoraBlockEntities;
import net.osdilites.tekora.block.renderer.RotationalEntityRenderer;

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
                // todo make any alkali metals like sodium explode if is in water.
                // turn into a config option if this proves to be too laggy.
            }
        }
    }
}
