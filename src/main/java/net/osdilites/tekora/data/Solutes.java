package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public record Solutes(@NotNull Map<SoluteKey, Double> dataMap) {
    public static final Codec<Solutes> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.unboundedMap(SoluteKey.CODEC, Codec.DOUBLE).fieldOf("solutes").forGetter(Solutes::dataMap)
    ).apply(instance, Solutes::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, Solutes> STREAM_CODEC =
            ByteBufCodecs.map(HashMap::new, SoluteKey.STREAM_CODEC, ByteBufCodecs.DOUBLE)
                    .map(Solutes::new, (Solutes s) -> (s.dataMap instanceof HashMap<SoluteKey,Double> ret ? ret : new HashMap<>(s.dataMap)));

    public Solutes removeKey(SoluteKey key) {
        dataMap.remove(key);
        return this;
    }

    public double overallCharge() {
        double charge = 0;
        for (SoluteKey key : dataMap.keySet()) {
            charge += key.charge() * dataMap.getOrDefault(key, 0.0);
        }
        return charge;
    }

    public Solutes addKey(SoluteKey key, double coeff) {
        dataMap.put(key, dataMap.containsKey(key) ? (dataMap.get(key) + coeff) : coeff);
        return this;
    }

    public void modifyKey(SoluteKey key, double coeff) {
        if (dataMap.containsKey(key)) {
            dataMap.put(key, coeff);
        }
    }

    public static Solutes create() {
        return new Solutes(new HashMap<>());
    }

}
