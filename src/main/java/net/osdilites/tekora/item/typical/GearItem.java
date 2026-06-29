package net.osdilites.tekora.item.typical;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.mechanical.AbstractTekoraMechanicalMachine;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;

public class GearItem extends TekoraItem {
    private final GearType gearType;

    public GearItem(String name, GearType gearType) {
        super(name);
        this.gearType = gearType;
    }

    public GearItem(String name, GearType gearType, boolean fireRes) {
        super(fireRes, name);
        this.gearType = gearType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            Block block = world.getBlockState(context.getClickedPos()).getBlock();
            if (block instanceof Shaft) {
                // todo, change the block state of the blockstate
            }
        }
        return super.useOn(context);
    }
}
