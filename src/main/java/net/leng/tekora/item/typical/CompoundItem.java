package net.leng.tekora.item.typical;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CompoundItem extends TekoraItem implements ICompounds {
    private final String cation;
    private final String anion;
    private final int cationOxState;
    public CompoundItem(String cations, String anions) {
        this(cations, anions, 0, false);
    }
    public CompoundItem(String cations, String anions, boolean isFireRes) {
        this(cations, anions, 0, isFireRes);
    }
    public CompoundItem(String cations, String anions, int pCatOxState) {
        this(cations, anions, pCatOxState, false);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        IonicParts cation = getCation();
        IonicParts anion = getAnion();
        if (cation != null && anion != null) {
            pTooltipComponents.add(Component.literal(cation.toString() + anion.toString()).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public CompoundItem(String cations, String anions, int pCatOxState, boolean isFireRes) {
        super(isFireRes);
        this.cation = cations.toUpperCase();
        this.anion = anions.toUpperCase();
        this.cationOxState = pCatOxState;
    }


    public IonicParts getCation() {
        IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
        IonicParts.Cations cation = IonicParts.Cations.valueOf(this.cation);
        int catOxState = cationOxState != 0 ? cationOxState : cation.getOxidationState();
        int anOxState = Math.abs(anion.getOxidationState());
        return new IonicParts(cation, anOxState > 0 && catOxState % anOxState == 0 ? 1 : anOxState);
    }

    public IonicParts getAnion() {
        IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
        IonicParts.Cations cation = IonicParts.Cations.valueOf(this.cation);
        int anOxState = Math.abs(anion.getOxidationState());
        int catOxState = cationOxState != 0 ? cationOxState : cation.getOxidationState();
        return new IonicParts(anion, anOxState > 0 && catOxState % anOxState == 0 ? catOxState / anOxState : catOxState);
    }
}
