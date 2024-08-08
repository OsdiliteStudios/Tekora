package net.tekoramods.tekora.item.typical;

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
    private final Ions ion;
    private final int count;
    public IonicParts(Ions pIon, int num) {
        this.ion = pIon;
        this.count = num > 0 ? num : 1;
    }

    public IonicParts(Ions pIon) {
        this(pIon, pIon.getOxidationState());
    }

    public Ions getIon() {
        return ion;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String symbol = ion.getSymbol();
        String cnt = (count > 1 ? count : "") + "";
        if (count > 1) {
            for (char c : symbol.toCharArray()) {
                if (Character.isDigit(c)) {
                    symbol = "(" + symbol + ")";
                    break;
                }
            }
        }
        return symbol + cnt;
    }

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

    public static final Cations[] ALL_CATIONS = Cations.values();
    public static final int CATION_SIZE = ALL_CATIONS.length;

    public static final Anions[] ALL_ANIONS = Anions.values();
    public static final int ANION_SIZE = ALL_ANIONS.length;

    public interface Ions {
        String getSymbol();

        // function for autogenerating electrolysis recipes
        int getOxidationState();

        float getElectronegativity();
    }

    public enum Cations implements Ions {
        AMMONIUM("NH4", 1, 0.98f),
        LITHIUM("Li", 1, 0.98f),
        BERYLLIUM("Be", 2, 1.57f),
        BORON("B", 3, 2.04f),
        SODIUM("Na", 1, 0.98f),
        MAGNESIUM("Mg", 2, 1.31f),
        ALUMINUM("Al", 3, 1.61f),
        SILICON("Si", 4, 1.9f),
        POTASSIUM("K", 1, 0.82f),
        CALCIUM("Ca", 2, 1f),
        SCANDIUM("Sc", 3, 1.36f),
        TITANIUM("Ti", 4, 1.54f),
        VANADIUM("V", 5, 1.63f),
        CHROMIUM("Cr", 4, 1.66f),
        MANGANESE("Mn", 4, 1.55f),
        IRON("Fe", 3, 1.83f),
        COBALT("Co", 3, 1.88f),
        NICKEL("Ni", 2, 1.91f),
        COPPER("Cu", 1, 1.9f),
        ZINC("Zn", 2, 1.65f),
        GALLIUM("Ga", 3, 1.81f),
        GERMANIUM("Ge", 4, 2.01f),
        ARSENIC("As", 5, 2.18f),
        RUBIDIUM("Rb", 1, 0.82f),
        STRONTIUM("Sr", 2, 0.95f),
        YTTRIUM("Y", 3, 1.22f),
        ZIRCONIUM("Zr", 4, 1.33f),
        NIOBIUM("Nb", 5, 1.6f),
        MOLYBDENUM("Mo", 4, 2.16f),
        RUTHENIUM("Ru", 4, 2.2f),
        RHODIUM("Rh", 3, 2.28f),
        PALLADIUM("Pd", 4, 2.2f),
        SILVER("Ag", 1, 1.93f),
        CADMIUM("Cd", 2, 1.69f),
        INDIUM("In", 3, 1.78f),
        TIN("Sn", 4, 1.96f),
        ANTIMONY("Sb", 5, 2.05f),
        TELLURIUM("Te", 4, 2.1f),
        CESIUM("Cs", 1, 0.79f),
        BARIUM("Ba", 2, 0.89f),
        LANTHANUM("La", 3, 1.1f),
        CERIUM("Ce", 4, 1.12f),
        PRASEODYMIUM("Pr", 3, 1.13f),
        NEODYMIUM("Nd", 3, 1.14f),
        SAMARIUM("Sm", 3, 1.17f),
        EUROPIUM("Eu", 3, 1.2f),
        GADOLINIUM("Gd", 3, 1.2f),
        TERBIUM("Tb", 3, 1.22f),
        DYSPROSIUM("Dy", 3, 1.23f),
        HOLMIUM("Ho", 3, 1.24f),
        ERBIUM("Er", 3, 1.24f),
        THULIUM("Tm", 3, 1.25f),
        YTTERBIUM("Yb", 3, 1.1f),
        LUTETIUM("Lu", 3, 1.27f),
        HAFNIUM("Hf", 4, 1.3f),
        TANTALUM("Ta", 5, 1.5f),
        TUNGSTEN("W", 4, 2.36f),
        RHENIUM("Re", 7, 1.9f),
        OSMIUM("Os", 8, 2.2f),
        IRIDIUM("Ir", 4, 2.2f),
        PLATINUM("Pt", 4, 2.28f),
        GOLD("Au", 3, 2.54f),
        MERCURY("Hg", 2, 2f),
        THALLIUM("Tl", 1, 1.62f),
        LEAD("Pb", 2, 2.33f),
        BISMUTH("Bi", 3, 2.02f),
        THORIUM("Th", 4, 1.3f),
        PROTACTINIUM("Pa", 5, 1.5f),
        URANIUM("U", 4, 1.38f),
        NEPTUNIUM("Np", 4, 1.36f),
        PLUTONIUM("Pu", 4, 1.28f),
        AMERICIUM("Am", 3, 1.3f);
        private final String symbol;
        private final int oxidationState;
        private final float electronegativity;

        Cations(String pSymbol, int oxState, float pElectronegativity) {
            this.symbol = pSymbol;
            this.oxidationState = oxState;
            // note: the oxState shows the possible oxState within Tekora residues for the sake of simple calculations
            // meaning there are dusts that don't follow the oxStates set here
            this.electronegativity = pElectronegativity;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getOxidationState() {
            return oxidationState;
        }

        public float getElectronegativity() {
            // determines speed of reactions, single displacement reactions, and whether things explode in fluids or not
            return electronegativity;
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
                new Cations[]{Cations.SILVER}}, -1, "F", 3.98f),

        CHLORIDE(new Cations[][]{
                addToList(SILVERY, Cations.LEAD),
                new Cations[]{Cations.LITHIUM, Cations.MAGNESIUM, Cations.STRONTIUM, Cations.BARIUM},
                new Cations[]{Cations.LITHIUM, Cations.CALCIUM, Cations.STRONTIUM},
                new Cations[]{Cations.POTASSIUM, Cations.RUBIDIUM, Cations.STRONTIUM, Cations.BARIUM, Cations.LEAD},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "Cl", 3.16f),

        BROMIDE(new Cations[][]{
                new Cations[]{Cations.SILVER},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "Br", 2.96f),

        IODIDE(new Cations[][]{
                addToList(SILVERY, Cations.LEAD),
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.SILVER}}, -1, "I", 2.66f),

        OXIDE(new Cations[][] {
                addToList(ALKALI, Cations.BERYLLIUM, Cations.CALCIUM, Cations.STRONTIUM, Cations.BARIUM),
                MAIN_LANTHANIDES,
                new Cations[]{},
                MAIN_LANTHANIDES,
                addToList(MAIN_LANTHANIDES, Cations.SAMARIUM),
                LANTHANIDE_WO_HOLMIUM,
                LANTHANIDE_WO_HOLMIUM,
                addToList(MAIN_LANTHANIDES, Cations.TERBIUM, Cations.DYSPROSIUM, Cations.YTTERBIUM, Cations.LUTETIUM),
                LANTHANIDE_WO_HOLMIUM}, -2, "O", 3.44f, false),

        SULFIDE(new Cations[][]{
                addToList(ALKALI, ALKALINE)
        }, -2, "S", 2.58f, false),

        NITRIDE(new Cations[][]{}, -3, "N", 3.04f),
        SELENIDE(new Cations[][]{}, -2, "Se", 2.55f),

        HYDROXIDE(new Cations[][]{
                addToList(LIGHT_ALKALINE, GROUP14, TRANSITION_METAL, new Cations[]{Cations.ALUMINUM, Cations.GALLIUM, Cations.INDIUM, Cations.BISMUTH}),
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{},
                new Cations[]{Cations.MAGNESIUM}}, -1, "OH", 1.24f),

        SULFATE(new Cations[][]{
            new Cations[]{Cations.BARIUM, Cations.LEAD, Cations.STRONTIUM, Cations.CALCIUM}
        }, -2, "SO4", 0.86f),
        NITRATE(new Cations[][]{}, -1, "NO3", 0.4f),
        PHOSPHATE(new Cations[][]{
                addToList(ALKALINE, SOFT_METAL, TRANSITION_METAL)
        }, -3, "PO4", 1.25f),
        CARBONATE(new Cations[][]{}, -2, "CO3", 0.89f);
        // HgS is insoluble in nitric acid but soluble in aqua regia
        private final Cations[][] cationList;
        final boolean solubleByDefault;
        private final int oxidationState;
        private final String symbol;
        private final float electronegativity;
        /* Formatting
         * for mixtures like aqua regia or ammonium hydroxide, if its soluble in one of the components its soluble in the mixture
         * in @param pInsol, the array lists what cations of the anions are soluble in what substance
         * the first array lists for water
         * the second array lists for acetone
         * the third for ammonia
         * the fourth for ethanol
         * the fifth for hydrochloric acid - mineral acid
         * the sixth for nitric acid - mineral acid
         * the seventh for prussic acid
         * the eight for sulfuric acid - mineral acid
         */
        Anions(Cations[][] pInsol, int oxState, String pSymbol, float pElectronegativity) {
            this(pInsol, oxState, pSymbol, pElectronegativity, true);
        }


        Anions(Cations[][] pSol, int oxState, String pSymbol, float pElectronegativity, boolean pSolByDefault) {
            this.cationList = pSol;
            this.oxidationState = oxState;
            this.symbol = pSymbol;
            this.solubleByDefault = pSolByDefault;
            this.electronegativity = pElectronegativity;
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

        @Override
        public float getElectronegativity() {
            return electronegativity;
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
}
