package net.nukollodda.tekora.item.typical;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.nukollodda.tekora.block.fluid.blocks.AbstractTekoraFluidBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TekoraBucketItem extends BucketItem {
    public TekoraBucketItem(Supplier<? extends Fluid> supplier) {
        super(supplier, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Block block = getFluid().defaultFluidState().createLegacyBlock().getBlock();
        if (block instanceof AbstractTekoraFluidBlock fluidBlock) {
            fluidBlock.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
