package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.mechanical.AbstractTekoraMechanicalMachine;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;

public class GearItem extends TekoraItem {
    private final GearType gearType;

    public GearItem(String name, GearType gearType, boolean flammable) {
        super(flammable, name);
        this.gearType = gearType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.getValue(TekoraBlockStates.GEAR_TYPE) == GearType.NONE) {
            BlockState newState = state.setValue(TekoraBlockStates.GEAR_TYPE, gearType);
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
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
        return super.useOn(context);
    }
}
