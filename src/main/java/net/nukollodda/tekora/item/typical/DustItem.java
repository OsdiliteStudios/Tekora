package net.nukollodda.tekora.item.typical;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.mixtures.Residue;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DustItem extends TekoraItem {
    // used for all possible tekora dusts that aren't involved in major recipes
    // tekora dusts used for special recipes will be added
    // also, a pattern exists with oxidation states
    // num of anions of ox state -1 = cation oxstate
    // num of anions of ox state -2 = cation oxstate / 2 (if cation is odd, double cation and anion cnt)
    // num of anions of ox state -3 = cation oxstate / 3 (if cation isn't threeven, triple cnt)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        IonicParts cation = getCation(pStack);
        IonicParts anion = getAnion(pStack);
        if (cation != null && anion != null) {
            pTooltipComponents.add(Component.literal(cation.toString() + anion.toString()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public IonicParts getCation(ItemStack pStack) {
        if (pStack.getItem() instanceof DustItem && pStack.getTag() != null) {
            CompoundTag tag = pStack.getTag();
            IonicParts.Cations cation = IonicParts.Cations.valueOf(tag.getString(Residue.CATION_KEY));
            IonicParts.Anions anions = IonicParts.Anions.valueOf(tag.getString(Residue.ANION_KEY));
            int anOxState = Math.abs(anions.getOxidationState());
            int catCount = anOxState % cation.getOxidationState() == 0 ? 1 : anOxState;
            return new IonicParts(cation, catCount);
        }
        return null;
    }

    public IonicParts getAnion(ItemStack pStack) {
        if (pStack.getItem() instanceof DustItem && pStack.getTag() != null) {
            CompoundTag tag = pStack.getTag();
            IonicParts.Cations cation = IonicParts.Cations.valueOf(tag.getString(Residue.CATION_KEY));
            IonicParts.Anions anions = IonicParts.Anions.valueOf(tag.getString(Residue.ANION_KEY));
            int anOxState = Math.abs(anions.getOxidationState());
            int catOxState = cation.getOxidationState();
            return new IonicParts(anions, catOxState % anOxState == 0 ? 1 : catOxState);
        }
        return null;
    }

    public void setIons(ItemStack pStack, IonicParts.Cations pCation, IonicParts.Anions pAnions) {
        if (pStack.getItem() instanceof DustItem) {
            CompoundTag tag = pStack.getOrCreateTag();
            tag.putString(Residue.CATION_KEY, pCation.name());
            tag.putString(Residue.ANION_KEY, pAnions.name());
            pStack.setTag(tag);
        }
    }
}
