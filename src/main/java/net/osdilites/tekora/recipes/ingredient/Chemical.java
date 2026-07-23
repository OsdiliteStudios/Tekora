package net.osdilites.tekora.recipes.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record Chemical(ChemicalIngredient chemical, int coefficient, int order) {
    public static final Codec<Chemical> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ChemicalIngredient.CODEC.fieldOf("chemical").forGetter(Chemical::chemical),
            Codec.INT.optionalFieldOf("coefficient", 1).forGetter(Chemical::coefficient), // for solids, we'll approximate, for liquids we'll use more exact values
            Codec.INT.optionalFieldOf("order", 0).forGetter(Chemical::order)
    ).apply(instance, Chemical::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, Chemical> STREAM_CODEC = StreamCodec.composite(
            ChemicalIngredient.STREAM_CODEC, Chemical::chemical,
            ByteBufCodecs.VAR_INT, Chemical::coefficient,
            ByteBufCodecs.VAR_INT, Chemical::order,
            Chemical::new
    );

    public double getMol() {
        return chemical.getMol();
    }
}
