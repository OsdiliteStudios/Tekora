package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.osdilites.tekora.data.SoluteKey;
import net.osdilites.tekora.data.Solutes;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

@Deprecated
public record ChemDataIngredient(Either<SoluteKey, Solutes> input) {
    public static final Codec<ChemDataIngredient> CODEC = Codec.either(
            SoluteKey.CODEC,
            Solutes.CODEC
    ).xmap(ChemDataIngredient::new, ChemDataIngredient::input);

    private static final StreamCodec<RegistryFriendlyByteBuf, Either<SoluteKey, Solutes>>
            GENERAL_STREAM_CODEC = StreamCodec.of(
            (buf, either) -> either.ifLeft(
                    ingredient -> {
                        buf.writeBoolean(true);
                        SoluteKey.STREAM_CODEC.encode(buf, ingredient);
                    }
            ).ifRight(
                    fluid -> {
                        buf.writeBoolean(false);
                        Solutes.STREAM_CODEC.encode(buf, fluid);
                    }
            ),
            buf -> buf.readBoolean()
                    ? Either.left(SoluteKey.STREAM_CODEC.decode(buf))
                    : Either.right(Solutes.STREAM_CODEC.decode(buf))
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ChemDataIngredient> STREAM_CODEC = StreamCodec.composite(
            GENERAL_STREAM_CODEC,
            ChemDataIngredient::input,
            ChemDataIngredient::new
    );
    public boolean isMap() {
        return input.right().isPresent();
    }

    public boolean isSingular() {
        return input.left().isPresent();
    }

    public SoluteKey asSingular() {
        return input.left().orElseThrow();
    }

    public Solutes asMap() {
        return input.right().orElseThrow();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChemDataIngredient(Either<SoluteKey, Solutes> input1)) {
            return input.equals(input1);
        }
        return false;
    }

    @Contract("_ -> new")
    public static @NonNull ChemDataIngredient of(SoluteKey ing) {
        return new ChemDataIngredient(Either.left(ing));
    }

    @Contract("_ -> new")
    public static @NonNull ChemDataIngredient of(Solutes ing) {
        return new ChemDataIngredient(Either.right(ing));
    }
}
