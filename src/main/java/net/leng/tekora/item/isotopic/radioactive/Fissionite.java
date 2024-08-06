package net.leng.tekora.item.isotopic.radioactive;

import net.minecraft.world.item.Item;
import net.leng.tekora.item.mixtures.AbstractMixtures;

public class Fissionite extends AbstractMixtures {
    public enum Components {
        ;
        private final int id;
        private final int radiationValue;
        private final int halfLife;
        private final Item decayItem;

        Components(int id, int radVal, int hLife, Item pDecayItem) {
            this.id = id;
            this.radiationValue = radVal;
            this.halfLife = hLife;
            this.decayItem = pDecayItem;
        }

        public int getId() {
            return id;
        }

        public int getRadiationValue() {
            return radiationValue;
        }

        public int getHalfLife() {
            return halfLife;
        }

        public Item getDecayItem() {
            return decayItem;
        }
    }
}
