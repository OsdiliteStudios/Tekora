package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.typical.ICompounds;
import net.nukollodda.tekora.item.typical.IonicParts;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Uranium extends AbstractRadioactiveItem {
    public Uranium() {
        super(new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("msg.tekora.isoratio"));
        textMaker(pStack, pTooltipComponents);
        pTooltipComponents.add(Component.translatable("msg.tekora.rad"));
        pTooltipComponents.add(Component.literal(AbstractRadioactiveItem.formatRad(getRadiation(pStack)))
                .withStyle(AbstractRadioactiveItem.radColor(getRadiation(pStack))));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
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
                isoName = i == 0 ? "U238 - " : "U23" + (7 - i) + " - ";
                String formatted = isoName + ((int)((ratio[i] / dividend) * 1000)) / 10f + "%";
                pTooltipComponents.add(Component.literal(formatted)
                        .withStyle(ChatFormatting.GRAY));
            }
        }
    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{99.2f, 0f, 0.7f, 0.1f, 0f};
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        float[] ratio = getIsotopicRatio(pStack);
        float totalRad = 0;
        float divider = 0;
        for (int i = 0; i < 5; i++) {
            totalRad += (float) (Isotopes.getIsotopeById(i).getRadiationVal() * ratio[i]);
            divider += ratio[i];
        }
        return totalRad / divider > 0 ? divider : 1;
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
        return total / divider > 0 ? divider : 1;
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
        return total / divider > 0 ? divider : 1;
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
        return total / divider > 0 ? divider : 1;
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
        return total / divider > 0 ? divider : 1;
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        U238(0, 0.000157, 0.01, 0.95, 20f, 1942f, Plutonium.Isotopes.PU239),
        U236(1, 0.03, 0, 0, 0f, 971f, Neptunium.Isotopes.NP237),
        U235(2, 0.001, 0.96, 0.01, 2166.6f, 0f, U236),
        U234(3, 6, 0.1, 0.93, 200f, 0f, U235),
        U233(4, 29, 0.94, 0.01, 2145.2f, 0f, U234);
        private final int id;
        private final double radiationVal;
        private final double fissionRate;
        private final double neutronAbsorptionRate;
        private final float fissionEnergy;
        private final float neutronAbsorptionEnergy;
        private final AbstractRadioactiveItem.Isotopes postAbsorptionIsotope;

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

        @Override
        public double getRadiationVal() {
            return radiationVal;
        }

        @Override
        public double getFissionRate() {
            return fissionRate;
        }

        @Override
        public double getNeutronAbsorptionRate() {
            return neutronAbsorptionRate;
        }

        @Override
        public float getFissionEnergy() {
            return fissionEnergy;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return neutronAbsorptionEnergy;
        }

        public static AbstractRadioactiveItem.Isotopes getIsotopeById(int id) {
            return switch (id) {
                case 1 -> U236;
                case 2 -> U235;
                case 3 -> U234;
                case 4 -> U233;
                default -> U238;
            };
        }

        @Override
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return postAbsorptionIsotope;
        }
    }

    public static class Nugget extends Uranium {
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

    public static class CompoundDust extends Uranium implements ICompounds {
        private final String anion;
        private final int oxidationState;
        public CompoundDust(String pAnion) {
            this(pAnion, 4);
        }
        public CompoundDust(String pAnion, int pOxState) {
            this.anion = pAnion.toUpperCase();
            this.oxidationState = pOxState == 6 ? pOxState : 4;
        }

        @Override
        public IonicParts getCation() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            int catCount = anOxState % oxidationState == 0 ? 1 : anOxState;
            return new IonicParts(IonicParts.Cations.PROTACTINIUM, catCount);
        }

        @Override
        public IonicParts getAnion() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(anion, oxidationState % anOxState == 0 ? 1 : oxidationState);
        }
    }
}
