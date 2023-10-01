package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.item.typical.ICompounds;

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

    public static class CompoundDust extends Protactinium implements ICompounds {

        private final Item decayItem;
        private final String anion;

        public CompoundDust(Item decay, String anions) {
            this.decayItem = decay;
            this.anion = anions;
        }

        public Item getDecayItem() {
            return decayItem;
        }

        @Override
        public IonicParts.Cations getCation() {
            return IonicParts.Cations.PROTACTINIUM;
        }

        @Override
        public IonicParts.Anions getAnion() {
            for (IonicParts.Anions anion : IonicParts.Anions.values()) {
                if (anion.getSymbol().equals(this.anion)) {
                    return anion;
                }
            }
            return null;
        }
    }
}
