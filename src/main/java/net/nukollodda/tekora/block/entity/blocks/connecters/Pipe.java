package net.nukollodda.tekora.block.entity.blocks.connecters;

import net.nukollodda.tekora.block.entity.blocks.models.IrregularModel;

public abstract class Pipe extends IrregularModel {
    public Pipe(float strength) {
        super(strength);
    }
    /* Tekora Pipe list:
     * Glass - all fluids below 800K
     * Steel - noncorrosive fluids below 1300K
     * Bronze - all fluids below 1300K
     * mechanical - dusts
     */
}
