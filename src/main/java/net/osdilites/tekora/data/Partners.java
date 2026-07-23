package net.osdilites.tekora.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

public record Partners(List<BlockPos> partners) {
    public static final Codec<Partners> CODEC = RecordCodecBuilder.create((
            instance) -> instance.group(
            BlockPos.CODEC.listOf().fieldOf("partners").forGetter(Partners::partners)
    ).apply(instance, Partners::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, Partners> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC.apply(ByteBufCodecs.list()), Partners::partners,
            Partners::new
    );

    public void addPartner(BlockPos pos) {
        partners.add(pos);
    }
}
