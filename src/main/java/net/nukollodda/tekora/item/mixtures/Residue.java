package net.nukollodda.tekora.item.mixtures;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.util.TekoraUtilFunctions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Residue extends AbstractMixtures {
    private static final int CSIZE = IonicParts.CATION_SIZE;
    private static final int ASIZE = IonicParts.ANION_SIZE;
    private static final String CATION_KEY = "residue.cations.";
    private static final String ANION_KEY = "residue.anions.";

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        byte[] cationRatio = getCationRatio(pStack);
        pTooltipComponents.add(Component.translatable("ion.tekora.cation").append(":").withStyle(ChatFormatting.RED));
        byte cationDivider = getCationDivider(pStack);
        if (cationDivider > 0) {
            for (int i = 0; i < CSIZE; i++) {
                if (cationRatio[i] > 0) {
                    pTooltipComponents.add(Component.literal(IonicParts.ALL_CATIONS[i].getSymbol() + " - " +
                            TekoraUtilFunctions.convertToPercentage(cationRatio[i], cationDivider)).withStyle(ChatFormatting.GRAY));
                }
            }
        }
        byte[] anionRatio = getAnionRatio(pStack);
        pTooltipComponents.add(Component.translatable("ion.tekora.anions").append(":").withStyle(ChatFormatting.GREEN));
        byte anionDivider = getAnionDivider(pStack);
        if (anionDivider > 0) {
            for (int i = 0; i < ASIZE; i++) {
                if (anionRatio[i] > 0) {
                    pTooltipComponents.add(Component.literal(IonicParts.ALL_ANIONS[i].getSymbol() + " - " +
                            TekoraUtilFunctions.convertToPercentage(anionRatio[i], anionDivider)).withStyle(ChatFormatting.GRAY));
                }
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private CompoundTag setAnions(CompoundTag pTag, byte[] pRatio) {
        for (int i = 0; i < ASIZE; i++) {
            pTag.putByte(ANION_KEY + IonicParts.ALL_ANIONS[i].name().toLowerCase(), pRatio[i]);
        }
        return pTag;
    }

    private CompoundTag setCations(CompoundTag pTag, byte[] pRatio) {
        for (int i = 0; i < CSIZE; i++) {
            pTag.putByte(CATION_KEY + IonicParts.ALL_CATIONS[i].name().toLowerCase(), pRatio[i]);
        }
        return pTag;
    }

    private CompoundTag setIons(CompoundTag pTag, byte[] pCations, byte[] pAnions) {
        setCations(pTag, pCations);
        setAnions(pTag, pAnions);
        return pTag;
    }

    public ItemStack setIons(ItemStack pItem, byte[] pCations, byte[] pAnions) {
        pItem.setTag(setIons(pItem.getTag(), pCations, pAnions));
        return pItem;
    }

    public byte[] getAnionRatio(ItemStack pItem) {
        byte[] anions = new byte[ASIZE];
        for (int i = 0; i < ASIZE; i++) {
            if (pItem.getTag() != null) {
                anions[i] = pItem.getTag()
                        .getByte(ANION_KEY + IonicParts.ALL_ANIONS[i].name().toLowerCase());
            }
        }
        return anions;
    }

    public byte[] getCationRatio(ItemStack pItem) {
        byte[] cations = new byte[CSIZE];
        for (int i = 0; i < CSIZE; i++) {
            if (pItem.getTag() != null) {
                cations[i] = pItem.getTag()
                        .getByte(CATION_KEY + IonicParts.ALL_CATIONS[i].name().toLowerCase());
            }
        }
        return cations;
    }

    @Override
    public @Nullable CompoundTag getShareTag(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (stack.getItem() instanceof Residue && stack.hasTag()) {
            setIons(tag, getCationRatio(stack), getAnionRatio(stack));
        }
        return tag;
    }

    public ItemStack mergeCations(ItemStack pOriginal, byte[] pCations) {
        byte[] cations = new byte[CSIZE];
        for (int i = 0; i < CSIZE; i++) {
            cations[i] = (byte) (getCationRatio(pOriginal)[i] + pCations[i]);
        }
        pOriginal.setTag(setCations(pOriginal.getTag(), cations));
        return pOriginal;
    }

    public ItemStack mergeAnions(ItemStack pOriginal, byte[] pAnions) {
        byte[] anions = new byte[ASIZE];
        for (int i = 0; i < ASIZE; i++) {
            anions[i] = (byte) (getAnionRatio(pOriginal)[i] + pAnions[i]);
        }
        pOriginal.setTag(setAnions(pOriginal.getTag(), anions));
        return pOriginal;
    }

    public ItemStack mergeIons(ItemStack pItem, byte[] pCations, byte[] pAnions) {
        pItem = mergeCations(pItem, pCations);
        pItem = mergeAnions(pItem, pAnions);
        return pItem;
    }

    public byte getCationDivider(ItemStack pItem) {
        byte total = 0;
        byte[] cationRatio = getCationRatio(pItem);
        for (byte ratio : cationRatio) {
            total += ratio;
        }
        return total <= 0 ? 1 : total;
    }

    public byte getAnionDivider(ItemStack pItem) {
        byte total = 0;
        byte[] anionRatio = getAnionRatio(pItem);
        for (byte ratio : anionRatio) {
            total += ratio;
        }
        return total <= 0 ? 1 : total;
    }
}
