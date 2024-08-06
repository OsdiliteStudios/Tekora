package net.tekoramods.tekora.item.isotopic;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.tekoramods.tekora.item.TekoraItems;
import net.tekoramods.tekora.item.typical.RawItem;

import java.util.List;

public class Lithium extends AbstractIsotopicItem {
    public Lithium() {
        super(false, RawItem.LITHIUM);
    }

    protected void textMaker(ItemStack pStack, List<Component> pTooltipComponents) {
        float addedRat = 0;
        float[] ratio = getIsotopicRatio(pStack);
        for (float val : ratio) {
            addedRat += val;
        }
        float dividend = addedRat > 0 ? addedRat : 100;
        String isoName;
        for (int i = 0; i < 5; i++) {
            if (ratio[i] > 0) {
                isoName = "Li" + (i + 6) + " - ";
                String formatted = isoName + ((int)((ratio[i] / dividend) * 1000)) / 100 + "%";
                pTooltipComponents.add(Component.literal(formatted)
                        .withStyle(ChatFormatting.GRAY));
            }
        }
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
