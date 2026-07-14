package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.entities.mechanical.AbstractTekoraMechanicalMachine;

public class MachinePartItem extends TekoraItem {
    private final AbstractTekoraMechanicalMachine block;

    public MachinePartItem(String name, AbstractTekoraMechanicalMachine block) {
        super(name);
        this.block = block;
    }

    public MachinePartItem(String name, AbstractTekoraMechanicalMachine block, boolean fireRes) {
        super(fireRes, name);
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            Block block = world.getBlockState(pos).getBlock();
            if (block instanceof AbstractTekoraMechanicalMachine) {
                BlockState state = block.defaultBlockState();
                world.setBlock(pos, state, 3);
            }
        }
        return super.useOn(context);
    }
}
