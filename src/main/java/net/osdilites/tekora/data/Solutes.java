package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.HashMap;
import java.util.Map;

public record Solutes(Map<SoluteKey, Double> dataMap) {
    public static final Codec<Solutes> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.unboundedMap(SoluteKey.CODEC, Codec.DOUBLE).fieldOf("solutes").forGetter(Solutes::dataMap)
    ).apply(instance, Solutes::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, Solutes> STREAM_CODEC =
            ByteBufCodecs.map(HashMap::new, SoluteKey.STREAM_CODEC, ByteBufCodecs.DOUBLE)
                    .map(Solutes::new, (Solutes s) -> (s.dataMap instanceof HashMap<SoluteKey,Double> ret ? ret : new HashMap<>(s.dataMap)));
}
