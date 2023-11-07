package net.nukollodda.tekora.item.typical;

import net.minecraft.world.item.Item;

public class CompoundItem extends Item implements ICompounds {
    private final String cation;
    private final String anion;
    private final int cationOxState;
    public CompoundItem(String cations, String anions) {
        this(cations, anions, 0, false);
    }
    public CompoundItem(String cations, String anions, boolean isFireRes) {
        this(cations, anions, 0, isFireRes);
    }
    public CompoundItem(String cations, String anions, int pCatOxState) {
        this(cations, anions, pCatOxState, false);
    }

    public CompoundItem(String cations, String anions, int pCatOxState, boolean isFireRes) {
        super(isFireRes ? new Item.Properties().fireResistant() : new Item.Properties());
        this.cation = cations.toUpperCase();
        this.anion = anions.toUpperCase();
        this.cationOxState = pCatOxState;
    }


    public IonicParts getCation() {
        IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
        IonicParts.Cations cation = IonicParts.Cations.valueOf(this.cation);
        int catOxState = cationOxState != 0 ? cationOxState : cation.getOxidationState();
        int anOxState = Math.abs(anion.getOxidationState());
        return new IonicParts(cation, anOxState % catOxState == 0 ? 1 : anOxState);
    }

    public IonicParts getAnion() {
        IonicParts.Anions anion = IonicParts.Anions.valueOf(this.anion);
        IonicParts.Cations cation = IonicParts.Cations.valueOf(this.cation);
        int anOxState = Math.abs(anion.getOxidationState());
        int catOxState = cationOxState != 0 ? cationOxState : cation.getOxidationState();
        return new IonicParts(anion, catOxState % anOxState == 0 ? 1 : catOxState);
    }
}
