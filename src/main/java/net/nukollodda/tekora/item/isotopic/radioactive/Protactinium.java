package net.nukollodda.tekora.item.isotopic.radioactive;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nukollodda.tekora.item.mixtures.Residue;
import net.nukollodda.tekora.item.typical.IonicParts;
import net.nukollodda.tekora.item.typical.ICompounds;

public class Protactinium extends AbstractRadioactiveItem {
    public Protactinium() {
        super(new Item.Properties());
    }

    @Override
    public double getRadiation(ItemStack pStack) {
        return 21;
    }

    @Override
    public double getFissionRate(ItemStack pStack) {
        return 0;
    }

    @Override
    public double getNeutronAbsorptionRate(ItemStack pStack) {
        return 4913f;
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
        PA231;

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

    public static class CompoundDust extends Protactinium implements ICompounds {

        private final Item decayItem;
        private final String anion;
        private final int oxidationState;

        public CompoundDust(Item decay, String anions) {
            this(decay, anions, 5);
        }

        public CompoundDust(Item decay, String anions, int pOxState) {
            this.decayItem = decay;
            this.anion = anions.toUpperCase();
            this.oxidationState = pOxState == 4 ? pOxState : 5;
        }

        public Item getDecayItem() {
            return decayItem;
        }

        @Override
        public IonicParts getCation() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            int catCount = anOxState % oxidationState == 0 ? 1 : anOxState;
            return new IonicParts(IonicParts.Cations.PROTACTINIUM, catCount);
        }

        @Override
        public IonicParts getAnion() {
            IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
            int anOxState = Math.abs(anion.getOxidationState());
            return new IonicParts(anion, oxidationState % anOxState == 0 ? 1 : oxidationState);
        }
    }
}
