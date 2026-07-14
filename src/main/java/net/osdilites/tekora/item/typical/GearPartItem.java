package net.osdilites.tekora.item.typical;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.osdilites.tekora.block.TekoraBlockStates;
import net.osdilites.tekora.block.entities.transporter.rotational.GearType;
import net.osdilites.tekora.block.entities.transporter.rotational.Shaft;

public class GearPartItem extends TekoraItem {
    private final GearType gearType;

    public GearPartItem(String name, GearType gearType, boolean flammable) {
        super(flammable, name);
        this.gearType = gearType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            ItemStack handItem = context.getItemInHand();
            if (block instanceof Shaft && state.hasProperty(TekoraBlockStates.GEAR_TYPE) && state.hasProperty(TekoraBlockStates.IS_LARGE) && handItem.getCount() >= 4) {
                GearType blockType = state.getValue(TekoraBlockStates.GEAR_TYPE);
                if (blockType == this.gearType && !state.getValue(TekoraBlockStates.IS_LARGE) && state.hasProperty(BlockStateProperties.AXIS)) {
                    BlockState check1, check2, check3, check4;
                    int x = pos.getX();
                    int y = pos.getY();
                    int z = pos.getZ();
                    switch (state.getValue(Shaft.AXIS)) {
                        case X -> {
                            check1 = world.getBlockState(new BlockPos(x, y + 1, z));
                            check2 = world.getBlockState(new BlockPos(x, y - 1, z));
                            check3 = world.getBlockState(new BlockPos(x, y, z + 1));
                            check4 = world.getBlockState(new BlockPos(x, y, z - 1));
                        }
                        case Z -> {
                            check1 = world.getBlockState(new BlockPos(x, y + 1, z));
                            check2 = world.getBlockState(new BlockPos(x, y - 1, z));
                            check3 = world.getBlockState(new BlockPos(x + 1, y, z));
                            check4 = world.getBlockState(new BlockPos(x - 1, y, z));
                        }
                        default -> {
                            check1 = world.getBlockState(new BlockPos(x, y, z + 1));
                            check2 = world.getBlockState(new BlockPos(x, y, z - 1));
                            check3 = world.getBlockState(new BlockPos(x + 1, y, z));
                            check4 = world.getBlockState(new BlockPos(x - 1, y, z));
                        }
                    }
                    if (!(check1.hasProperty(Shaft.IS_LARGE) && check1.getValue(Shaft.IS_LARGE))
                            && !(check2.hasProperty(Shaft.IS_LARGE) && check2.getValue(Shaft.IS_LARGE))
                            && !(check3.hasProperty(Shaft.IS_LARGE) && check3.getValue(Shaft.IS_LARGE))
                            && !(check4.hasProperty(Shaft.IS_LARGE) && check4.getValue(Shaft.IS_LARGE))) {
                        world.setBlock(pos, state.setValue(Shaft.GEAR_TYPE, gearType).setValue(Shaft.IS_LARGE, true), 3);
                        handItem.shrink(4);
                    }
                } else {
                    world.setBlock(pos, state.setValue(Shaft.GEAR_TYPE, gearType), 3);
                    handItem.shrink(4);
                }
            }
        }
        return super.useOn(context);
    }
}
