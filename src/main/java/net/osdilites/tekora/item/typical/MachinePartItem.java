package net.osdilites.tekora.item.typical;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.osdilites.tekora.block.entities.mechanical.AbstractTekoraMechanicalMachine;
import net.osdilites.tekora.block.entities.mechanical.MixerMechanical;

public class MachinePartItem extends TekoraItem {
    private final MixerMechanical block;

    public MachinePartItem(String name, MixerMechanical block) {
        super(name);
        this.block = block;
    }

    public MachinePartItem(String name, MixerMechanical block, boolean fireRes) {
        super(fireRes, name);
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            Block block = world.getBlockState(context.getClickedPos()).getBlock();
            if (block instanceof AbstractTekoraMechanicalMachine) {
                // todo, replace the block with the field block.
            }
        }
        return super.useOn(context);
    }
}
