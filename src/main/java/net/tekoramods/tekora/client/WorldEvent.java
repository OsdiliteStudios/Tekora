package net.tekoramods.tekora.client;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tekoramods.tekora.Tekora;

@Mod.EventBusSubscriber(modid = Tekora.MODID)
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

    public static void inWater(BlockEvent event) {
        BlockState state = event.getState();
        if (state.getBlock() instanceof LiquidBlock liquid) {
            if (liquid.getFluid() instanceof WaterFluid) {
                // todo make any alkali metals like sodium explode if is in water.
                // turn into a config option if this proves to be too laggy.
            }
        }
    }
    // code pollution on to furnaces in the future.
}
