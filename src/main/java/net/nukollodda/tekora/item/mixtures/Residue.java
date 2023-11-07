package net.nukollodda.tekora.item.mixtures;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.util.UtilFunctions;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Residue extends AbstractMixtures {
    private static final int CSIZE = IonicParts.CATION_SIZE;
    private static final int ASIZE = IonicParts.ANION_SIZE;
    public static final String CATION_KEY = "cations";
    public static final String ANION_KEY = "anions";

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (pStack.getTag() != null) {
            byte[] cationRatio = pStack.getTag().getByteArray(CATION_KEY);
            byte cationDivider = getCationDivider(cationRatio);
            if (cationDivider > 0) {
                pTooltipComponents.add(Component.translatable("ion.tekora.cation").append(":").withStyle(ChatFormatting.RED));
                for (int i = 0; i < CSIZE; i++) {
                    if (cationRatio[i] > 0) {
                        pTooltipComponents.add(Component.literal(IonicParts.ALL_CATIONS[i].getSymbol() + " - " +
                                UtilFunctions.convertToPercentage(cationRatio[i], cationDivider)).withStyle(ChatFormatting.GRAY));
                    }
                }
            }
            byte[] anionRatio = pStack.getTag().getByteArray(ANION_KEY);
            byte anionDivider = getAnionDivider(anionRatio);
            if (anionDivider > 0) {
                pTooltipComponents.add(Component.translatable("ion.tekora.anions").append(":").withStyle(ChatFormatting.GREEN));
                for (int i = 0; i < ASIZE; i++) {
                    if (anionRatio[i] > 0) {
                        pTooltipComponents.add(Component.literal(IonicParts.ALL_ANIONS[i].getSymbol() + " - " +
                                UtilFunctions.convertToPercentage(anionRatio[i], anionDivider)).withStyle(ChatFormatting.GRAY));
                    }
                }
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public ItemStack setIons(ItemStack pItem, byte[] pCations, byte[] pAnions) {
        CompoundTag tag = pItem.getOrCreateTag();
        tag.putByteArray(CATION_KEY, pCations);
        tag.putByteArray(ANION_KEY, pAnions);
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
        if (pItem.getTag() != null) {
            return pItem.getTag().getByteArray(CATION_KEY);
        }
        return new byte[CSIZE];
    }

    public byte getCationDivider(byte[] cations) {
        byte total = 0;
        for (byte ratio : cations) {
            total += ratio;
        }
        return total <= 0 ? 1 : total;
    }

    public byte getAnionDivider(byte[] anions) {
        byte total = 0;
        for (byte ratio : anions) {
            total += ratio;
        }
        return total <= 0 ? 1 : total;
    }
}
