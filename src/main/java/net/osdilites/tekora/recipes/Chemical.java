package net.osdilites.tekora.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record Chemical(ChemicalIngredient chemical, int coefficient, double order) {
    public static final Codec<Chemical> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ChemicalIngredient.CODEC.fieldOf("chemical").forGetter(Chemical::chemical),
            Codec.INT.optionalFieldOf("coefficient", 1).forGetter(Chemical::coefficient),
            Codec.DOUBLE.optionalFieldOf("order", 0.0).forGetter(Chemical::order)
    ).apply(instance, Chemical::new));
}
