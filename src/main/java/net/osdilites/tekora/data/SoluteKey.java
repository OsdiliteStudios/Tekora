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
            return formula1.equals(formula) && charge1 == charge;
        }
        return false;
    }
}
