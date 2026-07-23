package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.osdilites.tekora.block.TekoraBlocks;
import net.osdilites.tekora.block.entities.mechanical.AbstractModularMachine;

public class MachinePartItem extends TekoraItem {
    private final AbstractModularMachine block;

    public MachinePartItem(String name, AbstractModularMachine block) {
        super(name);
        this.block = block;
    }

    public MachinePartItem(String name, AbstractModularMachine block, boolean fireRes) {
        super(fireRes, name);
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            Block block = world.getBlockState(pos).getBlock();
            if (block.equals(TekoraBlocks.MECH_TOP.get())) {
                BlockState state = this.block.defaultBlockState();
                world.setBlock(pos, state, 3);
            }
        }
        return super.useOn(context);
    }
}
