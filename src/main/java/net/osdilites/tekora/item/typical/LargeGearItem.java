package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import org.jspecify.annotations.NonNull;

public class LargeGearItem extends GearItem
{
    public LargeGearItem(String name, GearType gearType, boolean flammable) {
        super(name, gearType, flammable);
    }

    @Override @NonNull
    public InteractionResult useOn(UseOnContext context)
    {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        // Check if it has is_large property
        if (state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.getValue(TekoraBlockStates.GEAR_TYPE) == GearType.NONE && state.hasProperty(TekoraBlockStates.IS_LARGE)) {
            return placeSuccessful(context, world, pos, state);
        }
        return super.useOn(context);
    }
}
