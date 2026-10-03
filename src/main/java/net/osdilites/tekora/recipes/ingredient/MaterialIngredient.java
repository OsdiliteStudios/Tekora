package net.osdilites.tekora.recipes.ingredient;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public record MaterialIngredient(Either<Ingredient, FluidIngredient> input) {
    public static final Codec<MaterialIngredient> CODEC = Codec.either(
            Ingredient.CODEC,
            FluidIngredient.CODEC
    ).xmap(MaterialIngredient::new, MaterialIngredient::input);

    private static final StreamCodec<RegistryFriendlyByteBuf, Either<Ingredient, FluidIngredient>>
            GENERAL_STREAM_CODEC = StreamCodec.of(
            (buf, either) -> either.ifLeft(
                    ingredient -> {
                        buf.writeBoolean(true);
                        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
                    }
            ).ifRight(
                    fluid -> {
                        buf.writeBoolean(false);
                        FluidIngredient.STREAM_CODEC.encode(buf, fluid);
                    }
            ),
            buf -> buf.readBoolean()
                    ? Either.left(Ingredient.CONTENTS_STREAM_CODEC.decode(buf))
                    : Either.right(FluidIngredient.STREAM_CODEC.decode(buf))
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, MaterialIngredient> STREAM_CODEC = StreamCodec.composite(
            GENERAL_STREAM_CODEC,
            MaterialIngredient::input,
            MaterialIngredient::new
    );

    // Helper methods to easily query the machineType during reaction checks
    public boolean isFluid() {
        return input.right().isPresent();
    }

    public boolean isItem() {
        return input.left().isPresent();
    }

    public Ingredient asItem() {
        return input.left().orElseThrow();
    }

    public FluidIngredient asFluid() {
        return input.right().orElseThrow();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MaterialIngredient(Either<Ingredient, FluidIngredient> input1)) {
            return input.equals(input1);
        }
        return false;
    }

    @Contract("_ -> new")
    public static @NonNull MaterialIngredient of(Ingredient ing) {
        return new MaterialIngredient(Either.left(ing));
    }

    @Contract("_ -> new")
    public static @NonNull MaterialIngredient of(FluidIngredient ing) {
        return new MaterialIngredient(Either.right(ing));
    }
}