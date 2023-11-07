package net.nukollodda.tekora.item.typical;

public class ElementalItem extends TekoraItem {
    private final String ion;

    public ElementalItem(String pIon, boolean fireRes) {
        super(fireRes);
        this.ion = pIon;
    }

    public ElementalItem(String pIon) {
        super();
        this.ion = pIon;
    }

    public IonicParts.Ions getIon() {
        for (IonicParts.Cations cation : IonicParts.ALL_CATIONS) {
            if (cation.name().toLowerCase().equals(ion)) {
                return cation;
            }
        }
        for (IonicParts.Anions anion : IonicParts.ALL_ANIONS) {
            if (anion.name().toLowerCase().equals(ion)) {
                return anion;
            }
        }
        return null;
    }
}
