package net.leng.tekora.item.isotopic.radioactive;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.leng.tekora.item.typical.RawItem;

public class Neptunium extends AbstractRadioactiveItem {
    public Neptunium() {
        super(false, RawItem.NEPTUNIUM);
    }
    @Override
    public double getRadiation(ItemStack pStack) {
        return Isotopes.NP237.getRadiationVal();
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return Isotopes.NP237.getFissionRate();
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return Isotopes.NP237.getNeutronAbsorptionRate();
    }

    @Override
    public float getFissionEnergy(ItemStack pStack) {
        return Isotopes.NP237.getFissionEnergy();
    }

    @Override
    public float getNeutronAbsorptionEnergy(ItemStack pStack) {
        return Isotopes.NP237.getNeutronAbsorptionEnergy();
    }

    public enum Isotopes implements AbstractRadioactiveItem.Isotopes {
        NP237;

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
