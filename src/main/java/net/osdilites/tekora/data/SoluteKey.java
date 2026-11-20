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

    @Contract("_ -> new")
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

    // covalently bonded solutes
    public static SoluteKey AMMONIA = of("NH3");
    public static SoluteKey SULFURIC_ACID = of("H2SO4");
    public static SoluteKey WATER = of("H2O");
}
