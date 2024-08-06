package net.leng.tekora.item.typical;

import net.leng.tekora.item.tools.ITekoraColored;

public class RawItem extends TekoraItem implements ITekoraColored {
    private final int color;
    public RawItem(boolean fireRes, int color) {
        super(fireRes);
        this.color = color;
    }

    public RawItem(int color) {
        this(false, color);
    }

    @Override
    public int getColor() {
        return color;
    }

    public static final int ALUMINUM = 0xFFEDFBFF;
    public static final int AMERICIUM = 0xFF4D0E0E;
    public static final int ANTIMONY = 0xFFEBE1FC;
    public static final int ARSENIC = 0xFF87826D;
    public static final int BARIUM = 0xFF4F4F4F;
    public static final int BERYLLIUM = 0xFF9FAD99;
    public static final int BORON = 0xFF6D6257;
    public static final int BRASS = 0xFFFFF09E;
    public static final int BRONZE = 0x40FFB161;
    public static final int CADMIUM = 0xFF455245;
    public static final int CALCIUM = 0xFFEAEAEA;
    public static final int CARBON_STEEL = 0xFF474747;
    public static final int CERIUM = 0xFFFBFFEB;
    public static final int CESIUM = 0xFFFFFFF0;
    public static final int CHROMIUM = 0xFFCFFFC4;
    public static final int CHROMOLY_STEEL = 0xFFD5F5EC;
    public static final int COBALT = 0x604090FF;
    public static final int COPPER = 0xFFE77C56;
    public static final int CUPRONICKEL = 0xFFFAAA7A;
    public static final int DIAMOND = 0xFF4AEDD9;
    public static final int DYSPROSIUM = 0xFFFFDEEA;
    public static final int ELECTRUM = 0x40FFE787;
    public static final int ERBIUM = 0xFFEDC5C5;
    public static final int EUROPIUM = 0xFFE7F7DA;
    public static final int FERROBORON = 0xFFFFF2E6;
    public static final int GADOLINIUM = 0xFFE3FCF4;
    public static final int GALLIUM = 0xFFEDF9FF;
    public static final int GALVANIZED_STEEL = 0xFFFFF9E8;
    public static final int GERMANIUM = 0xFFDEDEB1;
    public static final int GOLD = 0xFFFFF9A6;
    public static final int HAFNIUM = 0xFFD4D3B4;
    public static final int HOLMIUM = 0xFFD1C6C5;
    public static final int HSLA_STEEL = 0xFFB1DCF2;
    public static final int INCONEL = 0xFFF5FFA1;
    public static final int INDIUM = 0xFF9EAEAE;
    public static final int INVAR = 0x80FFECAD;
    public static final int IRIDIUM = 0xFFEDF9FF;
    public static final int IRON = 0xFFA8A8A8;
    public static final int LANTHANUM = 0xFFD9D9D9;
    public static final int LEAD = 0xFF9496FF;
    public static final int LITHIUM = 0xFFC2BCB0;
    public static final int LUTETIUM = 0xFFB7C4C9;
    public static final int MAGNESIUM = 0xFF878787;
    public static final int MAGNESIUM_DIBORIDE = 0xFF5F5D5B;
    public static final int MAGNETIC_NEODYMIUM = 0xFFBBAEAC;
    public static final int MANGANESE = 0xFFFBD9FF;
    public static final int MOLYBDENUM = 0xFFE3EFFA;
    public static final int MU_METAL = 0x80FFE694;
    public static final int NEODYMIUM = 0xFFE8E0EE;
    public static final int NEPTUNIUM = 0xFF3341DE;
    public static final int NETHERITE = 0xFF4D494D;
    public static final int NICKEL = 0xFFFFFCE0;
    public static final int NIOBIUM = 0xFF5E566E;
    public static final int NIOBIUM_TIN = 0xFF9E98AD;
    public static final int OSMIUM = 0xFFE8FAF9;
    public static final int PALLADIUM = 0xFFFFF4E8;
    public static final int PLATINUM = 0xFFD6F8FF;
    public static final int PLUTONIUM = 0xFF878684;
    public static final int POTASSIUM = 0xFFE8D5BE;
    public static final int PROTACTINIUM = 0xFFD9CAB0;
    public static final int PRASEODYMIUM = 0xFFD9E3D3;
    public static final int REACTOR_STEEL = 0xFF5F5B58;
    public static final int RHENIUM = 0xFFCBC7EB;
    public static final int RHODIUM = 0xFF4D4D4D;
    public static final int RUBIDIUM = 0xFFC4B8B3;
    public static final int RUTHENIUM = 0xFFC4BECC;
    public static final int SAMARIUM = 0xFFD2CEBE;
    public static final int SCANDIUM = 0xFFB2B4AC;
    public static final int SILICON = 0xFF5A5A76;
    public static final int SILICON_CARBIDE = 0xFF23232E;
    public static final int SILVER = 0xFFFFFFFF;
    public static final int SODIUM = 0xFF838389;
    public static final int STAINLESS_STEEL = 0xFFF2F8FF;
    public static final int STEEL = 0xFFABABAB;
    public static final int STRONTIUM = 0xFFC3E0E6;
    public static final int TANTALUM = 0xFFE3D9D5;
    public static final int TELLURIUM = 0xFFA9C7C1;
    public static final int TERBIUM = 0xFFBCBFB4;
    public static final int THALLIUM = 0xFFA4B6AB;
    public static final int THORIUM = 0xFF545753;
    public static final int THULIUM = 0xFF9C9992;
    public static final int TIN = 0xFFF0FBFF;
    public static final int TITANIUM = 0xFF656A85;
    public static final int TUNGSTEN = 0xFF514E54;
    public static final int TUNGSTEN_CARBIDE = 0xFF3C3B3B;
    public static final int TUNGSTEN_STEEL = 0xFF948A94;
    public static final int URANIUM = 0xFFC3E3B8;
    public static final int VANADIUM = 0xFFA5A0BA;
    public static final int VANASTEEL = 0xFFC2B5FF;
    public static final int YTTERBIUM = 0xFF9A988C;
    public static final int YTTRIUM = 0xFF717868;
    public static final int ZINC = 0xFFFAF7E6;
    public static final int ZIRCALOY = 0xFFFFF4E8;
    public static final int ZIRCONIUM = 0xFFEBE6CC;
}
