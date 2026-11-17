package net.osdilites.tekora.recipes.ingredient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// energyRed means how much does a catalyst reduces the activation energy of a chemical reaction
// todo, store data in here as a list rather than a single item
public record Catalyst(ChemicalIngredient catalyst, double energyRed /* J/mol */) {
    public static final Codec<Catalyst> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ChemicalIngredient.CODEC.fieldOf("catalyst").forGetter(Catalyst::catalyst),
            Codec.DOUBLE.optionalFieldOf("energy_reduction", 0.0).forGetter(Catalyst::energyRed)
    ).apply(instance, Catalyst::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, Catalyst> STREAM_CODEC = StreamCodec.composite(
            ChemicalIngredient.STREAM_CODEC, Catalyst::catalyst,
            ByteBufCodecs.DOUBLE, Catalyst::energyRed,
            Catalyst::new
    );

    // null catalyst, temporary solution for now
    public static Catalyst NULL_CATALYST = new Catalyst(ChemicalIngredient.of(Items.BARRIER), 0);
}
