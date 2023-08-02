package net.nukollodda.tekora.item.typical;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidType;

public class CompoundItem extends Item {
    private final Cations cation;
    private final Anions anion;

    public CompoundItem(Cations cations, Anions anions, boolean isFireRes) {
        super(isFireRes ? new Item.Properties().fireResistant() : new Item.Properties());
        this.cation = cations;
        this.anion = anions;
    }

    public CompoundItem(Cations cations, Anions anions) {
        this(cations, anions, false);
    }

    public CompoundItem(Cations cations) {
        this(cations, Anions.OXIDE);
    }

    public Cations getCation() {
        return cation;
    }

    public Anions getAnion() {
        return anion;
    }

    public enum Cations {
        ALUMINUM();
    }

    public enum Anions {
        OXIDE(new Cations[][]{
                new Cations[]{Cations.ALUMINUM}});
        final Block[] solvents = new Block[]{Blocks.WATER};
        final Cations[][] insoluble;

        Anions(Cations[][] pInsol) {
            this.insoluble = pInsol;
        }

        public boolean isSoluble(FluidType pFluid, CompoundItem pCompound) {
            boolean corSolv = false;
            boolean isSoluble = false;
            for (Block solvent : this.solvents) {
                if (pFluid.equals(solvent)) {
                    corSolv = true;
                    break;
                }
            }

            return corSolv;
        }
    }
}
