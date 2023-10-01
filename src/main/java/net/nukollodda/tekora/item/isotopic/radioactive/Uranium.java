package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Uranium extends AbstractRadioactiveItem {
    public float[] isotopeRatio = new float[5];
    private float divident;
    public Uranium() {
        super(new Item.Properties());
    }

    public static AbstractRadioactiveItem.Isotopes[] getIsotopeList() {
        return new AbstractRadioactiveItem.Isotopes[]{Isotopes.U238,
                Isotopes.U236, Isotopes.U235, Isotopes.U234, Isotopes.U233};
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("msg.tekora.isoratio"));
        pTooltipComponents.add(Component.literal(textMaker()).withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("msg.tekora.rad"));
        pTooltipComponents.add(Component.literal(AbstractRadioactiveItem.formatRad(getRadiation()))
                .withStyle(AbstractRadioactiveItem.radColor(getRadiation())));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    protected String textMaker() {
        float addedRat = 0;
        for (float val : isotopeRatio) {
            addedRat += val;
        }
        float divident = addedRat > 0 ? addedRat : 100;
        StringBuilder text = new StringBuilder();
        String isoName;
        for (int i = 0; i < 5; i++) {
            isoName = i == 0 ? "U238 - " : "U23" + (7 - i) + " - ";
            text.append(isotopeRatio[i] > 0 ? isoName + (int) (isotopeRatio[0] / divident * 100) + "%\n" : "");
        }
        return text.toString();
    }

    @Override
    public void saveData(CompoundTag pTag) {
        if (pTag != null) {
            pTag.putFloat("U238", isotopeRatio[0]);
            pTag.putFloat("U236", isotopeRatio[1]);
            pTag.putFloat("U235", isotopeRatio[2]);
            pTag.putFloat("U234", isotopeRatio[3]);
            pTag.putFloat("U233", isotopeRatio[4]);
        }
    }

    @Override
    public void readData(CompoundTag pTag) {
        if (pTag == null || pTag.isEmpty()) {
            isotopeRatio = getDefaultIsotopeRatio();
            divident = 100;
        } else {
            isotopeRatio = new float[]{
                    pTag.getFloat("U238"),
                    pTag.getFloat("U236"),
                    pTag.getFloat("U235"),
                    pTag.getFloat("U234"),
                    pTag.getFloat("U233")};
            divident = pTag.getFloat("U238") + pTag.getFloat("U236") +
                    pTag.getFloat("U235") + pTag.getFloat("U234") + pTag.getFloat("U233");
        }
    }

    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        if (stack.getTag() != null) {
            readData(stack.getTag());
            saveData(stack.getTag());
        }
        return super.getShareTag(stack);
    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{99.2f, 0f, 0.7f, 0.1f, 0f};
    }

    @Override
    public double getRadiation() {
        float totalRad = 0;
        for (int i = 0; i < 5; i++) {
            totalRad += (float) (Isotopes.getIsotopeById(i).getRadiationVal() * isotopeRatio[i]);
        }
        return totalRad / divident > 0 ? divident : 100;
    }

    @Override
    public double getFissionRate() {
        float totalRate = 0;
        for (int i = 0; i < 5; i++) {
            totalRate += (float) (Isotopes.getIsotopeById(i).getFissionRate() * isotopeRatio[i]);
        }
        return totalRate / divident > 0 ? divident : 100;
    }

    @Override
    public double getNeutronAbsorptionRate() {
        float totalAbsorbRate = 0;
        for (int i = 0; i < 5; i++) {
            totalAbsorbRate += (float) (Isotopes.getIsotopeById(i).getNeutronAbsorptionRate() * isotopeRatio[i]);
        }
        return totalAbsorbRate /  divident > 0 ? divident : 100;
    }

    @Override
    public float getFissionEnergy() {
        float totalFisEn = 0;
        for (int i = 0; i < 5; i++) {
            totalFisEn += (Isotopes.getIsotopeById(i).getFissionEnergy() * isotopeRatio[i]);
        }
        return totalFisEn / divident > 0 ? divident : 100;
    }

    @Override
    public float getNeutronAbsorptionEnergy() {
        float totalnEn = 0;
        for (int i = 0; i < 5; i++) {
            totalnEn += (Isotopes.getIsotopeById(i).getNeutronAbsorptionEnergy() * isotopeRatio[i]);
        }
        return totalnEn / divident > 0 ? divident : 100;
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
        public double getRadiation() {
            return super.getRadiation() / 9;
        }

        @Override
        public float getFissionEnergy() {
            return super.getFissionEnergy() / 9;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return super.getNeutronAbsorptionEnergy() / 9;
        }
    }

    public static class CompoundDust extends Uranium {
        public CompoundDust(Item[] items) {
        }
    }
}
