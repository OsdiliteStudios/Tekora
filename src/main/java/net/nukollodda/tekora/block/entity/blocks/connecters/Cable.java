package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.nukollodda.tekora.block.entity.blocks.models.IrregularModel;

public abstract class Cable extends IrregularModel {
    public Cable(float strength) {
        super(strength);
    }

    /* Tekora wire list:
     * Copper - electricity
     * Bronze & Diamond - heat
     * Silver - heat & electricity
     * NiobiumTin - electromagnetism
     */
}
