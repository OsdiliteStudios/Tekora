package net.leng.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.leng.tekora.item.typical.RawItem;

import java.util.List;

public class Plutonium extends AbstractRadioactiveItem {
    public Plutonium() {
        super(false, RawItem.PLUTONIUM);
    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return null;
    }

    protected void textMaker(ItemStack pStack, List<Component> pTooltipComponents) {
        float addedRat = 0;
        float[] ratio = getIsotopicRatio(pStack);
        for (float val : ratio) {
            addedRat += val;
        }
        float dividend = addedRat > 0 ? addedRat : 100;
        String isoName;
        for (int i = 0; i < 5; i++) {
            if (ratio[i] > 0) {
                isoName = i < 2 ? "Pu23" + (i + 9) + " - " : "Pu24" + ((i - 2) * 2) + " - ";
                String formatted = isoName + ((int)((ratio[i] / dividend) * 1000)) / 100 + "%";
                pTooltipComponents.add(Component.literal(formatted)
                        .withStyle(ChatFormatting.GRAY));
            }
        }
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        float[] isotopes = getIsotopicRatio(pStack);
        Isotopes[] values = Isotopes.values();
        float total = 0;
        float divider = 0;
        for (int i = 0; i < isotopes.length; i++) {
            total += values[i].radiationVal * isotopes[i];
            divider += isotopes[i];
        }
        return total / divider;
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        float[] isotopes = getIsotopicRatio(pStack);
        Isotopes[] values = Isotopes.values();
        float total = 0;
        float divider = 0;
        for (int i = 0; i < isotopes.length; i++) {
            total += values[i].fissionRate * isotopes[i];
            divider += isotopes[i];
        }
        return total / divider;
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        float[] isotopes = getIsotopicRatio(pStack);
        Isotopes[] values = Isotopes.values();
        float total = 0;
        float divider = 0;
        for (int i = 0; i < isotopes.length; i++) {
            total += values[i].neutronAbsorptionRate * isotopes[i];
            divider += isotopes[i];
        }
        return total / divider;
    }

    @Override
    public float getFissionEnergy(ItemStack pStack) {
        float[] isotopes = getIsotopicRatio(pStack);
        Isotopes[] values = Isotopes.values();
        float total = 0;
        float divider = 0;
        for (int i = 0; i < isotopes.length; i++) {
            total += values[i].fissionEnergy * isotopes[i];
            divider += isotopes[i];
        }
        return total / divider;
    }

    @Override
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        float[] isotopes = getIsotopicRatio(pStack);
        Isotopes[] values = Isotopes.values();
        float total = 0;
        float divider = 0;
        for (int i = 0; i < isotopes.length; i++) {
            total += values[i].neutronAbsorptionEnergy * isotopes[i];
            divider += isotopes[i];
        }
        return total / divider;
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        PU240(0, 108, 0.01, 0.08, 20f, 971f, Americium.Isotopes.AM241),
        PU239(1, 292, 0.62, 0.01, 2168.9f, 0, PU240),
        PU238(2, 8000, 0.5, 0.01, 1000f, 0, PU239);

        private final int id;
        private final double radiationVal;
        private final double fissionRate;
        private final double neutronAbsorptionRate;
        private final float fissionEnergy;
        private final float neutronAbsorptionEnergy;
        private final AbstractRadioactiveItem.Isotopes postAbsorptionIsotope;

        private static final AbstractRadioactiveItem.Isotopes[] isotopes = {PU240, PU239, PU238};
        Isotopes(int id, double radVal, double fisRate, double nAbsorpRate, float fissEn, float nAbsorpEn,
                 AbstractRadioactiveItem.Isotopes postAbsorpItem) {
            this.id = id;
            this.radiationVal = radVal;
            this.fissionRate = fisRate;
            this.neutronAbsorptionRate = nAbsorpRate;
            this.fissionEnergy = fissEn;
            this.neutronAbsorptionEnergy = nAbsorpEn;
            this.postAbsorptionIsotope = postAbsorpItem;
        }

        public int getId() {
            return id;
        }

        public double getRadiationVal() {
            return radiationVal;
        }

        public double getFissionRate() {
            return fissionRate;
        }

        public double getNeutronAbsorptionRate() {
            return neutronAbsorptionRate;
        }

        public float getFissionEnergy() {
            return fissionEnergy;
        }

        public float getNeutronAbsorptionEnergy() {
            return neutronAbsorptionEnergy;
        }

        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return postAbsorptionIsotope;
        }

        public static AbstractRadioactiveItem.Isotopes getIsotopeById(int id) {
            return switch (id) {
                case 0 -> PU240;
                case 2 -> PU238;
                default -> PU239;
            };
        }
    }

    public static class Nugget extends Plutonium {
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

    public static class CompoundDust extends Plutonium {
        public CompoundDust(Item[] items) {
        }
    }
}
