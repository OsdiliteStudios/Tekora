package net.osdilites.tekora.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
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
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.data.TekoraComponents;

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
        // todo, figure a way to incorporate item tags into the Ingredient class
//        if (Ingredient.of(Items.IRON_CHAIN).acceptsItem(stack.typeHolder()) && stack.has(TekoraComponents.PARTNER)
//                && level.getBlockEntity(pos) instanceof ShaftEntity shaft && shaft.canBeCog()) {
//            BlockPos orgPos = stack.get(TekoraComponents.PARTNER);
//            if (orgPos == null) {
//                stack.set(TekoraComponents.PARTNER, pos);
//            } else {
//                shaft.addAttachedPartner(stack.getItem(), orgPos);
//                stack.shrink(1);
//            }
//        }
    }
}
