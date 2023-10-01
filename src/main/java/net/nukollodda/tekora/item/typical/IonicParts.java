package net.nukollodda.tekora.item.typical;

public class IonicParts {
    private static final Cations[] LIGHT_ALKALI = new Cations[] {Cations.LITHIUM, Cations.SODIUM, Cations.POTASSIUM};
    private static final Cations[] LIGHT_ALKALINE = new Cations[] {Cations.MAGNESIUM, Cations.CALCIUM};
    private static final Cations[] GROUP3 = new Cations[] {Cations.SCANDIUM, Cations.YTTRIUM};
    private static final Cations[] GROUP4 = new Cations[] {Cations.TITANIUM, Cations.ZIRCONIUM, Cations.HAFNIUM};
    private static final Cations[] GROUP5 = new Cations[] {Cations.VANADIUM, Cations.NIOBIUM, Cations.TANTALUM};
    private static final Cations[] GROUP6 = new Cations[] {Cations.CHROMIUM, Cations.MOLYBDENUM, Cations.TUNGSTEN};
    private static final Cations[] GROUP7 = new Cations[] {Cations.MANGANESE, Cations.RHENIUM};
    private static final Cations[] HEAVY_GROUP8 = new Cations[] {Cations.RUTHENIUM, Cations.OSMIUM};
    private static final Cations[] HEAVY_GROUP9 = new Cations[] {Cations.RHODIUM, Cations.IRIDIUM};
    private static final Cations[] HEAVY_GROUP10 = new Cations[] {Cations.PALLADIUM, Cations.PLATINUM};
    private static final Cations[] GROUP11 = new Cations[] {Cations.COPPER, Cations.SILVER, Cations.GOLD};
    private static final Cations[] GROUP12 = new Cations[] {Cations.ZINC, Cations.CADMIUM, Cations.MERCURY};
    private static final Cations[] GROUP13 = new Cations[] {Cations.ALUMINUM, Cations.GALLIUM, Cations.INDIUM};
    private static final Cations[] GROUP14 = new Cations[] {Cations.TIN, Cations.LEAD};

    private static final Cations[] MAIN_LANTHANIDES = new Cations[] {Cations.LANTHANUM, Cations.CERIUM, Cations.NEODYMIUM, Cations.GADOLINIUM};
    private static final Cations[] LANTHANIDE_WO_HOLMIUM = addToList(MAIN_LANTHANIDES, Cations.PRASEODYMIUM, Cations.SAMARIUM, Cations.EUROPIUM,
            Cations.TERBIUM, Cations.DYSPROSIUM, Cations.ERBIUM, Cations.THULIUM, Cations.YTTERBIUM, Cations.LUTETIUM);
    private static final Cations[] LANTHANIDE = addToList(LANTHANIDE_WO_HOLMIUM, Cations.HOLMIUM);
    private static final Cations[] SEMI_IRON_LIKE = new Cations[] {Cations.IRON, Cations.MANGANESE, Cations.COBALT};
    private static final Cations[] MAGNETIC = new Cations[] {Cations.IRON, Cations.COBALT, Cations.NICKEL};
    private static final Cations[] IRON_LIKE = addToList(MAGNETIC, Cations.MANGANESE);
    private static final Cations[] MAIN_ALKALINE = addToList(LIGHT_ALKALINE, Cations.STRONTIUM, Cations.BARIUM);
    private static final Cations[] SILVERY = new Cations[] {Cations.MERCURY, Cations.SILVER};
    private static final Cations[] NOBLE_METALS = addToList(HEAVY_GROUP8, HEAVY_GROUP9, HEAVY_GROUP10);

    private static final Cations[] TRANSITION_METAL = addToList(GROUP3, GROUP4, GROUP5, GROUP6, GROUP7,
            GROUP11, GROUP12, NOBLE_METALS, MAGNETIC);

    private static final Cations[] SOFT_METAL = addToList(addToList(GROUP13, GROUP14), Cations.BISMUTH);
    private static final Cations[] ALKALI = addToList(LIGHT_ALKALI, Cations.RUBIDIUM, Cations.CESIUM);
    private static final Cations[] ALKALINE = addToList(MAIN_ALKALINE, Cations.BERYLLIUM);
    private static Cations[] addToList(Cations[] pCations, Cations... pNewCations) {
        Cations[] cations = new Cations[pCations.length + pNewCations.length];
        for (int i = pCations.length; i < pNewCations.length; i++) {
            if (i >= pCations.length) {
                cations[i] = pNewCations[i-pCations.length];
            } else {
                cations[i] = pCations[i];
            }
        }
        return cations;
    }

    private static Cations[] addToList(Cations[]... pNewCations) {
        int arrayLen = 0;
        for (Cations[] cations : pNewCations) {
            for (Cations ignored : cations) {
                arrayLen++;
            }
        }
        Cations[] cationArray = new Cations[arrayLen];
        for (int i = 0; i < pNewCations.length; i++) {
            Cations[] cations = pNewCations[i];
            for (int j = 0; j < cations.length; j++) {
                cationArray[i + j] = cations[j];
            }
        }
        return cationArray;
    }

    public interface Ions {
        String getSymbol();

        // function for autogenerating electrolysis recipes
        int getOxidationState();
    }

    public enum Cations implements Ions {
        AMMONIUM("NH4", 1),
        LITHIUM("Li", 1),
        BERYLLIUM("Be", 2),
        BORON("B", 3),
        SODIUM("Na", 1),
        MAGNESIUM("Mg", 2),
        ALUMINUM("Al", 3),
        SILICON("Si", 4),
        POTASSIUM("K", 1),
        CALCIUM("Ca", 2),
        SCANDIUM("Sc", 3),
        TITANIUM("Ti", 4),
        VANADIUM("V", 5),
        CHROMIUM("Cr", 4),
        MANGANESE("Mn", 4),
        IRON("Fe", 3), // may have variants
        COBALT("Co", 3),
        NICKEL("Ni", 2),
        COPPER("Cu", 1),
        ZINC("Zn", 2),
        GALLIUM("Ga", 3),
        GERMANIUM("Ge", 4),
        ARSENIC("As", 5),
        RUBIDIUM("Rb", 1),
        STRONTIUM("Sr", 2),
        YTTRIUM("Y", 3),
        ZIRCONIUM("Zr", 4),
        NIOBIUM("Nb", 5),
        MOLYBDENUM("Mo", 4),
        RUTHENIUM("Ru", 4),
        RHODIUM("Rh", 3),
        PALLADIUM("Pd", 4),
        SILVER("Ag", 1),
        CADMIUM("Cd", 2),
        INDIUM("In", 3),
        TIN("Sn", 4),
        ANTIMONY("Sb", 5),
        TELLURIUM("Te", 4),
        CESIUM("Cs", 1),
        BARIUM("Ba", 2),
        LANTHANUM("La", 3),
        CERIUM("Ce", 4),
        PRASEODYMIUM("Pr", 3),
        NEODYMIUM("Nd", 3),
        SAMARIUM("Sm", 3),
        EUROPIUM("Eu", 3),
        GADOLINIUM("Gd", 3),
        TERBIUM("Tb", 3),
        DYSPROSIUM("Dy", 3),
        HOLMIUM("Ho", 3),
        ERBIUM("Er", 3),
        THULIUM("Tm", 3),
        YTTERBIUM("Yb", 3),
        LUTETIUM("Lu", 3),
        HAFNIUM("Hf", 4),
        TANTALUM("Ta", 5),
        TUNGSTEN("W", 4),
        RHENIUM("Re", 7),
        OSMIUM("Os", 8),
        IRIDIUM("Ir", 4),
        PLATINUM("Pt", 4),
        GOLD("Au", 3),
        MERCURY("Hg", 2),
        THALLIUM("Tl", 1),
        LEAD("Pb", 2),
        BISMUTH("Bi", 3),
        THORIUM("Th", 4),
        PROTACTINIUM("Pa", 5),
        URANIUM("U", 4),
        NEPTUNIUM("Np", 4),
        PLUTONIUM("Pu", 4),
        AMERICIUM("Am", 3);
        final String symbol;
        final int oxidationState;

        Cations(String pSymbol, int oxState) { // final param will be the pure form, which will either be a block or a liquid
            this.symbol = pSymbol;
            this.oxidationState = oxState;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getOxidationState() {
            return oxidationState;
        }

        public static Cations getCationFromSymbol(String pSymbol) {
            for (Cations cation : Cations.values()) {
                if (cation.getSymbol().equals(pSymbol)) {
                    return cation;
                }
            }
            return null;
        }
    }
    public enum Anions implements Ions {
        FLUORIDE(new Cations[][] {
                addToList(MAIN_ALKALINE, SEMI_IRON_LIKE, new Cations[] {Cations.LEAD, Cations.ALUMINUM, Cations.GALLIUM}),
                new Cations[]{Cations.SODIUM, Cations.CESIUM, Cations.CALCIUM},
                new Cations[]{Cations.SODIUM},
                addToList(ALKALI, Cations.BERYLLIUM, Cations.MAGNESIUM),
                new Cations[]{Cations.SODIUM},
                new Cations[]{Cations.SILVER}}, -1, "F"),

        CHLORIDE(new Cations[][]{
                addToList(SILVERY, Cations.LEAD),
                new Cations[]{Cations.LITHIUM, Cations.MAGNESIUM, Cations.STRONTIUM, Cations.BARIUM},
                new Cations[]{Cations.LITHIUM, Cations.CALCIUM, Cations.STRONTIUM},
                new Cations[]{Cations.POTASSIUM, Cations.RUBIDIUM, Cations.STRONTIUM, Cations.BARIUM, Cations.LEAD},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "Cl"),

        BROMIDE(new Cations[][]{
                new Cations[]{Cations.SILVER},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "Br"),

        IODIDE(new Cations[][]{
                addToList(SILVERY, Cations.LEAD),
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "I"),

        OXIDE(new Cations[][] {
                addToList(ALKALI, Cations.BERYLLIUM, Cations.CALCIUM, Cations.STRONTIUM, Cations.BARIUM),
                MAIN_LANTHANIDES,
                new Cations[]{},
                MAIN_LANTHANIDES,
                addToList(MAIN_LANTHANIDES, Cations.SAMARIUM),
                LANTHANIDE_WO_HOLMIUM,
                LANTHANIDE_WO_HOLMIUM,
                addToList(MAIN_LANTHANIDES, Cations.TERBIUM, Cations.DYSPROSIUM, Cations.YTTERBIUM, Cations.LUTETIUM),
                LANTHANIDE_WO_HOLMIUM}, -2, "O", false),

        SULFIDE(new Cations[][]{
                addToList(ALKALI, ALKALINE)
        }, -2, "S", false),

        NITRIDE(new Cations[][]{}, -3, "N"),
        SELENIDE(new Cations[][]{}, -2, "Se"),
        ARSENIDE(new Cations[][]{}, -3, "As"),

        HYDROXIDE(new Cations[][]{
                addToList(LIGHT_ALKALINE, GROUP14, TRANSITION_METAL, new Cations[]{Cations.ALUMINUM, Cations.GALLIUM, Cations.INDIUM, Cations.BISMUTH}),
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.MAGNESIUM}}, -1, "OH"),

        SULFATE(new Cations[][]{
            new Cations[]{Cations.BARIUM, Cations.LEAD, Cations.STRONTIUM, Cations.CALCIUM}
        }, -2, "SO4"),
        NITRATE(new Cations[][]{}, -1, "NO3"),
        PHOSPHATE(new Cations[][]{
                addToList(ALKALINE, SOFT_METAL, TRANSITION_METAL)
        }, -3, "PO4"),
        CARBONATE(new Cations[][]{}, -2, "CO3"),
        ALUMINOSILICATE(new Cations[][]{}, -2, "AlSiO5", false),
        SILICATE(new Cations[][]{}, -3, "SiO4", false),
        ARSENATE(new Cations[][]{}, -3, "AsO4", false),
        PARATUNGSTATE(new Cations[][]{}, -1, "WO4",false);
        // HgS is insoluble in nitric acid but soluble in aqua regia
        final Cations[][] cationList;
        final boolean solubleByDefault;
        final int oxidationState;
        final String symbol;
        /* Formatting
         * for mixtures like aqua regia or ammonium hydroxide, if its soluble in one of the components its soluble in the mixture
         * in @pInsol, the array lists what cations of the anions are soluble in what substance
         * the first array lists for water
         * the second array lists for acetone
         * the third for ammonia
         * the fourth for ethanol
         * the fifth for hydrochloric acid - mineral acid
         * the sixth for nitric acid - mineral acid
         * the seventh for prussic acid
         * the eight for sulfuric acid - mineral acid
         */
        Anions(Cations[][] pInsol, int oxState, String pSymbol) {
            this(pInsol, oxState, pSymbol, true);
        }


        Anions(Cations[][] pSol, int oxState, String pSymbol, boolean pSolByDefault) {
            this.cationList = pSol;
            this.oxidationState = oxState;
            this.symbol = pSymbol;
            this.solubleByDefault = pSolByDefault;
        }

        // determines the math for auto recipes
        public int getOxidationState() {
            return oxidationState;
        }

        public String getSymbol() {
            return symbol;
        }

        public Cations[][] getCationList() {
            return cationList;
        }

        public static Anions getAnionFromSymbol(String pSymbol) {
            for (Anions anion : Anions.values()) {
                if (anion.getSymbol().equals(pSymbol)) {
                    return anion;
                }
            }
            return null;
        }
    }

    public static final Cations[] ALL_CATIONS = Cations.values();
    public static final int CATION_SIZE = ALL_CATIONS.length;

    public static final Anions[] ALL_ANIONS = Anions.values();
    public static final int ANION_SIZE = ALL_ANIONS.length;
}
