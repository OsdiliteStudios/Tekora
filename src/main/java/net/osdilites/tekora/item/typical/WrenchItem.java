package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.Tekora;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;
import net.osdilites.tekora.item.TekoraItems;

public class WrenchItem extends Item {
    public WrenchItem(String pName, int durability) {
        super(new Properties()
                .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tekora.MODID, pName)))
                .durability(durability)
                .stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level lvl = context.getLevel();
        if (!lvl.isClientSide()) {
            Player player = context.getPlayer();
            BlockPos pos = context.getClickedPos();
            BlockState state = lvl.getBlockState(pos);
            BlockState newState = state;
            if (player != null && player.isShiftKeyDown() && state.hasProperty(Shaft.GEAR_TYPE)) {
                GearType type = state.getValue(Shaft.GEAR_TYPE);
                Item dropped = switch (type) {
                    case ALUMINUM -> TekoraItems.ALUMINUM_GEAR.get();
                    case BRONZE -> TekoraItems.BRONZE_GEAR.get();
                    case BRASS -> TekoraItems.BRASS_GEAR.get();
                    case STEEL -> TekoraItems.STEEL_GEAR.get();
                    case PLASTIC -> TekoraItems.PLASTIC_GEAR.get();
                    case WOOD -> TekoraItems.WOODEN_GEAR.get();
                    case NONE -> null;
                };
                if (state.getValueOrElse(Shaft.IS_LARGE, false)) {
                    Item additional = switch (type) {
                        case ALUMINUM -> TekoraItems.ALUMINUM_GEAR_PART.get();
                        case BRONZE -> TekoraItems.BRONZE_GEAR_PART.get();
                        case BRASS -> TekoraItems.BRASS_GEAR_PART.get();
                        case STEEL -> TekoraItems.STEEL_GEAR_PART.get();
                        case PLASTIC -> TekoraItems.PLASTIC_GEAR_PART.get();
                        case WOOD -> TekoraItems.WOODEN_GEAR_PART.get();
                        case NONE -> null;
                    };
                    if (additional != null) {
                        lvl.addFreshEntity(new ItemEntity(lvl, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(additional, 4)));
                        context.getItemInHand().hurtAndBreak(1, player, context.getHand());
                    }
                    newState = state.setValue(Shaft.IS_LARGE, false);
                }

                newState = newState.setValue(Shaft.GEAR_TYPE, GearType.NONE);
                if (dropped != null) {
                    lvl.addFreshEntity(new ItemEntity(lvl, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropped, 1)));
                    player.playSound(switch(type) {
                        case WOOD -> SoundEvents.WOOD_BREAK;
                        case PLASTIC -> SoundEvents.GLASS_BREAK;
                        default -> SoundEvents.METAL_BREAK;
                    }, 1, 1);
                    context.getItemInHand().hurtAndBreak(1, player, context.getHand());
                }
            } else {
                if (state.hasProperty(BlockStateProperties.FACING)) {
                    newState = newState.setValue(BlockStateProperties.FACING, context.getClickedFace());
                } else if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    newState = newState.setValue(BlockStateProperties.HORIZONTAL_FACING, context.getClickedFace());
                } else if (state.hasProperty(BlockStateProperties.VERTICAL_DIRECTION)) {
                    newState = newState.setValue(BlockStateProperties.VERTICAL_DIRECTION, state.getValue(BlockStateProperties.VERTICAL_DIRECTION));
                } else if (state.hasProperty(BlockStateProperties.AXIS)) {
                    newState = newState.setValue(BlockStateProperties.AXIS, context.getClickedFace().getAxis());
                } else if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                    newState = newState.setValue(BlockStateProperties.HORIZONTAL_AXIS, context.getClickedFace().getAxis());
                } // todo, add an else-if to account for cables, chains, pipes, etc.
            }

            lvl.setBlock(pos, newState, 3);

        }
        return super.useOn(context);
    }
}
