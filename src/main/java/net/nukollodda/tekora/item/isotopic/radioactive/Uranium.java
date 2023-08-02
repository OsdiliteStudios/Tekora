package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Uranium extends AbstractRadioactiveItem {
    private int[] isotopeRatio;
    public Uranium() {
        super(new Item.Properties());
    }

    public static AbstractRadioactiveItem.Isotopes[] getIsotopeList() {
        return new AbstractRadioactiveItem.Isotopes[]{Isotopes.U238,
                Isotopes.U236, Isotopes.U235, Isotopes.U234, Isotopes.U233};
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void saveData(CompoundTag pTag) {

    }

    @Override
    public void readData() {

    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{99.2f, 0f, 0.7f, 0.1f, 0f};
    }

    private int[] itemRatio = new int[5];

    public void setItemRatio(int[] ratio) {
        this.itemRatio = ratio;
    }

    @Override
    public double getRadiation() {
        return 0;
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
        return 0;
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        U238(0, 0.000000000157, 0.01, 0.95, 20f, 1942f, Plutonium.Isotopes.PU239),
        U236(1, 0.00000003, 0, 0, 0f, 971f, Neptunium.Isotopes.NP237),
        U235(2, 0.000000001, 0.96, 0.01, 2166.6f, 0f, U236),
        U234(3, 0.000006, 0.1, 0.93, 200f, 0f, U235),
        U233(4, 0.000029, 0.94, 0.01, 2145.2f, 0f, U234);
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

        @Override
        public AbstractIsotopicItem.Isotopes getIsotopeById(int id) {
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
