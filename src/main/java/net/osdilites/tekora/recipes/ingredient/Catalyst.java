package net.osdilites.tekora.recipes.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

// energyRed means how much does a catalyst reduces the activation energy of a chemical reaction
public record Catalyst(ChemicalIngredient catalyst, double energyRed /* J/mol */) {
    public static final Codec<Catalyst> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ChemicalIngredient.CODEC.fieldOf("catalyst").forGetter(Catalyst::catalyst),
            Codec.DOUBLE.optionalFieldOf("energy_reduction", 0.0).forGetter(Catalyst::energyRed)
    ).apply(instance, Catalyst::new));
}
