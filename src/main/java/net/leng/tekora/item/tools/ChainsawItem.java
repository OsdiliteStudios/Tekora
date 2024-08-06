package net.leng.tekora.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.leng.tekora.tiers.TekoraTiers;

public class ChainsawItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE = BlockTags.MINEABLE_WITH_AXE;
    public ChainsawItem(TekoraTiers pTier) {
        super(pTier.getLevel() + 7, pTier.getSpeed(), pTier, MINEABLE, new Properties());
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && getDamage(pStack) < getTier().getUses()) {
            if (pState.is(MINEABLE)) {
                BlockPos pos = pPos.above();
                BlockState state = pLevel.getBlockState(pos);
                while (state.getBlock() instanceof RotatedPillarBlock && state.is(MINEABLE)) {
                    pLevel.destroyBlock(pos, true);
                    pos = pos.above();
                    state = pLevel.getBlockState(pos);

                }
            }
            return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        }
        return false;
    }
}
