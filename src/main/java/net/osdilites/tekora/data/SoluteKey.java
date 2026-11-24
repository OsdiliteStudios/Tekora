package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public record SoluteKey(String formula, int charge) {
    public static final Codec<SoluteKey> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.STRING.fieldOf("formula").forGetter(SoluteKey::formula),
            Codec.INT.fieldOf("charge").forGetter(SoluteKey::charge)
    ).apply(instance, SoluteKey::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, SoluteKey> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SoluteKey::formula,
            ByteBufCodecs.INT, SoluteKey::charge,
            SoluteKey::new
    );

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SoluteKey(String formula1, int charge1)) {
            return charge1 == charge && formula1.equals(formula);
        }
        return false;
    }

    // cations and anions are used for aqueous/dissolved salts and also for molten and gaseous salts.
    @Contract("_, _ -> new")
    public static @NonNull SoluteKey cation(String formula, int magnitude) {
        return new SoluteKey(formula, magnitude);
    }

    @Contract("_ -> new")
    public static @NonNull SoluteKey cation(String formula) {
        return cation(formula, 1);
    }

    @Contract("_, _ -> new")
    public static @NonNull SoluteKey anion(String formula, int magnitude) {
        return new SoluteKey(formula, -magnitude);
    }

    @Contract("_ -> new")
    public static @NonNull SoluteKey anion(String formula) {
        return anion(formula, 1);
    }

    // used for covalently bounded compounds and solid salts
    public static @NonNull SoluteKey of(String formula) {
        return new SoluteKey(formula, 0);
    }

    // cations
    public static SoluteKey AMMONIUM = cation("NH4");
    public static SoluteKey ALUMINUM = cation("Al", 3);
    public static SoluteKey SODIUM = cation("Na");
    public static SoluteKey MAGNESIUM = cation("Mg", 2);
    public static SoluteKey IRON2 = cation("Fe", 2); // ferrous
    public static SoluteKey IRON3 = cation("Fe", 3); // ferric

    // anions
    public static SoluteKey ACETATE = anion("CH3COO");
    public static SoluteKey BICARBONATE = anion("HCO3");
    public static SoluteKey BISULFATE = anion("HSO4");
    public static SoluteKey CARBONATE = anion("CO3", 2);
    public static SoluteKey CHLORIDE = anion("Cl");
    public static SoluteKey CYANIDE = anion("CN");
    public static SoluteKey FORMATE = anion("HCOO");
    public static SoluteKey HYDROXIDE = anion("OH");
    public static SoluteKey OXIDE = anion("O", 2);
    public static SoluteKey PERCHLORATE = anion("ClO4");
    public static SoluteKey PHOSPHATE = anion("PO4", 3);
    public static SoluteKey NITRATE = anion("NO3");
    public static SoluteKey SULFATE = anion("SO4", 2);

    // covalently bonded solutes/solid salts
    public static SoluteKey AMMONIA = of("NH3");
    public static SoluteKey SULFURIC_ACID = of("H2SO4");
    public static SoluteKey WATER = of("H2O");

    private static boolean isPolyatomic(@NonNull String formula) {
        return formula.length() > 2 || (formula.length() == 2 && ((formula.charAt(1) >= 'A' && formula.charAt(1) <= 'Z') || (formula.charAt(1) >= '2' && formula.charAt(1) <= '9')));
    }

    // method that can make a SoluteKey from other SoluteKeys. Useful for JSON recipe consistency.
    public static @NonNull SoluteKey assembleSaltFromIons(@NonNull SoluteKey cation, @NonNull SoluteKey anion) {
        int pos = cation.charge();
        int neg = anion.charge();
        // safeguarding, removed for the released product
        if (neg >= 0 || pos <= 0) throw new IllegalArgumentException("Cation has to be positive and anion has to be negative");

        pos = Math.abs(pos);
        neg = Math.abs(neg);
        String catForm = cation.formula();
        String anForm = anion.formula();
        if (pos == neg) {
            return of(catForm + anForm);
        } else {
            boolean catParen = isPolyatomic(catForm);
            boolean anParen = isPolyatomic(anForm);
            if (pos % neg == 0) {
                int anCnt = pos / neg;
                return of(catForm + (anParen ? "(" + anForm + ")" : anForm) + anCnt);
            } else if (neg % pos == 0) {
                int catCnt = neg / pos;
                return of((catParen ? "(" + catForm + ")" : catForm) + catCnt + anForm);
            } else {
                int a = neg;
                int b = pos;
                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }
                int anCnt = pos/a;
                int catCnt = neg/a;
                return of((catParen ? "(" + catForm + ")" : catForm) + catCnt + (anParen ? "(" + anForm + ")" : anForm) + anCnt);
            }
        }
    }
}
