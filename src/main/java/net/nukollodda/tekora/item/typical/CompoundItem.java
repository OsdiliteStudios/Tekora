package net.nukollodda.tekora.item.typical;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CompoundItem extends Item implements Compounds {
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
        LITHIUM(1),
        SODIUM(1),
        POTASSIUM(1),
        RUBIDIUM(1),
        CESIUM(1),
        BERYLLIUM(2),
        MAGNESIUM(2),
        CALCIUM(2),
        STRONTIUM(2),
        BARIUM(2),

        BORON(3),
        ALUMINUM(3),
        GALLIUM(3),
        INDIUM(3),
        THALLIUM(new int[]{1, 3}),
        SILICON(4),
        GERMANIUM(4),
        TIN(4),
        LEAD(4),
        ARSENIC(5),
        ANTIMONY(5),
        BISMUTH(5),
        TELLURIUM(6),

        TITANIUM(new int[]{2, 3, 4}),
        VANADIUM(new int[]{2, 5}),
        CHROMIUM(new int[]{2, 3, 6}),
        MANGANESE(4),
        IRON(new int[]{2, 3, 4}),
        COBALT(new int[]{2, 3}),
        NICKEL(2),
        COPPER(new int[]{1, 2}),
        ZINC(2),
        ZIRCONIUM(new int[]{4}),
        NIOBIUM(new int[]{2, 5}),
        MOLYBDENUM(new int[]{4, 6}),
        RUTHENIUM(new int[]{3, 4}),
        RHODIUM(3),
        PALLADIUM(4),
        SILVER(1),
        CADMIUM(2),
        HAFNIUM(new int[]{4}),
        TANTALUM(new int[]{5}),
        TUNGSTEN(new int[]{4, 6}),
        RHENIUM(new int[]{2, 4, 6, 7}),
        OSMIUM(new int[]{2, 3, 4, 8}),
        IRIDIUM(new int[]{1, 3, 4}),
        PLATINUM(4),
        GOLD(new int[]{1, 3}),
        MERCURY(new int[]{1, 2}),

        SCANDIUM(3),
        YTTRIUM(3),
        LANTHANUM(3),
        CERIUM(new int[]{4}),
        PRASEODYMIUM(3),
        NEODYMIUM(3),
        SAMARIUM(3),
        EUROPIUM(3),
        GADOLINIUM(3),
        TERBIUM(3),
        DYSPROSIUM(3),
        HOLMIUM(3),
        ERBIUM(3),
        THULIUM(3),
        YTTERBIUM(3),
        LUTETIUM(3),

        THORIUM(new int[]{4}),
        PROTACTINIUM(new int[]{4, 5}),
        URANIUM(new int[]{4, 6}),
        NEPTUNIUM(new int[]{4, 6}),
        PLUTONIUM(new int[]{4, 6}),
        AMERICIUM(3),

        AMMONIUM(1);

        final int[] oxidationStates;
        // final Block fluid;

        Cations(int pType) {
            oxidationStates = switch (pType) {
                case 1 -> new int[]{1};
                case 2 -> new int[]{2};
                case 3 -> new int[]{3};
                case 4 -> new int[]{2, 4};
                case 5 -> new int[]{3, 5};
                case 6 -> new int[]{4, 6};
                case 7 -> new int[]{3, 5, 7};
                default -> new int[]{pType};
            };
        }

        Cations(int[] oxStates) {
            oxidationStates = oxStates;
        }

        public int[] getOxidationStates() {
            return oxidationStates;
        }

        /*
        public Block getFluid() {
            return fluid;
        }
         */
    }

    public enum Anions {
        /* Formatting
         * in this 2D array, the first array lists what cations of this particular anion are soluble in water
         * the second array lists for acetone
         * the third for ammonia
         * the fourth for aqua regia
         * the fifth for ethanol
         * the sixth for hydrochloric acid
         * the seventh for prussic acid
         * the eight for sulfuric acid
         */
        FLUORIDE(new Cations[][]{
                new Cations[]{Cations.ALUMINUM, Cations.IRON, Cations.COPPER, Cations.SILVER, Cations.ZINC}}, -1),
        OXIDE(new Cations[][]{
                new Cations[]{Cations.ALUMINUM}}, -2);
        final Block[] solvents = new Block[]{Blocks.WATER};
        final Cations[][] insoluble;
        final int oxidationState;

        Anions(Cations[][] pInsol, int oxState) {
            this.insoluble = pInsol;
            this.oxidationState = oxState;
        }

        public boolean isSoluble(Block pBlock, CompoundItem pCompound) {
            boolean corSolv = false;
            boolean isSoluble = false;
            for (Block solvent : this.solvents) {
                if (pBlock.equals(solvent)) {
                    corSolv = true;
                    break;
                }
            }

            return corSolv;
        }

        public int getOxidationState() {
            return oxidationState;
        }
        // determines the math for auto recipes
    }
}
