package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.ShaftEntity;

public class GearItem extends TekoraItem {
    protected final GearType gearType;
    protected final boolean isLarge;

    // gearitems are created with isLarge = false by default
    public GearItem(String name, GearType gearType, boolean flammable) {
        this(name, gearType, flammable, false);
    }

    protected GearItem(String name, GearType gearType, boolean flammable, boolean isLarge) {
        super(flammable, name);
        this.gearType = gearType;
        this.isLarge = isLarge;
    }

    protected InteractionResult placeSuccessful(UseOnContext context, Level world, BlockPos pos, BlockState state) {
        BlockState newState = state.setValue(TekoraBlockStates.GEAR_TYPE, gearType);
        
        // if something doesn't have an isLarge property, like modular machinery,it would crash without this guard
        if (state.hasProperty(TekoraBlockStates.IS_LARGE)) {
            newState = newState.setValue(TekoraBlockStates.IS_LARGE, isLarge);
        }

        context.getItemInHand().shrink(1);
        Player player = context.getPlayer();
        if (world.setBlock(pos, newState, 3)) {
            if (player != null) {
                player.playSound(switch (gearType) {
                    case WOOD -> SoundEvents.WOOD_PLACE;
                    case PLASTIC -> SoundEvents.GLASS_PLACE;
                    default -> SoundEvents.COPPER_BREAK;
                }, 1, 1);
            }

            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof ShaftEntity shaftEntity) {
                shaftEntity.setChanged();
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.getValue(TekoraBlockStates.GEAR_TYPE) == GearType.NONE) {
            return placeSuccessful(context, world, pos, state);
        }
        return super.useOn(context);
    }
}
