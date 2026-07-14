package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ManuscriptComponent(int id) {
    public static final Codec<ManuscriptComponent> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
                    Codec.INT.fieldOf("id").forGetter(ManuscriptComponent::id)
    ).apply(instance, ManuscriptComponent::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ManuscriptComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, ManuscriptComponent::id,
            ManuscriptComponent::new
    );
}
