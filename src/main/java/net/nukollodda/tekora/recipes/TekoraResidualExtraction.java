package net.nukollodda.tekora.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.GsonHelper;
import net.nukollodda.tekora.item.typical.CompoundItem;

import java.util.List;

public class TekoraResidualExtraction {
    public static JsonArray getArray(JsonObject pJson, String pName) {
        if (pJson.has(pName)) {
            if (pJson.isJsonArray()) {
                return pJson.getAsJsonArray();
            } else {
                throw new JsonSyntaxException("Expected " + pName + " to be a JsonArray, was " + GsonHelper.getType(pJson));
            }
        } else {
            throw new JsonSyntaxException("Missing " + pName + ", expected to find a JsonArray");
        }
    }

    public static List<CompoundItem.Cations> convertStringToCations(String[] str) {
        List<CompoundItem.Cations> cations = List.of();
        for (String symbol : str) {
            cations.add(convertStringToCations(symbol));
        }
        return cations;
    }

    public static List<CompoundItem.Anions> convertStringToAnions(String[] str) {
        List<CompoundItem.Anions> anions = List.of();
        for (String symbol : str) {
            anions.add(convertStringToAnions(symbol));
        }
        return anions;
    }

    public static CompoundItem.Cations convertStringToCations(String str) {
        return switch (str) {
            case "Li" -> CompoundItem.Cations.LITHIUM;
            case "Be" -> CompoundItem.Cations.BERYLLIUM;
            case "B" -> CompoundItem.Cations.BORON;
            case "Na" -> CompoundItem.Cations.SODIUM;
            case "Mg" -> CompoundItem.Cations.MAGNESIUM;
            case "Al" -> CompoundItem.Cations.ALUMINUM;
            case "Si" -> CompoundItem.Cations.SILICON;
            case "K" -> CompoundItem.Cations.POTASSIUM;
            case "Ca" -> CompoundItem.Cations.CALCIUM;
            case "Sc" -> CompoundItem.Cations.SCANDIUM;
            case "Ti" -> CompoundItem.Cations.TITANIUM;
            case "V" -> CompoundItem.Cations.VANADIUM;
            case "Cr" -> CompoundItem.Cations.CHROMIUM;
            case "Mn" -> CompoundItem.Cations.MANGANESE;
            case "Fe" -> CompoundItem.Cations.IRON;
            case "Co" -> CompoundItem.Cations.COBALT;
            case "Ni" -> CompoundItem.Cations.NICKEL;
            case "Cu" -> CompoundItem.Cations.COPPER;
            case "Zn" -> CompoundItem.Cations.ZINC;
            case "Ga" -> CompoundItem.Cations.GALLIUM;
            case "Ge" -> CompoundItem.Cations.GERMANIUM;
            case "As" -> CompoundItem.Cations.ARSENIC;
            case "Rb" -> CompoundItem.Cations.RUBIDIUM;
            case "Sr" -> CompoundItem.Cations.STRONTIUM;
            case "Y" -> CompoundItem.Cations.YTTRIUM;
            case "Zr" -> CompoundItem.Cations.ZIRCONIUM;
            case "Nb" -> CompoundItem.Cations.NIOBIUM;
            case "Mo" -> CompoundItem.Cations.MOLYBDENUM;
            case "Ru" -> CompoundItem.Cations.RUTHENIUM;
            case "Rh" -> CompoundItem.Cations.RHODIUM;
            case "Pd" -> CompoundItem.Cations.PALLADIUM;
            case "Ag" -> CompoundItem.Cations.SILVER;
            case "Cd" -> CompoundItem.Cations.CADMIUM;
            case "In" -> CompoundItem.Cations.INDIUM;
            case "Sn" -> CompoundItem.Cations.TIN;
            case "Sb" -> CompoundItem.Cations.ANTIMONY;
            case "Cs" -> CompoundItem.Cations.CESIUM;
            case "Ba" -> CompoundItem.Cations.BARIUM;
            case "La" -> CompoundItem.Cations.LANTHANUM;
            case "Ce" -> CompoundItem.Cations.CERIUM;
            case "Pr" -> CompoundItem.Cations.PRASEODYMIUM;
            case "Nd" -> CompoundItem.Cations.NEODYMIUM;
            case "Sm" -> CompoundItem.Cations.SAMARIUM;
            case "Eu" -> CompoundItem.Cations.EUROPIUM;
            case "Gd" -> CompoundItem.Cations.GADOLINIUM;
            case "Tb" -> CompoundItem.Cations.TERBIUM;
            case "Dy" -> CompoundItem.Cations.DYSPROSIUM;
            case "Ho" -> CompoundItem.Cations.HOLMIUM;
            case "Er" -> CompoundItem.Cations.ERBIUM;
            case "Tm" -> CompoundItem.Cations.THULIUM;
            case "Yb" -> CompoundItem.Cations.YTTERBIUM;
            case "Lu" -> CompoundItem.Cations.LUTETIUM;
            case "Hf" -> CompoundItem.Cations.HAFNIUM;
            case "Ta" -> CompoundItem.Cations.TANTALUM;
            case "W" -> CompoundItem.Cations.TUNGSTEN;
            case "Re" -> CompoundItem.Cations.RHENIUM;
            case "Os" -> CompoundItem.Cations.OSMIUM;
            case "Ir" -> CompoundItem.Cations.IRIDIUM;
            case "Pt" -> CompoundItem.Cations.PLATINUM;
            case "Au" -> CompoundItem.Cations.GOLD;
            case "Hg" -> CompoundItem.Cations.MERCURY;
            case "Tl" -> CompoundItem.Cations.THALLIUM;
            case "Pb" -> CompoundItem.Cations.LEAD;
            case "Bi" -> CompoundItem.Cations.BISMUTH;
            case "Th" -> CompoundItem.Cations.THORIUM;
            case "Pa" -> CompoundItem.Cations.PROTACTINIUM;
            case "U" -> CompoundItem.Cations.URANIUM;
            case "Np" -> CompoundItem.Cations.NEPTUNIUM;
            case "Pu" -> CompoundItem.Cations.PLUTONIUM;
            case "Am" -> CompoundItem.Cations.AMERICIUM;
            case "NH4" -> CompoundItem.Cations.AMMONIUM;
            default -> null;
        };
    }

    public static CompoundItem.Anions convertStringToAnions(String str) {
        return switch (str) {
            case "O" -> CompoundItem.Anions.OXIDE;
            case "F" -> CompoundItem.Anions.FLUORIDE;
            /*
            case "S" -> CompoundItem.Anions.SULFIDE;
            case "Cl" -> CompoundItem.Anions.CHLORIDE;
            case "Se" -> CompoundItem.Anions.SELENIDE;
            case "Br" -> CompoundItem.Anions.BROMIDE;
            case "I" -> CompoundItem.Anions.IODIDE;
            case "BO3" -> CompoundItem.Anions.BORATE;
            case "CO3" -> CompoundItem.Anions.CARBONATE;
            case "NO3" -> CompoundItem.Anions.NITRATE;
            case "AlSi5" -> CompoundItem.Anions.ALUMINOSILICATE;
            case "SiO4" -> CompoundItem.Anions.SILICATE;
            case "PO4" -> CompoundItem.Anions.PHOSPHATE;
            case "SO3" -> CompoundItem.Anions.SULFITE;
            case "SO4" -> CompoundItem.Anions.SULFATE;
            case "ClO4" -> CompoundItem.Anions.PERCHLORATE;
            case "AsO4" -> CompountItem.Anions.ARSENATE;
            case "OH" -> CompoundItem.Anions.HYDROXIDE;
            case "WO4" -> CompoundItem.Anions.PARATUNGSTATE;
             */
            default -> null;
        };
    }
}
