package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Americium extends AbstractRadioactiveItem {

    public Americium() {
        super(new Item.Properties());
    }

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{100};
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return 0;
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return 0;
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return 0;
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
        AM241(0, 2000, 0, 0, 0, 0, Plutonium.Isotopes.PU238);

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
        };

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
        public AbstractRadioactiveItem.Isotopes getPostAbsorptionIsotope() {
            return postAbsorptionIsotope;
        }
    }

    public static class Nugget extends Americium {
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

    public static class CompoundDust extends Americium {
        private final Item decayItem;

        public CompoundDust(Item item) {
            this.decayItem = item;
        }

        public Item getDecayItem() {
            return decayItem;
        }
    }
}
