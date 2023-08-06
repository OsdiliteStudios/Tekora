package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.isotopic.AbstractIsotopicItem;

public class Neptunium extends AbstractRadioactiveItem {
    private int[] isotopeRatio;
    public Neptunium() {
        super(new Item.Properties());
    }

    public static AbstractRadioactiveItem.Isotopes[] getIsotopeList() {
        return new AbstractRadioactiveItem.Isotopes[]{Isotopes.NP237};
    }

    @Override
    public double getRadiation() {
        return Isotopes.NP237.getRadiationVal();
    }

    @Override
    public double getFissionRate() {
        return Isotopes.NP237.getFissionRate();
    }

    @Override
    public double getNeutronAbsorptionRate() {
        return Isotopes.NP237.getNeutronAbsorptionRate();
    }

    @Override
    public float getFissionEnergy() {
        return Isotopes.NP237.getFissionEnergy();
    }

    @Override
    public float getNeutronAbsorptionEnergy() {
        return Isotopes.NP237.getNeutronAbsorptionEnergy();
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        NP237();

        public int getId() {
            return 0;
        }

        @Override
        public double getRadiationVal() {
            return 3;
        }

        @Override
        public double getFissionRate() {
            return 0.6;
        }

        @Override
        public double getNeutronAbsorptionRate() {
            return 0.01;
        }

        @Override
        public float getFissionEnergy() {
            return 1980.5f;
        }

        @Override
        public float getNeutronAbsorptionEnergy() {
            return 1371f;
        }

        @Override
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return Uranium.Isotopes.U238;
        }
    }

    public static class Nugget extends Neptunium {
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

    public static class CompoundDust extends Neptunium {
        private final Item decayItem;

        public CompoundDust(Item item) {
            this.decayItem = item;
        }

        public Item getDecayItem() {
            return decayItem;
        }
    }
}
