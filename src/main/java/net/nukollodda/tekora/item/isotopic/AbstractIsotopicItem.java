package net.nukollodda.tekora.item.isotopic;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.Item;
import net.nukollodda.tekora.item.isotopic.radioactive.AbstractRadioactiveItem;

public abstract class AbstractIsotopicItem extends Item {
    protected int[] isotopicRatio;
    public AbstractIsotopicItem(Properties pProperties) {
        super(pProperties);
    }
    public abstract double getFissionRate();
    public abstract double getNeutronAbsorptionRate();
    public abstract float getFissionEnergy();
    public abstract float getNeutronAbsorptionEnergy();

    public abstract float[] getDefaultIsotopeRatio();

    public interface Isotopes {
        int getId();
        double getFissionRate();
        double getNeutronAbsorptionRate();
        float getFissionEnergy();
        float getNeutronAbsorptionEnergy();

        AbstractIsotopicItem.Isotopes getIsotopeById(int id);
    }
}
