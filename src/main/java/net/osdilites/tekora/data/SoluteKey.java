package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

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

    // cations
    public static SoluteKey AMMONIUM = new SoluteKey("NH4", 1);
    public static SoluteKey SODIUM = new SoluteKey("Na", 1);
    public static SoluteKey MAGNESIUM = new SoluteKey("Mg", 2);
    public static SoluteKey IRON2 = new SoluteKey("Fe", 2); // ferrous
    public static SoluteKey IRON3 = new SoluteKey("Fe", 3); // ferric

    // anions
    public static SoluteKey ACETATE = new SoluteKey("CH3COO", -1);
    public static SoluteKey BICARBONATE = new SoluteKey("HCO3", -1);
    public static SoluteKey BISULFATE = new SoluteKey("HSO4", -1);
    public static SoluteKey CYANIDE = new SoluteKey("CN", -1);
    public static SoluteKey FORMATE = new SoluteKey("HCOO", -1);
    public static SoluteKey HYDROXIDE = new SoluteKey("OH", -1);
    public static SoluteKey PERCHLORATE = new SoluteKey("ClO4", -1);
    public static SoluteKey PHOSPHATE = new SoluteKey("PO4", -3);
    public static SoluteKey CHLORIDE = new SoluteKey("Cl", -1);
    public static SoluteKey CARBONATE = new SoluteKey("CO3", -2);
    public static SoluteKey NITRATE = new SoluteKey("NO3", -1);
    public static SoluteKey SULFATE = new SoluteKey("SO4", -2);
}
