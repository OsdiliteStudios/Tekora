package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;
import net.nukollodda.tekora.item.typical.CompoundItem;
import net.nukollodda.tekora.item.typical.Compounds;

public class Protactinium extends AbstractRadioactiveItem {
    private int[] isotopeRatio;
    public Protactinium() {
        super(new Item.Properties());
    }

    public static AbstractRadioactiveItem.Isotopes[] getIsotopeList() {
        return new AbstractRadioactiveItem.Isotopes[]{Isotopes.PA231};
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
        PA231();

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

    public static class CompoundDust extends Protactinium implements Compounds {

        private final Item decayItem;
        private final CompoundItem.Cations cation = CompoundItem.Cations.PROTACTINIUM;
        private final CompoundItem.Anions anion;

        public CompoundDust(Item item, CompoundItem.Anions anions) {
            this.decayItem = item;
            this.anion = anions;
        }

        public Item getDecayItem() {
            return decayItem;
        }

        @Override
        public CompoundItem.Cations getCation() {
            return cation;
        }

        @Override
        public CompoundItem.Anions getAnion() {
            return anion;
        }
    }
}
