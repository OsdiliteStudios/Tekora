package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;

public class Plutonium extends AbstractRadioactiveItem {
    private int[] isotopeRatio;
    public Plutonium() {
        super(new Item.Properties());
    }

    public static AbstractRadioactiveItem.Isotopes[] getIsotopeList() {
        return new AbstractRadioactiveItem.Isotopes[]{Isotopes.PU240,
                Isotopes.PU239, Isotopes.PU238};
    }

    @Override
    public void saveData(CompoundTag pTag) {

    }

    @Override
    public void readData(CompoundTag pTag) {

    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return null;
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

    public static class CompoundDust extends Plutonium {
        public CompoundDust(Item[] items) {
        }
    }
}
