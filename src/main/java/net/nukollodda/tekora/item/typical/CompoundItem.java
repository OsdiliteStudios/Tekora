package net.nukollodda.tekora.item.typical;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CompoundItem extends Item implements ICompounds {
    private final IonicParts.Cations cation;
    private final IonicParts.Anions anion;

    public CompoundItem(IonicParts.Cations cations) {
        this(cations, IonicParts.Anions.OXIDE, false);
    }
    public CompoundItem(IonicParts.Cations cations, IonicParts.Anions anions) {
        this(cations, anions, false);
    }

    public CompoundItem(IonicParts.Cations cations, IonicParts.Anions anions, boolean isFireRes) {
        super(isFireRes ? new Item.Properties().fireResistant() : new Item.Properties());
        this.cation = cations;
        this.anion = anions;
    }


    public IonicParts.Cations getCation() {
        return cation;
    }

    public IonicParts.Anions getAnion() {
        return anion;
    }
}
