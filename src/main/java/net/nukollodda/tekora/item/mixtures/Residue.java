package net.nukollodda.tekora.item.mixtures;

import net.nukollodda.tekora.item.typical.CompoundItem;

import java.util.Map;

public class Residue extends AbstractMixtures {

    private Map<CompoundItem.Cations, Float> cationsMap;
    private Map<CompoundItem.Anions, Float> anionsMap;

    private float cationDiviser;
    private float anionDiviser;

    public void setAnions(CompoundItem.Anions[] pAnions, float[] pRatio) {
        float diviser = 0;
        Map<CompoundItem.Anions, Float> map = Map.of();
        for (int i = 0; i < pAnions.length; i++) {
            if (i < pRatio.length) map.put(pAnions[i], pRatio[i]);
            diviser += pRatio[i];
        }

        anionDiviser = diviser;
        anionsMap = map;
    }

    public void setCations(CompoundItem.Cations[] pCations, float[] pRatio) {
        float diviser = 0;
        Map<CompoundItem.Cations, Float> map = Map.of();
        for (int i = 0; i < pCations.length; i++) {
            if (i < pRatio.length) map.put(pCations[i], pRatio[i]);
            diviser += pRatio[i];
        }

        cationDiviser = diviser;
        cationsMap = map;
    }

    public Map<CompoundItem.Anions, Float> getAnions() {
        return anionsMap;
    }

    public Map<CompoundItem.Cations, Float> getCations() {
        return cationsMap;
    }

    public float getCationDiviser() {
        return cationDiviser;
    }

    public float getAnionDiviser() {
        return anionDiviser;
    }
}
