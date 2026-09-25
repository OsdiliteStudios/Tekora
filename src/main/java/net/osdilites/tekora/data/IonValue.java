package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record IonValue(String ion, double molarity, boolean isAnion) {
    public static final Codec<IonValue> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.STRING.fieldOf("ion").forGetter(IonValue::ion),
            Codec.DOUBLE.fieldOf("molarity").forGetter(IonValue::molarity),
            Codec.BOOL.fieldOf("is_anion").forGetter(IonValue::isAnion)
    ).apply(instance, IonValue::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, IonValue> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, IonValue::ion,
            ByteBufCodecs.DOUBLE, IonValue::molarity,
            ByteBufCodecs.BOOL, IonValue::isAnion,
            IonValue::new
    );
}
