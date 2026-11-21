package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record PipeDurability(int durability) {
    public static final Codec<PipeDurability> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            Codec.INT.fieldOf("durability").forGetter(PipeDurability::durability)
    ).apply(instance, PipeDurability::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PipeDurability> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, PipeDurability::durability,
            PipeDurability::new
    );
}
