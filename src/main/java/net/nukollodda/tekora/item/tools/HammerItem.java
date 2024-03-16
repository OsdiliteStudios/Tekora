package net.nukollodda.tekora.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends PickaxeItem implements ITekoraColored {
    private final int color;
    public HammerItem(Tier pTier, boolean pFireRes, int color) {
        super(pTier, 1 , -3.2f, pFireRes ? new Properties().fireResistant() : new Properties());
        this.color = color;
    }
    public HammerItem(Tier pTier, int color) {
        this(pTier, false, color);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack item = new ItemStack(this);
        item.setDamageValue(itemStack.getDamageValue() + 1);
        if (item.getDamageValue() >= item.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return item;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving); // supposed to mine a 3x3 surrounding
    }
}
