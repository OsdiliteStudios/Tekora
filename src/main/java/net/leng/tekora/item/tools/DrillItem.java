package net.leng.tekora.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.leng.tekora.datagen.tags.TekoraTags;
import net.leng.tekora.tiers.TekoraTiers;

public class DrillItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE = TekoraTags.Blocks.MINEABLE_WITH_DRILL;
    public DrillItem(TekoraTiers pTier) {
        super(pTier.getLevel() + 5, pTier.getSpeed(), pTier, MINEABLE,
                new Properties().durability(pTier.getUses()));
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && this.getDamage(pStack) < getTier().getUses()) {
            if (pState.is(MINEABLE)) {
                Direction.Axis axis = pEntityLiving.getDirection().getAxis();
                int range = (this.getTier().getLevel() - 2) / 2;
                for (int i = -range; i <= range; i++) {
                    for (int j = -range; j <= range; j++) {
                        BlockPos pos = switch (axis) {
                            case X -> new BlockPos(pPos.getX(), i, j);
                            case Y -> new BlockPos(i, pPos.getY(), j);
                            case Z -> new BlockPos(i, j, pPos.getZ());
                        };
                        pLevel.destroyBlock(pos, true);
                    }
                }
            }
            return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        }
        return false;
    }
}
