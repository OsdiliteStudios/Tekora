package net.nukollodda.tekora.item.containers;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.tekora.block.fluids.AbstractTekoraFluidBlock;
import net.nukollodda.tekora.fluid.TekoraChemicalFluidType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Canister extends Item implements DispensibleContainerItem {
    private final int maxTemperature;
    private final int corrosionResistance;
    public Canister(int pMaxTemperature, int pCorrosionRes) {
        super(new Item.Properties().stacksTo(1));
        this.maxTemperature = pMaxTemperature;
        this.corrosionResistance = pCorrosionRes;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        // allow fluids to be placed or picked up, will be implemented
        ItemStack itemInHand = pPlayer.getItemInHand(pUsedHand);
        CompoundTag tag = itemInHand.getOrCreateTag();
        Fluid fluidInCan = getFluid(itemInHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, fluidInCan.equals(Fluids.EMPTY) ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
        InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onBucketUse(pPlayer, pLevel, itemInHand, blockhitresult);
        if (ret != null) return ret;
        if (blockhitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemInHand);
        } else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemInHand);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (fluidInCan.equals(Fluids.EMPTY) && pLevel.getBlockState(blockpos).getBlock() instanceof LiquidBlock liquid  &&
                    liquid.getFluid().getFluidType().getTemperature() < this.maxTemperature &&
                    !(liquid.getFluid().getFluidType() instanceof TekoraChemicalFluidType tekoraChemical &&
                            (tekoraChemical.isMetallic() || tekoraChemical.getMeltingPoint() >= this.maxTemperature ||
                                    tekoraChemical.getReactivity() >= this.corrosionResistance))) {
                pLevel.removeBlock(blockpos, false);
                tag.putString("fluid_in", liquid.getDescriptionId());
                itemInHand.setTag(tag);
            } else if (pLevel.getBlockState(blockpos).getBlock() instanceof AirBlock && !fluidInCan.equals(Fluids.EMPTY)) {
                pLevel.setBlock(blockpos, fluidInCan.defaultFluidState().createLegacyBlock(), 3);
                tag.putString("fluid_in", Fluids.EMPTY.getFluidType().getDescriptionId());
                itemInHand.setTag(tag);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Fluid fluidInCan = getFluid(pStack);
        if (!fluidInCan.equals(Fluids.EMPTY)) {
            pTooltipComponents.add(Component.translatable(fluidInCan.getFluidType().getDescriptionId()));
            if (fluidInCan.defaultFluidState().createLegacyBlock().getBlock() instanceof AbstractTekoraFluidBlock tekoraFluid) {
                tekoraFluid.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult hitResult, @Nullable ItemStack container) {
        return DispensibleContainerItem.super.emptyContents(player, level, pos, hitResult, container);
    }

    @Override
    public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult) {
        return false; // do NOT use
    }

    public Fluid getFluid(ItemStack pStack) {
        CompoundTag tag = pStack.getOrCreateTag();
        Fluid fluidIncan = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(tag.getString("fluid_in")));
        return fluidIncan == null ? Fluids.EMPTY : fluidIncan;
    }
}
