package net.leng.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.leng.tekora.item.typical.IonicParts;
import net.leng.tekora.item.typical.ICompounds;
import net.leng.tekora.item.typical.RawItem;
import net.leng.tekora.util.DustUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Protactinium extends AbstractRadioactiveItem {
    public Protactinium() {
        super(false, RawItem.PROTACTINIUM);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("msg.tekora.rad"));
        pTooltipComponents.add(AbstractRadioactiveItem.radComponent(getRadiation(pStack)));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return 21;
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return 0;
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return 4913f;
    }

    @Override
    public float getFissionEnergy(ItemStack pStack) {
        return 0;
    }

    @Override
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        return 0;
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        PA231;

        public int getId() {
            return 0;
        }

        @Override
        public double getRadiationVal() {
            return 21;
        }

        @Override
        public double getFissionRate() {
            return 0;
        }

        @Override
        public double getNeutronAbsorptionRate() {
            return 0;
        }

        @Override
        public float getFissionEnergy() {
            return 0;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return 4913f;
        }

        @Override
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return Thorium.Isotopes.TH232;
        }
    }

    public static class Nugget extends Protactinium {
        @Override
        public double getRadiation(ItemStack pStack) {
            return super.getRadiation(pStack) / 9;
        }

        @Override
        public float getFissionEnergy(ItemStack pStack) {
            return super.getFissionEnergy(pStack) / 9;
        }

        @Override
        public float getNeutronAbsorptionEnergy(ItemStack pStack) {
            return super.getNeutronAbsorptionEnergy(pStack) / 9;
        }
    }

    public static class CompoundDust extends Protactinium implements ICompounds {
        private final String anion;
        private final int oxidationState;

        public CompoundDust(String anions) {
            this(anions, 5);
        }

        public CompoundDust(String anions, int pOxState) {
            this.anion = anions.toUpperCase();
            this.oxidationState = pOxState == 4 ? pOxState : 5;
        }

        public ItemStack getDecayItem() {
            return DustUtil.createDustFromIons(IonicParts.Cations.THORIUM.ordinal(), IonicParts.Anions.valueOf(anion).ordinal());
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

        @Override
        public IonicParts getCation() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(IonicParts.Cations.PROTACTINIUM, anOxState > 0 && oxidationState % anOxState == 0 ? 1 : anOxState);
        }

        @Override
        public IonicParts getAnion() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(anion, anOxState > 0 && oxidationState % anOxState == 0 ? oxidationState / anOxState : oxidationState);
        }
    }
}
