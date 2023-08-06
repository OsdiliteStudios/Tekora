package net.nukollodda.tekora.item.isotopic;

import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.TekoraItems;

public class Lithium extends AbstractIsotopicItem {
    public Lithium() {
        super(new Item.Properties());
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

    @Override
    public float[] getDefaultIsotopeRatio() {
        return new float[]{95.1f, 4.9f};
    }

    public Item getPostAbsorptionIsotopes() {
        return TekoraItems.BERYLLIUM_DUST.get();
    }

    public enum Isotopes implements AbstractIsotopicItem.Isotopes {
        LI7(0, 0.09, 0.3, 0f, 0f),
        LI6(1, 0.95, 0.01, 51.4f, 0f);

        private final int id;
        private final double fissionRate;
        private final double neutronAbsorptionRate;
        private final float fissionEnergy;
        private final float neutronAbsorptionEnergy;
        Isotopes(int id, double fisRate, double nAbsorpRate, float fisEn, float nAbsorpEn) {
            this.id = id;
            this.fissionRate = fisRate;
            this.neutronAbsorptionRate = nAbsorpRate;
            this.fissionEnergy = fisEn;
            this.neutronAbsorptionEnergy = nAbsorpEn;
        }

        @Override
        public int getId() {
            return id;
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

        public static AbstractIsotopicItem.Isotopes getIsotopeById(int id) {
            return id == 1 ? LI6 : LI7;
        }
    }

    public static class CompoundDust extends Lithium {
        private final Item postAbsorptionIsotope;

        public CompoundDust(Item item) {
            this.postAbsorptionIsotope = item;
        }

        public Item getPostAbsorptionIsotope() {
            return postAbsorptionIsotope;
        }
    }
}
