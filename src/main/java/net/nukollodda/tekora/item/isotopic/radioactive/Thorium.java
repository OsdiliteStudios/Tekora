package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.typical.ICompounds;
import net.nukollodda.tekora.item.typical.IonicParts;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Thorium extends AbstractRadioactiveItem {
    public Thorium() {
        super(new Item.Properties().fireResistant());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("msg.tekora.rad"));
        pTooltipComponents.add(Component.literal(AbstractRadioactiveItem.formatRad(getRadiation(pStack)))
                .withStyle(AbstractRadioactiveItem.radColor(getRadiation(pStack))));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return Isotopes.TH232.getRadiationVal();
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return Isotopes.TH232.getFissionRate();
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return Isotopes.TH232.getNeutronAbsorptionRate();
    }

    @Override
    public float getFissionEnergy(ItemStack pStack) {
        return Isotopes.TH232.getFissionEnergy();
    }

    @Override
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        return Isotopes.TH232.getNeutronAbsorptionEnergy();
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        TH232;

        public int getId() {
            return 0;
        }

        @Override
        public double getRadiationVal() {
            return 0.000021;
        }

        @Override
        public double getFissionRate() {
            return 0.01;
        }

        @Override
        public double getNeutronAbsorptionRate() {
            return 0.96;
        }

        @Override
        public float getFissionEnergy() {
            return 20;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return 1942f;
        }

        @Override
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return Uranium.Isotopes.U233;
        }
    }

    public static class Nugget extends Thorium {
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

    public static class CompoundDust extends Thorium implements ICompounds {
        private final String anion;
        public CompoundDust(String pAnion) {
            this.anion = pAnion.toUpperCase();
        }

        @Override
        public IonicParts getCation() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            int catCount = anOxState % 4 == 0 ? 1 : anOxState;
            return new IonicParts(IonicParts.Cations.THORIUM, catCount);
        }

        @Override
        public IonicParts getAnion() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(anion, 4 % anOxState == 0 ? 1 : 4);
        }
    }
}
